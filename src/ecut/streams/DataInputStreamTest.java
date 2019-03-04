package ecut.streams;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DataInputStreamTest {

	public static void main(String[] args) throws IOException {
		InputStream in = new FileInputStream( "binary.data" );
		DataInputStream dis = new DataInputStream( in );
		
		final int size = dis.available();
		final int unit = 35 ;
		
		final int n = size / unit ;
		
		// final byte b = 0 ;
		final byte[] nameBytes = new byte[32] ;
		
		for( int i = 0 ; i < n ; i++ ){
		
			dis.read( nameBytes ); // 读取 32 个字节到 数组中
			
			String name = new String( nameBytes );
			System.out.println( name.trim() );
			
			char gender = dis.readChar(); // 读取 2 个字节构造成 char 类型
			System.out.println( gender );
			
			boolean married = dis.readBoolean() ; // 读取 1 个字节 构造成 booolean 类型数值
			System.out.println( married );
			
		}
		
		dis.close();
		in.close();
	}

}
