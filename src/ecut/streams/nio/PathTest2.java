package ecut.streams.nio;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest2 {

	public static void main(String[] args) {

		//将给定的URI转换为 Path对象。 
		Path path = Paths.get( "D:/Amy/C++/c++API.chm"  );
		//测试文件是否存在。如果path表示的文件或目录存在则返回true，否则返回false。
		System.out.println( Files.exists( path ) );
		//测试文件是否是一个目录。 
		System.out.println( Files.isDirectory( path ) );
		//测试文件是否与不透明的常规文件内容。 
		System.out.println( Files.isRegularFile( path ) );
		
	}

}
