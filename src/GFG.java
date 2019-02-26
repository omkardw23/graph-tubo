//Code starts here

import java.util.LinkedList;

public class GFG
{
    static class Graph
    {
        int V;
        LinkedList<Integer> adjListArray[];
        public int[] colorAtVertex;
        LinkedList<Integer> colorArray = new LinkedList<Integer>();

        Graph(int V)
        {
            this.V = V;
            adjListArray = new LinkedList[V];
            colorArray.add(1);

            for(int i = 0; i < V ; i++){
                adjListArray[i] = new LinkedList<Integer>();
                colorAtVertex[i] = colorArray.get(0);
            }
        }
    }

    static void addEdge(Graph graph, int src, int dest)
    {
        graph.adjListArray[src].add(dest);
        graph.adjListArray[dest].add(src);
    }

    static void printGraph(Graph graph)
    {
        for(int v = 0; v < graph.V; v++)
        {
            System.out.println("Adjacency list of vertex "+ v);
            System.out.print("head");
            for(Integer x: graph.adjListArray[v]){
                System.out.print(" -> "+ x);
            }
            System.out.println("\n");
        }
    }

    static boolean edgeConnectionCheck(Graph g){
        for(int i=0; i< g.V; i++){
            for(int j=0; j < g.adjListArray[i].size();j++){
                if(g.adjListArray[i].get(j) == 1){

                }   //here ..instead of 1 we will provide graph edge data to check if edge connection is complete...
            }
        }return true;
    }

    static boolean NeighbourWithoutColor(Graph graph, int vertex, int color){
        int f = 0;
        for(int i=0; i< graph.adjListArray[vertex].size();i++) {
            if (graph.colorAtVertex[graph.adjListArray[vertex].get(i)] == color){
                f = f+1;
                break;}
            else
                continue;
        }
        if(f>0)
            return false;
        else
            return true;
    }

    static int addColor(Graph graph){
        int colorAdded = 0;
        int configuration = 0;
        LinkedList<Float> m = new LinkedList<Float>();
        do{
            configuration = configuration + 1;
            {addEdge(graph,1,4); //Find how to automatically decide the sequence
                if(graph.colorAtVertex[1] == graph.colorAtVertex[4]) {
                    for(int x=0; x < graph.colorArray.size(); x++){
                        if(NeighbourWithoutColor(graph,1,graph.colorArray.get(x))){
                            graph.colorAtVertex[1] = graph.colorArray.get(x);
                            int ci = x+1;
                            break;
                        }
                        else if(NeighbourWithoutColor(graph,4,graph.colorArray.get(x))){
                            graph.colorAtVertex[4] = graph.colorArray.get(x);
                            int ci = x+1;
                            break;
                        }
                        else{
                            graph.colorArray.add(graph.colorArray.size()+1);
                            graph.colorAtVertex[1] = graph.colorArray.getLast();
                            colorAdded = colorAdded+1;
                            int ci = graph.colorArray.size();
                            break;
                        }
                    }
                }}

        }  while(edgeConnectionCheck(graph));
        return colorAdded;
    }

    public static void main(String args[])
    {
        int V = 5;
        Graph graph = new Graph(V);
        addColor(graph);
        //Find how to add sequence to edge adding

        //Find how to Sort in non-conflicting order
        int k = graph.colorArray.size() + addColor(graph); // Chromatic Number

        printGraph(graph);
    }
}
//changed