import java.math.*;

public class Problem_03 {
	public static void main(String[] args) throws java.lang.Exception {
		// TODO Auto-generated method stub
		BigInteger x = new BigInteger("600851475143");

		for (long i = 1; i < x.longValue(); i++) {
			if (i > Long.MAX_VALUE) {
				System.out.println("range over ;");
				break;
			}

			/* 소수인지 판별 */
			if (isSosu(i) && x.mod(BigInteger.valueOf(i)).equals(BigInteger.ZERO)) {
				x = x.divide(BigInteger.valueOf(i));
			}
		}

		System.out.println(x.longValue());

	}

	private static boolean isSosu(long x) {
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