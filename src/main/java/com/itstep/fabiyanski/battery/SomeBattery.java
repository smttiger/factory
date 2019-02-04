package com.itstep.fabiyanski.battery;

public class SomeBattery implements ABattery {

    private double currentCharge;

    public double getCurrentCharge() {
        return currentCharge;
    }

    public void setCurrentCharge(double currentCharge) {
        this.currentCharge = currentCharge;
    }

    public boolean giveChargeAbility(double neededCharge) {
        boolean chargeAbility = false;
        if (getCurrentCharge() >= neededCharge) {
            chargeAbility = true;
        }
        return chargeAbility;
    }
}
