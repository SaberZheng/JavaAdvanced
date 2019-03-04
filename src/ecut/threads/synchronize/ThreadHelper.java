package ecut.threads.synchronize;

public final class ThreadHelper {
	
	public static void create( Runnable target , String name ) {
		
		Thread t = new Thread( target , name ) ;
		
		t.start();
		
	}

}
