import java.util.Scanner;
import java.io.File;

public class ThreeSum {
    public static int count(int[] a) {
        int N = a.length;

        int count = 0;

        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++)
                for (int k = j + 1; k < N; k++)
                    if (a[i] + a[j] + a[k] == 0) {
                        count++;
                    }
        return count;
    }

    public static int[] getNumbers(String path) throws java.io.FileNotFoundException
    {
      Scanner scanner = new Scanner(new File(path));
      try
      {
        int [] tall = new int [100];
        int i = 0;
        while(scanner.hasNextInt())
        {
          tall[i++] = scanner.nextInt();
        }
        return tall;
      }
      catch (java.io.FileNotFoundException ex)  
      {
        int [] tall = new int [1];
        tall[0] = 0;
        return tall;
      }
    }

    public static void main(String[] args) {
      if (args.length != 0) {
        int[] a = getNumbers(args[0]);
        System.out.println(count(a));
      }
    }

}
