package example.codeclan.com.fruitmachine.behaviours;

/**
 * Created by user on 30/06/2017.
 */

public enum Symbols {

    AUBERGINE(1),
    LEMON(2),
    CHERRY(3),
    BELL(4),
    SEVEN(7),
    DIAMOND(10),
    JACKPOT(20);

    private int symbolValue;

    Symbols (int symbolValue){
        this.symbolValue = symbolValue;
    }

    public int getValue() {
        return this.symbolValue;
    }
}
