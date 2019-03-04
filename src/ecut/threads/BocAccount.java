package ecut.threads;

/**
 * BOC : Bank of China
 */
public class BocAccount {

	/* 定义一个枚举，用来表示 账户上有钱还是没钱 */
	public static enum Mark { 
		RICH("有钱") , NONE("没钱") ;

		private String value;

		private Mark(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	private String id; /* 当前账户的编号 */
	private double balance; /* 账户余额 */
	private Mark mark = Mark.NONE; // 代表是否有钱的标记: 有- 帐号上有钱, 无- 帐号上没有钱
	
	public BocAccount(String id, double balance) {
		super();
		this.id = id;
		if( balance > 0 ) {
			this.balance = balance ;
			mark = Mark.RICH ;
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

	public Mark getMark() {
		return mark;
	}

	public void setMark(Mark mark) {
		this.mark = mark;
	}

}
