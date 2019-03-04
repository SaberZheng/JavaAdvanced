package ecut.threads;

/**
 * 家长
 */
public class Patriarch {

	private BocAccount account;

	public Patriarch(BocAccount account) {
		super();
		this.account = account;
	}

	public void deposit(double depositAmount) {
		
		synchronized ( account ) {
			try {
				if ( account.getMark() == BocAccount.Mark.RICH ) {
					System.out.println( Thread.currentThread().getName() + " : 卡上有钱，白跑一趟" );
					// 哪个正在执行的线程调用 同步锁 的 wait 将导致 该线程进入到 阻塞状态 ( 等待池 ( wait pool ) )
					// 该线程进入 等待池 时，同时 释放它所占有的 同步锁 ( 释放同步锁 )
					account.wait(); // 谁是同步锁，就调用谁的 wait 方法
				} else {
					System.out.println(Thread.currentThread().getName() + " - 存钱[" + depositAmount + "]");
					account.setBalance( account.getBalance() + depositAmount );
					System.out.println(Thread.currentThread().getName() + " - 余额[" + account.getBalance() + "]");
					account.setMark( BocAccount.Mark.RICH );
					System.out.println( Thread.currentThread().getName() + " - 又给臭小子把钱打过去了，我和老婆子这个月咋活呀" );
					// 调用 同步锁的 notifyAll 方法，将唤醒 正在等待 (目前处于 等待池 中) 该同步锁的 所有线程
					// 被唤醒的线程不是立即进入就绪状态，而是进入到 锁池 ( lock pool )
					account.notifyAll();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
