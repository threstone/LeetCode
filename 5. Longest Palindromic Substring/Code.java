public String longestPalindrome(String s) {
		if (s.length() == 0) {
			return "";
		}
		int[] max = new int[2];
		for (int i = 0; i < s.length() - 1; i++) {
			if (i + (max[1] - max[0]) >= s.length() - 1) {
				break;
			}
			char c = s.charAt(i);
			for (int x = i + 1; x < s.length(); x++) {
				if ((x - i) < (max[1] - max[0])) {
					x += ((max[1] - max[0]) - (x - i));
					if (x > s.length()) {
						break;
					}
				}
				if (c == s.charAt(x)) {
					boolean isTrue = true;
					int index1 = i, index2 = x;
					while (index2 > index1) {
						if (s.charAt(index1) != s.charAt(index2)) {
							isTrue = false;
							break;
						}
						index1++;
						index2--;
					}
					if (isTrue) {
						max[0] = i;
						max[1] = x;
					}
				}
			}
		}

		return s.substring(max[0], max[1] + 1);
	}