package com.apps.quantitymeasurement;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetEquality_SameValue()
    {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(10.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(10.0);
        assertEquals(true,feet1.equals(feet2));
    }
    @Test
    public void testFeetEquality_DifferentValue()
    {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(10.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(20.0);
        assertEquals(false,feet1.equals(feet2));
    }
    @Test
    public void testFeetEquality_NullComparison()
    {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(10.0);
        assertEquals(false,feet1.equals(null));
    }
    @Test
    public void testFeetEquality_DifferentClass()
    {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(10.0);
        Object obj = "Not OBJ";
         assertEquals(false,feet1.equals(obj));
    }
    @Test
    public void testFeetEquality_SameReference()
    {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(10.0);
        assertEquals(true,feet1.equals(feet1));
    }

    @Test
    public void testInchesEquality_SameValue()
    {
        QuantityMeasurementApp.Inches inch1 = new QuantityMeasurementApp.Inches(12);
        QuantityMeasurementApp.Inches inch2 = new QuantityMeasurementApp.Inches(12);
        assertEquals(true,inch1.equals(inch2));
    }
    @Test
    public void testInchesEquality_DifferentValue()
    {
        QuantityMeasurementApp.Inches inch1 = new QuantityMeasurementApp.Inches(10);
        QuantityMeasurementApp.Inches inch2 = new QuantityMeasurementApp.Inches(20);
        assertEquals(false,inch1.equals(inch2));
    }
    @Test
    public void testInchesEquality_NullComparison()
    {
        QuantityMeasurementApp.Inches inch1 = new QuantityMeasurementApp.Inches(10);
        assertEquals(false,inch1.equals(null));
    }
    @Test
    public void testInchesEquality_DifferentClass()
    {
        QuantityMeasurementApp.Inches inch1 = new QuantityMeasurementApp.Inches(15);
        Object obj = "Not OBJ";
        assertEquals(false,inch1.equals(obj));
    }
    @Test
    public void testInchesEquality_SameReference()
    {
        QuantityMeasurementApp.Inches inch1 = new QuantityMeasurementApp.Inches(10.0);
        assertEquals(true,inch1.equals(inch1));
    }





}
