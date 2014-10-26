package com.brownylin.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InterviewService
{
	private static final Logger logger = LoggerFactory.getLogger(InterviewService.class);

	@Inject
	public InterviewService() {}

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

		for(int i = arr.length-1; i >= 0; i--) {
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

		if(inputSet.size() < inputList.size())
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
		logger.info("prefix: {}, input: {}", prefix, input);

		int n = input.length();
		if (n == 0) {
			System.out.println(prefix);
		} else {
			for (int i = 0; i < n; i++) {
				logger.info(
					"prefix: {} + input.charAt({}): {}, input.substring(0, {}): {} + input.substring({} + 1): {}",
					prefix, i, input.charAt(i), i, input.substring(0, i), i, input.substring(i + 1)
				);
				permutationRecursive(prefix + input.charAt(i), input.substring(0, i) + input.substring(i + 1));
			}
		}
	}
	// :~)
}
