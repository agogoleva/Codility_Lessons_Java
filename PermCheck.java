package Codility;

import java.util.*;

public class PermCheck {
	
	public int solution(int[] A)
	{
		int	l = A.length;
		int	out = 0;
		Set<Integer> range = new HashSet<Integer>();
		
		//algo based on set of integers [1:l], if encounter one of them => remove
		//if empty, we got full sequence
		for (int i = 1; i <= l; i++) //populate set with numbers till l including
			range.add(i);
		for (int i = 0; i < l; i++)
		{
			if (range.contains(A[i]))
				range.remove(A[i]);
		}
		if (range.isEmpty())	//permutation == empty range, ie full sequence
			out = 1;
		
		return (out);
	}
	
    public static void main(String[] args) 
    {
    	int[]	A = {4, 1, 3, 2};
    	int		out = new PermCheck().solution(A);
    	System.out.println("In: " + Arrays.toString(A));
    	System.out.println("Out: " + out);
    }

}


//100%

/*
A non-empty array A consisting of N integers is given.

A permutation is a sequence containing each element from 1 to N once, and only once.

For example, array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
is a permutation, but array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
is not a permutation, because value 2 is missing.

The goal is to check whether array A is a permutation.

Write a function:

class Solution { public int solution(int[] A); }
that, given an array A, returns 1 if array A is a permutation and 0 if it is not.

For example, given array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
the function should return 1.

Given array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
the function should return 0.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [1..1,000,000,000].

*/