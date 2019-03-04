package ecut.streams.nio;

import java.nio.CharBuffer;

public class CharBufferTest1 {

	public static void main(String[] args) {
		
		// 获得 CharBuffer 实例
		CharBuffer buffer = CharBuffer.allocate( 10 );
		show( buffer );
		
		buffer.put( 'A' );
		buffer.put( 'B' );
		buffer.put( 'C' ) ;
		
		show( buffer );
		
		// 判断 从 当前位置 到限制位置 之间是否有元素可以读取
		System.out.println( buffer.hasRemaining() );
		// 获得 从当前位置 到 限制位置 之间的 元素个数
		System.out.println( buffer.remaining() );
		
		System.out.println( buffer );
		
		// 重新设置 限制位置 为 当前位置
		buffer.limit( buffer.position() ) ;
		// 将 当期位置 设置为 开始位置
		buffer.position( 0 ) ;
		
		System.out.println( buffer.toString() );
		
		show( buffer );
		
		//相对 get 方法。读取此缓冲区当前位置的字符，然后该位置递增。 
		char ch = buffer.get();
		System.out.println( ch );
		show( buffer );
		
		ch = buffer.get();
		System.out.println( ch );
		show( buffer );
		
		ch = buffer.get();
		System.out.println( ch );
		show( buffer );
		
	}
	
	public static void show( CharBuffer buffer ) {
		System.out.print( "position : " + buffer.position() );
		System.out.print( " , " );
		System.out.print( "limit : " + buffer.limit() );
		System.out.print( " , " );
		System.out.println( "capacity : " + buffer.capacity() );
	}

}
