
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//deklaracje zmiennych
        String slowo;
        int m1 = 0;
        int m2 = 5;
        int random;

//wylosowanie liczby z przedzialu <m1,m2>
        Random rand = new Random();
        random = rand.nextInt(m2 - m1) + m1;

//przypisanie do zmiennej slowo losowego slowa z listy
        lista_slow l = new lista_slow();
        slowo = l.easy[random];
        System.out.println(slowo);

//podzielenie słowa na litery
        String[] podzielone = slowo.split("");
        System.out.println(podzielone[1]);



    }
    }