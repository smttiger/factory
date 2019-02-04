package com.itstep.fabiyanski;

import com.itstep.fabiyanski.battery.TheAccumulator;
import com.itstep.fabiyanski.flashlight.FlashLightWithRadio;
import com.itstep.fabiyanski.light.IncandecsentLamp;
import org.junit.Assert;
import org.junit.Test;

public class FlashLightWithRadioTest {
    private FlashLightFactory factory = new FlashLightFactory();
    private IncandecsentLamp light = new IncandecsentLamp();

    @Test
    public void FlashLightWithRadioTurnOnTest() {
        TheAccumulator accumulator1 = new TheAccumulator();
        TheAccumulator accumulator2 = new TheAccumulator();
        FlashLightWithRadio flashLightWithRadio = factory.createFlashLightWithRadio(accumulator1, accumulator2, light);
        for (int i = 0; i < 140; i++) {
            Assert.assertTrue(flashLightWithRadio.turnOn());
            flashLightWithRadio.turnOff();
        }
    }

    @Test
    public void FlashLightWithRadioTurnOffTest() {
        TheAccumulator accumulator1 = new TheAccumulator();
        TheAccumulator accumulator2 = new TheAccumulator();
        FlashLightWithRadio flashLightWithRadio = factory.createFlashLightWithRadio(accumulator1, accumulator2, light);
        Assert.assertTrue(flashLightWithRadio.turnOn());
        flashLightWithRadio.turnOff();
        Assert.assertFalse(flashLightWithRadio.isTurnedOn);
    }

    @Test
    public void FlashLightWithRadioTurnOnRadioTest() {
        TheAccumulator accumulator1 = new TheAccumulator();
        TheAccumulator accumulator2 = new TheAccumulator();
        FlashLightWithRadio flashLightWithRadio = factory.createFlashLightWithRadio(accumulator1, accumulator2, light);
        for (int i = 0; i < 208; i++) {
            Assert.assertTrue(flashLightWithRadio.turnOnRadio());
            flashLightWithRadio.turnOffRadio();
        }
    }

    @Test
    public void FlashLightWithRadioTurnOffRadioTest() {
        TheAccumulator accumulator1 = new TheAccumulator();
        TheAccumulator accumulator2 = new TheAccumulator();
        FlashLightWithRadio flashLightWithRadio = factory.createFlashLightWithRadio(accumulator1, accumulator2, light);
        Assert.assertTrue(flashLightWithRadio.turnOnRadio());
        flashLightWithRadio.turnOffRadio();
        Assert.assertFalse(flashLightWithRadio.isRadioTurnedOn);
    }

    @Test
    public void FlashLightWithRadioShowCurrentChargeTest() {
        TheAccumulator accumulator1 = new TheAccumulator();
        TheAccumulator accumulator2 = new TheAccumulator();
        FlashLightWithRadio flashLightWithRadio = factory.createFlashLightWithRadio(accumulator1, accumulator2, light);
        for (int i = 0; i < 138; i++) {
            Assert.assertTrue(flashLightWithRadio.turnOn());
            flashLightWithRadio.turnOff();
        }
        flashLightWithRadio.showCurrentAccumulatorCharge();
        Assert.assertTrue((flashLightWithRadio.accumulator.getCurrentCharge() + flashLightWithRadio.secondAccumulator.getCurrentCharge()) == 2);
    }

    @Test
    public void FlashLightWithRadioAccumulatorRechargeTest() {
        TheAccumulator accumulator1 = new TheAccumulator();
        TheAccumulator accumulator2 = new TheAccumulator();
        FlashLightWithRadio flashLightWithRadio = factory.createFlashLightWithRadio(accumulator1, accumulator2, light);
        for (int i = 0; i < 10; i++) {
            Assert.assertTrue(flashLightWithRadio.turnOn());
            flashLightWithRadio.turnOff();
        }
        flashLightWithRadio.getAccumulator().recharge();
        flashLightWithRadio.getSecondAccumulator().recharge();
        Assert.assertTrue(flashLightWithRadio.accumulator.getCurrentCharge() == 70);
        Assert.assertTrue(flashLightWithRadio.secondAccumulator.getCurrentCharge() == 70);
    }
}
