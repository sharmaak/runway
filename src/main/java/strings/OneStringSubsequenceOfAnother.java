package strings;

/**
 * Given two strings, check if one string is subsequence of another.
 * Runtime complexity O(N).
 *
 *
 */
public class OneStringSubsequenceOfAnother {
    /**
     * Check if subject is subsequence of source.
     * @return true if subject is subsequence of source.
     */
    public boolean isSubsequence(String source, String subject) {
        // For subject to be subsequence of source, len(subject) <= len(source)
        if(subject == null || source == null ||
           subject.isEmpty() || source.isEmpty() ||
           subject.length() > source.length()) {
            return false;
        }
        
        // At this point, len(subject) <= len(source)
        /*
                    SOURCE              SUBJECT
                    a b c d e f g       c e
                    i | | | |           j |      a != c; increment i
                      i | | |           j |      b != c; increment i
                        i | |           j |      c == c; increment i,j
                          i |             j      d != e; increment i
                            i             j      e == e; increment i,j
        */
        
        int matchingCharCount = 0;
        char[] src = source.toCharArray();
        char[] sub = subject.toCharArray();
        int i = 0; // src index
        int j = 0; // sub index
        while(j < sub.length && i < src.length) {
            if(src[i] != sub[j]) {
                i++;
                continue;
            }
            matchingCharCount++;
            i++;
            j++;
        }
        
        return matchingCharCount == sub.length;
    }
}
