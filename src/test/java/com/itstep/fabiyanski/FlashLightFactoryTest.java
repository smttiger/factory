package com.itstep.fabiyanski;

import com.itstep.fabiyanski.battery.ChineseBattery;
import com.itstep.fabiyanski.battery.DuracellBattery;
import com.itstep.fabiyanski.battery.TheAccumulator;
import com.itstep.fabiyanski.flashlight.AccumulatorFlashLight;
import com.itstep.fabiyanski.flashlight.FlashLightWithRadio;
import com.itstep.fabiyanski.flashlight.SimpleFlashLight;
import com.itstep.fabiyanski.flashlight.TwoBattFlashLight;
import com.itstep.fabiyanski.light.IncandecsentLamp;
import com.itstep.fabiyanski.radio.OneStationAccRadio;
import com.itstep.fabiyanski.radio.OneStationBattRadio;
import org.junit.Assert;
import org.junit.Test;

public class FlashLightFactoryTest {

    private FlashLightFactory factory = new FlashLightFactory();
    private ChineseBattery battery = new ChineseBattery();
    private ChineseBattery battery2 = new ChineseBattery();
    private IncandecsentLamp light = new IncandecsentLamp();
    private DuracellBattery duracellBattery = new DuracellBattery();
    private TheAccumulator accumulator = new TheAccumulator();
    private TheAccumulator accumulator2 = new TheAccumulator();

    @Test
    public void createSimpleFlashLightWithChineseBatteryTest() {
        SimpleFlashLight flashLight = factory.createFlashLight(battery, light);
        Assert.assertNotNull(flashLight);
    }

    @Test
    public void createSimpleFlashLightWithDuracellBatteryTest() {
        SimpleFlashLight flashLight = factory.createFlashLight(duracellBattery, light);
        Assert.assertNotNull(flashLight);
    }

    @Test
    public void createAccumulatorFlashLightTest() {
        AccumulatorFlashLight flashLight = factory.createAccumulatorFlashLight(accumulator, light);
        Assert.assertNotNull(flashLight);
    }

    @Test
    public void createOneStationAccRadioTest() {
        OneStationAccRadio oneStationAccRadio = factory.createOneStationAccRadio(accumulator);
        Assert.assertNotNull(oneStationAccRadio);
    }

    @Test
    public void createOneStationBattRadioTest() {
        OneStationBattRadio oneStationBattRadio = factory.createOneStationBattRadio(battery);
        Assert.assertNotNull(oneStationBattRadio);
    }

    @Test
    public void createTwoBattFlashLightTest() {
        TwoBattFlashLight flashLight = factory.createTwoBattFlashLight(battery, battery2, light);
        Assert.assertNotNull(flashLight);
    }

    @Test
    public void createFlashLightWithRadioTest() {
        FlashLightWithRadio flashLightWithRadio = factory.createFlashLightWithRadio(accumulator, accumulator2, light);
        Assert.assertNotNull(flashLightWithRadio);
    }
}
