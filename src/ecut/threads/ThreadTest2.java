package ecut.threads;

/**
 * 应该怎样启动一个线程 ( 启动线程 跟 调用 线程实例的 run 方法的区别 )
 * 如果要创建并启动一个 自己的线程 ，需要继承 Thread 类并重写 run 方法
 */
public class ThreadTest2 {

	public static void main(String[] args) {
		
		Thread t = new FirstThread();
		
		// t.run(); // main 调用 t 所引用的实例的 run 方法，执行者是main这个线程,当前线程是main
		
		t.start();//调用start启动了t这个线程，让t里面的run方法去执行

	}
 
}
