package ecut.threads;

public class JoinThread implements Runnable {
	
	private Thread another ;
	
	public JoinThread() {
		super();
	}

	public JoinThread(Thread another) {
		super();
		this.another = another;
	}

	@Override
	public void run() {
		
		// 获得 当前线程 的引用
		Thread current = Thread.currentThread() ;
		
		for( int i = 0 ; i < 6 ; i++ ){
			System.out.println( i + " : " + current.getName() + " , " + current.getPriority() );
			if( i == 2 ){
				if( another != null ) {
					try {
						// 调用另外一个线程的 join 方法，让 那个线程 的 代码 执行完之后，当前线程才继续执行
						another.join();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
	}

}
