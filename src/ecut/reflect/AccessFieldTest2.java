package ecut.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import ecut.reflect.entity.Student;

public class AccessFieldTest2 {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		
		Object o = new Student();
		
		Class<?> c = o.getClass() ;
		//获得在本类中直接声明指定名称的属性( Field )对象 private  、默认 、protected 、public
		Field idField = c.getDeclaredField( "id" );
		
		int mod = idField.getModifiers();//以 int 形式返回该 属性 ( Field ) 的修饰符
		
		System.out.println( mod );
		
		String modifiers = Modifier.toString( mod );//返回描述指定修饰符中的访问修饰符标志的字符串
		
		System.out.println( modifiers );
		
	}

}
