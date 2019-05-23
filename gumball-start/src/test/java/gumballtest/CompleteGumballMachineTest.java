package gumballtest;
import static org.junit.Assert.*;

import com.clickchain.gumball.GumballMachine;
import com.clickchain.gumball.Messages;
import org.junit.*;

public class CompleteGumballMachineTest {

    private TestDevice device = new TestDevice();
    private GumballMachine gumballMachine;

    @Before
    public void setup() {
        gumballMachine = new GumballMachine(device);
    }

    @Test
    public void initialConditionsEmptyMachineShouldShowSoldOut() {
        assertDisplayMessage(Messages.SO_START);
    }
    // Out of Gumballs
    @Test
    public void insertQuarterOnEmptyMachineShouldDisplayEmpty() {
        gumballMachine.insertQuarter();
        assertDisplayMessage(Messages.SO_QUART);
    }
    @Test
    public void insertQuarterOnEmptyMachineShouldReleaseQuarter() {
        gumballMachine.insertQuarter();
        assertTrue(device.hasEjected());
    }

    @Test
    public void ejectQuarterOnEmptyMachineShouldDisplayEmpty() {
        gumballMachine.ejectQuarter();
        assertDisplayMessage(Messages.SO_EJECT);
    }

    @Test // Jase's test
    public void autoEjectingQuarterOnEmptyMachineAlsoDecrementsBalance() {
        gumballMachine.insertQuarter();
        gumballMachine.ejectQuarter();
        assertEquals(Messages.SO_EJECT, device.getLine());
    }

    @Test
    public void turnCrankOnEmptyMachineShouldDisplayNoGumballs() {
        gumballMachine.turnCrank();
        assertDisplayMessage(Messages.SO_CRANK);
    }

    @Test
    public void takeGumballOnEmptyMachineShouldDisplayNoGumballs() {
        gumballMachine.takeGumball();
        assertDisplayMessage(Messages.SO_TAKE);
    }


    // No Quarter State
//    @Test
//    public void fullMachineAtStartShouldShowMarketing() {
//        refillMachine();
//        assertDisplayMessage(Messages.NQ_START);
//    }
    @Test
    public void fullMachineInsertQuarterShouldDisplayQuarterMessage() {
        refillMachine();
        gumballMachine.insertQuarter();
        assertDisplayMessage(Messages.NQ_QUART);
    }

    @Test
    public void fullMachineEjectQuarterShouldDisplayNoQuarterEjectMessage() {
        refillMachine();
        gumballMachine.ejectQuarter();
        assertDisplayMessage(Messages.NQ_EJECT);
    }

    @Test
    public void fullMachineEjectQuarterShouldNotEjectQuarter() {
        refillMachine();
        gumballMachine.ejectQuarter();
        assertFalse(device.hasEjected());
    }

    @Test
    public void fullMachineTurnCrankShouldDisplayNoQuarterCrankMessage() {
        refillMachine();
        gumballMachine.turnCrank();
        assertDisplayMessage(Messages.NQ_CRANK);
    }

    @Test
    public void fullMachineTakeGumballShouldDisplayNoQuarterTakeMessage() {
        refillMachine();
        gumballMachine.takeGumball();
        assertDisplayMessage(Messages.NQ_TAKE);
    }

    // Has Quarter State
    @Test
    public void fullMachineInsertQuarterShouldDisplayHasQuarterStartMessage() {
        hasQuarter();
        assertDisplayMessage(Messages.HQ_START);
    }

    @Test
    public void insertQuarterShouldDisplayHasQuarter() {
        hasQuarter();
        gumballMachine.insertQuarter();
        assertDisplayMessage(Messages.HQ_QUART);
    }

    @Test
    public void insertQuarterShouldEjectQuarter() {
        hasQuarter();
        gumballMachine.insertQuarter();
        assertTrue(device.hasEjected());
    }

    @Test
    public void ejectQuarterShouldDisplayHasQuarter() {
        hasQuarter();
        gumballMachine.ejectQuarter();
        assertDisplayMessage(Messages.HQ_EJECT);
    }

