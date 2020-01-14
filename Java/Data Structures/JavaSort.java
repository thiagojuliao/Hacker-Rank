import java.util.*;

class Student implements Comparable<Student>{

	private int id;
	private String fname;
	private double cgpa;

	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}

    @Override
    public int compareTo(Student otherStudent){

        int c0 = new Double(this.cgpa).compareTo(new Double(otherStudent.getCgpa()));
        int c1 = this.fname.compareTo(otherStudent.getFname());
        int c2 = new Integer(this.id).compareTo(new Integer(otherStudent.getId()));

        if (c0 == 0){
            if (c1 == 0){
                return c2;
            }else{
               return c1;
            }
        }else{
            return -c0;
        }
    }
}

//Complete the code
public class Solution
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		List<Student> studentList = new ArrayList<Student>();
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
			
			Student st = new Student(id, fname, cgpa);
			studentList.add(st);
			
			testCases--;
		}

        // Sorting the list
        Collections.sort(studentList);
        
      	for(Student st: studentList){
			System.out.println(st.getFname());
		}
	}
}



