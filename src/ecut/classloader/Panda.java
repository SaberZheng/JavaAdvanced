package ecut.classloader;

public class Panda {
	
	// 编译时常量(对于final 修饰的变量，如果编译时就能确定其取值，即被看作编译时常量)
	public static final String HOMETOWN = "中国" ;
	
	// 非编译时常量(对于final 修饰的变量，如果编译时就不能确定其取值，则不被看作编译时常量)
	public static final long time = System.currentTimeMillis();

	public static int a ;
	
	static {
		System.out.println( "static code , a = " + a  );
		 a = 100 ;
		 System.out.println( "static code , a = " + a  );
	}
}
