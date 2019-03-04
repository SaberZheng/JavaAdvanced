package ecut.classloader;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LoadClassTest {

	public static void main(String[] args) throws IOException {
		
		final String path = "D:/Amy" ;
		
		// 确定被加载的类的权限定类名
		final String className = "ecut.classloader.entity.Student" ;
		
		String s = className.replace( '.', '/' ) ;
		s += ".class" ;
		System.out.println( s );
		
		Path p = Paths.get( path ,  s );
		System.out.println( p );
		
		System.out.println( Files.exists( p ) );
		
		InputStream in = Files.newInputStream( p  );
		
		System.out.println( in );
		
		//FileInputStream in = new FileInputStream( "C:/files/edu/ecut/entity/Student.class" );

	}

}
