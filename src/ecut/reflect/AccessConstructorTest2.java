package ecut.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import ecut.reflect.entity.Student;

public class AccessConstructorTest2 {

	public static void main(String[] args) throws Exception {
		
		Class<Student> c = Student.class ;
		
		//从本类的 public 修饰的构造方法中，寻找与 parameterTypes 相匹配的那个构造方法
		Constructor<Student> con = c.getConstructor( int.class , String.class );
		
		System.out.println( con );
		
		int mod = con.getModifiers() ;
		System.out.println( Modifier.toString( mod ) );
		
		System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
		
		Object o = con.newInstance( 100 , "张三丰" );
		
		System.out.println( o );//通过反射获取到对象
		
	}

}
