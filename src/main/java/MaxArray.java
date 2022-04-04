
import java.util.concurrent.atomic.AtomicInteger;

public class MaxArray implements Runnable{
    private int[] values;
    private AtomicInteger max;

    MaxArray(int[] values,AtomicInteger max){
        this.values = values;
        this.max = max;

    }
    @Override
    public void run() {
        int tempMax = Integer.MIN_VALUE;

        for(int v: values){
            if(v > tempMax) tempMax = v;
        }

        max.set(tempMax);


    }
}
