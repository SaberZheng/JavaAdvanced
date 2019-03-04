package ecut.threads;

public class YeildThreadTest {

	public static void main(String[] args) {
		
		Runnable runnable = new  YeildThread();
		
		Thread t1 = new Thread( runnable , "first" );
		t1.setPriority( Thread.MIN_PRIORITY );
		t1.start();
		
		Thread t2 = new Thread( runnable , "second" );
		t2.setPriority( Thread.MIN_PRIORITY + 2 );
		t2.start();
		
		Thread t3 = new Thread( runnable , "third" );
		t3.setPriority( Thread.NORM_PRIORITY );
		t3.start();
		
		Thread t4 = new Thread( runnable , "forth" );
		t4.setPriority( Thread.MAX_PRIORITY );
		t4.start();
		
	}

}
