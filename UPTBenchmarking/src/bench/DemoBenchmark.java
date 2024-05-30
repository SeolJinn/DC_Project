package bench;

import java.util.Random;

public class DemoBenchmark implements IBenchmark {
    private int[] array;
    private int workload;

    @Override
    public void run() {
        if (array != null) {
            // Use initialized array for benchmark
            bubbleSort(array);
        } else {
            // Use workload as loop size for benchmark
            for (int i = 0; i < workload; i++) {
                // Perform some dummy operation
            }
        }
    }

    @Override
    public void run(Object... params) {
        if (params.length > 0 && params[0] instanceof int[]) {
            int[] inputArray = (int[]) params[0];
            bubbleSort(inputArray);
        } else if (params.length > 0 && params[0] instanceof Integer) {
            int loopSize = (Integer) params[0];
            for (int i = 0; i < loopSize; i++) {
                // Perform some dummy operation
            }
        } else {
            throw new IllegalArgumentException("Invalid parameters for run method.");
        }
    }

    @Override
    public void initialize(Object... params) {
        if (params.length > 0 && params[0] instanceof Integer) {
            int size = (Integer) params[0];
            array = generateRandomArray(size);
        } else if (params.length > 0 && params[0] instanceof int[]) {
            array = (int[]) params[0];
        } else {
            throw new IllegalArgumentException("Expected an integer or integer array for initialization.");
        }
    }

    @Override
    public void clean() {
        array = null;
    }

    @Override
    public void cancel() {
        // Not needed for this benchmark
    }

    private int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(); // Generate random integer
        }
        return arr;
    }

    private void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
