package com.apps.quantitymeasurement;

import java.text.DecimalFormat;

public class Length {
    private double value;
    private LengthUnit unit;

    public double getValue() {
        return value;
    }

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

    private double convertToBaseUnit() {
        if (this.unit == null) {  return 0.0;  }
        if (!Double.isFinite(value)) throw new IllegalArgumentException("value must not be null or Infinite or NAN");
        return this.value * this.unit.getConversionFactor();
    }

    public boolean compare(Length length) {
        double first = this.convertToBaseUnit();
        double second = length.convertToBaseUnit();
         return Double.compare(first, second) == 0;
    }

    public Length convertTo(LengthUnit length2) throws Exception {
        if (length2 == null  ) throw new IllegalArgumentException("Length unit must not be null");
        if (!Double.isFinite(value)) throw new IllegalArgumentException("value must not be null or Infinite or NAN");
        double result = value * (this.unit.conversionFactor/length2.conversionFactor);
        double result1 = Math.round(result * 100.0) / 100.0;
        return  new Length(result1, length2);
    }

    public Length add(Length thatLength){
        double value1 = this.convertToBaseUnit();
        double value2 = thatLength.convertToBaseUnit();
        double addedValue = value1  + value2;
        double finalResult = convertFromBaseToTargetUnit(addedValue,this.unit);
          finalResult = Math.round(finalResult * 100.0) / 100.0;
        return new Length(finalResult,this.unit);
    }

    public double convertFromBaseToTargetUnit(double lengthInInches,LengthUnit targetUnit){
        return lengthInInches / targetUnit.conversionFactor;
    }


    @Override
    public String toString() {
        return String.format(value + " " +unit);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || getClass() != obj.getClass()) return false;
        Length length = (Length) obj;
        if(length.unit == null) return false;
        return compare(length);
    }
}
