package Solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numJewelsInStones(String J, String S) {
        char[] ja = J.toCharArray();
        char[] sa = S.toCharArray();
        Arrays.sort(ja);
        Arrays.sort(sa);

        int count = 0;
        for (int i = 0; i < sa.length; i ++) {
            int k = 0;
            for (; k < ja.length; k ++) {
                if (ja[i] == sa[k]) {
                    count ++;
                    break;
                }
                else if (ja[i] > sa[k]) {
                    break;
                }
                // else { // if (ja[i] < sa[k])
                //
                // }
            }

            if (k == ja.length) {
                break;
            }
        }
        return count;
    }

    public int numUniqueEmails(String[] emails) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < emails.length; i ++) {
        	char [] dest = new char[100];
        	int index = 0;
        	boolean escape = false;
        	for (int j = 0; j < emails[i].length(); j ++) {
        		if (emails[i].charAt(j) == '@') {
        			for (int k = j; k < emails[i].length(); k ++) {
        				dest[index] = emails[i].charAt(k);
        				index ++;
        			}
        			String key = new String(dest);
        			if (map.get(key) == null) {
        				map.put(key, "");
        			}
        			break;
        		}
        		else if (escape) {
        			continue;
        		}
        		else if (emails[i].charAt(j) == '+') {
        			escape = true;
        			continue;
        		}
        		else if (emails[i].charAt(j) == '.') {
        			continue;
        		}
        		
        		dest[index] = emails[i].charAt(j);
				index ++;
        	}
        	
        }
        return map.size();
    }
    
    public String toLowerCase(String str) {
    	char [] rt = str.toCharArray();
    	for (int i = 0; i < str.length(); i ++) {
    		rt[i] = (char)(rt[i] | 0x20);
    	}
    	return new String(rt);
    }
    
    static String [] strCodes = {
    		".-", 
    		"-...", 
    		"-.-.", 
    		"-..", 
    		".", 
    		"..-.", 
    		"--.", 
    		"....",
    		"..",
    		".---",
    		"-.-",
    		".-..",
    		"--",
    		"-.",
    		"---",
    		".--.",
    		"--.-",
    		".-.",
    		"...",
    		"-",
    		"..-",
    		"...-",
    		".--",
    		"-..-",
    		"-.--",
    		"--.."};
	
    public int uniqueMorseRepresentations(String[] words) {
    	long [] codes = new long [words.length];
    	int idx = 0;
    	for (int i = 0; i < words.length; i ++) {
    		long code = 0x1L;
    		for (int j = 0; j < words[i].length(); j ++) {
    			for (int k = 0; k < strCodes[words[i].charAt(j) - 0x61].length(); k ++) {
    				if (strCodes[words[i].charAt(j) - 0x61].charAt(k) == '-') {
    					code = code << 1;
    				}
    				else {
    					code = (code << 1) + 1; 
    				}
    			}
    		}
    		
    		if (idx == 0) {
    			codes[0] = code;
    			idx ++;
    			continue;
    		}
    		
    		int j = 0;
    		for (; j < idx; j ++) {
    			if (codes[j] == code) {
    				break;
    			}
    			else if (codes[j] < code) {
    				continue;
    			}
    			else {
    				for (int k = idx; j <= k; k --) {
    					codes[k] = codes[k - 1];
    				}
    				codes[j] = code;
    				idx ++;
    				break;
    			}
    		}
    		
    		if (j == idx) {
    			codes[j] = code;
    			idx ++;
    		}
    	}
    	
    	return idx;
    }
    
    public int[] sortArrayByParity(int[] A) {
    	int idx = A.length;
    	for (int i = 0; i < idx; i ++) {
    		if ((A[i] & 1) != 0) {
    			for (; i < idx;) {
    				if ((A[idx - 1] & 1) == 0) {
    					int tmp = A[idx - 1];
    					A[idx - 1] = A[i];
    					A[i] = tmp;
    					idx --;
    					break;
    				}
    				else {
    					idx --;
    				}
    			}
    		}
    	}
        return A; 
    }
    
    /**
     * https://leetcode.com/problems/delete-columns-to-make-sorted/
     * Think about A is a spread sheet. You have N columns and X rows
     * For each column is a char in row x1 > a char in row x2, and
     * x1 < x2, delete that column.
     * @param A
     * @return
     */
    public int minDeletionSize(String[] A) {
    	return 0;
    }
    
    /*
     * https://leetcode.com/problems/robot-return-to-origin/
     */
    public boolean judgeCircle(String moves) {
    	int ud = 0;
    	int lr = 0;
    	for (int i = 0; i < moves.length(); i ++) {
    		switch (moves.charAt(i)) {
    		case 'U':
    			ud ++;
    			break;
    		case 'D':
    			ud --;
    			break;
    		case 'L':
    			lr ++;
    			break;
    		case 'R':
    			lr --;
    			break;
    		}
    	}
    	if (ud == 0 && lr == 0) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    /**
     * https://leetcode.com/problems/hamming-distance/
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
    	int count = 0;
    	while (x != 0 || y != 0 ) {
    		if ((x & 0x1) != (y & 0x1)) {
    			count ++;
    		}
    		x >>= 1;
    		y >>= 1;
    	}
    	return count;
    }
    
    /**
     * https://leetcode.com/problems/flipping-an-image/
     * scan once only
     */
    public int[][] flipAndInvertImage(int[][] A) {
    	return null;
    }
    
    /**
     * https://leetcode.com/problems/merge-two-binary-trees/
     */
    
    public static class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { 
    		val = x; 
    	}
    }
    
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    	// If both == null, return null
    	if (t1 == null) {
    		return t2;
    	}
    	else if (t2 == null) {
    		return t1;
    	}
    	
    	t1.val += t2.val;
    	t1.left = mergeTrees(t1.left, t2.left);
    	t1.right = mergeTrees(t1.right, t2.right);
    	return t1;
    } 

};
