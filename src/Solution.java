/// Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack

/// Provided below is three solutions to this problem.
class Solution {

    // Basic solution using Java Collections .contains() method
    public static int strStr(String haystack, String needle) {
        if (haystack.contains(needle)) {
            return haystack.indexOf(needle);
        }
        return -1;
    }

    // Solution that uses two pointers (right, left) that iterate on the string haystack till they find a string with the same length as needle
    // then the function checks if the extracted substring is indeed equal to needle
    public static int strStrTwo(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;
        for (int left = 0, right = 0, n = 0, start = -1; right < haystack.length() && n < needle.length(); ) {

            while (right < haystack.length() && n < needle.length() && haystack.charAt(right) == needle.charAt(n)) {
                if (haystack.charAt(right) == haystack.charAt(0)) {
                    start = right;
                }
                if (right - left + 1 == needle.length()) return left;
                ++n;
                ++right;
            }
            n = 0;
            ++left;
            right = left;

        }
        return -1;
    }

    // Solution that uses an extra string res, that replaces the first element of the first occurence of the substring needle in the string haystack. Then it checks if both the original string and res are not equal, and returns the index of the replaced element if present.
    public static int strStrThree(String haystack, String needle) {
        String res = haystack.replaceFirst(needle, "*");
        if (res.equals(haystack)) {
            return -1;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (res.charAt(i) == '*') {
                return i;
            }
        }
        return 0;
    }
}