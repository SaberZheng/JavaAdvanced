package ecut.threads;

/**
 * 实现 Runnable 的类 的实例 只能算作可执行对象，不属于线程
 */
public class SecondThread implements Runnable {

	@Override
	public void run() {
		System.out.println( Thread.currentThread() );
	}

}
