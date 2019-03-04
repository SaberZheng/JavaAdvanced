package ecut.threads.synchronize;

public class IcbcATM {

	public static void main(String[] args) {
		
		IcbcAccount ia = new IcbcAccount( "杨过" ,  1000 ) ;
		
		Runnable run1 = new IcbcDrawThread( ia , 800 );
		Thread t1 = new Thread( run1 , "杨过" );
		
		Runnable run2 = new IcbcDrawThread( ia , 800 );
		Thread t2 = new Thread( run2 , "龙姑娘" );
		
		t1.start();
		t2.start();
		
	}

}
