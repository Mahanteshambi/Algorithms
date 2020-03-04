package com.algorithms.stack;

import java.util.Stack;

public class ExpressionConversion {

	public static void main(String[] args) {
		ExpressionConversion obj = new ExpressionConversion();
		String[] prefixs = { "*-A/BC-/AKL", "*+AB-CD" };
		for (String prefix : prefixs) {
			System.out.println(prefix + " prefixToInfix " + obj.convertPrefixToInfix(prefix));
			System.out.println(prefix + " prefixToPostfix " + obj.convertPrefixToPostfix(prefix) + " PostfixToPrefix "
					+ obj.convertPostfixToPrefix(obj.convertPrefixToPostfix(prefix)) + " PostfixToInFix "
					+ obj.convertPostfixToInfix(obj.convertPrefixToPostfix(prefix)) + " infiToPostfix "
					+ obj.convertInfixToPostfix(obj.convertPrefixToInfix(prefix)));
		}

	}

	private String convertPrefixToInfix(String str) {
		Stack<String> stack = new Stack<String>();
		for (int c = str.length() - 1; c >= 0; c--) {
			if (Character.isLetterOrDigit(str.charAt(c))) {
				stack.push(str.charAt(c) + "");
			} else {
				String op1 = stack.pop();
				String op2 = stack.pop();
				stack.push("(" + op1 + str.charAt(c) + op2 + ")");
			}
		}
		return stack.pop();
	}

	private String convertPrefixToPostfix(String str) {
		Stack<String> stack = new Stack<String>();
		for (int c = str.length() - 1; c >= 0; c--) {
			if (Character.isLetterOrDigit(str.charAt(c))) {
				stack.push(str.charAt(c) + "");
			} else {
				String op1 = stack.pop();
				String op2 = stack.pop();
				stack.push(op1 + op2 + str.charAt(c));
			}
		}
		return stack.pop();
	}

	private String convertPostfixToPrefix(String str) {
		Stack<String> stack = new Stack<String>();
		for (int c = 0; c <= str.length() - 1; c++) {
			if (Character.isLetterOrDigit(str.charAt(c))) {
				stack.push(str.charAt(c) + "");
			} else {
				String op1 = stack.pop();
				String op2 = stack.pop();
				stack.push(str.charAt(c) + op2 + op1);
			}
		}
		return stack.pop();
	}

	private String convertPostfixToInfix(String str) {
		Stack<String> stack = new Stack<String>();
		for (int c = 0; c <= str.length() - 1; c++) {
			if (Character.isLetterOrDigit(str.charAt(c))) {
				stack.push(str.charAt(c) + "");
			} else {
				String op1 = stack.pop();
				String op2 = stack.pop();
				stack.push("(" + op2 + str.charAt(c) + op1 + ")");
			}
		}
		return stack.pop();
	}

	int Prec(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 1;

		case '*':
		case '/':
			return 2;

		case '^':
			return 3;
		}
		return -1;
	}

	private String convertInfixToPostfix(String exp) {
		String result = new String("");

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < exp.length(); ++i) {
			char c = exp.charAt(i);

			if (Character.isLetterOrDigit(c))
				result += c;

			else if (c == '(')
				stack.push(c);

			else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(')
					result += stack.pop();

				if (!stack.isEmpty() && stack.peek() != '(')
					return "Invalid Expression";
				else
					stack.pop();
			} else {
				while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) {
					if (stack.peek() == '(')
						return "Invalid Expression";
					result += stack.pop();
				}
				stack.push(c);
			}
		}
		while (!stack.isEmpty()) {
			if (stack.peek() == '(')
				return "Invalid Expression";
			result += stack.pop();
		}
		return result;
	}

	private String infixToPrefix(String str1) {
		StringBuilder str = new StringBuilder(str1).reverse();
		for (int c = 0; c < str.length(); c++) {
			if (str.charAt(c) == '(') {
				str.setCharAt(c, ')');
				c++;
			} else if (str.charAt(c) == ')') {
				str.setCharAt(c, '(');
				c++;
			}
		}
		String prefix = convertInfixToPostfix(str.toString());
		str = new StringBuilder(prefix);
		return str.reverse().toString();
	}

}
