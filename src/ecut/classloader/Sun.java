package ecut.classloader;

public class Sun {
	
	protected static int a = 100 ;//链接(准备):0//初始化: a:100
	protected static int b  ;//链接(准备):0//初始化: b:0
	
	protected static Sun instance = new Sun() ;//链接(准备):null//初始化: a:101  b:1	
	
	public Sun() {
		a++ ;
		b++ ;
	}
	
}
