package com.itstep.fabiyanski.radio;

import com.itstep.fabiyanski.battery.SomeBattery;


public class OneStationBattRadio extends OneStationAccRadio implements Radio {

    public OneStationBattRadio(SomeBattery battery) {
        this.accumulator = null;
        this.light = null;
        this.isTurnedOn = false;
        this.battery = battery;
    }

    public boolean turnOn() {
        if (isTurnedOn == false && battery.giveChargeAbility(RADIO_TURN_ON_ENERGY)) {
            isTurnedOn = true;
            battery.setCurrentCharge(battery.getCurrentCharge() - RADIO_TURN_ON_ENERGY);
        }
        return isTurnedOn;
    }
}
