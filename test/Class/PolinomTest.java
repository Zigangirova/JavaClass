package Class;

import main.java.Class.Polinom;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PolinomTest{
    @Test
    public void summing(){
        Polinom inputOne = new Polinom(new int[] {-6, 4, 0, -3}),
                inputTwo = new Polinom(new int[] {11, 3, 7, 9}),
                expected = new Polinom(new int[] {5, 7, 7, 6});
        assertEquals(expected, inputOne.summing(inputTwo));
        }

    @Test
    public void minus(){
        Polinom inputOne = new Polinom(new int[] {27, 9, 5, 0, -3}),
                inputTwo = new Polinom(new int[] {7, 2, -6, -2}),
                expected = new Polinom(new int[] {27, 2, 3, 6, -1});
        assertEquals(expected, inputOne.minus(inputTwo));
    }

    @Test
    public void multiplication(){
        Polinom inputOne = new Polinom(new int[] {2, 1, 0, 5, 4}),
                inputTwo = new Polinom(new int[] {1, 0, 0, 3}),
                expected = new Polinom(new int[] {2, 1, 0, 11, 7, 0, 15, 12});
        assertEquals(expected, inputOne.multiplication(inputTwo));
    }

    @Test
    public void divide(){
        Polinom inputOne = new Polinom(new int[] {8, 2, 0, 8}),
                inputTwo = new Polinom(new int[] {-4, 1, 0}),
                expected = new Polinom(new int[] {-2, -1});
        assertEquals(expected, inputOne.divide(inputTwo));
    }

    @Test
    public void getRemainder(){
        Polinom inputOne = new Polinom(new int[] {8, 2, 0, 8}),
                inputTwo = new Polinom(new int[] {-4, 1, 0}),
                expected = new Polinom(new int[] {1, 8});
        assertEquals(expected, inputOne.getRemainder(inputTwo));
    }

    @Test
    public void substituteX(){
        Polinom inputOne = new Polinom(new int[] {1, 2, 5, 0, -9});
               int expected = 43;
        assertEquals(expected, inputOne.substituteX(2));
    }
}