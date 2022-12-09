import java.util.Random;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++)
        {
            int m1 = 0;
            int m2 = 5;
            int random;
            Random rand = new Random();
            random = rand.nextInt(m2 - m1) + m1;
            lista_slow l = new lista_slow();
            System.out.println(l.hard[random]);
        }
    }
    }