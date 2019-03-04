package ecut.streams;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class PrintWriterTest {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		
		PrintWriter pw = new PrintWriter( "pw.txt" , "UTF-8");
		
		pw.append( "hello , " );
		
		pw.println( " world " );
		
		pw.print( '!' );
		
		pw.close();

	}

}
