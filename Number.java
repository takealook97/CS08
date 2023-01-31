import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;

public class Number {
    static int number;

    public interface Calculator {
        boolean pefrect = false;

        boolean abundant = false;

        boolean deficient = false;

        boolean prime = false;

        boolean square = false;
    }

    public Number(int number) {
        Number.number = number;
    }
    public static void main(String[] args) {
        Calculator.pefrect = check -> sum(new Number(number).factors()) - number == number;
        Calculator.abundant = check -> sum(factors()) - number > number;
        Calculator.deficient = check -> sum(factors()) - number < number;
        Calculator.prime = check -> {
            Set<Integer> primeSet = new HashSet<>() {
                {
                    add(1);
                    add(number);
                }
            };
            number > 1 && factors().equals(primeSet);
        };
        Calculator.square = check -> Math.sqrt(number) % 1 == 0;
    }

    public Set<Integer> factors() {
        HashSet<Integer> factors = new HashSet<>();
        for (int pod = 1; pod <= Math.sqrt(number); pod++) {
            if (isFactor(pod)) {
                factors.add(pod);
                factors.add(number / pod);
            }
        }
        return factors;
    }

    public boolean isFactor(int potentialFactor) {
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
