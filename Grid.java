import java.util.*;

public class Grid {
  private Hashtable<String, String> targetGrid;
  private Hashtable<String, Boolean> oceanGrid; 
  
  public Grid() {
    targetGrid = new Hashtable<String, String>();
    oceanGrid = new Hashtable<String, Boolean>();
    
    for (int i = 65; i < 75; i ++) {
      for (int j = 1; j <11; j++) {
    	targetGrid.put((char)(i) + Integer.toString(j), "Empty");
    	oceanGrid.put((char)(i) + Integer.toString(j), false);
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
          if (oceanGrid.get(loc).equals(true)) {
        	 System.out.println("There is already a ship in this location!"); 
        	 alreadyShip = true;
        	 break;
          }
      }
      for(int i = 0; i < ship.getLength(); i++) {
    	  if (!alreadyShip) {
    	  String loc = (char)(startRow + i) + Character.toString(startCol);
    	  oceanGrid.put(loc, true);
    	  }
      }
    }
    
    else {
        for(int i = 0; i < ship.getLength(); i++) {
        	String loc = Character.toString(startRow) + (char)(startCol + i);
            if (oceanGrid.get(loc).equals(true)) {
          	 System.out.println("There is already a ship in this location!"); 
          	 alreadyShip = true;
          	 break;
            }
        }
        for(int i = 0; i < ship.getLength(); i++) {
      	  if (!alreadyShip) {
      	  String loc = Character.toString(startRow) + (char)(startCol + i);
      	  oceanGrid.put(loc, true);
      	  }
        }
      }
  }
  
  public void markHitMissile(String location) {
	 targetGrid.put(location, "HIT");
  }
  
  public void markMissMissile(String location) {
	 targetGrid.put(location, "MISS");
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
