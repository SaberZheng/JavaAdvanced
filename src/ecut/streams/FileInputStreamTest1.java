package ecut.streams;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStreamTest1 {

	public static void main(String[] args) throws IOException {
		// 创建一个用来读取JavaAdvanced.txt文件的输入流
		InputStream in = new FileInputStream( "JavaAdvanced.txt" );//需要抛出FileNotFoundException
		// 声明一个变量用来记录读取到的单个字节
		int b ;
		// 每循环以次读取一个字节，并将读取到的字节赋值给 变量 n ，当到达流末尾时返回-1。
		//read()需要抛出IOException，IOException是FileNotFoundException的父类。 
		while( ( b = in.read() ) != -1 ) {			
			//(char)b将读取到的字节转换成字符类型，以便于在控制台中输出后查看
			char c = (char) b ;
			// 将每个字节对应的字符输出到控制台上(文件中的换行符号会当作换行处理，因此输出时不需要带换行)
			System.out.print(c );//中文可能会乱码
		}
		
		in.close();
	}

}
