package ecut.streams.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

public class CharsetTest1 {

	public static void main(String[] args) {
		
		// Java 语言中默认采用 UNICODE 来表示 字符
		char ch = '东' ; // 2 字节
		
		Charset cs = Charset.defaultCharset() ; // 获得 默认的 字符编码 对应的 Charset 对象
		System.out.println( "当前编码: " + cs.displayName()  );
		
		// 将 字符串 按照 当前的字符编码集 来【编码】成相应的 字节序列
		ByteBuffer buffer = cs.encode( ch + "" );
		
		byte[] bytes = buffer.array();
		
		System.out.println(  Arrays.toString( bytes ) );
		
		System.out.println( "~~~~~~~~~~~~~~~~~~~~~~" );
		
		// 将 指定的字节序列(字节缓冲区) 按照 当前的字符编码集 【解码】成 字符 ( 字符缓冲区 )
		CharBuffer charBuffer = cs.decode( buffer );
		System.out.println( charBuffer );

	}

}
