package ecut.threads;

public class SleepThreadTest {

	public static void main(String[] args) {
		
		// 创建一个 可以运行 的实例
		Runnable runnable = new SleepThread();
		
		// 创建一个专门用来 执行 runnable 的 线程
		Thread t1 = new Thread( runnable , "first" );
		t1.setPriority( Thread.MIN_PRIORITY );
		t1.start();
		
		Thread t2 = new Thread( runnable , "second" );
		
		t2.start();
		
		Thread t3 = new Thread( runnable , "third" );
		t3.setPriority( Thread.MAX_PRIORITY );
		t3.start();
		
	}

}
