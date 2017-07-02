package example.codeclan.com.fruitmachine;

/**
 * Created by user on 30/06/2017.
 */

public class CombinationLogic {

    private WheelSpinner wheel1;
    private WheelSpinner wheel2;
    private WheelSpinner wheel3;

    public CombinationLogic(WheelSpinner wheel1, WheelSpinner wheel2, WheelSpinner wheel3){
        this.wheel1 = wheel1;
        this.wheel2 = wheel2;
        this.wheel3 = wheel3;
    }

    public int getWinningAmount(){
        int result = 0;
        if(wheel1.getSymbol().getValue() == wheel2.getSymbol().getValue() && wheel2.getSymbol().getValue() == wheel3.getSymbol().getValue()){
            result = wheel1.getSymbol().getValue();
        }else{
            result = 0;
        }
        return result;
    }

}

