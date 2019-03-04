package ecut.streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFile {

	public static void main(String[] args) throws IOException {
		
		InputStream in = new FileInputStream( "D:/Amy/Java2/teacher/408/408pm/JavaAdvancedTutorial_01_Files_and_Streams.pdf" );
		OutputStream out = new FileOutputStream( "JavaAdvancedTutorial_01_Files_and_Streams.pdf") ;
		
		long start = System.currentTimeMillis() ; // 程序执行到 当前行对应的时间 (毫秒)
		
		int n ;
		final byte[] bytes = new byte[ 1 << 20 ]; // 1024 : 1 < 10 ; 反复利用缓冲区
		while( ( n = in.read(bytes) ) != -1  ){
			out.write( bytes ,  0 ,  n );
		}
		
		long end = System.currentTimeMillis() ; // 程序执行到 当前行对应的时间 (毫秒)
		
		long duration = end - start ; 
		
		System.out.println( "复制文件用时: " + duration + "ms." );
		
		out.close();//后开的先关
		in.close();//先开的后关
		
	}

}
