import java.util.Enumeration;
import java.util.Random;
import java.util.*;

public class PlayBattleship {
  
  // Initialize private instance variables
  private Grid pGrid;
  private Grid cGrid;
  String cCoord;
  
  /**
   * Constructor which initializes player Grids and also sets up ships on cGrid
   */
  public PlayBattleship() {
    // Assign instance variables
    pGrid = new Grid();
    cGrid = new Grid();
    
    // Create ships to be added to cGrid
    Ship[] cShips = new Ship[5];
    Ship ship1 = new Ship("Destroyer", "Vertical", "A1");
    Ship ship2 = new Ship("Submarine", "Vertical", "A1");
    Ship ship3 = new Ship("Cruiser", "Vertical", "A1");
    Ship ship4 = new Ship("Battleship", "Vertical", "A1");
    Ship ship5 = new Ship("Carrier", "Vertical", "A1");
    cShips[0] = ship1;
    cShips[1] = ship2;
    cShips[2] = ship3;
    cShips[3] = ship4;
    cShips[4] = ship5;

    // Randomize ship orientations
    for (Ship ship: cShips) {
        Random rand1 = new Random();
        int randNum = rand1.nextInt(10);
     if (randNum/2 != 0)
      ship.setOrientation("Horizontal");
    }

    // Randomize starting coordinates and add ships
    for (Ship ship: cShips) {
        Random rand2 = new Random(); 
        int let = rand2.nextInt(10) + 65;
        int num = rand2.nextInt(10) + 1;
        String loc = (char)(let) + Integer.toString(num);
     ship.setStartCoord(loc);
     
     while (!cGrid.isOpenSpot(loc) || !cGrid.isValidStart(ship)) {
      let = rand2.nextInt(10) + 65;
         num = rand2.nextInt(10) + 1;
         loc = (char)(let) + Integer.toString(num);
         ship.setStartCoord(loc);
     }
     cGrid.addShip(ship);
    }
  }
  
  /**
   * Fires missile, marks player one's targetGrid and the other player's oceanGrid
   * @param loc String denoting location to fire at
   * @param grid1 Grid object for one player
   * @param grid2 Grid object for second player
   */
  public boolean fireMissile(String loc, Grid grid1, Grid grid2) {
    if (grid2.isOpenSpot(loc)) {
      grid1.markTargetGrid(grid2, loc);
      grid2.markOceanGrid(loc);
    }
    return grid2.hasShip(loc);
  }
  
  /**
   * Simulates one turn for the player, firing a missile and informing them if a ship has been sunk
   * @param loc String denoting location to fire missile at
   */
  public boolean playerTurn(String loc) {
 boolean hit;
 
    if (cGrid.hasShip(loc)) 
      System.out.println("HIT at " + loc);
    else
      System.out.println("MISS at " + loc);
    
    hit = fireMissile(loc, pGrid, cGrid);
    
    if (cGrid.isSunk(loc))
      System.out.println("You sunk one of the computer's ships");
    
    return hit;
  }
 
  /**
   * Helper function to get location to the left of the current location
   * @param current String location to find adjacent locations of
   * @return location adjacent to current location on the left
   */
  private String getLeftAdjacent(String current) {
   String s = "";
   char column = current.charAt(0);
   String row = current.substring(1);
   column = (char) (column-1);
   if (cGrid.getTargetGrid().containsKey(column + row)) // Check that adjacent location is actually a valid spot on grid
    s = column+row;
      return s;
  }
  
  /**
   * Helper function to get location to the right of the current location
   * @param current String location to find adjacent locations of
   * @return location adjacent to current location on the right
   */
  private String getRightAdjacent(String current) {
   String s = "";
   char column = current.charAt(0);
   String row = current.substring(1);
   column = (char) (column+1);
   if (cGrid.getTargetGrid().containsKey(column + row)) // Check that adjacent location is actually a valid spot on grid
    s = column+row;
   return s;
  }
 
  /**
   * Helper function to get location to the north of the current location
   * @param current String location to find adjacent locations of
   * @return location adjacent to current location on the north
   */
  private String getNorthAdjacent(String current) {
  String s = "";
  char column = current.charAt(0);
  String row = current.substring(1);
  row = Integer.toString(Integer.parseInt(row)-1);
   if (cGrid.getTargetGrid().containsKey(column + row)) // Check that adjacent location is actually a valid spot on grid
    s = column+row;
  return s;
  }
  
