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
	
		/* step1. 2부터 20까지의 숫자를 소인수분해 */
		for (int i = 2; i < MAX_NUMBER + 1; i++)
			listData.add(factorization(i));
	
		/* step2. 숫자 n의 공약수가 x와 나누어 떨어지는 경우, 해당 숫자를 지워준다. (단, x > n) */
		ArrayList<Integer> listMinNum, listCompareNum;
		int tmp;
		for (int idxData = 0; idxData < listData.size(); idxData++) {
			listMinNum = (ArrayList<Integer>) listData.get(idxData);
			if (listMinNum.isEmpty())
				continue;
	
			for (int idxCompareData = idxData + 1; idxCompareData < listData.size(); idxCompareData++) {
				listCompareNum = (ArrayList<Integer>) listData.get(idxCompareData);
	
				if (listCompareNum.isEmpty())
					continue;
	
				for (int idxMinNum = 0; idxMinNum < listMinNum.size(); idxMinNum++) {
					tmp = (int) listMinNum.get(idxMinNum);
	
					for (int idxCompareNum = 0; idxCompareNum < listCompareNum.size(); idxCompareNum++) {
						if (tmp == (int) listCompareNum.get(idxCompareNum)) {
							listCompareNum.remove(idxCompareNum);
							break;
						}
					}
	
					if (listCompareNum.isEmpty())
						break;
				}
			}
		}
		
		/* 남은 숫자들을 모두 곱한다. */
		int result = 1;
		for (int i = 0; i < listData.size(); i++) {
			listCompareNum = (ArrayList<Integer>) listData.get(i);
			if (listCompareNum.isEmpty())
				continue;
			for(int j=0; j<listCompareNum.size(); j++) {
				result *= (int)listCompareNum.get(j);
				System.out.println("" + (int)listCompareNum.get(j));
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
