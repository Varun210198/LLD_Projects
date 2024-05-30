package LLD3.TicTacToe.Models;

import LLD3.TicTacToe.Factories.BotPlayingStrategyFactory;
import LLD3.TicTacToe.Strategies.BotPlayingStrategies.BotPlayingStrategy;

public class BotPlayer extends Player{
    BotDifficultyLevel botDifficultyLevel;
    BotPlayingStrategy botPlayingStrategy;

    public BotPlayer(String name, Integer gamerID, Character symbol, PlayerType playerType, 
    BotDifficultyLevel botDifficultyLevel) {
        super(name, gamerID, symbol, playerType);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(botDifficultyLevel);
        // this.botPlayingStrategy = BotPlayingStrategyFactory
        //         .getBotPlayingStrategy(this.botDifficultyLevel);
    }
    public Cell makeMove(Board board){
        return botPlayingStrategy.makeMove(board,this);
    }
}
