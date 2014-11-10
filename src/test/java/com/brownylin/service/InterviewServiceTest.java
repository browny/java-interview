package com.brownylin.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class InterviewServiceTest
{
	private static final Logger logger = LoggerFactory.getLogger(InterviewServiceTest.class);

	private InterviewService testedService = DaggerModule.getObjectGraph().get(InterviewService.class);

	/**
	 * Reverse String
	 */
	@Test(dataProvider="ReverseString")
	public void reverseString(String sampleInput, String expected)
	{
		Assert.assertEquals(testedService.reverseString(sampleInput), expected);
		Assert.assertEquals(testedService.reverseStringIterative(sampleInput), expected);
		Assert.assertEquals(testedService.reverseStringRecursive(sampleInput), expected);
	}
	@DataProvider(name="ReverseString")
	private Object[][] getReverseString()
	{
		return new Object[][] {
			{ "abc123", "321cba" },
		};
	}
	// :~)

	/**
	 * Reverse Words
	 */
	@Test(dataProvider="ReverseWords")
	public void reverseWords(String sampleInput, String expected)
	{
		Assert.assertEquals(testedService.reverseWords(sampleInput), expected);
	}
	@DataProvider(name="ReverseWords")
	private Object[][] getReverseWord()
	{
		return new Object[][] {
			{ "you are a good man", "man good a are you" },
		};
	}
	// :~)

	/**
	 * Check duplicate in Array
	 */
	@Test(dataProvider="CheckDuplicateInArray")
	public void checkDuplicateInArray(String[] sampleInput)
	{
		Assert.assertTrue(testedService.checkDuplicateInArray_bruteForce(sampleInput));
		Assert.assertTrue(testedService.checkDuplicateInArray_usingSet(sampleInput));
		Assert.assertTrue(testedService.checkDuplicateInArray_usingAdd(sampleInput));
	}
	@DataProvider(name="CheckDuplicateInArray")
	private Object[][] getCheckDuplicateInArray()
	{
		return new Object[][] {
			{ new String[] {"one","two","three","one"} },
		};
	}
	// :~)

	/**
	 * Permutations of a given string
	 */
	@Test
	public void permutationRecursive()
	{
		testedService.permutationRecursive("", "012");
	}
	// :~)

	/**
	 * Find first non repeating char in the string
	 */
	@Test(dataProvider="FirstNonRepeatedChar")
	public void firstNonRepeatedChar(String sampleInput, char expected)
	{
		Assert.assertEquals(testedService.firstNonRepeatedCharOnePass(sampleInput), expected);

		Assert.assertEquals(testedService.firstNonRepeatedCharTwoPass(sampleInput), expected);
	}
	@DataProvider(name="FirstNonRepeatedChar")
	private Object[][] getFirstNonRepeatedChar()
	{
		return new Object[][] {
			{ "abcdefghija", 'b' },
			{ "aaa", ' ' },
		};
	}
	// :~)

	/**
	 * Check if the string is palindrome
	 */
	@Test(dataProvider="IsPalindrome")
	public void isPalindrome(String s, boolean expected)
	{
		boolean result = testedService.isPalindrome(s);

		Assert.assertEquals(result, expected);
	}
	@DataProvider(name="IsPalindrome")
	private Object[][] getIsPalindrome()
	{
		return new Object[][] {
			{ "Niagara. O roar again!", true },
			{ "RACECAR", true },
		};
	}
	// :~)

	/**
	 * Check if the string is palindrome
	 */
	@Test
	public void generatePerm()
	{
		List<Integer> list = Arrays.asList(1, 2 ,3, 4);

		testedService.generatePerm(list, 0, 3);
	}
	// :~)
}
