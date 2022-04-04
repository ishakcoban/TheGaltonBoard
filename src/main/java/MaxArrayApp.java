import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class MaxArrayApp {
    public static void main(String[] args) throws Exception {

        int[] arr = new int[]{1,5,66,8,99,-9,0,44,23};

        AtomicInteger i1 = new AtomicInteger();
        AtomicInteger i2 = new AtomicInteger();

        Thread t1 = new Thread(new MaxArray(Arrays.copyOfRange(arr,0,arr.length / 2),i1));
        Thread t2 = new Thread(new MaxArray(Arrays.copyOfRange(arr,arr.length / 2,arr.length),i2));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.printf("Max %d\n", Math.max(i1.intValue(),i2.intValue()));

    }
}
