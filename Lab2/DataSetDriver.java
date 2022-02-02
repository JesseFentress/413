import java.util.ArrayList;

public class DataSetDriver {
    public static void main(String[] args) {
        String a = "okaythisisme";
        String b = "fu";
        int c = 12;
        int d = 234;
        System.out.println(b.compareTo(a));
        Student s0 = new Student(0,"s0","s","s","s");
        Student s1 = new Student(1,"s1","s","s","s");
        Student s2 = new Student(2,"s2","s","s","s");
        Student s3 = new Student(3,"s3","s","s","s");
        ArrayList<Student> students = new ArrayList<>();
        students.add(s3);
        students.add(s2);
        students.add(s1);
        students.add(s0);
        ArrayList<Student> students1 = new ArrayList<>();
        students1.addAll(students);
        ArrayList<Student> students2 = new ArrayList<>();
        students2.addAll(students);
        ArrayList<Student> students3 = new ArrayList<>();
        students3.addAll(students);
        System.out.println(students);
        IDSorter idSorter = new IDSorter();
        System.out.println("Merge Sort" + idSorter.mergeSort(students));
        System.out.println(students1);
        System.out.println("Selection Sort" + idSorter.selectionSort(students1));
        System.out.println(students2);
        System.out.println("Bubble Sort" + idSorter.bubbleSort(students2, students2.size()));
        System.out.println(students3);
        System.out.println("Insertion Sort" + idSorter.insertionSort(students3));

    }
}
