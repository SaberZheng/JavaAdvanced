package ecut.threads;

public class DaemonThread implements Runnable {
	
	public static void main(String[] args) throws InterruptedException {
		
		Runnable r = new DaemonThread();
		
		Thread t = new Thread( r , "daemon" );
		t.setDaemon( true ) ; // true 表示 将 该线程设置为 精灵线程 ( 守护线程 / 后台线程 )
		t.start();
		
		Thread.sleep( 1000 );
		
	}

	@Override
	public void run() {
		while( true ){
			System.out.println( "hello" );
		}
	}

}
