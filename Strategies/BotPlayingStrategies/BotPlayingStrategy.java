package LLD3.TicTacToe.Strategies.BotPlayingStrategies;

import LLD3.TicTacToe.Models.Board;
import LLD3.TicTacToe.Models.Cell;
import LLD3.TicTacToe.Models.Player;

public interface BotPlayingStrategy {
    Cell makeMove(Board board,Player player);
}
