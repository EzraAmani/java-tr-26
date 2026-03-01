package practise;

import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;

public class Main {
    public static void main(String[] args) {
        System.out.println(LocalTime.now());
        // System.out.println(new LocalTime.now());
        // MonthDay.of(28,Month.OCTOBER);
        // MonthDay.getInstance(10,28);
        // MonthDay.of(10, 28);
        // System.out.println(MonthDay.of(10, 28));

        Object obj1 = new Object();
        Object obj2 = obj1;
        Object obj3 = new Object();

        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());
        System.out.println(obj3.hashCode());

        System.out.println(obj1.equals(obj2));
        System.out.println(obj1.hashCode() == obj2.hashCode());

    }

}
