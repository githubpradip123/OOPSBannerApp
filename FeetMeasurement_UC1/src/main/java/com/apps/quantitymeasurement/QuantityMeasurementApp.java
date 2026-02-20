package com.apps.quantitymeasurement;


public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(Length L1,Length L2){
        System.out.println("Length Equality >>> "+L1.equals(L2));
        return L1.equals(L2);
    }

    public static void demonstrateLengthComparison(double value1, LengthUnit LengthUnit1,double value2, LengthUnit LengthUnit2) {
        Length length1 = new Length(value1,LengthUnit1);
        Length length2 = new Length(value2,LengthUnit2);
        System.out.println("Length Equality Check =>  " +demonstrateLengthEquality(length1,length2) );
    }

    public static Length demonstrateLengthConversion(double value1, LengthUnit FromUnit,LengthUnit ToUnit) {
        Length length1 = new Length(value1,FromUnit);
        Length length = length1.convertTo(ToUnit);
         return length;
    }

    public static Length demonstrateLengthConversion( Length length,LengthUnit toUnit) {
        if(length == null) throw new IllegalArgumentException("Length must not be null");
        if(toUnit == null) throw new IllegalArgumentException("Length unit must not be null");
        Length lengthConversion = length.convertTo(toUnit);
        return lengthConversion;
    }

    public static Length demonstrateLengthAddition(double value1, LengthUnit LengthUnit1,double value2, LengthUnit LengthUnit2) {
        Length length1 = new Length(value1,LengthUnit1);
        Length length2 = new Length(value2,LengthUnit2);
        Length length = length1.add(length2);
        System.out.println("Length Addition  =>  " + length);
        return  length;
    }

    public static Length demonstrateLengthAddition( Length length2,LengthUnit toUnit) {
        if(length2 == null) throw new IllegalArgumentException("Length must not be null");
        if(toUnit == null) throw new IllegalArgumentException("Length unit must not be null");
        Length length1 = new Length(1.0,LengthUnit.FEET);

        Length lengthAddition = length1.add(length2,toUnit);
        System.out.println("Length Addition Different Units =>  " + lengthAddition);
        return lengthAddition;
    }

    public static void main(String[] args) throws Exception {

        demonstrateLengthComparison(1.0, LengthUnit.FEET,12.0, LengthUnit.INCHES);

        demonstrateLengthConversion(12.0,LengthUnit.FEET, LengthUnit.INCHES);
        demonstrateLengthConversion(new Length(1,LengthUnit.CENTIMETER),LengthUnit.INCHES);

        demonstrateLengthAddition(1.0, LengthUnit.FEET,1.0, LengthUnit.YARDS);
        demonstrateLengthAddition(new Length(12,LengthUnit.INCHES),LengthUnit.FEET);
    }
}