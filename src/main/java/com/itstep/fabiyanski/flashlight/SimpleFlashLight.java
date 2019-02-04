package com.itstep.fabiyanski.flashlight;

import com.itstep.fabiyanski.battery.SomeBattery;
import com.itstep.fabiyanski.light.ALight;

public class SimpleFlashLight implements AFlashLight {
    public SomeBattery battery;
    public ALight light;
    public boolean isTurnedOn;

    public SimpleFlashLight() {
    }

    public SimpleFlashLight(SomeBattery battery, ALight light) {
        this.battery = battery;
        this.light = light;
        this.isTurnedOn = false;
    }

    public boolean turnOn() {
        if (isTurnedOn == false && battery.giveChargeAbility(light.chargesToTurnOn())) {
            isTurnedOn = true;
            battery.setCurrentCharge(battery.getCurrentCharge() - light.chargesToTurnOn());
        }
        return isTurnedOn;
    }

    public void turnOff() {
        if (isTurnedOn) isTurnedOn = false;
    }
}
