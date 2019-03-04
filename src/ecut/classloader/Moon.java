package ecut.classloader;

public class Moon {
	
	protected static Moon instance = new Moon() ;//链接(准备):null//初始化: a:1  b:1
	
	protected static int a = 100 ;//链接(准备):0//初始化: a:100
	protected static int b  ;//链接(准备):0//初始化: b:1
	
	public Moon() {
		a++ ;
		b++ ;
	}
	
}
