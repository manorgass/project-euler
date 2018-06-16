
public class DoIt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime, endTime, time;
		
		Problem_04 problem = new Problem_04();
		
		startTime = System.nanoTime();
		problem.solution();
		endTime = System.nanoTime();
		
		time = endTime - startTime;
		System.out.println("total time(ms): " + time / 1000000.0);
	}
}
