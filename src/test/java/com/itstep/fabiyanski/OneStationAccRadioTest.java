package com.itstep.fabiyanski;


import com.itstep.fabiyanski.battery.TheAccumulator;
import com.itstep.fabiyanski.radio.OneStationAccRadio;
import org.junit.Assert;
import org.junit.Test;

public class OneStationAccRadioTest {
    private FlashLightFactory factory = new FlashLightFactory();


    @Test
    public void OneStationAccRadioTurnOnTest() {
        TheAccumulator accumulator = new TheAccumulator();
        OneStationAccRadio radio = factory.createOneStationAccRadio(accumulator);
        for (int i = 0; i < 104; i++) {
            Assert.assertTrue(radio.turnOn());
            radio.turnOff();
        }
    }

    @Test
    public void OneStationAccRadioTurnOffTest() {
        TheAccumulator accumulator = new TheAccumulator();
        OneStationAccRadio radio = factory.createOneStationAccRadio(accumulator);
        Assert.assertTrue(radio.turnOn());
        radio.turnOff();
        Assert.assertFalse(radio.isTurnedOn);
    }


}
