package ecut.threads;

public class PriorityThread implements Runnable {

	@Override
	public void run() {
		
		// 获得 当前线程 的引用
		Thread current = Thread.currentThread() ;
		
		for( int i  = 0 ; i < 5 ; i++ ){
			System.out.println( i + " : " + current.getName() + " , " + current.getPriority() );
		}
		
	}

}
