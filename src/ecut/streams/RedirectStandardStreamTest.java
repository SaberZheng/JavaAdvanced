package ecut.streams;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class RedirectStandardStreamTest {

	public static void main(String[] args) throws FileNotFoundException {
		
		// 将标准输入流的默认输出位置保存起来
		final PrintStream defaultOut = System.out ;
		// 创建一个可以向指定文件中输出内容的打印流
		PrintStream out = new PrintStream( "standard.txt" );
		// 这句将输出到控制台中
		System.out.println( "redirect...." ); 
		// 重定向 "标准" 输出流到指定的打印流
		System.setOut( out );
		// 这句将输出到指定的打印流中
		System.out.println( "hello , print stream ." ); 
		// 这句将输出到指定的打印流中
		System.out.println( "back..." ); 
		
		// 将 标准输出流 改回默认的输出位置
		System.setOut( defaultOut );
		// 这句将输出到控制台中
		System.out.println( "i am back." ); 

	}

}
