package ecut.classloader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 除了 Bootstrap Loader 之外，
 * 其它的所有的类加载器对应的类的父类都是 java.lang.ClassLoader
 */
public class EcutClassLoader extends ClassLoader {
	
	private String path ;
	
	public EcutClassLoader(String path) {
		super();
		this.path = path;
	}

	@Override
	protected Class<?> findClass(final String name) throws ClassNotFoundException {
		Class<?> c = null ;
		System.out.println( "将要加载的类: " + name );
		String s = name.replace( '.', '/' ) + ".class";
		
		Path p = Paths.get( path ,  s );
		
		if( Files.exists( p ) ){
			try {
				
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				
				InputStream in = Files.newInputStream( p  );
				int n ;
				byte[] bytes = new byte[1024];
				while( ( n = in.read( bytes ) ) != -1 ){
					baos.write( bytes , 0 , n );
				}
				
				final byte[] byteCode = baos.toByteArray(); // 获得 ByteArrayOutputStream 内部的数据
				
				c = this.defineClass( name , byteCode ,  0 , byteCode.length );
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			throw new ClassNotFoundException( "类: " + name  + " 未找到." );
		}
		
		return c ;
	}

}
