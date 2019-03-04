package ecut.network;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class ServerV1 {

	public static void main(String[] args) throws Exception {
		
		// 创建一个 ServerSocket 对象,用来对外提供服务
		ServerSocket server = new ServerSocket();
		System.out.println( server );
		System.out.println( server.isBound() );
		
		SocketAddress endpoint = new InetSocketAddress( "10.10.12.72",  5555 );
		server.bind( endpoint );
		
		System.out.println( "server ip : " + server.getInetAddress().getHostAddress());
		System.out.println( "server port : " +server.getLocalPort() );
		
		// 监听来自客户端的连接 ( 会阻塞当前线程 )
		Socket socketFromClient = server.accept();
		System.out.println( "socket : " + socketFromClient );
		
		System.out.println( "server ip ( local ) : " + socketFromClient.getLocalAddress().getHostAddress() );
		System.out.println( "server port ( local ) : " + socketFromClient.getLocalPort() );
		
		InetSocketAddress sa = (InetSocketAddress) socketFromClient.getRemoteSocketAddress();
		System.out.println( "client ip : " + sa.getHostString() );
		System.out.println( "client port : " + sa.getPort() );
		
		server.close();
	}

}
