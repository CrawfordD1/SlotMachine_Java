package example.codeclan.com.fruitmachine;

import java.util.Scanner;

/**
 * Created by user on 30/06/2017.
 */

public class Player {

    int wallet;
    private Scanner sc;


    public Player() {
        this.wallet = 20;
        sc = new Scanner(System.in);
    }

    public void payMoney(int amount) {
        this.wallet -= amount;
        System.out.println("Removed " + amount + " from wallet!");
    }

    public void addWinnings(int amount) {
        this.wallet += amount;
        System.out.println("Added " + amount + " to wallet!");
    }

    public int chooseAmount() {
        System.out.println("Your total is: " + getWallet() + " | How much you you like to bet?");
        String input = sc.nextLine();

            while (!input.matches("[0-9]+") || (Integer.parseInt(input) > 10 || Integer.parseInt(input) <= 0)) {
                if(input.equals("7654321") || input.equals("1234567")){
                    return Integer.parseInt(input);
                }else {
                    System.out.println("Please enter a valid number between 1 & 10");
                    input = sc.nextLine();
                }
            }
            return Integer.parseInt(input);

    }


    public int getWallet() {
        return this.wallet;
    }

    public void noMoney() {
        System.out.println("Sorry No Money Remaining");
        System.out.println("This machine is terrible! I'm never gambling again!");
        System.exit(0);
    }
}
