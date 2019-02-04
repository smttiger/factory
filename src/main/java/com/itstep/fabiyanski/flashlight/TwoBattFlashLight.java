package com.itstep.fabiyanski.flashlight;

import com.itstep.fabiyanski.battery.SomeBattery;
import com.itstep.fabiyanski.light.ALight;

public class TwoBattFlashLight extends SimpleFlashLight {
    private SomeBattery secondBattery;

    public TwoBattFlashLight(SomeBattery battery1, SomeBattery battery2, ALight light) {
        super(battery1, light);
        this.secondBattery = battery2;
    }

    public boolean turnOn() {
        if (isTurnedOn == false && battery.giveChargeAbility((light.chargesToTurnOn() / 2)) && secondBattery.giveChargeAbility((light.chargesToTurnOn() / 2))) {
            isTurnedOn = true;
            battery.setCurrentCharge(battery.getCurrentCharge() - (light.chargesToTurnOn() / 2));
            secondBattery.setCurrentCharge(secondBattery.getCurrentCharge() - (light.chargesToTurnOn() / 2));
        }
        return isTurnedOn;
    }
}
