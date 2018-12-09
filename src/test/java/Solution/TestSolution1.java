package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import Solution.Solution1.ListNode;
import Solution.Solution1.Node;
import Solution.Solution1.TreeNode;
import junit.framework.Assert;

public class TestSolution1 {
	@Test
	public void test_selfDividingNumbers() {
		List<Integer> list = new Solution1().selfDividingNumbers(1, 22);
		list.forEach( i -> {
			System.out.println("number: " + i);
		});
	}
	
	@Test
	public void test_arrayPairSum() {
		int [] nums = {1,4,3,2};
		int rt = new Solution1().arrayPairSum(nums);
		System.out.println("number: " + rt);
	}
	
	@Test
	public void test_peakIndexInMountainArray() {
		int [] nums = {40,48,61,75,100,99,98,39,30,10};
		int rt = new Solution1().peakIndexInMountainArray(nums);
		System.out.println("number: " + rt);
		
		nums = new int[] {0, 1, 0};
		rt = new Solution1().peakIndexInMountainArray(nums);
		System.out.println("number: " + rt);
	}
	
	@Test
	public void test_sortArrayByParityII() {
		int [] nums = {648,831,560,986,192,424,997,829,897,843};
		nums = new Solution1().sortArrayByParityII(nums);
		Arrays.stream(nums).forEach( i -> {
			System.out.println("number: " + i);
		});
		
		nums = new int[] {3,1,4,2};
		nums = new Solution1().sortArrayByParityII(nums);
		Arrays.stream(nums).forEach( i -> {
			System.out.println("number: " + i);
		});
	}
	
	@Test
	public void test_n_tree() {
		Node root = new Node();
		root.val = 1;
		root.children = new ArrayList<>();
		Node n = new Node();
		n.val = 3;
		root.children.add(n);
		n.children = new ArrayList<>();
		Node n1 = new Node();
		n1.val = 5;
		n.children.add(n1);
		n1 = new Node();
		n1.val = 6;
		n.children.add(n1);
		
		n = new Node();
		n.val = 2;
		root.children.add(n);
		n = new Node();
		n.val = 4;
		root.children.add(n);
		
		List<Integer> l = new Solution1().preorder(null);
		l.forEach(i -> {
			System.out.println(i);
		});
		System.out.println("---------------------");
		
		l = new Solution1().preorder(root);
		l.forEach(i -> {
			System.out.println(i);
		});
		
		System.out.println("---------------------");
		l = new Solution1().postorder(root);
		l.forEach(i -> {
			System.out.println(i);
		});

		System.out.println("---------------------");		
		int depth = new Solution1().maxDepth(root);
		System.out.println(depth);
	}
	
	@Test
	public void test_smallestRangeI() {
		int [] A = {1};
		int d = new Solution1().smallestRangeI(A, 0);
		System.out.println(d);
		
		A = new int [] {10,7,1};
		d = new Solution1().smallestRangeI(A, 3);
		System.out.println(d);
		
		A = new int [] {1,3,6};
		d = new Solution1().smallestRangeI(A, 3);
		System.out.println(d);
	}
	
	@Test
	public void test_middleNode() {
		ListNode root = new ListNode(1);
		ListNode tmp = root;
		tmp.next = new ListNode(2);
		tmp = tmp.next;
		tmp.next = new ListNode(3);
		tmp = tmp.next;
		tmp.next = new ListNode(4);
		tmp = tmp.next;
		tmp.next = new ListNode(5);
		
		ListNode node = new Solution1().middleNode(root);
		while (node != null) {
			System.out.println(node.val);
			node =  node.next;
		}
		System.out.println("---------------------");
		tmp = tmp.next;
		tmp.next = new ListNode(6);
		node = new Solution1().middleNode(root);
		while (node != null) {
			System.out.println(node.val);
			node =  node.next;
		}
	}
	
	@Test
	public void test_reverseWords() {
		String rt = new Solution1().reverseWords("Let's take LeetCode contest");
		System.out.println(rt);
	}
	
	@Test
	public void test_subdomainVisits() {
		String [] in = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
		List<String> l = new Solution1().subdomainVisits(in);
		l.forEach(i -> {
			System.out.println(i);
		});
	}
	
