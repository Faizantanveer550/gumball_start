//package gumballtest;
//
//import static org.junit.Assert.*;
//
//import com.clickchain.gumball.GumballMachine;
//import com.clickchain.gumball.Messages;
//import org.junit.*;
//
//public class GumballMachineTest {
//	private TestDevice testDevice = new TestDevice();
//	private GumballMachine gumballMachine;
//
//	@Before
//	public void setup() {
//		gumballMachine = new GumballMachine(testDevice);
//	}
//
//    @Test
//	public void initialConditionsEmptyMachineShouldShowSoldOut() {
//		Assert.assertEquals(Messages.SO_START, testDevice.getLine());
//	}
//	@Test
//	public void WhenMachineIsEmptyInsertQuarterShouldShowPickYourQuarter(){
//		gumballMachine.insertQuarter();
//		assertEquals(Messages.SO_QUART,testDevice.getLine());
//	}
//	@Test
//    public void WhemUserNotInsertQuarterAndTryToEjectQuarterShouldShowNotSlotMachine(){
//        gumballMachine.ejectQuarter();
//	    assertEquals(Messages.SO_EJECT, testDevice.getLine());
//    }
//    @Test
//    public void WhemUserInsertQuarterAndTurnCrankAndMachineIsSoldOutShouldShowThereIsNoGumball(){
//		//gumballMachine.insertQuarter();
//        gumballMachine.turnCrank();
//        assertEquals(Messages.SO_CRANK, testDevice.getLine());
//    }
//	@Test
//	public void WhenMachineIsEmptyInsertQuarterAndTryToTakeGumballShouldShowIhaveNotGumball(){
//		gumballMachine.insertQuarter();
//		gumballMachine.takeGumball();
//		assertEquals(Messages.SO_TAKE,testDevice.getLine());
//	}
////
////	//gumball machine has a quarter
////
//	@Test
//	public void WhenMachineHasQuarterInsertAnOtherQuarterShouldShowCantInsertAnotherQuarter(){
//		gumballMachine.refill();
//		gumballMachine.insertQuarter();
//		gumballMachine.insertQuarter();
//		assertEquals(Messages.HQ_QUART,testDevice.getLine());
//	}
//	@Test
//	public void WhenMachineHasQuarterEjectQuarterShouldShowPickYourQuarter(){
//		gumballMachine.refill();
//		gumballMachine.insertQuarter();
//		gumballMachine.ejectQuarter();
//		assertEquals(Messages.HQ_EJECT,testDevice.getLine());
//	}
//	@Test
//	public void WhenMachineHasQuarterTurnCrankShouldShowGumballOnItsWay(){
//		gumballMachine.refill();
//		gumballMachine.insertQuarter();
//		gumballMachine.turnCrank();
//		assertEquals(Messages.HQ_CRANK,testDevice.getLine());
//	}
//	@Test
//	public void WhenMachineHasQuarterTakeGumballShouldShowQuarterForGumball(){
//		gumballMachine.refill();
//		gumballMachine.insertQuarter();
//		gumballMachine.takeGumball();
//		assertEquals(Messages.HQ_TAKE,testDevice.getLine());
//	}
////	//GumballMachineNoQuarter
////
//	@Test
//	public void WhenMachineHasNoQuarterUserInsertQuarterShouldShowTurnCrankForGumball(){
//		gumballMachine.refill();
//		gumballMachine.insertQuarter();
//		assertEquals(Messages.NQ_QUART,testDevice.getLine());
//	}
//	@Test
//	public void WhenMachineHasNoQuarterUserEjectQuarterShouldShowYouHaveNotInsertedQuarterYet(){
//		gumballMachine.refill();
//		gumballMachine.ejectQuarter();
//		assertEquals(Messages.NQ_EJECT,testDevice.getLine());
//	}
//	@Test
//	public void WhenMachineHasNoQuarterUserTurnCrankShouldShowYouNeedToPayfirst(){
//		gumballMachine.refill();
//		gumballMachine.turnCrank();
//		assertEquals(Messages.NQ_CRANK,testDevice.getLine());
//	}
//	@Test
//	public void WhenMachineHasNoQuarterUserTakeGumballShouldShowComeBackAfterPayDay(){
//		gumballMachine.refill();
//		gumballMachine.takeGumball();
//		assertEquals(Messages.NQ_TAKE,testDevice.getLine());
//	}
////
////	//Gumball Sold
//	@Test
//	public void WhenGumballSoldUserInsertQuarterShouldShowPleaseWaitYouAlreadyTakeGumball(){
//		gumballMachine.refill();
//		gumballMachine.insertQuarter();
//		gumballMachine.turnCrank();
//		gumballMachine.insertQuarter();
//		assertTrue(testDevice.hasEjected());
//
//	}
//	@Test
//	public void WhenGumballSoldUserEjectQuarterShouldShowYouAlreadyTurnedCrank(){
//			gumballMachine.refill();
//			gumballMachine.insertQuarter();
//			gumballMachine.turnCrank();
//			gumballMachine.ejectQuarter();
//			assertEquals(Messages.SL_EJECT,testDevice.getLine());
//	}
//
//	@Test
//	public void WhenGumballSoldUserTurnCrankShouldShowDontGiveYouAnotherGumball(){
//			gumballMachine.refill();
//			gumballMachine.insertQuarter();
//			gumballMachine.turnCrank();
//			gumballMachine.turnCrank();
//			assertEquals(Messages.SL_CRANK,testDevice.getLine());
//	}
//
//	@Test
//	public void WhenGumballSoldUserTakeGumballShouldShowQuarterForAGumball(){
//		gumballMachine.refill();
//		gumballMachine.insertQuarter();
//		gumballMachine.turnCrank();
//		gumballMachine.takeGumball();
//		assertEquals(Messages.SL_TAKE,testDevice.getLine());
//	}
////	private void refill(){
////		int num = 50 - testDevice.getCount();
////		testDevice.addGumballs(num);
////	}
//}