    @Test
    public void turnCrankShouldDisplayGumball() {
        hasQuarter();
        gumballMachine.turnCrank();
        assertDisplayMessage(Messages.HQ_CRANK);
    }

    @Test
    public void turnCrankShouldDispenseGumball() {
        hasQuarter();
        gumballMachine.turnCrank();
        assertEquals(49, device.getCount());
    }

    @Test
    public void takeGumballShouldDisplayGumballMessage() {
        refillMachine();
        sellGumball();
        assertDisplayMessage(Messages.NQ_START);
    }


    // Sell Out
//    @Test
//    public void sellingOutShouldDisplaySoldOut() {
//        sellOutMachine();
//        assertDisplayMessage(Messages.SO_START);
//    }

    @Test
    public void sellingOutShouldReturnQuarter() {
        sellOutMachine();
        //////////////////////////////
        assertTrue(device.hasEjected());
    }

    // Error checks
    @Test
    public void turningCrankTwiceShouldDisplayCrank() {
        refillMachine();
        sellGumball();
        gumballMachine.turnCrank();//////////////////////////////////////////////
        assertDisplayMessage(Messages.SL_CRANK);
    }

    @Test
    public void insertEjectShouldEject() {
        refillMachine();
        cycleQuarter();
        assertTrue(device.hasEjected());
    }

    @Test
    public void insertEjectInsertShouldNotHaveQuarter() {
        refillMachine();
        cycleQuarter();
        gumballMachine.insertQuarter();
        assertDisplayMessage(Messages.NQ_QUART);
    }

    @Test
    public void refillingMidCycleShouldNotEffectHasQuarter() {
        refillMachine();
        gumballMachine.insertQuarter();
        refillMachine();
        assertDisplayMessage(Messages.HQ_START);
    }
//my tests
	@Test
	public void whenGumBallSoldShouldShowAGumBallIsOnItsWay() {
		hasQuarter();
		gumballMachine.turnCrank();
		assertDisplayMessage(Messages.SL_START);
	}
		@Test
		public void whenGumBallSoldAnsUserInsertQuarterShouldShowWeAlreadyGivingYouAGumBall(){
			hasQuarter();
			gumballMachine.turnCrank();
			gumballMachine.insertQuarter();
			assertDisplayMessage(Messages.SL_QUART);

		}
	@Test
	public void whenGumBallSoldAnsUserInsertQuarterShouldShowWeAlreadyGivingYouAGumBallAndReleaseQuarter(){
		hasQuarter();
		gumballMachine.turnCrank();
		gumballMachine.insertQuarter();
		assertTrue(device.hasEjected());
	}
	@Test
	public void whenGumBallSoldAnsUserEjectQuarterShouldShowSorryYouAlreadyTurnedTheCrank(){
		hasQuarter();
		gumballMachine.turnCrank();
		gumballMachine.ejectQuarter();
		assertDisplayMessage(Messages.SL_EJECT);

	}
	@Test
	public void whenGumBallIsSoldAndTurnCrankAgainShoulShowTurningAgainShouldNotGetYouAnotherGumBall(){
		hasQuarter();
		gumballMachine.turnCrank();
		gumballMachine.turnCrank();
		assertDisplayMessage(Messages.SL_CRANK);
	}
    // Helper methods

    private void assertDisplayMessage(String message) {
        assertEquals(message, device.getLine());
    }

    private void refillMachine() {
        device.addGumballs(50);
        gumballMachine.refill(50);
    }

    private void hasQuarter() {
        refillMachine();
        gumballMachine.insertQuarter();
    }

    private void sellGumball() {
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.takeGumball();

    }

    private void cycleQuarter() {
        gumballMachine.insertQuarter();
        gumballMachine.ejectQuarter();
    }

    @Test
    public void sellOutMachine() {
      refillMachine();
        for(int i = 0; i < 50; i++){
            sellGumball();
        }
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
    }
}

