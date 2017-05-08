import java.util.*;

public class Grid {
  private Hashtable<String, String> targetGrid;
  private Hashtable<String, String> oceanGrid; 
  private Ship[] shipTypes;
  private Vector<LinkedList<String>> ships;
  private static final int NUM_SHIPS = 5;
  private int counter = 0;
  
  public Grid() {
    // Initialize instance variables
    targetGrid = new Hashtable<String, String>();
    oceanGrid = new Hashtable<String, String>();
    shipTypes = new Ship[NUM_SHIPS];
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
  }
  
  /**
   * Based on the starting point and the orientation of the ship will place the ship on the oceanGrid
   * @param ship to be placed
   */
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
    
    if (!alreadyShip) {
        shipTypes[counter] = ship;
        counter++;
    }
  }
  /**
   * Alows the user to check if a missile has been already shot to a certain location
   * @param loc String denoting location to be checked
   * @return true if a missile has already been shot to location, false otherwise
   */
  public boolean alreadyShotMissile(String loc) {
   return (targetGrid.equals("HIT") || targetGrid.equals("MISS"));
  }
  
 /**
  * Marks places on the grid where the player has hit
  * @param location String denoting location to hit
  */
  public void markTargetGrid(String location) {
<<<<<<< HEAD
   if (!oceanGrid.get(location).equals("ship")) 
    targetGrid.put(location, "MISS");
   else 
    targetGrid.put(location, "HIT");
=======
	  if (!oceanGrid.get(location).equals("ship")) 
		  targetGrid.put(location, "MISS");
	  else 
		  targetGrid.put(location, "HIT");
>>>>>>> ea2924ba459a06d2948bc086c8161e6a4b393c00
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
  public Ship[] getShipTypes() {
   return shipTypes;
  }
  
  /**
   * Returns the index of a given Ship object
   * @param Ship ship which user wants the index of
   * @return int index of ship in shipTypes
   */
  public int indexOfShip(Ship ship) {
    for(int i = 0; i < NUM_SHIPS; i++) {
      if(shipTypes[i].equals(ship))
        return i;
    }
    return -1;
  }
  
  public boolean hasShip(String loc) {
   return oceanGrid.get(loc).equals("ship");
  }
  
  public boolean hasShip(String loc) {
	  boolean hasShip = false;
	  if (oceanGrid.get(loc).equals("ship"))
		  hasShip = true;
	  return hasShip;
  }
  
  /**
   * Method which tells user what ship is stored at a certain location. Assumes user only inputs a location in which a ship exists.
   * @param loc String denoting which location user would like to search for a ship for
   * @return Ship ship at input location
   */
  public Ship shipAtLocation(String loc) {
   int shipIndex = 0;
   for (int i = 0; i < ships.size(); i++)
    for (String location: ships.get(i))
     if (location.equals(loc))
      shipIndex = i;
   return shipTypes[shipIndex];
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
    
    System.out.println("Checking ship at location C4 (Submarine): " + grid.shipAtLocation("C4").getName());
    
    grid.addShip(ship3);
    grid.addShip(ship4);
    
    System.out.println(grid.getShips());
    System.out.println(grid.getShipTypes());
  }
}