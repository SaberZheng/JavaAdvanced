package ecut.threads;

public class JoinThreadTest {

	public static void main(String[] args) {
		
		Runnable runnable1 = new JoinThread(); // 因为不知道要调用谁的 join 方法，所以不传参数
		
		Thread t1 = new Thread( runnable1 , "first" );
		t1.setPriority( Thread.MIN_PRIORITY );
		
		Runnable runnable2 = new JoinThread( t1 ); // 传入需要等待的线程 ( Thread )
		
		Thread t2 = new Thread( runnable2 , "second" );
		
		t2.start();
		
		t1.start();
		

	}

}
