package com.apps.quantitymeasurement;


import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import static com.apps.quantitymeasurement.QuantityMeasurementApp.demonstrateLengthConversion;
import static org.junit.Assert.*;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 1e-9;
    
    // UC1 Test Cases
    @Test
    public void testFeetEquality_SameValue() {
        Length length1 = new Length(10.0, LengthUnit.FEET);
        Length length2 = new Length(10.0, LengthUnit.FEET);
        assertEquals(true,length1.equals(length2));
    }
    @Test
    public void testFeetEquality_DifferentValue() {
        Length length1 = new Length(10.0, LengthUnit.FEET);
        Length length2 = new Length(20.0, LengthUnit.FEET);
        assertEquals(false,length1.equals(length2));
    }
    @Test
    public void testFeetEquality_NullComparison(){
        Length length1 = new Length(10.0, LengthUnit.FEET);
        assertEquals(false,length1.equals(null));
    }
    @Test
    public void testFeetEquality_DifferentClass(){
        Length length1 = new Length(10.0, LengthUnit.FEET);
        Object obj = "Not OBJ";
         assertEquals(false,length1.equals(obj));
    }
    @Test
    public void testFeetEquality_SameReference(){
        Length length1 = new Length(10.0, LengthUnit.FEET);
        assertEquals(true,length1.equals(length1));
    }

    // UC2 Test Cases
    @Test
    public void testInchesEquality_SameValue(){
        Length length1 = new Length(12.0, LengthUnit.INCHES);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        assertEquals(true,length1.equals(length2));
    }
    @Test
    public void testInchesEquality_DifferentValue(){
        Length length1 = new Length(12.0, LengthUnit.INCHES);
        Length length2 = new Length(24.0, LengthUnit.INCHES);
        assertEquals(false,length1.equals(length2));
    }
    @Test
    public void testInchesEquality_NullComparison(){
        Length length1 = new Length(12.0, LengthUnit.INCHES);
        assertEquals(false,length1.equals(null));
    }
    @Test
    public void testInchesEquality_DifferentClass(){
        Length length1 = new Length(12.0, LengthUnit.INCHES);
        Object obj = "Not OBJ";
        assertEquals(false,length1.equals(obj));
    }
    @Test
    public void testInchesEquality_SameReference(){
        Length length1 = new Length(12.0, LengthUnit.INCHES);
        assertEquals(true,length1.equals(length1));
    }



    // UC3 Test Cases
    @Test
    public void testFeetEquality(){
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(1.0, LengthUnit.FEET);
        assertEquals(true,length1.equals(length2));
    }
    @Test
    public void testEquality_FeetToFeet_DifferentValue(){
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(2.0, LengthUnit.FEET);
        assertEquals(false,length1.equals(length2));
    }
    @Test
    public void testInchesEquality(){
        Length length1 = new Length(1.0, LengthUnit.INCHES);
        Length length2 = new Length(1.0, LengthUnit.INCHES);
        assertEquals(true,length1.equals(length2));
    }
    @Test
    public void testEquality_InchToInch_DifferentValue(){
        Length length1 = new Length(1.0, LengthUnit.INCHES);
        Length length2 = new Length(2.0, LengthUnit.INCHES);
        assertEquals(false,length1.equals(length2));
    }
    @Test
    public void testFeetInchesComparison(){
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        assertEquals(true,length1.equals(length2));
    }
    @Test
    public void testFeetInEquality(){
        Length length1 = new Length(4.0, LengthUnit.FEET);
        Length length2 = new Length(2.0, LengthUnit.FEET);
        assertEquals(false,length1.equals(length2));
    }
    @Test
    public void testInchesInEquality(){
        Length length1 = new Length(15.0, LengthUnit.INCHES);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        assertEquals(false,length1.equals(length2));
    }
    @Test
    public void testCrossUnitInEquality(){
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(13.0, LengthUnit.INCHES);
        assertEquals(false,length1.equals(length2));
    }
    @Test
    public void testEquality_NullUnit(){
        Length length1 = new Length(5.0, null);
        Length length2 = new Length(6.0, LengthUnit.FEET);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,() -> length1.equals(length2));
        assertTrue(ex.getMessage().toLowerCase().contains("unit must not be null"));
    }
    @Test
    public void testEquality_NullComparison(){
        Length length1 = new Length(5.0,  LengthUnit.FEET);
        Length length2 = null;
        assertEquals(false,length1.equals(length2));
    }


    // UC4 Test Cases
    @Test
    public void testEquality_YARDToYARD_SameValue(){
        Length length1 = new Length(1.0,  LengthUnit.YARDS);
        Length length2 = new Length(1.0,  LengthUnit.YARDS);
        assertEquals(true,length1.equals(length2));
    }
    @Test
    public void testEquality_YARDToYARD_DifferentValue(){
        Length length1 = new Length(1.0,  LengthUnit.YARDS);
        Length length2 = new Length(2.0,  LengthUnit.YARDS);
        assertEquals(false,length1.equals(length2));
    }
    @Test
    public void testEquality_YARDToFeet_EquivalentValue(){
        Length length1 = new Length(1.0,  LengthUnit.YARDS);
        Length length2 = new Length(3.0,  LengthUnit.FEET);
        assertEquals(true,length1.equals(length2));
    }
    @Test
    public void testEquality_FeetToYard_EquivalentValue(){
        Length length1 = new Length(3.0,  LengthUnit.FEET);
        Length length2 = new Length(1.0,  LengthUnit.YARDS);
        assertEquals(true,length1.equals(length2));
    }
    @Test
    public void testEquality_YardToInches_EquivalentValue(){
        Length length1 = new Length(1.0,  LengthUnit.YARDS);
        Length length2 = new Length(36.0,  LengthUnit.INCHES);
        assertEquals(true,length1.equals(length2));
    }
    @Test
    public void testEquality_InchesToYard_EquivalentValue(){
        Length length1 = new Length(36.0,  LengthUnit.INCHES);
        Length length2 = new Length(1.0,  LengthUnit.YARDS);
        assertEquals(true,length1.equals(length2));
    }
    @Test
    public void testEquality_YardToFeet_NonEquivalentValue(){
        Length length1 = new Length(1.0,  LengthUnit.YARDS);
        Length length2 = new Length(2.0,  LengthUnit.FEET);
        assertEquals(false,length1.equals(length2));
    }
    @Test
    public void testEquality_CentimetersToInches_EquivalentValue(){
        Length length1 = new Length(1.0,  LengthUnit.CENTIMETER);
        Length length2 = new Length(0.393701,  LengthUnit.INCHES);
        assertEquals(true,length1.equals(length2));
    }
    @Test
    public void testEquality_CentimetersToFeet_NonEquivalentValue(){
        Length length1 = new Length(1.0,  LengthUnit.CENTIMETER);
        Length length2 = new Length(1.0,  LengthUnit.FEET);
        assertEquals(false,length1.equals(length2));
    }
    @Test
    public void testEquality_MultiUnit_TransitiveProperty(){
        Length length1 = new Length(1.0,  LengthUnit.YARDS);
        Length length2 = new Length(36.0,  LengthUnit.INCHES);
        assertEquals(true,length1.equals(length2));
    }
    @Test
    public void testEquality_YardWithNullUnit(){
        Length length1 = new Length(5.0, null);
        Length length2 = new Length(1.0, LengthUnit.YARDS);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,() -> length1.equals(length2));
        assertTrue(ex.getMessage().toLowerCase().contains("unit must not be null"));
    }
    @Test
    public void testEquality_YardSameReference(){
        Length length1 = new Length(1.0, LengthUnit.YARDS);
        assertEquals(true,length1.equals(length1));
    }
    @Test
    public void testEquality_YardNullComparison(){
        Length length1 = new Length(1.0,  LengthUnit.YARDS);
        Length length2 = null;
        assertEquals(false,length1.equals(length2));
    }
    @Test
    public void testEquality_CentimetersWithNullUnit(){
        Length length1 = new Length(2.0, null);
        Length length2 = new Length(1.0, LengthUnit.CENTIMETER);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,() -> length1.equals(length2));
        assertTrue(ex.getMessage().toLowerCase().contains("unit must not be null"));
    }
    @Test
    public void testEquality_CentimetersSameReference(){
        Length length1 = new Length(1.0, LengthUnit.CENTIMETER);
        assertEquals(true,length1.equals(length1));
    }
    @Test
    public void testEquality_CentimetersNullComparison(){
        Length length1 = new Length(1.0,  LengthUnit.CENTIMETER);
        Length length2 = null;
        assertEquals(false,length1.equals(length2));
    }
    @Test
    public void testEquality_AllUnits_ComplexScenario(){
        Length length1 = new Length(2.0,  LengthUnit.YARDS);
        Length length2 = new Length(6.0,  LengthUnit.FEET);
        Length length3 = new Length(72.0,  LengthUnit.INCHES);
        assertEquals(true,length1.equals(length2));
        assertEquals(true,length2.equals(length3));
        assertTrue(length1.equals(length3));
    }


    // UC5 Test Cases
    @Test
    public void testConversion_FeetToInches() {
        Length length = demonstrateLengthConversion(1.0,LengthUnit.FEET,LengthUnit.INCHES);
          assertEquals(12.0,length.getValue(),EPSILON);
    }
    @Test
    public void testConversion_InchesToFeet()   {
        Length length = demonstrateLengthConversion(24.0,LengthUnit.INCHES,LengthUnit.FEET);
        assertEquals(2.0,length.getValue(),EPSILON);
    }
    @Test
    public void testConversion_YardsToInches()   {
        Length length = demonstrateLengthConversion(1.0,LengthUnit.YARDS,LengthUnit.INCHES);
        assertEquals(36.00,length.getValue(),EPSILON);
    }
    @Test
    public void testConversion_InchesToYards()   {
        Length length = demonstrateLengthConversion(72.0,LengthUnit.INCHES,LengthUnit.YARDS);
        assertEquals(2.0,length.getValue(),EPSILON);
    }
    @Test
    public void testConversion_CentimetersToInches()   {
        Length length = demonstrateLengthConversion(2.54,LengthUnit.CENTIMETER,LengthUnit.INCHES);
        assertEquals(1.0,length.getValue(),EPSILON);
    }
    @Test
    public void testConversion_FeetToYard()   {
        Length length = demonstrateLengthConversion(6.0,LengthUnit.FEET,LengthUnit.YARDS);
        assertEquals(2.0,length.getValue(),EPSILON);
    }
    @Test
    public void testConversion_RoundTrip_PreservesValue()   {
        Length length = demonstrateLengthConversion(6.0,LengthUnit.FEET,LengthUnit.INCHES);
        Length length1 = demonstrateLengthConversion(length.getValue(),LengthUnit.INCHES,LengthUnit.FEET);
        assertEquals(6.0, length1.getValue(),EPSILON);
    }
    @Test
    public void testConversion_ZeroValue()   {
        Length length = demonstrateLengthConversion(0.0,LengthUnit.FEET,LengthUnit.INCHES);
        assertEquals(0.00,length.getValue(),EPSILON);
    }
    @Test
    public void testConversion_NegativeValue()   {
        Length length = demonstrateLengthConversion(-1.0,LengthUnit.FEET,LengthUnit.INCHES);
        assertEquals(-12.0,length.getValue(),EPSILON);
    }
    @Test
    public void testConversion_InvalidUnit_Throws() {
        Length length = new Length(1.0, LengthUnit.FEET);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> length.convertTo(null));
        assertTrue(ex.getMessage().toLowerCase().contains("must not be null"));
    }
    @Test
    public void testConversion_NANOrInfinite_Throws()   {
        Length length = new Length(Double.NaN, LengthUnit.FEET);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,() -> length.convertTo(LengthUnit.INCHES));
        assertTrue(ex.getMessage().toLowerCase().contains("must not be null or infinite or nan"));
    }
    @Test
    public void testConversion_PrecisionTolerance()   {
        Length length = demonstrateLengthConversion(1.0,LengthUnit.FEET,LengthUnit.INCHES);
        assertEquals(12.0, length.getValue(), EPSILON);
    }


    // UC6 Test Cases
    @Test
    public void testAddition_SameUnit_FeetPlusFeet()   {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(2.0, LengthUnit.FEET);
        Length lengthAddition = length1.add(length2);
        assertEquals(3.0,lengthAddition.getValue(),EPSILON);
    }
    @Test
    public void testAddition_SameUnit_InchPlusInch()   {
        Length length1 = new Length(12.0, LengthUnit.INCHES);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        Length lengthAddition = length1.add(length2);
        assertEquals(24.0,lengthAddition.getValue(),EPSILON);
    }
    @Test
    public void testAddition_CrossUnit_FeetPlusInch()   {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        Length lengthAddition = length1.add(length2);
        assertEquals(2.0,lengthAddition.getValue(),EPSILON);
    }
    @Test
    public void testAddition_CrossUnit_InchPlusFeet()   {
        Length length1 = new Length(12.0, LengthUnit.INCHES);
        Length length2 = new Length(1.0, LengthUnit.FEET);
        Length lengthAddition = length1.add(length2);
        assertEquals(24.0,lengthAddition.getValue(),EPSILON);
    }
    @Test
    public void testAddition_CrossUnit_YARDPlusFeet()   {
        Length length1 = new Length(1.0, LengthUnit.YARDS);
        Length length2 = new Length(3.0, LengthUnit.FEET);
        Length lengthAddition = length1.add(length2);
        assertEquals(2.0,lengthAddition.getValue(),EPSILON);
    }
    @Test
    public void testAddition_CrossUnit_CentimeterPlusInch() {
        Length length1 = new Length(2.54, LengthUnit.CENTIMETER);
        Length length2 = new Length(1.0, LengthUnit.INCHES);
        Length lengthAddition = length1.add(length2);
        assertEquals(5.08,lengthAddition.getValue(),EPSILON);
    }
    @Test
    public void testAddition_Commutativity()   {
        Length length1 = new Length(1, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        Length lengthAddition = length1.add(length2);
        Length lengthAddition1 = length2.add(length1);
        double sum1InInches = lengthAddition.convertTo(LengthUnit.INCHES).getValue();
        double sum2InInches = lengthAddition1.convertTo(LengthUnit.INCHES).getValue();
        assertTrue( sum1InInches == sum2InInches);
    }
    @Test
    public void testAddition_WithZero()   {
        Length length1 = new Length(5.0, LengthUnit.FEET);
        Length length2 = new Length(0.0, LengthUnit.INCHES);
        Length lengthAddition = length1.add(length2);
        assertEquals(5.0,lengthAddition.getValue(),EPSILON);
    }
    @Test
    public void testAddition_Negative_Values()   {
        Length length1 = new Length(5.0, LengthUnit.FEET);
        Length length2 = new Length(-2.0, LengthUnit.FEET);
        Length lengthAddition = length1.add(length2);
        assertEquals(3.0,lengthAddition.getValue(),EPSILON);
    }
    @Test
    public void testAddition_NullSecondOperand()   {
        Length length1 = new Length(5.0, LengthUnit.FEET);
        Length length2 =  null;
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,() -> length1.add(length2));
        assertTrue(ex.getMessage().toLowerCase().contains("must not be null"));
    }
    @Test
    public void testAddition_LargeValues()   {
        Length length1 = new Length(1e6, LengthUnit.FEET);
        Length length2 = new Length(1e6 ,LengthUnit.FEET);
        Length lengthAddition = length1.add(length2);
        assertEquals(2e6,lengthAddition.getValue(),EPSILON);
    }
    @Test
    public void testAddition_SmallValues()   {
        Length length1 = new Length(0.001, LengthUnit.FEET);
        Length length2 = new Length(0.002, LengthUnit.FEET);
        Length lengthAddition = length1.add(length2);
        assertEquals(0.003,lengthAddition.getValue(),EPSILON);
    }


    // UC7 Test Cases
    @Test
    public void testAddition_ExplicitTargetUnit_Feet() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        Length lengthAddition = length1.add(length2,LengthUnit.FEET);
        assertEquals(2.0,lengthAddition.getValue(),EPSILON);
    }
    @Test
    public void testAddition_ExplicitTargetUnit_Inches() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        Length lengthAddition = length1.add(length2,LengthUnit.INCHES);
        assertEquals(24.0,lengthAddition.getValue(),EPSILON);
    }
    @Test
    public void testAddition_ExplicitTargetUnit_YARDS() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        Length lengthAddition = length1.add(length2,LengthUnit.YARDS);
        assertEquals(0.667,lengthAddition.getValue(),EPSILON);
    }
    @Test
    public void testAddition_ExplicitTargetUnit_Centimeters() {
        Length length1 = new Length(1.0, LengthUnit.INCHES);
        Length length2 = new Length(1.0, LengthUnit.INCHES);

        Length lengthAddition = length1.add(length2,LengthUnit.CENTIMETER);
        assertEquals(5.08,lengthAddition.getValue(),EPSILON);
    }
    @Test
    public void testAddition_ExplicitTargetUnit_SameAsFirstOperand() {
        Length length1 = new Length(2.0, LengthUnit.YARDS);
        Length length2 = new Length(3.0, LengthUnit.FEET);

        Length lengthAddition = length1.add(length2,LengthUnit.YARDS);
        assertEquals(3.0,lengthAddition.getValue(),EPSILON);
    }
    @Test
    public void testAddition_ExplicitTargetUnit_SameAsSecondOperand() {
        Length length1 = new Length(2.0, LengthUnit.YARDS);
        Length length2 = new Length(3.0, LengthUnit.FEET);

        Length lengthAddition = length1.add(length2,LengthUnit.FEET);
        assertEquals(9.0,lengthAddition.getValue(),EPSILON);
    }
    @Test
    public void testAddition_ExplicitTargetUnit_Commutativity() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        Length lengthAddition = length1.add(length2,LengthUnit.YARDS);
        Length lengthAddition1 = length2.add(length1,LengthUnit.YARDS);

        assertTrue( lengthAddition.getValue() == lengthAddition1.getValue());
    }
    @Test
    public void testAddition_ExplicitTargetUnit_WithZero() {
        Length length1 = new Length(5.0, LengthUnit.FEET);
        Length length2 = new Length(0.0, LengthUnit.INCHES);

        Length lengthAddition = length1.add(length2,LengthUnit.YARDS);
        assertEquals(1.667,lengthAddition.getValue(),EPSILON);
    }
    @Test
    public void testAddition_ExplicitTargetUnit_NegativeValues() {
        Length length1 = new Length(5.0, LengthUnit.FEET);
        Length length2 = new Length(-2.0, LengthUnit.FEET);

        Length lengthAddition = length1.add(length2,LengthUnit.INCHES);
        assertEquals(36.0,lengthAddition.getValue(),EPSILON);
    }
    @Test
    public void testAddition_ExplicitTargetUnit_NullTargetUnit() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,() -> length1.add(length2,null));
        assertTrue(ex.getMessage().toLowerCase().contains("must not be null"));
    }
    @Test
    public void testAddition_ExplicitTargetUnit_LargeToSmallScale() {
        Length length1 = new Length(1000.0, LengthUnit.FEET);
        Length length2 = new Length(500.0, LengthUnit.FEET);

        Length lengthAddition = length1.add(length2,LengthUnit.INCHES);
        assertEquals(18000.0,lengthAddition.getValue(),EPSILON);
    }
    @Test
    public void testAddition_ExplicitTargetUnit_SmallToLargeScale() {
        Length length1 = new Length(12.0, LengthUnit.INCHES);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        Length lengthAddition = length1.add(length2,LengthUnit.YARDS);
        assertEquals(0.667,lengthAddition.getValue(),EPSILON);
    }
    @Test
    public void testAddition_ExplicitTargetUnit_AllUnitCombination() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(1.0, LengthUnit.INCHES);

        Length lengthAddition = length1.add(length2,LengthUnit.CENTIMETER);
        assertEquals(33.02,lengthAddition.getValue(),EPSILON);

        Length length3 = new Length(1.0, LengthUnit.YARDS);
        Length length4 = new Length(36.0, LengthUnit.INCHES);

        Length lengthAddition1 = length3.add(length4,LengthUnit.FEET);
        assertEquals(6.0,lengthAddition1.getValue(),EPSILON);
    }
    @Test
    public void testAddition_ExplicitTargetUnit_PrecisionTolerance() {
        Length length1 = new Length(12.0, LengthUnit.INCHES);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        Length lengthAddition = length1.add(length2,LengthUnit.YARDS);
        assertEquals(0.667,lengthAddition.getValue(),EPSILON);
    }


    // UC8 Test Cases
    @Test
    public void testLengthUnitEnum_FeetConstant() {
        assertEquals(12.0,LengthUnit.FEET.getConversionFactor(),EPSILON);
    }
    @Test
    public void testLengthUnitEnum_InchesConstant() {
        assertEquals(1.0,LengthUnit.INCHES.getConversionFactor(),EPSILON);
    }
    @Test
    public void testLengthUnitEnum_YardsConstant() {
        assertEquals(36.0,LengthUnit.YARDS.getConversionFactor(),EPSILON);
    }
    @Test
    public void testLengthUnitEnum_CentimetersConstant() {
        assertEquals(0.393701,LengthUnit.CENTIMETER.getConversionFactor(),EPSILON);
    }
    @Test
    public void testConvertToBaseUnit_InchesToInches() {
        assertEquals(12.0,LengthUnit.INCHES.convertToBaseUnit(12.0),EPSILON);
    }
    @Test
    public void testConvertToBaseUnit_FeetToInches() {
        assertEquals(12.0,LengthUnit.FEET.convertToBaseUnit(1.0),EPSILON);
    }
    @Test
    public void testConvertToBaseUnit_YardsToInches() {
        assertEquals(36.0,LengthUnit.YARDS.convertToBaseUnit(1.0),EPSILON);
    }
    @Test
    public void testConvertToBaseUnit_CentimeterToInches() {
        assertEquals(39.37,Math.round(LengthUnit.CENTIMETER.convertToBaseUnit(100.0) * 100.0)/100.0,EPSILON);
    }
    @Test
    public void testConvertFromBaseUnit_InchesToInches() {
        assertEquals(12.0,LengthUnit.INCHES.convertFromBaseUnit(12.0),EPSILON);
    }
    @Test
    public void testConvertFromBaseUnit_InchesToFeet() {
        assertEquals(1.0,LengthUnit.FEET.convertFromBaseUnit(12.0),EPSILON);
    }
    @Test
    public void testConvertFromBaseUnit_InchesToYards() {
        assertEquals(1.0,LengthUnit.YARDS.convertFromBaseUnit(36.0),EPSILON);
    }
    @Test
    public void testConvertFromBaseUnit_InchesToCentimeter() {
        assertEquals(254.0,Math.round(LengthUnit.CENTIMETER.convertFromBaseUnit(100) * 100.0)/100.0,EPSILON);
    }
    @Test
    public void testQuantityLengthRefactored_Equality() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        assertEquals(true, length1.equals(length2));
    }
    @Test
    public void testQuantityLengthRefactored_ConvertTo() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length  length2  = length1.convertTo(LengthUnit.INCHES);
        assertEquals(12.0,length2.getValue(),EPSILON);
    }
    @Test
    public void testQuantityLengthRefactored_Add() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        Length  lengthAddition  = length1.add(length2,LengthUnit.FEET);
        assertEquals(2.0,lengthAddition.getValue(),EPSILON);
    }

    @Test
    public void testQuantityLengthRefactored_AddWithTargetUnit() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        Length  lengthAddition  = length1.add(length2,LengthUnit.YARDS);
        assertEquals(0.667,lengthAddition.getValue(),EPSILON);
    }
    @Test
    public void testQuantityLengthRefactored_NullUnit() {
        Length length1 = new Length(5.0, null);
        Length length2 = new Length(6.0, LengthUnit.FEET);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,() -> length1.equals(length2));
        assertTrue(ex.getMessage().toLowerCase().contains("unit must not be null"));
    }
    @Test
    public void testQuantityLengthRefactored_InvalidUnit() {
        Length length1 = new Length(Double.NaN, null);
        Length length2 = new Length(6.0, LengthUnit.FEET);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,() -> length1.equals(length2));
        assertTrue(ex.getMessage().toLowerCase().contains("unit must not be null"));
    }
    @Test
    public void testRoundTripConversion_RefractedDesign() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length  lengthValue  = length1.convertTo(LengthUnit.INCHES);

        Length length2 = new Length(lengthValue.getValue(), LengthUnit.INCHES);
        Length  lengthValue1  = length2.convertTo(LengthUnit.FEET);

        assertEquals(true,lengthValue.getValue() == LengthUnit.FEET.convertToBaseUnit(lengthValue1.getValue()));
    }

    @Test
    public void testUnitImmutability() {
        Field[] fields = Length.class.getDeclaredFields();
        System.out.println(Arrays.stream(fields).toList());
        assertTrue("Length should have fields",fields.length > 0);

        for (Field f : fields) {
            int mod = f.getModifiers();
            assertTrue(f.getName() + " must be private", Modifier.isPrivate(mod));
        }
    }


}
