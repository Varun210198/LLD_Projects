package LLD3.TicTacToe.Controllers;

import java.util.List;

import LLD3.TicTacToe.Exceptions.BotCountExceedsLimitException;
import LLD3.TicTacToe.Exceptions.DuplicateSymbolException;
import LLD3.TicTacToe.Exceptions.InvalidPlayerCountException;
import LLD3.TicTacToe.Models.Game;
import LLD3.TicTacToe.Models.Player;
import LLD3.TicTacToe.Strategies.Winningstrategy.WinningStrategy;

public class GameController {
    public Game startGame(Integer dimension, List<Player> players, List<WinningStrategy> winningStrategyList) throws InvalidPlayerCountException, DuplicateSymbolException, BotCountExceedsLimitException{
        System.out.println("TicTacToe Game Begins!");
        return Game.getBuilder()
                            .setDimension(dimension)
                            .setPlayers(players)
                            .setWinningStrategyList(winningStrategyList)
                            .build();

    }
    public void makeMove(Game game){
        game.makeMove();
    }

    public void printBoard(Game game){
        game.printBoard();
    }

    public void undo(Game game){
        game.undo();
    }
    
}
