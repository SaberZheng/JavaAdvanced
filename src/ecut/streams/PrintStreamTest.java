package ecut.streams;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
//过滤流
public class PrintStreamTest {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		
		PrintStream ps = new PrintStream( "print.txt" , "UTF-8" );//UnsupportedEncodingException
		
		ps.println( true );
		
		ps.print( 'A' );
		
		ps.println( "Z" ) ;
		
		ps.append( '东' );
		
		ps.append( "华理工" );//实现了Appendable接口CharSequence
		
		ps.println();
		
		ps.close();
		
	}

}
