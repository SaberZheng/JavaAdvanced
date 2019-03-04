package ecut.threads;

import java.io.IOException;
import java.io.PipedReader;

public class PipedReaderThread implements Runnable {
	
	private PipedReader reader ;
	
	public PipedReaderThread(PipedReader reader) {
		super();
		this.reader = reader;
	}

	@Override
	public void run() {
		System.out.println( "读取到的数据:" );
		try {
			int ch ;
			while( ( ch = reader.read() ) != -1 ){
				char c = (char)ch ;
				System.out.print( c );
			}
		} catch (IOException e) {
			String message = e.getMessage();
			if( "write end dead" .equalsIgnoreCase( message ) ) {
				System.out.println();
				System.out.println( "发送数据的线程结束" );
			} else {
				e.printStackTrace();
			}
		}
		
	}

}
