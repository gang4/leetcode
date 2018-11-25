package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import Solution.Solution1.ListNode;
import Solution.Solution1.Node;

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
}
