package ecut.streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class EncodingConverter {

	public static void main(String[] args) throws IOException {
		
		final File source = new File( "gbk.txt" );
		final String sourceEncoding = "GBK" ;
		
		InputStream in = new FileInputStream( source );
		InputStreamReader reader = new InputStreamReader( in , sourceEncoding ) ;
		
		final File dest = new File( "dest.txt" );
		final String destEncoding = "UTF-8" ;
		
		OutputStream out = new FileOutputStream( dest );
		OutputStreamWriter writer = new OutputStreamWriter( out ,  destEncoding );
		
		int n ;
		char[] chars = new char[ 100 ];
		while( ( n = reader.read( chars ) ) != -1 ){
			writer.write( chars ,  0 ,  n );
			writer.flush();
		}
		
		writer.close();
		out.close();
		
		reader.close();
		in.close();
		
	}

}
