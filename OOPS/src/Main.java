public class Main {
    public static void main(String[] args) {
        // store data of 5 students {roll no, name, marks}
        int[] rno = new int[5];
        String[] name = new String[5];
        float[] marks = new float[5];
    // or else create a single datatype that stores all these 3 params.
        Student[] students = new Student[5];

       // Student kunal; // Declaring a reference to an object of type Student
                       // (not creating an object kunal)
        Student kunal = new Student(47, "Shashank", 99.6f); // new keyword dynamically allocates memory & returns a reference
                                       // reference to it(object kunal created.)
//       kunal.rno = 13;
//       kunal.name = "Kunal Kushwaha";
//       kunal.marks = 88.5f;

        System.out.println(kunal.rno);
        System.out.println(kunal.name);
        System.out.println(kunal.marks);
    }
}
// Create class
class Student{
    int rno;
    String name;
    float marks = 90;
    Student(int rno, String name, float marks){
        this.rno = rno;
        this.name = name;
        this.marks = marks;
    }



}