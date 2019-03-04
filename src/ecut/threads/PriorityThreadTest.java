package ecut.threads;

public class PriorityThreadTest {

	public static void main(String[] args) {
		
		// 创建一个 可以运行 的实例
		Runnable runnable = new PriorityThread();
		
		// 创建一个专门用来 执行 runnable 的 线程
		Thread t1 = new Thread( runnable , "first" );
		t1.setPriority( Thread.NORM_PRIORITY - 2 );
		t1.start();
		
		Thread t2 = new Thread( runnable , "second" );
		t2.setPriority( Thread.NORM_PRIORITY + 2 );
		t2.start();
		
		Thread t3 = new Thread( runnable , "third" );
		t3.start();
		
	}

}