	@Test
	public void test_findComplement() {
		System.out.println(new Solution1().findComplement(5));
	}
	
	
	@Test
	public void test_shortestToChar() {
		String S = new String("loveleetcode");
		int [] rt = new Solution1().shortestToChar(S, 'e');
		printAray(rt);
		
		S = "aaba";
		rt = new Solution1().shortestToChar(S, 'b');
		printAray(rt);
	}

	private void printAray(int[] rt) {
		for (int i = 0; i < rt.length; i ++) {
			System.out.print(rt[i]);
			System.out.print(",");
		}
		System.out.println("");
	}
	
	@Test
	public void test_findWords() {
		String [] S = {"Hello", "Alaska", "Dad", "Peace"};
		String [] rt = new Solution1().findWords(S);
		Arrays.asList(rt).forEach(s -> {System.out.println(s);});
	}
	
	@Test
	public void test_leafSimilar() {
		TreeNode root1 = new TreeNode(18);
		root1.left = new TreeNode(35);
		root1.right = new TreeNode(22);
		root1.left.right = new TreeNode(103);
		root1.left.right.left = new TreeNode(58);
		root1.right.left = new TreeNode(43);
		root1.right.right = new TreeNode(101);
		root1.right.left.left = new TreeNode(97);
		
		TreeNode root2 = new TreeNode(94);
		root2.left = new TreeNode(102);
		root2.left.left = new TreeNode(122);
		root2.left.left.left = new TreeNode(58);
		root2.left.left.right = new TreeNode(101);
		root2.right = new TreeNode(17);
		root2.right.right = new TreeNode(54);
		root2.right.left = new TreeNode(97);

		boolean rt = new Solution1().leafSimilar(root1, root2);
		System.out.println(rt);
	}
	
	@Test
	public void test_isToeplitzMatrix() {
		int [][] matrix2 = {{11,74,0,93}, {40,11,74,7}};
		boolean rt = new Solution1().isToeplitzMatrix(matrix2);
		System.out.println(rt);
				
		int [][] matrix = {{1,2,3,4}, {5,1,2,3}, {9,5,1,2}};
		rt = new Solution1().isToeplitzMatrix(matrix);
		System.out.println(rt);
		
		int [][] matrix1 = {{1,2,3,4}, {5,1,2,3}, {9,5,1,2}, {3,9,5,1}};
		rt = new Solution1().isToeplitzMatrix(matrix1);
		System.out.println(rt);
	}
	
	@Test
	public void test_uncommonFromSentences() {
		String A = "this apple is sweet";
		String B = "this apple is sour";
		String [] rt = new Solution1().uncommonFromSentences(A, B);
		System.out.println(rt);
		
		
		String A1 = "s z z z s";
		String B1 = "s z ejt";
		rt = new Solution1().uncommonFromSentences(A1, B1);
		System.out.println(rt);

	}
	
	@Test
	public void test_islandPerimeter() {
		int [][] grid = {{0,1,0,0},
		                 {1,1,1,0},
		                 {0,1,0,0},
		                 {1,1,0,0}};
		int rt = new Solution1().islandPerimeter(grid);
		System.out.println(rt);
	}
	
	@Test
	public void test_trimBST() {
		/*
		 Input: 
		    1
		   / \
		  0   2
		 */
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(2);
		new Solution1().trimBST(root, 1, 2);
		
		/*
		    3
		   / \
		  0   4
		   \
		    2
		   /
		  1		 
		 */
		root = new TreeNode(3);
		root.left = new TreeNode(0);
		root.right = new TreeNode(4);
		
		root.left.right = new TreeNode(2);
		
		root.left.right.left = new TreeNode(1);
		new Solution1().trimBST(root, 1, 3);
	}
	
