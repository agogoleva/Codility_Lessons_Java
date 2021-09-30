package Codility;

import java.util.Arrays;

public class CyclicRotation {
	
	public int[] solution(int[] A, int K)
	{
		int	l = A.length;
		
		//limitations
		if (l == 0 || K == 0)	//no need to rotate
			return (A);
		int	mod = K % l;
		if (mod == 0)	//full cycle rotation
			return (A);
		
		//algo based on mod as each int will shift its position by mod
		int[]	A_out = new int[l];
		for (int i = 0; i < l; i++)
		{
			if (i + mod < l)			//till last position
				A_out[i + mod] = A[i];
			else						//beyond last position to start
				A_out[i + mod - l] = A[i];
		}
		
		return (A_out);
	}
	
	
    public static void main(String[] args) 
    {
    	int[]	A = {3, 8, 9, 7, 6};
    	int		K = 3;
    	int[]	out = new CyclicRotation().solution(A, K);
    	System.out.println("In: " + Arrays.toString(A));
    	System.out.println("K: " + K);
    	System.out.println("Out: " + Arrays.toString(out));
    }

}

//100%

/*
An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is moved to the first place. For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).

The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.

Write a function:

class Solution { public int[] solution(int[] A, int K); }
that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.

For example, given

    A = [3, 8, 9, 7, 6]
    K = 3
the function should return [9, 7, 6, 3, 8]. Three rotations were made:

    [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
    [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
    [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
For another example, given

    A = [0, 0, 0]
    K = 1
the function should return [0, 0, 0]

Given

    A = [1, 2, 3, 4]
    K = 4
the function should return [1, 2, 3, 4]

Assume that:

N and K are integers within the range [0..100];
each element of array A is an integer within the range [−1,000..1,000].
In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
*/