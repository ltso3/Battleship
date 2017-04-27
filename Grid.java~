import java.util.*;

public class Grid {
  // private Vector<LinkedList<String>> shipLocations;
  private Hashtable<String, String> gridState;
  private Hashtable<String, Boolean> locations; 
//  private Vector<Ship> ships;
  
  public Grid() {
    gridState = new Hashtable<String, String>();
    locations = new Hashtable<String, Boolean>();
//    ships = new Vector<Ship>();
    
    for (int i = 65; i < 75; i ++) {
      for (int j = 1; j <11; j++) {
        gridState.put((char)(i) + Integer.toString(j), "Empty");
        locations.put((char)(i) + Integer.toString(j), false);
      }
    }
    /*
    ships.add(new Ship("Destroyer", "vertical", "A1"));
    ships.add(new Ship("Submarine", "vertical", "A1"));
    ships.add(new Ship("Cruiser", "vertical", "A1"));
    ships.add(new Ship("Battleship", "vertical", "A1"));
    ships.add(new Ship("Carrier", "vertical", "A1"));
    */
  }
  
  public void addShip(Ship ship) {
    // Example: Cruiser (length 3) vertical from A1 to C1 
    // Example: Cruiser (length 3) horizontal from A1 to A3
    int startRow = (int) ship.getStartCoord().charAt(0);
    char startCol = ship.getStartCoord().charAt(1);
    
    if(ship.getOrientation().equals("Vertical")) {
      for(int i = 0; i < ship.getLength(); i++) {
        String loc = Integer.toString(startRow + i) + startCol;
        locations.put(loc, true); 
      }
    }
    
    else {
      for(int j = 0; j < ship.getLength(); j++) {
        String loc = startRow + Integer.toString((int) (startCol + j);
        locations.put(loc, true); 
      }
    }
  }
  
  public boolean markMissile(String location) {
    // check if shot is in bounds
    if(locations.get(location) == true) {
      gridState.put(location, "HIT");
      return true;
    }
    else {
      gridState.put(location, "MISS");
      return false;
    }
  }
  
  
  /*
  public void placeDestroyer(String hole1, String hole2) {
    shipLocations.get(0).add(0, hole1);
    shipLocations.get(0).add(1, hole2);
  }
  
  public void placeSubmarine (String hole1, String hole2, String hole3) {
    shipLocations.get(1).add(0, hole1);
    shipLocations.get(1).add(1, hole2);
    shipLocations.get(1).add(2, hole3);
  }
  
  public void placeDestoryer (String hole1, String hole2, String hole3) {
    shipLocations.get(2).add(0, hole1);
    shipLocations.get(2).add(1, hole2);
    shipLocations.get(2).add(2, hole3);
  }
  
  public void placeBattleship (String hole1, String hole2, String hole3, String hole4) {
    shipLocations.get(3).add(0, hole1);
    shipLocations.get(3).add(1, hole2);
    shipLocations.get(3).add(2, hole3);
    shipLocations.get(3).add(3, hole4);
  }
  
  public void placeCarrier (String hole1, String hole2, String hole3, String hole4, String hole5) {
    shipLocations.get(4).add(0, hole1);
    shipLocations.get(4).add(1, hole2);
    shipLocations.get(4).add(2, hole3);
    shipLocations.get(4).add(3, hole4);
    shipLocations.get(4).add(4, hole5);
  }
  */
  public static void main(String[] args) {
    Ship ship = new Ship("Destroyer", "Vertical", "C4");
    char startRow = ship.getStartCoord().charAt(0);
    char startCol = ship.getStartCoord().charAt(1);
    
    System.out.println((int) startRow);
    System.out.println(startCol);
    /*
    Grid grid = new Grid();
    System.out.println(grid.grid.toString());
    grid.markMissile("A1");
    System.out.println(grid.grid.get("A1"));
    */
    
  }
}
