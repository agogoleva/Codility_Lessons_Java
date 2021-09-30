package Codility;

import java.util.Arrays;

public class OddOccurrencesInArray 
{
	public int solution(int[] A)
	{
		int	l = A.length;
		//limitations
		if (l == 1)
			return (A[0]);
		//algo based on pair of elements in sorted array
		Arrays.sort(A);
		for (int i = 0; i < l - 1; i+=2)	//loop with step 2 till end - 1
		{
			if (A[i] != A[i+1])
				return (A[i]);	//unpaired
		}
		
		return (A[l - 1]);		//last is unpaired
	}
	
    public static void main(String[] args) 
    {
    	int[]	A = {9, 3, 9, 3, 9, 7, 9};
    	int		out = new OddOccurrencesInArray().solution(A);
    	System.out.println("In: " + Arrays.toString(A));
    	System.out.println("Out: " + out);
    }

}

//100%

/*
A non-empty array A consisting of N integers is given. The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.

For example, in array A such that:

  A[0] = 9  A[1] = 3  A[2] = 9
  A[3] = 3  A[4] = 9  A[5] = 7
  A[6] = 9
the elements at indexes 0 and 2 have value 9,
the elements at indexes 1 and 3 have value 3,
the elements at indexes 4 and 6 have value 9,
the element at index 5 has value 7 and is unpaired.
Write a function:

class Solution { public int solution(int[] A); }
that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.

For example, given array A such that:

  A[0] = 9  A[1] = 3  A[2] = 9
  A[3] = 3  A[4] = 9  A[5] = 7
  A[6] = 9
the function should return 7, as explained in the example above.

Write an efficient algorithm for the following assumptions:

N is an odd integer within the range [1..1,000,000];
each element of array A is an integer within the range [1..1,000,000,000];
all but one of the values in A occur an even number of times.
*/