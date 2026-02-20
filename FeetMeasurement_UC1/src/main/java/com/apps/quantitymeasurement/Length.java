package com.apps.quantitymeasurement;

import java.text.DecimalFormat;

public class Length {
    private double value;
    private LengthUnit unit;

    public double getValue() {
        return value;
    }

    public Length(double value, LengthUnit unit){
            this.value = value;
            this.unit = unit;
    }

    public boolean compare(Length length) {
        if (this.unit == null) throw new IllegalArgumentException("Length unit must not be null");
        if (length.unit == null) throw new IllegalArgumentException("Length unit must not be null");
        double first = this.unit.convertToBaseUnit(this.value);
        double second = length.unit.convertToBaseUnit(length.value);
         return Double.compare(first, second) == 0;
    }

    public Length convertTo(LengthUnit length2) {
        if (length2 == null  ) throw new IllegalArgumentException("Length unit must not be null");
        if (!Double.isFinite(value)) throw new IllegalArgumentException("value must not be null or Infinite or NAN");
        double result = value * (this.unit.getConversionFactor() / length2.getConversionFactor());
        double result1 = Math.round(result * 1000.0) / 1000.0;
        return  new Length(result1, length2);
    }

    public Length add(Length thatLength){
        if (thatLength == null  ) throw new IllegalArgumentException("Length unit must not be null");
        if (!Double.isFinite(value)) throw new IllegalArgumentException("value must not be null or Infinite or NAN");
        Length length = this.addAndConvert(thatLength,this.unit);
         return length;
    }

    public Length add(Length length, LengthUnit targetUnit) {
        if (targetUnit == null) throw new IllegalArgumentException("Length unit must not be null");
        if (length == null  ) throw new IllegalArgumentException("Length must not be null");
        if (!Double.isFinite(value)) throw new IllegalArgumentException("value must not be null or Infinite or NAN");
        Length finalLength = this.addAndConvert(length,targetUnit);
        return finalLength;
    }

    public Length addAndConvert(Length length2, LengthUnit targetUnit) {
        if (targetUnit == null) throw new IllegalArgumentException("Length unit must not be null");
        if (length2 == null  ) throw new IllegalArgumentException("Length must not be null");
        if (!Double.isFinite(value)) throw new IllegalArgumentException("value must not be null or Infinite or NAN");

        double value1 = this.unit.convertToBaseUnit(value);
        double value2 = length2.unit.convertToBaseUnit(length2.value);

        double addedValue = value1  + value2;
        double finalResult = convertFromBaseToTargetUnit(addedValue,targetUnit);

//        finalResult = Math.round(( finalResult * 1000.0)/1000.0);
        DecimalFormat df = new DecimalFormat("#.###");
        finalResult = Double.parseDouble(df.format(finalResult));

        return new Length(finalResult, targetUnit);
    }

    public double convertFromBaseToTargetUnit(double lengthInInches,LengthUnit targetUnit){
        return targetUnit.convertFromBaseUnit(lengthInInches);
    }

    @Override
    public String toString() {
        return String.format(""+value);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || getClass() != obj.getClass()) return false;
        Length length = (Length) obj;
        if(length.unit == null) return false;
        return compare(length);
    }
}
