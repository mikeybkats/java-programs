/*
Social network connectivity. Given a social network containing nn members and a
log file containing mm timestamps at which times pairs of members formed friendships,
design an algorithm to determine the earliest time at which all members are connected
(i.e., every member is a friend of a friend of a friend ... of a friend). Assume that
the log file is sorted by timestamp and that friendship is an equivalence relation.
The running time of your algorithm should be m \log nmlogn or better and use extra
space proportional to nn.
 */

public class UnionFindSocialNetwork {

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

        QuickUnionUF(7);

        union(0, 1);
        union(0, 2);
        union(0, 3);
        union(0, 4);
        union(0, 6);

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



