package com.itstep.fabiyanski;

import com.itstep.fabiyanski.battery.TheAccumulator;
import com.itstep.fabiyanski.flashlight.ThreeAccLedFlashLight;
import com.itstep.fabiyanski.light.LedLamp;
import org.junit.Assert;
import org.junit.Test;

public class ThreeAccLedFlashLightTest {
    private FlashLightFactory factory = new FlashLightFactory();
    private LedLamp light = new LedLamp();

    @Test
    public void ThreeAccLedFlashlightTurnOnTest() {
        TheAccumulator accumulator1 = new TheAccumulator();
        TheAccumulator accumulator2 = new TheAccumulator();
        TheAccumulator accumulator3 = new TheAccumulator();
        ThreeAccLedFlashLight flashLight = factory.createThreeAccLedFlashLight(accumulator1, accumulator2, accumulator3, light);
        for (int i = 0; i < 636; i++) {
            Assert.assertTrue(flashLight.turnOn());
            flashLight.turnOff();
        }
    }

    @Test
    public void ThreeAccLedFlashlightTurnOffTest() {
        TheAccumulator accumulator1 = new TheAccumulator();
        TheAccumulator accumulator2 = new TheAccumulator();
        TheAccumulator accumulator3 = new TheAccumulator();
        ThreeAccLedFlashLight flashLight = factory.createThreeAccLedFlashLight(accumulator1, accumulator2, accumulator3, light);
        Assert.assertTrue(flashLight.turnOn());
        flashLight.turnOff();
        Assert.assertFalse(flashLight.isTurnedOn);
    }

    @Test
    public void ThreeAccLedFlashlightShowCurrentChargeTest() {
        TheAccumulator accumulator1 = new TheAccumulator();
        TheAccumulator accumulator2 = new TheAccumulator();
        TheAccumulator accumulator3 = new TheAccumulator();
        ThreeAccLedFlashLight flashLight = factory.createThreeAccLedFlashLight(accumulator1, accumulator2, accumulator3, light);
        for (int i = 0; i < 200; i++) {
            Assert.assertTrue(flashLight.turnOn());
            flashLight.turnOff();
        }
        flashLight.showCurrentAccumulatorCharge();
        Assert.assertTrue(((int) (flashLight.accumulator.getCurrentCharge() * 3)) == 144);
    }

    @Test
    public void AccumulatorRechargeTest() {
        TheAccumulator accumulator1 = new TheAccumulator();
        TheAccumulator accumulator2 = new TheAccumulator();
        TheAccumulator accumulator3 = new TheAccumulator();
        ThreeAccLedFlashLight flashLight = factory.createThreeAccLedFlashLight(accumulator1, accumulator2, accumulator3, light);
        for (int i = 0; i < 10; i++) {
            Assert.assertTrue(flashLight.turnOn());
            flashLight.turnOff();
        }
        flashLight.getAccumulator().recharge();
        flashLight.getSecondAccumulator().recharge();
        flashLight.getThirdAccumulator().recharge();
        Assert.assertTrue(flashLight.accumulator.getCurrentCharge() == 70);
        Assert.assertTrue(flashLight.secondAccumulator.getCurrentCharge() == 70);
        Assert.assertTrue(flashLight.thirdAccumulator.getCurrentCharge() == 70);
    }
}
