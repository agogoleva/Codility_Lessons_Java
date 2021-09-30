package Codility;

import java.util.*;

public class CountDistinctSlices {

	public int solution(int M, int[] A)
	{
		int		l = A.length;
		int		out = 0;
		int		front = 0;
		int		back = 0;
		boolean[] cond = new boolean[M + 1];
		Arrays.fill(cond, false);
		
		while (front < l && back < l)
		{
			while (front < l && !cond[A[front]])
				{
					out += (front - back + 1);
					cond[A[front]] = true;
					front += 1;
					if (out > 1000000000)
						return (1000000000);
				}
			while (front < l && back < l && A[back] != A[front])
				{
					cond[A[back]] = false;
					back += 1;
				}

			cond[A[back]] = false;
			back += 1;
		}
		
		return (out);
	}
	
	/*
	    public int solution(int M, int[] A) {
        // write your code in Java SE 8
        int l = A.length;
        long count = 0;

        if (l == 1) return 1;

        int front = 0;
        int[] counter = new int[M + 1];

        for (int i = 0; i < l; i++) 
        {
            while(front < l && counter[A[front]] == 0 ) 
            {
                count += front - i + 1;
                counter[A[front++]] = 1;
            }

            while(front < l && A[i] != A[front] && i < front) 
                counter[A[i++]] = 0;

            counter[A[i]] = 0;

           if (count > 1_000_000_000)
                return 1_000_000_000;
        }

        return (int) count;
    }
    */
	
    public static void main(String[] args) 
    {
    	int		M = 6;
    	int[]	A = {3, 4, 5, 5, 2};
    	int 	out = new CountDistinctSlices().solution(M, A);
    	System.out.println("In: M = " + M);
    	System.out.println("In: " + Arrays.toString(A));
    	System.out.println("Out: "+ out);
    }
}

//100%

/*
An integer M and a non-empty array A consisting of N non-negative integers are given. All integers in array A are less than or equal to M.

A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A. The slice consists of the elements A[P], A[P + 1], ..., A[Q]. A distinct slice is a slice consisting of only unique numbers. That is, no individual number occurs more than once in the slice.

For example, consider integer M = 6 and array A such that:

    A[0] = 3
    A[1] = 4
    A[2] = 5
    A[3] = 5
    A[4] = 2
There are exactly nine distinct slices: (0, 0), (0, 1), (0, 2), (1, 1), (1, 2), (2, 2), (3, 3), (3, 4) and (4, 4).

The goal is to calculate the number of distinct slices.

Write a function:

class Solution { public int solution(int M, int[] A); }

that, given an integer M and a non-empty array A consisting of N integers, returns the number of distinct slices.

If the number of distinct slices is greater than 1,000,000,000, the function should return 1,000,000,000.

For example, given integer M = 6 and array A such that:

    A[0] = 3
    A[1] = 4
    A[2] = 5
    A[3] = 5
    A[4] = 2
the function should return 9, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
M is an integer within the range [0..100,000];
each element of array A is an integer within the range [0..M].
*/
