package ecut.streams;

import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;

public class RandomAccessFileTest2 {

	public static void main(String[] args) throws IOException {
		
		PrintStream ps = new PrintStream( "mywtmpx.txt" );
		
		RandomAccessFile raf = new RandomAccessFile( "mywtmpx" ,  "r" ) ;
		
		final long size = raf.length() ;  // 获得文件大小
		final int unit = 372 ; // 指定每条记录所占的字节数
		final long n = size / unit ; // 计算总记录数
		System.out.println( "总记录数: " + n  );
		
		final byte[] nameBytes = new byte[32] ;
		final byte[] ipBytes = new byte[257] ;
		
		long start = System.currentTimeMillis() ; 
		
		for( long i = 0 ; i < n ; i++ ){
			raf.seek( i * unit );
			
			raf.read( nameBytes ) ; // 32
			String name = new String( nameBytes ).trim() ;
			ps.append( name );
			ps.append( " , " ) ;
			
			raf.seek( raf.getFilePointer() + 36 ) ; //raf.skipBytes( 36 );
			
			int pid = raf.readInt() ; // 4 
			ps.append( pid + "" );
			ps.append( " , " ) ;
			
			short type = raf.readShort() ; // 2 
			ps.append( type + "" );
			ps.append( " , " ) ;
			
			raf.seek( raf.getFilePointer() + 6 ) ; // 6
			
			int s = raf.readInt() ; // 4
			int ms = raf.readInt() ; // 4 
			
			long time = s * 1000L + ms ;
			ps.append( time + "" );
			ps.append( " , " ) ;
			
			raf.seek( raf.getFilePointer() + 26 ) ; // 26
			
			raf.read( ipBytes ) ;
			String ip = new String( ipBytes ).trim() ;
			ps.println( ip );
			
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println( "解析时间: " + ( end - start )  );
		
		
		raf.close();
		
		ps.close();
		
	}

}
