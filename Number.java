import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Number {
    private int number;

    public Number(int number) {
        this.number = number;
    }

    public static void main(String[] args) {
        Number alpha1 = new Number(10);
        Number alpha2 = new Number(6);
        Number prime1 = new Number(10);
        Number prime2 = new Number(7);
        System.out.println(alpha1.isPerfect());
        System.out.println(alpha2.isPerfect());
        System.out.println(prime1.isPrime());
        System.out.println(prime2.isPrime());

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

    public boolean isAbundant() {
        return sum(factors()) - number > number;
    }

    public boolean isDeficient() {
        return sum(factors()) - number < number;
    }

    public boolean isSquared() {
        return Math.sqrt(number) % 1 == 0;
    }
}
