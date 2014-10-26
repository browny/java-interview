package com.brownylin.leetcode;

import com.brownylin.service.DaggerModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DynamicProgrammingTest
{
	private static final Logger logger = LoggerFactory.getLogger(DynamicProgramming.class);

	private DynamicProgramming tested = DaggerModule.getObjectGraph().get(DynamicProgramming.class);

	/**
	 * Climbing Stairs
	 */
	@Test(dataProvider="ClimbStairs")
	public void climbStairs(int total, int expected)
	{
		int result = tested.climbStairs(total);

		Assert.assertEquals(result, expected);
	}
	@DataProvider(name="ClimbStairs")
	private Object[][] getClimbStairs()
	{
		return new Object[][] {
			{ 1, 1 },
			{ 2, 2 },
			{ 3, 3 },
		};
	}
	// ~:)

	/**
	 * Unique Binary Search Trees
	 */
	@Test(dataProvider="NumTrees")
	public void numTrees(int n, int expected)
	{
		int result = tested.numTrees(n);

		Assert.assertEquals(result, expected);
	}
	@DataProvider(name="NumTrees")
	private Object[][] getNumTrees()
	{
		return new Object[][] {
			{ 1, 1 },
			{ 2, 2 },
			{ 3, 5 },
		};
	}
	// ~:)
}