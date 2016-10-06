package com.ParkingSystem.runnable;

import java.util.Scanner;

import com.ParkingSystem.ParkingLot;
import com.ParkingSystem.ParkingSpot;
import com.ParkingSystem.User.Owner;
import com.ParkingSystem.User.User;
import com.ParkingSystem.User.UserFactory;

public class Core {
	
	public static void main(String []args){
		
		
		
		
		
		
		
		//Test user fatory
		UserFactory uf = new UserFactory();
		User admin = uf.getUser("Admin");
		User customer = uf.getUser("Customer");
		User owner = uf.getUser("Owner");
		
		System.out.println(admin.whatUAmI());
		System.out.println(owner.whatUAmI());
		System.out.println(customer.whatUAmI());
		
		{
			System.out.println("Enter a username");
			Scanner s = new Scanner(System.in);
			String parkingLotName;
			String userName = null;
			int capacity = 0;
			
			userName = s.nextLine();
	
			System.out.println("Enter a parking lot name");
			parkingLotName = s.nextLine();
			System.out.println("Enter a capacity for " + parkingLotName);
			capacity = Integer.parseInt(s.nextLine());
			User owners = uf.getUser("Owner");
			Owner o_owner = (Owner)owners;
			o_owner.setUserName(userName);
			o_owner.registerNewParkingLot(parkingLotName, capacity);
		
		
			for(ParkingLot pl: o_owner.getParkingLot()){
				for(ParkingSpot ps : pl.getSpots()){
					System.out.println(ps);
			
				}
			}
			o_owner.getParkingLot().get(0).registerUserToSpot(o_owner);
			for(ParkingLot pl: o_owner.getParkingLot()){
				for(ParkingSpot ps : pl.getSpots()){
					System.out.println(ps);
			
				}
			}
			
			o_owner.unRegisterParkingSpot();
			
			for(ParkingLot pl: o_owner.getParkingLot()){
				for(ParkingSpot ps : pl.getSpots()){
					System.out.println(ps);
			
				}
			}
			
			
			
		}
		
	}
}
