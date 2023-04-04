//Depth First Search
import java.util.LinkedList;

//Klash anaparastashs kateuthinomenou grafou
//me xrhsh listas geitniashs.
class DfsGraph
{
    //plhthos korufwn
    private int V;

    //dhlwsh listas, pou dexetai mono akeraies times.
    //anaparastash listas geitniashs
    private LinkedList<Integer> adj_list[];


    public DfsGraph(int v)
    {
        this.V = v;
        //dhmiourgia listas orismenou megethous
        adj_list = new LinkedList[v];

        //metapoihsh stoixeiwn listas se epimerous listes
        for (int i=0; i<v; i++)
        {
            //ana8esh kenhs listas se kathe stoixeio
            //LinkedList() --> constructor
            adj_list[i] = new LinkedList();
        }
    }

    //Sunarthsh pros8hkhs akmhs ston grafo
    void constructEdge(int start, int end)
    {
        // prosthiki akmhs sto telos tis listas geitniashs
        // oi akmes einai kateuthinomenes.
        adj_list[start].add(end);
    }


    void DfsUtil(int vertex, boolean explored[])
    {
        //epishmansh komvou ws diatregmenos
        explored[vertex] = true;
        //Ektupwsh komvou/korufhs
        System.out.println(vertex + " ");

        int a = 0;

        //elegxos istorikou diatregmenwn komvwn
        for (int i=0; i<adj_list[vertex].size(); i++)
        {
            a = adj_list[vertex].get(i);

            //sunexish algorithmou monon se mh diatregmenous komvous.
            if (explored[a] == false)
            {
                DfsUtil(a, explored);
            }
        }

    }

    //Sunarthsh ekkinhshs DFS algori8mou.
    //Anadromikh klhsh ths DfsUtil().
    void DFS(int vertex)
    {
        //dhmiourgia pinaka logikwn timwn
        //gia apothikeysh twn diatregmenwn komvwn.
        //Epishmansh, arxika, olwn twn korufwn ws !explored.
        boolean[] explored = new boolean[V];

        DfsUtil(vertex, explored);
    }




    public static void main(String[] args)
    {
        // dhmiourgia grafou 9 komvwn:
        // 0 1 2 3 4 5 6 7 8
        DfsGraph graph = new DfsGraph(9);
        // 0 <-- riza
        //graph.constructEdge(0, 6); //a//g
        graph.constructEdge(0, 1);
        graph.constructEdge(0, 3);
        graph.constructEdge(0, 6);
        // 1
        graph.constructEdge(1, 2);
        // 2 <-- fyllo
        //-------------
        // 3
        //graph.constructEdge(3, 0); //d
        graph.constructEdge(3, 4);
        //graph.constructEdge(3, 0); //c
        // 4
        graph.constructEdge(4, 5);
        graph.constructEdge(4, 3); //f
        // 5 <-- fyllo
        graph.constructEdge(5, 4); //f
        //-------------
        // 6
        graph.constructEdge(6, 7);
        graph.constructEdge(6, 8);
        // 7 <-- fyllo
        //-------------
        // 8 <-- fyllo
        //-------------
        System.out.println("Depth First Search result: ");
        //graph.DFS(0);
        //graph.DFS(3);   //b
        graph.DFS(5);     //e
    }



































}
