package graphs;

// LC 133 : Clone Graph
// Given a reference of a node in a connected undirected graph.
// Return a deep copy (clone) of the graph.
// Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.


import java.util.HashMap;

public class cloneGraph {
    public Node cloneFunc(Node node, HashMap<Node, Node> mp){
        Node newNode = new Node(node.val);
        mp.put(node, newNode);
        for(Node nei: node.neighbors){
            if(mp.containsKey(nei)){
                newNode.neighbors.add(mp.get(nei));
            }else{
                newNode.neighbors.add(cloneFunc(nei, mp));
            }
        }
        return newNode;
    }

    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        HashMap<Node, Node> mp = new HashMap<Node, Node>();
        return cloneFunc(node, mp);
    }
}
