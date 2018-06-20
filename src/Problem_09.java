
public class Problem_09 {
	void solution() {
		int a, b, c;
		// number a increase roof
		for (a = 1; a < 1000 / 3; a++) {
			// number b increase roof
			for (b = a + 1; b < (1000 - a) / 2; b++) {
				c = 1000 - a - b;
				if ((a * a) + (b * b) == (c * c)) {
					System.out.println(a * b * c);
					return;
				}
			}
		}
	}
}
