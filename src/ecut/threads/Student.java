package ecut.threads;

/**
 * 表示学生
 */
public class Student {

	private BocAccount account;

	public Student(BocAccount account) {
		super();
		this.account = account;
	}

	public void draw(double drawAmount) {
		synchronized ( account ) {
			try {
				if (account.getMark() == BocAccount.Mark.NONE ) {
					System.out.println( Thread.currentThread().getName() + " : 卡上没钱，白跑一趟" );
					// this.wait(); // 注意，这里的 this 指的是 当前的 Student 对象 ( 此时它并不是同步锁 )
					account.wait(); // 谁是同步锁，就调用谁的 wait 方法
				} else {
					System.out.println(Thread.currentThread().getName() + " - 取钱[" + drawAmount + "]");
					account.setBalance( account.getBalance() - drawAmount );
					System.out.println(Thread.currentThread().getName() + " - 余额[" + account.getBalance() + "]");
					account.setMark( BocAccount.Mark.NONE );
					// this.notifyAll(); // 注意，这里的 this 指的是 当前的 Student 对象  ( 此时它并不是同步锁 )
					System.out.println( Thread.currentThread().getName() + " - 没钱了，这是吃土的节奏啊" );
					account.notifyAll(); // 谁是同步锁，就调用谁的 notifyAll 方法,通知其他线程可以打钱了
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
