package grafos;

import static grafos.Graph.graphFromFile;
import static grafos.VertexCover.*;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
       // test1();
       //test2();
       //test3();
       //test4();
       //test5();
    }

    public static void test1(){
        System.out.println("Testing class Graph");
        Graph g = graphFromFile("/home/luiz/NetBeansProjects/Grafos/src/grafos/cube.txt");
        System.out.println(g.toString());
        g.drawGraph();
    }
    
    public static void test2(){
        System.out.println("Testing class VertexCover");
        Graph g = graphFromFile("/home/luiz/NetBeansProjects/Grafos/src/grafos/dodecahedron.txt");
        g.drawGraph();
        testValidity(g);
    }
    
    public static void test3(){
        System.out.println("Testing class VertexCover");
        Graph g=Graph.graphFromFile("/home/luiz/NetBeansProjects/Grafos/src/grafos/outerplanar.txt");
        g.drawGraph();
        testGavril(g);
    }
    
    public static void test4(){
        System.out.println("Testing class VertexCover");
        Graph g=Graph.graphFromFile("/home/luiz/NetBeansProjects/Grafos/src/grafos/outerplanar.txt");
        g.drawGraph();
        testDFSTraversal(g);    
    }
    
    public static void test5(){
        System.out.println("Testing class VertexCover");
        Graph g=Graph.graphFromFile("/home/luiz/NetBeansProjects/Grafos/src/grafos/dodecahedron.txt");
        g.drawGraph();
        testSpanningTree(g);
    }

}

