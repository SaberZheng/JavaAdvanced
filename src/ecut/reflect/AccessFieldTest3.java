package ecut.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import ecut.reflect.entity.Student;

public class AccessFieldTest3 {

	public static void main(String[] args) {

		Object o = new Student();

		Class<?> c = o.getClass();

		try {
			// 获得由本类直接声明的所有的属性组成的 Field 数组
			Field idField = c.getDeclaredField("id");
			System.out.println(idField);

			int mod = idField.getModifiers(); // 获得修饰符
			String modifier = Modifier.toString(mod);
			System.out.println("modifier : " + modifier);
			// 返回当前属性的类型 ( 是一个 Class 类型的对象 )
			Class<?> type = idField.getType();
			System.out.println("type : " + type.getName());
			// 返回此 Field 对象表示的属性 的名称
			String name = idField.getName();
			System.out.println("name : " + name);

		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}

	}

}
