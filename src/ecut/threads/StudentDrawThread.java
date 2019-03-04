package ecut.threads;

public class StudentDrawThread extends Thread {
	
	private Student student ;
	private double drawAmount ;
	
	public StudentDrawThread(Student student , double drawAmount , String threadName ) {
		super( threadName );
		this.student = student;
		this.drawAmount = drawAmount ;
	}

	@Override
	public void run() {
		for( int i = 0 ; i < 2 ; i++ ){
			student.draw(drawAmount);
		}
		System.out.println( "学生取钱线程结束" );
	}

}
