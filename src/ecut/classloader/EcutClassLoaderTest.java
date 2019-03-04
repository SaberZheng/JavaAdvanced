package ecut.classloader;

import java.lang.reflect.Field;

public class EcutClassLoaderTest {

	public static void main(String[] args) throws Exception {
		
		final String path = "D:/Amy" ;
		
		// 创建一个自定义的类加载器 ( 实例 )
		EcutClassLoader loader = new EcutClassLoader( path );
		
		final String className = "ecut.classloader.entity.Student" ;
		Class<?> c = loader.loadClass( className );
		
		System.out.println( c );
		
		System.out.println( c.getName() );
		
		System.out.println( c.getSimpleName() );
		
		System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
		
		Object o = c.newInstance();
		
		System.out.println( o );
		
		Field idField = c.getDeclaredField( "id" );
		idField.setAccessible( true );
		Object value = idField.get( o ); // o.id
		System.out.println( value );
		
		idField.set( o , 250 ); // o.id = 250 ;
		
		 value = idField.get( o ); // o.id
		 System.out.println( value );
		
	}

}
