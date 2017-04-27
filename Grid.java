import java.util.*;

public class Grid {
  private Hashtable<String, String> targetGrid;
  private Hashtable<String, String> oceanGrid; 
  
  public Grid() {
    targetGrid = new Hashtable<String, String>();
    oceanGrid = new Hashtable<String, String>();
    
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
      for(int i = 0; i < ship.getLength(); i++) {
    	  if (!alreadyShip) {
    	  String loc = (char)(startRow + i) + Character.toString(startCol);
    	  oceanGrid.put(loc, "ship");
    	  }
      }
    }
    
    else {
        for(int i = 0; i < ship.getLength(); i++) {
        	String loc = Character.toString(startRow) + (char)(startCol + i);
            if (oceanGrid.get(loc).equals("ship")) {
          	 System.out.println("There is already a ship in this location!"); 
          	 alreadyShip = true;
          	 break;
            }
        }
        for(int i = 0; i < ship.getLength(); i++) {
      	  if (!alreadyShip) {
      	  String loc = Character.toString(startRow) + (char)(startCol + i);
      	  oceanGrid.put(loc, "ship");
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
  
  public static void main(String[] args) {
	Grid grid = new Grid();
	
    Ship ship = new Ship("Destroyer", "Vertical", "C4");
    Ship ship2 = new Ship("Submarine", "Horizontal", "C3");

    grid.addShip(ship);
    /*System.out.println("Checking if C4 has a ship: " + grid.oceanGrid.get("C4"));
    System.out.println("Checking if D4 has a ship: " + grid.oceanGrid.get("D4"));
    grid.markMissile("C4");
    grid.markMissile("A4");
    System.out.println("Checking if C4 has been hit: " + grid.targetGrid.get("C4"));
    System.out.println("Checking if A4 has been hit: " + grid.targetGrid.get("A4"));*/
    
    grid.addShip(ship2);
    System.out.println("Checking if C3 has a ship: " + grid.oceanGrid.get("C3"));
    //grid.markMissile("Z5");
    /*System.out.println("Checking if D4 has a ship: " + grid.oceanGrid.get("D4"));
    grid.markMissile("A5");
    grid.markMissile("A4");
    System.out.println("Checking if A5 has been hit: " + grid.targetGrid.get("A5"));
    System.out.println("Checking if A4 has been hit: " + grid.targetGrid.get("A4"));*/
  }
}
