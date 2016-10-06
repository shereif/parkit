package com.ParkingSystem.runnable;

import com.ParkingSystem.Data.Data;
import com.ParkingSystem.User.User;
import com.ParkingSystem.User.UserFactory;

public class TestData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Data d = new Data();
		UserFactory uf = new UserFactory();
		for (int i = 0; i < 100000; i += 1) {
			User owner = uf.getUser("Owner");
			owner.setUserName("o"+i);
			
			
			d.addUser(owner);

		}
		//d.prnt();
		
		System.out.println("Done initializing users");
		System.out.println("looked up user successfully"+ d.lookUpUser("o786").getUserName());

	}

}
