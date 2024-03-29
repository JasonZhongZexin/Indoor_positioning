package com.example.selinazuo.indoornavigationnavigation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;




public class Dijksta2 {
    public static int INFINITY = 99999;
    public static Map<String, Vertex> vertexMap = new HashMap<String, Vertex>();

    // 边距
    static class Edge {
        public Vertex dest;
        public double cost;

        public Edge(Vertex d, double c) {
            this.dest = d;
            this.cost = c;
        }

    }

    static class Vertex implements Comparable<Vertex> {
        public String name;
        public List<Edge> adj;
        public double dist;
        public Vertex prev;
        public int scratch;
        public boolean visited;

        public Vertex(String nm) {
            this.name = nm;
            adj = new ArrayList<Edge>();
            reset();
        }

        public void reset() {
            visited = false;
            dist = Dijksta2.INFINITY;
        }

        @Override
        public int compareTo(Vertex o) {
            double c = o.dist;

            return dist < c ? -1 : dist > c ? 1 : 0;
        }

    }

    public static String[] dijkstra(String startName, String endName) {
        PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();// 该队列以权值升序排列，因为Vertex实现Comparable接口
        Vertex start = vertexMap.get(startName);
        start.dist = 0;
        for (Vertex v : vertexMap.values())
            pq.add(v);
        int seenNum = 0;
        while (!pq.isEmpty() && seenNum < vertexMap.size()) {
            Vertex v = pq.remove();
            if (v.name.equals(endName)) { // 恰好是自己要找的那个点
//                System.out.println(startName + "---->" + v.name + ":" + v.dist); // 最短距离
//                System.out.println(getPreNames(v)); // 最短路线
                return getPreNames(v) ;
            }
            if (v.scratch != 0)
                continue;
            v.scratch = 1;
            seenNum++;

            for (Edge e : v.adj) {
                Vertex w = e.dest;
                double v_to_w = e.cost;
                if (w.dist > v.dist + v_to_w) {
                    w.dist = v.dist + v_to_w;
                    w.prev = v;
                    pq.remove(w);// 出队
                    pq.add(w);// 按优先级插在队头，先插入的在队头，依次往后

                }
            }
        }
        while (pq.peek() != null) {
            System.out.println(pq.poll());
            return pq.poll().toString().split(",");
        }
        return new String[]{};
    }

    public static String[] getPreNames(Vertex v) {
        String routeEndName = v.name;
        StringBuilder sb = new StringBuilder();
        while (v.prev != null) {
            sb.append(v.prev.name + ",");
            v = v.prev;
        }
        String reverseRoute = routeEndName + "," + sb.toString();
        String[] reverseArray = reverseRoute.split(",");

        return reverseArray;
    }
}
