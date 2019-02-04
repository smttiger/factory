package com.itstep.fabiyanski;

import com.itstep.fabiyanski.battery.ChineseBattery;
import com.itstep.fabiyanski.battery.DuracellBattery;
import com.itstep.fabiyanski.flashlight.SimpleFlashLight;
import com.itstep.fabiyanski.light.IncandecsentLamp;
import org.junit.Assert;
import org.junit.Test;

public class SimpleFlashLightTest {

    private FlashLightFactory factory = new FlashLightFactory();
    private IncandecsentLamp light = new IncandecsentLamp();


    @Test
    public void SimpleFlashlightWithChineseBatteryTurnOnTest() {
        ChineseBattery battery = new ChineseBattery();
        SimpleFlashLight flashLight = factory.createFlashLight(battery, light);
        for (int i = 0; i < 5; i++) {
            Assert.assertTrue(flashLight.turnOn());
            flashLight.turnOff();
        }
    }

    @Test
    public void SimpleFlashlightTurnOffTest() {
        ChineseBattery battery = new ChineseBattery();
        SimpleFlashLight flashLight = factory.createFlashLight(battery, light);
        Assert.assertTrue(flashLight.turnOn());
        flashLight.turnOff();
        Assert.assertFalse(flashLight.isTurnedOn);
    }

    @Test
    public void SimpleFlashlightWithDuracellBatteryTurnOnTest() {
        DuracellBattery duracellBattery = new DuracellBattery();
        SimpleFlashLight flashLight = factory.createFlashLight(duracellBattery, light);
        for (int i = 0; i < 50; i++) {
            Assert.assertTrue(flashLight.turnOn());
            flashLight.turnOff();
        }
    }

}