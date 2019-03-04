package ecut.threads.synchronize;

public class CCBATM {

	public static void main(String[] args) {
		
		Account a = new Account( "郭靖" , 1000 );
		
		Runnable target1 = new DrawThread( a ,  800 );
		Thread t1 = new Thread( target1 , "郭靖" ) ;
		t1.start();
		
		Runnable target2 = new DrawThread( a ,  800 );
		Thread t2 = new Thread( target2 , "黄蓉" ) ;
		t2.start();
		
	}

}
