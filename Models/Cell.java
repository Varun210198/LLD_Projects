package LLD3.TicTacToe.Models;

public class Cell {
    int row;
    int col;
    CellState cellState; 
    Player player;

    public Cell(int row, int col ) {
        this.row = row;
        this.col = col;
        this.cellState = CellState.EMPTY;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public CellState getCellState() {
        return cellState;
    }

    public Player getPlayer() {
        return player;
    }
}
