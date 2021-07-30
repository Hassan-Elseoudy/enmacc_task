package com.enmacc.task.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
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
        Arrays.stream(this.adjList).forEach(adj -> adj = new HashSet<>());
    }

    public void addEdge(Integer u, Integer v) {
        adjList[u].add(v);
    }

}
