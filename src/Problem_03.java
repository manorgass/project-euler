public class Problem_03 {
	public void solution() {
		long x = 600851475143L;
	
		/* ������ ���� �Ҽ��� �ƴ� ��� ���� �۾��� �ݺ�. ex) 1029 */
		while(!isSosu(x)) {
			for (long i = 1; i < x; i++) {
				/* i�� �Ҽ��̸� �ش� ���ڿ� ���� �������� ��� �������� �ٽ� ���� */
				if (isSosu(i) && x % i == 0) {
					x /= i;
					System.out.println(i);
				}
					
			}
		}
		System.out.println("maximum value is " + x);
	}

	/* �Ҽ��ΰ�� true�� ���� */
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