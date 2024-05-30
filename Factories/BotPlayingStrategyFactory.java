package LLD3.TicTacToe.Factories;

import LLD3.TicTacToe.Models.BotDifficultyLevel;
import LLD3.TicTacToe.Strategies.BotPlayingStrategies.BotPlayingStrategy;
import LLD3.TicTacToe.Strategies.BotPlayingStrategies.EasyPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel difficultyLevel){
        if(difficultyLevel == BotDifficultyLevel.EASY){
            return new EasyPlayingStrategy();
        }
        return null;
    }
        
}
