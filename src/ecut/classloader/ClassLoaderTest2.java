package ecut.classloader;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class ClassLoaderTest2 {

	public static void main(String[] args) {

		Properties props = System.getProperties();
		System.out.println(props);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");

		Set<Object> keys = props.keySet();
		for (Object key : keys) {
			Object value = props.get(key);
			System.out.println(key + " : " + value);
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
		Iterator<Object> it = keys.iterator();
		while (it.hasNext()) {
			Object key = it.next();
			Object value = props.get(key);
			System.out.println(key + " : " + value);
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");

		System.out.println(System.getProperty("java.ext.dirs"));

		System.out.println(System.getProperty("java.class.path"));

	}

}
