

public class Main {

    private static int[] id;
    private static int[] time;

    private static void QuickUnionUF(int N)
    {
        id = new int[N];
        time = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            time[i] = i;
        }
    }

    public static boolean connected(int p, int q)
    {
        return root(p) == root(q);
    }

    private static int root(int i)
    {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }

        return i;
    }

    public static void union(int p, int q)
    {
        int i = root(p);
        int j = root(q);
        if (i == j) return;
        if (time[i] < time[j]) {
            id[i] = j; time[j] += time[i];
        }
        else {
            id[j] = i; time[i] += time[j];
        }
    }

    public static void main(String[] args) {

        QuickUnionUF(10);

        union(0, 6);
        union(1, 3);

        int k = 1;
        for(int i = 0; i < id.length; i++){
            System.out.println("index i: " + i + " index k: " + k);
            while(!connected(id[i], id[k])){
                union(id[i], id[k]);

                System.out.println("connected ids: " + i + ", " + k);
                System.out.println("connected at roots: " + id[i] + ", " + id[k]);
                System.out.println("connected at time: " + time[i]);

                if(!(k >= id.length)){
                    if(i == 0){
                        k++;
                    } else {
                        k = i + 1;
                    }
                }

            }
            k = 1;
        }

    }
}

