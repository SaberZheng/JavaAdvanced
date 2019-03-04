package ecut.streams;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * markSupported() 、mark( readlimit ) 、reset()
 */
public class BufferedInputStreamTest2 {

	public static void main(String[] args) throws IOException {
		
		InputStream in = new FileInputStream( "./src/ecut/streams/BufferedInputStreamTest2.java" );
		
		// BufferedInputStream 内部有一个 默认 容量是 8192 字节数组 用来缓存 读取到的内容
		BufferedInputStream bis = new BufferedInputStream( in );
		
		int b ;
		while( ( b = bis.read( ) ) != -1 ) {
			char ch = (char) b ;
			System.out.print( ch );
			if( ch == 'w'){
				 //在此输入流中标记当前的位置。
				bis.mark( 24250 ); // 在 当前位置处留下标记 ( markpos = pos ; )readlimit意义不大，注意clean flip rewind 三个方法。
			}
		}
		
		System.out.println( "\n~~~~~~~~~~~~~~~~~~~~~~~~" );
		 //将此流重新定位到最后一次对此输入流调用 mark 方法时的位置
		bis.reset(); // 回到 做标记的位置
		
		while( ( b = bis.read( ) ) != -1 ) {
			char ch = (char) b ;
			System.out.print( ch );
		}
		
		bis.close();
		in.close();
		

	}

}
