package com.itstep.fabiyanski.battery;

public class DuracellBattery extends SomeBattery {
    private static final int DEFAULT_DURACELL_CHARGE = 50;

    public DuracellBattery() {
        setCurrentCharge(DEFAULT_DURACELL_CHARGE);
    }
}
