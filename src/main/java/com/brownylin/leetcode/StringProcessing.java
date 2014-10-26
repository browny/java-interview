package com.brownylin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringProcessing
{
	private static final Logger logger = LoggerFactory.getLogger(StringProcessing.class);

	@Inject
	public StringProcessing() {}

	/**
	 * Q: https://oj.leetcode.com/problems/zigzag-conversion/
	 *
	 * nRows = 3
	 * 	   PAYPALISHIRING
	 * 	   01210121012101 => PAHNAPLSIIGYIR
	 * nRows = 4
	 *     PAYPALISHIRING
	 *     01232101232101 => PINALSIGYAHRPI
	 */
	public String zigZagConvert(String s, int nRows)
	{
		if (nRows == 0)
			return s;

		List<List<String>> zigZag2D = new ArrayList<>(nRows);
		for (int i = 0; i < nRows; i++) {
			zigZag2D.add(new ArrayList<String>());
		}

		char[] input = s.toCharArray();
		int[] pattern = getIndexPattern(nRows);

		for (int i = 0; i < input.length; i++) {
			int row = pattern[i % pattern.length];

			zigZag2D.get(row).add(String.valueOf(input[i]));
		}

		String result = "";
		for (int i = 0; i < zigZag2D.size(); i++) {
			result += concatStringsWSep(zigZag2D.get(i), "");
		}

		return result;
	}

	/**
	 * 1 -> 0
	 * 2 -> 0 1
	 * 3 -> 0 1 2 1
	 * 4 -> 0 1 2 3 2 1
	 * 5 -> 0 1 2 3 4 3 2 1
	 */
	private int[] getIndexPattern(int nRows)
	{
		if (nRows == 1)
			return new int[] { 0 };

		int size = (nRows - 1) * 2;
		int[] pattern = new int[size];

		for (int i = 0; i < size; i++) {
			if (i < nRows) {
				pattern[i] = i;
			} else {
				pattern[i] = (nRows-1) - (i - (nRows-1));
			}
		}

		return pattern;
	}

	/**
	 * {"A", "P", "P", "L", "E"} -> "APPLE"
	 */
	private String concatStringsWSep(List<String> strings, String separator)
	{
		StringBuilder sb = new StringBuilder();
		String sep = "";
		for(String s: strings) {
			sb.append(sep).append(s);
			sep = separator;
		}

		return sb.toString();
	}
	// :~)


	/**
	 * Add Binary
	 * Q: https://oj.leetcode.com/problems/add-binary/
	 */
	public String addBinary(String a, String b)
	{
		String[] src = alignString(a, b);

		src[0] = new StringBuilder(src[0]).reverse().toString();
		src[1] = new StringBuilder(src[1]).reverse().toString();

		logger.info("After reverse: {}, {}", src[0], src[1]);

		StringBuilder sb = new StringBuilder();
		char carry = '0';
		char[] tmpResult = new char[] { '0', '0' };

		for (int i = 0; i < src[0].length(); i++) {
			tmpResult = charBinarySum(src[0].charAt(i), src[1].charAt(i), tmpResult[1]);

			logger.info("sum:{}, carry:{}", tmpResult[0], tmpResult[1]);

			sb.append(tmpResult[0]);
		}

		if (tmpResult[1] == '1') {
			sb.append('1');
		}

		return sb.reverse().toString();
	}

	public String[] alignString(String a, String b)
	{
		String newA = a;
		String newB = b;

		if (a.length() > b.length()) {
			newB = new StringBuilder(repeatString("0", a.length() - b.length())).append(b).toString();
		}
		if (b.length() > a.length()) {
			newA = new StringBuilder(repeatString("0", b.length() - a.length())).append(a).toString();
		}

		logger.info("After align: {}, {}", newA, newB);

		return new String[] { newA, newB };
	}

	private String repeatString(String s, int times)
	{
		StringBuffer b = new StringBuffer();

		for (int i = 0; i < times; i++) {
			b.append(s);
		}

		return  b.toString();
	}

	public char[] charBinarySum(char a, char b, char c)
	{
		char[] result = new char[2];

		int sum =
			Integer.parseInt(String.valueOf(a)) +
			Integer.parseInt(String.valueOf(b)) +
			Integer.parseInt(String.valueOf(c));

		if (sum == 0) {
			result[0] = '0';
			result[1] = '0';
		}
		if (sum == 1) {
			result[0] = '1';
			result[1] = '0';
		}
		if (sum == 2) {
			result[0] = '0';
			result[1] = '1';
		}
		if (sum == 3) {
			result[0] = '1';
			result[1] = '1';
		}

		return result;
	}
	// :~)


	/**
	 * Count and Say
	 * Q: https://oj.leetcode.com/problems/count-and-say/
	 */
	public String countAndSay(int n)
	{
		String result = "1";

		if (n == 1) {
			return result;
		}

		char tmp = 0;
		StringBuilder sb = new StringBuilder();
		List<String> group = new ArrayList<>();

		while (n > 1) {

			tmp = 0;
			sb.setLength(0);
			group.clear();

			for (int i = 0; i < result.length(); i++) {

				if (i == 0) {
					// first case
					tmp = result.charAt(i);
					sb.append(tmp);
				} else {
					if (result.charAt(i) != tmp) {
						group.add(sb.toString());

						tmp = result.charAt(i);

						sb.setLength(0);
						sb.append(tmp);
					} else {
						sb.append(result.charAt(i));
					}

					// last case
					if (i == result.length() - 1) {
						group.add(sb.toString());
					}
				}
			}

			// For case: result.length() == 1
			if (group.size() == 0) {
				group.add(sb.toString());
			}

			// Generate answer from group
			sb.setLength(0);
			for (int i = 0; i < group.size(); i++) {

				String numOfRepeat = String.valueOf(group.get(i).length());
				String value = String.valueOf(group.get(i).charAt(0));

				sb.append(numOfRepeat).append(value);
			}

			result = sb.toString();

			n--;
		}

		return result;
	}
	// :~)

	/**
	 * Longest Common Prefix
	 * Q: https://oj.leetcode.com/problems/longest-common-prefix/
	 */
	public String longestCommonPrefix(String[] strs)
	{
		if (strs.length == 0)
			return "";

		int[] lengthArr = new int[strs.length];

		for (int i = 0; i < strs.length; i++) {
			lengthArr[i] = strs[i].length();
		}
		Arrays.sort(lengthArr);
		int shortest = lengthArr[0];

		int commonLength = 0;
		for (int i = 0; i < shortest; i ++) {
			List<String> list = new ArrayList<>();

			for (int j = 0; j < strs.length; j++) {
				list.add(String.valueOf(strs[j].charAt(i)));
			}

			if (!isAllSameValue(list)) {
				commonLength = i;
				break;
			}

			commonLength = i + 1;
		}

		return strs[0].substring(0, commonLength);
	}

	private boolean isAllSameValue(List<String> strs)
	{
		String tmp = strs.get(0);

		for (String s : strs) {
			if (!s.equals(tmp))
				return false;
		}

		return true;
	}
	// :~)

	/**
	 * Valid Parentheses
	 * Q: https://oj.leetcode.com/problems/valid-parentheses/
	 */
	public boolean isValid(String s)
	{
		if (s.length() <= 1 || (s.length() % 2) != 0)
			return false;

		Stack<String> stack = new Stack();
		for (int i = 0; i < s.length(); i++) {
			String currentChar = String.valueOf(s.charAt(i));

			if (currentChar.equals(")") || currentChar.equals("]") || currentChar.equals("}")) {
				if (stack.empty())
					return false;
			}

			if (currentChar.equals("(") || currentChar.equals("[") || currentChar.equals("{")) {
				stack.push(currentChar);
			}

			if (currentChar.equals(")") && stack.peek().equals("(")) {
				stack.pop();
			}
			if (currentChar.equals("]") && stack.peek().equals("[")) {
				stack.pop();
			}
			if (currentChar.equals("}") && stack.peek().equals("{")) {
				stack.pop();
			}
		}

		return stack.empty();
	}
	// :~)
}
