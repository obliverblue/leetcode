package com.oliverblue.leetcode;

/**
 * @author oliver blue
 * @since 2019/4/9
 * 26. Remove Duplicates from Sorted Array
 */
public class LeetCode26
{
	public static void main(String[] args)
	{
		//int[] nums = {1,1,2};
		//int[] nums = {0,0,1,1,1,2,2,3,3,4};
		int[] nums = {4,4,4};
		int len = Solution.removeDuplicates(nums);
		System.out.println("len = " + len);
		for(int x : nums)
		{
			System.out.print(x + " ");
		}
	}

	static class Solution {
		public static  int removeDuplicates(int[] nums) {
			if(nums.length <= 0)
			{
				return 0;
			}
			int max = getMaxNum(nums);
			setDuplicatedNumToMax(max, nums);
			return exchangeAndGetLen(max, nums);
		}

		private static int getMaxNum(int[] nums)
		{
			int max  = nums[0];
			for(int i = 1; i < nums.length; i++)
			{
				if(nums[i] >= max)
				{
					max = nums[i];
				}
			}
			return max;
		}

		private static void setDuplicatedNumToMax(int max, int[] nums)
		{
			int duplicate = max;
			for(int i = 0; i < nums.length; i++)
			{
				if(nums[i] != max)
				{
					if(nums[i] == duplicate)
					{
						nums[i] = max;
					}
					else
					{
						duplicate = nums[i];
					}
				}
			}
		}

		private static int exchangeAndGetLen(int max, int[] nums)
		{
			int mark = -1;
			for(int i = 0; i < nums.length; i++)
			{
				if(nums[i] == max && mark == -1)
				{
					mark = i; // init mark;
				}
				else
				{
					if(mark != -1 && nums[i] != max)
					{
						int temp = nums[mark];
						nums[mark] = nums[i];
						nums[i] = temp;
						mark++;
					}
				}
			}

			return mark + 1;
		}


	}
}


