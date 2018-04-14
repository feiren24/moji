package com.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution2 {

	public DoublyListNode bstToDoublyList(TreeNode root) {
		// write your code here
		if (root == null)
			return null;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		_inorder(root, queue);
		// build delink
		root = queue.poll();
		DoublyListNode rootNode = new DoublyListNode(root.val);
		DoublyListNode headNode = rootNode;
		while (!queue.isEmpty()) {
			TreeNode tNode = queue.poll();
			DoublyListNode dNode = new DoublyListNode(tNode.val);
			headNode.next = dNode;
			dNode.prev = headNode;
			headNode = dNode;
		}

		return rootNode;

	}

	// 中序遍历
	private void _inorder(TreeNode root, Queue<TreeNode> queue) {
		if (root == null)
			return;
		_inorder(root.left, queue);
		queue.add(root);
		_inorder(root.right, queue);
	}

	public class DoublyListNode {
		int val;
		DoublyListNode next, prev;

		DoublyListNode(int val) {
			this.val = val;
			this.next = this.prev = null;
		}
	}

	public class TreeNode {
		public int val;
		public TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}

	public TreeNode bulidTree() {
		TreeNode root = new TreeNode(2);
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		return root;
	}

	public String reverseVowels(String s) {

		if (s == null || s.length() == 0)
			return null;
		int l = 0;
		int r = s.length() - 1;
		char[] arr = s.toCharArray();
		String aeiou = "aeiouAEIOU";
		while (l < r) {
			if (aeiou.contains(arr[l] + "") && aeiou.contains(arr[r] + "")) {
				swapChar(arr, l, r);
				l++;
				r--;
			} else if (!aeiou.contains((arr[l]) + "")) {
				l++;
			} else {
				r--;
			}
		}

		return new String(arr);
	}

	private void swapChar(char[] arr, int p1, int p2) {
		char temp = arr[p1];
		arr[p1] = arr[p2];
		arr[p2] = temp;
	}

	private boolean isVowels(char c) {
		char[] arr = { c };
		c = new String(arr).toLowerCase().charAt(0);
		return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
	}

	public List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		List<Set<Integer>> listSet = new ArrayList<Set<Integer>>();
		boolean isFirst = true;
		for (int i = 0; i < nums.length; i++) {
			int target = 0 - nums[i];
			if (nums[i] == 0) {
				System.out.println();
			}
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int j = i + 1; j < nums.length; j++) {
				int comp = target - nums[j];
				boolean have3Zero = false;
				if (map.containsKey(comp)) {
					List<Integer> subList = new ArrayList<Integer>();
					if (!have3Zero && nums[i] == 0 && nums[j] == 0 && comp == 0) {
						have3Zero = true;
					}
					// 之前已经存在
					if (!have3Zero || contains(listSet, nums[i], nums[j], comp)) {
						continue;
					}

					Set<Integer> set = new HashSet<Integer>();
					subList.add(nums[i]);
					subList.add(nums[j]);
					subList.add(comp);
					set.addAll(subList);
					listSet.add(set);
					resultList.add(subList);
				} else {
					map.put(nums[j], j);
				}
			}
		}
		return resultList;

	}

	public List<List<Integer>> threeSum3(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int l = i + 1;
			int r = nums.length - 1;
			while (l < r) {

				if (nums[i] + nums[l] + nums[r] == 0) {
					list.add(Arrays.asList(nums[i], nums[l], nums[r]));
					l++;
					r--;
					while (l < r && nums[r] == nums[r + 1]) {
						r--;
					}
					while (l < r && nums[l] == nums[l - 1]) {
						l++;
					}

				} else if (nums[i] + nums[l] + nums[r] > 0) {
					r--;

				} else {
					l++;
				}

			}
		}

		return list;

	}

	public List<List<Integer>> threeSum2(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && (nums[i] == nums[i - 1]))
				continue; // avoid duplicates
			for (int j = i + 1, k = nums.length - 1; j < k;) {
				if (nums[i] + nums[j] + nums[k] == 0) {
					list.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j++;
					k--;
					while ((j < k) && (nums[j] == nums[j - 1]))
						j++;// avoid duplicates
					while ((j < k) && (nums[k] == nums[k + 1]))
						k--;// avoid duplicates
				} else if (nums[i] + nums[j] + nums[k] > 0)
					k--;
				else
					j++;
			}
		}
		return list;
	}
	
  
	private boolean contains(List<Set<Integer>> listSet, int a, int b, int c) {
		for (Set<Integer> s : listSet) {
			if (s.contains(a) && s.contains(b) && s.contains(c))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Solution2 so = new Solution2();

		// so.bstToDoublyList(so.bulidTree());
		int[] nums = { -4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0 };
		System.out.println(so.reverseVowels("ai"));
		so.threeSum3(nums);
		System.out.println(Math.abs(-9));
	}
}
