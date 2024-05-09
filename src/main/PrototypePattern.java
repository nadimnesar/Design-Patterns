package main;

import java.util.ArrayList;
import java.util.List;

public class PrototypePattern {
    public static void main(String[] args) {
        /**
         * Creating a student object and loading some data into it.
         */
        Student student1 = new Student();
        student1.loadData();

        /**
         * Cloning student1 object to create student2 using the prototype pattern's getClone method.
         * Here, student2 will receive all data from student1
         * and student2 will have its own memory space.
         */
        Student student2 = (Student) student1.getClone();

        /**
         * Modifying student2 object; student1 remains unaffected
         */
        student2.getStudentList().add("Student 5");

        /**
         * Printing the studentList from student1 and student2 objects
         */
        System.out.println("Student 1's List: " + student1.getStudentList());
        System.out.println("Student 2's List: " + student2.getStudentList());
    }
}

/**
 * This interface needs to be implemented by any class to utilize the prototype pattern.
 */
interface Prototype {
    Prototype getClone(); // Returns a cloned instance of the object
}

/**
 * The Student class implements the Prototype interface.
 */
class Student implements Prototype {
    private List<String> studentList;

    public Student() {
        studentList = new ArrayList<>();
    }

    public Student(List<String> studentList) {
        this.studentList = studentList;
    }

    /**
     * Loads data into the studentList.
     */
    public void loadData() {
        studentList.add("Student 1");
        studentList.add("Student 2");
        studentList.add("Student 3");
        studentList.add("Student 4");
    }

    /**
     * Returns the studentList.
     *
     * @return List<String>
     */
    public List<String> getStudentList() {
        return studentList;
    }

    /**
     * Clones the current object.
     *
     * @return Prototype, because 'Student is a Prototype'.
     */
    @Override
    public Prototype getClone() {
        /**
         * Creating a new Student object with a cloned copy of the student list.
         * Initially, a new ArrayList is created with data from the current studentList.
         * Then, a new Student object is created with the copied ArrayList.
         * This ensures a new memory space, making it an individual entity.
         */
        List<String> studentList = new ArrayList<>(this.getStudentList());
        return new Student(studentList);
    }
}