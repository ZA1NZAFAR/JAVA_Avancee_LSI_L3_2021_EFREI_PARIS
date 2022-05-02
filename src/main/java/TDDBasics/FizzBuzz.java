package TDDBasics;

public class FizzBuzz {
    public String check(int i) {
        String result = "";
        if (i % 3 == 0)
            result += "Fizz";
        if (i % 5 == 0)
            result += "Buzz";
        return (result.equals("")) ? Integer.toString(i) : result;
    }
}