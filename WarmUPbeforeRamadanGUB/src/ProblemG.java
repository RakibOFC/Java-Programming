import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class ProblemG {

    public static void main(String[] args) throws IOException {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String number = br.readLine();

        BigInteger N = new BigInteger(number);
        BigInteger fact = new BigInteger("1");
        BigInteger i = new BigInteger("1");
        int c = 0;

        while (c < 100) {

            fact = fact.multiply(i);

            if (N.equals(fact)) {

                System.out.println(i);
            }
            c++;
            i = i.add(BigInteger.valueOf(1));
        }
    }
}
