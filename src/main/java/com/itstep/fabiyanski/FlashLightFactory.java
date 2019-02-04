package com.itstep.fabiyanski;

import com.itstep.fabiyanski.battery.SomeBattery;
import com.itstep.fabiyanski.battery.TheAccumulator;
import com.itstep.fabiyanski.flashlight.*;
import com.itstep.fabiyanski.light.ALight;
import com.itstep.fabiyanski.radio.OneStationAccRadio;
import com.itstep.fabiyanski.radio.OneStationBattRadio;

public class FlashLightFactory implements AFlashLightFactory {

    public SimpleFlashLight createFlashLight(SomeBattery battery, ALight light) {
        return new SimpleFlashLight(battery, light);
    }

    public AccumulatorFlashLight createAccumulatorFlashLight(TheAccumulator accumulator, ALight light) {

        return new AccumulatorFlashLight(accumulator, light);
    }

    public OneStationAccRadio createOneStationAccRadio(TheAccumulator accumulator) {

        return new OneStationAccRadio(accumulator);
    }

    public OneStationBattRadio createOneStationBattRadio(SomeBattery battery) {
        return new OneStationBattRadio(battery);
    }

    public TwoBattFlashLight createTwoBattFlashLight(SomeBattery battery1, SomeBattery battery2, ALight light) {
        return new TwoBattFlashLight(battery1, battery2, light);
    }

    public TwoAccFlashLight createTwoAccFlashLight(TheAccumulator accumulator1, TheAccumulator accumulator2, ALight light) {
        return new TwoAccFlashLight(accumulator1, accumulator2, light);
    }

    public FlashLightWithRadio createFlashLightWithRadio(TheAccumulator accumulator1, TheAccumulator accumulator2, ALight light) {
        return new FlashLightWithRadio(accumulator1, accumulator2, light);
    }

    public ThreeAccLedFlashLight createThreeAccLedFlashLight(TheAccumulator accumulator1, TheAccumulator accumulator2, TheAccumulator accumulator3, ALight light) {
        return new ThreeAccLedFlashLight(accumulator1, accumulator2, accumulator3, light);
    }
}
