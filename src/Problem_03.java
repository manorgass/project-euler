public class Problem_03 {
	public void solution() {
		long x = 600851475143L;
	
		/* 마지막 수가 소수가 아닌 경우 분해 작업을 반복. ex) 1029 */
		while(!isSosu(x)) {
			for (long i = 1; i < x; i++) {
				/* i가 소수이며 해당 숫자와 나눠 떨어지는 경우 나눈값을 다시 저장 */
				if (isSosu(i) && x % i == 0) {
					x /= i;
					System.out.println(i);
				}
					
			}
		}
		System.out.println("maximum value is " + x);
	}

	/* 소수인경우 true를 리턴 */
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