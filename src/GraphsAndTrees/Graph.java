package GraphsAndTrees;

import java.util.*;

public class Graph {
    static DefaultDict<Integer, List<Integer>> graph;

    Graph() {
        graph =
                new DefaultDict<Integer, List<Integer>>(ArrayList.class);
    }

    //from v1 to v2
    static void insertEdge(int v1, int v2) {
        graph.get(v1).add(v2);
    }

    static void DFS(int startNode){
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> st = new Stack<>();
        st.push(startNode);

        while(st.size()>0){
            int cur = st.peek();
            st.pop();

            if(!visited.contains(cur)){
                System.out.println("Not visited " + cur);
                visited.add(cur);
            }

            for(int vertex : graph.get(cur)){ //every node that has children , contains a list of values    v1->[v2,v3,v4]
                if(!visited.contains(vertex)) {
                    st.add(vertex);
                }
            }
        }
    }

    // start Node
    static void BFS(int s) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(s);

        visited.add(s);
        while(!queue.isEmpty()){
            int u = queue.peek(); //get the first element
            queue.remove();
            System.out.println(" " + u);

            for(int v : graph.get(u)) {
                if(!visited.contains(v)) {
                    queue.add(v);
                    visited.add(v);
                }
            }
        }
    }
    public static void main(String[] args) {
        graph = new DefaultDict<Integer, List<Integer>>(ArrayList.class);
        insertEdge(2,1);
        insertEdge(2,5);
        insertEdge(5,6);
        insertEdge(5,8);
        insertEdge(6,9);

        //DFS(2);

        BFS(2);

    }
}
