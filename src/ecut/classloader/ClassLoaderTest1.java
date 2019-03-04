package ecut.classloader;

import java.util.ArrayList;

public class ClassLoaderTest1 {

	public static void main(String[] args) {

		Class<?> c = String.class; // java.lang.String
		ClassLoader loader = c.getClassLoader();
		System.out.println(loader); // null ( Bootstrap Loader )

		Object o = new ArrayList<>(); // java.util.ArrayList

		c = o.getClass();
		loader = c.getClassLoader();
		System.out.println(loader); // null ( Bootstrap Loader )
		
		c = ClassLoaderTest1.class;
		loader = c.getClassLoader(); // 获得 ClassLoaderTest1 这个类的类加载器
		System.out.println(loader); // AppClassLoader
		
		// 获得 loader 这个 "类加载器" 的 父加载器
		ClassLoader parent = loader.getParent();
		System.out.println(parent); // ExtClassLoader
		
		ClassLoader root = parent.getParent();
		System.out.println( root ); // null ( Bootstrap Loader )

	}

}
