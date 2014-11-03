package com.brownylin.leetcode;


import java.util.Arrays;

import com.brownylin.service.DaggerModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArrayProcessingTest
{
	private static final Logger logger = LoggerFactory.getLogger(ArrayProcessingTest.class);

	private ArrayProcessing tested = DaggerModule.getObjectGraph().get(ArrayProcessing.class);

	/**
	 * Remove Element
	 */
	@Test(dataProvider="RemoveElement")
	public void removeElement(int[] sampleInput, int removed, int expected)
	{
		int result = tested.removeElement(sampleInput, removed);

		Assert.assertEquals(result, expected);
	}
	@DataProvider(name="RemoveElement")
	private Object[][] getRemoveElement()
	{
		return new Object[][] {
			{ new int[] {1, 2, 2, 3}, 2, 2 },
		};
	}
	// :~)

	/**
	 * Remove Duplicates from Sorted Array
	 */
	@Test(dataProvider="RemoveDuplicates")
	public void removeDuplicates(int[] A, int expected)
	{
		Assert.assertEquals(tested.removeDuplicates(A), expected);
	}
	@DataProvider(name="RemoveDuplicates")
	private Object[][] getRemoveDuplicates()
	{
		return new Object[][] {
			{ new int[] {1, 2, 2, 3}, 3 },
			{ new int[] {1, 2, 2, 2}, 2 },
		};
	}
	// :~)

	/**
	 * Two Sum
	 */
	@Test(dataProvider="TwoSum")
	public void twoSum(int[] numbers, int target, int[] expected)
	{
		int[] result = tested.twoSum(numbers, target);

		Assert.assertTrue(Arrays.equals(result, expected));
	}
	@DataProvider(name="TwoSum")
	private Object[][] getTwoSum()
	{
		return new Object[][] {
			{ new int[] {2, 7, 11, 15}, 9, new int[] {1, 2} },
			{ new int[] {3, 2, 4}, 6, new int[] {2, 3} },
		};
	}
	// :~)
}