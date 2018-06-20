import java.util.Scanner;

public class Problem_04 {
	public void solution() {
		int arg1 = 999, arg2;
		int result = 0;
		int tmp;

		while (true) {
			arg2 = arg1;
			for (int i = 0; i < arg1; i++) {
				tmp = arg1 * arg2;

				if (tmp % 10 == tmp / (int) Math.pow(10, numOfDigit(tmp) - 1) && result < tmp) {
					if (isSymmetryNumber(tmp)) {
						result = tmp;
						System.out
								.println("current biggest symmetry number is " + result + " = " + arg1 + " * " + arg2);
					}
				}
				arg2--;
				if (arg2 < 100)
					break;
			}
			arg1--;
			if (arg1 == 0 && arg1 < 100)
				break;
		}
	}

	public void test_isSymmetryNumber() {
		Scanner scanner = new Scanner(System.in);
		int input;
		String result;
		while (true) {
			input = scanner.nextInt();
			if (input == 0)
				break;

			result = isSymmetryNumber(input) ? "true" : "false";
			System.out.println(result);
		}
	}

	public boolean isSymmetryNumber(int arg) {
		int digit = numOfDigit(arg);
		int originNum = arg;
		int symmetryNum = 0;
		int powCnt = digit - 1;

		for (int i = 0; i < digit; i++) {
			symmetryNum += (arg % 10) * Math.pow(10, powCnt);
			arg /= 10;
			powCnt--;
		}

		if (originNum == symmetryNum)
			return true;
		else
			return false;
	}

	public void test_numOfDigit() {
		Scanner scanner = new Scanner(System.in);
		int input;
		while (true) {
			input = scanner.nextInt();
			if (input == 0)
				break;
			System.out.println(numOfDigit(input));
		}
	}

	public int numOfDigit(int arg) {
		int numOfDigit = 1;

		if (arg < 10)
			return numOfDigit;
		else {
			while (true) {
				arg /= 10;
				numOfDigit++;
				if (arg < 10)
					return numOfDigit;
			}
		}
	}
}
