package com.ParkingSystem;

import com.ParkingSystem.User.User;

/**
 * Defines what it means to park, capabilities to park
 * @author KnasterDynamics
 *
 */
public interface Parking {
	public void startParking(float time);
	public void endParking(float time);
	public void registerParking(User u);
	public void flagAsNotAvailable();
	public void flagAsAvailable();
	public boolean isAvailable();
	
}
