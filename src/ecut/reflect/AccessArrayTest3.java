package ecut.reflect;

import java.lang.reflect.Array;

public class AccessArrayTest3 {

	public static void main(String[] args) {

		Object o = Array.newInstance(int.class, 4, 5); // new char[ 4 ] [ 5 ] ;

		Class<?> c = o.getClass();

		if (c.isArray()) {

			int x = Array.getLength(o); // 获得最外维的数组的长度
			System.out.println("外部数组长度: " + x);
			for (int i = 0; i < x; i++) {
				// 获得数组内部的元素 ( 可能还是数组 )
				Object e = Array.get(o, i);
				Class<?> cc = e.getClass();
				if (cc.isArray()) {
					int y = Array.getLength(e); // 获得第二维的数组的长度
					for (int j = 0; j < y; j++) {
						// 获得第二维数组中的元素
						Object v = Array.get(e, j);
						System.out.print(v + "\t");
					}
					System.out.println();
				} else {
					System.out.println(e);
				}
			}

		}

	}

}
