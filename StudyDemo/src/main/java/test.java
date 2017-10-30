import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Object());
        list.add(new Object());
        list.add(new Object());
        list.add(new Object());

        for (int i = 0; i < list.size(); i++) {
            for (int i1 = 0; i1 < list.size(); i1++) {
                list.remove(list.get(i1));
            }
        }
    }
}
