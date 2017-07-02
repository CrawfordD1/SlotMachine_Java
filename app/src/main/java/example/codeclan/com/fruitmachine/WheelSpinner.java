package example.codeclan.com.fruitmachine;

import java.util.ArrayList;
import java.util.Random;

import example.codeclan.com.fruitmachine.behaviours.Symbols;

/**
 * Created by user on 30/06/2017.
 */

public class WheelSpinner {

    private ArrayList<Symbol> wheel;
    private Symbol symbol;
    private int wheelNumber;
    private int hold;

    public WheelSpinner(int wheelNumber){
        this.wheel = new ArrayList<Symbol>();
        addSymbolstoWheel();
        this.symbol = getStart();
        this.wheelNumber = wheelNumber;
        this.hold = 0;
    }

    public void addSymbolstoWheel(){
        for(Symbols symbols: Symbols.values()){
            Symbol symbol = new Symbol(symbols);
            this.wheel.add(symbol);
        }
    }

    public ArrayList<Symbol> getWheel() {
        return this.wheel;
    }

    public Symbols getSymbol() {
        return this.symbol.getSymbol();
    }

    public Symbol getStart(){
        Random rand = new Random();
        Random random = new Random();
        int index = random.nextInt(wheelSize());
        return getSymbolAtindex(index);
    }

    public int getCurrentIndex(){
        for (int i =0; i< getWheel().size(); i++){
            if (getWheel().get(i).getValue() == this.symbol.getValue()){
                return i;
            }
        }
        return -2;
    }

    public Symbol getSymbolAtindex(int index){
        return getWheel().get(index);
    }

    private int wheelSize() {
        return this.wheel.size();
    }

    public void setSymbol(Symbol symbol){
        this.symbol = symbol;
    }

    public void spinWheel(){
        if(this.hold == 0) {
            System.out.println("Spinning!");
            Random rand = new Random();
            Random random = new Random();
            int index = random.nextInt(wheelSize());
            setSymbol(getSymbolAtindex(index));
        }else{
            System.out.println("Holding!");
        }
    }

    public void turnHoldOn(){
        this.hold = 1;
    }

    public void turnHoldOff(){
        this.hold = 0;
    }

    public void nudge(){
        int index = getCurrentIndex() + 1;
        if(index > wheelSize() - 1){
            index = 0;
        }
        setSymbol(getSymbolAtindex(index));
    }


}
