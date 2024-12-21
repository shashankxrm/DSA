import java.util.ArrayList;

public class adjacencyList {
    public static void main(String[] args) {
        int n = 3, m = 3;
        ArrayList < ArrayList < Integer >> adjList = new ArrayList < ArrayList < Integer >> ();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList< Integer >());
        }
        // edge 1--2
        adjList.get(1).add(2);
        adjList.get(2).add(1);
        // edge 2--3
        adjList.get(2).add(3);
        adjList.get(3).add(2);
        // edge 3--1
        adjList.get(3).add(1);
        adjList.get(1).add(3);

        for(int i = 1; i <= n; i++) {
            System.out.print("Node " + i + " is connected to: ");
            for(int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
