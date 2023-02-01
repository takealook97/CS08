import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Number {
    private final Function<Integer, String> getType = number -> Stream.of(
                    number + " : ",
                    isPerfect(number) ? "perfect, " : "",
                    isAbundant(number) ? "abundant, " : "",
                    isDeficient(number) ? "deficient, " : "",
                    isPrime(number) ? "prime, " : "",
                    isSquared(number) ? "squared, " : ""
            )
            .reduce((a, b) -> a + b)
            .map(a -> a.substring(0, a.length() - 2) + "\n")
            .get();

    public static void main(String[] args) {
        System.out.println(new Number().classifyNum());
    }


    public Set<Integer> factors(int number) {
        HashSet<Integer> factors = new HashSet<>();
        IntStream.range(1, (int) Math.sqrt((number)) + 1)
                .filter(potentialFactor -> isFactor(number, potentialFactor))
                .forEach(i -> {
                    factors.add(number / i);
                    factors.add(i);
                });
        return factors;
    }

    static public int sum(Set<Integer> factors) {
        return factors.stream().reduce(0, Integer::sum);
    }
    public boolean isFactor(int number, int potentialFactor) {
        return number % potentialFactor == 0;
    }
    public boolean isPerfect(int number) {
        return sum(factors(number)) - number == number;
    }

    public boolean isAbundant(int number) {
        return sum(factors(number)) - number > number;
    }

    public boolean isDeficient(int number) {
        return sum(factors(number)) - number < number;
    }

    public boolean isPrime(int number) {
        Set<Integer> primeSet = new HashSet<>() {
            {
                add(1);
                add(number);
            }
        };
        return number > 1 && factors(number).equals(primeSet);
    }

    public boolean isSquared(int number) {
        return Math.sqrt(number) % 1 == 0;
    }


    public String classifyNum() {
        return IntStream.range(2, 101)
                .mapToObj(getType::apply).reduce((a, b) -> a + b).get();
    }
}