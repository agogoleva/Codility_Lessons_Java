package Codility;

import java.util.Stack;

public class Brackets {

	public int solution(String S)
	{
		int	l = S.length();
		if (l == 0)
			return (1);
		if (l%2 != 0)
			return (0);
		
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i < l; i++)
		{
			char c = S.charAt(i);
			if (c == '(' || c == '[' || c == '{')
				stack.push(c);
			else if (c == ')' || c == ']' || c == '}')
			{
				if (stack.isEmpty())
					return (0);
				char pop = stack.pop();
				if (!(pop == '(' && c == ')') && !(pop == '[' && c == ']') && !(pop == '{' && c == '}'))
					return (0);
			}
		}
		if (stack.isEmpty())
			return (1);
		else
			return (0);
	}
	
    public static void main(String[] args) 
    {
    	String	A = "{[()()]}";
    	int		out = new Brackets().solution(A);
    	System.out.println("In: " + A);
    	System.out.println("Out: " + out);
    }
}

//100%

/*
A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

S is empty;
S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, the string "{[()()]}" is properly nested but "([)()]" is not.

Write a function:

class Solution { public int solution(String S); }
that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..200,000];
string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
*/