package test;

import java.util.List;

public class GetMinTime {
	int min = 1440;
	int first;

	public int findMinDifference(List<String> timePoints) {

		strToInt(timePoints);
		return min;
	}

	public void strToInt(List<String> timePoints) {

		int[] array = new int[1440 / 32];

		for (int i = 0; i < timePoints.size(); i++) {
			String timeStr = timePoints.get(i);
			int hour1 = timeStr.charAt(0) - 48;// 0在48 1在49
			int hour2 = timeStr.charAt(1) - 48;
			int minute1 = timeStr.charAt(3) - 48;
			int minute2 = timeStr.charAt(4) - 48;
			int time = (hour1 * 10 + hour2) * 60 + minute1 * 10 + minute2;

			int arrayIndex = time / 32;// 44 0
			int bitIndex = time % 32;// 31 0
			bitIndex = 1 << (31 - bitIndex);
			int beforeNum = array[arrayIndex];// 记录改变前的值
			array[arrayIndex] = array[arrayIndex] | bitIndex;// 改变值

			// 如果改变后值不变，说明有相同时间，不必继续遍历
			if (beforeNum == array[arrayIndex]) {
				min = 0;
				return;
			}

		}
		operationArray(array);
	}

	public void operationArray(int[] array) {

		int index = -1;
		for (int i = 0; i < array.length; i++) {

			for (int z = 0; z <= 31; z++) {
				if ((array[i] | 1 << (31 - z)) == array[i]) {
					getValue(index, (i * 32 + z));
					index = i * 32 + z;
				}
			}
		}
		getValue(first, index);
	}

	// num1<num2
	public void getValue(int num1, int num2) {
		if (num1 == -1) {
			first = num2;
			return;
		} else {
			int value = num2 - num1;
			if (value > 720) {
				value = 1440 - value;
			}
			if (value < min) {
				min = value;
			}
		}
	}

}
