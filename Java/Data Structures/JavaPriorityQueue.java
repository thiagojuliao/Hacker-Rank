import java.util.Comparator;
import java.util.Arrays;

// Comparator
class Checker implements Comparator<Student>{

    public int compare(Student s1, Student s2){
        if (s1.getCGPA() > s2.getCGPA()){
            return -1;
        }else if(s1.getCGPA() == s2.getCGPA()){
            if (s1.getName().compareTo(s2.getName()) < 0){
                return -1;
            }else if (s1.getName().compareTo(s2.getName()) == 0){
                return new Integer(s1.getId()).compareTo(new Integer(s2.getId()));
            }else{
                return 1;
            }
        }else{
            return 1;
        }
    }
}

// Student
class Student{

    private String name;
    private double cgpa;
    private int id;

    public Student(String name, double cgpa, int id){
        this.name = name;
        this.cgpa = cgpa;
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public double getCGPA(){
        return this.cgpa;
    }

    public int getId(){
        return this.id;
    }
}

// Priorities
class Priorities{

    public List<Student> getStudents(List<String> events){
        
        List<Student> q = new ArrayList<>();
        Checker checker = new Checker();

        String cmd;
        String name;
        double cgpa;
        int id;

        for (int i = 0; i < events.size(); i++){
            String[] args = events.get(i).split(" ");
            cmd = args[0];
            
            // System.out.println(Arrays.toString(args));
            // System.out.println(args[0].length());

            if (cmd.length() == 5){
                name = args[1];
                cgpa = Double.parseDouble(args[2]);
                id = Integer.parseInt(args[3]);

                q.add(new Student(name, cgpa, id));
                q.sort(checker);
            }else{
                if (!q.isEmpty()) q.remove(0);
            }
        }
        return q;
    }
}
