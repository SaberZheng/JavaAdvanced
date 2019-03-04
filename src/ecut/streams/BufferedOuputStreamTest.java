package ecut.streams;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class BufferedOuputStreamTest {

	public static void main(String[] args) throws IOException {

		OutputStream out = new FileOutputStream("buffer.txt");

		// 内部有一个 默认是 8192 大小的字节数组
		BufferedOutputStream bos = new BufferedOutputStream(out);

		byte[] bytes = "i am sinaean !".getBytes();
		// 好像并没有直接写磁盘减少对磁盘的读写次数，实际上最终还是将传入的out流一个字节一个字节的写出并没有提高多少效率
		bos.write(bytes); // 将 字节内容 写入 BufferedOutputStream 内部的缓冲区 ( byte 数组默认
							// 大小是 8192)
		// bos.flush(); // 将 缓冲区中的内容 刷出 到 底层输出流

		bos.close(); // close 操作导致将 最后写入到 缓冲区的内容 刷出

		out.close();

	}

	

}
