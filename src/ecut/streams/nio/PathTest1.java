package ecut.streams.nio;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class PathTest1 {

	public static void main(String[] args) {
		
		//转换的路径字符串,或一个字符串序列,当加入形成一个路径字符串, Path。 
		Path path = Paths.get( "D:/" , "Amy" ,"C++" , "c++API.chm"  );
		
		System.out.println( path );
		
		System.out.println( "是否是绝对路径 : " + path.isAbsolute() );
		
		System.out.println( "文件 或 目录 名称: " + path.getFileName()  );
		
		// 对可变长参数部分的各个 Path 进行迭代的迭代器
		Iterator<Path> itor = path.iterator();
		
		while( itor.hasNext() ){
			System.out.println( itor.next() );
		}
		
	}

}
