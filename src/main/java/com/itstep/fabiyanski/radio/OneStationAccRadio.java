package com.itstep.fabiyanski.radio;

import com.itstep.fabiyanski.battery.TheAccumulator;
import com.itstep.fabiyanski.flashlight.AccumulatorFlashLight;


public class OneStationAccRadio extends AccumulatorFlashLight implements Radio {
    public static final double RADIO_TURN_ON_ENERGY = 0.67;

    public OneStationAccRadio() {
    }

    public OneStationAccRadio(TheAccumulator accumulator) {
        this.accumulator = accumulator;
        this.light = null;
        this.isTurnedOn = false;
        this.battery = null;
    }

    public boolean turnOn() {
        if (isTurnedOn == false && accumulator.giveChargeAbility(RADIO_TURN_ON_ENERGY)) {
            isTurnedOn = true;
            accumulator.setCurrentCharge(accumulator.getCurrentCharge() - RADIO_TURN_ON_ENERGY);
        }
        return isTurnedOn;
    }
}
