package com.ParkingSystem.User;

import com.ParkingSystem.ParkingSpot;

/**
 * Front end type of user to the app
 * @author KnasterDynamics
 *
 */
public class Customer implements User {

	ParkingSpot mySpot = null;
	@Override
	public String whatUAmI() {
		// TODO Auto-generated method stub
		return "Customer";
	}

	@Override
	public void setUserName(String name) {
		// TODO Auto-generated method stub
		
	}
	
	public void unRegisterParkingSpot() {
		// TODO Auto-generated method stub
		mySpot.flagAsAvailable();
		
		mySpot = null;
	}
	public void registerWithSpot(ParkingSpot ps ){
		if(mySpot == null){
			mySpot = ps;
		}
		System.out.println(this.getUserName() + " is parking at " + ps);
	}
	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return null;
	}

}
