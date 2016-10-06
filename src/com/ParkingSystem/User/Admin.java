package com.ParkingSystem.User;

/**
 * Admin type of user, this user will have access to change and alter service based tasks
 * @author KnasterDynamics
 *
 */
public class Admin extends Customer {

	@Override
	public String whatUAmI() {
		// TODO Auto-generated method stub
		return "Admin";
	}

	@Override
	public void setUserName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return null;
	}

}
