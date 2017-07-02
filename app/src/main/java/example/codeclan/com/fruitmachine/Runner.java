package example.codeclan.com.fruitmachine;

/**
 * Created by user on 30/06/2017.
 */

public class Runner {

    Player player;

    public static void main(String[] args) {
        WheelSpinner wheel1 = new WheelSpinner(1);
        WheelSpinner wheel2 = new WheelSpinner(2);
        WheelSpinner wheel3 = new WheelSpinner(3);
        CombinationLogic combinationLogic = new CombinationLogic(wheel1, wheel2, wheel3);
        FruitMachineBank bank = new FruitMachineBank();
        Player player = new Player();
        GameLogic game = new GameLogic(player, bank);

        System.out.println("Welcome to Slotsville");
        while (player.getWallet() >= 0) {
            playGame(wheel1, wheel2, wheel3, player, combinationLogic, game);
        }
        System.exit(0);
    }

    public static void playGame(WheelSpinner wheel1, WheelSpinner wheel2, WheelSpinner wheel3, Player player, CombinationLogic combinationLogic, GameLogic game) {
        game.resetWheels(wheel1, wheel2, wheel3);
        System.out.println("-------------------------------");
        System.out.println();
        System.out.println("2 Spins Remaining");
        int bet = player.chooseAmount();
        if (bet == 7654321) {
            bet = 1;
            game.playerPayMoney(bet);
            wheel1.setSymbol(wheel1.getSymbolAtindex(6));
            wheel2.setSymbol(wheel2.getSymbolAtindex(6));
            wheel3.setSymbol(wheel3.getSymbolAtindex(6));
        }else if(bet == 1234567){
            System.out.println("Machine Total: " + game.getBank());
            playGame(wheel1, wheel2, wheel3, player, combinationLogic, game);
        }else{
            game.playerPayMoney(bet);
            wheel1.spinWheel();
            wheel2.spinWheel();
            wheel3.spinWheel();
        }
        System.out.println("Result: " + wheel1.getSymbol() + " | " + wheel2.getSymbol() + " | " + wheel3.getSymbol());

        int winnings = combinationLogic.getWinningAmount();
        boolean gameWon = game.checkWinner(winnings, bet);
        if (gameWon) {
            playGame(wheel1, wheel2, wheel3, player, combinationLogic, game);
        }
        game.nudgeChoice(wheel1, wheel2, wheel3);
        System.out.println("Result: " + wheel1.getSymbol() + " | " + wheel2.getSymbol() + " | " + wheel3.getSymbol());

        winnings = combinationLogic.getWinningAmount();
        gameWon = game.checkWinner(winnings, bet);
        if (gameWon) {
            playGame(wheel1, wheel2, wheel3, player, combinationLogic, game);
        }
        System.out.println("1 Spin remaining");
        wheel1.spinWheel();
        wheel2.spinWheel();
        wheel3.spinWheel();
        System.out.println("Result: " + wheel1.getSymbol() + " | " + wheel2.getSymbol() + " | " + wheel3.getSymbol());

        winnings = combinationLogic.getWinningAmount();
        game.checkWinner(winnings, bet);

        game.resetWheels(wheel1, wheel2, wheel3);

    }

}
