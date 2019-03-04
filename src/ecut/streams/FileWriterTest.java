package ecut.streams;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileWriterTest {

	public static void main(String[] args) throws IOException {
		
		Writer w = new FileWriter( "file.txt" , true );//指定是否追加
		
		w.append( "hello" );
		
		w.write( "world." );
		
		w.write( '\n' );

		w.close();
		
	}

}
