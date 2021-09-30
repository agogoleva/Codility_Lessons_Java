package Codility;

import java.util.*;

public class EquiLeader {

    public int solution(int[] A) 
    {
        // write your code in Java SE 8
        int l = A.length;
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < l; i++)
        {
            if (stack.isEmpty() || A[i] == stack.peek()) stack.push(A[i]);
            else stack.pop();
        }
        if (stack.isEmpty()) return 0;
        int leader = stack.peek();
        int count = 0;
        stack.clear();
        for (int i = 0; i < l; i++)
        {
            if (A[i] == leader) count++;
        }
        if (count <= l/2) return 0;
        int out = 0;
        int left_count = 0;
        int left_no_count = 0;
        for (int i = 0; i < l; i++)
        {
            if (A[i] == leader) left_count++;
            else left_no_count++;
            if (left_count > left_no_count && (count - left_count) > (l - count - left_no_count)) out++;
        }
        return out;
    }
    
    public static void main(String[] args) 
    {
    	int[]	A = {4, 3, 4, 4, 4, 2};
    	int		out = new EquiLeader().solution(A);
    	System.out.println("In: " + Arrays.toString(A));
    	System.out.println("Out: " + out);
    }

}

//100%

/*
A non-empty array A consisting of N integers is given.

The leader of this array is the value that occurs in more than half of the elements of A.

An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.

For example, given array A such that:

    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2
we can find two equi leaders:

0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
The goal is to count the number of equi leaders.

Write a function:

class Solution { public int solution(int[] A); }
that, given a non-empty array A consisting of N integers, returns the number of equi leaders.

For example, given:

    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2
the function should return 2, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
*/