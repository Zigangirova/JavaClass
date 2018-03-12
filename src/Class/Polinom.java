package Class;

public class Polinom {
    String strCoef;

    public Polinom(String strCoef) {
        this.strCoef = strCoef;
    }


    public int[] makeArray(String strCoef) {
        int length = strCoef.length();
        int numberMinus = 0;
        for (int i = 0; i < length; i++) {
            if (strCoef.charAt(i) == '-') {
                numberMinus++;
            }
        }
        int[] res = new int[length - numberMinus];
        int i = 0;
        while (i != length) {
            if (!strCoef.substring(i, i + 1).equals('-'))
                res[i] = Integer.parseInt(strCoef.substring(i, i + 1));
            else {
                strCoef = removeCharAt(strCoef, i);
                i++;
                res[i] = -Integer.parseInt(strCoef.substring(i, i + 1));
            }
            i++;
        }
        return res;
    }

    public static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }

    public int[] summing(String strPolinomOther) {
        int[] polinom = makeArray(strCoef);
        int[] polinomOther = makeArray(strPolinomOther);
        int maxLength = Math.max(polinom.length, strPolinomOther.length());
        int minLength = Math.min(polinom.length, strPolinomOther.length());
        int[] res = new int[maxLength];
        for (int i = 0; i < minLength; i++) {
            res[i] = polinom[i] + polinomOther[i];
        }
        if (polinom.length > polinomOther.length)
            for (int i = minLength; i < maxLength; i++) {
                res[i] = polinom[i];
            }
        else for (int i = minLength; i < maxLength; i++) {
            res[i] = polinomOther[i];
        }
        return res;
    }

    public int[] minus(String strPolinomOther) {
        int[] polinom = makeArray(strCoef);
        int[] polinomOther = makeArray(strPolinomOther);
        int maxLength = Math.max(polinom.length, strPolinomOther.length());
        int minLength = Math.min(polinom.length, strPolinomOther.length());
        int[] res = new int[maxLength];
        for (int i = 0; i < minLength; i++) {
            res[i] = polinom[i] - polinomOther[i];
        }
        if (polinom.length > polinomOther.length)
            for (int i = minLength; i < maxLength; i++) {
                res[i] = polinom[i];
            }
        else for (int i = minLength; i < maxLength; i++) {
            res[i] = -polinomOther[i];
        }
        return res;

    }
}
