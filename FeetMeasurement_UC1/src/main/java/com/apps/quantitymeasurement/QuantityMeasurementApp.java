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

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the First Value");
        double feetValue1 = sc.nextDouble();
        System.out.println("Enter the Second Value");
        double feetValue2 = sc.nextDouble();
        Feet feet1 = new Feet(feetValue1);
        Feet feet2 = new Feet(feetValue2);
        System.out.println("Result >>" + feet1.equals(feet2));
    }
}