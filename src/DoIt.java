
public class DoIt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime, endTime, time;
		
		Problem_10 problem = new Problem_10();
		
		startTime = System.nanoTime();
		problem.solution();
		endTime = System.nanoTime();
		
		time = endTime - startTime;
		System.out.println("total time(ms): " + time / 1000000.0);
	}
}
