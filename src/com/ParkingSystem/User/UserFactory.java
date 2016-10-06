package com.ParkingSystem.User;

/**
 * Generate types of users
 * @author KnasterDynamics
 *
 */
public class UserFactory {
	public User getUser(String type){
		if(type.equalsIgnoreCase("Owner")){
			return new Owner();
		} else if(type.equalsIgnoreCase("Customer")){
			return new Customer();
		}
		else if(type.equalsIgnoreCase("Admin")){
			return new Admin();
		}
		return null;
	}
}
