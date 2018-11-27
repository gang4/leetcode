package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

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
}