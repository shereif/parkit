package com.ParkingSystem;

import java.util.ArrayList;

import com.ParkingSystem.User.Customer;
import com.ParkingSystem.User.Owner;
import com.ParkingSystem.User.User;

/**
 * A container for parking spots, a spot must belong to a parking lot..
 * @author KnasterDynamics
 *
 */
public class ParkingLot {
	private ArrayList<ParkingSpot> m_spots;
	private Owner my_owner;

	String m_nameOFLot;
	int parking_spot_counter = 0;

	
	/**
	 * Create a parking lot, capacity, name of lot , pass in the owner to connect it to
	 */
	public ParkingLot(int parkingSpotsToOpen, String nameOfLot, Owner o) {
		m_spots = new ArrayList<>();
		my_owner = o;
		m_nameOFLot = nameOfLot;
		System.out.println(my_owner.getUserName() + " registered " + parkingSpotsToOpen + " spots in parking lot ["
				+ nameOfLot + "].");

		for (int i = 0; i < parkingSpotsToOpen; i++) {
			m_spots.add(new ParkingSpot(parking_spot_counter, this));
			m_spots.get(i).flagAsAvailable();
			parking_spot_counter += 1;
		}

	}

	
	public void registerUserToSpot( User u){
		ParkingSpot availspot = null;
		for(ParkingSpot ps : m_spots){
			if(ps.isAvailable()){
				availspot = ps;
				break;
			}
		}
		
		Customer c = (Customer ) u;
		availspot.flagAsNotAvailable();
		availspot.registerParking(u);
		
		
		
	}
	/**
	 * Get the individual spots in the parking lot
	 * @return
	 */
	public ArrayList<ParkingSpot> getSpots() {
		return (ArrayList<ParkingSpot>) m_spots.clone();
	}

	/**
	 * This must be set by a parking lot, 
	 * @return
	 */
	public String getName() {
		return m_nameOFLot;
	}
}
