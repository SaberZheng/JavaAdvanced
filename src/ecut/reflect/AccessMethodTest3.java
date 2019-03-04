package ecut.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;

public class AccessMethodTest3 {

	public static void main(String[] args) throws Exception {
		
		Class<?> c = HashMap.class ;
		//获得由本类直接声明的指定名称、指定参数列表的方法对应的 Method 对象
		Method m = c.getDeclaredMethod( "put" , Object.class , Object.class );
		
		System.out.println( m );
		//以 int 形式返回该 方法 ( Method ) 的修饰符
		int mod = m.getModifiers();
		String modifier = Modifier.toString( mod ) ;
		System.out.println( "modifier : " + modifier );
		//返回当前方法的返回类型 ( 是一个 Class 类型的对象 )
		Class<?> returnType = m.getReturnType();
		System.out.println( "return type : " + returnType.getName() );
		//返回此 方法 的名称
		String name = m.getName();
		System.out.println( "name : " + name );
		
		
		// 获得参数类型列表
		Class<?>[] paramTypes = m.getParameterTypes();
		System.out.print( "parameter types : " );
		for( int i = 0 , n = paramTypes.length ; i < n ; i++ ){
			Class<?> t = paramTypes[ i ];
			System.out.print( t.getName() + "\t" );
		}
		System.out.println();
		
		
		// 获取所声明抛出的异常类型
		Class<?>[]  exceptionTypes = m.getExceptionTypes();
		System.out.print( "exception types : " );
		for( int i = 0 , n = exceptionTypes.length ; i < n ; i++ ){
			Class<?> t = exceptionTypes[ i ];
			System.out.print( t.getName() + "\t" );
		}
		System.out.println();
	}

}
