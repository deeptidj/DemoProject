import java.util.HashMap;

public class Example {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(1,2);
        if (!hm.containsKey(1)) {
            hm.put(1,4);
        } else {
            System.out.println("Duplicate");
        }
    }
}
