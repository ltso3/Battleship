import java.util.*;

public class Grid {
  
  //Initialize private instance variables
  private Hashtable<String, String> targetGrid;
  private Hashtable<String, String> oceanGrid; 
  private String[] shipTypes;
  private Vector<LinkedList<String>> shipLocs;
  private static final int NUM_SHIPS = 5;
  
  public Grid() {
    // Assign private instance variables
    targetGrid = new Hashtable<String, String>();
    oceanGrid = new Hashtable<String, String>();
    shipTypes = new String[NUM_SHIPS];
    shipLocs = new Vector<LinkedList<String>>();
    
    // Fill each ship location with empty lists
    for (int i = 0; i < NUM_SHIPS; i++)
      shipLocs.add(new LinkedList<String>());
    
    // Fill grid with empty coordinates
    for (int i = 65; i < 75; i ++) {
      for (int j = 1; j <11; j++) {
        targetGrid.put((char)(i) + Integer.toString(j), "Empty");
        oceanGrid.put((char)(i) + Integer.toString(j), "Empty");
      }
    }
    
    // Fill array with the names of each ship type
    shipTypes[0] = "Destroyer";
    shipTypes[1] = "Submarine";
    shipTypes[2] = "Cruiser";
    shipTypes[3] = "Battleship";
    shipTypes[4] = "Carrier";
  }
  
  /* 
   * Places ship on player's oceanGrid based on start coordinate and orientation
   * @param ship to be placed 
   */
  public void addShip(Ship ship) {
    
    // Error message if ship is placed out of the grid's bounds
    if (!isValidStart(ship)) {
      throw new IllegalArgumentException("Ship not in bounds of the board. Please check ship positions.");
    }
    
    // Fills oceanGrid with ship values to indicate a ship present 
    for (String loc : spannedSpaces(ship)) {
      oceanGrid.put(loc, ship.getName());
      shipLocs.get(indexOfShip(ship.getName())).add(loc);
    }
    
    // System.out.println(Arrays.toString(shipTypes));
    // System.out.println(shipLocs);
  }
  
  /* 
   * Marks location on targetGrid with corresponding message
   * @param location String denoting location to hit 
   */
  public void markTargetGrid(String location) {
    if (oceanGrid.get(location).equals("Empty")) 
      targetGrid.put(location, "MISS");
    else 
      targetGrid.put(location, "HIT");
  }
  
  /**
   * Makes places on the oceanGrid with corresponding message
   * @param location String denoting location to hit
   */
  public void markOceanGrid(String loc){
    if (hasShip(loc))
        oceanGrid.put(loc, "HIT");
    else
    	oceanGrid.put(loc, "MISS");
  }
  
  /**
   * Getter method for targetGrid
   * @return Hashtable<String, String> targetGrid
   */
  public Hashtable<String, String> getTargetGrid() {
    return targetGrid;
  }
  
  /**
   * Getter method for oceanGrid
   * @return Hashtable<String, String> oceanGrid
   */
  public Hashtable<String, String> getOceanGrid() {
    return oceanGrid;
  }
  
  /**
   * 
   * Getter method for ship locations
   * @return Vector<LinkedList<String>> shipLocs
   */
  public Vector<LinkedList<String>> getShipLocs() {
    return shipLocs;
  }
  
  /**
   * Getter method for shipTypes
   * @return Vector<Ship> shipLocs
   */
  public String[] getShipTypes() {
    return shipTypes;
  }
  
  /**
   * Returns the index of a given Ship name
   * @param String name which user wants the index of
   * @return int index of ship in shipTypes
   */
  public int indexOfShip(String name) {
    // Traverses through shipTypes to find index of given name
    for(int i = 0; i < NUM_SHIPS; i++) {
      if(shipTypes[i].equals(name)) {
        return i;
      }
    }
    return -1; // return -1 if name not found
  }
  
  public boolean hasShip(String loc) {
    return oceanGrid.get(loc).equals("HIT") || oceanGrid.get(loc).equals("Carrier") || oceanGrid.get(loc).equals("Battleship") 
    		|| oceanGrid.get(loc).equals("Destroyer") || oceanGrid.get(loc).equals("Submarine") || oceanGrid.get(loc).equals("Cruiser");
  }
  
