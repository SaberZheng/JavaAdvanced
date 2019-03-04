package ecut.streams.nio;

import java.nio.charset.Charset;

public class CharsetTest3 {

	public static void main(String[] args) {
		
		String charsetName = "UTF-8" ;
		// 通知是否支持指定的 charset。
		boolean support = Charset.isSupported( charsetName ) ;
		
		System.out.println( support );
		
		if( support ){
			// 返回指定 charset 的 charset 对象。
			Charset charset = Charset.forName( charsetName );
			
			System.out.println( charset );
			
		}

	}

}
