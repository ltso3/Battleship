public class PlayBattleship {
	private Grid pGrid;
	private Grid cGrid;
	private String pName;
	private String cName;
	
	public PlayBattleship(String pName, String cName) {
		pGrid = new Grid();
		cGrid = new Grid();
		this.pName = pName;
		this.cName = cName;
	}
	
	// Fires missile, marks player one's targetGrid and the other player two's oceanGrid
	private void fireMissile(String loc, Grid grid1, Grid grid2) {
		grid2.markOceanGrid(loc);
		grid1.markTargetGrid(loc);
	}
	
	private void playerTurn(String loc) {
		fireMissile(loc, pGrid, cGrid);
	}
	
	private void computerTurn(String loc) {
		fireMissile(loc, cGrid, pGrid);
	}
}
