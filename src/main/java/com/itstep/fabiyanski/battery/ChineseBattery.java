package com.itstep.fabiyanski.battery;

public class ChineseBattery extends SomeBattery {
    private static final int DEFAULT_CHINESE_CHARGE = 5;

    public ChineseBattery() {
        setCurrentCharge(DEFAULT_CHINESE_CHARGE);
    }
}
