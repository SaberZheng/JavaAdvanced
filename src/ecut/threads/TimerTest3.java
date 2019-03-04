package ecut.threads;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest3 {
	
	private static Calendar calendar = Calendar.getInstance();
	
	static {
		calendar.set( Calendar.MILLISECOND ,  0 );
	}

	public static void main(String[] args) {
		
		final Timer t = new Timer();
		
		calendar.set( 2018 , 2 , 17, 14, 43, 40 );
		Date time = calendar.getTime() ;
		
		TimerTask task1 = new TimerTask() {
			@Override
			public void run() {
				System.out.println( "播放音乐" );
			}
		};
		
		t.schedule( task1 , time , 1000 );
		
		TimerTask task2 = new TimerTask() {
			@Override
			public void run() {
				System.out.println( "震动起来" );
				//震动一次就取消掉
				this.cancel(); // 取消当前的定时任务
				t.purge(); // 从 定时器中移除已经取消的定时任务
			}
		};
		
		t.schedule( task2 , time , 1000 );

	}

}
