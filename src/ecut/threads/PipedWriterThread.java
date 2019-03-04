package ecut.threads;

import java.io.IOException;
import java.io.PipedWriter;

public class PipedWriterThread implements Runnable {
	
	private PipedWriter writer ;
	
	public PipedWriterThread(PipedWriter writer) {
		super();
		this.writer = writer;
	}

	@Override
	public void run() {
		try {
			writer.write( "hello , i am PipedWriterThread ." );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
