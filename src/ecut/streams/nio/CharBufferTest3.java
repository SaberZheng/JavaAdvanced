package ecut.streams.nio;

import java.nio.CharBuffer;

public class CharBufferTest3 {

	public static void main(String[] args) {
		
		// 获得 CharBuffer 实例
		CharBuffer buffer = CharBuffer.allocate( 10 );
		
		show( buffer );
		
		buffer.put( 'A' );
		buffer.put( 'B' );
		buffer.put( 'C' ) ;
		
		show( buffer );
		
		buffer.flip(); // 1、limit = position ; 2、position = 0 ;  3、mark = -1;
		
		for( int i = buffer.position() , n = buffer.limit() ; i < n ; i++ ){
			char ch = buffer.get();
			System.out.println( ch );
		}
		
		System.out.println( "~~~~~~~~~~~~~~~~~" );
		show( buffer );
		buffer.rewind(); // "倒带" 
		show( buffer );
		
		for( int i = buffer.position() , n = buffer.limit() ; i < n ; i++ ){
			char ch = buffer.get();
			System.out.println( ch );
		}
		
		
	}
	
	public static void show( CharBuffer buffer ) {
		System.out.print( "position : " + buffer.position() );
		System.out.print( " , " );
		System.out.print( "limit : " + buffer.limit() );
		System.out.print( " , " );
		System.out.println( "capacity : " + buffer.capacity() );
	}

}
