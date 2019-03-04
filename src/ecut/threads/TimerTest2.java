package ecut.threads;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest2 {
	
	private static Calendar calendar = Calendar.getInstance();
	
	static {
		calendar.set( Calendar.MILLISECOND ,  0 );
	}

	public static void main(String[] args) {
		
		final Timer t = new Timer();
		
		//int n = 0 ;//jdk1.7 匿名内部类访问外部类的局部变量时，必须用final修饰，jdk1.8默认有final修饰
		
		TimerTask task = new TimerTask() {
			
			int n = 0 ;
			
			@Override
			public void run() {
				System.out.println( n + " : " + System.currentTimeMillis() );
				if( n >= 10 ){
					t.cancel();
				} else {
					n++ ;
				}
			}
			
		} ;
		
		calendar.set( 2018 , 2 , 17, 14, 38, 15 );
		
		Date time = calendar.getTime() ;
		
		long period = 200 ;//每隔200ms执行一次
		
		t.schedule( task , time , period );

	}

}
