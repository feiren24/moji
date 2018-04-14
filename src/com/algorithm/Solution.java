package com.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
	/**
	 * @param root:
	 *            param root: The root of the binary search tree
	 * @param k1:
	 *            An integer
	 * @param k2:
	 *            An integer
	 * @return: return: Return all keys that k1<=key<=k2 in ascending order
	 */
	public List<Integer> searchRange(TreeNode root, int k1, int k2) {
		List<Integer> list = new ArrayList<Integer>();
		find(root, k1, k2, list);
		Collections.sort(list);// 进行从小到大排序
		return list;
	}

	private void find(TreeNode root, int k1, int k2, List<Integer> list) {
		if (root == null)
			return;
		if (root.val >= k1 && root.val <= k2) {
			list.add(root.val);
		} else if (root.val < k1) {
			find(root.right, k1, k2, list);
		} else if (root.val > k2) {
			find(root.left, k1, k2, list);
		}
	}

	public String serialize(TreeNode root) {
		// write your code here
		if (root == null) {
			return null;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		StringBuffer buffer = new StringBuffer();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			buffer.append(String.valueOf(node.val));
			if (node.left != null) {
				queue.add(node.left);

			}

			if (node.right != null) {
				queue.add(node.right);
			}
		}

		return buffer.toString();
	}

	/**
	 * This method will be invoked second, the argument data is what exactly you
	 * serialized at method "serialize", that means the data is not given by
	 * system, it's given by your own serialize method. So the format of data is
	 * designed by yourself, and deserialize it here as you serialize it in
	 * "serialize" method.
	 */
	public TreeNode deserialize(String data) {
		// write your code here
		if (data == null || data.length() == 0)
			return null;
		return bulidTree(data, 0);
	}

	private TreeNode bulidTree(String data, int index) {
		if (index > data.length())
			return null;
		if (data.charAt(index) == '#') {
			return null;
		} else {
			TreeNode root = new TreeNode(data.charAt(index) - '0');
			int leftIndex = 2 * index + 1;
			int rightIndex = 2 * index + 2;

			root.left = bulidTree(data, leftIndex);
			root.right = bulidTree(data, rightIndex);
			return root;

		}

	}

	public List<Integer> preorderTraversal(TreeNode root) {
		// write your code here
		List<Integer> list = new ArrayList<Integer>();
		_preorder(root, list);
		return list;

	}

	private void _preorder(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		list.add(root.val);
		_preorder(root.left, list);
		_preorder(root.right, list);
	}

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int nLeft = maxDepth(root.left);
		int nRight = maxDepth(root.right);
		return nLeft > nRight ? nLeft + 1 : nRight + 1;
	}

	public int maxPathSum(TreeNode root) {
		// write your code here
		if (root == null) {
			return 0;
		}
		int nLeft = maxPathSum(root.left) + root.val;
		int nRight = maxPathSum(root.right) + root.val;
		return nLeft > nRight ? nLeft : nRight;
	}

	public void rotateString(char[] str, int offset) {
		// write your code here
		if (str == null || offset <= 0)
			return;
		while (offset > str.length) {
			offset = offset - str.length;
		}

		String copyStr = new String(str);
		int count = 0;
		int position = str.length - offset;
		for (int i = position; i < str.length; i++) {
			str[count++] = copyStr.charAt(i);
		}
		for (int i = 0; i < position; i++) {
			str[count++] = copyStr.charAt(i);
		}
		System.out.println(str);
	}

	private boolean isAllNum(String str){
	      return str.matches("^(-|\\+)?\\d+$");
	}

	public int atoi(String str) {
		// write your code here
		str = str.trim();
		// 去掉小数点
		if(str.indexOf(".") != -1)
		str = str.substring(0, str.indexOf("."));
		String newStr = "";
		boolean withOp = false;//第一个字符是否带+或者—
		//截取数字的字符
//		Pattern pattern = Pattern.compile("(-|\\+)?\\d+");
//		
//		Matcher matcher = pattern.matcher(str);
//		if(matcher.find()){
//			str = matcher.group(0);
//		}
//		else{
//			return 0;
//		}
		
		for(int i=0;i<str.length();i++){
			if(str.charAt(i) == 'd'){
				System.out.println("");
			}
			if(String.valueOf(str.charAt(i)).matches("^(-|\\+)?\\d*")){
				if(withOp){
					if(str.charAt(i) == '+' || str.charAt(i) == '-'){
						break;
					}
				}
				newStr += str.charAt(i);
				withOp = true;
			}
			else{
				break;
			}
		}
		
		
		
		
		//没有找到数字
		if(newStr.length() == 0){
			return 0;
		}
		if(newStr.matches("(-|\\+)+")){
			return 0;
		}
		else{
			if(newStr.charAt(0) == '+')
				str = newStr.substring(1);
			else
				str = newStr;
			
		}
				
		// 如果是负数
		if (str.charAt(0) == '-') {
			// 长度超过最小值
			if (str.length() > 11) {
				return -2147483648;
			} else {
				// 因为第一个是负数，所以从1开始
				Long value = Long.parseLong(str);

				if (value + 2147483648L < 0) {
					return -2147483648;
				}

			}
		} else {
			if (str.length() > 10) {
				return 2147483647;
			} else {
				Long value = Long.parseLong(str);

				if (value - 2147483647L > 0) {
					return 2147483647;
				}

			}
		}

		return Integer.parseInt(str);
	}

	public static void main(String[] args) {
		Solution so = new Solution();
		TreeNode root = so.deserialize("3920##157");
		String result = so.serialize(root);
		System.out.println(result);
		String str = "abcdefg";
		so.rotateString(str.toCharArray(), 3);
		System.out.println(so.atoi("        dd112469032d53"));

	}
}

class TreeNode {
	public int val;
	public TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}