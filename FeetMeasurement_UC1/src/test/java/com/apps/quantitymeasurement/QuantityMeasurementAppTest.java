package com.apps.quantitymeasurement;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QuantityMeasurementAppTest {

    // UC1 Test Cases
    @Test
    public void testFeetEquality_SameValue() {
        Length length1 = new Length(10.0, Length.LengthUnit.FEET);
        Length length2 = new Length(10.0, Length.LengthUnit.FEET);
        assertEquals(true,length1.equals(length2));
    }
    @Test
    public void testFeetEquality_DifferentValue() {
        Length length1 = new Length(10.0, Length.LengthUnit.FEET);
        Length length2 = new Length(20.0, Length.LengthUnit.FEET);
        assertEquals(false,length1.equals(length2));
    }
    @Test
    public void testFeetEquality_NullComparison(){
        Length length1 = new Length(10.0, Length.LengthUnit.FEET);
        assertEquals(false,length1.equals(null));
    }
    @Test
    public void testFeetEquality_DifferentClass(){
        Length length1 = new Length(10.0, Length.LengthUnit.FEET);
        Object obj = "Not OBJ";
         assertEquals(false,length1.equals(obj));
    }
    @Test
    public void testFeetEquality_SameReference(){
        Length length1 = new Length(10.0, Length.LengthUnit.FEET);
        assertEquals(true,length1.equals(length1));
    }

    // UC2 Test Cases
    @Test
    public void testInchesEquality_SameValue(){
        Length length1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);
        assertEquals(true,length1.equals(length2));
    }
    @Test
    public void testInchesEquality_DifferentValue(){
        Length length1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(24.0, Length.LengthUnit.INCHES);
        assertEquals(false,length1.equals(length2));
    }
    @Test
    public void testInchesEquality_NullComparison(){
        Length length1 = new Length(12.0, Length.LengthUnit.INCHES);
        assertEquals(false,length1.equals(null));
    }
    @Test
    public void testInchesEquality_DifferentClass(){
        Length length1 = new Length(12.0, Length.LengthUnit.INCHES);
        Object obj = "Not OBJ";
        assertEquals(false,length1.equals(obj));
    }
    @Test
    public void testInchesEquality_SameReference(){
        Length length1 = new Length(12.0, Length.LengthUnit.INCHES);
        assertEquals(true,length1.equals(length1));
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


    // UC4 Test Cases
    @Test
    public void testEquality_YARDToYARD_SameValue(){
        Length length1 = new Length(1.0,  Length.LengthUnit.YARDS);
        Length length2 = new Length(1.0,  Length.LengthUnit.YARDS);
        assertEquals(true,length1.equals(length2));
    }
    @Test
    public void testEquality_YARDToYARD_DifferentValue(){
        Length length1 = new Length(1.0,  Length.LengthUnit.YARDS);
        Length length2 = new Length(2.0,  Length.LengthUnit.YARDS);
        assertEquals(false,length1.equals(length2));
    }
    @Test
    public void testEquality_YARDToFeet_EquivalentValue(){
        Length length1 = new Length(1.0,  Length.LengthUnit.YARDS);
        Length length2 = new Length(3.0,  Length.LengthUnit.FEET);
        assertEquals(true,length1.equals(length2));
    }
    @Test
    public void testEquality_FeetToYard_EquivalentValue(){
        Length length1 = new Length(3.0,  Length.LengthUnit.FEET);
        Length length2 = new Length(1.0,  Length.LengthUnit.YARDS);
        assertEquals(true,length1.equals(length2));
    }
    @Test
    public void testEquality_YardToInches_EquivalentValue(){
        Length length1 = new Length(1.0,  Length.LengthUnit.YARDS);
        Length length2 = new Length(36.0,  Length.LengthUnit.INCHES);
        assertEquals(true,length1.equals(length2));
    }
    @Test
    public void testEquality_InchesToYard_EquivalentValue(){
        Length length1 = new Length(36.0,  Length.LengthUnit.INCHES);
        Length length2 = new Length(1.0,  Length.LengthUnit.YARDS);
        assertEquals(true,length1.equals(length2));
    }
    @Test
    public void testEquality_YardToFeet_NonEquivalentValue(){
        Length length1 = new Length(1.0,  Length.LengthUnit.YARDS);
        Length length2 = new Length(2.0,  Length.LengthUnit.FEET);
        assertEquals(false,length1.equals(length2));
    }
    @Test
    public void testEquality_CentimetersToInches_EquivalentValue(){
        Length length1 = new Length(1.0,  Length.LengthUnit.CENTIMETER);
        Length length2 = new Length(0.393701,  Length.LengthUnit.INCHES);
        assertEquals(true,length1.equals(length2));
    }
    @Test
    public void testEquality_CentimetersToFeet_NonEquivalentValue(){
        Length length1 = new Length(1.0,  Length.LengthUnit.CENTIMETER);
        Length length2 = new Length(1.0,  Length.LengthUnit.FEET);
        assertEquals(false,length1.equals(length2));
    }
    @Test
    public void testEquality_MultiUnit_TransitiveProperty(){
        Length length1 = new Length(1.0,  Length.LengthUnit.YARDS);
        Length length2 = new Length(36.0,  Length.LengthUnit.INCHES);
        assertEquals(true,length1.equals(length2));
    }
    @Test
    public void testEquality_YardWithNullUnit(){
        Length length1 = new Length(5.0, null);
        Length length2 = new Length(1.0, Length.LengthUnit.YARDS);
        assertEquals(false,length1.equals(length2));
    }
    @Test
    public void testEquality_YardSameReference(){
        Length length1 = new Length(1.0, Length.LengthUnit.YARDS);
        assertEquals(true,length1.equals(length1));
    }
    @Test
    public void testEquality_YardNullComparison(){
        Length length1 = new Length(1.0,  Length.LengthUnit.YARDS);
        Length length2 = null;
        assertEquals(false,length1.equals(length2));
    }
    @Test
    public void testEquality_CentimetersWithNullUnit(){
        Length length1 = new Length(2.0, null);
        Length length2 = new Length(1.0, Length.LengthUnit.CENTIMETER);
        assertEquals(false,length1.equals(length2));
    }
    @Test
    public void testEquality_CentimetersSameReference(){
        Length length1 = new Length(1.0, Length.LengthUnit.CENTIMETER);
        assertEquals(true,length1.equals(length1));
    }
    @Test
    public void testEquality_CentimetersNullComparison(){
        Length length1 = new Length(1.0,  Length.LengthUnit.CENTIMETER);
        Length length2 = null;
        assertEquals(false,length1.equals(length2));
    }
    @Test
    public void testEquality_AllUnits_ComplexScenario(){
        Length length1 = new Length(2.0,  Length.LengthUnit.YARDS);
        Length length2 = new Length(6.0,  Length.LengthUnit.FEET);
        Length length3 = new Length(72.0,  Length.LengthUnit.INCHES);
        assertEquals(true,length1.equals(length2));
        assertEquals(true,length2.equals(length3));
        assertTrue(length1.equals(length3));
    }







}
