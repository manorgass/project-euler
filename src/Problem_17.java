/*
 * Project Euler ���� 17. 2017.11.07
 * 
 * 1���� 5������ ���ڸ� ����� ���� one, two, three, four, five �̰�,
 * �� �ܾ��� ���̸� ���ϸ� 3 + 3 + 5 + 4 + 4 = 19 �̹Ƿ� ���� ���ڴ� ��� 19���Դϴ�.
 * 1���� 1,000���� ����� ���� ���� ��� �� ���� ���ڸ� ����ؾ� �ұ��?
 * ����: �� ĭ�̳� ������('-')�� ������ �����ϸ�, �ܾ� ������ and �� ���� �ֽ��ϴ�.
 * ���� ��� 342�� ����� ���� three hundred and forty-two �� �Ǿ 23 ����,
 * 115 = one hundred and fifteen �� ��쿡�� 20 ���ڰ� �˴ϴ�.
 * */
public class Problem_17 {
	public void solution() {
		int allOfLength = 0;
		Problem_17 p = new Problem_17();
		allOfLength = p.caculate();
		System.out.println("result is " + allOfLength);
	}

	private int caculate() {
		int result = 0;
		for (int i = 1; i < 1001; i++) {
			result += getLength(i);
		}

		return result;
	}

	private int getLength(int number) {
		int length = 0;

		if (number == 1000)
			return 11; // OneThousand

		int unit_hundred = number / 100;
		int remainder_hundred = number % 100;

		if (unit_hundred != 0) {
			switch (unit_hundred) {
			case 1: // one
			case 2: // two
			case 6: // six
				length += 3;
				break;
			case 4: // four
			case 5: // five
			case 9: // nine
				length += 4;
				break;
			case 3: // three
			case 7: // seven
			case 8: // eight
				length += 5;
				break;
			}
			length += 7; // hundred
			if (remainder_hundred != 0)
				length += 3; // and
		}

		if (remainder_hundred < 20) {
			switch (remainder_hundred) {
			case 1: // one
			case 2: // two
			case 6: // six
			case 10: // ten
				length += 3;
				break;
			case 4: // four
			case 5: // five
			case 9: // nine
				length += 4;
				break;
			case 3: // three
			case 7: // seven
			case 8: // eight
				length += 5;
				break;
			case 11: // eleven
			case 12: // twelve
				length += 6;
				break;
			case 15: // fifteen
			case 16: // sixteen
				length += 7;
				break;
			case 13: // thirteen
			case 14: // fourteen
			case 18: // eighteen
			case 19: // nineteen
				length += 8;
				break;
			case 17:
				length += 9;
				break;
			}
		} else {
			int unit_ten = remainder_hundred / 10;
			int remainder_ten = remainder_hundred % 10;
			switch (unit_ten) {
			case 4: // forty? fourty?
			case 5:
			case 6:
				length += 5;
				break;
			case 2:
			case 3:
			case 8:
			case 9:
				length += 6;
				break;
			case 7:
				length += 7;
				break;
			}

			switch (remainder_ten) {
			case 1: // one
			case 2: // two
			case 6: // six
				length += 3;
				break;
			case 4: // four
			case 5: // five
			case 9: // nine
				length += 4;
				break;
			case 3: // three
			case 7: // seven
			case 8: // eight
				length += 5;
				break;
			}
		}
		System.out.println("" + number + " ----- " + length);
		return length;
	}
}