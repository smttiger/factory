package com.itstep.fabiyanski;

import com.itstep.fabiyanski.battery.TheAccumulator;
import com.itstep.fabiyanski.flashlight.AccumulatorFlashLight;
import com.itstep.fabiyanski.light.IncandecsentLamp;
import org.junit.Assert;
import org.junit.Test;

public class AccumulatorFlashLightTest {
    private FlashLightFactory factory = new FlashLightFactory();
    private IncandecsentLamp light = new IncandecsentLamp();

    @Test
    public void AccumulatorFlashlightTurnOnTest() {
        TheAccumulator accumulator = new TheAccumulator();
        AccumulatorFlashLight flashLight = factory.createAccumulatorFlashLight(accumulator, light);
        for (int i = 0; i < 70; i++) {
            Assert.assertTrue(flashLight.turnOn());
            flashLight.turnOff();
        }
    }

    @Test
    public void AccumulatorFlashlightShowCurrentChargeTest() {
        TheAccumulator accumulator = new TheAccumulator();
        AccumulatorFlashLight flashLight = factory.createAccumulatorFlashLight(accumulator, light);
        for (int i = 0; i < 69; i++) {
            Assert.assertTrue(flashLight.turnOn());
            flashLight.turnOff();
        }
        flashLight.showCurrentAccumulatorCharge();
        Assert.assertTrue(flashLight.accumulator.getCurrentCharge() == 1);
    }

    @Test
    public void AccumulatorRechargeTest() {
        TheAccumulator accumulator = new TheAccumulator();
        AccumulatorFlashLight flashLight = factory.createAccumulatorFlashLight(accumulator, light);
        for (int i = 0; i < 10; i++) {
            Assert.assertTrue(flashLight.turnOn());
            flashLight.turnOff();
        }
        flashLight.getAccumulator().recharge();
        Assert.assertTrue(flashLight.accumulator.getCurrentCharge() == 70);
    }
}

