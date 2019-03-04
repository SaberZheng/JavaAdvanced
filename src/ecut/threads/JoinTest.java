package ecut.threads;

public class JoinTest {

	public static void main(String[] args) throws InterruptedException {
		
		Thread main = Thread.currentThread() ; // 获得 当前线程 的引用
		
		Join jt = new Join();
		jt.start();
		
		for( int i = 0 ; i < 6 ; i++ ){
			System.out.println( i + " : " + main.getName() + " , " + main.getPriority() );
			if( i == 0 ) {
				jt.join(); // main 线程 将 等待 jt 这个线程 执行结束后，自己再执行
			}
		}
		
	}
	
	public static class Join extends Thread {
		public Join(){
			super( "join" ) ;
		}
		@Override
		public void run() {
			// 获得 当前线程 的引用
			Thread current = Thread.currentThread() ;
			for( int i = 0 ; i < 6 ; i++ ){
				System.out.println( i + " : " + current.getName() + " , " + current.getPriority() );
			}
		}
	}

}
