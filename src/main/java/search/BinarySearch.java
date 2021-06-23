package search;

// Binary Search

/*
	k=4
	{1,2,3,4,5,6,7,8,9} i=0, j=8, m=0+(8-0)/2=4, 4<5
	{1,2,3,4,5,6,7,8,9} i=0, j=3, m=0+(3-0)/2=1, 4>2
	{1,2,3,4,5,6,7,8,9} i=2, j=3, m=2+(3-2)/2=2, 4>3
	{1,2,3,4,5,6,7,8,9} i=3, j=3, m=3+(3-3)/2=3, 4==4
*/

public class BinarySearch {
    public static void main(String ... args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        BinarySearch bin = new BinarySearch();
        Integer result = bin.search(arr, 0, arr.length-1, 5);
        assert(result == 5);
        System.out.println(result);
        result = bin.search(arr, 0,arr.length-1, 22);
        assert(result == null);
        System.out.println(result);
    }
    
    Integer search(int[] arr, int i, int j, int k ) {
        if(arr == null || arr.length == 0 || i>j) {
            return null;
        }
        
        if(i==j) {
            if( arr[i] == k ) {
                return k;
            } else {
                return null;
            }
        }
        
        // 1. Find midpoint
        int mid = i+(j-i)/2;
        if(arr[mid] == k) {
            return k;
        } else if(k > arr[mid]) {
            i=mid+1;
        } else {
            j=mid+1;
        }
        
        return search(arr, i, j, k);
    }
}

