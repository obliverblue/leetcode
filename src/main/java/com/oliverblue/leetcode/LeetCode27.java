package com.oliverblue.leetcode;

/**
 * @author oliver blue
 * @since 2019/4/10
 * 27. Remove Element
 */
public class LeetCode27
{
	public static void main(String[] args)
	{
		int[] nums = {3,2,2,3};
		int val = 3;
//		int[] nums = {0,1,2,2,3,0,4,2};
//		int val = 2;
		int len = Solution.removeElement(nums, val);
		System.out.println(len);
		for(int x : nums)
		{
			System.out.print(x + " ");
		}
	}


	static class Solution {
		public static int removeElement(int[] nums, int val) {
			return exchangeAndGetLen(nums, val);
		}


		private static int exchangeAndGetLen(int[] nums, int val)
		{
			int mark = -1;
			for(int i = 0; i < nums.length; i++)
			{
				if(nums[i] == val && mark == -1)
				{
					mark = i; // init mark;
				}
				else
				{
					if(mark != -1 && nums[i] != val)
					{
						int temp = nums[mark];
						nums[mark] = nums[i];
						nums[i] = temp;
						mark = mark + 1;
					}
				}
			}

			return mark;
		}
	}
}
