package ecut.reflect;

import java.lang.reflect.Array;
import java.util.Random;

public class AccessArrayTest1 {

	public static void main(String[] args) {
		
		Random rand = new Random();
		
		Object o = new int[ 10 ] ;
		
		
		// 获得 o 的运行时类型 ( o 所引用的对象的类型 )
		Class<?> c = o.getClass(); // java.lang.Object 类的 getClass 方法被所有类所继承
		
		if( c.isArray() ) {
			
			// 获得数组长度
			int length = Array.getLength( o ) ; // o.length ;
			System.out.println( "数组元素个数: " + length );
			
			// 用反射方式遍历数组
			for( int i = 0 ; i < length ; i++ ){
				Object v = Array.get( o ,  i ) ;  // o[ i ] ;
				System.out.print( v + "\t" );
			}
			System.out.println();
			
			// 用反射方式为数组中的每个元素赋值
			for( int i = 0 ; i < length ; i++ ){
				int v = rand.nextInt( 100 ) ; // 产生 [ 0 , 100 ) 之间的整数
				Array.set( o ,  i ,  v ); // o [ i ] = v ;
			}
			
			System.out.println( "~~~~~~~~~~~~~" );
			
			for( int i = 0 ; i < length ; i++ ){
				Object v = Array.get( o ,  i ) ;  // o[ i ] ;
				System.out.print( v + "\t" );
			}
			System.out.println();
			
		}
		

	}

}
