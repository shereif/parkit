package com.ParkingSystem.runnable;

public class ParkingCmd implements Command{
	public Runnable task = null;
	public ParkingCmd(Runnable a) {
		createCommand(a);
	}
	@Override
	public void createCommand(Runnable t) {
		// TODO Auto-generated method stub
		task = t;
	}

	@Override
	public Runnable getCommand() {
		// TODO Auto-generated method stub
		return task;
	}

}
