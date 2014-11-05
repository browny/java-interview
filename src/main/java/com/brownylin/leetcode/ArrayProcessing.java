package com.brownylin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArrayProcessing
{
	private static final Logger logger = LoggerFactory.getLogger(ArrayProcessing.class);

	@Inject
	public ArrayProcessing() {}

	/**
	 * Remove Element
	 * Q: https://oj.leetcode.com/problems/remove-element/
	 */
	public int removeElement(int[] A, int elem)
	{
		int count = 0;

		for (int i = 0; i < A.length; ++i) {
			if (A[i] == elem) {
				++count;
			} else if(count > 0) {
				A[i - count] = A[i];
			}
		}

		return A.length - count;
	}
	// :~)

	/**
	 * Remove Duplicates from Sorted Array
	 * Q: https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/
	 */
	public int removeDuplicates(int[] A)
	{
		if (A.length == 0)
			return 0;

		int tmp = 0;
		int j = 0;

		for (int i = 0; i < A.length; i++) {
			if (i == 0) {
				tmp = A[0];
				continue;
			}

			if (A[i] == tmp) {
				if (i == (A.length-1)) {
					A[j] = tmp;
				}
			}
			if (A[i] != tmp) {
				A[j] = tmp;
				tmp = A[i];
				j++;

				if (i == (A.length-1)) {
					A[j] = tmp;
				}
			}
		}

		return j+1;
	}
	// :~)

	/**
	 * Two Sum
	 * Q: https://oj.leetcode.com/problems/two-sum/
	 */
	public int[] twoSum(int[] numbers, int target)
	{
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(target - numbers[i])) {
				result[1] = i + 1;
				result[0] = map.get(target - numbers[i]);
				return result;
			}
			map.put(numbers[i], i + 1);
		}

		return result;
	}
	// :~)

	/**
	 * Pascal's Triangle
	 * https://oj.leetcode.com/problems/pascals-triangle/
	 */
	public List<List<Integer>> generate(int numRows)
	{
		List<List<Integer>> result = new ArrayList<>(numRows);

		for (int i = 0; i < numRows; i++) {
			if (i == 0) {
				result.add(Arrays.asList(1));
				continue;
			}
			if (i == 1) {
				result.add(Arrays.asList(1, 1));
				continue;
			}

			result.add(nList(i, result.get(i-1)));
		}

		return result;
	}

	private List<Integer> nList(int n, List<Integer> prevList)
	{
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < n+1; i++) {
			if (i == 0 || i == (n)) {
				list.add(1);
			} else {
				list.add(
					i,
					prevList.get(i-1) + prevList.get(i)
				);
			}
		}

		return list;
	}
	// :~)

	/**
	 * Pascal's Triangle II
	 * https://oj.leetcode.com/problems/pascals-triangle-ii/
	 */
	public List<Integer> getRow(int rowIndex)
	{
		if (rowIndex == 0)
			return Arrays.asList(1);

		List<Integer> l = new ArrayList<>(Arrays.asList(1, 1));

		while (rowIndex-1 > 0) {
			int tmp = l.get(0);
			int sum = 0;

			for (int i = 1; i < l.size(); i++) {
				sum = tmp + l.get(i);
				tmp = l.get(i);
				l.set(i, sum);
			}
			l.add(1);

			rowIndex--;
		}

		return l;
	}
	// :~)

	/**
	 * Merge Sorted Array
	 * https://oj.leetcode.com/problems/merge-sorted-array/
	 *
	 * Hint: calculate from the tail
	 */
	public void merge(int A[], int m, int B[], int n)
	{
		int len = m + n;
		int idxA = m - 1;
		int idxB = n - 1;

		for (int i = len - 1; i >= 0; i--) {
			if (idxA < 0) {
				A[i] = B[idxB];
				idxB--;
			} else if (idxB < 0) {
				A[i] = A[idxA];
				idxA--;
			} else if (A[idxA] > B[idxB]) {
				A[i] = A[idxA];
				idxA--;
			} else {
				A[i] = B[idxB];
				idxB--;
			}
		}
	}
	// :~)

	/**
	 * Combination Sum
	 * https://oj.leetcode.com/problems/combination-sum/
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target)
	{
		List<List<Integer>> result = new ArrayList<>();

		if (candidates == null || candidates.length == 0 || target < 0) {
			return result;
		}

		Arrays.sort(candidates);

		int start=0;
		ArrayList<Integer> current = new ArrayList<>();
		buildResult(candidates, start, current, target, result);

		return result;
	}

	private void buildResult(
		int[] candidates, int start, ArrayList<Integer> current, int target,
		List<List<Integer>> result
	){
		if (target == 0) {
			ArrayList<Integer> temp = new ArrayList<>(current);

			logger.info("add to result: {}", temp);

			result.add(temp);

			return;
		}

		for (int i = start; i < candidates.length; i++) {
			if (target - candidates[i] < 0) {
				return;
			}

			current.add(candidates[i]);
			buildResult(candidates, i, current, target - candidates[i], result);
			current.remove(current.size()-1);
		}
	}
	// :~)

	/**
	 * Combination Sum II
	 * https://oj.leetcode.com/problems/combination-sum-ii/
	 */
	public List<List<Integer>> combinationSum2(int[] num, int target)
	{
		List<List<Integer>> result = new ArrayList<>();

		if (num == null || num.length == 0) {
			return result;
		}

		List<Integer> current = new ArrayList<>();

		int start=0;

		Arrays.sort(num);

		buildResult2(num, start, current, target, result);

		return result;
	}

	private void buildResult2(
		int[] num, int start, List<Integer> current, int target,
		List<List<Integer>> result
	){
		if (target == 0) {
			ArrayList<Integer> temp = new ArrayList<>(current);

			result.add(temp);

			return;
		}

		for (int i = start; i < num.length; i++) {
			if (target - num[i] < 0) {
				return;
			}

			current.add(num[i]);
			buildResult2(num, i + 1, current, target - num[i], result);
			current.remove(current.size() - 1);
			while (i + 1 < num.length && num[i] == num[i + 1]) {
				i++;
			}
		}
	}
	// :~)
}
