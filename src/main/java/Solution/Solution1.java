package Solution;

import java.util.ArrayList;
import java.util.Arrays;
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
	public static void buildheap(int []arr) {
	   /*
	    * As last non leaf node will be at (arr.length-1)/2 
	    * so we will start from this location for heapifying the elements
	    * */
		for(int i = (arr.length - 1) / 2; i >= 0; i--){
			heapify(arr, i, arr.length - 1);
		}
	}
 
	public static void heapify(int[] arr, int i,int size) { 
		int left = 2*i + 1;
		int right = 2*i + 2;
		int max;
		if (left <= size && arr[left] > arr[i]) {
			max = left;
		} else {
			max = i;
		}
 
		if (right <= size && arr[right] > arr[max]) {
			max = right;
		}
		// If max is not current node, exchange it with max of left and right child
		if (max != i) {
			exchange(arr, i, max);
			heapify(arr, max, size);
       }
   }
 
   public static void exchange(int[] arr,int i, int j) {
       int t = arr[i];
       arr[i] = arr[j];
       arr[j] = t; 
   }
 
   public static int heapSort(int[] arr) {
	   buildheap(arr);
	   int sizeOfHeap = arr.length - 1;
	   int count = 1;
	   for (int i = sizeOfHeap; i > 0; i--) {
		   exchange(arr,0, i);
		   if (i != (arr.length - 1) && arr[i + 1] != arr[i]) {
			   count ++;			   
		   }
		   sizeOfHeap = sizeOfHeap - 1;

		   heapify(arr, 0, sizeOfHeap);
	   }
	   return count;
   	}
   
	public int distributeCandies(int[] candies) {
		Arrays.sort(candies);
		//heapSort(candies);
		int count = heapSort(candies);
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
	
	/**
	 * https://leetcode.com/problems/fizz-buzz/
	 * @param n
	 * @return
	 */
    public List<String> fizzBuzz(int n) {
    	String [] str = {"Fizz", "Buzz", "FizzBuzz"};
    	List<String> rt = new ArrayList<>();
    	for (Integer i = 1; i < n + 1; i ++) {
    		if (i % 3 == 0 && i % 5 == 0) {
    			rt.add(str[2]);
    		}
    		else if (i % 3 == 0) {
    			rt.add(str[0]);
    		}
    		else if (i % 5 == 0) {
    			rt.add(str[1]);
    		}
    		else {
    			//rt.add(toNumberString(i));
    			rt.add(i.toString());
    		}
    	}
    	return rt;
    }
    
    /**
     * https://leetcode.com/problems/projection-area-of-3d-shapes/
     */
    public int projectionArea(int[][] grid) {
    	// top to down projection, count all != 0
    	int count = 0;
    	int [] col = new int [grid.length];
    	int [] row = new int [col.length];
    	for (int i = 0; i < row.length; i ++) {
    		for (int j = 0; j < col.length; j ++) {
    			if (grid[i][j] != 0) {
    				count ++;
    			}
    			
    			if (grid[i][j] > row[i]) {
    				row[i] = grid[i][j];
    			}
    			
    			if (grid[i][j] > col[j]) {
    				col[j] = grid[i][j];
    			}
    		}
    	}
    	for (int i = 0; i < col.length; i ++) {
    		count += (row[i] + col[i]);
    	}
    	return count;
    }
    
    /**
     * https://leetcode.com/problems/not-boring-movies/submissions/
     * 
     * select id,movie,description,rating from cinema where id % 2 = 1 and description != 'boring' order by rating DESC
     */
        
    /*
     * https://leetcode.com/problems/swap-salary/submissions/
     * update salary
	set sex =
	  	case sex 
	    	when 'f' then 'm'
	    	when 'm' then 'f'
	  	end;
     */
    
    /**
     * https://leetcode.com/problems/maximum-depth-of-binary-tree/
     */
    private int depth = 0;
    private int max = 0;
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		depth ++;
		System.out.println("val: " + root.val + " ->" + "depth:" + depth);
		maxDepth(root.left);
		maxDepth(root.right);
		if (max < depth) {
			max = depth;
		}
		depth --;
		return max;
	}

    public int maxDepth1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		int max = 0;
		int depth = 1;
		int call = -1; // -1 left, 0 none, 1 right
		boolean stop = false;
		Stack<TreeNode> stack = new Stack<>();
		// mimick maxDepth1
		do {
			// return if null
			if (root == null) {
				root = stack.pop();
				depth --;
				if (call == -1) {
					call = 1;
				}
				else if (call == 1){
					call = 0;
				}
				continue; // return
			}
			
			System.out.println("val: " + root.val + " ->" + "depth:" + depth);

			switch (call) {
			case -1:
				stack.push(root);
				depth ++;
				root = root.left;
				break;
			case 1:
				stack.push(root);
				depth ++;
				root = root.right;
				break;
			case 0:
				if (max < depth) {
					max = depth;
				}
				
				// return
				if (stack.isEmpty()) {
					stop = true;
					break;
				}
				TreeNode next = stack.pop();
				if (next.left == root) {
					call = 1;
				}
				else {
					call = 0;
				}
				root = next;
				depth --;
			}
			
		} while (!stop);
		
		return max;
	}
}