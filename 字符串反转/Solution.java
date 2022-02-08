class Solution {
    public void reverseString(char[] s) {
        int sLength = s.length;
        for (int left = 0, right = sLength - 1; left < right; left++, right--) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }
}