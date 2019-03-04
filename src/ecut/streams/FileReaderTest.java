package ecut.streams;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * FileReader 仅用来读取 文本文件 ( .txt 、.java 、.properties 之类的 )
 */
public class FileReaderTest {

	public static void main(String[] args) throws IOException {
		
		// FileReader 继承了 InputStreamReader ，因此它本身就具有 将字节转字符的能力
		// 但是，它只能根据当前平台的默认编码进行读取
		Reader reader = new FileReader( "JavaAdvanced.txt" );
		
		int n ;
		char[] chars = new char[100] ;
		while( ( n = reader.read( chars ) ) != -1 ){
			String s = new String( chars , 0 , n );
			System.out.print( s );
		}
		
		reader.close();

	}

}
