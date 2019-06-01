package Solution;

import org.junit.Assert;
import org.junit.Test;

import Solution.Solution1.TreeNode;

public class TestUtil {
	@Test
	public void test() {
		TreeNode root;
		TreeNode gen;
		int depth ;
		// [0]
		root = new TreeNode(0);
		gen = new TreeNodeUtil().treeGen(new Integer [] {0});
		depth = new Solution1().maxDepth(gen);
		Assert.assertEquals(1, depth);
		System.out.println("-----------------");
		// [0,2]
		root = new TreeNode(0);
		root.left = new TreeNode(2);
		gen = new TreeNodeUtil().treeGen(new Integer [] {0, 2});
		depth = new Solution1().maxDepth(gen);
		Assert.assertEquals(2, depth);
		System.out.println("-----------------");
		// [0,null,2]
		root = new TreeNode(1);
		root.right = new TreeNode(3);
		gen = new TreeNodeUtil().treeGen(new Integer [] {0, null, 2});
		depth = new Solution1().maxDepth(gen);
		Assert.assertEquals(2, depth);
		System.out.println("-----------------");
		//[1,2,3]
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		gen = new TreeNodeUtil().treeGen(new Integer [] {0, 2, 3});
		depth = new Solution1().maxDepth(gen);
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
		gen = new TreeNodeUtil().treeGen(new Integer [] {0,2,4,1,null,3,-1,5,1,null,6,null,8});
		depth = new Solution1().maxDepth(gen);
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
		gen = new TreeNodeUtil().treeGen(new Integer [] {0,1,2,3,null,null,4,null,null,null,5});
		depth = new Solution1().maxDepth(gen);
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
		gen = new TreeNodeUtil().treeGen(new Integer [] {3,9,20,null,null,15,7});
		depth = new Solution1().maxDepth(gen);
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
		gen = new TreeNodeUtil().treeGen(new Integer [] {3,null,20,null,17,null,7});
		depth = new Solution1().maxDepth(gen);
		Assert.assertEquals(4, depth);

	}
}
