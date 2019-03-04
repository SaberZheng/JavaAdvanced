package ecut.streams;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class ParseWtmpx {

	public static void main(String[] args) throws IOException {

		PrintStream ps = new PrintStream("parsed.txt");

		File f = new File("mywtmpx");

		final long size = f.length(); // 获得文件大小
		final int unit = 372;
		final long n = size / unit;
		System.out.println("记录数: " + n);

		InputStream in = new FileInputStream(f);

		DataInputStream dis = new DataInputStream(in);

		final byte[] nameBytes = new byte[32];
		final byte[] ipBytes = new byte[257];
		for (int i = 0; i < n; i++) {
			// 一条记录开始
			dis.read(nameBytes); // 32
			String username = new String(nameBytes).trim();
			ps.print(username);
			ps.print("\t");

			dis.skip(36); // 36

			int pid = dis.readInt(); // 4
			ps.print(pid);
			ps.print("\t");

			short type = dis.readShort(); // 2
			ps.print(type);
			ps.print("\t");

			dis.skip(6); // 6

			int seconds = dis.readInt(); // 时间的 秒部分 ( 4 )
			int ms = dis.readInt(); // 时间的 毫秒部分 ( 4 )

			long time = seconds * 1000L + ms;// int类型乘以1000可能超出int界限所以可能结果是负数
			ps.print(time);
			ps.print("\t");

			dis.skip(26); // 26

			dis.read(ipBytes); // 257
			String ip = new String(ipBytes).trim();
			ps.println(ip);

			dis.skip(1);// 一条记录结束
		} 
		dis.close();
		in.close();
		ps.close();

	}

}
