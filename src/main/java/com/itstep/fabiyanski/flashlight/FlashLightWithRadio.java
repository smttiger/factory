package com.itstep.fabiyanski.flashlight;

import com.itstep.fabiyanski.light.ALight;
import com.itstep.fabiyanski.battery.TheAccumulator;

import static com.itstep.fabiyanski.radio.OneStationAccRadio.RADIO_TURN_ON_ENERGY;

public class FlashLightWithRadio extends TwoAccFlashLight implements AFlashLightWithRadio {
    public boolean isRadioTurnedOn;

    public FlashLightWithRadio(TheAccumulator accumulator1, TheAccumulator accumulator2, ALight light) {
        super(accumulator1, accumulator2, light);
        this.isRadioTurnedOn = false;
    }

    public boolean turnOnRadio() {
        if (isRadioTurnedOn == false && accumulator.giveChargeAbility((RADIO_TURN_ON_ENERGY / 2)) && secondAccumulator.giveChargeAbility((RADIO_TURN_ON_ENERGY / 2))) {
            isRadioTurnedOn = true;
            accumulator.setCurrentCharge((accumulator.getCurrentCharge() - (RADIO_TURN_ON_ENERGY / 2)));
            secondAccumulator.setCurrentCharge((secondAccumulator.getCurrentCharge() - (RADIO_TURN_ON_ENERGY / 2)));
        }
        return isRadioTurnedOn;
    }

    public void turnOffRadio() {
        if (isRadioTurnedOn) isRadioTurnedOn = false;
    }
}
