package main.java.Class;

import java.util.Arrays;

public class Polinom {
    private int[] coefficients;

    public Polinom(int... coefficients) {
        int i;
        final int length = coefficients.length;
        for (i = 0; i < length; i++) {
            if (coefficients[i] != 0) {
                break;
            }
        }
        this.coefficients = new int[length - i];
        final int shift = i;
        for (; i < length; i++) {
            this.coefficients[i - shift] = coefficients[i];
        }
    }


    public Polinom summing(Polinom polynomOther) {
        Polinom polynom = new Polinom(coefficients);
        int maxLength = Math.max(polynom.coefficients.length, polynomOther.coefficients.length);
        int minLength = Math.min(polynom.coefficients.length, polynomOther.coefficients.length);
        int[] newCoefficients = new int[maxLength];
        int[] maxArray = maxPoly(polynom, polynomOther).coefficients;
        int[] minArray = minPoly(polynom, polynomOther).coefficients;
        for (int i = 0; i < maxLength - minLength; i++) {
            newCoefficients[i] = maxArray[i];
        }
        for (int i = maxLength - minLength; i < maxLength; i++) {
            newCoefficients[i] = maxArray[i] + minArray[-maxLength + minLength + i];
        }
        return new Polinom(newCoefficients);
    }


    public Polinom minus(Polinom polynomOther) {
        Polinom polynom = new Polinom(coefficients);
        int maxLength = Math.max(polynom.coefficients.length, polynomOther.coefficients.length);
        int minLength = Math.min(polynom.coefficients.length, polynomOther.coefficients.length);
        int[] newCoefficients = new int[maxLength];
        int[] maxArray = maxPoly(polynom, polynomOther).coefficients;
        int[] minArray = minPoly(polynom, polynomOther).coefficients;
        for (int i = 0; i < maxLength - minLength; i++) {
            newCoefficients[i] = maxArray[i];
        }
        for (int i = maxLength - minLength; i < maxLength; i++) {
            newCoefficients[i] = maxArray[i] - minArray[-maxLength + minLength + i];
        }
        return new Polinom(newCoefficients);
    }

    public Polinom multiplication(Polinom polynomOther) {
        Polinom polynom = new Polinom(coefficients);
        int maxLength = Math.max(polynom.coefficients.length, polynomOther.coefficients.length);
        int minLength = Math.min(polynom.coefficients.length, polynomOther.coefficients.length);
        int[] newCoefficients = new int[maxLength + minLength - 1];
        for (int i = 0; i < polynom.coefficients.length; i++) {
            for (int j = 0; j < polynomOther.coefficients.length; j++) {
                newCoefficients[i + j] += polynom.coefficients[i] * polynomOther.coefficients[j];
            }
        }
        return new Polinom(newCoefficients);
    }

    public Polinom divide(Polinom polynomOther) {
        return this.getPrivateAndRemainder(polynomOther)[0];
    }

    public Polinom getRemainder(Polinom polynomOther) {
        return this.getPrivateAndRemainder(polynomOther)[1];
    }



    public int substituteX(int x) {
        int value = 0;
        final int maxPow = coefficients.length - 1;
        for (int i = 0; i < maxPow; i++) {
            value += coefficients[i] * (int) Math.pow(x, maxPow - i);
        }
        return value + coefficients[maxPow];
    }

    private Polinom[] getPrivateAndRemainder(Polinom polynomOther){
        final int firstLength = coefficients.length;
        final int secondLength = polynomOther.coefficients.length;

        if (firstLength < secondLength) throw new IllegalArgumentException();

        final int newLength = firstLength - secondLength + 1;
        final int[] newCoefficients = new int[newLength];
        final int[] mutableCoefficients = coefficients;

        int shift = 0;

        for (int i = 0; i < newLength; i++) {
            final int currentCoefficient = mutableCoefficients[shift] / polynomOther.coefficients[0];
            newCoefficients[i] = currentCoefficient;

            for (int j = shift; j < shift + newLength; j++) {
                mutableCoefficients[j] -= currentCoefficient * polynomOther.coefficients[j - shift];

            }

            shift++;
        }

        int remainderLength = firstLength - newLength;
        final int[] remainder = new int[remainderLength];
        for (int i = 0; i < remainderLength; i++) {
            remainder[i] = mutableCoefficients[newLength + i];
        }

        return new Polinom[]{new Polinom(newCoefficients), new Polinom(remainder)};
    }

    public Polinom maxPoly(Polinom polynom, Polinom polynomOther) {
        if (polynom.coefficients.length > polynomOther.coefficients.length) return polynom;
        else return polynomOther;
    }


    public Polinom minPoly(Polinom polynom, Polinom polynomOther) {
        if (polynom.coefficients.length > polynomOther.coefficients.length) return polynomOther;
        else return polynom;
    }


    @Override
    public int hashCode() {
        return Arrays.hashCode(coefficients);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object instanceof Polinom) {
            Polinom polynomOther = (Polinom) object;
            return Arrays.equals(coefficients, polynomOther.coefficients);
        }
        return false;
    }

    @Override
    public String toString() {
        String coefficientsToString = "";
        for (int i = 0; i < coefficients.length; i++) {
            coefficientsToString += coefficients[i] + " ";
        }
        return coefficientsToString;
    }
}



