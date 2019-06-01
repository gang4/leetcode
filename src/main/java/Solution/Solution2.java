package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Solution.Solution1.TreeNode;


/**
 * https://leetcode.com/problems/single-number/
 * @return
 */
public class Solution2 {
	//Definition for a Node.
	public static class Node {
		public int val;
		public List<Node> children;

		public Node() {}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	};

    public int singleNumber(int[] nums) {
    	Arrays.sort(nums);
    	int count = 0;
    	for (int i = 0; i < nums.length - 1; i ++) {
    		if (nums[i] == nums[i + 1]) {
    			count ++;
    		}
    		else {
    			if (count == 0) {
    				return nums[i];
    			}
    			count = 0;
    		}
    	}
        return nums[nums.length - 1];
    }
    
    /**
     * https://leetcode.com/problems/next-greater-element-i/
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    	Arrays.sort(nums1);
    	int [] rt = new int [nums2.length];
    	for (int i = 0; i < nums2.length; i ++) {
    		rt[i] = binarySearch(nums1, 0, nums1.length, nums2[i]);
    	}
    	for (int i = 0; i < rt.length; i ++) {
    		if (rt[i] < nums1.length - 1) {
    			rt[i] ++;
    		}
    		else {
    			rt[i] = -1;
    		}
    	}
    	return rt;
     }

	private int binarySearch(int[] nums, int start, int end, int i) {
		if (i < nums[0] || i > nums[nums.length - 1]) {
			return -1;
		}
		int idx = (end + start) / 2;
		if (i < nums[idx]) {
			return binarySearch(nums, 0, idx, i);
		}
		else if (nums[idx] < i) {
			return binarySearch(nums, idx + 1, end, i);
		}
		else {
			return idx;
		}
	}
	
	/**
	 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
	 */
	public List<Double> averageOfLevels(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		List<Double> list = new ArrayList<>();
		queue.add(root);
		averageVal(queue, list);
		return list;
	}

	private void averageVal(Queue<TreeNode> current, List<Double> list) {
		Queue<TreeNode> next = new LinkedList<>();
		int currentLen = current.size() ;
		long count = 0;
		for (int i = 0; i < currentLen; i ++) {
			TreeNode node = current.poll();
			count += node.val;
			if (node.left != null) {
				next.add(node.left);
			}
			if (node.right != null) {
				next.add(node.right);
			}
		}
		
		list.add((double)count/currentLen);
		
		if (!next.isEmpty()) {
			averageVal(next, list);
		}
	}
	
	/**
	 * https://leetcode.com/problems/binary-number-with-alternating-bits/
	 * 
	 * easy
	 */
	
	/*
	 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/
	 */
    public List<List<Integer>> levelOrder(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		List<List<Integer>> list = new ArrayList<>();
    	if (root == null) {
    		return list;
    	}
		levelOrderInternal(queue, list);
		return list;
    }

	private void levelOrderInternal(Queue<Node> queue, List<List<Integer>> list) {
		Queue<Node> local = new LinkedList<>();
		int length = queue.size();
		List<Integer> vals = new ArrayList<>();
		for (int i = 0; i < length; i ++) {
			Node next = queue.poll();
			vals.add(next.val);
			if (next.children != null) {
				local.addAll(next.children);
			}
		}
		
		list.add(vals);
		
		if (!local.isEmpty()) {
			levelOrderInternal(local, list);
		}
	}
	/**
	 * https://leetcode.com/problems/invert-binary-tree/
	 */
    public TreeNode invertTree(TreeNode root) {
    	if (root == null) {
    		return root;
    	}
    	
    	TreeNode tmp = root.left;
    	root.left = root.right;
    	root.right = tmp;
    	if (root.left != null) {
    		invertTree(root.left);
    	}
    	if (root.right != null) {
    		invertTree(root.right);
    	}
		return root;
        
    }
    
    /*
     * https://leetcode.com/problems/longest-uncommon-subsequence-i/
     * Problem description:
     * Given a group of two strings, you need to find the longest uncommon subsequence of 
     * this group of two strings. The longest uncommon subsequence is defined as the 
     * longest subsequence of one of these strings and this subsequence should not be any 
     * subsequence of the other strings.
	 * A subsequence is a sequence that can be derived from one sequence by deleting some 
	 * characters without changing the order of the remaining elements. Trivially, any 
	 * string is a subsequence of itself and an empty string is a subsequence of any string.
	 * The input will be two strings, and the output needs to be the length of the longest 
	 * uncommon subsequence. If the longest uncommon subsequence doesn't exist, return -1.
	 * 
	 * Solution 1:
	 * it is NP problemtTo find the longest common string. After we find longest common, 
	 * we can delete it in both strings. If we recursively do this until there is no 
	 * longest common string. The problem here is resolved.
	 * 
	 * Find the longest common string is O(mn) if n is one string length and m is another
	 * 
	 * if this is the best way to resolve this issue, this is definitely not a easy. So
	 * Leetcode is misleading the difficulty of this issue.
	 * 
	 * Solution 2:
	 * If one string has one char that can be find in another, it is not longest
	 * uncommon string. Then uncommon string can only hold if and only if there is no
	 * common char in both strings. So we only need to delete common char from each 
	 * string. The run time before is O(mn + m) also.
     */
    public int findLUSlength(String a, String b) {
    	int ccCount = a.length();
    	int baCount = b.length();
    	if (ccCount != baCount) {
    		if (baCount < ccCount) {
    			return ccCount;
    		}
    		else {
    			return baCount;
    		}
    	}
    	byte [] aa = a.getBytes();
    	byte [] ba = b.getBytes();
    	for (int i = 0; i < aa.length; i ++) {
    		if (aa[i] == ba[i]) {
    			aa[i] = '0';
    		}
    	}
    	ccCount = 0;
    	for (int i = 0; i < aa.length; i ++) {
    		if (aa[i] != '0') {
    			ccCount ++;
    		}
    	}
    	if (ccCount == 0) {
    		return -1;
    	}
		return ccCount;        
    }
    
