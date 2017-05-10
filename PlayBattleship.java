import java.util.*;

public class PlayBattleship {
  
  // Initialize private instance variables
  private Grid pGrid;
  private Grid cGrid;
  
  public PlayBattleship() {
    // Assign instance variables
    pGrid = new Grid();
    cGrid = new Grid();
  }
  
  /**
   * Fires missile, marks player one's targetGrid and the other player's oceanGrid
   * @param loc String denoting location to fire at
   * @param grid1 Grid object for one player
   * @param grid2 Grid object for second player
   */
  public boolean fireMissile(String loc, Grid grid1, Grid grid2) {
    if (grid2.isValidMissile(loc)) {
      grid2.markOceanGrid(loc);
      grid1.markTargetGrid(loc);
    }
    return grid2.hasShip(loc);
  }
  
  /**
   * Simulates one turn for the player, firing a missile and informing them if a ship has been sunk
   * @param loc String denoting location to fire missile at
   */
  public void playerTurn(String loc) {
    if (cGrid.hasShip(loc)) 
      System.out.println("HIT at " + loc);
    else
      System.out.println("MISS at " + loc);
    
    fireMissile(loc, pGrid, cGrid);
    
//    if (isSunk(cGrid, loc))
//      System.out.println("You sunk one of the computer's ships");
  }
  
  /**
   * Simulates one turn for the computer, firing a missile and informing them if a ship has been sunk
   */
  public void computerTurn() { // Can make this the easy level later and hard will have more focused targeting
    
    // Generate a random location for the computer to shoot at
    String loc;
    Random rand = new Random(); 
    int let = rand.nextInt(10) + 65;
    int num = rand.nextInt(10) + 1;
    loc = (char)(let) + Integer.toString(num);

    // Make sure the location can be shot at before firing missile
    while (!cGrid.isValidMissile(loc)) {
      let = rand.nextInt((74 - 65) + 1) + 65;
      num = rand.nextInt(10) + 1;
      loc = (char)(let) + Integer.toString(num);
    }

    if (pGrid.hasShip(loc)) 
      System.out.println("HIT at " + loc);
    else
      System.out.println("MISS at " + loc);
    
    fireMissile(loc, cGrid, pGrid);
    
//    if (isSunk(pGrid, loc))
//      System.out.println("The computer has sunk one of your ships");
  }
  
  public Grid getPGrid() {
    return pGrid;
  }
  
  public Grid getCGrid() {
    return cGrid;
  }
  
  public static void main(String[] args) {
    PlayBattleship game = new PlayBattleship();
    Ship boatyboatface = new Ship("Submarine", "Vertical", "C4");
    
    // Testing playerTurn
    game.cGrid.addShip(boatyboatface);
    System.out.print("Player is shooting at C5 (HIT): ");
    game.playerTurn("C5");
    System.out.print("Player is shooting at E6 (MISS): ");
    game.playerTurn("E6");
    System.out.print("Player is shooting at C4 (HIT): ");
    game.playerTurn("C4");
    System.out.print("Player is shooting at C6 (HIT): ");
    game.playerTurn("C6");
    System.out.println("Testing allSunk(true): " + game.cGrid.allSunk());
    
    // Testing computerTurn
    game.pGrid.addShip(boatyboatface);
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