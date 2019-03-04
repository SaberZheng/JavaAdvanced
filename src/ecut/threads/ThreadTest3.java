package ecut.threads;

/**
 * 通过 创建一个 Thread 实例 ，来执行 Runnable 实例的 run 方法
 */
public class ThreadTest3 {

	public static void main(String[] args) {
		
		// 创建一个 可运行的对象 ( 它不是线程 )
		Runnable runnable = new SecondThread();
		
		// runnable.run();//main线程调 Runnable 所引用的实例的 run 方法，执行者是main这个线程,当前线程是main
		
		// 对于 Runnable 类型的 实例，需要用 另外的一个 Thread 来启动它
		Thread t = new Thread( runnable  , "second");
		
		t.start(); // 启动 线程 t ，将调用 t 内部的 run 方法，而 t 内部的 run 将调用 runnable 的 run 方法
		

	}

}
