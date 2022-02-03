import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class DataSetDriver {
    public static void main(String[] args) {
        ArrayList<Student> students1 = new ArrayList<Student>();
        IDSorter idSorter = new IDSorter();
        FirstNameSorter fnSorter = new FirstNameSorter();
        LastNameSorter lnSorter = new LastNameSorter();
        try {
            Object file = new JSONParser().parse(new FileReader("students.json"));
            JSONObject json = (JSONObject) file;        
            JSONArray array = (JSONArray) json.get("students");
            for (int i = 0; i < array.size(); i++) {
                JSONObject newStudent = (JSONObject)array.get(i);
                int id = ((Long)newStudent.get("student_id")).intValue();
                String fn = (String)newStudent.get("first_name"); 
                String ln = (String)newStudent.get("last_name"); 
                String email = (String)newStudent.get("email"); 
                String major = (String)newStudent.get("major");
                students1.add(new Student(id, fn, ln, email, major));
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        ArrayList<Student> students2 = new ArrayList<Student>();
        ArrayList<Student> students3 = new ArrayList<Student>();
        ArrayList<Student> students4 = new ArrayList<Student>();
        students2.addAll(students1);
        students3.addAll(students1);
        students4.addAll(students1);

        ArrayList<Student> fn1 = new ArrayList<Student>();
        ArrayList<Student> fn2 = new ArrayList<Student>();
        ArrayList<Student> fn3 = new ArrayList<Student>();
        ArrayList<Student> fn4 = new ArrayList<Student>();
        fn1.addAll(students1);
        fn2.addAll(students1);
        fn3.addAll(students1);
        fn4.addAll(students1);

        ArrayList<Student> ln1 = new ArrayList<Student>();
        ArrayList<Student> ln2 = new ArrayList<Student>();
        ArrayList<Student> ln3 = new ArrayList<Student>();
        ArrayList<Student> ln4 = new ArrayList<Student>();
        ln1.addAll(students1);
        ln2.addAll(students1);
        ln3.addAll(students1);
        ln4.addAll(students1);

        long start;

        System.out.println("Linear Search (ID):");
        start = System.nanoTime();
        for (int i = 0; i < students1.size(); i++) {
            if (students1.get(i).getId() == 12342) {
                break;
            }
        }
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");

        System.out.println("Linear Search (FN):");
        start = System.nanoTime();
        for (int i = 0; i < students1.size(); i++) {
            if (students1.get(i).getFn().equals("Quinn")) {
                break;
            }
        }
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");

        System.out.println("Linear Search (LN):");
        start = System.nanoTime();
        for (int i = 0; i < students1.size(); i++) {
            if (students1.get(i).getLn().equals("Jameson")) {
                break;
            }
        }
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        System.out.println("Merge Sort (ID): \n" + idSorter.mergeSort(students1));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();
        start = System.nanoTime();
        System.out.println("Selection Sort (ID): \n" + idSorter.selectionSort(students2));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();
        start = System.nanoTime();
        System.out.println("Bubble Sort (ID): \n" + idSorter.bubbleSort(students3, students3.size()));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();
        start = System.nanoTime();
        System.out.println("Insertion Sort (ID): \n" + idSorter.insertionSort(students4));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();

        start = System.nanoTime();
        System.out.println("Merge Sort (FN): \n" + fnSorter.mergeSort(fn1));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();
        start = System.nanoTime();
        System.out.println("Selection Sort (FN): \n" + fnSorter.selectionSort(fn2));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();
        start = System.nanoTime();
        System.out.println("Bubble Sort (FN): \n" + fnSorter.bubbleSort(fn3, fn3.size()));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();
        start = System.nanoTime();
        System.out.println("Insertion Sort (FN): \n" + fnSorter.insertionSort(fn4));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();

        start = System.nanoTime();
        System.out.println("Merge Sort (LN): \n" + lnSorter.mergeSort(ln1));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();
        start = System.nanoTime();
        System.out.println("Selection Sort (LN): \n" + lnSorter.selectionSort(ln2));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();
        start = System.nanoTime();
        System.out.println("Bubble Sort (LN): \n" + lnSorter.bubbleSort(ln3, ln3.size()));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();
        start = System.nanoTime();
        System.out.println("Insertion Sort (LN): \n" + lnSorter.insertionSort(ln4));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();

        System.out.println("###########################");
        System.out.println("####### Sorted Data #######");
        System.out.println("###########################");

        start = System.nanoTime();
        System.out.println("Merge Sort (ID): \n" + idSorter.mergeSort(students1));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();
        start = System.nanoTime();
        System.out.println("Selection Sort (ID): \n" + idSorter.selectionSort(students2));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();
        start = System.nanoTime();
        System.out.println("Bubble Sort (ID): \n" + idSorter.bubbleSort(students3, students3.size()));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();
        start = System.nanoTime();
        System.out.println("Insertion Sort (ID): \n" + idSorter.insertionSort(students4));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();

        start = System.nanoTime();
        System.out.println("Merge Sort (FN): \n" + fnSorter.mergeSort(fn1));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();
        start = System.nanoTime();
        System.out.println("Selection Sort (FN): \n" + fnSorter.selectionSort(fn2));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();
        start = System.nanoTime();
        System.out.println("Bubble Sort (FN): \n" + fnSorter.bubbleSort(fn3, fn3.size()));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();
        start = System.nanoTime();
        System.out.println("Insertion Sort (FN): \n" + fnSorter.insertionSort(fn4));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();

        start = System.nanoTime();
        System.out.println("Merge Sort (LN): \n" + lnSorter.mergeSort(ln1));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();
        start = System.nanoTime();
        System.out.println("Selection Sort (LN): \n" + lnSorter.selectionSort(ln2));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();
        start = System.nanoTime();
        System.out.println("Bubble Sort (LN): \n" + lnSorter.bubbleSort(ln3, ln3.size()));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();
        start = System.nanoTime();
        System.out.println("Insertion Sort (LN): \n" + lnSorter.insertionSort(ln4));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        
        System.out.println("###########################");
        System.out.println("######*# Same Data ########");
        System.out.println("###########################");

        ArrayList<Student> same = new ArrayList<Student>();

        for (int i = 0; i < 20; i++) {
            same.add(students1.get(0));
        }
        
        start = System.nanoTime();
        System.out.println("Merge Sort (ID): \n" + idSorter.mergeSort(same));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();
        start = System.nanoTime();
        System.out.println("Selection Sort (ID): \n" + idSorter.selectionSort(same));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();
        start = System.nanoTime();
        System.out.println("Bubble Sort (ID): \n" + idSorter.bubbleSort(same, same.size()));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();
        start = System.nanoTime();
        System.out.println("Insertion Sort (ID): \n" + idSorter.insertionSort(same));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();

        start = System.nanoTime();
        System.out.println("Merge Sort (FN): \n" + fnSorter.mergeSort(same));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();
        start = System.nanoTime();
        System.out.println("Selection Sort (FN): \n" + fnSorter.selectionSort(same));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();
        start = System.nanoTime();
        System.out.println("Bubble Sort (FN): \n" + fnSorter.bubbleSort(same, same.size()));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();
        start = System.nanoTime();
        System.out.println("Insertion Sort (FN): \n" + fnSorter.insertionSort(same));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();

        start = System.nanoTime();
        System.out.println("Merge Sort (LN): \n" + lnSorter.mergeSort(same));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();
        start = System.nanoTime();
        System.out.println("Selection Sort (LN): \n" + lnSorter.selectionSort(same));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();
        start = System.nanoTime();
        System.out.println("Bubble Sort (LN): \n" + lnSorter.bubbleSort(same, same.size()));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");
        System.out.println();
        start = System.nanoTime();
        System.out.println("Insertion Sort (LN): \n" + lnSorter.insertionSort(same));
        System.out.println("Elapsed Time: " + (System.nanoTime() - start) + " ns");        
    }
}
