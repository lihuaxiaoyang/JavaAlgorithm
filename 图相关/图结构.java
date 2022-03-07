package 图相关;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @auther lihua
 * @create 2022-03-07 22:06
 */
public class 图结构 {


    static class Edge {
        public int weight;
        public Node from;
        public Node to;

        public Edge(int weight, Node from, Node to) {
            this.weight = weight;
            this.from = from;
            this.to = to;
        }
    }

    static class Node {
        public int value;
        public int in;
        public int out;
        public ArrayList<Node> nexts;//从自己出发相邻的点
        public ArrayList<Edge> edges;//自己所拥有的边

        public Node(int value) {
            this.value = value;
            in = 0;
            out = 0;
            nexts = new ArrayList<>();
            edges = new ArrayList<>();
        }
    }

    public static class Graph {
        public HashMap<Integer, Node> nodes;//点集，Integer表示点的编号，Node表示实际的点
        public HashSet<Edge> edges;//边集

        public Graph() {
            nodes = new HashMap<>();
            edges = new HashSet<>();
        }
    }

    //matrix 所有的边
    //N*3的矩阵
    //[from节点上面的值, to节点上面的值, weight]
    public static Graph createGrap(Integer[][] matrix) {
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            Integer from = matrix[i][0];
            Integer to = matrix[i][0];
            Integer weight = matrix[i][2];
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.containsKey(to);
            }

            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, fromNode, toNode);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(newEdge);
            graph.edges.add(newEdge);
        }
        return graph;
    }

    //图的宽度优先遍历（宽度优先遍历一般使用队列）
    public static void bfs(Node node) {

    }
}
