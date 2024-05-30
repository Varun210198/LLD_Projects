package LLD3.TicTacToe.Models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int dimension;
    private List<List<Cell>> board;

    public Board(int dimension){
        this.dimension = dimension;
        this.board = new ArrayList<>();

        for(int i = 0; i < dimension ; i++){
            board.add(new ArrayList<>());
            for ( int j = 0; j < dimension ; j++){
                board.get(i).add(new Cell(i,j));
            }
        }
    }

    public int getDimension() {
        return dimension;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void display() {
        System.out.println("Current Board : ");
        for(int i = 0 ; i < this.dimension; i++){
            for(int j = 0; j < this.dimension; j++){
                if(board.get(i).get(j).cellState == CellState.FILLED){
                    System.out.print("|"+board.get(i).get(j).player.symbol+"|");
                }
                else{
                    System.out.print("|_|");
                }
            }
            System.out.println();
        }
    }

    
}
