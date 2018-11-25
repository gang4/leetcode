package Solution;

import java.util.Random;

import org.junit.Test;

public class TestSuperpalindromesInRange {
	@Test
	public void test_superpalindromesInRange() {
		int rt = new SuperpalindromesInRange().superpalindromesInRange("4", "1000");
		System.out.println("Count: " + rt);	

		rt = new SuperpalindromesInRange().superpalindromesInRange("103966815", "201619847391450");
		System.out.println("Count: " + rt);
	}
	
	@Test
	public void test_isPalindrome() {
		boolean rt = new SuperpalindromesInRange().isPalindrome(1234L);
		System.out.println("Count: " + rt);
		
		rt = new SuperpalindromesInRange().isPalindrome(1234321L);
		System.out.println("Count: " + rt);	
		
		rt = new SuperpalindromesInRange().isPalindrome(12344321L);
		System.out.println("Count: " + rt);	
	}
	
	@Test
	public void test_getAClosePalindrome() {
		Random r = new Random(System.currentTimeMillis());
		
		String rt = new SuperpalindromesInRange().getAClosePalindrome("1891");
		System.out.println("1891" + " : " + rt);

		
		for (int i = 0; i < 50; i ++) {
			Long s = Math.abs(r.nextLong() % 10000);
			rt = new SuperpalindromesInRange().getAClosePalindrome(s.toString());
			System.out.println(s.toString() + " : " + rt);
		}
	}
	
	@Test
	public void test_nextPalindrome() {
		new SuperpalindromesInRange().nextPalindrome("191");
		new SuperpalindromesInRange().nextPalindrome("1991");
		new SuperpalindromesInRange().nextPalindrome("999");
		new SuperpalindromesInRange().nextPalindrome("9999");
		Long start = 1L;
		String base = start.toString();
		int count = 0;
		for (; count < 10000;) {
			String rt = new SuperpalindromesInRange().nextPalindrome(base);
			System.out.println(base + " : " + rt);
			base = rt;
			count ++;
		}
	}
	
	@Test
	public void test_compare() {
		int rt = new SuperpalindromesInRange().compare("103966815", "201619847391450");
		assert (rt == -1);
		rt = new SuperpalindromesInRange().compare("201619847391450", "103966815");
		assert (rt == 1);
		
		rt = new SuperpalindromesInRange().compare("201", "103");
		assert (rt == 1);
		
		rt = new SuperpalindromesInRange().compare("101", "103");
		assert (rt == -1);
		
		rt = new SuperpalindromesInRange().compare("201", "201");
		assert (rt == 0);
	}
}
