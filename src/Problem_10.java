import java.math.BigInteger;
import java.util.ArrayList;

public class Problem_10 {
	int MAX_NUMBER = 2000000;

	void solution() {
		boolean isSosu;
		int x = 2;
		BigInteger result = BigInteger.valueOf(2);
		ArrayList<Integer> listSosu = new ArrayList<>();
		listSosu.add(2);

		while (x != MAX_NUMBER) {
			x++;
			isSosu = true;
			for (int i = 0; i < listSosu.size(); i++) {
				if (x % listSosu.get(i) == 0) {
					isSosu = false;
					break;
				}
				// 해당 숫자의 제곱근까지의 소수로만 나누어봐도 소수인지 판별이 가능하다.
				if (Math.sqrt(x) <= listSosu.get(i))
					break;
			}
			if (isSosu) {
				listSosu.add(x);
				result = result.add(BigInteger.valueOf(x));
			}
		}

		System.out.println(result.toString());
	}
}
