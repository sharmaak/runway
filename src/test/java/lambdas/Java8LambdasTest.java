package lambdas;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Java8LambdasTest {
    
    private static final Logger LOG = LoggerFactory.getLogger( Java8LambdasTest.class );
    
    @Test
    public void testComparator() {
        int[][] data = {
                {2, 20}, {1, 10}, {4, 40}, {3, 30},  {5, 50}
        };
    
        int[][] resultAscFirstElement = {
                {1, 10}, {2, 20}, {3, 30}, {4, 40}, {5, 50}
        };
    
        int[][] resultDescSecondElement = {
                {5, 50}, {4, 40}, {3, 30}, {2, 20}, {1, 10}
        };
        
        // Sort ascending by first elements of all sub-arrays;
        Arrays.sort(data, (a,b) -> a[0]-b[0]);
        LOG.info("Array: sorted: e0:: {}", Arrays.deepToString(data));
        assertArrayEquals(resultAscFirstElement, data);
        
        // Sort descending by second element of each sub-array;
        Arrays.sort(data, (a,b) -> b[1]-a[1]);
        LOG.info("Array: sorted: e1:: {}", Arrays.deepToString(data));
        assertArrayEquals(resultDescSecondElement, data);
    }
    
    @Test
    public void testForEach() {
        // forEach example
        int[] a = { 1,2,3,4,5,6,7,8,9};
        List<Integer> squares = new LinkedList<>();
        Arrays.stream(a).forEach( v -> squares.add(v*v) );
        System.out.println(squares);
    }
    
    @Test
    public void testStreamMapExample() {
        // map() example 1: mapping integers to strings
        Integer[] a = { 1,2,3,4,5,6,7,8,9 };
        List<String> hellos = Arrays.stream(a)
                                    .map( x -> "hello: " + x )
                                    .collect( Collectors.toList() );
        System.out.println(hellos);
        
        // map() example 2: In case of primitive int, double, long the map() operation will not
        // work. Refer to JavaDoc for details. If mapping primitives into other types, use
        // mapToObj() instead.
        int[] b ={ 10,20,30,40,50,60,70,80,90 };
        Set<String> byes = Arrays.stream(b)
                                 .mapToObj( n -> "bye: " + n*n )
                                 .collect( Collectors.toSet() );
        System.out.println(byes);
    }
    
    @Test
    public void testStreamFilter() {
        List<String> out =
        Stream.iterate( "", x -> Integer.toHexString(new Random().nextInt()) )
              .filter( e -> e.endsWith( "f" ) )
              .limit( 5 )
              .collect( Collectors.toList() );
        System.out.println(out);
    }
    
    @Test
    public void testFindFirstOrNull() {
        
        String[] names = {"Amit", "Ankit", "Ramesh", "Suresh"};
    
        String out = Arrays.stream(names)
                           .filter( e -> e.endsWith( "z" ) )
                           .findFirst()
                           .orElse( null );
        
        System.out.println(out);
    }
}
