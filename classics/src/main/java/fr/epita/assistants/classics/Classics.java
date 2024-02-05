package fr.epita.assistants.classics;

import org.eclipse.aether.util.StringUtils;

public class Classics {
    /**
     * Computes the factorial of n.
     * @param n the nth value to compute, negative values should return -1
     *
     * @return the long value of n!
     */
    public static long factorial(int n) {
        if (n < 0)
        {
            return -1;
        }
        int res = 1;
        while (n > 0)
        {
            res *= n;
            n--;
        }
        return res;
    }

    /**
     * Computes the nth value of the tribonacci suite.
     * f(0) = 0, f(1) = 1, f(2) = 1, f(n+3) = f(n) + f(n+1) + f(n+2)
     *
     * @param n the nth sequence to compute
     */
    public static long tribonacci(int n) {
        int f0 = 0;
        int f1 = 1;
        int f2 = 1;

        if (n == 0)
        {
            return 0;
        }
        if (n == 1 || n == 2)
        {
            return 1;
        }
        for (int i = 2; i < n; i++)
        {
            int tmp = f0;
            f0 = f1;
            f1 = f2;
            f2 = f2 + f0 + tmp;
        }
        return f2;
    }

    /**
     * Checks if a word is a palindrome.
     *
     * @param word the string to check
     * @return true if the word is a palindrome, false otherwise.
     */
    public static boolean isPalindrome(String word) {
        if (word == null)
        {
            return false;
        }
        if (word.isEmpty())
        {
            return true;
        }
        word = word.toLowerCase();
        int n = word.length();
        int i = 0;
        int j = n - 1;
        while (i < j) {
            if (word.charAt(i) == ' ') {
                i++;
                continue;
            }
            if (word.charAt(j) == ' ') {
                j--;
                continue;
            }
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * Sorts an array using an insertion sort.
     *
     * @param array the array to sort in place
     */
    public static void insertionSort(int[] array) {
        int i = 1;
        int len = array.length;
        int j = 0;
        while (i < len)
        {
            j = i;
            while (j > 0 && array[j - 1] > array[j])
            {
                int tmp = array[j];
                array[j] = array[j-1];
                array[j-1] = tmp;
                j--;
            }
            i++;
        }
    }

    /**
     * Combines two strings by alternating their characters. Must use a StringBuilder.
     * If the strings do not have the same length, appends the remaining characters at the end of the result.
     * For instance, combine("abc", "def") returns "adbecf"
     */
    public static String combine(String a, String b) {
        if (a.isEmpty() && b.isEmpty()) {
            return "";
        }
        if (a.isEmpty()) {
            return b;
        }
        if (b.isEmpty()) {
            return a;
        }
        StringBuffer res = new StringBuffer("");
        int i = 0;
        int j = 0;
        int k = 0;
        int len_a = a.length();
        int len_b = b.length();
        while (k < len_a + len_b)
        {
            if (i < len_a)
            {
                res.insert(k, a.charAt(i));
                i++;
                k++;
            }
            if (j < len_b)
            {
                res.insert(k, b.charAt(j));
                j++;
                k++;
            }
        }
        return res.toString();
    }
}
