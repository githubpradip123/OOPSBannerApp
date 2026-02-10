package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static class Feet {
        private final double value;

        public Feet(double value)
        {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == null || getClass() != obj.getClass()) return false;
            return Double.compare(this.value,((Feet)obj).value) == 0;
        }
    }

    public static class Inches {
        private final double value;

        public Inches(double value)
        {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == null || getClass() != obj.getClass()) return false;
            return Double.compare(this.value,((Inches)obj).value) == 0;
        }

    }

    public static boolean demonstrateLengthEquality(Length L1,Length L2){
        System.out.println("LengthEquality >>> "+L1.equals(L2));
        return L1.equals(L2);
    }

    public static void demonstrateFeetEquality() {
        Length length1 = new Length(2.0, Length.LengthUnit.FEET);
        Length length2 = new Length(2.0, Length.LengthUnit.FEET);
        System.out.println("Feet Equality =>  " +length1.equals(length2) );
    }

    public static void demonstrateInchesEquality() {
        Length length1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);
        System.out.println("Inches Equality =>  " +length1.equals(length2) );
    }

    public static void demonstrateFeetInchesComparison() {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);
        System.out.println("FEET Inches Comparison =>  " +length1.equals(length2) );
    }

    public static void main(String[] args) {

        demonstrateFeetEquality();
        demonstrateInchesEquality();
        demonstrateFeetInchesComparison();
    }
}