package LLD3.TicTacToe.Strategies.BotPlayingStrategies;

import LLD3.TicTacToe.Models.Board;
import LLD3.TicTacToe.Models.Cell;
import LLD3.TicTacToe.Models.CellState;
import LLD3.TicTacToe.Models.Player;

public class EasyPlayingStrategy implements BotPlayingStrategy{

    @Override
    public Cell makeMove(Board board, Player player) {
        //return next avaible cell in the board
        Integer boardSize = board.getDimension();
        for(int i = 0; i < boardSize ; i++){
            for(int j = 0; j < boardSize ; j++){
                if(board.getBoard().get(i).get(j).getCellState().equals(CellState.EMPTY)){
                    Cell cell = board.getBoard().get(i).get(j);
                    cell.setCellState(CellState.FILLED);
                    cell.setPlayer(player);
                    return cell;
                }
            }
        }
        return null;
    }
    
}
