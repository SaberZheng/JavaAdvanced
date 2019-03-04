package ecut.reflect;

import java.lang.reflect.Method;

import ecut.reflect.entity.Student;

public class AccessMethodTest1 {

	public static void main(String[] args) {
		
		Object o = new Student();
		
		Class<?> c = o.getClass() ;
		//获得由本类直接声明的所有的方法对应的 Method 数组
		Method[] methods = c.getDeclaredMethods();
		
		for( int i = 0 , n = methods.length ; i < n ; i++ ) {
			Method m = methods[ i ] ;
			System.out.println( m );
		}
		
	}

}
