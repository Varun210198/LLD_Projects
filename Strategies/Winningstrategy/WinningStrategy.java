package LLD3.TicTacToe.Strategies.Winningstrategy;

import LLD3.TicTacToe.Models.Board;
import LLD3.TicTacToe.Models.Cell;
import LLD3.TicTacToe.Models.Move;

public interface WinningStrategy {
    boolean checkWin(Board board, Cell cell);
    void handleUndo(Board board, Move lastMove);
}
