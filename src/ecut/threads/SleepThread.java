package ecut.threads;

public class SleepThread implements Runnable {

	@Override
	public void run() {
		
		// 获得 当前线程 的引用
		Thread current = Thread.currentThread() ;
		
		for( int i  = 0 ; i < 5 ; i++ ){
			System.out.println( i + " : " + current.getName() + " , " + current.getPriority() );
			try{
				Thread.sleep( 1 ); // 睡眠的时间单位是毫秒，1毫秒足够有时间让别的线程抢占cpu
			} catch ( InterruptedException e ) {
				//InterruptedException不能抛出，因为父类没有抛出异常，每次try catch 都会创建一个异常追踪的堆栈，消耗内存和空间效率低。
				System.out.println( "居然敢打扰老子睡觉..." );
			}
		}
		
	}

}
