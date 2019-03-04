package ecut.threads;

public class PatriarchDepositThread extends Thread {
	
	private Patriarch patriarch ;
	private double depositAmount ;
	
	public PatriarchDepositThread(Patriarch patriarch , double depositAmount , String threadName) {
		super( threadName );
		this.patriarch = patriarch;
		this.depositAmount = depositAmount ;
	}

	@Override
	public void run() {
		for( int i = 0 ; i < 2 ; i++ ){
			patriarch.deposit(depositAmount);
		}
	}

}
