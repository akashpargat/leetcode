package com.java.leetcode.zero.ten;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific
 * target.
 * 
 * You may assume that each input would have exactly one solution, and you may not use the same
 * element twice.
 */
@SuppressWarnings({ "nls", "javadoc" })
public class TwoSum
{
    public static int[] twoSum(int[] nums, int target)
    {
        int[] indexes = new int[2];
        for (int i = 0; i < nums.length; i++)
        {
            for (int j = 0; j < nums.length; j++)
            {
                int k = nums[i] + nums[j];
                if (k == target && i != j)
                {
                    indexes[1] = i;
                    indexes[0] = j;
                }

            }
        }

        return indexes;
    }

    private static int[] twoSumEfficient(int[] nums, int target)
    {
        Map<Integer, Integer> valMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            valMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++)
        {
            int a = target - nums[i];
            if (valMap.containsKey(a) && i != valMap.get(a))
            {
                return new int[] { i, valMap.get(a) };
            }
        }

        return nums;
    }

    public static void main(String[] args)
    {
        int twoSum[] = twoSum(new int[] { 2, 7, 11, 15 }, 9);
        System.out.println("First Index:" + twoSum[0] + "\n" + "Second Index: " + twoSum[1]);
        int twoSum_efficient[] = twoSumEfficient(new int[] { 3, 2, 4 }, 6);
        System.out.println("First Index:" + twoSum_efficient[0] + "\n" + "Second Index: "
                + twoSum_efficient[1]);
    }
}