  /*
   * Returns all locations a potential ship would occupy
   * @param Ship ship to be placed
   * @return Vector<String> of locations
   * 
   * */
  public Vector<String> spannedSpaces(Ship ship) {
    Vector<String> spans = new Vector<String>(); // Vector to hold string locations of a potential ship
    
    // Start coordinate broken down into row and column
    char column = ship.getStartCoord().charAt(0);
    String row = ship.getStartCoord().substring(1);
    
    // Traverses through columns if orientation is horizontal
    if (ship.getOrientation().equals("Horizontal")) {
      for (int i = 0; i < ship.getLength(); i++) {
        char columnLoc = (char) ((int) column + i);
        spans.add(Character.toString(columnLoc) + row);
      }
    } 
    // Traverses through rows if orientation is vertical
    else if (ship.getOrientation().equals("Vertical")) {
      for (int j = 0; j < ship.getLength(); j++) {
        int rowLoc = Integer.parseInt(row) + j;
        spans.add(Character.toString(column) + Integer.toString(rowLoc));
      }
    }
    return spans; 
  }
  
  /*
   * Check if location to be fired upon is within the grid and not previously fired upon
   * @return true if yes, false otherwise
   * */
  public boolean isOpenSpot(String loc) {
    return oceanGrid.containsKey(loc) && targetGrid.get(loc).equals("Empty");
  }
  
  /*
   * Check if ship can be placed within grid without overlap
   * @param Ship ship to be placed
   * @return true if start coordinate is valid, false otherwise
   * 
   * */
  public boolean isValidStart(Ship ship) {
    for(String loc : spannedSpaces(ship)) {
      if(!oceanGrid.containsKey(loc) || !oceanGrid.get(loc).equals("Empty")) {
        return false;
      }
    }
    return true;
  }
    
  
  /**
   * Determines whether a ship has been sunk at the end of a turn
   * @param grid Grid which to check ships on
   * @param loc String denoting location where missile was shot
   * @return true if the ship at location has been sunk, false otherwise
   */
  /*  private boolean isSunk(Grid grid, String loc) {
   boolean sunk = true;
   String hitShip = grid.getShipLocs().get(loc);
   int hitShipIndex = grid.indexOfShip(hitShip);
   for (int i = 0; i < grid.getShipLocs().get(hitShipIndex).size(); i++) {
   String locKey = (grid.getShipLocs().get(hitShipIndex).get(i));
   if (!grid.getOceanGrid().get(locKey).equals("HIT")) { 
   sunk = false;
   i = grid.getShipLocs().get(hitShipIndex).size(); // If any location on the ship has not been hit, the ship is not sunk so we can early exit loop
   }
   }
   return sunk;
   }
   */
  
  /**
   * Determine whether all ships are sunk and the game is over
   * @return true if all ships are sunk, false otherwise
   */
  public boolean allSunk() {
    boolean won = true;
    for (LinkedList<String> locs: shipLocs) {
      for(String loc : locs) {
        if (!locs.isEmpty() && !oceanGrid.get(loc).equals("HIT"))
              won = false;
      }
    }
    return won;
  }
  
  public static void main(String[] args) {
    Grid grid = new Grid();
//    System.out.println("Target: " + grid.getTargetGrid());
//    System.out.println("Ocean: " + grid.getOceanGrid());
    
/*    Ship ship1 = new Ship("Destroyer", "Vertical", "C4");
    Ship ship2 = new Ship("Submarine", "Horizontal", "C3");
    Ship ship3 = new Ship("Battleship", "Vertical", "A3");
    Ship ship4 = new Ship("Cruiser", "Horizontal", "C2");
    
    grid.addShip(ship1);
    System.out.println("Checking if C4 has a ship (Destroyer): " + grid.oceanGrid.get("C4"));
    System.out.println("Checking if C5 has a ship (Destroyer): " + grid.oceanGrid.get("C5"));
    grid.markTargetGrid("C4");
    System.out.println("Checking if C4 has been hit (HIT): " + grid.targetGrid.get("C4"));
    System.out.println("Checking if A4 has been targeted (Empty): " + grid.targetGrid.get("A4"));
    
    grid.addShip(ship2);
    System.out.println("Checking if C3 has a ship (Submarine): " + grid.oceanGrid.get("C3"));
    System.out.println("Checking if D3 has a ship (Submarine): " + grid.oceanGrid.get("D3"));
    System.out.println("Checking if A5 has been hit (Empty): " + grid.targetGrid.get("A5"));
    System.out.println("Checking if A4 has been hit (Empty): " + grid.targetGrid.get("A4"));
    
    System.out.println("Target: " + grid.getTargetGrid());
    System.out.println("Ocean: " + grid.getOceanGrid());
    grid.addShip(ship3); 
    grid.addShip(ship4);
    
    System.out.println(grid.getShipLocs());
    System.out.println(grid.getShipTypes());*/
  }
}
