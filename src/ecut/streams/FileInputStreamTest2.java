package ecut.streams;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * FileInputStream 用于读取诸如图像数据之类的原始字节流，字节流不擅长读字符文件擅长 字节文件，要读取字符流，请考虑使用 FileReader。
 */
public class FileInputStreamTest2 {

	public static void main(String[] args) throws IOException {
		// 创建一个用来读取JavaAdvanced.txt文件的输入流
		InputStream in = new FileInputStream( "JavaAdvanced.txt" );//1388byte
		//false 不支持mark方法（  在此输入流中标记当前的位置）和reset方法（将此流重新定位到最后一次对此输入流调用 mark 方法时的位置。）因为没有缓冲区。
		System.out.print( in.markSupported());
		// 声明⼀个变量⽤来统计读取到的字节数
		int n ;
		// 声明并创建一个数组⽤来保存读取到的字节
		byte[] bytes = new byte[ 100 ];
		// 从 输入流中 读取 字节 到 数组中，并返回 实际读取到的 字节数，当到达流末尾时返回-1
		while( ( n = in.read( bytes ) ) != -1 ) {
			// 将 bytes 数组中的 [ 0 , n ) 之间的字节根据 平台默认编码构造字符串对象
			//不要调用String(byte bytes[])构造方法，若调用此构造方法最后一次会有12个byte读到之前的内容。
			String s = new String( bytes , 0 , n  );
			// 将本次读取到的字符串输出到控制台(文件中的换行符号会当作换行处理，因此输出时不需要带换行)
			System.out.print( s );
		}
		
		in.close();
		
	}

}
