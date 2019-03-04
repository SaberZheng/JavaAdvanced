package ecut.threads;

/**
 * 模拟下载过程的 线程
 */
public class ThunderDownloadThread implements Runnable {
	
	private Thunder thunder ;
	
	public ThunderDownloadThread(Thunder thunder) {
		super();
		if( thunder == null ){
			throw new NullPointerException( "必须指定一个 Thunder 实例 ( 对象 )" );
		}
		this.thunder = thunder;
	}
	
	@Override
	public void run() {
		
		for( int i = 0 ; i < 1024 ; i++ ){
			System.out.println( "正在下载:"  + i );
		}
		
		thunder.finish = true ;
		
	}

}
