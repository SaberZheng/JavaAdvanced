package ecut.streams;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class RandomAccessFileTest1 {

	public static void main(String[] args) throws IOException {
		
		final byte b = 0 ;
		final byte[] nameBytes = new byte[32] ;
		
		String name = "" ;
		char gender ;
		boolean married = false ; // 表示是否结婚的变量 ( JVM 中 boolean 占 1 个 位 ( 1 bit ) )
		
		
		String filename = "student.data" ;
		String mode = "rw" ;// 	打开以便读取和写入
		RandomAccessFile raf = new RandomAccessFile( filename , mode );
		raf.setLength( 70 );
		
		raf.seek( 35 ); // 将 文件指针 调整到 35  
		
		name = "奥斯特洛夫斯基" ;
		byte[] bytes = name.getBytes(); // 长度是 21
		Arrays.fill( nameBytes ,  b );//将数组填充为初始状态
		System.arraycopy( bytes , 0 , nameBytes,  0 , bytes.length );//bytes拷贝到nameBytes
		raf.write( nameBytes ); // 写出一个 长度为 32 字节的数组
		
		gender = '男' ;
		raf.writeChar( gender ); // 写出一个 字符 占 2 个字节
		
		married = true ;
		raf.writeBoolean( married ); // 写出一个 boolean 值，占 1 字节
		
		long pointer = raf.getFilePointer() ; // 获得  "文件指针" 的 当前位置
		System.out.println( "pointer :" + pointer );
		
		System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		raf.seek( 35 );
		
		raf.read( nameBytes );  // 读取 32 个字节到数组中
		name = new String( nameBytes ).trim() ;
		
		gender = raf.readChar(); // 读取 2 个字节 并重构成 char 类数值
		
		married = raf.readBoolean() ; // 读取 1 个字节，并根据这个字节中的那一个位重构 boolean 数值
		
		System.out.println( name + " , " + gender + " , " + married ) ;
		
		pointer = raf.getFilePointer() ; // 获得  "文件指针" 的 当前位置
		System.out.println( "pointer :" + pointer );
		
		
		raf.close();
		
	}

}
