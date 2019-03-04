package ecut.reflect;

import java.lang.reflect.Field;

import ecut.reflect.entity.Student;

public class AccessFieldTest4 {

	public static void main(String[] args) {
		
		Object o = new Student( 100 , "张三丰" );
		
		Class<?> c = o.getClass();
		
		try {
			
			Field idField = c.getDeclaredField( "id" );
			//判断指定对象是否可以被访问，比如 private 修饰的属性就不能直接访问
			if( idField.isAccessible() == false) {
				//让一个本来不能访问的对象可以被访问，可以写作 setAccessible( true )
				idField.setAccessible( true );
			}
			
			// 从 o 对象中 获取 idField 所表示的属性的值
			Object v = idField.get( o ) ;  // o.id ;
			System.out.println( v );
			
			int value = 1001 ;
			//为指定对象 ( o ) 的 该属性赋值
			// 为 o 对象中的 idField 所表示的属性 赋予 value 所表示的值
			idField.set( o , value );
			//返回指定对象( o ) 中，该 Field 表示的属性的值
			v = idField.get( o ) ;  // o.id ;
			System.out.println( v );
			
		} catch (NoSuchFieldException e) {
			System.out.println( "属性不存在" );
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			System.out.println( "不准访问" );
			e.printStackTrace();
		}
		

	}

}