	@Test
	public void test_increasingBST() {
		
		/*
		[379
		 826]
		 */
		TreeNode root = new TreeNode(379);
		root.left = new TreeNode(826);
		new Solution1().increasingBST(root);

		/*
		       5
		      / \
		    3    6
		   / \    \
		  2   4    8
		 /        / \ 
		1        7   9
		 */
		root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.left.left.left = new TreeNode(1);
		
		root.right = new TreeNode(6);
		root.right.right = new TreeNode(8);
		root.right.right.left = new TreeNode(7);
		root.right.right.right = new TreeNode(9);
		
		new Solution1().increasingBST(root);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void test_binaryGap() {
		int rt = new Solution1().binaryGap(6);
		Assert.assertEquals(1, rt);

		rt = new Solution1().binaryGap(22);
		Assert.assertEquals(2, rt);
		
		rt = new Solution1().binaryGap(5);
		Assert.assertEquals(2, rt);
		
		rt = new Solution1().binaryGap(8);
		Assert.assertEquals(0, rt);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void test_distributeCandies() {
		int [] candise = new int [] {0,10,0,10,0,10,0,10,0,10};
		int rt = new Solution1().distributeCandies(candise);
		Assert.assertEquals(2, rt);

		candise = new int [] {1,1,2,2,3,3};
		rt = new Solution1().distributeCandies(candise);
		Assert.assertEquals(3, rt);
		
		candise = new int [] {1,1,2,3};
		rt = new Solution1().distributeCandies(candise);
		Assert.assertEquals(2, rt);
	}
	
	@Test
	public void test_fizzBuzz() {
		List<String> rt = new Solution1().fizzBuzz(15);
		rt.forEach(s -> {
			System.out.print(s + " ,");
		});
		System.out.println("");
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void test_projectionArea() {
		int [][] in;
		int rt;
		//[[1,1,1],[1,0,1],[1,1,1]]
		in = new int [][] {{2,2,2},{2,1,2},{2,2,2}};
		rt = new Solution1().projectionArea(in);
		Assert.assertEquals(21, rt);
		
		in = new int [][] {{1,1,1},{1,0,1},{1,1,1}};
		rt = new Solution1().projectionArea(in);
		Assert.assertEquals(14, rt);
				
		in = new int [][] {{1,0},{0,2}};
		rt = new Solution1().projectionArea(in);
		Assert.assertEquals(8, rt);
		
		in = new int[][] {{1,2},{3,4}};
		rt = new Solution1().projectionArea(in);
		Assert.assertEquals(17, rt);
		
		in = new int [][] {{2}};
		rt = new Solution1().projectionArea(in);
		Assert.assertEquals(5, rt);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void test_maxDepth() {
		TreeNode root;
		int depth ;
		// [0]
		root = new TreeNode(0);
		depth = new Solution1().maxDepth(root);
		Assert.assertEquals(1, depth);
		System.out.println("-----------------");
		// [0,2]
		root = new TreeNode(0);
		root.left = new TreeNode(2);
		depth = new Solution1().maxDepth(root);
		Assert.assertEquals(2, depth);
		System.out.println("-----------------");
		// [0,null,2]
		root = new TreeNode(1);
		root.right = new TreeNode(3);
		depth = new Solution1().maxDepth(root);
		Assert.assertEquals(2, depth);
		System.out.println("-----------------");
		//[1,2,3]
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		depth = new Solution1().maxDepth(root);
		Assert.assertEquals(2, depth);
		System.out.println("-----------------");
		// [0,2,4,1,null,3,-1,5,1,null,6,null,8]
		/**
		 *       0
		 *      / \
		 *     2   4
		 *    /   / \
		 *   1   3  -1 
		 *  / \   \   \ 
		 * 5   1   6   8
		 */
		root = new TreeNode(0);
		root.left = new TreeNode(2);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(-1);
		root.left.left.left = new TreeNode(5);
		root.left.left.right = new TreeNode(1);
		root.right.right.right = new TreeNode(5);
		root.right.left.right = new TreeNode(6);
		root.right.right.right = new TreeNode(8);
		depth = new Solution1().maxDepth(root);
		Assert.assertEquals(4, depth);
		
		// [0,0,0,0,null,null,0,null,null,null,0]
		/**
		 * 		0
		 * 	   / \
		 *    1   2
		 *   /     \
		 *  3       4
		 *           \
		 *            5
		 */
		root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.left.left = new TreeNode(3);
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(5);
		depth = new Solution1().maxDepth(root);
		Assert.assertEquals(4, depth);
		/**
		    3
		   / \
		  9  20
		    /  \
		   15   7
   		 */
		root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		depth = new Solution1().maxDepth(root);
		Assert.assertEquals(3, depth);
		
		/**
	    3
	     \
	     20
	       \
	        17
	         \
	          7
		 */
		root = new TreeNode(3);
		root.right = new TreeNode(20);
		root.right.right = new TreeNode(17);
		root.right.right.right = new TreeNode(7);
		
		depth = new Solution1().maxDepth(root);
		Assert.assertEquals(4, depth);
	}
}
