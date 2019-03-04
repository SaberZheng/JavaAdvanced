package ecut.streams;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutputStreamTest1 {

	public static void main(String[] args) throws IOException {
		
		OutputStream out = new FileOutputStream( "abc.txt" );//默认创建到在当前工程底下
		//eclipse环境下所有的当前路径除了java.lang.Class 类的 getResourceAsStream 方法是类路径底下都是当前工程底下
		
		for( int i = 'A' ; i<= 'Z' ; i++ ){
			out.write( i );//写出的是字节，打开的时候eclipse文本工具将字节转换成了字符文件的
		}
		
		out.close();
		
	}

}
