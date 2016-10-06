package com.ParkingSystem.runnable;

import java.util.HashMap;
import java.util.Scanner;

import com.ParkingSystem.Data.Data;
import com.ParkingSystem.User.Owner;
import com.ParkingSystem.User.User;
import com.ParkingSystem.User.UserFactory;

public class ParkingCLI {
	static String cliMsg = "ParkingCLI << ";
	public static HashMap<String, Command> cmdMap = new HashMap<>();

	public static void out(String outp) {
		System.out.println(cliMsg + outp);
	}

	public static void loadCommands() {
		ParkingCmd pc = new ParkingCmd(() -> {

			UserFactory uf = new UserFactory();
			User owner = uf.getUser("Owner");
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
			Owner o_owner = (Owner) owners;
			o_owner.setUserName(userName);
			o_owner.registerNewParkingLot(parkingLotName, capacity);
			d.addUser(o_owner);
		});
		cmdMap.put("Initialize Owner", pc);

	}

	public static Command cmdProcessor(String cmd) {
		for (String k : cmdMap.keySet()) {
			if (k.toLowerCase().contains(cmd.toLowerCase())) {
				
				return cmdMap.get(k);

			}
		}
		return null;
	}

	public static Data d = new Data();
	public static void main(String... args) {
		
		loadCommands();

		out("Please enter a command");
		while(true){
		out("");
		cmdProcessor(new Scanner(System.in).nextLine()).getCommand().run();
		d.prnt();
		}
		
	}
}
