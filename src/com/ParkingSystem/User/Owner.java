package com.ParkingSystem.User;

import java.util.ArrayList;
import java.util.Hashtable;

import com.ParkingSystem.ParkingLot;

public class Owner extends Customer {
	
	Hashtable<String, ParkingLot> dataTable;
	
	String userName = null;
	
	public Owner() {
		dataTable = new Hashtable<>();
		// TODO Auto-generated constructor stub
	}

	public void registerNewParkingLot(String name, int capacity){
		
		ParkingLot pl = new ParkingLot(capacity, name, this);
		dataTable.put(name, pl);
	}

	@Override
	public String whatUAmI() {
		// TODO Auto-generated method stub
		return "Owner";
	}

	@Override
	public void setUserName(String name) {
		userName = name;
	}


	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return userName;
	}

	public ArrayList<ParkingLot> getParkingLot() {
		
		ArrayList<ParkingLot> pl = new ArrayList<>();
		pl.addAll(dataTable.values());
		return pl;
	}

	
	
	
	
	
	

}
