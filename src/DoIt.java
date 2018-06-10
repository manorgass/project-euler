
public class DoIt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime, endTime, time;
		Problem_02 p1 = new Problem_02();
		startTime = System.nanoTime();
		p1.solution();
		endTime = System.nanoTime();
		time = endTime - startTime;
		System.out.println("total time(ms): " + time/1000000.0);
	}
}
