package ecut.threads;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class PipedTest {

	public static void main(String[] args) throws IOException {
		
		PipedWriter writer = new PipedWriter();
		PipedReader reader = new PipedReader();
		
		writer.connect( reader );//连接两个流
		// reader.connect( writer );
		
		Runnable w = new PipedWriterThread(writer);
		Runnable r = new PipedReaderThread(reader);
		
		Thread wt = new Thread( w );
		wt.start();
		
		Thread rt = new Thread( r );
		rt.start();

	}

}
