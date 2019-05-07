package test;

import java.util.List;

public class GetMinTime {
	int min = 1440;
	int[] array = new int[1440];
	int first;

	public int findMinDifference(List<String> timePoints) {

		getMin(timePoints);
		return min;
	}

	public void getMin(List<String> timePoints) {
		for (int i = 0; i < timePoints.size(); i++) {
			String strTime = timePoints.get(i);
			int hour1 = strTime.charAt(0) - 48;// 0在48 1在49
			int hour2 = strTime.charAt(1) - 48;
			int minute1 = strTime.charAt(3) - 48;
			int minute2 = strTime.charAt(4) - 48;
			int time = (hour1 * 10 + hour2) * 60 + minute1 * 10 + minute2;
			if (array[time] != 0) {
				min = 0;
				return;
			}
			array[time] = 1;
		}

		int index = -1;

		for (int i = 0; i < 1440; i++) {

			if (array[i] == 1) {
				getValue(index, i);
				index = i;
			}
		}

		getValue(first, index);
	}

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
