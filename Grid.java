import java.util.*;

public class Grid {
  private Hashtable<String, String> targetGrid;
  private Hashtable<String, String> oceanGrid; 
  private String[] shipTypes;
  private Vector<LinkedList<String>> ships;
  private static final int NUM_SHIPS = 5;
  private int counter = 0;
  
  public Grid() {
    // Initialize instance variables
    targetGrid = new Hashtable<String, String>();
    oceanGrid = new Hashtable<String, String>();
    shipTypes = new String[NUM_SHIPS];
    ships = new Vector<LinkedList<String>>();
    
    for (int i = 0; i < NUM_SHIPS; i++) // Fill ships with empty lists
      ships.add(new LinkedList<String>());
    
    // Fill hashtables with keys
    for (int i = 65; i < 75; i ++) {
      for (int j = 1; j <11; j++) {
        targetGrid.put((char)(i) + Integer.toString(j), "Empty");
        oceanGrid.put((char)(i) + Integer.toString(j), "Empty");
      }
    }
    
    shipTypes[0] = "Destroyer";
    shipTypes[1] = "Submarine";
    shipTypes[2] = "Cruiser";
    shipTypes[3] = "Battleship";
    shipTypes[4] = "Carrier";
  }
  
  /**
   * Based on the starting point and the orientation of the ship will place the ship on the oceanGrid
   * @param ship to be placed
   */
  public void addShip(Ship ship) {
    if (!isValidStart(ship)) {
      throw new IllegalArgumentException("Ships not in bounds of the board. Please check ship positions.");
    }
    System.out.println(Arrays.toString(shipTypes));
    System.out.println(ships);
    for (String loc : spannedSpaces(ship)) {
      oceanGrid.put(loc, "ship");
      ships.get(indexOfShip(ship.getName())).add(loc);
    }
  }
  /**
   * Alows the user to check if a missile has been already shot to a certain location
   * @param loc String denoting location to be checked
   * @return true if a missile has already been shot to location, false otherwise
   */
  public boolean alreadyShotMissile(String loc) {
    return !(targetGrid.get(loc).equals("empty"));
  }
  
  /**
   * Marks places on the grid where the player has hit
   * @param location String denoting location to hit
   */
  public void markTargetGrid(String location) {
    if (!oceanGrid.get(location).equals("ship")) 
      targetGrid.put(location, "MISS");
    else 
      targetGrid.put(location, "HIT");
  }
  
  /**
   * Makes places on the grid where the player has fired
   * @param location String denoting location to hit
   */
  public void markOceanGrid(String location){
    if (!oceanGrid.get(location).equals("ship"))
      oceanGrid.put(location, "MISS");
    else
      oceanGrid.put(location, "HIT");
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
   * Getter method for ship locations
   * @return Vector<LinkedList<String>> ships
   */
  public Vector<LinkedList<String>> getShips() {
    return ships;
  }
  
  /**
   * Getter method for shipTypes
   * @return Vector<Ship> ships
   */
  public String[] getShipTypes() {
    return shipTypes;
  }
  
  /**
   * Returns the index of a given Ship object
   * @param Ship ship which user wants the index of
   * @return int index of ship in shipTypes
   */
  public int indexOfShip(String name) {
    for(int i = 0; i < NUM_SHIPS; i++) {
      if(shipTypes[i].equals(name))
        return i;
    }
    return -1;
  }
  
  public boolean hasShip(String loc) {
    return oceanGrid.get(loc).equals("ship");
  }
  
  /**
   * Method which tells user what ship is stored at a certain location. Assumes user only inputs a location in which a ship exists.
   * @param loc String denoting which location user would like to search for a ship for
   * @return Ship ship at input location
   */
  public String shipAtLocation(String loc) {
    int shipIndex = 0;
    for (int i = 0; i < NUM_SHIPS; i++)
      for (String location: ships.get(i))
        if (location.equals(loc))
          shipIndex = i;
    return shipTypes[shipIndex];
  }
  
  public Vector<String> spannedSpaces(Ship ship) {
    Vector<String> spans = new Vector<String>();
    char column = ship.getStartCoord().charAt(0);
    String row = Character.toString(ship.getStartCoord().charAt(1));
    System.out.println("column: " + column + "| row: " + row);
    //example a1: a1, b1, c1, d1
    if (ship.getOrientation().equals("Horizontal")) {
      for (int i = 0; i < ship.getLength(); i++) {
        char columnLoc = (char) ((int) column + i);
        System.out.println(Character.toString(columnLoc));
        spans.add(Character.toString(columnLoc) + row);
      }
    } 
    // example a1: a1, a2, a3
    else {
      for (int j = 0; j < ship.getLength(); j++) {
        int rowLoc = Integer.parseInt(row) + j;
        spans.add(Character.toString(column) + Integer.toString(rowLoc));
      }
    }
    return spans;
  }
  
  public boolean isValidMissile(String loc) {
    return oceanGrid.containsKey(loc);
  }
  
  public boolean isValidStart(Ship ship) {
    for(String loc : spannedSpaces(ship)) {
      if(!oceanGrid.containsKey(loc) || oceanGrid.get(loc).equals("ship")) {
        return false;
      }
    }
    return true;
  }
  
  public static void main(String[] args) {
    Grid grid = new Grid();
    System.out.println("Target: " + grid.getTargetGrid());
    System.out.println("Ocean: " + grid.getOceanGrid());
    
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
    
    System.out.println("Checking ship at location C4 (Submarine): " + grid.shipAtLocation("C4"));
    
    grid.addShip(ship3);
    grid.addShip(ship4);
    
    System.out.println(grid.getShips());
    System.out.println(grid.getShipTypes());
  }
}