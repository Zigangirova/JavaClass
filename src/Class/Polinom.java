package Class;

public class Polinom {
    private int[] coefficients;

    public Polinom(int... coefficients) {
        this.coefficients = coefficients;
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
        for (int i = 0; i < newCoefficients.length; i++) {
            System.out.println(newCoefficients[i]);
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


    public Polinom maxPoly(Polinom polynom, Polinom polynomOther) {
        if (polynom.coefficients.length > polynomOther.coefficients.length) return polynom;
        else return polynomOther;
    }


    public Polinom minPoly(Polinom polynom, Polinom polynomOther) {
        if (polynom.coefficients.length > polynomOther.coefficients.length) return polynomOther;
        else return polynom;
    }
}


