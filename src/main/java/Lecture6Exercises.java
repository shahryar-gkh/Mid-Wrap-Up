import java.util.ArrayList;
import java.util.List;

public class Lecture6Exercises {

    /*
     *   implement a function that takes an array of int and return sum of
     *   elements at even positions
     *   lecture 6 page  16
     */
    public long calculateEvenSum(int[] arr) {
        long sum = 0;
        for (int i = 0; i < arr.length; i += 2) {
            sum += arr[i];
        }
        return sum;
    }

    /*
     *   implement a function that takes an array of int and return that
     *   array in reverse order
     *   lecture 6 page 16
     */
    public int[] reverseArray(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[arr.length - i - 1] = arr[i];
        }
        return result;
    }

    /*
     *   implement a function that calculate product of two 2-dim matrices
     *   lecture 6 page 21
     */
    public double[][] matrixProduct(double[][] m1, double[][] m2) throws RuntimeException {
        if (m1.length != m2[0].length) {
            throw new RuntimeException("The number of first matrix's columns should be equal to the number of the second matrix's rows.");
        }
        double[][] result = new double[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[i].length; j++) {
                result[i][j] = 0;
                for (int k = 0; k < m1[i].length; k++) {
                    result[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return result;
    }

    /*
     *   implement a function that return array list of array list of string
     *   from a 2-dim string array
     *   lecture 6 page 30
     */
    public List<List<String>> arrayToList(String[][] names) {
        List<List<String>> arraylistOfArraylists = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            List<String> arrayListOfStrings = new ArrayList<>();
            for (int j = 0; j < names[i].length; j++) {
                arrayListOfStrings.add(j, names[i][j]);
            }
            arraylistOfArraylists.add(i, arrayListOfStrings);
        }
        return arraylistOfArraylists;
    }

    /*
     *   implement a function that return a list of prime factor of integer n
     *   in ascending order
     *   lecture 6 page 30
     */
    public List<Integer> primeFactors(int n) {
        List<Integer> allPrimes = new ArrayList<>();
        int index = 0;
        for (int i = 2; i < n; i++) {
            while (n % i == 0) {
                allPrimes.add(index, i);
                n = n/i;
                index++;
            }
        }
        if (n > 2) {
            allPrimes.add(index, n);
        }
        List<Integer> finalResult = new ArrayList<>();
        int counter = 0;
        for (int i : allPrimes) {
            if (!finalResult.contains(i)) {
                finalResult.add(counter, i);
                counter++;
            }
        }
        return finalResult;
    }

    /*
     *   implement a function that return a list of words in a given string
     *   lecture 6 page 30
     */
    public List<String> extractWord(String line) {
        List<String> listOfWords = new ArrayList<>();
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String word = "";
        int index = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ' ' || i == line.length()-1) {
                if (word.length() != 0) {
                    listOfWords.add(index, word);
                    word = "";
                    index++;
                }
            }
            else {
                if (0 <= alphabet.indexOf(line.charAt(i))) {
                    word += line.charAt(i);
                }
            }
        }
        return listOfWords;
    }
}