  /**
   * Helper function to get location to the south of the current location
   * @param current String location to find adjacent locations of
   * @return location adjacent to current location on the south
   */
  private String getSouthAdjacent(String current) {
   String s = "";
   char column = current.charAt(0);
   String row = current.substring(1);
   row = Integer.toString(Integer.parseInt(row)+1);
   if (cGrid.getTargetGrid().containsKey(column + row)) // Check that adjacent location is actually a valid spot on grid
    s = column+row;
   return s;
  }
 
  /**
   * Simulates one turn for the computer, firing a missile and informing them if a ship has been sunk
   */
  public boolean computerTurn() { 
 boolean hit = false;
 boolean fired = false;

 Enumeration<String> keys = cGrid.getTargetGrid().keys();
 while (keys.hasMoreElements() && !fired) {
  String adj = "";
  String loc = keys.nextElement();
  
  if (cGrid.getTargetGrid().get(loc).equals("HIT")) {
   String right = getRightAdjacent(loc);
   String left = getLeftAdjacent(loc);
   String south = getSouthAdjacent(loc);
      String north = getNorthAdjacent(loc);
    
   if (cGrid.getTargetGrid().get(right).equals("Empty"))
    adj = right;
   else if (cGrid.getTargetGrid().get(south).equals("Empty"))
    adj = south;
   else if (cGrid.getTargetGrid().get(left).equals("Empty"))
    adj = left;
   else if (cGrid.getTargetGrid().get(north).equals("Empty"))
    adj = north;
  }

  if (!adj.equals("")) {
      if (pGrid.hasShip(adj)) 
          System.out.println("HIT at " + adj);
        else
          System.out.println("MISS at " + adj);
        
        cCoord = adj;
        hit = fireMissile(adj, cGrid, pGrid);
        fired = true;
        
        if (pGrid.isSunk(loc))
          System.out.println("The computer has sunk one of your ships");
  } 
 }
 
 // Shoot at a random location if there is no better option to shoot at
    if (fired == false) { 
     System.out.println("Going random");
     String loc;
     Random rand = new Random(); 
     int let = rand.nextInt(10) + 65;
     int num = rand.nextInt(10) + 1;
     loc = (char)(let) + Integer.toString(num);
 
     // Make sure the location can be shot at before firing missile
     while (!cGrid.isOpenSpot(loc)) {
       let = rand.nextInt((74 - 65) + 1) + 65;
       num = rand.nextInt(10) + 1;
       loc = (char)(let) + Integer.toString(num);
       System.out.println(loc);
     }
 
     cCoord = loc; 
     
     if (pGrid.hasShip(loc)) 
       System.out.println("HIT at " + loc);
     else
       System.out.println("MISS at " + loc);
     
     hit = fireMissile(loc, cGrid, pGrid);
     
     if (pGrid.isSunk(loc))
       System.out.println("The computer has sunk one of your ships");
    }
    return hit;
  }
  
  public String getCCoord() {
   return cCoord;
  }
  
  public Grid getPGrid() {
    return pGrid;
  }
  
  public Grid getCGrid() {
    return cGrid;
  }
  
  
  /**
   * Determine whether all ships are sunk and the game is over
   * @return true if all ships are sunk, false otherwise
   */
  public boolean playerWin() {
    boolean won = true;
    for (LinkedList<String> locs: cGrid.getShipLocs()) {
      for(String loc : locs) {
        if (!cGrid.getOceanGrid().get(loc).equals("HIT"))
              won = false;
      }
    }
    return won;
  }
  
  /**
   * Determine whether all ships are sunk and the game is over
   * @return true if all ships are sunk, false otherwise
   */
  public boolean computerWin() {
    boolean won = true;
    for (LinkedList<String> locs: pGrid.getShipLocs()) {
      for(String loc : locs) {
        if (!pGrid.getOceanGrid().get(loc).equals("HIT"))
              won = false;
      }
    }
    return won;
  }
  
  public static void main(String[] args) {
   PlayBattleship game = new PlayBattleship();
   Ship boatyboatface = new Ship("Submarine", "Vertical", "C4");
   game.pGrid.addShip(boatyboatface);
   
   game.fireMissile("C5", game.cGrid, game.pGrid);
   
   System.out.print("Computer is playing: ");
   game.computerTurn();
   
   System.out.print("Computer is playing: ");
   game.computerTurn();
   
   System.out.print("Computer is playing: ");
   game.computerTurn();
   
   System.out.print("Computer is playing: ");
   game.computerTurn();
   
   System.out.print("Computer is playing: ");
   game.computerTurn();
   
   System.out.print("Computer is playing: ");
   game.computerTurn();
   
   System.out.print("Computer is playing: ");
   game.computerTurn();
   
  }
}
