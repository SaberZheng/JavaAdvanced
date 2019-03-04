package ecut.streams;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * DataOutput 接口 用于将 任意 Java 基本类型转换为一系列字节，并将这些字节写入二进制流
 * DataOutputStream 类 实现了 DataOutput 接口
 */
public class DataOutputStreamTest {

	public static void main(String[] args) throws IOException{
		
		OutputStream out = new FileOutputStream( "binary.data" );//读写都是二进制数据
		
		DataOutputStream oos = new DataOutputStream( out );
		
		final byte[] nameBytes = new byte[32] ; // 假设一个人的姓名最多占32字节
		
		String name = "张三丰" ;
		byte[] bytes1 = name.getBytes();
		System.arraycopy( bytes1 ,  0 ,  nameBytes ,  0 , bytes1.length );
		
		oos.write( nameBytes ); // 将 nameBytes 数组 32 个字节 写入到 数据输出流中
		
		// char 占 2 个字节 ( byte )
		char gender = '男' ; // char类型的范围\u0000 ~ \uFFFF 
		oos.writeChar( gender ); // 将一个 字符 对应的 2 个字节写入到 数据输出流
		
		// boolean 占 1 个 bit ( 写出到文件后占 1 个字节 )
		boolean married = false ;
		oos.writeBoolean( married ); // 将一个 boolean 值 对应的 1 个字节写入到 数据输出流
		
		System.out.println( "~~~~~~~~~~~~~~~~~~~~~" );
		
		name = "灭绝" ;
		byte[] bytes2 = name.getBytes();
		Arrays.fill( nameBytes , (byte)0 );//nemeBytes上次的时候占了9个字节“张三丰”，放入灭绝时候会变成灭绝丰因此需要还原一下数组
		System.arraycopy( bytes2 ,  0 ,  nameBytes ,  0 , bytes2.length );
		oos.write( nameBytes );
		gender = '女' ;
		oos.writeChar( gender );
		married = false ;
		oos.writeBoolean( married );
		
		oos.close();
		out.close();
		

	}

}
