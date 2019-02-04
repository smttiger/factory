package com.itstep.fabiyanski.flashlight;

import com.itstep.fabiyanski.battery.TheAccumulator;

public interface AccFlashLight extends AFlashLight {

    TheAccumulator getAccumulator();

    void showCurrentAccumulatorCharge();
}
