package com.apps.quantitymeasurement;

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

    public double convertToBaseUnit(double value) {

        if (!Double.isFinite(value)) throw new IllegalArgumentException("value must not be null or Infinite or NAN");
        return value * this.getConversionFactor();
    }

    public double convertFromBaseUnit(double baseValue) {
        return baseValue / this.getConversionFactor();
    }

}