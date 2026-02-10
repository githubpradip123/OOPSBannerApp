package com.apps.quantitymeasurement;

public class Length {

    private double value;
    private LengthUnit unit;

    public enum LengthUnit {
            FEET(12.0),
            INCHES(1.0);

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
    }
}
