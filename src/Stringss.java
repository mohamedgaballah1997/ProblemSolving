import java.util.HashMap;
import java.util.Scanner;

public class Stringss {
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		HashMap<Character, Integer> hm = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (!hm.containsKey(s.charAt(i))) {
				hm.put(s.charAt(i), 1);
			} else
				hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1);
		}
		for (int i = 0; i < t.length(); i++) {
			if (!hm.containsKey(t.charAt(i)) || hm.get(t.charAt(i)) <= 0)
				return false;
			hm.replace(t.charAt(i), hm.get(t.charAt(i)) - 1);
		}
		return true;
	}

	public static int myAtoi(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) < 47 || str.charAt(i) > 57) {
				if (str.charAt(i) != '-')
					str = str.replace(str.charAt(i), ' ');
			}
		}
		str = str.trim();
		System.out.println(str);
		return Integer.parseInt(str);
	}

	public static boolean isPalindrome(String s) {
		s = s.trim();
		if (s.length() <= 1)
			return true;
		s = s.toLowerCase();
		int i = -1, j = s.length();
		while (i++ < j--) {
			System.out.println((int) s.charAt(i));
			try {
				while (!(s.charAt(i) <= 122 && s.charAt(i) >= 97) && !(s.charAt(i) <= 57 && s.charAt(i) >= 47)) {
					i++;
				}
				while (!(s.charAt(j) <= 122 && s.charAt(j) >= 97) && !(s.charAt(j) <= 57 && s.charAt(j) >= 47)) {
					j--;
				}
			} catch (Exception e) {
				return true;
			}
			if (s.charAt(i) != s.charAt(j))
				return false;
		}
		return true;
	}

	public static int strStr(String haystack, String needle) {
		if (needle.isEmpty())
			return 0;
		for (int i = 0; i < haystack.length(); i++) {
			int index = i;
			int j = 0;
			while (haystack.charAt(i) == needle.charAt(j)) {
				i++;
				j++;
				if (i == haystack.length())
					return -1;
				if (j == needle.length())
					return index;
			}

		}
		return -1;
	}

	public static String countAndSay(int n) {
		if (n == 1)
			return Integer.toString(1);
		String[] arr = new String[n];
		arr[0] = "1";
		for (int i = 1; i < n; i++) {
			arr[i] = countAndSayHelper((arr[i - 1]));
			System.out.println(arr[i]);
		}
		return arr[n - 1];
	}

	public static String countAndSayHelper(String n) {

		String number = n;
		String str = "";
		for (int i = 0; i < number.length(); i++) {
			char k = number.charAt(i);
			int counter = 0;
			while (number.charAt(i) == k) {
				counter++;
				i++;
				if (i == number.length())
					break;
			}
			i--;
			str = str.concat("" + counter + "" + k);
		}
		return str;
	}

	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		if (strs.length == 1)
			return strs[0];
		if (strs[0].length() == 0)
			return "";
		int finalIndex = 0;
		for (int i = 1; i < strs.length; i++) {
			int j = 0;
			for (j = 0; j < strs[i].length(); j++) {
				if (strs[0].charAt(j) != strs[i].charAt(j))
					break;
			}
			if (i == 1)
				finalIndex = j - 1;
			else
				finalIndex = Math.min(finalIndex, j - 1);

		}
		return strs[0].substring(0, finalIndex);

	}



	static boolean isMatch(String text, String pattern) {
		int i = 0, j = 0;
		while (i < text.length() || j<pattern.length()) {
			if (j >= pattern.length() || i>=text.length())
				return false;
			if (pattern.charAt(j) == '.' || pattern.charAt(j) == text.charAt(i)) {
				j++;
				i++;
			} else if (pattern.charAt(j) == '*') {
				while(i<text.length() && text.charAt(i)== text.charAt(i-1)) i++;
				j++;
			} else if (pattern.charAt(j) != text.charAt(i) && j < pattern.length() 
					&& pattern.charAt(j + 1) == '*') {
				j += 2;
			} else {
				return false;
			}
		}
		return true;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text=sc.next();
		String pattern=sc.next();
		System.out.println(isMatch(text, pattern));
		sc.close();
	}

}
