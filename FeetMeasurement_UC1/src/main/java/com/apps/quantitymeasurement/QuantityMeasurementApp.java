package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {
    
    public static boolean demonstrateLengthEquality(Length L1,Length L2){
        System.out.println("Length Equality >>> "+L1.equals(L2));
        return L1.equals(L2);
    }

    public static void demonstrateLengthComparison(double value1, Length.LengthUnit LengthUnit1,double value2, Length.LengthUnit LengthUnit2) {
        Length length1 = new Length(value1,LengthUnit1);
        Length length2 = new Length(value2,LengthUnit2);
        System.out.println("Length Equality Check =>  " +length1.equals(length2) );
    }

    public static void main(String[] args) {

        demonstrateLengthComparison(1.0, Length.LengthUnit.FEET,12.0, Length.LengthUnit.INCHES);
        demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS,36.0, Length.LengthUnit.INCHES);
        demonstrateLengthComparison(100.0, Length.LengthUnit.CENTIMETER,39.3701, Length.LengthUnit.INCHES);
        demonstrateLengthComparison(3.0, Length.LengthUnit.FEET,1.0, Length.LengthUnit.YARDS);
        demonstrateLengthComparison(30.48, Length.LengthUnit.CENTIMETER,1.0, Length.LengthUnit.FEET);

    }
}