import java.util.ArrayList;

/**
 * 문제 05번 1 ~ 10 사이의 어떤 수로도 나누어 떨어지는 가장 작은 수는 2520입니다. 그러면 1 ~ 20 사이의 어떤 수로도 나누어
 * 떨어지는 가장 작은 수는 얼마입니까?
 * 
 * @author manorgass
 *
 */
public class Problem_05 {
	int MAX_NUMBER = 20;

	void solution() {
		ArrayList<ArrayList<Integer>> listData = new ArrayList<ArrayList<Integer>>();

		/* step1. 숫자 분해 */
		for (int i = 2; i < MAX_NUMBER + 1; i++)
			listData.add(factorization(i));

		/* step2. 앞에서부터 약수 지워나가며 곱해주기 */
		ArrayList<Integer> listStd, listTarget;
		int tmp;
		for (int i = 0; i < listData.size(); i++) {
			listStd = (ArrayList<Integer>) listData.get(i);
			if (listStd.isEmpty())
				continue;

			for (int j = i + 1; j < listData.size(); j++) {
				listTarget = (ArrayList<Integer>) listData.get(j);

				if (listTarget.isEmpty())
					continue;

				for (int z = 0; z < listStd.size(); z++) {
					tmp = (int) listStd.get(z);

					for (int x = 0; x < listTarget.size(); x++) {
						if (tmp == (int) listTarget.get(x)) {
							listTarget.remove(x);
							break;
						}
					}

					if (listTarget.isEmpty())
						break;
				}
			}
		}

		int result = 1;
		for (int i = 0; i < listData.size(); i++) {
			listTarget = (ArrayList<Integer>) listData.get(i);
			if (listTarget.isEmpty())
				continue;
			for(int j=0; j<listTarget.size(); j++) {
				result *= (int)listTarget.get(j);
				System.out.println("" + (int)listTarget.get(j));
			}
		}
		
		System.out.println("" + result);
	}

	/**
	 * 입력된 숫자를 인수분해 하여 반환한다.
	 * @param arg 인수분해할 숫자
	 * @return 인수분해 결과가 들어있는 ArrayList
	 */
	private ArrayList<Integer> factorization(int arg) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		while (true) {
			if (isSosu(arg)) {
				list.add(arg);
				break;
			}
			for (int i = 2; i < arg; i++) {
				if (arg % i == 0) {
					list.add(i);
					arg /= i;
					break;
				}
			}
		}

		return list;
	}

	/**
	 * 입력된 숫자가 소수인지 아닌지를 구분해준다.
	 * @param x 소수인지 여부를 파악할 숫자
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
