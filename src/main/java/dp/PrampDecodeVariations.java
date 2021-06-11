package dp;


/*

This is a pramp.com problem.

Decode Variations
=================
A letter can be encoded to a number in the following way:
'A' -> '1', 'B' -> '2', 'C' -> '3', ..., 'Z' -> '26'
A message is a string of uppercase letters, and it is encoded first using this scheme. For example, 'AZB' -> '1262'
Given a string of digits S from 0-9 representing an encoded message, return the number of ways to decode it.

Examples:
    input:  S = '1262'
    output: 3
    explanation: There are 3 messages that encode to '1262': 'AZB', 'ABFB', and 'LFB'.
    Constraints:

[time limit] 5000ms
[input] string S, 1 ≤ S.length ≤ 12
[output] integer

                          1262
                      1/        12\
                     262           62
                   2/   26\       6/ x\
                   62      2      2
 */
public class PrampDecodeVariations {
    
    public int decodeVariations(String s) {
        
        char[] chars = s.toCharArray();
        
        // Test edge case
        if( chars[chars.length - 1] == '0' ) {
            return 0;
        }
        
        int[] memo = new int[chars.length];
        return calc( chars, 0, memo );
    }
    
    private int calc(char[] chars, int i, int[] memo) {
        // termination
        if( i == chars.length ) {
            return 1;
        }
        if( memo[i] > 0 ) {
            return memo[i];
        }
        
        // take out first char
        int leg1 = calc( chars, i + 1, memo );
        
        // take out first two chars
        int leg2 = 0;
        if( i < chars.length - 1 ) {
            int i2 = 10 * (chars[i] - '0') + (chars[i + 1] - '0'); // in range [1,26]
            if( i2 <= 26 ) {
                leg2 = calc( chars, i + 2, memo );
            }
        }
        memo[i] = leg1 + leg2;
        return memo[i];
    }
    
}
    

