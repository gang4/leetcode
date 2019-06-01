package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import Solution.Solution1.TreeNode; 

public class TestSolution2 {
	
	@Test
	public void testSingleNumber() {
		int [] nums;
		int rt;
		nums = new int [] {2,2,1}; 
		rt = new Solution2().singleNumber(nums);
		Assert.assertEquals(1, rt);
		
		nums = new int [] {4,1,2,1,2}; 
		rt = new Solution2().singleNumber(nums);
		Assert.assertEquals(4, rt);
	}
	
	@Test
	public void testNextGreaterElement() {
		int [] rt;
		rt = new Solution2().nextGreaterElement(new int [] {1,3,4,2}, new int [] {4,1,2});
		Assert.assertArrayEquals(rt , new int [] {-1,3,-1});
	}
	
	@Test
	public void testAverageOfLevels() {
		TreeNode gen;
		List<Double> list;
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
		gen = new TreeNodeUtil().treeGen(new Integer [] {0,2,4,1,null,3,-1,5,1,null,6,null,8});
		list = new Solution2().averageOfLevels(gen);
		Assert.assertEquals(new Double(5.0), list.get(3));
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
		gen = new TreeNodeUtil().treeGen(new Integer [] {0,1,2,3,null,null,4,null,null,null,5});
		list = new Solution2().averageOfLevels(gen);
		Assert.assertEquals(new Double(5.0), list.get(3));
		/**
		    3
		   / \
		  9  20
		    /  \
		   15   7
   		 */
		gen = new TreeNodeUtil().treeGen(new Integer [] {3,9,20,null,15,7});
		list = new Solution2().averageOfLevels(gen);
		Assert.assertEquals(new Double((15 + 7) / 2.0), list.get(2));
		/**
	    3
	     \
	     20
	       \
	        17
	         \
	          7
		 */
		gen = new TreeNodeUtil().treeGen(new Integer [] {3,null,20,null,17,null,7});
		list = new Solution2().averageOfLevels(gen);
		Assert.assertEquals(new Double(17), list.get(2));
		// [2147483647,2147483647,2147483647]
		gen = new TreeNodeUtil().treeGen(new Integer [] {2147483647, 2147483647, 2147483647});
		list = new Solution2().averageOfLevels(gen);
		Assert.assertEquals(new Double(17), list.get(2));
	}
	
	@Test
	public void testLevelOrder() {
		Solution2.Node root = new Solution2.Node();
		root.val = 1;
		root.children = new ArrayList<>();
		Solution2.Node child1 = new Solution2.Node();
		child1.val = 3;
		root.children.add(child1);
		Solution2.Node child2 = new Solution2.Node();
		child2.val = 2;
		root.children.add(child2);
		Solution2.Node child3 = new Solution2.Node();
		child3.val = 4;
		root.children.add(child3);	
		
		child1.children = new ArrayList<>();
		Solution2.Node child4 = new Solution2.Node();
		child4.val = 5;
		child1.children.add(child4);
		Solution2.Node child5 = new Solution2.Node();
		child5.val = 6;
		child1.children.add(child5);
		
		List<List<Integer>> rt = new Solution2().levelOrder(root);
		Assert.assertEquals(3, rt.get(1).size());
	}
	
	@Test
	public void testInvertTree() {
		/*
		 * 
		     4
		   /   \
		  2     7
		 / \   / \
		1   3 6   9
		 */
		TreeNode gen;
		gen = new TreeNodeUtil().treeGen(new Integer [] {4,2,7,1,3,6,9});
		new Solution2().invertTree(gen);
		Assert.assertEquals(9, gen.left.left.val);
		/*
		 		1
		 	   /
		 	  2
		 */
		gen = new TreeNodeUtil().treeGen(new Integer [] {1,2});
		new Solution2().invertTree(gen);
		Assert.assertEquals(null, gen.left);
	}
	
	@Test
	public void testFindLUSlength() {
		String a;
		String b;
		int rt;
		a = "aefawfawfawfaw";
		b = "aefawfeawfwafwaef";
		rt = new Solution2().findLUSlength(a, b);
		Assert.assertEquals(rt, 17);
		
		a = "horbxeemlgqpqbujbdagizcfairalg";
		b = "iwvtgyojrfhyzgyzeikqagpfjoaeen";
		System.out.println(b.length());
		rt = new Solution2().findLUSlength(a, b);
		Assert.assertEquals(rt, 30);
	}
	
	@Test
	public void testSortedSquares() {
		int [] t1 = {-4,-1,0,3,10};
		int [] t2 = {0,1,9,16,100};
		t1 = new Solution2().sortedSquares(t1);
		System.out.println(Arrays.toString(t1));
		Assert.assertArrayEquals(t1, t2);
		
		int [] t3 = {-7,-3,2,3,11};
		int [] t4 = {4,9,9,49,121};
		t3 = new Solution2().sortedSquares(t3);
		System.out.println(Arrays.toString(t3));
		Assert.assertArrayEquals(t3, t4);
	}
	
	@Test
	public void testRepeatedNTimes() {
		int [] t1 = {1,2,3,3};
		int rt = new Solution2().repeatedNTimes(t1);
		Assert.assertEquals(rt, 3);
		
		int [] t2 = {2,1,2,5,3,2};
		rt = new Solution2().repeatedNTimes(t2);
		Assert.assertEquals(rt, 2);
		
		int [] t3 = {9,5,3,3};
		rt = new Solution2().repeatedNTimes(t3);
		Assert.assertEquals(rt, 3);
	}
	
	@Test
	public void testTranspose() {
		int [][] a = {{1,2,3},{4,5,6},{7,8,9}};
		a = new Solution2().transpose(a);
		int [][] b = {{1,4,7},{2,5,8},{3,6,9}}; 
		Assert.assertArrayEquals(a, b);
		
		int [][] a1 = {{1,2,3},{4,5,6}};
		int [][] a11 = new Solution2().transpose(a1);
		int [][] b1 = {{1,4},{2,5},{3,6}};
		Assert.assertArrayEquals(a11, b1);
		
		int [][] b11 = new Solution2().transpose(a11);
		Assert.assertArrayEquals(a1, b11);
	}
	
	@Test
	public void testMinDeletionSize() {
		String [] a = {"cba","daf","ghi"};
		int rt = new Solution2().minDeletionSize(a);
		Assert.assertEquals(rt, 1);
		
		String [] b = {"a","b"};
		rt = new Solution2().minDeletionSize(b);
		Assert.assertEquals(rt, 0);
		
		String []  c = {"zyx","wvu","tsr"};
		rt = new Solution2().minDeletionSize(c);
		Assert.assertEquals(rt, 3);

	}
	
	@Test
	public void testTwoSum() {
//		int [] a = {2, 7, 11, 15};
//		int [] rt = new Solution2().twoSum(a,  9);
//		Assert.assertArrayEquals(rt, new int [] {0,1});
//		
//		int [] b = {16, 2, 1, 7, 11, 15};
//		rt = new Solution2().twoSum(b,  9);
//		Assert.assertArrayEquals(rt, new int [] {1,3});
		
		int [] c = {0,4,3,0};
		int [] rt = new Solution2().twoSum(c,  0);
		Assert.assertArrayEquals(rt, new int [] {0,3});
	}
}
