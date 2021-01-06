package exercise8;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Practice2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		Set<Student> students = new TreeSet<Student>();
		String number,name;
        int age;
		while(true) {
			number = input.next();
			if("exit".equals(number))
				break;
			name = input.next();
			age = input.nextInt();
			Student student = new Student(number, name, age);
			students.add(student);
		}
		
		File file = new File("src/exercise8/output.txt");
		FileOutputStream outFile = new FileOutputStream(file);
		DataOutputStream dataOutFile = new DataOutputStream(outFile);
		
		Iterator<Student> it = students.iterator();
		while(it.hasNext()) {
			Student student = (Student)it.next();
			System.out.println(student.getNumber()+" "+student.getName()+" "+student.getAge());
			dataOutFile.writeUTF(student.getNumber()+" "+student.getName()+" "+student.getAge());
		}
		dataOutFile.close();
	}

}
@SuppressWarnings("rawtypes")
class Student implements Comparable{
	private String number; //学号
	private String name;  //姓名
	private int age;    //年龄
	
	public Student(String number,String name,int age) {
		this.number=number;
		this.name=name;
		this.age=age;
	}
	
	public String getNumber(){
        return this.number;
    }
	
    public String getName(){
        return this.name;
    }
    
    public int getAge(){
        return this.age;
    }
    
    public void setNumber(String number){
        this.number = number;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setAge(int age){
        this.age = age;
    }

    public int compareTo(Object o) {
    	 if(!(o instanceof Student)){
             throw new RuntimeException("不是Student对象");
         }
         Student p = (Student) o;
         if(this.age > p.age){
             return 1;
         }else if(this.age == p.age){
             return this.name.compareTo(p.name);
         }else{
             return -1;
         }
    }
}