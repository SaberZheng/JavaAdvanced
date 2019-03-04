package ecut.threads;

public class Thunder {
	
	public static void main(String[] args) {
		
		Thunder t = new Thunder(); // t.finish --> false
		
		Runnable down = new ThunderDownloadThread( t );
		Thread dt = new Thread( down ) ;
		dt.start();
		
		Runnable store = new ThunderStoreThread( t );
		Thread st = new Thread( store ) ;
		st.start();
		
	}
	
	// 声明一个属性，用来表示 "下载" 是否完成
	protected  boolean finish = false ;

}
