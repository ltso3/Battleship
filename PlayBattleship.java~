import java.util.*;

public class PlayBattleship {
	private Grid pGrid;
	private Grid cGrid;
	private String pName;
	private String cName;
	
	public PlayBattleship(String pName, String cName) {
		// Initialize instance variables
		pGrid = new Grid();
		cGrid = new Grid();
		this.pName = pName;
		this.cName = cName;
	}
	
	/**
	 * Fires missile, marks player one's targetGrid and the other player two's oceanGrid
	 * @param loc String denoting location to fire at
	 * @param grid1 Grid object for one player
	 * @param grid2 Grid object for second player
	 */
	private void fireMissile(String loc, Grid grid1, Grid grid2) {
		grid2.markOceanGrid(loc);
		grid1.markTargetGrid(loc);
	}
	
	/**
	 * Simulates one turn for the player, firing a missile and informing them if a ship has been sunk
	 * @param loc String denoting location to fire missile at
	 */
	private void playerTurn(String loc) {
		fireMissile(loc, pGrid, cGrid);
		if (isSunk(cGrid, loc))
			System.out.println(pName + " has sunk one of" + cName + "'s ships");
	}
	
	/**
	 * Simulates one turn for the computer, firing a missile and informing them if a ship has been sunk
	 */
	private void computerTurn() { // Can make this the easy level later and hard will have more focused targeting
		
		// Generate a random location for the computer to shoot at
		String loc;
		Random rand = new Random(); 
		int let = rand.nextInt(74) + 65;
		int num = rand.nextInt(10) + 1;
		loc = (char)(let) + Integer.toString(num);
		
		// Make sure the location can be shot at before firing missile
		while (cGrid.alreadyShotMissile(loc)) {
			let = rand.nextInt(74) + 65;
			num = rand.nextInt(10) + 1;
		}
		
		fireMissile(loc, cGrid, pGrid);

		if (isSunk(pGrid, loc))
			System.out.println(cName + " has sunk one of" + pName + "'s ships");
	}
	
	/**
	 * Helper method to help determine whether a ship has been sunk at the end of a turn
	 * @param grid Grid which to check ships on
	 * @param loc String denoting location where missile was shot
	 * @return true if the ship at location has been sunk, false otherwise
	 */
	private boolean isSunk(Grid grid, String loc) {
		boolean sunk = true;
		Ship hitShip = grid.shipAtLocation(loc);
		int hitShipIndex = grid.indexOfShip(hitShip);
		for (int i = 0; i < grid.getShips().get(hitShipIndex).size(); i++)
			if (!grid.getShips().get(hitShipIndex).get(i).equals("HIT")) { 
				sunk = false;
				i = grid.getShips().get(hitShipIndex).size(); // If any location on the ship has not been hit, the ship is not sunk so we can early exit loop
			}
		return sunk;
	}
	
	/**
	 * Helper method determining whether a player has sunk all ships and won the game
	 * @param grid Grid of opponent
	 * @return true if all ships in opponent's grid are sunk, false otherwise
	 */
	private boolean allSunk(Grid grid) {
		boolean won = true;
		Vector<LinkedList<String>> ships = grid.getShips();
		for (LinkedList<String> shipLocs: ships)
			if (!isSunk(grid, shipLocs.get(0)))
					won = false;
		return won;
	}
}
