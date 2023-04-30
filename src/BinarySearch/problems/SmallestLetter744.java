package BinarySearch.problems;

public class SmallestLetter744 {
    // Leetcode 744 Find Smallest Letter Greater Than Target
    public static void main(String[] args) {

    }

    // Finding the smallest letter greater than the target character
    public char nextGreatestLetter(char[] letters, char target) {

        int start = 0;
        int end = letters.length - 1;

        while (start <= end) {
            // midifying the orignal formula start+end/2 so that it does not cross the Integer MAX Range
            int mid = start + (end - start) / 2;


            if (target < letters[mid]) {
                end = mid - 1;
            } else  {
                start = mid + 1;
            }

        }
        // this will check if any character greater than targe tchar does not eist it will return the oth index
        // We are using modulo here lets say the smallest chat is at 2 if we do 2%4 where 4 is the lenth it will return 2 only
        // this will save our logic space here
        // plz understand modulo here it will return the same index in caseif we find the answer else it will return the
        // 0 as we do 4%$ bcoz at the end codition the start will reach the end of the array

        // we can also write seperate return statement also if we want to make it simple
        return letters[start % letters.length];
    }

}
