package ecut.threads.synchronize;

public class IcbcDrawThread implements Runnable {
	
	private IcbcAccount account ;
	private double money ;
	
	public IcbcDrawThread( IcbcAccount account , double money ) {
		super();
		if( account == null ){ // 如果 account 为 null 
			throw new RuntimeException( "账号不能为空" );
		}
		this.account = account;
		
		if( money <= 0 ){
			throw new RuntimeException( "交易金额必须大于 0" );
		}
		this.money = money ;
	}


	@Override
	public void run() {
		
		// 调用同步方法 ,对于 同步方法 draw 来说 当前的对象 ( account ) 就是 同步锁
		account.draw( money );
		
	}

}
