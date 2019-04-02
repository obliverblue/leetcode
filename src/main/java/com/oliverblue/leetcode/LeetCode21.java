package com.oliverblue.leetcode;

/**
 * @author oliver blue
 * @since 2019/4/2
 */
public class LeetCode21
{

	public static void main(String[] args)
	{
//		ListNode l1 = new ListNode(1);
//		ListNode l1_1 = new ListNode(2);
//		l1.next = l1_1;
//		ListNode l1_2 = new ListNode(4);
//		l1_1.next = l1_2;
//
//		ListNode l2 = new ListNode(1);
//		ListNode l2_1 = new ListNode(3);
//		l2.next = l2_1;
//		ListNode l2_2 = new ListNode(4);
//		l2_1.next = l2_2;

//		ListNode l1 = new ListNode(2);
//		ListNode l2 = new ListNode(1);


		ListNode l1 = new ListNode(1);
		ListNode l1_1 = new ListNode(7);
		l1.next = l1_1;
		ListNode l1_2 = new ListNode(10);
		l1_1.next = l1_2;

		ListNode l2 = new ListNode(2);
		ListNode l2_1 = new ListNode(7);
		l2.next = l2_1;
		ListNode l2_2 = new ListNode(8);
		l2_1.next = l2_2;

		ListNode newList = Solution.mergeTwoLists(l1, l2);
		ListNode cur = newList;
		while(cur != null)
		{
			System.out.println(cur.val);
			cur = cur.next;
		}

	}


	static class Solution
	{

		public static ListNode mergeTwoLists(ListNode l1, ListNode l2)
		{
			if(l1 == null)
			{
				return l2;
			}

			if(l2 == null)
			{
				return l1;
			}

			if(l1.val >= l2.val)
			{
				return merge(l2, l1);
			}
			else
			{
				return merge(l1, l2);
			}
		}
	}

	private static ListNode merge(ListNode smaller, ListNode bigger)
	{
		ListNode cur = smaller;
		ListNode next;
		ListNode splicing = bigger;

		while((next = cur.next) != null)
		{

			if(cur.val <= splicing.val && next.val > splicing.val)
			{
				cur.next = splicing;
				cur = splicing;
				splicing = next;
			}
			else
			{
				cur = next;
			}

		}

		if(next == null && splicing != null)
		{
			cur.next = splicing;
		}

		return smaller;
	}


	static class ListNode
	{
		int val;
		ListNode next;

		ListNode(int x)
		{
			val = x;
		}
	}
}
