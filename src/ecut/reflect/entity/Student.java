package ecut.reflect.entity;

public class Student {

	private int id;
	private String name;

	public Student() {
		System.out.println("无参构造执行");
	}

	protected Student(int id) {
		System.out.println("带有一个int类型参数的构造执行");
		this.id = id;
	}

	public Student(int id, String name) {
		System.out.println("带有一个int类型参数和一个String类型参数的构造执行");
		this.id = id;
		this.name = name;
	}

	public Student(String name, int id) throws RuntimeException, NullPointerException {
		System.out.println("带有一个String类型参数和一个int类型参数的构造执行");
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public final void eat(String food) {
		System.out.println(this.name + " 吃 " + food);
	}

}
