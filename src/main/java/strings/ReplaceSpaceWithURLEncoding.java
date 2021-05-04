package strings;

public class ReplaceSpaceWithURLEncoding {
    
    private static final char SPC=' ';
    
    private int solution(char[] str, int len ) {
        // 1. First pass, find out how many spaces exist
        int spaceCount = 0;
        for(char chr : str) {
            if(chr == SPC) {
                spaceCount++;
            }
        }
        
        // 2. Find the new length
        int newLength = len + spaceCount * 2; // 2 is the additional length between ' ' and '%20'. 2=3-1
        System.out.printf("len=%d, spaceCount=%d, newLength=%d %n", len, spaceCount, newLength );
        
        // 3. Substitute. Since we want to do it in-place, we will go backwards to avoid over-writing.
        //    When doing in-place string manipulation, it is a standard trick to start from end work
        //    backwards. This ensures we do not overwrite.
        int srcIndex=len-1, targetIndex=newLength-1;
        while(srcIndex > 0) {
            if(str[srcIndex] != SPC) {
                // simply copy over
                str[targetIndex] = str[srcIndex];
                targetIndex--;
            } else {
                str[targetIndex]  ='0';
                str[targetIndex-1]='2';
                str[targetIndex-2]='%';
                targetIndex = targetIndex-3;
            }
            srcIndex--;
        }
         return newLength;
    }
    
    public static void main(String[] args) {
        ReplaceSpaceWithURLEncoding app = new ReplaceSpaceWithURLEncoding();
        String input = "I heard Joe say \"So  be it ,\"";
        char[] data = app.toSafeCharArray(input.toCharArray());
        int newLength = app.solution(data, input.length());
        System.out.printf("input: %s%noutput: %s%n", input, new String(data, 0, newLength));
    }
    
    private char[] toSafeCharArray(char[] src) {
        char[] target = new char[src.length * 3]; // worst case, if all chars are spaces
        System.arraycopy( src, 0, target, 0, src.length );
        return target;
    }
}
