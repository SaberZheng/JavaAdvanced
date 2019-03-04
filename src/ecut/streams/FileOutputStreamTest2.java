package ecut.streams;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutputStreamTest2 {

	public static void main(String[] args) throws IOException {
		// 创建文件输出流
		OutputStream out = new FileOutputStream( "abc.txt" );
		// 声明一个字符串，这个字符串中的内容将被输出到指定文件中
		String s = "今天好热，热死了" ;  
		System.out.println( s.length() );//8
		//byte[] bytes = s.getBytes("GBK"); //16
		// 根据平台默认字符集将给定的字符串编码为 byte 序列(一个byte数组)
		byte[] bytes = s.getBytes(); //24
		System.out.println( bytes.length );
		// 将 bytes 数组中的 [ 0 , 0 + 15 ) 之间的字节写出   今天好热，
		out.write( bytes , 0 , 15 ); 
		out.close();// 关闭文件输出流
		
	}

}
