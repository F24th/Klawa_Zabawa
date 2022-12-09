import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Random;

public class lista_slow{
    //lista łatwych słów
    public static String[] easy =
            {
                    "kot",
                    "pies",
                    "dom",
                    "lis",
                    "auto",
                    "park",
                    "mysz",
                    "pasy",
                    "okno"
            };
    //lista średnich słów
    public static String[] medium =
            {
                    "hotel",
                    "domek",
                    "salon",
                    "ślub",
                    "stolik",
                    "butla",
                    "złoto",
                    "myszka",
                    "diament",
                    "kilof",
                    "łyżka"
            };
    //lista trudnych słów
    public static String[] hard =
            {
                    "krzesło",
                    "budynek",
                    "języki",
                    "monitor",
                    "lodowiec",
                    "paralotnia",
                    "żółć",
                    "źdźbło"
            };

    //podstawowe zmienne
    static int min = 0;
    static int max_e = easy.length;
    static int max_m = medium.length;
    static int max_h = hard.length;
    static int random = 0;

    public static String los_slowa_e()
    {

        String slowo = null;
        //wylosowanie liczby z przedzialu <m1,m2>
        Random rand = new Random();
        random = rand.nextInt(max_e - min) + min;

        //przypisanie do zmiennej slowo losowego slowa z listy
        slowo = easy[random];
        return slowo;
    }
    public static String los_slowa_m()
    {

        String slowo = null;
        //wylosowanie liczby z przedzialu <m1,m2>
        Random rand = new Random();
        random = rand.nextInt(max_m - min) + min;

        //przypisanie do zmiennej slowo losowego slowa z listy
        slowo = medium[random];
        return slowo;
    }
    public static String los_slowa_h()
    {

        String slowo = null;
        //wylosowanie liczby z przedzialu <m1,m2>
        Random rand = new Random();
        random = rand.nextInt(max_h - min) + min;

        //przypisanie do zmiennej slowo losowego slowa z listy
        slowo = hard[random];
        return slowo;
    }

    public static String podzial_e()
    {
        //podzielenie słowa na litery i wypisanie każdej kolejnej litery
        String sl = los_slowa_e();
        System.out.println(sl);
        String[] podzielone = sl.split("");
        int dlugosc = sl.length();
        for (int i = 0; i < dlugosc; i++)
        {
            int d = i + 1;
            System.out.println("Litera \"" + d + "\" to jest \"" + podzielone[i] + "\".");
        }
        return sl;
    }
    public static String podzial_m()
    {
        //podzielenie słowa na litery i wypisanie każdej kolejnej litery
        String sl = los_slowa_m();
        System.out.println(sl);
        String[] podzielone = sl.split("");
        int dlugosc = sl.length();
        for (int i = 0; i < dlugosc; i++)
        {
            int d = i + 1;
            System.out.println("Litera \"" + d + "\" to jest \"" + podzielone[i] + "\".");
        }
        return sl;
    }
    public static String podzial_h()
    {
        //podzielenie słowa na litery i wypisanie każdej kolejnej litery
        String sl = los_slowa_h();
        System.out.println(sl);
        String[] podzielone = sl.split("");
        int dlugosc = sl.length();
        for (int i = 0; i < dlugosc; i++)
        {
            int d = i + 1;
            System.out.println("Litera \"" + d + "\" to jest \"" + podzielone[i] + "\".");
        }
        return sl;
    }


}
