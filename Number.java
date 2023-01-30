import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;

public class Number {
    private int number;

    public Number(int number) {
        this.number = number;
    }

    public static void main(String[] args) {
        String[] arr = {"perfect", "prime", "squared", "abundant", "deficient"};
        Stream<String> stream = Arrays.stream(arr);
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

    static public int sum(Set<Integer> factors) {
        Iterator iterator = factors.iterator();
        int sum = 0;
        while (iterator.hasNext()) {
            sum += (Integer) iterator.next();
        }
        return sum;
    }

    public boolean isPerfect() {
        return sum(factors()) - number == number;
    }

    public boolean isPrime() {
        Set<Integer> primeSet = new HashSet<>() {
            {
                add(1);
                add(number);
            }
        };
        return number > 1 && factors().equals(primeSet);
    }

    public boolean isSquared() {
        return Math.sqrt(number) % 1 == 0;
    }

    public boolean isAbundant() {
        return sum(factors()) - number > number;
    }

    public boolean isDeficient() {
        return sum(factors()) - number < number;
    }
}
