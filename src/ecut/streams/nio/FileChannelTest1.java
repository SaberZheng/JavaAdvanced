package ecut.streams.nio;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileChannelTest1 {

	 

	public static void main(String[] args) throws IOException {
		
		PrintStream ps = new PrintStream( "m.txt" );
		
		// 获得指定名称的文件对应的 Path 实例
		Path path = Paths.get( "mywtmpx" );
		
		// 如果指定 path 存在并且是一个文件
		if( Files.exists( path ) && Files.isRegularFile( path ) ){
			// 用只读方式 打开到 path 的通道
			SeekableByteChannel channel = Files.newByteChannel( path , StandardOpenOption.READ );
			// 判断 channel 是否是一个 FileChannel 
			if( channel instanceof FileChannel ){
				// 如果是，就强制类型转换
				FileChannel fileChannel = (FileChannel) channel ;
				
				final ByteBuffer buffer = ByteBuffer.allocate( 37200000 ) ;
				final int unit = 372 ;
				
				final byte[] nameBytes = new byte[32] ;
				final byte[] ipBytes = new byte[257] ;
				// 通道并不能直接读取数据，通道的作用是 将 文件中的 部分 或 全部 数据 "映射" 到 缓冲区
				int n ;
				while( ( n = fileChannel.read( buffer )  ) != -1 ) {
					buffer.flip(); // "锁定" 缓冲区
					
					int x = n / unit ; // 计算本次读取到的 记录数 
					
					for( int i = 0 ; i < x ; i++ ){
						// 参考 RandomAccessFileTest2 中的代码，补充这个循环
						buffer.position( i * unit );
						
						buffer.get(nameBytes);
						String name = new String( nameBytes ).trim() ;
						ps.append( name );
						ps.append( " , " ) ;
						
						buffer.position(buffer.position()+36);
						
						int pid = buffer.getInt() ; // 4 
						ps.append( pid + "" );
						ps.append( " , " ) ;
						
						short type = buffer.getShort() ; // 2 
						ps.append( type + "" );
						ps.append( " , " ) ;
						
						buffer.position( buffer.position() + 6 ) ; // 6
						
						int s = buffer.getInt() ; // 4
						int ms = buffer.getInt() ; // 4 
						
						long time = s * 1000L + ms ;
						ps.append( time + "" );
						ps.append( " , " ) ;
						
						buffer.position( buffer.position() + 26 ) ; // 26
						
						buffer.get( ipBytes ) ;
						String ip = new String( ipBytes ).trim() ;
						ps.println( ip );	
						}
					buffer.clear(); // "释放" 缓冲区，以便于下次 从通道中 "提取"
				}
				
			}
		}
		ps.close(); // 关闭打印流
	}

}
