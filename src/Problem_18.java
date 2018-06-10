public class Problem_18 {

	public void solution() {
		// TODO Auto-generated method stub
		int table[][] = { { 75 }, { 95, 64 }, { 17, 47, 82 }, { 18, 35, 87, 10 }, { 20, 4, 82, 47, 65 },
				{ 19, 1, 23, 75, 3, 34 }, { 88, 2, 77, 73, 7, 63, 67 }, { 99, 65, 4, 28, 6, 16, 70, 92 },
				{ 41, 41, 26, 56, 83, 40, 80, 70, 33 }, { 41, 48, 72, 33, 47, 32, 37, 16, 94, 29 },
				{ 53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14 }, { 70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57 },
				{ 91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48 },
				{ 63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31 },
				{ 4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23 } };

		/* method 1. �����ϰ� �� ���غ��� */
		int height = 15;
		int table_sum[][] = new int[height][];
		for (int i = 0; i < height; i++) {
			table_sum[i] = new int[i + 1];
		}

		table_sum[0][0] = table[0][0];

		int back;
		int front;
		int bigger = 0;
		int count = 0;

		for (int i = 1; i < height; i++) {
			for (int j = 0; j < (i + 1); j++) {
				count++;
				// �� �迭�� �����ִ� ���ڴ� ���� ���� �� �ִ� ����Ǽ��� 1���̹Ƿ� ���� ����ó���� ���ش�.
				if (i == j) {
					table_sum[i][j] = table_sum[i - 1][j - 1] + table[i][j];
					break;
				}

				if (j == 0) {
					table_sum[i][j] = table_sum[i - 1][j] + table[i][j];
				} else {
					back = table_sum[i - 1][j - 1];
					front = table_sum[i - 1][j];
					bigger = (front > back) ? front : back;
					table_sum[i][j] = table[i][j] + bigger;
				}
			}
		}

		int sumOfMax = 0;
		for (int i = 0; i < height; i++) {
			if (sumOfMax < table_sum[height - 1][i])
				sumOfMax = table_sum[height - 1][i];
		}

		System.out.println("result : " + sumOfMax + ", and number of couunt : " + count);
	}
}
