package ecut.streams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 因为 BufferedReader 有缓冲区，因此支持 mark 和 reset 操作
 * 注意自己指定 缓冲区 大小
 */
public class BufferedReaderTest {

	public static void main(String[] args) throws IOException {
		// 创建一个可以读取指定文件内容的字符输入流
		Reader reader = new FileReader( "./src/ecut/streams/BufferedReaderTest.java" )  ;
		// 将指定的字符输入流包装成 字符缓冲输入流
		BufferedReader br = new BufferedReader( reader );
		
		/*
		int ch ;
		// 每次读取一个字符，连换行符 ( \n 或 10 ) 也要读取
		while( ( ch = br.read() ) != -1 ){
			System.out.print( (char) ch );
		}*/
		// 声明一个变量用来接收从缓冲输入流中读取到的字符串
		String s ; 
		// 从字符缓冲输入流中读取一行数据( 遇到换行符即停止)，当到达流末尾时返回 null
		while( ( s = br.readLine() ) != null ) {
			// 将读取到的字符串输出到控制台
			System.out.println( s );
		}
		
		br.close();
		
		reader.close();
		
	}

}
