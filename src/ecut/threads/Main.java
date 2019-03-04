package ecut.threads;

public class Main {

	public static void main(String[] args) {
		
		// 创建一个 账号对象，它充当竞争资源 ( 同步锁 、对象监视器 )
		final BocAccount account = new BocAccount( "家长" , 1000 );
		
		// 创建一个 学生类型的对象 ，充当消费者
		Student s = new Student( account );
		// 创建一个 家长类型的对象，充当生产者
		Patriarch p = new Patriarch( account );
		
		// 哪个学生要取多少钱
		StudentDrawThread st = new StudentDrawThread( s , 1000 , "学生" );
		st.start();
		
		// 哪位家长要存多少钱
		PatriarchDepositThread pt = new PatriarchDepositThread( p , 1000 , "家长" );
		pt.start();
		

	}

}
