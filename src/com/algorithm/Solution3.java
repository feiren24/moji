package com.algorithm;

import java.util.ArrayList;
import java.util.List;

class Solution3 {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		long number1 = getNumber(l1);
		long number2 = getNumber(l2);
		long number3 = number1 + number2;
		return buildList(number3);
	}

	private ListNode buildList(long number) {
		StringBuffer sb = new StringBuffer(String.valueOf(number));
		String str = sb.reverse().toString();
		ListNode tail = null;
		ListNode head = null;
		for (int i = 0; i < str.length(); i++) {
			int val = Integer.parseInt(String.valueOf(str.charAt(i)));
			ListNode node = new ListNode(val);
			if (i == 0)
				head = tail = node;
			else {
				tail.next = node;
				tail = node;
			}
		}
		
		List<Integer> list = new ArrayList<Integer>();

		return head;

	}

	private long getNumber(ListNode l) {
		if (l == null)
			return 0;
		StringBuffer sb = new StringBuffer();
		while (l != null) {
			sb.append(l.val);
			l = l.next;
		}
		return Long.parseLong(sb.reverse().toString());
	}
	
	public static void main(String[] args) {
		Solution3 so = new Solution3();
		so.addTwoNumbers(so.buildList(342),so.buildList(465));
	}
}