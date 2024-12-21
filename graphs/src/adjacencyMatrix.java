public class adjacencyMatrix {
    public static void main(String[] args) {
        int[][] graph = {
            {0, 1, 0, 0, 1},
            {1, 0, 1, 1, 1},
            {0, 1, 0, 1, 0},
            {0, 1, 1, 0, 1},
            {1, 1, 0, 1, 0}
        };
        for (int i = 0; i < graph.length; i++) {
            System.out.print("Node " + i + " is connected to: ");
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 1) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }

        // adjmatrix from graph figure
        int n = 3, m = 3;
        int[][] adjMatrix = new int[n+1][m+1];
        // edge 1--2
        adjMatrix[1][2] = 1;
        adjMatrix[2][2] = 1;

        // edge 2--3
        adjMatrix[2][3] = 1;
        adjMatrix[3][2] = 1;

        // edge 3--1
        adjMatrix[3][1] = 1;
        adjMatrix[1][3] = 1;
    }

}