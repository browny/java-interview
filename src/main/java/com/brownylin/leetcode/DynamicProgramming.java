package com.brownylin.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DynamicProgramming
{
	private static final Logger logger = LoggerFactory.getLogger(DynamicProgramming.class);

	@Inject
	public DynamicProgramming() {}


	/**
	 * Climbing Stairs
	 * Q: https://oj.leetcode.com/problems/climbing-stairs/
	 */
	static Map<Integer, Integer> map = new HashMap() {{ put(1, 1); put(2, 2); }};
	public int climbStairs(int n)
	{
		if (map.containsKey(n))
			return map.get(n);

		map.put(n, climbStairs(n - 1) + climbStairs(n - 2));

		return map.get(n);
	}

	public int climbStairsIteration(int n)
	{
		int v1 = 1;
		int v2 = 2;
		int result = n;
		for (int i = 3; i <= n; ++i) {
			result = v2 + v1;
			v1 = v2;
			v2 = result;
		}

		return result;
	}

	// Take too much time when n is large
	public int climbStairsRecursive(int n)
	{
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;

		return climbStairsRecursive(n - 2) + climbStairsRecursive(n - 1);
	}
	// :~)

	/**
	 * Unique Binary Search Trees
	 * Q: https://oj.leetcode.com/problems/unique-binary-search-trees/
	 */
	static Map<Integer, Integer> map2 = new HashMap() {{ put(0, 1); put(1, 1); put(2, 2); }};
	public int numTrees(int n)
	{
		if (map2.containsKey(n))
			return map2.get(n);

		int total = 0;
		for (int i = 1; i <= n; i++) {
			int numOfSmallerThan = i - 1;
			int numOfBiggerThan = n - i;

			total = total + numTrees(numOfSmallerThan) * numTrees(numOfBiggerThan);
		}

		map2.put(n, total);

		return map2.get(n);
	}
	// :~)

	/**
	 * Minimum Path Sum
	 * https://oj.leetcode.com/problems/minimum-path-sum/
	 */
	static int[][] mps;
	public int minPathSum(int[][] grid)
	{
		if (grid==null || grid.length==0){
			return 0;
		}

		int[][] minCounter=new int[grid.length][grid[0].length];

		minCounter[0][0]=grid[0][0];

		// build first column
		for  (int i=1; i<grid.length; i++){
			minCounter[i][0]=grid[i][0]+minCounter[i-1][0];
		}

		// build first row
		for (int i=1; i<grid[0].length; i++){
			minCounter[0][i]=grid[0][i]+minCounter[0][i-1];
		}

		//build minCounter
		for (int i=1; i<grid.length; i++){
			for (int j=1; j<grid[0].length; j++){
				minCounter[i][j]=Math.min(minCounter[i-1][j], minCounter[i][j-1])+grid[i][j];
			}
		}

		return minCounter[grid.length-1][grid[0].length-1];
	}
	// :~)
}
