import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class sudoku_check_txt {

    public static void main(String[] args)
            throws IOException {
        FileReader file = new FileReader("path//to//file//.txt");
        int[] sample = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int i, j = 0;

        int count = 0;
        int[] ar = new int[81];
        while ((i = file.read()) != -1) {
            int a = Character.getNumericValue((char) i);
            if (a == -1) {
                continue;
            }
            ar[j] = a;

            j++;
        }
        file.close();


        for (int l = 0; l < 81; l++) {
            System.out.print(ar[l] + " ");
            count++;
            if (count == 9) {
                count = 0;
                System.out.println();
            }
        }
        int l = 0;
        int m = 0;
        int max_count = 9;
        //for horizontal check
        while (max_count < 81) {
            int[] newarr = new int[9];
            while (m < 9) {
                newarr[m] = ar[l];
                m++;
                l++;
            }
            m = 0;
            max_count += 9;
            Arrays.sort(newarr);
            if (arraycmp(newarr, sample)) {
            } else {
                System.out.println(" horizontal check error");
                System.exit(0);
            }

        }
        // vertical check

        i = 0;
        max_count = 0;
        while (max_count < 9) {
            l = max_count;
            int[] newarr = new int[9];
            while (l < 81) {
                newarr[i] = ar[l];
                i++;
                l += 9;
            }
            i = 0;
            Arrays.sort(newarr);
            if (arraycmp(sample, newarr)) {

            } else {
                System.out.println("vertical check error ");
                System.exit(0);
            }
            max_count++;
        }
        //square check

        m = 21;
        j = 0;
        max_count = 0;
        count = 0;
        while (max_count < 80) {
            j++;
            l = max_count;
            int[] newarr = new int[9];
            while (l < m) {
                newarr[i] = ar[l];
                i++;
                l++;
                count++;
                if (count == 3) {
                    l = l + 6;
                    count = 0;
                }
            }
            Arrays.sort(newarr);
            i = 0;
            m += 3;
            if (arraycmp(sample, newarr)) {
            } else {
                System.out.println(" square check error");
                System.exit(0);
            }
            max_count += 3;
            if (j == 3) {
                j = 0;
                max_count += 18;
                m += 18;
            }
        }
        System.out.println("the txt solution of sudoku is correct");

    }

    public static boolean arraycmp(int[] array, int[] arry) {
        if (arry.length == array.length) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == arry[i]) {
                } else
                    return false;
            }
            return true;
        }
        return false;
    }
}
