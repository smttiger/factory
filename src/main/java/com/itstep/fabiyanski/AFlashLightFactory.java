package com.itstep.fabiyanski;

import com.itstep.fabiyanski.battery.SomeBattery;
import com.itstep.fabiyanski.battery.TheAccumulator;
import com.itstep.fabiyanski.flashlight.*;
import com.itstep.fabiyanski.light.ALight;
import com.itstep.fabiyanski.radio.OneStationAccRadio;
import com.itstep.fabiyanski.radio.OneStationBattRadio;

public interface AFlashLightFactory {

    SimpleFlashLight createFlashLight(SomeBattery battery, ALight light);

    AccumulatorFlashLight createAccumulatorFlashLight(TheAccumulator accumulator, ALight light);

    OneStationAccRadio createOneStationAccRadio(TheAccumulator accumulator);

    OneStationBattRadio createOneStationBattRadio(SomeBattery battery);

    TwoBattFlashLight createTwoBattFlashLight(SomeBattery battery1, SomeBattery battery2, ALight light);

    TwoAccFlashLight createTwoAccFlashLight(TheAccumulator accumulator1, TheAccumulator accumulator2, ALight light);

    FlashLightWithRadio createFlashLightWithRadio(TheAccumulator accumulator1, TheAccumulator accumulator2, ALight light);

    ThreeAccLedFlashLight createThreeAccLedFlashLight(TheAccumulator accumulator1, TheAccumulator accumulator2, TheAccumulator accumulator3, ALight light);
}
