package TDDBasics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFizzBuzz {
    FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    public void testWithNumberOne(){
        assertEquals("1", fizzBuzz.check(1));
    }

    @Test
    public void testWithNumberTwo(){
        assertEquals("2", fizzBuzz.check(2));
    }

    @Test
    public void testWithNumberAll(){
        for (int i = 0; i <= 100; i++) {
            System.out.println(fizzBuzz.check(i));
        }
    }

    @Test
    public void testWithNumberDivisibleThree(){
        assertEquals("Fizz", fizzBuzz.check(3));
    }

    @Test
    public void testWithNumberDivisibleFive(){
        assertEquals("Buzz", fizzBuzz.check(5));
    }


}