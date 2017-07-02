package example.codeclan.com.fruitmachine;

import example.codeclan.com.fruitmachine.behaviours.Symbols;

/**
 * Created by user on 30/06/2017.
 */

public class Symbol {

    private Symbols symbol;

    public Symbol(Symbols symbol){
        this.symbol = symbol;
    }

    public Symbols getSymbol() {
        return this.symbol;
    }

    public int getValue(){
        return this.symbol.getValue();
    }

}
