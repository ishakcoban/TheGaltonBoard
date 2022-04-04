import java.util.ArrayList;
public class sample {

    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        int numBins = 10;
        int numThreads = 20000;

        for (int i = 0; i < numBins; i++) {
            arr.add(0);

        }

        GB gb = new GB(numBins, numThreads);
        int countThreads = 0;
        int sumOfBinValues = 0;

        for (int i = 0; i < numThreads; i++) {

            Thread t = new Thread(gb);
            t.start();

            countThreads++;

        }

        for (int i = 0; i < arr.size(); i++) {

            System.out.println(i + "              " + arr.get(i));
            sumOfBinValues += arr.get(i);

        }

        if (countThreads == sumOfBinValues) {
            System.out.println("Number of requested thread: " + countThreads + "\n" + "Sum of bin values: " + sumOfBinValues + "\n" + "Nice work! Both of them are equal");

        } else {
            System.out.println("Number of requested thread: " + countThreads + "\n" + "Sum of bin values: " + sumOfBinValues + "\n" + "Bad issue! Both of them are not equal");

        }


    }
}

class GB implements Runnable {
    int numBins;
    int numThread;


    GB(int numBins, int numThread) {
        this.numBins = numBins;
        this.numThread = numThread;


    }

    @Override
    public void run() {

        int step = 1;
        int chosenIndex = 0;


        while (true) {
            synchronized (this) {

                int choseWay = (int) (Math.random() * 2);// chose Left or Right randomly. if the number is 0, left selected otherwise right selected.

                if (choseWay == 1) {
                    if (step != sample.arr.size()) {
                        chosenIndex++;
                    }

                }
                if (step == sample.arr.size()) {
                    int valueOfChosenIndex = sample.arr.get(chosenIndex);
                    sample.arr.set(chosenIndex, ++valueOfChosenIndex);
                    break;
                }

                step++;
            }


        }

        /*System.out.println();
        for (int i = 0; i < sample.arr.size(); i++) {
            System.out.print(sample.arr.get(i) + " ");

        }
        System.out.println();*/


    }
}
