package com.enmacc.task.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Graph {

    private Integer v;
    private ArrayList[] adjList;

    public Graph(Integer vertices) {
        this.v = vertices;
        this.adjList = new ArrayList[this.v];
        Arrays.stream(this.adjList).forEach(adj -> adj = new ArrayList<>());
    }

    public void addEdge(Integer u, Integer v) {
        adjList[u].add(v);
    }

}
