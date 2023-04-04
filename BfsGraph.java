//Breadth First Search
import java.util.LinkedList;
import java.util.Queue;

class BfsGraph
{
    //plhthos korufwn
    private int V;

    //dilwsi pinaka listwn, pou dexontai mono akeraies thmes.
    //anaparastash listas geitniashs
    private LinkedList<Integer> adj_list[];


    private Queue<Integer> queue;

    public BfsGraph(int v)
    {
        this.V = v;

        //dhmiourgia listas orismenou megethous
        adj_list = new LinkedList[v];

        //metapoihsh stoixeiwn listas se epimerous listes
        for (int i=0; i<v; i++)
        {
          //anathesh kenhs listas se kathe stoixeio
          //LinkedList() --> constructor
          adj_list[i] = new LinkedList<>();
        }

        queue = new LinkedList<Integer>();
    }

    //Sunarthsh pros8hkhs akmhs ston grafo
    void constructEdge(int start, int end)
    {
        // prosthiki akmhs sto telos tis listas geitniashs
        // oi akmes einai kateuthinomenes.
        adj_list[start].add(end);
    }

    void BFS(int n)
    {
        boolean nodes[] = new boolean[V];
        int a = 0;

        nodes[n] = true;
        queue.add(n);

        while (queue.size() != 0)
        {
            n = queue.poll();
            System.out.print(n + " ");

            for (int i=0; i<adj_list[n].size(); i++)
            {
                a = adj_list[n].get(i);

                if (!nodes[a])
                {
                    nodes[a] = true;
                    queue.add(a);
                }
            }
        }
    }


    public static void main(String[] args)
    {
      // dhmiourgia grafou 9 komvwn:
      // 0 1 2 3 4 5 6 7 8
      BfsGraph graph = new BfsGraph(9);

      // 0 <-- riza
      //graph.constructEdge(0, 6);
      graph.constructEdge(0, 1);
      graph.constructEdge(0, 3);
      graph.constructEdge(0, 6);
      // 1 <-- 1hs takshs apogonos
      graph.constructEdge(1, 2);
      // 2 <-- 2hs takshs apogonos && fyllo
      //-------------
      // 3 <-- 1hs takshs apogonos
      graph.constructEdge(3, 4);
      graph.constructEdge(3, 1);  //
      // 4 <-- 2hs takshs apogonos
      graph.constructEdge(4, 5);
      // 5 <-- 3hs takshs apogonos && fyllo
      //-------------
      // 6 <-- 1hs takshs apogonos
      graph.constructEdge(6, 7);
      graph.constructEdge(6, 8);
      // 7 <-- 2hs takshs apogonos && fyllo
      //-------------
      // 8 <-- 2hs takshs apogonos && fyllo
      //-------------

      //=========================

      System.out.println("Breadth First Search result: ");

      graph.BFS(0);



    }





































}
