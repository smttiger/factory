package com.itstep.fabiyanski.flashlight;

import com.itstep.fabiyanski.battery.TheAccumulator;
import com.itstep.fabiyanski.light.ALight;

public class AccumulatorFlashLight extends SimpleFlashLight implements AccFlashLight {

    public TheAccumulator accumulator;

    public AccumulatorFlashLight() {
    }

    public AccumulatorFlashLight(TheAccumulator accumulator, ALight light) {
        this.accumulator = accumulator;
        this.light = light;
        this.isTurnedOn = false;
        this.battery = null;
    }

    public void showCurrentAccumulatorCharge() {
        System.out.println("Current charge=" + accumulator.getCurrentCharge());
    }

    public TheAccumulator getAccumulator() {
        return accumulator;
    }

    public boolean turnOn() {
        if (isTurnedOn == false && accumulator.giveChargeAbility(light.chargesToTurnOn())) {
            isTurnedOn = true;
            accumulator.setCurrentCharge(accumulator.getCurrentCharge() - light.chargesToTurnOn());
        }
        return isTurnedOn;
    }
}
