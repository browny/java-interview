package com.brownylin.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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
}
