package ecut.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class Receiver3 {

	public static void main(String[] args) throws IOException {
		
		// 指定本地的 IP 地址和 端口
		SocketAddress local = new InetSocketAddress( "192.168.0.106" , 5555 ) ;
		// 创建一个可以基于UDP 协议进行 收、发 数据的 DatagramSocket 对象
		DatagramSocket receiver = new DatagramSocket( local );
		
		final byte[] buffer = new byte[ 1024 ];
		// 创建一个用来接受数据的数据报包 对象
		DatagramPacket dp = new DatagramPacket( buffer , buffer.length );
		
		while( true ) {
			// 接受数据 ( 接受时，依然是以数据报包形式接受 )
			receiver.receive( dp );
			InetSocketAddress remote = (InetSocketAddress)dp.getSocketAddress(); // 作为接收者，获得发送者对应的 IP 地址 和 端口
			String sender = remote.getHostString() + ":" + remote.getPort() ;
			int n = dp.getLength() ; // 接受到的字节数组的实际长度
			String s = new String( buffer , 0 , n );
			System.out.println( sender + "说: " + s );
			if( "byebyebye".equalsIgnoreCase( s ) ){
				break ;
			}
		}
		
		receiver.close();
	}

}
