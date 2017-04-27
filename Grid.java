// Need to account for ships which overlap

import java.util.*;

public class Grid {
  private Hashtable<String, String> gridState;
  private Hashtable<String, Boolean> locations; 
  
  public Grid() {
    gridState = new Hashtable<String, String>();
    locations = new Hashtable<String, Boolean>();
    
    for (int i = 65; i < 75; i ++) {
      for (int j = 1; j <11; j++) {
        gridState.put((char)(i) + Integer.toString(j), "Empty");
        locations.put((char)(i) + Integer.toString(j), false);
      }
    }
  }
  
  public void addShip(Ship ship) {
    // Example: Cruiser (length 3) vertical from A1 to C1 
    // Example: Cruiser (length 3) horizontal from A1 to A3
    char startRow = ship.getStartCoord().charAt(0);
    char startCol = ship.getStartCoord().charAt(1);
    
    if(ship.getOrientation().equals("Vertical")) {
      for(int i = 0; i < ship.getLength(); i++) {
        String loc = (char)(startRow + i) + Character.toString(startCol);
        locations.put(loc, true); 
      }
    }
    
    else {
      for(int j = 0; j < ship.getLength(); j++) {
        String loc = Character.toString(startRow) + (char)(startCol + j);
        locations.put(loc, true); 
      }
    }
  }
  
  public boolean markMissile(String location) {
    // Still need method for if missile is shot at an out of bounds location
    if(locations.get(location) == true) {
      gridState.put(location, "HIT");
      return true;
    }
    else {
      gridState.put(location, "MISS");
      return false;
    }
  }
  
  public static void main(String[] args) {
	Grid grid = new Grid();
	
    Ship ship = new Ship("Destroyer", "Vertical", "C4");
    Ship ship2 = new Ship("Submarine", "Horizontal", "A5");

    /*grid.addShip(ship);
    System.out.println("Checking if C4 has a ship: " + grid.locations.get("C4"));
    System.out.println("Checking if D4 has a ship: " + grid.locations.get("D4"));
    grid.markMissile("C4");
    grid.markMissile("A4");
    System.out.println("Checking if C4 has been hit: " + grid.gridState.get("C4"));
    System.out.println("Checking if A4 has been hit: " + grid.gridState.get("A4"));*/
    
    grid.addShip(ship2);
    System.out.println("Checking if A5 has a ship: " + grid.locations.get("A5"));
    System.out.println("Checking if D4 has a ship: " + grid.locations.get("D4"));
    grid.markMissile("A5");
    grid.markMissile("A4");
    System.out.println("Checking if A5 has been hit: " + grid.gridState.get("A5"));
    System.out.println("Checking if A4 has been hit: " + grid.gridState.get("A4"));
  }
}
