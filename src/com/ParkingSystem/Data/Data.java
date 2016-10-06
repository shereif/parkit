package com.ParkingSystem.Data;

import com.ParkingSystem.User.User;

public class Data {

	public Object[][] userData = new Object[10][2];
	int userCount = 0;

	public void addUser(User u) {
		
		
		if (userCount <=userData.length-1) {
			
			userData[userCount][0] = u.getUserName();
			userData[userCount][1] = u;
			userCount++;
			
		} else {
			Object[][] temp = new Object[userData.length+25][2];
		
			System.arraycopy(userData, 0, temp, 0, userData.length);
			userData = temp;
			
			userData[userCount][0] = u.getUserName();
			userData[userCount][1]= u;
			userCount++;
			
			
			
		}

	}
	public void prnt(){
		for(int i =0; i < userData.length ; i ++){
			System.out.println(userData[i][0]);
		}
	}
	public class UserHolder {
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
	public class BooleanHolder {
	    Boolean value;
	    public BooleanHolder(boolean u) {
	        this.value = u;
	    }
	    public void setValue(boolean u) {
	        this.value = u;
	    }
	    public boolean getValue() {
	        return this.value;
	    }
	}
	
	
	public User lookUpUser(String userName) {
		UserHolder uh = new UserHolder(null);
		BooleanHolder bh = new BooleanHolder(false);
		
		Thread t = new Thread(()->{
			
				for (int i = 0; i < userData.length / 2; i++) {
					if (bh.getValue() == false ){
						if(userData[i][0].equals(userName)) {
							uh.setValue((User) userData[i][1]);
							bh.setValue(true);
							
							break;
						}
					} else {
						break;
					}
				}
			
		});
		Thread t2 = new Thread(()->{
			
			for (int i =  userData.length / 2; i < userData.length; i++) {
				if (bh.getValue() == false ){
					if(userData[i][0].equals(userName)) {
						uh.setValue((User) userData[i][1]);
						bh.setValue(true);
						break;
					}
				} else {
					break;
				}
			}
			
	});
		t.start();
		t2.start();
		while(t.isAlive() || t2.isAlive()){
			
		}
		return uh.getValue();
		
		
	}

}
