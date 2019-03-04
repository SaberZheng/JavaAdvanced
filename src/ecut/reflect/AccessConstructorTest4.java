package ecut.reflect;

import java.lang.reflect.Constructor;

import ecut.reflect.entity.Student;

public class AccessConstructorTest4 {

	public static void main(String[] args) throws Exception {
		
		Class<?> c = Student.class ;
		
		Constructor<?> con = null ;
		Object o = null ;
		
		con = c.getConstructor(); // 获取 public 修饰的无参构造
		
		o = con.newInstance() ; // 调用无参构造创建对象
		
		System.out.println( o );
		
		// 根据参数类型列表寻找相应的由 public 修饰 构造方法
		con = c.getConstructor(  int.class  , String.class );
		
		o = con.newInstance( 9527 , "华安" );
		
		System.out.println( o );
		//获得由本类所声明的所有的构造方法组成的数组,这些构造方法的修饰符可以是 private 、默认 、protected 、public
		con = c.getDeclaredConstructor( int.class ) ;
		//让一个本来不能访问的对象可以被访问，可以写作 setAccessible( true )
		con.setAccessible( true );
		
		o = con.newInstance( 250 );
		System.out.println( o );
		
	}

}
