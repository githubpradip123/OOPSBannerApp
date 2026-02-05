package com.apps.quantitymeasurement;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeedEquality_SameValue()
    {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(10.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(10.0);
        assertEquals(true,feet1.equals(feet2));
    }


    @Test
    public void testFeedEquality_DifferentValue()
    {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(10.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(20.0);
        assertEquals(false,feet1.equals(feet2));
    }

    @Test
    public void testFeedEquality_NullComparison()
    {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(10.0);
        assertEquals(false,feet1.equals(null));
    }

    @Test
    public void testFeedEquality_DifferentClass()
    {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(10.0);
        Object obj = "Not OBJ";
         assertEquals(false,feet1.equals(obj));
    }

    @Test
    public void testFeedEquality_SameReference()
    {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(10.0);
        assertEquals(true,feet1.equals(feet1));
    }

}
