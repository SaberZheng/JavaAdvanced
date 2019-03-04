package ecut.classloader;

public class PandaTest {

	public static void main(String[] args) {
		
		System.out.println( Panda.HOMETOWN ); // 编译时常量被动使用
		
		//System.out.println( Panda.a ); // 访问静态变量(不是常量) 主动使用
		//使用该类型的静态变量将导致当前类被初始化( 主动使用)
		System.out.println( Panda.time );//非编译时常量主动使用，静态代码块只执行一次因为初始化操作只执行一次
		
		System.out.println( Panda.time );//只有第一次使用才完成初始化操作，所以值是固定的不变的

	}

}
