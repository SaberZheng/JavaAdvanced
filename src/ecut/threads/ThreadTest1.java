package ecut.threads;

public class ThreadTest1 {

	public static void main(String[] args) {
		
		// 获得当前线程的引用   [当前线程名称,当前线程的优先级,当前线程所在线程组的名称]
		System.out.println( Thread.currentThread() );
		
		// 创建一个 Thread 类的实例 就是 创建一个线程
		Thread t = new Thread();
		// 通过 Thread 类的 start 方法来启动线程
		t.start();

	}

}
