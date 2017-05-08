import java.util.*;

public class PlayBattleship {
 private Grid pGrid;
 private Grid cGrid;
 
 public PlayBattleship() {
  // Initialize instance variables
  pGrid = new Grid();
  cGrid = new Grid();
 }
 
 /**
  * Fires missile, marks player one's targetGrid and the other player two's oceanGrid
  * @param loc String denoting location to fire at
  * @param grid1 Grid object for one player
  * @param grid2 Grid object for second player
  */
 private void fireMissile(String loc, Grid grid1, Grid grid2) {
  if (!grid1.alreadyShotMissile(loc)) {
   grid2.markOceanGrid(loc);
   grid1.markTargetGrid(loc);
  }
 }
 
 /**
  * Simulates one turn for the player, firing a missile and informing them if a ship has been sunk
  * @param loc String denoting location to fire missile at
  */
 private void playerTurn(String loc) {
  if (cGrid.hasShip(loc)) 
   System.out.println("HIT");
  else
   System.out.println("MISS");
  
  fireMissile(loc, pGrid, cGrid);
  
  if (isSunk(cGrid, loc))
   System.out.println("You sunk one of the computer's ships");
 }
 
 /**
  * Simulates one turn for the computer, firing a missile and informing them if a ship has been sunk
  */
 private void computerTurn() { // Can make this the easy level later and hard will have more focused targeting
  
  // Generate a random location for the computer to shoot at
  String loc;
  Random rand = new Random(); 
  int let = rand.nextInt((74 - 65) + 1) + 65;
  int num = rand.nextInt(10) + 1;
  loc = (char)(let) + Integer.toString(num);
  
  // Make sure the location can be shot at before firing missile
  while (cGrid.alreadyShotMissile(loc)) {
   let = rand.nextInt((74 - 65) + 1) + 65;
   num = rand.nextInt(10) + 1;
  }
  
  if (pGrid.hasShip(loc)) 
   System.out.println("HIT at " + loc);
  else
   System.out.println("MISS at " + loc);
  
  fireMissile(loc, cGrid, pGrid);

  if (isSunk(pGrid, loc))
   System.out.println("The computer has sunk one of your ships");
 }
 
 /**
  * Helper method to help determine whether a ship has been sunk at the end of a turn
  * @param grid Grid which to check ships on
  * @param loc String denoting location where missile was shot
  * @return true if the ship at location has been sunk, false otherwise
  */
 private boolean isSunk(Grid grid, String loc) {
  boolean sunk = true;
  String hitShip = grid.shipAtLocation(loc);
  int hitShipIndex = grid.indexOfShip(hitShip);
  for (int i = 0; i < grid.getShips().get(hitShipIndex).size(); i++) {
   String locKey = (grid.getShips().get(hitShipIndex).get(i));
   if (!grid.getOceanGrid().get(locKey).equals("HIT")) { 
    sunk = false;
    i = grid.getShips().get(hitShipIndex).size(); // If any location on the ship has not been hit, the ship is not sunk so we can early exit loop
   }
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
  for (LinkedList<String> shipLocs: ships) {
   if (!shipLocs.isEmpty())
    if (!isSunk(grid, shipLocs.get(0)))
      won = false;
  }
  return won;
 }
 
 public Grid getPGrid() {
  return pGrid;
 }
 public static void main(String[] args) {
  PlayBattleship game = new PlayBattleship();
  Ship boatyboatface = new Ship("Submarine", "Vertical", "C4");
  
  // Testing playerTurn
/*  game.cGrid.addShip(boatyboatface);
  System.out.print("Player is shooting at D4 (HIT): ");
  game.playerTurn("D4");
  System.out.print("Player is shooting at E6 (MISS): ");
  game.playerTurn("E6");
  System.out.print("Player is shooting at C4 (HIT): ");
  game.playerTurn("C4");
  System.out.print("Player is shooting at E4 (HIT): ");
  game.playerTurn("E4");
  System.out.println("Testing allSunk(true): " + game.allSunk(game.cGrid));*/
  
  // Testing computerTurn
/*  game.pGrid.addShip(boatyboatface);
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
  game.computerTurn();*/
 }
}
