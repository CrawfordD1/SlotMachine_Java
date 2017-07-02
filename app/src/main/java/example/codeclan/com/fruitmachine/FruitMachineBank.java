package example.codeclan.com.fruitmachine;

/**
 * Created by user on 30/06/2017.
 */

public class FruitMachineBank {

    private int bank;

    public FruitMachineBank(){
        this.bank = 1000;
    }

    public void add(int amount) {
        this.bank += amount;
    }

    public void minus(int amount) {
        this.bank -= amount;
    }

    public boolean almostEmpty(){
        return this.bank >= 30;
    }

    public int getMoney() {
        return this.bank;
    }
}
