//package com.example.selinazuo.indoornavigationnavigation;
//
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.NoSuchElementException;
//
//import static com.example.selinazuo.indoornavigationnavigation.Dijksta2.INFINITY;
//
//public class Graph {
//    public static final int INFINITY=Integer.MAX_VALUE;
//    private HashMap<String,Vertex> vertexMap=new HashMap<String,Vertex>();
//
//    private Vertex getVertex(String vertexName){
//        Vertex v=vertexMap.get(vertexName);
//        if(v==null)
//        {
//            v=new Vertex(vertexName);
//            vertexMap.put(vertexName,v);
//        }
//        return v;
//    }
//
//    private void clearAll(){
//        for(Iterator< Vertex> itr = vertexMap.values().iterator(); itr.hasNext();)
//        {
//            itr.next().reset();
//        }
//    }
//    private void printPath(Vertex dest){
//
//        if(dest.path!=null)
//        {
//            printPath(dest.path);
//            System.out.print(" to ");
//        }
//        System.out.print(dest.name);
//    }
//
//    public void addEdge(String sourceName,String destName){
//        Vertex v=getVertex(sourceName);
//        Vertex w=getVertex(destName);
//        v.adj.add(w);
//    }
//
//    public void printPath(String destName) throws NoSuchElementException {
//
//        System.out.print("To "+destName+": ");
//        Vertex	w=vertexMap.get(destName);
//
//        if(w==null) {
//            System.out.println("Destination vertex not found!");
//        }
//        else {
//            printPath(w);
//            System.out.println();
//        }
//    }
//
//    public void unweighted(String startName){
//
//        clearAll();
//        Vertex start=vertexMap.get(startName);
//        if(start==null)
//            throw new NoSuchElementException("Start vertex not found!");
//        LinkedList<Vertex> q=new LinkedList<Vertex>();
//        q.addLast(start);
//        start.dist=0;
//
//        while(!q.isEmpty())
//        {
//            Vertex v=q.removeFirst();
//            for(Iterator<Vertex> itr=v.adj.iterator();itr.hasNext();)
//            {
//                Vertex w=itr.next();
//                if(w.dist==INFINITY)
//                {
//                    w.dist=v.dist+1;
//                    w.path=v;
//                    q.addLast(w);
//                }
//
//            }
//        }
//    }
//}
