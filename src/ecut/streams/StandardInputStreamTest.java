package ecut.streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class StandardInputStreamTest {

	public static void main(String[] args) throws IOException {
		
		InputStream in = System.in ;// 标准输入流 ( 默认是读取 键盘输入 )
		/*Scanner s = new Scanner(in);
		String str;
		while((str = s.nextLine())!=null){
			System.out.print(str);
		}
		s.close();*/
		// 将 字节输入流 包装成 字符输入流
		InputStreamReader reader = new InputStreamReader( in );
		
		// 将 "字符输入流" 包装成 "带有缓冲功能的字符输入流"
		BufferedReader br = new BufferedReader( reader );
		
		String s ;
		System.out.println( "请输入数据: " );
		while( ( s = br.readLine() ) != null ) {
			System.out.println( "你输入的是: " + s );
			System.out.println( "请输入数据: " );
		}

		br.close();
		reader.close();
		in.close();
	}

}
