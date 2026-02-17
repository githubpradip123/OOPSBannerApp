package com.apps.quantitymeasurement;


public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(Length L1,Length L2){
        System.out.println("Length Equality >>> "+L1.equals(L2));
        return L1.equals(L2);
    }

    public static void demonstrateLengthComparison(double value1, Length.LengthUnit LengthUnit1,double value2, Length.LengthUnit LengthUnit2) {
        Length length1 = new Length(value1,LengthUnit1);
        Length length2 = new Length(value2,LengthUnit2);
        System.out.println("Length Equality Check =>  " +demonstrateLengthEquality(length1,length2) );
    }

    public static Length demonstrateLengthConversion(double value1, Length.LengthUnit FromUnit,Length.LengthUnit ToUnit) throws Exception {
        Length length1 = new Length(value1,FromUnit);
        Length length = length1.convertTo(ToUnit);
         return length;
    }

    public static Length demonstrateLengthConversion( Length length,Length.LengthUnit toUnit) throws Exception {
        if(length == null) throw new IllegalArgumentException("Length must not be null");
        if(toUnit == null) throw new IllegalArgumentException("Length unit must not be null");
        Length lengthConversion = length.convertTo(toUnit);
        return lengthConversion;
    }

    public static Length demonstrateLengthAddition(double value1, Length.LengthUnit LengthUnit1,double value2, Length.LengthUnit LengthUnit2) {
        Length length1 = new Length(value1,LengthUnit1);
        Length length2 = new Length(value2,LengthUnit2);
        Length length = length1.add(length2);
        System.out.println("Length Addition  =>  " + length);
        return  length;
    }

    public static Length demonstrateLengthAddition( Length length2,Length.LengthUnit toUnit) {
        if(length2 == null) throw new IllegalArgumentException("Length must not be null");
        if(toUnit == null) throw new IllegalArgumentException("Length unit must not be null");
        Length length1 = new Length(1.0,Length.LengthUnit.FEET);

        Length lengthAddition = length1.add(length2,toUnit);
        System.out.println("Length Addition Different Units =>  " + lengthAddition);
        return lengthAddition;
    }




    public static void main(String[] args) throws Exception {

        demonstrateLengthComparison(1.0, Length.LengthUnit.FEET,12.0, Length.LengthUnit.INCHES);

        demonstrateLengthConversion(12.0,Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        demonstrateLengthConversion(new Length(1,Length.LengthUnit.CENTIMETER),Length.LengthUnit.INCHES);

        demonstrateLengthAddition(1.0, Length.LengthUnit.FEET,1.0, Length.LengthUnit.YARDS);
        demonstrateLengthAddition(new Length(12,Length.LengthUnit.INCHES),Length.LengthUnit.FEET);


    }
}