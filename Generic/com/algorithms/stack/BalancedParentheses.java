package com.algorithms.stack;

public class BalancedParentheses {

	public static void main(String[] args) {
		BalancedParentheses obj = new BalancedParentheses();
		String[] equations = { "{(a+(b-c))}", "{((a+b)]}", "())", "(((", "{a+[b-(c+d)]}" };
		for (String equation : equations) {
			if (obj.isBalanced(equation)) {
				System.out.println(equation + " Equation is balanced!");
			} else {
				System.out.println(equation + " Euation is not balanced!");
			}
		}
	}

	private boolean isBalanced(String equation) {
		char[] stack = new char[equation.length()];
		int top = -1;
		for (char c = 0; c < equation.length(); c++) {
			if (equation.charAt(c) == '{' || equation.charAt(c) == '(' || equation.charAt(c) == '[') {
				stack[++top] = equation.charAt(c);
			} else if (equation.charAt(c) == '}' || equation.charAt(c) == ')' || equation.charAt(c) == ']') {
				if (top == -1) {
					top--;
					break;
				}
				if ((equation.charAt(c) == '}' && stack[top] == '{') || (equation.charAt(c) == ')' && stack[top] == '(')
						|| (equation.charAt(c) == ']' && stack[top] == '[')) {
					top--;
				}
			}
		}
		if (top == -1) {
			return true;
		}

		return false;
	}

}
