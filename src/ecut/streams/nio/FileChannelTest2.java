package ecut.streams.nio;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileChannelTest2 {

	public static void main(String[] args) throws IOException {
		
		PrintStream ps = new PrintStream( "my.txt" );
		
		// 如果没有指定明确的绝对路径，则从 当前路径读取
		// 在 Eclipse 环境下普通 Java 工程中，默认的当前路径是 当前工程
		Path path = Paths.get( "mywtmpx" );
		
		// 接口类型的 引用变量 引用了 实现类类型的 一个 实例
		SeekableByteChannel channel = Files.newByteChannel( path );
		
		// 判断 channel 变量在运行期 所引用的那个实例 是否是 FileChannel 类型
		if( channel instanceof FileChannel ){
			FileChannel fc = (FileChannel) channel ;//fc和channel地址相同
			final long size = fc.size() ; // 获得 通道对应的 文件的 大小
			final int unit = 372 ;
			final long n = size / unit ;
			
			MappedByteBuffer buffer = fc.map( FileChannel.MapMode.READ_ONLY, 0 , size );//把数据映射到内存缓冲区，直接对文件的映射
			
			final byte[] nameBytes = new byte[32] ;
			final byte[] ipBytes = new byte[257] ;
			
			for( long i = 0 ; i < n ; i++ ) {
				
				buffer.get(nameBytes); // 32
				String name = new String( nameBytes ).trim() ;
				ps.append( name );
				ps.append( " , " ) ;
				
				buffer.position( buffer.position() + 36 ); //raf.skipBytes( 36 );
				
				int pid = buffer.getInt() ; // 4 
				ps.append( pid + "" );
				ps.append( " , " ) ;
				
				short type = buffer.getShort() ; // 2 
				ps.append( type + "" );
				ps.append( " , " ) ;
				
				buffer.position( buffer.position() + 6 );  // 6
				
				int s = buffer.getInt() ; // 4
				int ms = buffer.getInt() ; // 4 
				
				long time = s * 1000L + ms ;
				ps.append( time + "" );
				ps.append( " , " ) ;
				
				buffer.position( buffer.position() + 26 ); // 26
				
				buffer.get( ipBytes ) ;
				String ip = new String( ipBytes ).trim() ;
				ps.println( ip );
				
				buffer.get();
				
			}
			
			buffer = null ; // 让 buffer 本来引用 的那个 缓冲区 实例 不再被引用
			
			System.gc();//垃圾收集器运行。
			
			fc.close(); // 关闭通道
			
		}
		
		ps.close(); // 关闭打印流
		
	}

}
