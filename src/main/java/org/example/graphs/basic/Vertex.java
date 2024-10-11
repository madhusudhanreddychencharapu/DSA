package org.example.graphs.basic;

import java.util.Objects;

public class Vertex {
    int num = 0;
    boolean visited = false;
    public Vertex(int num){
        this.num = num;
    }
    public Vertex(int num , boolean visited){
        this.num= num;
        this.visited = visited;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return num == vertex.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }
}
