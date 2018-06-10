public class Problem_02 {
	public void solution() {
		int fiboIdx_01, fiboIdx_02, fiboIdx_03, sum;
		fiboIdx_01 = 1;
		fiboIdx_02 = 1;
		sum = 0;

		while (true) {
			fiboIdx_03 = fiboIdx_01 + fiboIdx_02;
			/* 4백만 이상일 경우 루프 탈출 */
			if (fiboIdx_03 > 4000000)
				break;
			/* 짝수인 경우에만 sum에 더해줌 */
			if (fiboIdx_03 % 2 == 0)
				sum += fiboIdx_03;
			fiboIdx_01 = fiboIdx_02;
			fiboIdx_02 = fiboIdx_03;
		}
		System.out.println("" + sum);
	}
}