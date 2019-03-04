package ecut.threads;

/***
 * 模拟保存数据到本次磁盘的线程
 */
public class ThunderStoreThread implements Runnable {
	
	private Thunder thunder ;
	
	public ThunderStoreThread(Thunder thunder) {
		super();
		if( thunder == null ){
			throw new NullPointerException( "必须指定一个 Thunder 实例 ( 对象 )" );
		}
		this.thunder = thunder;
	}

	@Override
	public void run() {
		
		while( true ){
			if( thunder.finish ) {
				System.out.println( "保存到磁盘" );
				break ;
			}
		}
		
	}

}
