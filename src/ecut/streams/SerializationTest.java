package ecut.streams;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;

public class SerializationTest {

	public static void main(String[] args) throws IOException {
		
		Calendar c = Calendar.getInstance();
		
		c.set( 1996 , 4 , 11 );//1996.5.11 月份从0开始，日期从1开始
		
		Date birthdate = c.getTime();
		
		
		// 创建一个可以输出到本地操作系统中指定文件的文件输出流(字节输出流)
		OutputStream out = new FileOutputStream( "student.ser" );
		//ObjectOutputStream处理流包装流
		/** 创建一个 可以将 JVM 中的指定对象 转换成 字节序列的流 ( 它只转换，不负责最终输出 )*/
		ObjectOutputStream oos = new ObjectOutputStream( out );//ObjectOutputStream实现了接口ObejectOutput，ObejectOutput继承DataOutput
		
		Student s = new Student( 100 , "张三丰" , '男' );
		
		s.setBirthdate( birthdate );
		
		// 将一个 支持 序列化的 类的对象 ，转换成 字节序列 写入 ObjectOuputStream 中
		oos.writeObject( s );
		
		oos.close();
		
		out.close();
		
	}

}
