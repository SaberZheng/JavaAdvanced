package ecut.reflect;

import java.lang.reflect.Array;
import java.util.Random;

public class AccessArrayTest2 {

	public static void main(String[] args) {
		
		Random rand = new Random();
		
		Object o = Array.newInstance( int.class ,  10 ); // Object o = new int[ 10 ] ;
		
		Class<?> c = o.getClass() ;
		
		if( c.isArray() ){
			int n = Array.getLength( o );
			System.out.println( n );
			
			// 用反射方式为数组中的每个元素赋值
			for (int i = 0; i < n; i++) {
				int v = rand.nextInt(100); // 产生 [ 0 , 100 ) 之间的整数
				Array.set(o, i, v); // o [ i ] = v ;
			}

			// 用反射方式遍历数组
			for (int i = 0; i < n; i++) {
				Object v = Array.get(o, i); // o[ i ] ;
				System.out.print(v + "\t");
			}
			System.out.println();

		} else {
			System.out.println( "不是数组" );
		}
		
		

	}

}
