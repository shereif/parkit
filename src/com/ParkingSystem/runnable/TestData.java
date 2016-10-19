package com.ParkingSystem.runnable;

import com.ParkingSystem.Data.Data;
import com.ParkingSystem.User.User;
import com.ParkingSystem.User.UserFactory;

public class TestData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Data d = new Data();
		d.startReaperThread();
		UserFactory uf = new UserFactory();
		for (int i = 0; i < 100; i += 1) {
			User owner = uf.getUser("Owner");
			owner.setUserName("o"+i);
			
			
			d.addNewUserToQueue(owner);

		}
		for (int i = 0; i < 100; i += 1) {
			User owner = uf.getUser("Owner");
			owner.setUserName("o"+i);
			
			
			d.addNewUserToQueue(owner);

		}
		
		
		System.out.println("Loading DB with recent queues");
		
		
		d.loadQueueToDB();
		
		//d.prnt();
		System.out.println("Done initializing users");
		
		System.out.println("Done sleeping, looking up initiated");
	
		for (int i = 0; i < d.getDBSIZE()/2; i += 1) {
			System.out.println("Looked up " + "o"+ i+ " " +d.lookUpUser("o"+i).getUserName());
		}
		
		
	
		
	}

}
