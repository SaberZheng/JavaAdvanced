package ecut.reflect;

import java.lang.reflect.Constructor;

import ecut.reflect.entity.Student;


public class AccessConstructorTest1 {

	public static void main(String[] args) {
		
		Class<?> c = Student.class ;
		//获得由本类所声明的所有的构造方法组成的数组,这些构造方法的修饰符可以是 private 、默认 、protected 、public
		Constructor<?>[] cs =  c.getDeclaredConstructors();
		
		for( Constructor<?> con : cs ){
			System.out.println( con );
		}
		
		System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~" );
		//获得本类中所有的 public 修饰的构造方法组成的数组
		Constructor<?>[] constructors =  c.getConstructors();
		
		for( Constructor<?> con : constructors ){
			System.out.println( con );
		}
		
		
	}

}
