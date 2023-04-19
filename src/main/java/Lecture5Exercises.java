import jdk.jfr.events.ExceptionThrownEvent;

public class Lecture5Exercises {

    public int randomNumberGenerator(int max) {
        return (int)(Math.random() * max);
    }

    public char randomLowercaseGenerator() {
        int lowercase = (int)((Math.random() * 26) + 97);
        return (char) lowercase;
    }

    public char randomCharacterGenerator() {
        int character = (int)((Math.random() * 94) + 33);
        return (char) character;
    }

    public char specialCharacterGenerator() {
        int special = (int)((Math.random() * 94) + 33);
        if ((33 <= special && special <= 47) || (58 <= special && special <= 64) || (91 <= special && special <= 96) || (123 <= special && special <= 126)) {
            return (char) special;
        }
        else {
            return specialCharacterGenerator();
        }
    }

    public char randomDigitGenerator() {
        int digit = (int)((Math.random() * 10) + 48);
        return (char) digit;
    }

    public String weakPassword(int length) {
        String weakPass = "";
        for (int i = 0; i < length; i++) {
            weakPass = weakPass + randomLowercaseGenerator();
        }
        return weakPass;
    }

    /*
     *   implement a function to create a random password with
     *   given length and at least 1 digit and 1 special character
     *   lecture 5 page 14
     */
    public String strongPassword(int length) throws Exception {
        if (length <= 3) {
            throw new Exception("Password needs to be at least 4 characters long.");
        }
        char[] password = new char[length];
        int specialCharacterPosition = randomNumberGenerator(length);
        password[specialCharacterPosition] = specialCharacterGenerator();
        int numberPosition = randomNumberGenerator(length);
        while (numberPosition == specialCharacterPosition) {
            numberPosition = randomNumberGenerator(length);
        }
        password[numberPosition] = randomDigitGenerator();
        for (int i = 0; i < length; i++) {
            if (i != specialCharacterPosition && i != numberPosition) {
                password[i] = randomCharacterGenerator();
            }
        }
        String finalResult = "";
        for (char c : password) {
            finalResult += c;
        }
        return finalResult;
    }

    /*
     *   implement a function that checks if an integer is a fibobin number
     *   integer n is fibobin if there exist an i where:
     *       n = fib(i) + bin(fib(i))
     *   where fib(i) is the ith fibonacci number and bin(i) is the number
     *   of ones in binary format
     *   lecture 5 page 17
     */
    public long fibonacci(int n) {
        long a = 1, b = 1;
        int i = 2;
        while (i <= n) {
            long sum = a + b;
            a = b;
            b = sum;
            i++;
        }
        return a;
    }

    public int bin(long n) {
        String binaryString = "";
        if (n == 0) {
            binaryString = "0";
        }
        while (n > 0) {
            binaryString = (char) n%2 + binaryString;
            n /= 2;
        }
        int numberOfOnes = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                numberOfOnes++;
            }
        }
        return numberOfOnes;
    }

    public boolean isFiboBin(int n) {
        for (int i = 1; i < 10; i++) {
            if (n == fibonacci(i) + bin(i)) {
                return true;
            }
        }
        return false;
    }
}
