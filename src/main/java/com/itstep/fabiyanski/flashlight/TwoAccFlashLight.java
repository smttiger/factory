package com.itstep.fabiyanski.flashlight;

import com.itstep.fabiyanski.battery.TheAccumulator;
import com.itstep.fabiyanski.light.ALight;

public class TwoAccFlashLight extends AccumulatorFlashLight {
    public TheAccumulator secondAccumulator;

    public TwoAccFlashLight(TheAccumulator accumulator1, TheAccumulator accumulator2, ALight light) {
        super(accumulator1, light);
        this.secondAccumulator = accumulator2;
    }

    public TheAccumulator getSecondAccumulator() {
        return secondAccumulator;
    }

    // предполагается, что оба аккумулятора одинаковые
    public boolean turnOn() {
        if (isTurnedOn == false && accumulator.giveChargeAbility((light.chargesToTurnOn() / 2))) {
            isTurnedOn = true;
            accumulator.setCurrentCharge(accumulator.getCurrentCharge() - (light.chargesToTurnOn() / 2));
            secondAccumulator.setCurrentCharge(accumulator.getCurrentCharge());
        }
        return isTurnedOn;
    }

    public void showCurrentAccumulatorCharge() {
        System.out.println("Current charge=" + (accumulator.getCurrentCharge() * 2));
    }
}

