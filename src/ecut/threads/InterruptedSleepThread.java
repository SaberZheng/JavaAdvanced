package ecut.threads;

public class InterruptedSleepThread implements Runnable{

	public static void main(String[] args) {
		
		Runnable runnable = new InterruptedSleepThread() ; 
		
		Thread t = new Thread( runnable , "interrupted" );
		
		t.start();
		
		t.interrupt(); // 中断 阻塞状态 ( 可能是中断睡眠 )
		
	}

	@Override
	public void run() {
		
		try {
			Thread.sleep( 3000 );
			System.out.println( "好好睡觉，天天向上" );
		} catch (InterruptedException e) {
			System.err.println( "居然敢打扰老子睡觉..." );
			e.printStackTrace();
		}
		
	}

}
