import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TestMap {
    public static void main(String... args) {
        Map<String, Set<Character>> set = new HashMap<>();
        set.computeIfAbsent("10", k -> new HashSet<>()).add('a');
    }
}
