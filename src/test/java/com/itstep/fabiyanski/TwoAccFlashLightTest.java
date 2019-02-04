package com.itstep.fabiyanski;

import com.itstep.fabiyanski.battery.TheAccumulator;
import com.itstep.fabiyanski.flashlight.TwoAccFlashLight;
import com.itstep.fabiyanski.light.IncandecsentLamp;
import org.junit.Assert;
import org.junit.Test;

public class TwoAccFlashLightTest {
    private FlashLightFactory factory = new FlashLightFactory();
    private IncandecsentLamp light = new IncandecsentLamp();

    @Test
    public void TwoAccFlashlightTurnOnTest() {
        TheAccumulator accumulator1 = new TheAccumulator();
        TheAccumulator accumulator2 = new TheAccumulator();
        TwoAccFlashLight flashLight = factory.createTwoAccFlashLight(accumulator1, accumulator2, light);
        for (int i = 0; i < 140; i++) {
            Assert.assertTrue(flashLight.turnOn());
            flashLight.turnOff();
        }
    }

    @Test
    public void TwoAccFlashlightShowCurrentChargeTest() {
        TheAccumulator accumulator1 = new TheAccumulator();
        TheAccumulator accumulator2 = new TheAccumulator();
        TwoAccFlashLight flashLight = factory.createTwoAccFlashLight(accumulator1, accumulator2, light);
        for (int i = 0; i < 138; i++) {
            Assert.assertTrue(flashLight.turnOn());
            flashLight.turnOff();
        }
        flashLight.showCurrentAccumulatorCharge();
        Assert.assertTrue((flashLight.accumulator.getCurrentCharge() + flashLight.secondAccumulator.getCurrentCharge()) == 2);
    }

    @Test
    public void AccumulatorRechargeTest() {
        TheAccumulator accumulator1 = new TheAccumulator();
        TheAccumulator accumulator2 = new TheAccumulator();
        TwoAccFlashLight flashLight = factory.createTwoAccFlashLight(accumulator1, accumulator2, light);
        for (int i = 0; i < 10; i++) {
            Assert.assertTrue(flashLight.turnOn());
            flashLight.turnOff();
        }
        flashLight.getAccumulator().recharge();
        flashLight.getSecondAccumulator().recharge();
        Assert.assertTrue(flashLight.accumulator.getCurrentCharge() == 70);
        Assert.assertTrue(flashLight.secondAccumulator.getCurrentCharge() == 70);
    }
}
