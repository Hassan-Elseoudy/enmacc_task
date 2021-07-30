package com.enmacc.task.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Graph {

    private Integer v;
    private HashSet<Integer>[] adjList;

    public Graph(Integer vertices) {
        this.v = vertices;
        this.adjList = new HashSet[this.v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new HashSet<>();
        }

    }

    public void addEdge(Integer u, Integer v) {
        adjList[u].add(v);
    }

}
