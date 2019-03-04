package ecut.streams.nio;

import java.nio.ByteBuffer;

public class ByteBufferTest {

	public static void main(String[] args) {
		
		ByteBuffer buffer = ByteBuffer.allocate( 1024 );
		
		System.out.println( buffer );
		
		buffer.putInt( 100 ); // 将 int 数值 放入到 字节缓冲区中，并占用 4 个字节
		
		System.out.println( buffer );
		
		buffer.putChar( 'A' ) ; // 2 个字节
		
		System.out.println( buffer );
		
		/*int x = buffer.getInt();
		
		System.out.println( x );//输出0，pos=6然后 getInt 往后移动4个位置因此pos=10  x为0*/	
	
		/*int x = buffer.getInt(0);
		
		System.out.println( x );//输出100，绝对的get从开始位置获取int post不变*/
		
		buffer.flip();
		
		int x = buffer.getInt();
		
		System.out.println( x );//输出100
		
		System.out.println( buffer );
		
		char ch = buffer.getChar();
		
		System.out.println( ch );
		
		System.out.println( buffer );
		
	}

}
