package LLD3.TicTacToe.Strategies.Winningstrategy;

import java.util.HashMap;
import java.util.Map;

import LLD3.TicTacToe.Models.Board;
import LLD3.TicTacToe.Models.Cell;
import LLD3.TicTacToe.Models.Move;

public class RowWinningStrategy implements WinningStrategy{
    Map<Integer, Map<Character, Integer> > rowMap = new HashMap<>();



    @Override
    public boolean checkWin(Board board, Cell cell) {
        Integer row = cell.getRow();
        Character symbol = cell.getPlayer().getSymbol();
        if (rowMap.get(row) == null){
            rowMap.put(row, new HashMap<>());
           // rowMap.get(row).put(symbol, 1);
        }
        if(rowMap.get(row).get(symbol) == null){
            rowMap.get(row).put(symbol,1);
        }
        else{
            rowMap.get(row).put(symbol, rowMap.get(row).get(symbol)+1);
        }
        if(rowMap.get(row).get(symbol).equals(board.getDimension())){
            return true;
        }

        return false;

    }



    @Override
    public void handleUndo(Board board, Move lastMove) {
        Integer row = lastMove.getCell().getRow();
        Character symbol = lastMove.getPlayer().getSymbol();
        rowMap.get(row).put(symbol,rowMap.get(row).get(symbol)-1);
        return;
    }
    
    // public handleUndo(Move lastMove){
    //     rowMap.get(row)
    // }
}
