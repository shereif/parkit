package com.ParkingSystem;

import com.ParkingSystem.User.Customer;
import com.ParkingSystem.User.User;

/**
 * A spot must be registerd to a parking lot..
 * @author KnasterDynamics
 *
 */
public class ParkingSpot implements Parking	{
	boolean m_can_park;
	int idx = 0;
	ParkingLot m_parent;
	Customer m_user  = null;
	public ParkingSpot(int i, ParkingLot parent) {
		// TODO Auto-generated constructor stub
		idx = i;
		m_parent = parent;
	}
	@Override
	public void startParking(float time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endParking(float time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerParking(User u) {
		m_user = (Customer)u;
		m_user.registerWithSpot(this);
		
	}

	@Override
	public void flagAsNotAvailable() {
		// TODO Auto-generated method stub
		m_can_park = false;
	}

	@Override
	public void flagAsAvailable() {
		// TODO Auto-generated method stub
		m_can_park = true;
	}

	public String toString(){
		return "Spot " + (idx+1)+ " of " + m_parent.getName() + " is " +( m_can_park ? "Available": "Not Available");
	}
	@Override
	public boolean isAvailable() {
		// TODO Auto-generated method stub
		return m_can_park;
	}

}
