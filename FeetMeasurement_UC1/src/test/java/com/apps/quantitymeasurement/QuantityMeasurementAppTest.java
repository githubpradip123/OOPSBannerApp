package com.apps.quantitymeasurement;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class QuantityMeasurementAppTest {

    // UC1 Test Cases
    @Test
    public void testFeetEquality_SameValue() {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(10.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(10.0);
        assertEquals(true,feet1.equals(feet2));
    }
    @Test
    public void testFeetEquality_DifferentValue() {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(10.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(20.0);
        assertEquals(false,feet1.equals(feet2));
    }
    @Test
    public void testFeetEquality_NullComparison(){
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(10.0);
        assertEquals(false,feet1.equals(null));
    }
    @Test
    public void testFeetEquality_DifferentClass(){
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(10.0);
        Object obj = "Not OBJ";
         assertEquals(false,feet1.equals(obj));
    }
    @Test
    public void testFeetEquality_SameReference(){
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(10.0);
        assertEquals(true,feet1.equals(feet1));
    }

    // UC2 Test Cases
    @Test
    public void testInchesEquality_SameValue(){
        QuantityMeasurementApp.Inches inch1 = new QuantityMeasurementApp.Inches(12);
        QuantityMeasurementApp.Inches inch2 = new QuantityMeasurementApp.Inches(12);
        assertEquals(true,inch1.equals(inch2));
    }
    @Test
    public void testInchesEquality_DifferentValue(){
        QuantityMeasurementApp.Inches inch1 = new QuantityMeasurementApp.Inches(10);
        QuantityMeasurementApp.Inches inch2 = new QuantityMeasurementApp.Inches(20);
        assertEquals(false,inch1.equals(inch2));
    }
    @Test
    public void testInchesEquality_NullComparison(){
        QuantityMeasurementApp.Inches inch1 = new QuantityMeasurementApp.Inches(10);
        assertEquals(false,inch1.equals(null));
    }
    @Test
    public void testInchesEquality_DifferentClass(){
        QuantityMeasurementApp.Inches inch1 = new QuantityMeasurementApp.Inches(15);
        Object obj = "Not OBJ";
        assertEquals(false,inch1.equals(obj));
    }
    @Test
    public void testInchesEquality_SameReference(){
        QuantityMeasurementApp.Inches inch1 = new QuantityMeasurementApp.Inches(12.0);
        assertEquals(true,inch1.equals(inch1));
    }


    // UC3 Test Cases
    @Test
    public void testFeetEquality(){
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(1.0, Length.LengthUnit.FEET);
        assertEquals(true,length1.equals(length2));
    }
    @Test
    public void testEquality_FeetToFeet_DifferentValue(){
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(2.0, Length.LengthUnit.FEET);
        assertEquals(false,length1.equals(length2));
    }
    @Test
    public void testInchesEquality(){
        Length length1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(1.0, Length.LengthUnit.INCHES);
        assertEquals(true,length1.equals(length2));
    }
    @Test
    public void testEquality_InchToInch_DifferentValue(){
        Length length1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(2.0, Length.LengthUnit.INCHES);
        assertEquals(false,length1.equals(length2));
    }
    @Test
    public void testFeetInchesComparison(){
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);
        assertEquals(true,length1.equals(length2));
    }
    @Test
    public void testFeetInEquality(){
        Length length1 = new Length(4.0, Length.LengthUnit.FEET);
        Length length2 = new Length(2.0, Length.LengthUnit.FEET);
        assertEquals(false,length1.equals(length2));
    }
    @Test
    public void testInchesInEquality(){
        Length length1 = new Length(15.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);
        assertEquals(false,length1.equals(length2));
    }
    @Test
    public void testCrossUnitInEquality(){
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(13.0, Length.LengthUnit.INCHES);
        assertEquals(false,length1.equals(length2));
    }
    @Test
    public void testEquality_NullUnit(){
        Length length1 = new Length(5.0, null);
        Length length2 = new Length(6.0, Length.LengthUnit.FEET);
        assertEquals(false,length1.equals(length2));
    }
    @Test
    public void testEquality_NullComparison(){
        Length length1 = new Length(5.0,  Length.LengthUnit.FEET);
        Length length2 = null;
        assertEquals(false,length1.equals(length2));
    }

}
