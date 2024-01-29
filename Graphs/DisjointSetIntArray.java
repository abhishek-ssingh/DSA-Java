import java.util.*;

public class DisjointSet {
    int[] rank;
    int[] parent;
    int[] size;

    public DisjointSet(int n){
        rank = new int[n+1];
        parent = new int[n+1];
        size = new int[n+1];

        for(int i=0; i<=n; i++) {
            rank[i] = 0;
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findUPar(int u){
        if(u==parent[u])
            return u;

        //path compression
        return parent[u] = findUPar(parent[u]);
    }

    public void unionByRank(int u, int v){
        int ulpU = findUPar(u);
        int ulpV = findUPar(v);
        if(ulpV == ulpU) return;

        if(rank[ulpU] < rank[ulpV]){
            parent[ulpU] = ulpV;
        } else if (rank[ulpU] > rank[ulpV]){
            parent[ulpV] = ulpU;
        } else {
            //rank are same
            parent[ulpV] = ulpU;
            rank[ulpU]++;
        }
    }

    public void unionBySize(int u, int v){
        int ulpU = findUPar(u);
        int ulpV = findUPar(v);
        if(ulpV == ulpU) return;

        if (size[ulpU] < size[ulpV]) {
            parent[ulpU] = ulpV;
            size[ulpV] += size[ulpU];
        } else {
            parent[ulpV] = ulpU;
            size[ulpU] += size[ulpV];
        }
    }


}

class DSS{

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionBySize(1,2);
        ds.unionBySize(2,3);
        ds.unionBySize(4,5);
        ds.unionBySize(6,7);
        ds.unionBySize(5,6);

        if(ds.findUPar(3)==ds.findUPar(7))
            System.out.println("yes");
        else
            System.out.println("na ran");

        ds.unionByRank(3,7);

        if(ds.findUPar(3)==ds.findUPar(7))
            System.out.println("yes");
        else
            System.out.println("na ran");
    }
}
