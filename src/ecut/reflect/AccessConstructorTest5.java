package ecut.reflect;

import ecut.reflect.entity.Student;

/**
 * 本类中并不会获取 Constructor 类型的对象，但是会通过 构造方法来创建对象
 */
public class AccessConstructorTest5 {

	public static void main(String[] args) throws Exception {
		
		Class<?> c = Student.class ;

		//依赖于 相应类型中的 public修饰的 无参构造方法 (被绝大多数框架所采用 )等同于c.getConstructor().newInstance();
		Object o = c.newInstance(); 

		System.out.println( o );
		
	}

}
