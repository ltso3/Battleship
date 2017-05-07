public class Ship {
  
  private String name;
  private String orientation;
  private int length;
  private String startCoord;
  
  public Ship(String name, String orientation, String startCoord) {  
    this.name = name;
    this.orientation = orientation;
    this.length = setLength(name);
    this.startCoord = startCoord;
  }
  
  public String getName() {
    return name;
  }
  
  public String getOrientation() {
    return this.orientation;
  }
  
  public String getStartCoord() {
    return this.startCoord;
  }
  
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
  
  public int getLength() {
    return this.length;
  }
  
  public String toString() {
    return "Ship: " +name + ", length: " + length + ", Starting coordinate: " + startCoord + "\n";
  }
  
  public static void main(String[] args) {
    /*
    Ship carrier = new Ship("Carrier", "Vertical", "A1");
    System.out.println(carrier.getName() + " of length " + carrier.getLength());
    Ship battleship = new Ship("Battleship", "Vertical", ");
    System.out.println(battleship.getName() + " of length " + battleship.getLength());
    Ship cruiser = new Ship("Cruiser", "Vertical", coord);
    System.out.println(cruiser.getName() + " of length " + cruiser.getLength());
    Ship submarine = new Ship("Submarine", "Vertical", coord);
    System.out.println(submarine.getName() + " of length " + submarine.getLength());
    Ship destroyer = new Ship("Destroyer", "Vertical", coord);
    System.out.println(destroyer.getName() + " of length " + destroyer.getLength());
    */
  }
}
