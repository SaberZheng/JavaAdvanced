package ecut.threads;

public class JvmProcessTest {
	//JvmProcess虚拟机进程
	public static void main(String[] args) throws InterruptedException {
		
		Thread.sleep( 30000 );//以毫秒为单位

	}
	//每次运行一个带main 方法的程序的时候就会产生一个虚拟机进程产生，由它去解析字节码文件，然后给我们产生结果
	//Java多进程支持非常弱
}
