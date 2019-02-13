package edu.nyu.cs.hd1068.assignment5;

/**
 * Model of a moped.
 * @author Helen Dong
 * @version 1.0
 */

public class Moped {
	
	// properties of a moped
	
	/**
	 * If the moped is in working order and the engine is on.
	 */
	protected boolean mopedInAction = false;
	
	/**
	 * A set of related constants that indicate the direction in which the moped is facing.
	 */
	public static enum Direction {
		NORTH,
		SOUTH,
		EAST,
		WEST,
	}
	
	/**
	 * The direction this moped is facing.
	 */
	protected Direction direction = Moped.Direction.SOUTH;
	
	/**
	 * A set of constants that indicate whether the car is driving forward or in reverse.
	 */
	public static enum Facing {
		FORWARD,
		REVERSE,
	}
	
	/**
	 * Whether the car is driving forward or in reverse.
	 */
	protected Facing facing = Moped.Facing.FORWARD;
	
	/**
	 * The amount of gas left in the moped.
	 */
	protected int gas = 100;
	
	/**
	 * The street that the moped is on.
	 */
	protected int street = 10;
	
	/**
	 * The avenue that the moped is on.
	 */
	protected int avenue = 5;
	
	// behaviors of a moped
	
	/**
	 * Set the amount of gas in the tank.
	 */
	protected void setGas(int newGas) {
		if (this.mopedInAction && newGas <= 100 && newGas >= 0) {
			this.gas = newGas;
		}
	}
	
	/**
	 * Get the amount of gas in the tank.
	 */
	protected void getGas() {
		System.out.println("The gas tank is currently " + this.gas + "% full.");
	}
	
	/**
	 * Decrease amount of gas by 5.
	 */
	private void decreaseGas() {
		this.setGas(gas - 5);
	}
	
	/**
	 * Drive one block forward.
	 */
	protected void driveForward(int street, int avenue, Direction direction) {
		if (this.direction == Moped.Direction.NORTH) {
			this.street += 1;
			this.street = checkSt(this.street, true);
		}
		if (this.direction == Moped.Direction.SOUTH) {
			this.street -= 1;
			this.street = checkSt(this.street, false);
		}
		if (this.direction == Moped.Direction.WEST) {
			this.avenue += 1;
			this.avenue = checkAve(this.avenue, true);
		}
		if (this.direction == Moped.Direction.EAST) {
			this.avenue -= 1;
			this.avenue = checkAve(this.avenue, false);
		}
		this.gas -= 5;
		streetAndAvenue(this.street, this.avenue, this.direction);
	}
	
	/**
	 * Drive one block backward.
	 */
	protected void driveBackward(int street, int avenue, Direction direction) {
		if (this.direction == Moped.Direction.NORTH) {
			this.street -= 1;
			this.street = checkSt(this.street, false);
		}
		if (this.direction == Moped.Direction.SOUTH) {
			this.street += 1;
			this.street = checkSt(this.street, true);
		}
		if (this.direction == Moped.Direction.WEST) {
			this.avenue -= 1;
			this.avenue = checkAve(this.avenue, false);
		}
		if (this.direction == Moped.Direction.EAST) {
			this.avenue += 1;
			this.avenue = checkAve(this.avenue, true);
		}
		this.gas -= 5;
		streetAndAvenue(this.street, this.avenue, this.direction);
	}
	
	/**
	 * Drive one block left.
	 */
	protected void driveLeft(int street, int avenue, Direction direction, Facing facing) {
		if (this.facing == Moped.Facing.FORWARD) {
			if (this.direction == Moped.Direction.NORTH) {
				this.avenue += 1;
				this.avenue = checkAve(this.avenue, true);
				if (!check(this.avenue, this.street))
					this.direction = Moped.Direction.WEST;
			}
			else if (this.direction == Moped.Direction.SOUTH) {
				this.avenue -= 1;
				this.avenue = checkAve(this.avenue, false);
				if (!check(this.avenue, this.street))
					this.direction = Moped.Direction.EAST;
			}
			else if (this.direction == Moped.Direction.WEST) {
				this.street -= 1;
				this.street = checkSt(this.street, false);
				if (!check(this.avenue, this.street))
					this.direction = Moped.Direction.SOUTH;
			}
			else if (this.direction == Moped.Direction.EAST) {
				this.street += 1;
				this.street = checkSt(this.street, true);
				if (!check(this.avenue, this.street))
					this.direction = Moped.Direction.NORTH;
			}
		}
		else {
			if (this.direction == Moped.Direction.NORTH) {
				this.avenue -= 1;
				this.avenue = checkAve(this.avenue, false);
				if (!check(this.avenue, this.street))
					this.direction = Moped.Direction.EAST;
			}
			else if (this.direction == Moped.Direction.SOUTH) {
				this.avenue += 1;
				this.avenue = checkAve(this.avenue, true);
				if (!check(this.avenue, this.street))
					this.direction = Moped.Direction.WEST;
			}
			else if (this.direction == Moped.Direction.WEST) {
				this.street += 1;
				this.street = checkSt(this.street, true);
				if (!check(this.avenue, this.street))
					this.direction = Moped.Direction.NORTH;
			}
			else if (this.direction == Moped.Direction.EAST) {
				this.street -= 1;
				this.street = checkSt(this.street, false);
				if (!check(this.avenue, this.street))
					this.direction = Moped.Direction.SOUTH;
			}
		}
		this.gas -= 5;
		streetAndAvenue(this.street, this.avenue, this.direction);
	}
	
