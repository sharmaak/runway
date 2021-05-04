package strings;

import java.util.Arrays;

/*
* Determine if a String has all unique characters.
* What if you can not use additional data structures
* */
public class DetectDuplicateChars {
    
    // Keep an int array of size 26, one for each en char.
    // If a char is found, increment the value at the index.
    // Check that all values are 1 in the array
    public boolean solution1(String data) {
        if(data == null || data.isEmpty()) return false;
        
        boolean[] arr = new boolean[26];
        int index;
        data =  data.toLowerCase();
        for(char chr : data.toCharArray()) {
            index = chr-97;
            if(arr[index]) { // if val[index]==true, it means the char was already found.
                return true;
            }
            arr[index] = true;
        }
        return false;
    }
    
    // Sort in place.
    // Check if two neighbouring chars are same : has duplicates
    // Complexity: O(nlogn) + O(n) = O(nlogn)
    public boolean solution2(String data) {
        if(data == null || data.isEmpty()) return false;
        
        char[] chr = data.toLowerCase().toCharArray();
        Arrays.sort(chr);
        for(int i=0; i<chr.length-1; i++) {
            if(chr[i] == chr[i+1]) {
                return true;
            }
        }
        return false;
    }
    
    
    public static void main(String[] args) {
        DetectDuplicateChars app = new DetectDuplicateChars();
        System.out.println(app.solution2( "abcd" ));
        System.out.println(app.solution2( "abcac" ));
    }
}
