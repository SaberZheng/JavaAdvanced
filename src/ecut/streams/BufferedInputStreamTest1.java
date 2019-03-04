package ecut.streams;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BufferedInputStreamTest1 {

	public static void main(String[] args) throws IOException {
		// 创建一个文件输入流
		InputStream in = new FileInputStream("./src/ecut/streams/BufferedInputStreamTest1.java");

		// 创建字节缓冲输入流。BufferedInputStream 内部有一个 默认 容量是 8192 字节数组 用来缓存 读取到的内容
		BufferedInputStream bis = new BufferedInputStream(in);
		// 声明一个变量用来记录读取到的字节数
		int n;
		// 声明并创建一个数组用来存储被读取到的字节
		byte[] bytes = new byte[8192];
		// 从字节缓冲输入流中读取数据到 字节数组中，并记录读取到的实际字节数，当到达流末尾时返回 -1
		while ((n = bis.read(bytes)) != -1) {
			// 将读取到的有效字节构造成字符串
			String s = new String(bytes, 0, n);
			System.out.print(s);
		}

		bis.close();// 关闭字节缓冲输人流
		in.close();// 关闭字节输入流

	}
	
}
