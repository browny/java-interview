package com.brownylin.service;

import java.util.*;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InterviewService
{
	private static final Logger logger = LoggerFactory.getLogger(InterviewService.class);

	@Inject
	public InterviewService()
	{
	}

	/**
	 * Reverse String
	 */
	public String reverseString(String source)
	{
		return new StringBuilder(source).reverse().toString();
	}

	public String reverseStringIterative(String source)
	{
		StringBuilder stringBuilder = new StringBuilder();
		char[] strChars = source.toCharArray();

		for (int i = strChars.length - 1; i >= 0; i--) {
			stringBuilder.append(strChars[i]);
		}

		return stringBuilder.toString();
	}

	public String reverseStringRecursive(String source)
	{
		//base case to handle one char string and empty string
		if (source.length() < 2) {
			return source;
		}

		return reverseStringRecursive(source.substring(1)) + source.charAt(0);
	}
	// :~)

	/**
	 * Reversing the words of Palindrome Sentences
	 */
	public String reverseWords(String source)
	{
		String arr[] = source.split(" ");
		StringBuilder stb = new StringBuilder();

		for (int i = arr.length - 1; i >= 0; i--) {
			if (i == 0) {
				stb.append(arr[i]);
			} else {
				stb.append(arr[i] + " ");
			}
		}

		return stb.toString();
	}
	// :~)

	/**
	 * Check duplicate in Array
	 */
	public boolean checkDuplicateInArray_bruteForce(String[] input)
	{
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length; j++) {
				if (input[i].equals(input[j]) && i != j) {
					return true;
				}
			}
		}

		return false;
	}

	public boolean checkDuplicateInArray_usingSet(String[] input)
	{
		/**
		 * detect duplicate in array by comparing size of List and Set
		 * since Set doesn't contain duplicate, size must be less for an array which contains duplicates
		 */
		List inputList = Arrays.asList(input);
		Set inputSet = new HashSet(inputList);

		if (inputSet.size() < inputList.size())
			return true;

		return false;
	}

	public boolean checkDuplicateInArray_usingAdd(String[] input)
	{
		/**
		 * Since Set doesn't allow duplicates add() return false
		 * if we try to add duplicates into Set and this property
		 * can be used to check if array contains duplicates in Java
		 */
		Set tempSet = new HashSet();

		for (String str : input) {
			if (!tempSet.add(str)) {
				return true;
			}
		}
		return false;
	}
	// :~)

	/**
	 * Permutations of a given string
	 */
	public void permutationRecursive(String prefix, String input)
	{
		int n = input.length();
		if (n == 0) {
			System.out.println(prefix);
		} else {
			for (int i = 0; i < n; i++) {
				permutationRecursive(prefix + input.charAt(i), input.substring(0, i) + input.substring(i + 1));
			}
		}
	}
	// :~)

	/**
	 * Find first non repeating char in the string
	 */
	public char firstNonRepeatedCharOnePass(String word)
	{
		Set<Character> repeating = new HashSet<>();
		List<Character> nonRepeating = new ArrayList<>();

		for (int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			if (repeating.contains(letter)) {
				continue;
			}

			if (nonRepeating.contains(letter)) {
				nonRepeating.remove((Character) letter);
				repeating.add(letter);
			} else {
				nonRepeating.add(letter);
			}
		}

		return nonRepeating.size() > 0 ? nonRepeating.get(0) : ' ';
	}

	public char firstNonRepeatedCharTwoPass(String str)
	{
		Map<Character, Integer> counts = new LinkedHashMap<>(str.length());

		for (char c : str.toCharArray()) {
			counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1);
		}

		for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}

		return ' ';
	}
	// :~)

	/**
	 * Check if the string is palindrome
	 */
	public boolean isPalindrome(String s)
	{
		if (s.isEmpty())
			return true;

		// Converts string to lowercase and replaces everything except numbers and alphabets
		s = s.toLowerCase().replaceAll("\\W", "");

		int j = 0;
		int k = s.length() - 1;

		while (j < s.length() / 2) {
			if (s.charAt(j++) != s.charAt(k--)) {
				return false;
			}
		}

		return true;
	}
	// :~)

	/**
	 * Generate all possible permutation of the integer list
	 * 每個都跟第一個換
	 *
	 * 1 2 3 4
	 *   3 2 4
	 *   4 3 2
	 *
	 * 2 1 3 4
	 *   3 1 4
	 *   4 3 1
	 *
	 * 3 2 1 4
	 *
	 *
	 * 4 2 3 1
	 */
	public void generatePerm(List<Integer> input, int start, int end)
	{
		if (start > end) {
			logger.info("result: {}", input);
		} else {
			for (int i = start; i <= end; i++) {
				logger.info("input: {}, start: {}, i: {}", input, start, i);
				Collections.swap(input, start, i);
				generatePerm(input, start + 1, end);
				Collections.swap(input, start, i);
			}
		}
	}
	// :~)
}

