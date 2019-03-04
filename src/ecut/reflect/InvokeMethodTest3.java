package ecut.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class InvokeMethodTest3 {

	public static void main(String[] args) throws Exception {
		
		// 加载指定的类
		Class<?> c = Class.forName( "ecut.reflect.entity.Student" );
		
		Constructor<?> con = c.getConstructor( int.class , String.class );
		
		//Student s = new Student( 100 , "张翠山" );
		Object s = con.newInstance( 100 , "张翠山" );
		
		Method getIdMethod = c.getDeclaredMethod( "getId" ) ;
		
		// int id = s.getId() ; // 被调用的方法是 getId ; 没有传入的参数 ; 调用 s 所引用的对象的 getId
		Object result = getIdMethod.invoke( s );
		System.out.println( "result : " + result );
		
		Method getNameMethod = c.getDeclaredMethod( "getName" ) ;
		
		// String name = s.getName() ; // 被调用的方法是 getName ; 没有传入的参数 ; 调用 s 所引用的对象的 getName
		result = getNameMethod.invoke( s );
		System.out.println( "result : " + result );
		
	}

}
