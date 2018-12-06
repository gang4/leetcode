package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

public class Solution1 {
	public List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> list = new ArrayList<>();
		for (int i = left; i < right + 1; i ++) {
			int j = i;
			for (; j != 0;) {
				if (j % 10 == 0) {
					break;
				}
				if ( i % (j % 10) != 0) {
					break;
				}
				
				j /= 10;
			}
			if (j == 0) {
				list.add(new Integer(i));
			}
		}
		return list;
    }
	
	/**
	 * https://leetcode.com/problems/array-partition-i/submissions/
	 * @param nums
	 * @return
	 */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length >> 1; i ++) {
        	count += nums[i << 1];
        }
        return count;
    }
    
    /**
     * https://leetcode.com/problems/peak-index-in-a-mountain-array/
     */
    public int peakIndexInMountainArray(int[] A) {
    	return peakIndexInMountainArray(A, 0, A.length);
    }
    
    int peakIndexInMountainArray(int[] A, int start, int end) {
    	if (A[(end + start) / 2] < A[((end + start) / 2) + 1] &&
    			A[((end + start) / 2) + 2] < A[((end + start) / 2) + 1]) {
    		return ((end + start) / 2) + 1;
    	}
    	
    	if (A[(end + start) / 2] < A[((end + start) / 2) + 1] &&
    			A[((end + start) / 2) + 1] < A[((end + start) / 2) + 2]) {
    		return peakIndexInMountainArray(A, ((end + start) / 2) + 1, end);
    	}
    	else {
    		return peakIndexInMountainArray(A, start, ((end + start) / 2));
    	}
    }
    
    /**
     * https://leetcode.com/problems/sort-array-by-parity-ii/
     */
    public int[] sortArrayByParityII(int[] A) {
    	for (int i = 0; i < A.length; i ++) {
    		if ((i & 0x1) == (A[i] & 0x1)) {
    			continue;
    		}
    		else {
    			int j = i + 1;
    			int idx = 0;
    			for (; j < A.length; j ++) {
    	    		if ((j & 0x1) == (A[j] & 0x1)) {
    	    			;
    	    		}
    	    		else if ((j & 0x1) == (i & 0x1)) {
    	    			if (idx == 0) {
    	    				idx = j;
    	    			}
    	    		}
    	    		else {
    	    			break;
    	    		}
    			}
    			int tmp = A[i];
    			A[i] = A[j];
    			A[j] = tmp;
    			if (idx == 0) {
    				i = j;
    			}
    			else {
    				i = idx - 1;
    			}
    		}
    	}
    	return A;
    }
    
 	 // Definition for a Node.
     /**
      * https://leetcode.com/problems/n-ary-tree-preorder-traversal/
      * @author yyu
      *
      */
	 public static class Node {
	     public int val;
	     public List<Node> children;
	
	     public Node() {}
	
	     public Node(int _val,List<Node> _children) {
	         val = _val;
	         children = _children;
	     }
	 };
	 
     public List<Integer> preorder(Node root) {
    	 final List<Integer> list = new ArrayList<>();
    	 if (root != null) {
    		 list.add(root.val);
    	 }
    	 else {
    		 return list;
    	 }
    	 
    	 if (root.children == null) {
    		 return list;
    	 }

    	 for (int i = 0; i < root.children.size(); i ++) {
    		 List<Integer> l = preorder(root.children.get(i));
    		 if (l != null) {
    			 list.addAll(l);
    		 }
    	 }

    	 return list;
     }
     
     /**
      * https://leetcode.com/problems/n-ary-tree-postorder-traversal/
      * @param root
      * @return
      */
     public List<Integer> postorder(Node root) {
    	 final List<Integer> list = new ArrayList<>();
    	 if (root == null) {
    		 return list;
    	 }
    	 
    	 if (root.children != null) {
	    	 for (int i = 0; i < root.children.size(); i ++) {
	    		 List<Integer> l = postorder(root.children.get(i));
	    		 if (l != null) {
	    			 list.addAll(l);
	    		 }
	    	 }
    	 }
    	 list.add(root.val);
    	 return list;
     }
     
     /**
      * https://leetcode.com/problems/smallest-range-i/
      */
     public int smallestRangeI(int[] A, int K) {
    	 if (A.length == 1) {
    		 return 0;
    	 }

    	 int min = Integer.MAX_VALUE;
    	 int max = Integer.MIN_VALUE;
    	 for (int i = 0; i < A.length; i ++) {
    		 if (A[i] < min) {
    			 min = A[i];
    		 }
    		 if (A[i] > max) {
    			 max = A[i];
    		 }
    	 }
    	 if (max - min - 2 * K < 0) {
    		 return 0;
    	 }
    	 else {
    		return max - min - 2 * K; 
    	 }
     }
     
     public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
     
     public ListNode middleNode(ListNode head) {
    	 ListNode node = head;
    	 while (head != null) {
    		 head = head.next;
    		 if (head != null) {
    			 head = head.next;
    			 node = node.next;
    		 }
    	 }
    	 
    	 return node;
     }
     
     /**
      * https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
      * @param root
      * @return
      */
     public int maxDepth(Node root) {
    	 if (root == null) {
    		 return 0;
    	 }
    	 
    	 if (root.children != null) {
    		 int d = 0;
	    	 for (int i = 0; i < root.children.size(); i ++) {
	    		 int rt = maxDepth(root.children.get(i));
	    		 if (d < rt) {
	    			 d = rt;
	    		 }
	    	 }
	    	 return d + 1;
    	 }
    	 else {
    		 return 1;
    	 }
     }
     
     /**
      * https://leetcode.com/problems/reverse-words-in-a-string-iii/
      */
     public String reverseWords(String s) {
    	 if (s.isEmpty()) {
    		 return s;
    	 }
    	 char [] sa = s.toCharArray();
    	 int idx = 0;
    	 for (int i = 0; i < sa.length; i ++) {
    		 if (sa[i] == ' ') {
    			 reverse(sa, idx, i - 1);
    			 idx = (i + 1);
    		 }
    	 }
    	 reverse(sa, idx, sa.length - 1);
    	 return new String(sa);
     }

	private void reverse(char[] s, int start, int end) {
		for (int i = start; i < (end + start) / 2 + ((end + start) & 0x1); i ++) {
			char tmp = s[i];
			s[i] = s[end - (i - start)];
			s[end - (i - start)] = tmp;
		}
	}
	
	/**
	 * https://leetcode.com/problems/subdomain-visit-count/
	 * @param cpdomains
	 * @return
	 */
    public List<String> subdomainVisits(String[] cpdomains) {
    	Map<String, Integer> map = new Hashtable<>();
    	for (int i = 0; i < cpdomains.length; i++) {
    		String [] parts = cpdomains[i].split(" ");
    		int index = 0;
    		do {
    			insert(map, parts[1], parts[0]);
    			index = parts[1].indexOf('.');
    			if (index > 0) {
    				parts[1] = parts[1].substring(index + 1, parts[1].length());
    			}
    		} while (index > 0);
    	}
    	List<String> rt = new ArrayList<>();
    	for (Map.Entry<String, Integer> entry : map.entrySet()) {
    		rt.add(entry.getValue() + " " + entry.getKey()); 
    	}
    	return rt;
    }

	private void insert(Map<String, Integer> map, String key, String value) {
		Integer count = map.get(key);
		if (count == null) {
			map.put(key, Integer.parseInt(value));
		}
		else {
			map.put(key, count + Integer.parseInt(value));
		}
	}
	
	/**
	 * https://leetcode.com/problems/number-complement/
	 */
	public int findComplement(int num) {
		int tmp = num;
		int mask = 1;
		while (true) {
			tmp >>= 1;
    	 	if (tmp != 0) {
    	 		mask = (mask << 1) + 1;
    	 	}
    	 	else {
    	 		break;
    	 	}
		}
		return mask & (~num);
    }
	
	/**
	 * https://leetcode.com/problems/shortest-distance-to-a-character/
	 * 
	 * Input: S = "loveleetcode", C = 'e'
	 * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
	 */
	public int[] shortestToChar(String S, char C) {
		char [] s = S.toCharArray();
		int [] rt = new int [s.length];
		// for any char there are 2 distances, 1. in head of it and one after
		int before = -1;
		int after = -1;
		for (int i = 0; i < s.length; i ++) {
			if (s[i] == C) {
				if (before == -1) {
					// ---------C
					before = i;
					for (int j = 0; j < i; j ++) {
						rt[j] = i - j;
					}
				}
				else {
					// ---------C-----C
					// ---------C-----C---C
					if (after != -1) {
						before = after;
					}
					after = i;
					for (int j = before + 1; j < i; j ++) {
						if (j - before < i - j) {
							rt[j] = j - before;
						}
						else {
							rt[j] = i - j;
						}
					}
				}
			}
		}
		if (after + 1 < s.length) {
			if (after != -1) {
				before = after;
			}
			for (int j = before + 1; j < s.length; j ++) {
				rt[j] = j - before;
			}	
		}
		return rt;
    }
	
	/**
	 * https://leetcode.com/problems/keyboard-row/
	 * Input: ["Hello", "Alaska", "Dad", "Peace"]
	 * Output: ["Alaska", "Dad"]
	 */
	public String[] findWords(String[] words) {
		if (words == null) {
			return null;
		}
		char [] r1 = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
		char [] r2 = {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};
		
		Arrays.sort(r1);
		Arrays.sort(r2);
		
		List<String> list = new ArrayList<>();
		for (int i = 0; i < words.length; i ++) {
			boolean in1 = false;
			boolean in2 = false;
			boolean in3 = false;
			int j = 0;
			char [] w = words[i].toLowerCase().toCharArray();
			for (; j < words[i].length(); j ++) {
				if (Arrays.binarySearch(r1, w[j]) >= 0) {
					in1 = true;
				}
				else if (Arrays.binarySearch(r2, w[j]) >= 0) {
					in2 = true;
				}
				else {
					in3 = true;
				}
				
				if	((in1 && in2) || (in2 && in3) || (in3 && in1)) {
					break;
				}
			}
			
			if	(j == words[i].length()) {
				list.add(words[i]);
			}
		}
		return list.toArray(new String [list.size()]);
    }
	
	/**
	 * Definition for a binary tree node.
	 */
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	/**
	 * https://leetcode.com/problems/leaf-similar-trees/
	 * [18,35,22,null,103,43,101,58,null,97]
	 * [94,102,17,122,null,null,54,58,101,97]
	 */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    	if (root1 == null && root2 == null) {
    		return true;
    	}
    	else if (root1 != null && root2 == null) {
    		return false;
    	}
    	else if (root1 == null && root2 != null) {
    		return false;
    	}
    	List<Integer> s1 = new ArrayList<>();
    	List<Integer> s2 = new ArrayList<>();
    	printNode(root1, s1);
    	printNode(root2, s2);
    	if (s1.size() != s2.size()) {
    		return false;
    	}
    	for (int i = 0; i < s1.size(); i ++) {
    		if (s1.get(i) != s2.get(i)) {
    			return false;
    		}
    	}
    	
    	return true;
    }

	private void printNode(TreeNode root, List<Integer> s1) {
		if (root.left == null && root.right == null) {
			s1.add(root.val);
		}
		
		if (root.left != null) {
			printNode(root.left, s1);
		}
		
		if (root.right != null) {
			printNode(root.right, s1);
		}
	}
	
	/**
	 * https://leetcode.com/problems/toeplitz-matrix/
	 */
	public boolean isToeplitzMatrix(int[][] matrix) {
		for (int j = 0; j < matrix[0].length; j ++) {
			for (int i = j, k = 0; i < matrix[0].length - 1 && k < matrix.length - 1; i ++, k ++) {
				if (matrix[k][i] != matrix[k + 1][i + 1]) {
					return false;
				}
			}
		}
		
		for (int j = 1; j < matrix.length; j ++) {
			for (int i = 0, k = j; i < matrix[0].length - 1 && k < matrix.length - 1; i ++, k ++) {
				if (matrix[k][i] != matrix[k + 1][i + 1]) {
					return false;
				}
			}
		}
		return true;
    }
	
	/**
	 * https://leetcode.com/problems/uncommon-words-from-two-sentences/
	 */
	public String[] uncommonFromSentences(String A, String B) {
		String [] words = A.split(" ");
		Map<String, Long> table1 = new Hashtable<>();
		for (int i = 0; i < words.length; i ++) {
			if (table1.get(words[i]) == null) {
				table1.put(words[i], 0L);
			}
			else {
				table1.put(words[i], 1L);
			}
		}
		
		String [] dup = B.split(" ");
		Map<String, Long> table2 = new Hashtable<>();
		for (int i = 0; i < dup.length; i ++) {
			if (table2.get(dup[i]) == null) {
				table2.put(dup[i], 0L);
			}
			else {
				table2.put(dup[i], 1L);
			}
		}
		
		List<String> list = new ArrayList<>();
		for (Entry<String, Long> entry: table1.entrySet()) {
			if (entry.getValue() == 0L && table2.get(entry.getKey()) == null) {
				list.add(entry.getKey());
			}
		}
		for (Entry<String, Long> entry: table2.entrySet()) {
			if (entry.getValue() == 0L && table1.get(entry.getKey()) == null) {
				list.add(entry.getKey());
			}
		}
		words = new String [list.size()];
		return list.toArray(words);
    }	
	
	/*
	 * https://leetcode.com/problems/island-perimeter/
	 * 
	 * Not good
	 */
	public int islandPerimeter(int[][] grid) {
		int count = 0;
        for (int j = 0; j < grid.length; j ++) {
        	for (int i = 0; i < grid[0].length; i ++) {
        		if (grid[j][i] == 1) {
        			// most left
        			if (i == 0) {
        				count ++;
        			}
        			else if (grid[j][i - 1] == 0) {
            			count ++;
            		}

        			// most right
        			if (i == grid[0].length - 1) {
        				count ++;
        			}
        			// i right
        			else if (grid[j][i + 1] == 0) {
        				count ++;
        			}
        			
        			if (j == 0) {
        				count ++;
        			}
        			else if (grid[j - 1][i] == 0) {
        				count ++;
        			}
        			
        			if (j == grid.length - 1) {
        				count ++;
        			}
        			else if (grid[j + 1][i] == 0) {
        				count ++;
        			}

        		}
        	}
        }
		return count;
    }
	
	/**
	 * https://www.geeksforgeeks.org/print-all-palindrome-permutations-of-a-string/
	 * 
	 * Input:  str = "aabcb"
	 * Output: abcba bacab
	 *
	 * input:  str = "aabbcadad"
	 * Output: aabdcdbaa aadbcbdaa abadcdaba
     *   abdacadba adabcbada adbacabda
     *   baadcdaab badacadab bdaacaadb
     *   daabcbaad dabacabad dbaacaabd
	 */
	public int palindromePermutations(String in) {
		// (1) 	check if in.length is even or odd,
		// (2) 	get all unique char and number of it.
		// (3) 	if string length is odd number, then you 
		// 		have to have only one char that has number 
		//		of odd number.
		// (4)  if string length is even, all number of 
		//		Individual char has to be even
		// (6)  n! is all combinations -> y
		// (7)  for all number of chars = x
		// (8)  	y = (y / (x / 2);
		//
		// Print all
		// tranverse through all chars
		// (1) put half of chars in an array
		// Optional
		// (2) put all result into a hastable to get rid of dup
		return 0;
	}
	
	/**
	 * https://leetcode.com/problems/trim-a-binary-search-tree/
	 */
	public TreeNode trimBST(TreeNode root, int L, int R) {
		if (root.left != null) {
			root.left = trimBST(root.left, L, R);
		}
		
		if (root.right != null) {
			root.right = trimBST(root.right, L, R);
		}
		
		if (root.val < L || root.val > R) {
			if (root.left == null) {
				return root.right;
			}
			else {
				// find place to set right
				if (root.right != null) {
					attachNode(root.left, root.right);
				}
				return root.left;
			}
		}
		else {
			return root;
		}
    }

	private void attachNode(TreeNode left, TreeNode right) {
		if (left.left != null && left.right != null) {
			attachNode(left.left, right);
		}
		if (left.left == null) {
			left.left = right;
		}
		else {
			left.right = right;
		}
	}
	
	/**
	 * https://leetcode.com/problems/increasing-order-search-tree/
	 */
	TreeNode root = null;
	TreeNode current = null;
    public TreeNode increasingBST(TreeNode root) {
    	if (root == null) {
    		return null;
    	}
    	increasingBSTInternal(root);
    	return this.root;
    }
	private void increasingBSTInternal(TreeNode root) {
		if (root.left != null) {
			increasingBSTInternal(root.left);
		}
		
		if (root.right != null) {
			addNode(root);
			increasingBSTInternal(root.right);
		}
		else {
			addNode(root);
		}
	}

	private void addNode(TreeNode root) {
		if (this.root == null) {
			this.root = root;
			current = root;
		}
		else {
			current.right = root;
			current.left = null;
			current = current.right;
		}
		root.left = null;
	}
	
	/*
	 * https://leetcode.com/problems/binary-gap/
	 */
	public int binaryGap(int n) {
		int dist = 0;
		int curentIdx = 0;
		//boolean consecutive = false;
		boolean hasOne = false;
		for (int i = 0; i < 64 &&  n != 0; i ++) {
			if (!hasOne) {
				curentIdx = i;
			}
			if ((n & 0x1) == 0x1) {
				if ((i - curentIdx) > dist) {
					dist = i - curentIdx;
				}
				curentIdx = i;
				hasOne = true;
			}
			n >>= 1;
		}
		return dist;
    }
	
	/**
	 * https://leetcode.com/problems/distribute-candies/
	 */
	public int distributeCandies(int[] candies) {
		Arrays.sort(candies);
		int count = 1;
		for (int i = 0; i < candies.length - 1; i ++) {
			if (candies[i] != candies[i + 1]) {
				count ++;
			}
		}
		if (count > candies.length / 2 ) {
			count = candies.length / 2;
		}
		return count;
    }
}