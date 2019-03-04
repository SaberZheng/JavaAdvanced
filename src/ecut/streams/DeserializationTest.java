package ecut.streams;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class DeserializationTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		// 读取指定文件中的字节序列的 字节输入流
		InputStream in = new FileInputStream("student.ser");

		/** 创建一个 可以将 字节序列 转换成 JVM 中的对象的 输入流 ( 转换流 ) */
		ObjectInputStream ois = new ObjectInputStream(in);

		// 从 ObjectInputStream 中读取字节序列并 "重构" 成 JVM 中的对象
		Object o = ois.readObject();// ClassNotFoundException
		System.out.println(o);// ecut.streams.Student@119d7047
		// instanceof用于安全转换，判断o是不是Student类型
		if (o instanceof Student) {
			Student s = (Student) o;
			System.out.println(s.getName());
			System.out.println(s.getBirthdate());
		}
		ois.close();

		in.close();

	}

}
