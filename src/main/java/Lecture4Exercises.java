import java.lang.reflect.Array;

public class Lecture4Exercises {
    public long factorial(int n) {
        long result = 1;
        for (int i = n; i > 0; i--) {
            result *= i;
        }
        return result;
    }

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

    public String reverse(String word) {
        int length = word.length();
        String reversed = "";
        for (int i = length-1; i >= 0; i--) {
            reversed = reversed + word.charAt(i);
        }
        return reversed;
    }

    public boolean isPalindrome(String line) {
        line = line.replaceAll("\\s+", "");
        line = line.toLowerCase();
        System.out.println(line);
        int i = 0, j = line.length()-1;
        while (i < j) {
            if (line.charAt(i) != line.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public char[][] dotPlot(String str1, String str2) {
        char[][] result = new char[str1.length()][str2.length()];
        for (int i = 0; i < str1.length(); i++) {
            char character = str1.charAt(i);
            for (int j = 0; j < str2.length(); j++) {
                if (str2.charAt(j) == character) {
                    result[i][j] = '*';
                }
                else {
                    result[i][j] = ' ';
                }
            }
        }
        return result;
    }
}
