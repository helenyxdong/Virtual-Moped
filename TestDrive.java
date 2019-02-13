package edu.nyu.cs.hd1068.assignment5;

import java.util.Scanner;

import edu.nyu.cs.hd1068.assignment5.Moped.Direction;
import edu.nyu.cs.hd1068.assignment5.Moped.Facing;

public class TestDrive {

	public static void main(String[] args) {
		System.out.println("Thanks for jumping on the moped. We're currently parked outside Dr. Rossinsky DDS's office at 10th St. and 5th Ave. May I say your teeth look very clean.");
		System.out.println("What would you like to do? At any time, say 'help' for assistance.");
		Moped myMoped = new Moped();
		Direction direction = myMoped.direction.SOUTH;
		Facing facing = myMoped.facing.FORWARD;
		Scanner in = new Scanner(System.in);
		String command = in.nextLine();
		myMoped.gas = 100;
		int[] values = {100, 10, 5};
		myMoped.mopedInAction = true;
		while (myMoped.mopedInAction) {
			int gas = values[0];
			int street = values[1];
			int avenue = values[2];
			if (myMoped.gas == 0) {
				System.out.println("You've run out of gas.");
				myMoped.mopedInAction = false;
			}
			else if (command.equalsIgnoreCase("help")) {
				System.out.println("You may enter any of the following commands to control your moped:\n"
						+ "'go left' - to drive one block left\n"
						+ "'go right' - to drive one block right\n"
						+ "'straight on' - to drive one block forward\n"
						+ "'back up' - to drive one block backward\n"
						+ "'how we doin'?' - to check how much gas is left in the tank\n"
						+ "'fill 'er up' - to fill up the gas tank\n"
						+ "'park' - to park on the sidewalk and quit the simulator\n"
						+ "'go to Petite Abeille' - to go to the Petite Abeille\n"
						+ "'help' - to see this menu again\n"
						+ "Happy Driving!");
				command = commandAgain();
			}
			else if (command.equalsIgnoreCase("go left")) {
				myMoped.driveLeft(myMoped.street, myMoped.avenue, direction, facing);
				command = commandAgain();
			}
			else if (command.equalsIgnoreCase("go right")) {
				myMoped.driveRight(street, avenue, direction, facing);
				command = commandAgain();
			}
			else if (command.equalsIgnoreCase("straight on")) {
				myMoped.driveForward(street, avenue, direction);
				command = commandAgain();
			}
			else if (command.equalsIgnoreCase("back up")) {
				myMoped.driveBackward(street, avenue, direction);
				command = commandAgain();
			}
			else if (command.equalsIgnoreCase("how we doin'?") || command.equalsIgnoreCase("how we doin?")) {
				myMoped.getGas();
				command = commandAgain();
			}
			else if (command.equalsIgnoreCase("fill 'er up") || command.equalsIgnoreCase("fill er up")) {
				myMoped.setGas(100);
				System.out.println("The gas tank is now full!");
				command = commandAgain();
			}
			else if (command.equalsIgnoreCase("park")) {
				System.out.println("You have parked your moped on the sidewalk. No more driving for you.");
				myMoped.mopedInAction = false;
			}
			else if (command.equalsIgnoreCase("go to Petite Abeille")) {
				myMoped.findHome(street, avenue);
				command = commandAgain();
			}
			else {
				System.out.println("What was that?");
				command = in.nextLine();
			}
		}
	}
	
	public static String commandAgain() {
		System.out.println("What would you like to do? ");
		Scanner in = new Scanner(System.in);
		String command = in.nextLine();
		return command;
	}

}
