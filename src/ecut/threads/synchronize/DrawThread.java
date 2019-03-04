package ecut.threads.synchronize;

public class DrawThread implements Runnable {
	
	private Account account ;
	private double money ;
	
	public DrawThread( Account account , double money ) {
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
		
		/*Thread current = Thread.currentThread();
		String name = current.getName() ;
		
		synchronized ( account ) {
			System.out.println( name + " : 取款之前，您账户上的余额是: [ " + account.getBalance() + " ]" );
			
			// 判断 账户上的 余额 是否 大于 交易金额
			if( account.getBalance() > money ){
				
				System.out.println(  name + " : 您本次的取款金额是 : [ " + money + " ]" );
				System.out.println(  name + " : 请收好您的钞票: " + money );
				
				Thread.yield();
				
				double newBalance = account.getBalance() - money ; // 让原来的 余额 减去 本次交易金额
				account.setBalance( newBalance ); // 将交易后的金额 重新设置到 account 的 balance 属性上
				
				System.out.println(  name + " : 取款之后，您账户上的余额是: [ " + account.getBalance() + " ]" );
			} else {
				System.out.println(  name + " : 余额不足，无法交易" );
			}
		} // 同步代码块
*/		
		account.draw( money );
	}

}
