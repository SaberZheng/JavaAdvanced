package ecut.streams.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopyFileByNio {

	public static void main(String[] args) throws IOException {
		
		Path source = Paths.get( "D:\\java_workspace\\zhongbang\\JavaAdvanced\\mywtmpx.txt" );
		
		String name = source.getFileName().toString() ;
		
		System.out.println("name:"+name );
		
		System.out.println("source:"+source );
		
		Path target = Paths.get( "D:/Amy" , name   );
		
		System.out.println("target:"+target );
		
		Files.copy( source ,  target , StandardCopyOption.REPLACE_EXISTING);
		
	}

}
