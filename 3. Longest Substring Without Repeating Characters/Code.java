package test;

public class code {
	public int lengthOfLongestSubstring(String s) {
		int result = 0;
		int[] array = new int[255];
		for (int i = 0; i < array.length; i++) {
			array[i] = -1;
		}
		int tempLength = 0;
		int startIndex = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (array[c] == -1 || array[c] == i || array[c] < startIndex) {
				array[c] = i;
				tempLength++;
			} else {
				startIndex = array[c];
				i = array[c];
				array[c] = -1;
				if (tempLength > result) {
					result = tempLength;
				}
				tempLength = 0;

			}
		}
		if (result < tempLength) {
			result = tempLength;
		}

		return result;
	}
}
