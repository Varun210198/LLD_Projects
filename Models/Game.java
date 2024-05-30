package LLD3.TicTacToe.Models;

import java.util.ArrayList;
import java.util.List;

import LLD3.TicTacToe.Exceptions.BotCountExceedsLimitException;
import LLD3.TicTacToe.Exceptions.DuplicateSymbolException;
import LLD3.TicTacToe.Exceptions.InvalidPlayerCountException;
import LLD3.TicTacToe.Strategies.Winningstrategy.WinningStrategy;
import LLD3.TicTacToe.Validations.GameValidations;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameState gameState;
    private Player winner;
    private Integer nextPlayerIndex; 
    private List<WinningStrategy> winningStrategyList;
    
    public Game(Integer dimension, List<Player> players, List<WinningStrategy> winningStrategyList){
        this.board = new Board(dimension);
        this.players = players;
        this.winningStrategyList = winningStrategyList;
        gameState = GameState.INPROGRESS;
        nextPlayerIndex = 0;
        moves = new ArrayList<>();
    }



    
    public void printBoard(){
        board.display();
    }




    public void makeMove(){
        Player player = players.get(nextPlayerIndex);
        Cell cell = player.makeMove(board);
        moves.add(new Move(cell, player));
        //Check if win
        if (checkWinner(board, cell)){
            this.gameState = GameState.CONCLUDED;
            this.winner = player;
            return ; 
        }
        else if(this.moves.size() == board.getDimension() * board.getDimension()){
            //check if Draw
            //when count of moves is equal to total cells then draw
            gameState = GameState.DRAW;
            return ;
        }     
        nextPlayerIndex++;
        nextPlayerIndex %=this.players.size();
    }



    public void undo(){
        if(this.moves.size() <= 0){
            System.out.println("No valid moves to undo");
            return;
        }

        Move lastMove = this.moves.get(this.moves.size()-1);
        this.moves.remove(lastMove);

        Cell cell = lastMove.getCell();
        cell.setPlayer(null);
        cell.setCellState(CellState.EMPTY);

        for(WinningStrategy ws: this.winningStrategyList){
            ws.handleUndo(board, lastMove);
        }

        if(nextPlayerIndex > 0){
            nextPlayerIndex--;
        }else{
            nextPlayerIndex = players.size()-1;
        }

    }





    public boolean checkWinner(Board board, Cell cell){
        for (WinningStrategy ws: winningStrategyList){
            if(ws.checkWin(board, cell)){
                return true;
            }
        }
        return false;
    }

    

    

    public GameState getGameState() {
        return gameState;
    }

    public Player getWinner() {
        return winner;
    }

    public Integer getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    
    public static Builder getBuilder(){
        return new Builder();
    }

    public static class Builder {
        Integer dimension;
        List<Player> players;
        List<WinningStrategy> winningStrategyList;
        
        public Builder setDimension(Integer dimension) {
            this.dimension = dimension;
            return this;
        }
        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }
        public Builder setWinningStrategyList(List<WinningStrategy> winningStrategyList) {
            this.winningStrategyList = winningStrategyList;
            return this;
        }

        public Game build() throws InvalidPlayerCountException, DuplicateSymbolException, BotCountExceedsLimitException{
            //Here we can add the validations
            GameValidations.validatePlayerCount(dimension,players);
            GameValidations.validateBotCount(dimension,players);
            GameValidations.validateUniqueSymbol(players);
            return new Game(dimension, players, winningStrategyList);
        }

    }

}
