package com.itstep.fabiyanski;

import com.itstep.fabiyanski.battery.ChineseBattery;
import com.itstep.fabiyanski.battery.DuracellBattery;
import com.itstep.fabiyanski.flashlight.TwoBattFlashLight;
import com.itstep.fabiyanski.light.IncandecsentLamp;
import org.junit.Assert;
import org.junit.Test;

public class TwoBattFlashLightTest {
    private FlashLightFactory factory = new FlashLightFactory();
    private IncandecsentLamp light = new IncandecsentLamp();


    @Test
    public void TwoBattFlashlightWithChineseBatteriesTurnOnTest() {
        ChineseBattery battery1 = new ChineseBattery();
        ChineseBattery battery2 = new ChineseBattery();
        TwoBattFlashLight flashLight = factory.createTwoBattFlashLight(battery1, battery2, light);
        for (int i = 0; i < 10; i++) {
            Assert.assertTrue(flashLight.turnOn());
            flashLight.turnOff();
        }
    }

    @Test
    public void TwoBattFlashlightTurnOffTest() {
        ChineseBattery battery1 = new ChineseBattery();
        ChineseBattery battery2 = new ChineseBattery();
        TwoBattFlashLight flashLight = factory.createTwoBattFlashLight(battery1, battery2, light);
        Assert.assertTrue(flashLight.turnOn());
        flashLight.turnOff();
        Assert.assertFalse(flashLight.isTurnedOn);
    }

    @Test
    public void TwoBattFlashlightWithDuracellBatteriesTurnOnTest() {
        DuracellBattery duracellBattery1 = new DuracellBattery();
        DuracellBattery duracellBattery2 = new DuracellBattery();
        TwoBattFlashLight flashLight = factory.createTwoBattFlashLight(duracellBattery1, duracellBattery2, light);
        for (int i = 0; i < 100; i++) {
            Assert.assertTrue(flashLight.turnOn());
            flashLight.turnOff();
        }
    }
}
