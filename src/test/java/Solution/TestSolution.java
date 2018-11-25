package Solution;

import org.junit.Test;

import Solution.Solution.TreeNode;

public class TestSolution {
	
	@Test
	public void test_Email() {
		String [] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
		int count = new Solution().numUniqueEmails(emails);
		System.out.println("Count: " + count);
	}
	
	@Test
	public void test_ToLowCase() {
		String src = "abCDe";
		String rt = new Solution().toLowerCase(src);
		System.out.println("tolowcase: " + rt);
	}
	
	@Test
	public void test_uniqueMorseRepresentations() {
		String [] src = {"gin", "zen", "gig", "msg", "xhd"};
		int count = new Solution().uniqueMorseRepresentations(src);
		System.out.println("Count: " + count);
	}
	
	@Test
	public void test_sortArrayByParity() {
		int [] src = {0, 1};
		int [] count = new Solution().sortArrayByParity(src);
		print(count);
		
		int [] src1 = {3,1,2,4};
		count = new Solution().sortArrayByParity(src1);
		print(count);
	}
	
	private void print(int [] count) {
		for (int i = 0; i < count.length; i++) {
			System.out.print(" " + count[i]);
		}
		System.out.println("");
	}
	
	@Test
	public void test_judgeCircle() {
		boolean rt = new Solution().judgeCircle("LL");
		System.out.println(rt);
		assert !rt;
		rt = new Solution().judgeCircle("UD");
		System.out.println(rt);
		assert rt;
	}
	
	@Test
	public void test_hammingDistance() {
		int rt = new Solution().hammingDistance(1, 4);
		System.out.println(rt);
		
		rt = new Solution().hammingDistance(1, 6);
		System.out.println(rt);		
	}
	
	@Test
	public void test_mergeTrees() {
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(3);
		t1.left.left = new TreeNode(5);
		t1.right = new TreeNode(2);
		
		TreeNode t2 = new TreeNode(2);
		t2.left = new TreeNode(1);
		t2.right = new TreeNode(3);

		t2.left.right = new TreeNode(4);
		t2.right.right = new TreeNode(7);

		TreeNode newTree = new Solution().mergeTrees(t1, t2);
		assert newTree.val == 3;
	}
}
