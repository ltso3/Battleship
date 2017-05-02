import java.util.*;

public class Grid {
  private Hashtable<String, String> targetGrid;
  private Hashtable<String, String> oceanGrid; 
  private Vector<LinkedList<String>> ships;
  private static final int NUM_SHIPS = 5;
  
  public Grid() {
    targetGrid = new Hashtable<String, String>();
    oceanGrid = new Hashtable<String, String>();
    ships = new Vector<LinkedList<String>>();
    
    for (int i = 0; i < NUM_SHIPS; i++) // Fill ships with empty lists
    	ships.add(new LinkedList<String>());
    
    for (int i = 65; i < 75; i ++) {
      for (int j = 1; j <11; j++) {
    	targetGrid.put((char)(i) + Integer.toString(j), "Empty");
    	oceanGrid.put((char)(i) + Integer.toString(j), "Empty");
      }
    }
  }
  
  public void addShip(Ship ship) {
    // Example: Cruiser (length 3) vertical from A1 to C1 
    // Example: Cruiser (length 3) horizontal from A1 to A3
    char startRow = ship.getStartCoord().charAt(0);
    char startCol = ship.getStartCoord().charAt(1);
    boolean alreadyShip = false;
    
    if(ship.getOrientation().equals("Vertical")) {
      // First for loop to ensure that ship does not already exist in locations
      for(int i = 0; i < ship.getLength(); i++) {
    	  String loc = (char)(startRow + i) + Character.toString(startCol);
          if (oceanGrid.get(loc).equals("ship")) {
        	 System.out.println("There is already a ship in this location!"); 
        	 alreadyShip = true;
        	 break;
          }
      }
      // Places ship in each space it fills
      for (int j = 0; j < ships.size(); j++) {
		  if (ships.get(j).isEmpty()) {
		      for(int i = 0; i < ship.getLength(); i++) {
		    	  if (!alreadyShip) {
			    	  String loc = (char)(startRow + i) + Character.toString(startCol);
			    	  oceanGrid.put(loc, "ship");
			    	  ships.get(j).add(loc);
		    	  }
		      }
		      j = ships.size();
		  } 
      }
    }

    else {
    	// First for loop to ensure that ship does not already exist in locations
        for(int i = 0; i < ship.getLength(); i++) {
        	String loc = Character.toString(startRow) + (char)(startCol + i);
            if (oceanGrid.get(loc).equals("ship")) {
          	 System.out.println("There is already a ship in this location!"); 
          	 alreadyShip = true;
          	 break;
            }
        }
        for (int j = 0; j < ships.size(); j++) {
  		  if (ships.get(j).isEmpty()) {
  		      for(int i = 0; i < ship.getLength(); i++) {
  		    	  if (!alreadyShip) {
  		    		String loc = Character.toString(startRow) + (char)(startCol + i);
  			    	  oceanGrid.put(loc, "ship");
  			    	  ships.get(j).add(loc);
  		    	  }
  		      }
  		      j = ships.size();
  		  } 
        }
      }
  }
  
  // Marking places the player has hit
  public void markTargetGrid(String location) {
	  if (!oceanGrid.get(location).equals("ship"))
		  targetGrid.put(location, "MISS");
	  else
		  targetGrid.put(location, "HIT");
  }
  
  // Marking places the player has been hit
  public void markOceanGrid(String location){
	  if (!oceanGrid.get(location).equals("ship"))
		  oceanGrid.put(location, "MISS");
	  else
		  oceanGrid.put(location, "HIT");
  }
  
  public Hashtable<String, String> getTargetGrid() {
	  return targetGrid;
  }
  
  public Hashtable<String, String> getOceanGrid() {
	  return oceanGrid;
  }
  
  public Vector<LinkedList<String>> getShips() {
	  return ships;
  }
  
  public static void main(String[] args) {
	Grid grid = new Grid();
	
    Ship ship = new Ship("Destroyer", "Vertical", "C4");
    Ship ship2 = new Ship("Submarine", "Horizontal", "C3");
    Ship ship3 = new Ship("Battleship", "Vertical", "C3");
    Ship ship4 = new Ship("Cruiser", "Horizantal", "C2");

    grid.addShip(ship);
    System.out.println("Checking if C4 has a ship (ship): " + grid.oceanGrid.get("C4"));
    System.out.println("Checking if D4 has a ship (ship): " + grid.oceanGrid.get("D4"));
    grid.markOceanGrid("C4");
    System.out.println("Checking if C4 has been hit (HIT): " + grid.oceanGrid.get("C4"));
    System.out.println("Checking if A4 has been targeted (Empty): " + grid.targetGrid.get("A4"));
    
    grid.addShip(ship2);
    System.out.println("Checking if C3 has a ship (ship): " + grid.oceanGrid.get("C3"));
    System.out.println("Checking if D4 has a ship (ship): " + grid.oceanGrid.get("D4"));
    System.out.println("Checking if A5 has been hit (Empty): " + grid.targetGrid.get("A5"));
    System.out.println("Checking if A4 has been hit (Empty): " + grid.targetGrid.get("A4"));
    
    grid.addShip(ship3);
    grid.addShip(ship4);
    
    System.out.println(grid.getShips());
  }
}
