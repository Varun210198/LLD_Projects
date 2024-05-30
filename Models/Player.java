package LLD3.TicTacToe.Models;

public abstract class Player {
    String name;
    Integer playerID;
    Character symbol;
    PlayerType playerType;

    public Player(String name, Integer PlayerID, Character symbol, PlayerType playerType) {
        this.name = name;
        this.playerID = PlayerID;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public abstract Cell makeMove(Board board);

    public Character getSymbol() {
       return this.symbol;
    }

    public String getName() {
       return this.name;
    }

    public Object getPlayerType() {
        return this.playerType;
    }
}
