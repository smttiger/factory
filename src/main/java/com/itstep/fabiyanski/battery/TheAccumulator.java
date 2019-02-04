package com.itstep.fabiyanski.battery;

public class TheAccumulator extends SomeBattery implements Accumulator {
    private static final int DEFAULT_ACCUMULATOR_CHARGE = 70;


    public TheAccumulator() {
        setCurrentCharge(DEFAULT_ACCUMULATOR_CHARGE);
    }

    public void recharge() {
        setCurrentCharge(DEFAULT_ACCUMULATOR_CHARGE);
    }


}
