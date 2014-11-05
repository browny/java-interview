package com.brownylin.leetcode;


import java.util.Arrays;
import java.util.List;

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

	/**
	 * Pascal's Triangle
	 */
	@Test
	public void generate()
	{
		tested.generate(3);
	}
	// ~:)

	/**
	 * Pascal's Triangle II
	 */
	@Test
	public void getRow()
	{
		tested.getRow(3);
	}
	// ~:)

	/**
	 * Merge Sorted Array
	 * https://oj.leetcode.com/problems/merge-sorted-array/
	 */
	@Test(dataProvider="Merge")
	public void merge(int A[], int m, int B[], int n, int[] expected)
	{
		tested.merge(A, m, B, n);

		for (int i = 0; i < A.length; i++) {
			Assert.assertEquals(A[i], expected[i]);
		}
	}
	@DataProvider(name="Merge")
	private Object[][] getMerge()
	{
		return new Object[][] {
			{ new int[] {1, 3, 5, 7, 0, 0}, 4, new int[] {4, 6}, 2,
			  new int[] {1, 3, 4, 5, 6, 7}
			},
			{ new int[] {1, 0}, 1, new int[] {2}, 1,
  			  new int[] {1, 2}
			},
			{ new int[] {1, 2, 3, 0, 0, 0}, 3, new int[] {2, 5, 6}, 3,
   			  new int[] {1, 2, 2, 3, 5, 6}
			},
		};
	}
	// ~:)

	/**
	 * Combination Sum
	 * https://oj.leetcode.com/problems/combination-sum/
	 */
	@Test
	public void combinationSum()
	{
		int[] A = new int[] {2, 3, 6, 7};

		List<List<Integer>> result = tested.combinationSum(A, 7);

		logger.info("result: {}", result);
	}
	// ~:)
}