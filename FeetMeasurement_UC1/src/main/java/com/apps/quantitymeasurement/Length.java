package com.apps.quantitymeasurement;

public class Length {

    private double value;
    private LengthUnit unit;

    public enum LengthUnit {
            FEET(12.0),
            INCHES(1.0),
            YARDS(36.0),
            CENTIMETER(0.393701);

            private final double conversionFactor;

            LengthUnit(double conversionFactor)
            {
                this.conversionFactor = conversionFactor;
            }
            public double getConversionFactor(){
                return conversionFactor;
        }
    }

    public Length(double value, LengthUnit unit){
            this.value = value;
            this.unit = unit;
    }

    private double convertToBaseUnit()
    {
        if (this.unit == null) {  return 0.0;  }
        return this.value * this.unit.getConversionFactor();
    }

    public boolean compare(Length length)
    {
        double first = this.convertToBaseUnit();
        double second = length.convertToBaseUnit();
         return Double.compare(first, second) == 0;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || getClass() != obj.getClass()) return false;
        Length length = (Length) obj;
        if(length.unit == null) return false;
        return compare(length);
    }
    public static void main(String[] args) {
        Length length1 = new Length(1.0,LengthUnit.FEET);
        Length length2 = new Length(12.0,LengthUnit.INCHES);
        System.out.println("Are Length Equals? =>  " +length1.equals(length2) );

        Length length3 = new Length(1.0,LengthUnit.YARDS);
        Length length4 = new Length(36.0,LengthUnit.INCHES);
        System.out.println("Are Length Equals? =>  " +length3.equals(length4) );

        Length length5 = new Length(100.0,LengthUnit.CENTIMETER);
        Length length6 = new Length(39.3701,LengthUnit.INCHES);
        System.out.println("Are Length Equals? =>  " +length5.equals(length6) );
    }
}
