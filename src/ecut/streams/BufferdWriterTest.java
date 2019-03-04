package ecut.streams;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class BufferdWriterTest {

	public static void main(String[] args) throws IOException {
		
		Writer writer = new FileWriter( "writer.txt" );
		
		BufferedWriter bw = new BufferedWriter( writer );
		
		bw.write( "hello" );
		
		//bw.flush();
		
		bw.close();
		writer.close();

	}

}
