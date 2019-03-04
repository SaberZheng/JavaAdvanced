package ecut.streams.nio;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;

public class CharsetTest2 {

	public static void main(String[] args) {
		// 构造从规范 charset 名称到 charset 对象的有序映射。
		SortedMap<String, Charset> charsets = Charset.availableCharsets();
		
		Set< Entry<String, Charset> > entries = charsets.entrySet();
		
		Iterator< Entry<String, Charset> > itor =  entries.iterator();
		
		while( itor.hasNext() ){
			Entry<String, Charset> entry = itor.next();
			System.out.print( entry.getKey() );
			System.out.print( " , " );
			System.out.println( entry.getValue() );
		}

	}

}
