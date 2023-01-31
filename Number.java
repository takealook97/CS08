import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;

public class Number {
    static int number;

    public Number(int number) {
        Number.number = number;
    }

    public interface Predicate<T> {
        boolean check(T t);

        Predicate<Boolean> isPerfect = check -> sum(factors()) - number == number;
        Predicate<Boolean> isAbundant = check -> sum(factors()) - number > number;
        Predicate<Boolean> isDeficient = check -> sum(factors()) - number < number;
        Predicate<Boolean> isPrime = check -> {
            Set<Integer> primeSet = new HashSet<>() {
                {
                    add(1);
                    add(number);
                }
            };
            return number > 1 && factors().equals(primeSet);
        };
        Predicate<Boolean> isSquared = check -> Math.sqrt(number) % 1 == 0;
    }

    public static void main(String[] args) {

    }

    public static Set<Integer> factors() {
        HashSet<Integer> factors = new HashSet<>();
        for (int pod = 1; pod <= Math.sqrt(number); pod++) {
            if (isFactor(pod)) {
                factors.add(pod);
                factors.add(number / pod);
            }
        }
        return factors;
    }

    public static boolean isFactor(int potentialFactor) {
        return number % potentialFactor == 0;
    }

    public static int sum(Set<Integer> factors) {
        Iterator iterator = factors.iterator();
        int sum = 0;
        while (iterator.hasNext()) {
            sum += (Integer) iterator.next();
        }
        return sum;
    }

//    public boolean isPerfect() {
//        return sum(factors()) - number == number;
//    }
//
//    public boolean isPrime() {
//        Set<Integer> primeSet = new HashSet<>() {
//            {
//                add(1);
//                add(number);
//            }
//        };
//        return number > 1 && factors().equals(primeSet);
//    }
//
//    public boolean isSquared() {
//        return Math.sqrt(number) % 1 == 0;
//    }
//
//    public boolean isAbundant() {
//        return sum(factors()) - number > number;
//    }
//
//    public boolean isDeficient() {
//        return sum(factors()) - number < number;
//    }
}
