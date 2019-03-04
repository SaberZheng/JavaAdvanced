package ecut.threads.synchronize;

public class IcbcAccount {

	private String id; /* 当前账户的编号 */
	private double balance; /* 账户余额 */

	public IcbcAccount(String id, double balance) {
		super();
		this.id = id;
		this.balance = balance;
	}
	
	public synchronized void draw( double money ) {
		Thread current = Thread.currentThread();
		String name = current.getName() ;
		System.out.println( name + " : 取款之前，您账户上的余额是: [ " + balance + " ]" );
		
		// 判断 账户上的 余额 是否 大于 交易金额
		if( balance > money ){
			
			System.out.println(  name + " : 您本次的取款金额是 : [ " + money + " ]" );
			System.out.println(  name + " : 请收好您的钞票: " + money );
			
			Thread.yield();
			
			double newBalance = balance - money ; // 让原来的 余额 减去 本次交易金额
			this.balance = newBalance ; // 将交易后的金额 重新设置到 account 的 balance 属性上
			
			System.out.println(  name + " : 取款之后，您账户上的余额是: [ " + balance + " ]" );
		} else {
			System.out.println(  name + " : 余额不足，无法交易" );
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
