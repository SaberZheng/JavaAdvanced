package ecut.streams;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class OutputStreamWriterTest {

	public static void main(String[] args) throws IOException {
		
		// 创建一个可以输出到指定文件的 字节输出流
		OutputStream out = new FileOutputStream( "utf8.txt" );
		
		// 将 字符输出流 按照指定的 字符编码 转换成 字节输出流
		Writer w = new OutputStreamWriter( out , "UTF-8" );
		
		// 写出 字符串 中的字符，OutputStreamWriter 会将每个字符 根据指定的编码转换成字节序列
		w.write( "今天天气孬" );
		
		w.close();
		
		out.close();

	}

}
