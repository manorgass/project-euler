/*
 * Project Euler 문제 17. 2017.11.07
 * 
 * 1부터 5까지의 숫자를 영어로 쓰면 one, two, three, four, five 이고,
 * 각 단어의 길이를 더하면 3 + 3 + 5 + 4 + 4 = 19 이므로 사용된 글자는 모두 19개입니다.
 * 1부터 1,000까지 영어로 썼을 때는 모두 몇 개의 글자를 사용해야 할까요?
 * 참고: 빈 칸이나 하이픈('-')은 셈에서 제외하며, 단어 사이의 and 는 셈에 넣습니다.
 * 예를 들어 342를 영어로 쓰면 three hundred and forty-two 가 되어서 23 글자,
 * 115 = one hundred and fifteen 의 경우에는 20 글자가 됩니다.
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