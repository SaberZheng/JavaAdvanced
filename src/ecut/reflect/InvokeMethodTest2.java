package ecut.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class InvokeMethodTest2 {

	public static void main(String[] args) throws Exception {
		
		
		/*加载指定的类 ,3种方式获取Class
		 （1）某个对象实例的getClass()方法，如new Student().getClass()
		 （2）某个类名.class属性，Student.class
		 （3）通过Class.forName("完整的类名")获取*/		
		Class<?> c = Class.forName( "ecut.reflect.entity.Student" );
		
		Constructor<?> con = c.getConstructor( int.class , String.class );
		
		//Student s = new Student( 100 , "张翠山" );
		Object s = con.newInstance( 100 , "张翠山" );
		//获得由本类或父类声明的由 public 修饰的、指定名称、指定参数列表的方法对应的 Method 对象
		Method eatMethod = c.getDeclaredMethod( "eat" , String.class ) ;
		
		// s.eat( "藜蒿炒腊肉" ); // 被调用的方法是 eat ; 传入的参数是字符串 ; 调用 s 所引用的对象的 eat 方法
		Object result = eatMethod.invoke( s , "藜蒿炒腊肉" );
		System.out.println( "result : " + result );
		
	}

}
