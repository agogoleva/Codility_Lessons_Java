package Codility;

import java.util.*;

public class PermMissingElem {
	
	public int solution(int[] A)
	{
	   	int l = A.length;
    	
	   	//limitations
    	if (l == 0)
    		return (1);
    	
    	//algo based on HashSet & contains method for a number from 1 to 1
    	Arrays.sort(A);
    	
    	Set<Integer> range = new HashSet<Integer>();
    	
    	for (int i = 0; i < l; i++)		//fill HashSet
    		range.add(A[i]);
    	for (int i = 1; i <= l; i++)	//run through all digits
    		if (!range.contains(i))
    			return (i);
    	
    	return (l + 1);		//if non is the next number is missing
	}
	
    public static void main(String[] args) 
    {
    	int[]	A = {2, 3, 1, 5};
    	int		out = new PermMissingElem().solution(A);
    	System.out.println("In: " + Arrays.toString(A));
    	System.out.println("Out: " + out);
    }

}

//100%

/*
An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.

Your goal is to find that missing element.

Write a function:

class Solution { public int solution(int[] A); }
that, given an array A, returns the value of the missing element.

For example, given array A such that:

  A[0] = 2
  A[1] = 3
  A[2] = 1
  A[3] = 5
the function should return 4, as it is the missing element.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
the elements of A are all distinct;
each element of array A is an integer within the range [1..(N + 1)].
*/