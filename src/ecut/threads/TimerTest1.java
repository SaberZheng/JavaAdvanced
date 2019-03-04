package ecut.threads;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest1 {
	
	private static Calendar calendar = Calendar.getInstance();
	//静态代码块，在虚拟机加载类的时候就会加载执行，而且只执行一次；
	//非静态代码块，在创建对象的时候（即new一个对象的时候）执行，每次创建对象都会执行一次
	static {
		calendar.set( Calendar.MILLISECOND ,  0 );
	}

	public static void main(String[] args) {
		
		Timer t = new Timer();
		
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				System.out.println( calendar.get( Calendar.MINUTE ) + ":" + calendar.get( Calendar.SECOND) );
				t.cancel();
			}
		} ;
		
		calendar.set( 2018 , 2 , 17, 14, 13, 00 );//14:13执行定时任务
		
		Date time = calendar.getTime() ;
		
		t.schedule( task , time );
	}

}
