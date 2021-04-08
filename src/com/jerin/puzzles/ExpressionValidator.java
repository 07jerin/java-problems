package com.jerin.puzzles;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class ExpressionValidator {

	private static final Map<Character, Character> SUPPORTED_OP_MAP = new HashMap<>();
	private static final Set<Character> OPERATOR_SET_OPEN = new HashSet<>();
	private static final Set<Character> OPERATOR_SET_CLOSE = new HashSet<>();

	static {
		ExpressionValidator.SUPPORTED_OP_MAP.put('{', '}');
		ExpressionValidator.SUPPORTED_OP_MAP.put('[', ']');
		ExpressionValidator.SUPPORTED_OP_MAP.put('(', ')');

		ExpressionValidator.OPERATOR_SET_OPEN.add('{');
		ExpressionValidator.OPERATOR_SET_CLOSE.add('}');
		ExpressionValidator.OPERATOR_SET_OPEN.add('(');
		ExpressionValidator.OPERATOR_SET_CLOSE.add(')');
		ExpressionValidator.OPERATOR_SET_OPEN.add('[');
		ExpressionValidator.OPERATOR_SET_CLOSE.add(']');
	}

	public static boolean isValidExpression(String expression) {

		Stack<Character> stack = new Stack<Character>();
		for (Character c : expression.toCharArray()) {
			if (ExpressionValidator.OPERATOR_SET_OPEN.contains(c)) {
				stack.push(c);
			} else if (ExpressionValidator.OPERATOR_SET_CLOSE.contains(c)) {
				if (stack.isEmpty() || !(c.equals(ExpressionValidator.SUPPORTED_OP_MAP.get(stack.pop())))) {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		System.out.println(ExpressionValidator.isValidExpression("{}"));
		System.out.println(ExpressionValidator.isValidExpression("a{aaa[aa]sss}a"));
		System.out.println(ExpressionValidator.isValidExpression("{a]a}"));
		System.out.println(ExpressionValidator.isValidExpression("{{[{([])}]}}"));
		System.out.println(ExpressionValidator.isValidExpression("}"));
		System.out.println(ExpressionValidator.isValidExpression("{"));
		System.out.println(ExpressionValidator.isValidExpression("[]"));
	}
}
