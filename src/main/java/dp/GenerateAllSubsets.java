package dp;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GenerateAllSubsets {
    
    public List<List<Integer>> generateAllSubsets(int[] s) {
    
        List<List<Integer>> result =  generateRecursively(s, s.length-1);
        Collections.sort( result, (a,b) -> a.size() - b.size());
        System.out.printf( "Count: %d, Sets: %n%s%n",result.size(), result );
        return result;
    }
    
    private List<List<Integer>> generateRecursively(int[] s, int maxIndex) {
        if(maxIndex < 0 ) {
            List<List<Integer>> val = new LinkedList<>();
            val.add( new LinkedList<>() );
            return val;
        }
        
        // include
        List<List<Integer>> include = generateRecursively( s, maxIndex-1 );
        for(List<Integer> lInc : include) {
            lInc.add( s[maxIndex] );
        }
        List<List<Integer>> exclude = generateRecursively( s, maxIndex-1 );
        for(List<Integer> lExc : exclude) {
            include.add( lExc );
        }
        
        return include;
    }
    
}
