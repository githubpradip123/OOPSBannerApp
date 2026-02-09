package com.apps.quantitymeasurement;


import java.util.Scanner;

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

    public static void demonstrateFeetEquality()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the First Feet Value:-");
        double feetValue1 = sc.nextDouble();
        System.out.println("Enter the Second Feet Value:-");
        double feetValue2 = sc.nextDouble();
        Feet feet1 = new Feet(feetValue1);
        Feet feet2 = new Feet(feetValue2);
        System.out.println("Result >>" + feet1.equals(feet2));
    }

    public static void demonstrateInchesEquality()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the First Inches Value:-");
        double inchesValue1 = sc.nextDouble();
        System.out.println("Enter the Second Inches Value:-");
        double inchesValue2 = sc.nextDouble();

        Inches inches1 = new Inches(inchesValue1);
        Inches inches2 = new Inches(inchesValue2);
        System.out.println("Result >>" + inches1.equals(inches2));
    }

    public static void main(String[] args) {

        demonstrateFeetEquality();
        demonstrateInchesEquality();
    }
}