package com.itstep.fabiyanski.flashlight;

import com.itstep.fabiyanski.battery.TheAccumulator;
import com.itstep.fabiyanski.light.ALight;

public class ThreeAccLedFlashLight extends TwoAccFlashLight {
    public TheAccumulator thirdAccumulator;

    public ThreeAccLedFlashLight(TheAccumulator accumulator1, TheAccumulator accumulator2, TheAccumulator accumulator3, ALight light) {
        super(accumulator1, accumulator2, light);
        this.thirdAccumulator = accumulator3;
    }

    public TheAccumulator getThirdAccumulator() {
        return thirdAccumulator;
    }

    // предполагается, что все 3 аккумулятора одинаковые
    public boolean turnOn() {
        if (isTurnedOn == false && accumulator.giveChargeAbility((light.chargesToTurnOn() / 3))) {
            isTurnedOn = true;
            accumulator.setCurrentCharge(accumulator.getCurrentCharge() - (light.chargesToTurnOn() / 3));
            secondAccumulator.setCurrentCharge(accumulator.getCurrentCharge());
            thirdAccumulator.setCurrentCharge(accumulator.getCurrentCharge());
        }
        return isTurnedOn;
    }

    public void showCurrentAccumulatorCharge() {
        System.out.println("Current charge=" + (accumulator.getCurrentCharge() * 3));
    }
}
