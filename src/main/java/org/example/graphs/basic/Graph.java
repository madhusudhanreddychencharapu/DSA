package org.example.graphs.basic;

import java.util.*;

public class Graph {
   /* public static void main(String[] args) {
        Graph g = createGraph();
        for(Vertex v : g.getAdjVertices(3)){
            System.out.println(v.num);
        }
        System.out.println("I am printing the DFS");
        g.depthForSearch(g);
        for(Vertex vertex : result) {
            System.out.println(vertex.num);
        }
    }
    // Adding a vertex
    // choosing a representation of the graph(adjacency list or matrix)
     /*
     * Here we are choosing the adjacency list representation using the
     * hash map
     *
    public static Map<Vertex, List<Vertex>> adjVertices = new HashMap<>();
    public static List<Vertex> result = new LinkedList<>();
    // adding vertices
    public void addVertex(int num){
        adjVertices.putIfAbsent(new Vertex(num),new ArrayList<>());
    }
    // deleting the vertices
    public void deleteVertex(int num){
        Vertex v = new Vertex(num);
        //first deletion of the edges in the adjacency list
        adjVertices.values().stream().forEach(e -> e.remove(v));
        adjVertices.remove(v);
    }
    // adding the edges


    // deleting the edges
    public void deleteEdge(int num1 , int num2){
        Vertex v1 = new Vertex(num1);
        Vertex v2 = new Vertex(num2);
        List<Vertex> eV1 = adjVertices.get(v1);
        List<Vertex> eV2 = adjVertices.get(v2);
        if(eV1 != null){
            eV1.remove(v1);
        }
        if(eV2 != null){
            eV2.remove(v2);
        }
    }
    //Creation of the simple Graph
    public static Graph createGraph(){
        Graph graph = new Graph();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);

        //adding the edges
        graph.addEdge(1,4);
        graph.addEdge(1,2);
        graph.addEdge(2,4);
        graph.addEdge(2,3);
        graph.addEdge(4,5);
        graph.addEdge(3,5);
        return graph;
    }
    // Get adjacent vertices
    public List<Vertex> getAdjVertices(int num){
        return adjVertices.get(new Vertex(num));
    }

    public void depthForSearch(Graph g){
        Set<Vertex> vertices = adjVertices.keySet();
        for( Vertex v : vertices){
            v.visited = false;
        }
        for(Vertex v : vertices){
            if(!v.visited) {
                explore(g, v);
            }
        }
    }
    public void explore(Graph g , Vertex vertex){
        vertex.visited = true;
        System.out.println(vertex.num + " i am currently at this vertex");
        result.add(vertex);
        for(Vertex v : adjVertices.get(vertex)){
            if(!v.visited){
                explore(g,v);
            }else{
                System.out.println(v.num+ "The vertex is already visited");
            }
        }
    }*/

}
