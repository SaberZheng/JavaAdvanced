package ecut.streams;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;

public class LineNumberReaderTest {

	public static void main(String[] args) throws IOException{
		
		Reader reader = new FileReader( "./src/ecut/streams/LineNumberReaderTest.java" )  ;
		
		LineNumberReader br = new LineNumberReader( reader );
		
		String s ; 
		// 每次读取一行内容 ( 遇到换行符即停止 )
		while( ( s = br.readLine() ) != null ) {
			System.out.println( br.getLineNumber() + " : " + s );
		}
		
		br.close();
		
		reader.close();

	}

}