    public int[] sortedSquares(int[] A) {
    	for (int i = 0; i < A.length; i ++) {
    		A[i] = Math.abs(A[i]);
    	}
    	Arrays.sort(A);
    	for (int i = 0; i < A.length; i ++) {
   			A[i] = A[i] * A[i];
    	}
		return A;
    }
    
    static public class ExComparator implements Comparator<Integer> {
    	public int rt = 0;
		@Override
		public int compare(Integer o1, Integer o2) {
			if (o1 > o2 ) {
				return 1;
			}
			else if (o1 < o2) {
				return -1;
			}
			rt = o1;
			throw new IllegalArgumentException();
		}    	
    }
    
    public int repeatedNTimes(int[] A) {
    	Integer [] a = new Integer[A.length];
    	for (int i = 0; i < A.length; i ++) {
    		a[i] = A[i];
    	}
    	ExComparator e = new ExComparator();
    	try {
    		Arrays.sort(a, e);
		} catch (IllegalArgumentException ex) {
			return e.rt;
		}
		return 0; 
    }
    
    public int[][] transpose(int[][] A) {
    	int [][] b;
    	if (A[0].length == A.length) {
        	for (int i = 0; i < A.length; i ++) {
        		for (int j = i; j < A[0].length; j ++) {
        			int tmp = A[i][j];
        			A[i][j] = A[j][i];
        			A[j][i] = tmp;
        		}
        	}
        	b = A;
    	}
    	else if (A[0].length > A.length) {
    		b = new int [A[0].length][];
    		for (int i = 0; i < A[0].length; i ++) {
    			b[i] = new int[A.length];
    		}
    		
        	for (int i = 0; i < A.length; i ++) {
        		for (int j = 0; j < A[0].length; j ++) {
        			b[j][i] = A[i][j];
        		}
        	}

    	}
    	else {
    		b = new int [A[0].length][];
    		for (int i = 0; i < A[0].length; i ++) {
    			b[i] = new int[A.length];
    		}
        	for (int i = 0; i < A[0].length; i ++) {
        		for (int j = 0; j < A.length; j ++) {
        			b[i][j] = A[j][i];
        		}
        	}
    	}
		return b;
    }
    
    public int minDeletionSize(String[] A) {
    	int rt = 0;
    	char[][] a = new char[A.length][];
    	for (int i = 0; i < A.length; i ++) {
    		a[i] = A[i].toCharArray();
    	}
    	for (int i = 0; i < A[0].length(); i ++) {
    		int j = 1;
    		for (; j < A.length; j ++) {
    			if (a[j][i] < a[j - 1][i]) {
    				rt ++;
    				break;
    			}
    		}
    	}
		return rt;
    }
    
    public int[] twoSum(int[] nums, int target) {
    	int [] copy = Arrays.copyOf(nums, nums.length);
    	Arrays.sort(nums);
    	if ((nums[0] + nums[1]) > target || (nums[nums.length - 1] + nums[nums.length - 2]) < target) {
    		return null;
    	}
    	
    	Integer [] rt = search (nums, 0, nums.length - 1, target, new Integer [2]);
    	if (rt[1] == null) {
    		return null;
    	}
    	int [] r = new int[2];
    	r[0] = -1;
    	r[1] = -1;
    	for (int i = 0; i < copy.length; i ++) {
    		if (r[0] == -1 && copy[i] == rt[0]) {
    			r[0] = i;
    		}
    		else if (r[1] == -1 && copy[i] == rt[1]) {
    			r[1] = i;
    		}
    	}
    	
    	if (r[0] > r[1]) {
    		int tmp = r[0];
    		r[0] = tmp;
    		r[0] = r[1];
    		r[1] = tmp;
    	}
    	return r;
    }
    
    Integer [] search(int [] nums, int start, int end, int target, Integer [] rt) {
    	rt[0] = nums[start];
    	rt[1] = null;
    	int count = 0;
    	for (int i = start; i <= end; i ++) {
    		if (nums[start] + nums[end - count] == target) {
    			rt[1] = nums[end - count];
    			return rt;
    		}
    		else if (nums[start] + nums[end - count] < target) {
    			start ++;
    			return search(nums, start, end - count, target, rt);
    		}
    		else {
    			count ++;
    			continue;
    		}
    	}
		return rt;
    }
}
