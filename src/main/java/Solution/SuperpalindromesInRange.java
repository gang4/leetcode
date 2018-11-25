package Solution;

public class SuperpalindromesInRange {
    public int superpalindromesInRange(String L, String R) {
    	int count = 0;
    	Double sqIn = Math.sqrt(Long.parseLong(L));
    	Long lStart;
    	if (Math.floor(sqIn) - sqIn != 0.0) {
    		lStart = sqIn.longValue() + 1;
    	}
    	else {
    		lStart = sqIn.longValue();
    	}
    	
    	String start = getAClosePalindrome(lStart.toString());
    	lStart = Long.parseLong(start);
    	Long sq = lStart * lStart;
    	while (compare(sq.toString(), R) <= 0) {
    		if (isPalindrome(sq.longValue())) {
        		count ++;
    		}
    		start = nextPalindrome(start);
        	lStart = Long.parseLong(start);
        	sq = lStart * lStart;
    	} 
    	return count;
    }
    
    String getAClosePalindrome(String num) {
    	char [] p = num.toCharArray();
    	int len = p.length;
    	for (int i = 0; i < p.length / 2; i ++) {
			p[len - (i + 1)] = p[i];
    	}
    	String rt = new String(p);
    	while (Long.parseLong(num) > Long.parseLong(rt)) {
    		rt = nextPalindrome(rt);
    	}
    	return rt;    	
    }
    
    int compare(String a, String b) {
    	if (a.length() < b.length()) {
    		return -1;
    	}
    	else if (a.length() > b.length()) {
    		return 1;
    	}
    	else {
    		for (int i = 0; i < a.length(); i ++) {
    			if (a.charAt(i) < b.charAt(i)) {
    				return -1;
    			}
    			else if (a.charAt(i) > b.charAt(i)) {
    				return 1;
    			}
    		}
    		return 0;
    	}
    }
    
    String nextPalindrome(String num) {
    	char [] p = num.toCharArray();
		int len = p.length;
		int half = len / 2;
		if ((len & 0x1) == 0x1 && p[half] != '9') {
			p[half] += 1;
		}
		else if (1 < len) {
			half += (len & 0x1);
	    	for (int i = 0; i < half; i ++) {
	    		if (p[half - (len & 0x1) + i] == '9') {
	    			p[half - (len & 0x1) + i] = '0';
	    			p[half - (i + 1)] = p[half - (len & 0x1) + i];
	    			continue;
	    		}
	    		
	    		p[half - (len & 0x1) + i] += 1;
	    		p[half - (i + 1)] = p[half - (len & 0x1) + i];
	    		break;
	    	}
		}
		
		String rt = new String(p);
		Long r = Long.parseLong(rt);
		if (r == 0 || Long.parseLong(num) == 9) {
			Long tmp = Long.parseLong(num);
			tmp += 2;
			rt = tmp.toString();
		}
    	return rt;
    }
    
    boolean isPalindrome(Long num) {
    	String s = num.toString();
    	int len = s.length() - 1;
    	for (int i = 0; i < len + 1; i ++) {
    		if (s.charAt(i) == s.charAt(len - i)) {
    			continue;
    		}
    		else {
    			return false;
    		}
    	}
    	return true;
    }
}
