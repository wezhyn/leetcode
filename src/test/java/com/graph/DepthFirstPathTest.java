package com.graph;

import org.junit.Test;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author wezhyn
 * @since 04.29.2020
 */
public class DepthFirstPathTest {

    @Test
    public void path() throws IOException {
        Scanner scanner = new Scanner(System.in);
        Graph graph = new Graph(scanner);
        SimplePathSearch path = new DepthFirstPath(graph);
        System.out.println(path.path(0, 2));
    }
}