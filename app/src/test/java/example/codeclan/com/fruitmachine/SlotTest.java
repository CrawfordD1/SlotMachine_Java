package example.codeclan.com.fruitmachine;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.*;
import example.codeclan.com.fruitmachine.behaviours.Symbols;
import static org.mockito.Mockito.*;

/**
 * Created by user on 30/06/2017.
 */

public class SlotTest {

    WheelSpinner spyWheel;
    WheelSpinner wheel1;
    WheelSpinner wheel2;
    WheelSpinner wheel3;
    CombinationLogic combinationLogic;

    @Before
    public void before() throws Exception {
        wheel1 = new WheelSpinner(1);
        wheel2 = new WheelSpinner(2);
        wheel3 = new WheelSpinner(3);
        spyWheel = Mockito.spy(wheel1);
        combinationLogic = new CombinationLogic(wheel1, wheel2, wheel3);
    }

    @Test
    public void testGetSymbolfromSpinner() throws Exception {
        spyWheel.setSymbol(new Symbol(Symbols.JACKPOT));
        assertEquals(20, spyWheel.getSymbol().getValue() );
    }

    @Test
    public void testNudge() throws Exception {
        wheel1.setSymbol(new Symbol(Symbols.AUBERGINE));
        wheel1.nudge();
        assertEquals(2, wheel1.getSymbol().getValue());
    }

    @Test
    public void testWinner() throws Exception {
        wheel1.setSymbol(new Symbol(Symbols.JACKPOT));
        wheel2.setSymbol(new Symbol(Symbols.JACKPOT));
        wheel3.setSymbol(new Symbol(Symbols.JACKPOT));
        assertEquals(20, combinationLogic.getWinningAmount());
    }

    @Test
    public void testLoser() throws Exception {
        wheel1.setSymbol(new Symbol(Symbols.JACKPOT));
        wheel2.setSymbol(new Symbol(Symbols.DIAMOND));
        wheel3.setSymbol(new Symbol(Symbols.JACKPOT));
        assertEquals(0, combinationLogic.getWinningAmount());
    }

    @Test
    public void testNudgeWinner() throws Exception {
        wheel1.setSymbol(new Symbol(Symbols.DIAMOND));
        wheel2.setSymbol(new Symbol(Symbols.JACKPOT));
        wheel3.setSymbol(new Symbol(Symbols.JACKPOT));
        wheel1.nudge();
        assertEquals(20, combinationLogic.getWinningAmount());
    }
}
