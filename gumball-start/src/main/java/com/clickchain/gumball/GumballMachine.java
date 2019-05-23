package com.clickchain.gumball;
import gumballtest.*;

public class GumballMachine{
    GumballHardwareDevice device;
    private int quarter = 0;
    private int gumballCount = 0;
    public GumballMachine(GumballHardwareDevice device) {
        this.device = device;
        device.displayLine(Messages.SO_START);
    }


    public void insertQuarter(){
        quarter++;
       // System.out.println(quarter);
        if(quarter > getNumOfQuarter() && gumballCount == 0){
            device.displayLine(Messages.SO_QUART);
            quarter--;
            device.releaseQuarter();
        }
        else if(quarter > getNumOfQuarter() && gumballCount > 0 && quarter > getNumOfQuarter() + 1){
            device.displayLine(Messages.HQ_QUART);
            quarter--;
            device.releaseQuarter();
        }
        else if(quarter > getNumOfQuarter() && gumballCount > 0 && gumballCount < 50){
            device.displayLine(Messages.SL_QUART);
            quarter--;
            device.releaseQuarter();
        }
        else if(quarter > getNumOfQuarter() && gumballCount > 0){
            device.displayLine(Messages.NQ_QUART);
        }
    }

    public void ejectQuarter(){
        if(quarter <= getNumOfQuarter() && gumballCount == 0){
            device.displayLine(Messages.SO_EJECT);
        }
        else if(quarter == 0 && gumballCount > 0){
            device.displayLine(Messages.NQ_EJECT);
        }
        else if(quarter > getNumOfQuarter() && gumballCount > 0){
            device.displayLine(Messages.HQ_EJECT);
            quarter--;
            device.releaseQuarter();
        }
        else if(quarter == getNumOfQuarter() && gumballCount < 50){
            device.displayLine(Messages.SL_EJECT);
        }
    }
//
    public void turnCrank(){
        if(quarter >= getNumOfQuarter() && gumballCount == 0){
            device.displayLine(Messages.SO_CRANK);
        }
        else if(quarter == getNumOfQuarter() && gumballCount < 50){
            device.displayLine(Messages.SL_CRANK);
        }
        else if(quarter <= getNumOfQuarter() && gumballCount > 0){
            device.displayLine(Messages.NQ_CRANK);
        }
        else if(quarter > getNumOfQuarter() && gumballCount > 0){
            device.displayLine(Messages.HQ_CRANK);
            device.releaseGumball();
            gumballCount--;
        }
    }

    public void takeGumball(){

        if(quarter >= getNumOfQuarter() && gumballCount == 0){
            device.displayLine(Messages.SO_TAKE);
        }
        else if(quarter == getNumOfQuarter() && gumballCount < 50){
            device.displayLine(Messages.SL_TAKE);
        }
        else if(quarter <= getNumOfQuarter() && gumballCount > 0){
            device.displayLine(Messages.NQ_TAKE);
        }
        else if(quarter > getNumOfQuarter() && gumballCount > 0){
            device.displayLine(Messages.HQ_TAKE);
        }
    }
//
    public void refill(int count){
        if(gumballCount == 0){
            gumballCount = count;
        }
    }

    private int getNumOfQuarter() {
        if(gumballCount > 0) {
            return 50 - gumballCount;
        }
        else{
            return 0;
        }
    }
}
