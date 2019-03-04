package ecut.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import ecut.reflect.entity.Student;

public class AccessConstructorTest3 {

	public static void main(String[] args) throws Exception {
		
		Class<?> c = Student.class ;
		//从本类的 public 修饰的构造方法中，寻找与 parameterTypes 相匹配的那个构造方法
		Constructor<?> con = c.getConstructor( String.class , int.class );
		
		System.out.println( con );
		//以 int 形式返回该 构造方法 ( Constructor ) 的修饰符
		int mod = con.getModifiers();
		String modifier = Modifier.toString( mod ) ;
		System.out.println( "modifier : " + modifier );
		// 获得构造方法的名称，返回带会包名.类名的形式
		String name = con.getName();
		System.out.println( "name : " + name );
		
		// 获得参数类型列表
		Class<?>[] paramTypes = con.getParameterTypes();
		System.out.print( "parameter types : " );
		for( int i = 0 , n = paramTypes.length ; i < n ; i++ ){
			Class<?> t = paramTypes[ i ];
			System.out.print( t.getName() + "\t" );
		}
		System.out.println();
		
		// 获取所声明抛出的异常类型
		Class<?>[]  exceptionTypes = con.getExceptionTypes();
		System.out.print( "exception types : " );
		for( int i = 0 , n = exceptionTypes.length ; i < n ; i++ ){
			Class<?> t = exceptionTypes[ i ];
			System.out.print( t.getName() + "\t" );
		}
		System.out.println();
		
	}

}
