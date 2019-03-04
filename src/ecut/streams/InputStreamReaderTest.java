package ecut.streams;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class InputStreamReaderTest {

	public static void main(String[] args) throws IOException {
		
		// 创建一个读取指定文件的 字节输入流 
		InputStream in = new FileInputStream( "JavaAdvanced.txt" );
		// 一个字节字节的图会出现乱码现象
		/*
		int n ;
		byte[] bytes = new byte[ 32 ];
		while( ( n = in.read( bytes ) ) != -1 ){
			String s = new String( bytes , 0 , n ) ;
			System.out.print( s );
		}*/
		
		// 将 字节输入流  包装成 字符输入流
		Reader reader = new  InputStreamReader( in , "UTF-8" );//实现AutoCloseable（1.7出现的）

		
		/*
		int ch ;
		while( ( ch = reader.read() ) != -1 ){
			char c = (char) ch ;
			System.out.print( c );
		}*/
		int n ;
		char[] chars = new char[100] ;
		while( ( n = reader.read( chars ) ) != -1 ){
			String s = new String( chars , 0 , n );
			System.out.print( s );
		}
		
		
		in.close();
		
	}

}
