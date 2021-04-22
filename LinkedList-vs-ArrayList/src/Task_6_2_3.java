import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Task_6_2_3 {

    static long[] a = new long[1_000_000];
    static long[] b = new long[1_000_000];
    static long[] c = new long[1_000_000];
    static int conts_a = 0;
    static int conts_b = 0;
    static int conts_c = 0;

    static int main_conts = 5;

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();

        addLinkedListCreate(linkedList);
        addArrayListCreate(arrayList);   // тут делаем список со 100_000 значений

        for(int i = 0; i < main_conts; i++) {
            System.out.println(i);

            addLinkedList(linkedList, 0, 5000, 1);
            addArrayList(arrayList, 0, 5000, 1);

            addLinkedList(linkedList, 45000, 50000, 2);
            addArrayList(arrayList, 45000, 50000, 2);

            addLinkedList(linkedList, 95000, 100_000, 3);
            addArrayList(arrayList, 95000, 100_000, 3);

        }
        equalsLong();
    }

    public static void addArrayListCreate(ArrayList arrayList) {
        for (int i = 0; i < 100_000; i++) {
            arrayList.add(i,i);
        }
    }

    public static void addArrayList(ArrayList arrayList, int from, int to, int flag) {
        long startTime = System.nanoTime();
        for (int i = from; i < to; i++) {
            arrayList.add(i,i);
        }
        long estimatedTime = System.nanoTime() - startTime;

        if (flag == 1) {
            a[conts_a++] = estimatedTime;
            System.out.println("a[conts_a++]" + estimatedTime);
        }
        if (flag == 2) {
            b[conts_b++] = estimatedTime;
            System.out.println("b[conts_b++]"+ estimatedTime);
        }
        if (flag == 3) {
            c[conts_c++] = estimatedTime;
            System.out.println("c[conts_c++]"+ estimatedTime+ '\n');
        }
    }
    public static void addLinkedListCreate(LinkedList linkedList) {

        for (int i = 0; i < 100_000; i++) {
            linkedList.add(i,i);
        }

    }

    public static void addLinkedList(LinkedList linkedList, int from, int to, int flag) {
        long startTime = System.nanoTime();
        for (int i = from; i < to; i++) {
            linkedList.add(i,i);
        }
        long estimatedTime = System.nanoTime() - startTime;
        if (flag == 1) {
            a[conts_a++] = estimatedTime;
            System.out.println("a[conts_a++]"+ estimatedTime);
        }
        if (flag == 2) {
            b[conts_b++] = estimatedTime;
            System.out.println("b[conts_b++]"+ estimatedTime);
        }
        if (flag == 3) {
            c[conts_c++] = estimatedTime;
            System.out.println("c[conts_c++]"+ estimatedTime);
        }
    }

    public static void equalsLong() {

        System.out.println("НАЧАЛО //1 - arrayList быстрее; 0 - linkedList - быстрее ");
        for (int i = 0; i < main_conts ; i = i + 2) {
            if (a[i] > a[i + 1] && a[i] != 0) {
                System.out.print("1 ");
            } else if (a[i] < a[i + 1] && a[i] != 0) {
                System.out.print("0 ");
            } else {

            }
        }
        System.out.println("\nСередина");
        for (int i = 0; i < main_conts; i = i + 2) {
            if (b[i] > b[i + 1] && b[i] != 0) {
                System.out.print("1 ");
            } else if (b[i] < b[i + 1] && b[i] != 0) {
                System.out.print("0 ");
            } else {

            }
        }
        System.out.println("\nКонец");
        for (int i = 0; i < main_conts ; i = i + 2) {
            if (c[i] > c[i + 1] && c[i] != 0) {
                System.out.print("1 ");
            } else if (c[i] < c[i + 1] && c[i] != 0) {
                System.out.print("0 ");
            } else {

            }
        }
    }
}
