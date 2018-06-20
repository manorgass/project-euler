
public class Problem_07 {
	void solution() {
		long x = 1;
		int cnt = 0;

		while (cnt != 10001) {
			x++;
			if (isSosu(x))
				cnt++;
		}

		System.out.println(x);
	}

	/**
	 * 입력된 숫자가 소수인지 아닌지를 구분해준다.
	 * 
	 * @param x
	 *            소수인지 여부를 파악할 숫자
	 * @return 소수라면 true를, 아니라면 false.
	 */
	private boolean isSosu(long x) {
		boolean isSosu = true;

		if (x == 1 || x == 2)
			return true;

		for (long i = 2; i < x; i++) {
			if (x % i == 0) {
				isSosu = false;
				break;
			}
		}
		return isSosu;
	}
}
