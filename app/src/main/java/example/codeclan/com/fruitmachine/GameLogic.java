package example.codeclan.com.fruitmachine;

import java.util.Scanner;

/**
 * Created by user on 30/06/2017.
 */

public class GameLogic {

    Player player;
    FruitMachineBank bank;
    private Scanner sc;


    public GameLogic(Player player, FruitMachineBank bank){
        this.player = player;
        this.bank = bank;
        sc = new Scanner(System.in);

    }

    public int getBank(){
        return this.bank.getMoney();
    }

    public void playerPayMoney(int amount){
        if(player.getWallet() > 0) {
            player.payMoney(amount);
            bank.add(amount);
            System.out.println("Bet added: " + amount + " | " + player.getWallet() + ": remaining");
        }else{
           player.noMoney();
        }
    }

    public void playerWinMoney(int amount){
        player.addWinnings(amount);
        bank.minus(amount);
    }

    public void nudgeChoice(WheelSpinner wheel1, WheelSpinner wheel2, WheelSpinner wheel3) {
        System.out.println("Wheel 1: Would you like to: |1.Hold|2.Nudge|3.Spin Again|");
        String input = sc.nextLine();
        while (!input.matches("[1-3]+")){
            System.out.println("Please enter a valid number between 1 & 3");
            input = sc.nextLine();
        }
        int choice = Integer.parseInt(input);
        switch(choice){
            case 1:
                System.out.println("Wheel 1 Held on " + wheel1.getSymbol());
                wheel1.turnHoldOn();
                break;
            case 2:
                wheel1.nudge();
                System.out.println("Wheel 1 Nudged round to " + wheel1.getSymbol());
                break;
            default:
                break;
        }
//        --------------------
        System.out.println("Wheel 2: Would you like to: |1.Hold|2.Nudge|3.Spin Again|");
        input = sc.nextLine();
        while (!input.matches("[1-3]+")){
            System.out.println("Please enter a valid number between 1 & 3");
            input = sc.nextLine();
        }
        choice = Integer.parseInt(input);
        switch(choice){
            case 1:
                System.out.println("Wheel 2 Held on " + wheel2.getSymbol());
                wheel2.turnHoldOn();
                break;
            case 2:
                wheel2.nudge();
                System.out.println("Wheel 2 Nudged round to " + wheel2.getSymbol());
                break;
            default:
                break;
        }
//        --------------------
        System.out.println("Wheel 3: Would you like to: |1.Hold|2.Nudge|3.Spin Again|");
        input = sc.nextLine();
        while (!input.matches("[1-3]+")){
            System.out.println("Please enter a valid number between 1 & 3");
            input = sc.nextLine();
        }
        choice = Integer.parseInt(input);
        switch(choice){
            case 1:
                System.out.println("Wheel 3 Held on " + wheel3.getSymbol());
                wheel3.turnHoldOn();
                break;
            case 2:
                wheel3.nudge();
                System.out.println("Wheel 3 Nudged round to " + wheel3.getSymbol());
                break;
            default:
                break;
        }
    }

    public void resetWheels(WheelSpinner wheel1, WheelSpinner wheel2, WheelSpinner wheel3){
        wheel1.turnHoldOff();
        wheel2.turnHoldOff();
        wheel3.turnHoldOff();
    }

    public boolean checkWinner(int winnings, int bet) {
        if (winnings > 0) {
            int total = bet * winnings;
            System.out.println("You have won!");
            playerWinMoney(total);
            System.out.println("Wallet total: " + player.getWallet());
            return true;
        } else {
            System.out.println("Sorry, no winner this time");
            return false;
        }
    }
}
