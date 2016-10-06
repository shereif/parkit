package com.ParkingSystem.runnable;

public interface Command {
	
	
	public void createCommand(Runnable t);
	
	public Runnable getCommand();
}
