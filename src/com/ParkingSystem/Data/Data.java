package com.ParkingSystem.Data;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.ParkingSystem.User.User;

public class Data {

	static public Object[][] userData = new Object[10][2];
	static private int userCount = 0;
	static Queue<User> newUsers = new LinkedList<>();

	static boolean newUsersBeingAdded = false;

	Stack<User> reapCandidates = new Stack<>();
	
	ConsumableMutex cM = new ConsumableMutex(false);
	public void addNewUserToQueue(User u) {
		cM.lock();

		newUsers.add(u);
		reapCandidates.add(u);
	}

	public synchronized void reapMultipleUsers() {

		while (true) {
			
			while (cM.isLocked()) {
				if (!reapCandidates.isEmpty()) {
					cM.consume();
					User u = reapCandidates.pop();
					newUsers.removeIf(user -> user.getUserName().equals(u));
					System.out.println("Reaped a duplicated registerd users");
					
					break;
					
				}
			}
		}
	}
	//
	// public synchronized void addUser(User u) {
	//
	// if (userCount <= userData.length - 1) {
	//
	// userData[userCount][0] = u.getUserName();
	// userData[userCount][1] = u;
	// userCount++;
	//
	// } else {
	// Object[][] temp = new Object[(int) (userData.length * 1.5)][2];
	//
	// System.arraycopy(userData, 0, temp, 0, userData.length);
	// userData = temp;
	//
	// userData[userCount][0] = u.getUserName();
	// userData[userCount][1] = u;
	// userCount++;
	//
	// }
	//
	// }

	public synchronized void loadQueueToDB() {
		while (newUsers.peek() != null) {

			User u = newUsers.poll();
			if (userCount <= userData.length - 1) {

				userData[userCount][0] = u.getUserName();
				userData[userCount][1] = u;
				userCount++;

			} else {
				Object[][] temp = new Object[(int) (userData.length * 1.5)][2];

				System.arraycopy(userData, 0, temp, 0, userData.length);
				userData = temp;

				userData[userCount][0] = u.getUserName();
				userData[userCount][1] = u;
				userCount++;

			}
		}

	}

	public void prnt() {
		for (int i = 0; i < userData.length; i++) {
			System.out.println(userData[i][0]);
		}
	}

	private class UserHolder {
		User value;

		public UserHolder(User u) {
			this.value = u;
		}

		public void setValue(User u) {
			this.value = u;
		}

		public User getValue() {
			return this.value;
		}
	}

	private class Mutex {
		Boolean value;

		public Mutex(boolean u) {
			this.value = u;
		}

		public void lock() {
			this.value = true;
		}

		public boolean isLocked() {
			return this.value;
		}
	}
	
	private class ConsumableMutex {
		Boolean value;

		public ConsumableMutex(boolean u) {
			this.value = u;
		}

		public void lock() {
			this.value = true;
		}
		public boolean isLocked() {
			return this.value;
		}
		public void consume(){
			if(this.value){
				this.value = false;
			}
		}
	}

	public User lookUpUser(String userName) {
		UserHolder uh = new UserHolder(null);
		Mutex mutex = new Mutex(false);

		Thread t = new Thread(() -> {
			int size = userData.length / 2;
			for (int i = 0; i < size; i++) {
				if (mutex.isLocked() == false && i < userCount) {
					if (userData[i][0].equals(userName)) {
						uh.setValue((User) userData[i][1]);
						mutex.lock();

						break;
					}
				} else {
					break;
				}
			}

		});
		Thread t2 = new Thread(() -> {
			int size = userData.length / 2;

			for (int i = size; i < userData.length - 1; i++) {
				if (mutex.isLocked() == false && i < userCount) {

					if (userData[i][0].equals(userName)) {
						uh.setValue((User) userData[i][1]);
						mutex.lock();
						break;
					}
				} else {
					break;
				}
			}

		});
		t.start();
		t2.start();
		while (t.isAlive() || t2.isAlive()) {

		}
		return uh.getValue();

	}

	public int getDBSIZE() {
		// TODO Auto-generated method stub
		return userCount;
	}

	public void startReaperThread() {
		Runnable r = new Runnable() {

			@Override
			public void run() {
				reapMultipleUsers();

			}
		};
		Thread t = new Thread(r);
		t.start();

	}

}
