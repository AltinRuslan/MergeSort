import java.util.Random;

public class MergeSort {
    private static int iterationsCount = 0;

    public static void main(String[] args) {

        Random random = new Random();
        int num = random.nextInt(50,100);
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100,10000);
        }

        long start = System.nanoTime();
        mergeSort(arr, arr.length);
        long finish = System.nanoTime();
        double ms = (double) (finish - start) / 1_000_000;
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
        System.out.println("Размер массива: " + arr.length);
        System.out.println("Прошло времени, мс: " + ms);
        System.out.println("Количество итераций: " + iterationsCount);
    }
    public static void mergeSort(int[] a, int n) {
        if (n < 2)
            return;
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];
        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        iterationsCount += mid + n - mid - 1;
        mergeSort(l, mid);
        mergeSort(r, n - mid);
        merge(a, l, r, mid, n - mid);
    }
    public static void merge(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            iterationsCount++;
            if (l[i] <= r[j]){
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            iterationsCount++;
            a[k++] = l[i++];
        }
        while (j < right) {
            iterationsCount++;
            a[k++] = r[j++];
        }
    }
}
