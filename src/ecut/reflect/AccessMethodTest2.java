package ecut.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import ecut.reflect.entity.Student;

public class AccessMethodTest2 {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		
		Object o = new Student();
		
		Class<?> c = o.getClass() ;
		//	获得由本类或父类声明的由 public 修饰的、指定名称、指定参数列表的方法对应的 Method 对象
		Method eatMethod = c.getDeclaredMethod( "eat" , String.class );
		
		int mod = eatMethod.getModifiers();//以 int 形式返回该 方法 ( Method ) 的修饰符
		
		System.out.println( mod );//1(public)+16(final)
		
		String modifiers = Modifier.toString( mod );//返回描述指定修饰符中的访问修饰符标志的字符串
		
		System.out.println( modifiers );
		
	}

}
