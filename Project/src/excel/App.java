package excel;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Excel ex = new Excel();
        List<Student> list = ex.populateClass();
        list.sort(null);

        for (Student i : list) {
            System.out.println(i.toString());
        }
    }
}
