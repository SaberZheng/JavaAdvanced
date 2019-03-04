package ecut.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Scanner;

public class Sender3 {
	
	public static void main(String[] args) throws IOException {
		
		Scanner scan = new Scanner( System.in );
		
		// 指定本地的 IP 地址和 端口
		SocketAddress local = new InetSocketAddress( "192.168.0.106" , 6666 ) ;
		// 创建一个可以基于UDP 协议进行 收、发 数据的 DatagramSocket 对象
		DatagramSocket sender = new DatagramSocket( local );
		
		// 指定远程IP地址和端口 ( 就是 数据报包 的目的地址 )
		SocketAddress remote = new InetSocketAddress( "192.168.0.106" , 5555 );
		final byte[] buffer = { };
		DatagramPacket dp = new DatagramPacket( buffer, buffer.length );
		// 为数据报包 指定目的地址
		dp.setSocketAddress( remote );
		
		String s ;
		System.out.println( "请输入你要发送的数据:" );
		while( ( s = scan.nextLine() ) != null ){
			byte[] data = s.getBytes() ;
			// 每次发送之前都将要发送的数据设置到 数据报包 中
			dp.setData( data );
			// 发送数据报包
			sender.send( dp );
			if( "byebyebye".equalsIgnoreCase( s ) ){
				break ;
			}
			System.out.println( "请输入你要发送的数据:" );
		}
		
		sender.close();
		scan.close();
	}
	
}
