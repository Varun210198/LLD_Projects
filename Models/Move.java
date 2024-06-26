package LLD3.TicTacToe.Models;

public class Move {
    private Cell cell;
    private Player player;

    public Move(Cell cell, Player player){
        this.cell = cell;
        this.player = player;
    }

    public Cell getCell() {
        return this.cell;
    }

    public Player getPlayer() {
        return this.player;
    }
}