	/**
	 * Drive one block right.
	 * @return 
	 */
	protected void driveRight(int street, int avenue, Direction direction, Facing facing) {
		if (this.facing == Moped.Facing.FORWARD) {
			if (this.direction == Moped.Direction.NORTH) {
				this.avenue -= 1;
				this.avenue = checkAve(this.avenue, false);
				if (!check(this.avenue, this.street))
					this.direction = Moped.Direction.EAST;
			}
			else if (this.direction == Moped.Direction.SOUTH) {
				this.avenue += 1;
				this.avenue = checkAve(this.avenue, false);
				if (!check(this.avenue, this.street))
					this.direction = Moped.Direction.WEST;
			}
			else if (this.direction == Moped.Direction.WEST) {
				this.street += 1;
				this.street = checkSt(this.street, true);
				if (!check(this.avenue, this.street))
					this.direction = Moped.Direction.NORTH;
			}
			else if (this.direction == Moped.Direction.EAST) {
				this.street -= 1;
				this.street = checkSt(this.street, false);
				if (!check(this.avenue, this.street))
					this.direction = Moped.Direction.SOUTH;
			}
		}
		else {
			if (this.direction == Moped.Direction.NORTH) {
				this.avenue += 1;
				this.avenue = checkAve(this.avenue, true);
				if (!check(this.avenue, this.street))
					this.direction = Moped.Direction.WEST;
			}
			else if (this.direction == Moped.Direction.SOUTH) {
				this.avenue -= 1;
				this.avenue = checkAve(this.avenue, false);
				if (!check(this.avenue, this.street))
					this.direction = Moped.Direction.EAST;
			}
			else if (this.direction == Moped.Direction.WEST) {
				this.street -= 1;
				this.street = checkSt(this.street, false);
				if (!check(this.avenue, this.street))
					this.direction = Moped.Direction.SOUTH;
			}
			else if (this.direction == Moped.Direction.EAST) {
				this.street += 1;
				this.street = checkSt(this.street, true);
				if (!check(this.avenue, this.street))
					this.direction = Moped.Direction.NORTH;
			}
		}
		this.gas -= 5;
		streetAndAvenue(this.street, this.avenue, this.direction);
	}

	
	/**
	 * Find "home" (the Petite Abeille) at 17th St and 6th Ave.
	 */
	protected void findHome(int street, int avenue) {
		while (this.street != 17) {
			if (this.street <= 16) {
				this.direction = Moped.Direction.NORTH;
				this.driveForward(this.street, this.avenue, Moped.Direction.NORTH);
			}
			else if (this.street >= 18) {
				this.direction = Moped.Direction.SOUTH;
				this.driveForward(this.street, this.avenue, Moped.Direction.SOUTH);
			}
		}
		boolean pool = true;
		while (pool) {
			if (this.avenue == 6) {
				System.out.println("We have reached the Petite Abeille. Enjoy your moules-frites.");
				pool = false;
			}
			if (this.avenue < 6) {
				this.direction = Moped.Direction.WEST;
				this.driveForward(this.street, this.avenue, this.direction);
			}
			else if (this.avenue > 6) {
				this.direction = Moped.Direction.EAST;
				this.driveForward(this.street, this.avenue, this.direction);
			}
		}
	}	
	
	private boolean check(int avenue, int street) {
		boolean check = false;
		if (avenue > 10 || avenue < 0 || street > 200 || street < 0) {
			System.out.println("Sorry! You cannot perform this command.");
			check = true;
			return check;
		}
		else {
			return check;
		}
	}
	
	private int checkAve(int avenue, boolean increase) {
		if (check(avenue, 20)) {
			if (increase) 
				avenue -= 1;
			else
				avenue += 1;
		}
		return avenue;
	}
	
	private int checkSt(int street, boolean increase) {
		if (check(5, street)) {
			if (increase)
				street -= 1;
			else
				street += 1;
		}
		return street;
	}
	
	private void streetAndAvenue(int street, int avenue, Direction direction) {
		String[] endings = {"st", "nd", "rd", "th"};
		int stNum = street % 10;
		int aveNum = avenue % 10;
		if (stNum > 3 || stNum < 1)
			stNum = 4;
		if (aveNum > 3 || aveNum < 1) 
			aveNum = 4;
		stNum -= 1;
		aveNum -= 1;
		String dir = " ";
		if (direction == Moped.Direction.SOUTH)
			dir = "South";
		else if (direction == Moped.Direction.NORTH)
			dir = "North";
		else if (direction == Moped.Direction.WEST)
			dir = "West";
		else if (direction == Moped.Direction.EAST)
			dir = "East";
		System.out.printf("Now at %d%s St. and %d%s Ave, facing %s.\n", street, endings[stNum], avenue, endings[aveNum], dir);
		if (street == 79 && avenue == 8) 
			System.out.println("The American Museum of Natural History occupies more than 186,000 square meters and is one of the largest museums in the world!");
		if (street == 74 && avenue == 1) 
			System.out.println("Memorial Sloan Kettering was founded in 1884 as New York Cancer Hospital on Manhattan's Upper West Side.");
		if (street == 12 && avenue == 4)
			System.out.println("The Strand has 18 miles of new, used and rare books and has been in business since 1927.");
		if (street == 3 && avenue == 6) 
			System.out.println("Fay Da Bakery is a small family owned bakery selling cultural fusion buns and pastries.");
	}
}