package com.itstep.fabiyanski;

import com.itstep.fabiyanski.battery.ChineseBattery;
import com.itstep.fabiyanski.battery.DuracellBattery;
import com.itstep.fabiyanski.radio.OneStationBattRadio;
import org.junit.Assert;
import org.junit.Test;

public class OneStationBattRadioTest {
    private FlashLightFactory factory = new FlashLightFactory();


    @Test
    public void OneStationBattRadioWithChineseBatteryTurnOnTest() {
        ChineseBattery battery = new ChineseBattery();
        OneStationBattRadio radio = factory.createOneStationBattRadio(battery);
        for (int i = 0; i < 7; i++) {
            Assert.assertTrue(radio.turnOn());
            radio.turnOff();
        }
    }

    @Test
    public void OneStationBattRadioTurnOffTest() {
        ChineseBattery battery = new ChineseBattery();
        OneStationBattRadio radio = factory.createOneStationBattRadio(battery);
        Assert.assertTrue(radio.turnOn());
        radio.turnOff();
        Assert.assertFalse(radio.isTurnedOn);
    }

    @Test
    public void OneStationBattRadioWithDuracellBatteryTurnOnTest() {
        DuracellBattery duracellBattery = new DuracellBattery();
        OneStationBattRadio radio = factory.createOneStationBattRadio(duracellBattery);
        for (int i = 0; i < 70; i++) {
            Assert.assertTrue(radio.turnOn());
            radio.turnOff();
        }
    }
}
