import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        //1
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evenNumbers = filter(numbers, n -> n%2==0);
        System.out.println(evenNumbers);

        List<String> names = Arrays.asList("Ali", "Vəli", "Aysel");
        List<String> filteredNames = filter(names, n -> n.startsWith("A"));
        System.out.println(filteredNames);


        //2
        List<String> words = Arrays.asList("java", "lambda");
        System.out.println(myMap(words, s -> s.length()));

        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4);
        myForEach(numbers1, n -> System.out.print(n + " "));

        //3
        // MyPredicate
        MyPredicate<Integer> even = n -> n % 2 == 0;
        MyPredicate<Integer> compare = n -> n > 10;
        System.out.println(even.test(4));
        System.out.println(compare.test(11));

        // MyFunction
        MyFunction<String, Integer> length = s -> s.length();
        System.out.println(length.apply("java"));

        // MyConsumer
        MyConsumer<String> print = s -> System.out.println("Hello, " + s);
        print.accept("Elvira");

        // MySupplier
        MySupplier<List<String>> newList = () -> new ArrayList<>();
        List<String> list = newList.get();
        list.add("Elvira");
        System.out.println(list);

    }
    public static <T>List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        return list.stream().filter(p).toList();
    }

    /*
    myReduce: başlanğıc dəyər və birləşdirmə qaydası ilə siyahını tək dəyərə endirsin
    Nümunə:
    myReduce([1, 2, 3, 4], 0, (a, b) -> a + b) → 10
    myReduce([1, 2, 3, 4], 1, (a, b) -> a * b) → 24
    */

    public static <T, R> List<R> myMap(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        return list.stream().map(f).toList();
    }

    public static <T> void myForEach(List<T> list, Consumer<T> f) {
        List<T> result = new ArrayList<>();
        if (list == null) {
            System.out.println(result);
        }
        list.stream().forEach(f);
    }
}