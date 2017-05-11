public class Ship {
  
  // Initialize private instance variables
  private String name;
  private String orientation;
  private int length;
  private String startCoord;
  
  public Ship(String name, String orientation, String startCoord) {  
    // Assign private instance variables
    this.name = name;
    this.orientation = orientation;
    this.length = setLength(name);
    this.startCoord = startCoord;
  }
  
  /* Getter method to retrieve name */
  public String getName() {
    return name;
  }
  
  /* Getter method to retrieve orientation */
  public String getOrientation() {
    return this.orientation;
  }
  
  /* Getter method to retrieve start coordinate */
  public String getStartCoord() {
    return this.startCoord;
  }
  
  /* Setter method to set orientation */
  public void setOrientation(String o) {
   orientation = o;
  }
  
  /* Setter method to set start coordinate */
  public void setStartCoord(String newCoord) {
   startCoord = newCoord;
  }
  
  /* Setter method to set length according to ship name */
  public int setLength(String name) {
    int len = 0;
    if(name.equals("Carrier"))
      len = 5;
    else if(name.equals("Battleship"))
      len = 4;
    else if(name.equals("Cruiser"))
      len = 3;
    else if(name.equals("Submarine")) 
      len = 3;
    else if(name.equals("Destroyer"))
      len = 2;
    else
      len = 0;
    return len;
  }
  
  /* Getter method to retrieve length */
  public int getLength() {
    return this.length;
  }
  
  /* Format Ship in a String with the appropriate values */
  public String toString() {
   String s = "";
   s += "Ship: " +name + ", Length: " + length + " Orientation: " + orientation + " Starting coordinate: " + startCoord + "\n";
   return s;
  }
  
  public static void main(String[] args) {
    /*
    Ship carrier = new Ship("Carrier", "Vertical", "A1");
    System.out.println(carrier.getName() + " of length " + carrier.getLength());
    Ship battleship = new Ship("Battleship", "Vertical", "F5");
    System.out.println(battleship.getName() + " of length " + battleship.getLength());
    Ship cruiser = new Ship("Cruiser", "Vertical", "J10");
    System.out.println(cruiser.getName() + " of length " + cruiser.getLength());
    Ship submarine = new Ship("Submarine", "Vertical", "E4");
    System.out.println(submarine.getName() + " of length " + submarine.getLength());
    Ship destroyer = new Ship("Destroyer", "Vertical", "G8");
    System.out.println(destroyer.getName() + " of length " + destroyer.getLength());
    */
  }
}