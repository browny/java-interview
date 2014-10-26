package com.brownylin.leetcode;

import com.brownylin.service.DaggerModule;
import mockit.Deencapsulation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StringProcessingTest
{
	private static final Logger logger = LoggerFactory.getLogger(StringProcessingTest.class);

	private StringProcessing tested = DaggerModule.getObjectGraph().get(StringProcessing.class);

	/**
	 * ZigZag Convert
	 */
	@Test(dataProvider="ZigZagConvert")
	public void zigZagConvert(String sampleInput, int sampleRows, String expected)
	{
		String result = tested.zigZagConvert(sampleInput, sampleRows);

		Assert.assertEquals(result, expected);
	}
	@DataProvider(name="ZigZagConvert")
	private Object[][] getZigZagConvert()
	{
		return new Object[][] {
			{ "PAYPALISHIRING", 3, "PAHNAPLSIIGYIR" },
			{ "PAYPALISHIRING", 4, "PINALSIGYAHRPI" },
		};
	}

	@Test(dataProvider="GetIndexPattern")
	public void getIndexPattern(int sampleInput, int[] expected)
	{
		int[] result = Deencapsulation.invoke(tested, "getIndexPattern", sampleInput);

		Assert.assertEquals(result, expected);
	}
	@DataProvider(name="GetIndexPattern")
	private Object[][] getGetIndexPattern()
	{
		return new Object[][] {
			{ 1, new int[] { 0 } },
			{ 2, new int[] { 0, 1 } },
			{ 3, new int[] { 0, 1, 2, 1 } },
			{ 4, new int[] { 0, 1, 2, 3, 2, 1 } },
			{ 5, new int[] { 0, 1, 2, 3, 4, 3, 2, 1 } },
		};
	}
	// :~)


	/**
	 * Add Binary
	 */
	@Test(dataProvider="AddBinary")
	public void addBinary(String sampleA, String sampleB, String expected)
	{
		String result = tested.addBinary(sampleA, sampleB);

		Assert.assertEquals(result, expected);
	}
	@DataProvider(name="AddBinary")
	private Object[][] getAddBinary()
	{
		return new Object[][] {
			{ "11", "1", "100" },
			{ "1010", "1111", "11001" },
		};
	}

	@Test(dataProvider="AlignString")
	public void alignString(String a, String b)
	{
		String[] result = tested.alignString(a, b);

		logger.info("a:{}, b:{}", result[0], result[1]);
	}
	@DataProvider(name="AlignString")
	private Object[][] getAlignString()
	{
		return new Object[][] {
			{ "1001", "11" },
		};
	}

	@Test(dataProvider="CharBinarySum")
	public void charBinarySum(char a, char b, char[] expected)
	{
		char[] result =tested.charBinarySum(a, b, '0');

		Assert.assertEquals(result, expected);
	}
	@DataProvider(name="CharBinarySum")
	private Object[][] getCharBinarySum()
	{
		return new Object[][] {
			{ '0', '0', new char[] {'0', '0'} },
			{ '0', '1', new char[] {'1', '0'} },
			{ '1', '0', new char[] {'1', '0'} },
			{ '1', '1', new char[] {'0', '1'} },
		};
	}
	// :~)

	/**
	 * Count and Say
	 */
	@Test(dataProvider="CountAndSay")
	public void countAndSay(int n, String expected)
	{
		String result = tested.countAndSay(n);

		Assert.assertEquals(result, expected);
	}
	@DataProvider(name="CountAndSay")
	private Object[][] getCountAndSay()
	{
		return new Object[][] {
			{ 1, "1" },
			{ 2, "11" },
			{ 3, "21" },
			{ 4, "1211" },
			{ 5, "111221" },
		};
	}
	// :~)

	/**
	 * Longest Common Prefix
	 * Q: https://oj.leetcode.com/problems/longest-common-prefix/
	 */
	@Test(dataProvider="LongestCommonPrefix")
	public void longestCommonPrefix(String[] strs, String expected)
	{
		String result = tested.longestCommonPrefix(strs);

		Assert.assertEquals(result, expected);
	}
	@DataProvider(name="LongestCommonPrefix")
	private Object[][] getLongestCommonPrefix()
	{
		return new Object[][] {
			{ new String[] { "abcd" }, "abcd" },
			{ new String[] { "abcd", "ab", "abf" }, "ab" },
			{ new String[] { "abcd", "ab", "azgg" }, "a" },
			{ new String[] { "bbcd", "ab", "azgg" }, "" },
		};
	}
	// :~)

	/**
	 * Valid Parentheses
	 * Q: https://oj.leetcode.com/problems/valid-parentheses/
	 */
	@Test(dataProvider="IsValid")
	public void isValid(String str, boolean expected)
	{
		boolean result = tested.isValid(str);

		Assert.assertEquals(result, expected);
	}
	@DataProvider(name="IsValid")
	private Object[][] getIsValid()
	{
		return new Object[][] {
			{ "({}[]", false },
			{ "[", false },
			{ "[])", false },
			{ ")}{({))[{{[}", false },
			{ "(){}[]", true },
			{ "([])", true },
			{ "{{{}}}", true },
		};
	}
	// :~)
}