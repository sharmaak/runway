package strings;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/number-of-matching-subsequences/
 *
 * Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.
 *
 * A subsequence of a string is a new string generated from the original string with some characters (can be none)
 * deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 *
 *
 * Example 1:
 *
 * Input: s = "abcde", words = ["a","bb","acd","ace"]
 * Output: 3
 * Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".
 * Example 2:
 *
 * Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
 * Output: 2
 *
 *
 * Constraints:
 *      1 <= s.length <= 5 * 104
 *      1 <= words.length <= 5000
 *      1 <= words[i].length <= 50
 *      s and words[i] consist of only lowercase English letters.
 */
public class LC792NumberOfMatchingSubsequences {
    /*
        The brute force approach is to check each word individually to the source string.
        Run time complexity of checking a word is O(N), where N is the length of the
        source (aka master) string.
        
        We repeat the same check for each test string. Let us say that the test array
        contains M elements, then the complexity turns out to be O(NM).
        
        An optimal solution would be to see if we can do it in single scan of the source string.
        Moreover, the length of the source string can be pretty big!
        
        We shall use a Trie kind of datastructure here to keep track of the alphabet with
        which each word in the source array begins. Let's look at an example:
        
        s = abicjptpp
        words = [ act, abc, bat, ball, eat]
        
        We arrange these words in an array where each index represents an english char
          a b c d e        y   z
        [ 0 1 2 3 4 5.... 25, 26]
         /   \       \
        act  bat     eat
         |    |
        abc  ball
        
        Now we start scanning over the array, let us represent current alphabet in master as 'c'
        
        > c=a, we lookup at index (c-'a'). Next we detect the next char for words which match c and put
        the at the index based on the next char in the word.
        
          a b c d e        y   z
        [ 0 1  2 3 4 5.... 25, 26]
             \  \     \
            bat  \     eat
             |    ct <
            ball
             |
             bc <
         
         >  c='b'. We repeat the same operation at index c-'a'
         
          a b c d e        y   z
        [ 0 1  2 3 4 5... 25, 26]
          |     \     \
          at     \     eat
          |       ct
          all     |
                  c
        > c='i', empty list at index c-'i'
        > c='c', repeat for index c-'c'. One word is exhausted at this point 'abc', so we
          increment the result counter.
          a b c d e        y   z
        [ 0 1  2 3 4 5... 25, 26]
          |     \     \
          at     \     eat
          |       ct
          all     |
                  c
          
          Runtime complexity:
            - One scan over source word O(N)
            - For each alphabet we scan a list in array. Let us say the average length of list
              is L.
            - Overall complexity if O(NL). If L << N, complexity will be O(N), O(LN) otherwise.
    */
    
    public int numMatchingSubseq(String s, String[] words) {
        
        // Create and initialize the lookup array
        List<Word>[] lookup = new LinkedList[26];
        for(int i=0; i<lookup.length; i++) {
            lookup[i] = new LinkedList<>();
        }
        
        // Single pass over all the words and put them in lookup
        int j;
        for(String word : words) {
            j = word.charAt( 0 ) - 'a';
            lookup[j].add( new Word( word, 0 ) );
        }
        // Lookup ready. All that remains is the execution!
        
        int count = 0;
        List<Word> match;
        for(char c : s.toCharArray()) {
            // a. Takeout the list of words which match this char
            match = lookup[c-'a'];
            // b. Reset the list at this node, because all words in it will be moved.
            lookup[c-'a'] = new LinkedList<>();
            // b. Iterate and modify
            for( Word w : match  ) {
                w.increment(); // effective to dropping the current char
                if(w.isExhausted()) {
                    count++;
                } else {
                    lookup[w.currentChar() - 'a'].add( w );
                }
                
            }
        }
        return count;
    }
    
    private class Word {
        private String content;
        private int idx;
        public Word(String content, int idx) {
            this.content = content;
            this.idx = idx;
        }
        
        void increment() {
            idx++;
        }
        
        char currentChar() {
            return content.charAt(idx);
        }
        
        boolean isExhausted() {
            return idx == content.length();
        }
    }
}
