package ecut.classloader;

public class InitTest {
	public static void main(String[] args) {
	    //比如使用了 Child.hometown ，而 hometown是继承自 Father ，则只初始化 Father 类
		//System.out.println(Child.hometown);
		//初始化某个类时，如果该类有父类，那么父类将也被初始化
		//System.out.println(Child.name);
		//new Father();
		//new Father();
		new Child();
		new Child();
	}
}

class Father {
	protected static String hometown ;
	static{
		System.out.println( "Father : static code block." );
		hometown = "Sinaean" ;
	}//new Fater()时静态代码块最先执行，只执行一次
	
	{ System.out.println( "Father : non-static code block." );}//每一次new Fater()都执行，仅此静态代码块执行
	public Father(){
		System.out.println( "Father construction." );
	}//每一次new Fater()都执行，最后执行
}

class Child extends Father {
	protected static String name ;
	static{
		System.out.println( "Child : static code block." );
		name = "Child" ;
	}
	{ System.out.println( "Child : non-static code block." );}
	public Child(){
		System.out.println( "Child construction." );
	}
}
