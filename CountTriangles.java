package Codility;

import java.util.*;

public class CountTriangles {

	public int solution(int[] A)
	{
		int	out = 0;
		int	l = A.length;
		
		//enough to check the strongest condition
		Arrays.sort(A);
		for (int i = 0; i < l; i++)
		{
			int	k = i + 1;
			for (int j = i + 1; j < l; j++)
			{
				while (k < l && A[i] + A[j] > A[k])
				{
					k++;
				}
				out += k - j - 1;
			}
		}
		
		return (out);
	}
		
	    public static void main(String[] args) 
	    {
	    
	    	int[]	A = {10, 2, 5, 1, 8, 20};
	    	int		out = new CountTriangles().solution(A);
	    	System.out.println("In: " + Arrays.toString(A));
	    	System.out.println("Out: " + out);
	    }
	    
}