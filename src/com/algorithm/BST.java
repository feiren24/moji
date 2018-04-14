package com.algorithm;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 二分搜索树
 * @author linxinze
 *
 */
public class BST {
	

	class Node{
		private String value;
		private int key;
		protected Node leftChild;
		protected Node rightChild;
		public Node(int key,String value){
			this.key = key;
			this.value = value;
			this.leftChild = null;
			this.rightChild = null;
		}
		
		public Node(Node node){
			this.key = node.key;
			this.value = node.value;
			this.leftChild = null;
			this.rightChild = null;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public int getKey() {
			return key;
		}
		public void setKey(int key) {
			this.key = key;
		}
		
	}
	
	private Node root;
	private int count;
	
	
	public BST(){
		root = null;
		count = 0;
	}
	
	public int getSize(){
		return count;
	}
	
	public boolean isEmpty(){
		return count == 0;
	}
	
	
	public void insert(int key,String value){
		count++;
		root = insertNode(root,key,value);
	}
	
	private Node insertNode(Node node,int key,String value){
		if(node == null){
			return new Node(key,value);
		}
		if(node.key > key){
			node.leftChild = insertNode(node.leftChild,key, value);
		}
		else if(node.key < key){
			node.rightChild = insertNode(node.rightChild,key,value);
		}
		else{
			node.value  = value;
		}
		return node;
	}
	
	public String search(int key){
		return searchValue(root,key);
	}
	
		
	//找到最小key值的value
	public String findMin(){
		Node node= findMinNode(root);
		return node == null ? null : node.value;
	}
	
	//找到最大key值的value
	public String findMax(){
		Node node = findMaxNode(root);
		return node == null ? null : node.value;
	}
	
	//删除最小值节点
	public void removeMin(){
		if(root != null){
			count --;
			_removeMin(root);
		}
		
	}
	
	//删除最大值节点
	public void removeMax(){
		if(root != null){
			_removeMax(root);
		}
	}
	
	//删掉某一个节点
	public void remove(int key){
		if(root != null){
			_remove(root,key);
		}
	}
	
	
	private Node _remove(Node node,int key){
		if(node == null){
			return null;
		}
		if(node.key == key){
			
			if(node.leftChild == null){
				Node rightChild = node.rightChild;
				node = null;
				return rightChild;
			}
			if(node.rightChild == null){
				Node leftChild = node.leftChild;
				node = null;
				return leftChild;
			}
			Node rightMinNode = new Node(findMinNode(node.rightChild));
			rightMinNode.rightChild = _removeMin(node.rightChild);
			count ++;
			rightMinNode.leftChild = node.leftChild;
			node = null;
			count --;
			return rightMinNode;
		}
		else if(node.key > key){
			node.leftChild = _remove(node.leftChild,key);
		}
		else{
			node.rightChild = _remove(node.rightChild,key);
		}
		return node;
	}
	
	
	private Node _removeMin(Node node){
		if(node.leftChild == null){
			count --;
			Node rightNode = node.rightChild;
			node = null;
			return rightNode;
		}
		node.leftChild = _removeMin(node.leftChild);
		return node;
	}
	
	private Node _removeMax(Node node){
		if(node.rightChild == null){
			count --;
			Node leftNode = node.leftChild;
			node = null;
			return leftNode;
		}
		node.rightChild = _removeMax(node.rightChild);
		return node;
	}
	
	
	private Node findMinNode(Node node){
		if(node.leftChild == null){
			return node;
		}
		return findMinNode(node.leftChild);
	}
	
	private Node findMaxNode(Node node){
		if(node.rightChild == null){
			return node;
		}
		return findMaxNode(node.rightChild);
	}
	
	
	
	private String searchValue(Node node,int key){
		if(node == null){
			return null;
		}
		if(node.key == key){
			return node.value;
		}
		else if(node.key > key){
			return searchValue(node.leftChild,key);
		}
		else {
			return searchValue(node.rightChild,key);
		}
	}
	
	//前序遍历
	public void preOrder(){
		_preOrder(root);
	}
	
	//中序遍历
	public void inOrder(){
		_inOrder(root);
	}
	
	//后序遍历
	public void postOrder(){
		_postOrder(root);
	}
	
	//层序遍历
	public void levelOrder(){
		LinkedBlockingQueue<Node> queue = new LinkedBlockingQueue<Node>();
		queue.add(root);
		while(!queue.isEmpty()){
			Node node= queue.poll();
			_printNode(node);
			if(node.leftChild != null){
				queue.add(node.leftChild);
			}
			if(node.rightChild != null){
				queue.add(node.rightChild);
			}
		}
	}
	
	private void _preOrder(Node node){
		if(node != null){
			_printNode(node);//打印node节点
			_preOrder(node.leftChild);
			_preOrder(node.rightChild);
		}
		
	}
	
	private void _inOrder(Node node){
		if(node != null){
			_inOrder(node.leftChild);
			_printNode(node);
			_inOrder(node.rightChild);
		}
	}
	
	private void _postOrder(Node node){
		if(node != null){
			_postOrder(node.leftChild);
			_postOrder(node.rightChild);
			_printNode(node);
		}
	}
	
	public void testNode(){
		Node node = new Node(1,"1");
		Node node2 = new Node(2,"2");
		node.rightChild = node2;
		
		Node rightNode = node.rightChild;
		node2 = null;
		
		System.out.println(rightNode);

		
	}
	
		
	private void _printNode(Node node){
		if(node != null){
			System.out.println("Key--->" + node.key +"   Value--->" + node.value);
		}
	}
	
	public static void main(String[] args) {
		BST bst = new BST();
		bst.insert(50, "50");//设置为根节点
//		for(int i=1;i<=100;i++){
//			bst.insert(i, String.valueOf(i));
//		}
		bst.insert(47, "47");
		bst.insert(45, "45");
		bst.insert(48,"48");
		bst.insert(46, "46");
		bst.insert(65, "65");
		bst.insert(60,"60");
		bst.insert(70, "70");
		bst.insert(68, "68");
		
		String value = bst.search(1);
		System.out.println(value);
		
		String minValue = bst.findMin();
		String maxValue = bst.findMax();
		System.out.println("Min value is: " + minValue + ";Max value is: " + maxValue);
		
//		bst.levelOrder();
		
		bst.removeMin();
		bst.removeMax();
		
		System.out.println("Execute delete operation---------");
		
		minValue = bst.findMin();
		maxValue = bst.findMax();
		System.out.println("Min value is: " + minValue + ";Max value is: " + maxValue);
		
		bst.remove(2);
		System.out.println("After delete operation---------");
		
		bst.inOrder();
		
		bst.testNode();

	}
	
	
}
