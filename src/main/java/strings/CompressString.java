package strings;

import java.util.Arrays;

public class CompressString {
    
    public int compress(char[] input) {
        if(input.length ==0 ) {
            return 0;
        }
        
        if(input.length == 1) {
            return 1;
        }
        
        int pivotIdx=0; // The index of char being processed
        int i=1;        // The current index
        int writeIdx=0; // The index at which we should write the next char of compressed string. Will also indicate len
        int count=0;    // keeps count of duplicates found
        
        while(i<input.length) {
            
            if(input[pivotIdx] == input[i]) { // can compress
                count = 2;
                i++;
                while(i<input.length && input[pivotIdx] == input[i]) {
                    count++;
                    i++;
                }
                
                input[writeIdx] = input[pivotIdx]; // copy over the char being compressed to writeIdx
                writeIdx++;
                pivotIdx=i;
                i++;
                
                
                // add the count. Convert int to char array and copy to the original array.
                char[] t = Integer.toString( count ).toCharArray();
                System.arraycopy( t, 0, input, writeIdx, t.length );
                writeIdx = writeIdx + t.length;
            } else { // move on
                
                // abcd
                // ^^
                input[writeIdx] = input[pivotIdx];
                writeIdx++;
                pivotIdx++;
                i++;
            }
            
            if(pivotIdx == input.length-1) {
                input[writeIdx] = input[pivotIdx];
                writeIdx++;
            }
            //System.out.println(Arrays.toString( input ));
        }
        //System.out.printf("Result: %s, len=%d%n", Arrays.toString(input), writeIdx);
        return writeIdx;
    }
    
    public static void main(String ... args) {
        CompressString app = new CompressString();
        String[] testCases = new String[]{
                "abc",
                "abcccd",              // abcd
                "abbcccdddd",        // ab2c3d4
                "aaabbbbbeeeeeee",   // a3b5e7
                "axxxxxxxxxxxxxxxee", // ax15e2
                "axxxxxxxxxxxxxxxiiiiiiiiiiiiiiiiiiiiii" //ax15i22
                
        };
        Arrays.stream( testCases ).forEach( x -> {
            char[] chr = x.toCharArray();
            int len = app.compress( chr );
            System.out.printf( "in=%s, out=%s%n", x, new String(chr, 0, len) );
        });
    }
}
