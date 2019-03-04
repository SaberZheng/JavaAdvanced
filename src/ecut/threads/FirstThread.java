package ecut.threads;

/**
 *  继承 Thread 类来实现自己的 线程，则需要 重写 run 方法
 */
public class FirstThread extends Thread {
	
	public FirstThread(){
		super( "first" ) ; // 调用父类 Thread 的 构造方法
	}
	
	public FirstThread( String name ){
		super( name ) ; // 调用父类 Thread 的 构造方法
	}

	@Override
	public void run() {
		
		for( int i = 0 ; i < 5 ; i++ ){
			System.out.print( i );
			System.out.print( " : " );
			//获得当前正在线程执行的引用，用Thread.currentThread()，不要用this，this返回的是当前的对象
			System.out.println( Thread.currentThread() );
		}
		
	}


}
