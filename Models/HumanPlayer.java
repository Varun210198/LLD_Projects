package LLD3.TicTacToe.Models;

import java.util.Scanner;

import LLD3.TicTacToe.Validations.CellValidations;

public class HumanPlayer extends Player{

    Scanner scanner ;

    public HumanPlayer(String name, Integer playerId, Character symbol, PlayerType type){
        super(name, playerId,symbol,type);
        scanner = new Scanner(System.in);
    }
    public Cell makeMove(Board board){
        Integer row;
        Integer col;
        //Take Input from user
        do{
             row = scanner.nextInt();
             col = scanner.nextInt();  
             //make CellValidation class a s static because we are not creating any object for CellValidation
             //as we dont have any data in CellValidations class   
             //we are just using the logic
             //we can use the same logic for all the games
        }while(!CellValidations.validateRowCol(board, row, col));
        

        Cell cell = board.getBoard().get(row).get(col);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(this);
        return cell;
    }

    
}
