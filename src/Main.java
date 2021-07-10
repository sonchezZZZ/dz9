import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        List<String> ff = new LinkedList<>();
        StringLinkedListImpl impl = new StringLinkedListImpl();
        impl.addFirst("first");
        impl.addFirst("new first");

    }

    public static List<String> filterList(List<String> list) {
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            boolean check = list.get(i).matches("(.{1,4})([^0-9])");
            if (check) {
                resultList.add(list.get(i));
            }
        }
        return resultList;
    }

    public static List<String> findUniqueness(List<String> list) {
        List<String> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String element = list.get(i);
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }
        return newList;
    }

    public static Set<String> findUniquenessSet(List<String> list) {
        Set<String> set = new HashSet<>(list);
        return set;
    }

}

