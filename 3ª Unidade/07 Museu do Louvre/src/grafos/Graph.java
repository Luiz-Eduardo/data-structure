package grafos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import java.util.*;

/**
 * An implementation of a general (undirected) graph, using an adjacency list
 * representation
 *
 * @author Luca Castelli Aleardi (INF421 2011)
 */
public class Graph {

    LinkedList<Edge>[] vertices;
    Point_2[] points; // geometric coordinates for drawing the graph

    public Graph(int n) {
        this.vertices = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            this.vertices[i] = new LinkedList<Edge>();
        }
    }

    public Graph(Point_2[] points) {
        this.points = points;
        this.vertices = new LinkedList[this.points.length];
        for (int i = 0; i < points.length; i++) {
            this.vertices[i] = new LinkedList<Edge>();
        }
    }

    /**
     * return the number of vertices of the graph
     */
    public int sizeVertices() {
        return vertices.length;
    }

    public LinkedList<Edge> getEdges(int u) {
        if (u < 0 || u >= this.vertices.length) {
            throw new Error("degree: vertex index error");
        }
        return this.vertices[u];
    }

    /**
     * return the degree of a vertex
     */
    public int degree(int u) {
        if (u < 0 || u >= this.vertices.length) {
            throw new Error("degree: vertex index error");
        }
        return this.vertices[u].size();
    }

    /**
     * add an edge between vertices u and v
     */
    public void addEdge(int u, int v) {
        if (u != v && u >= 0 && u < sizeVertices() && v >= 0 && v < sizeVertices()) {
            boolean flag = false;
            for (Edge x : getEdges(u)) {
                for (Edge y : getEdges(v)) {
                    if (x.equals(y)) {
                        flag = true;
                    }
                }
            }

            if (flag == false) {
                vertices[u].add(new Edge(u, v));
                vertices[v].add(new Edge(u, v));
            }

        }
    }

    /**
     * returns the position (geometric coordinates) of a vertex
     */
    public Point_2 getPoint(int i) {
        if (i < 0 || i >= this.points.length) {
            throw new Error("getPoint: vertex index error");
        }
        return this.points[i];
    }

    /**
     * return incident relations and vertex coordinates
     */
    public String toString() {
        String ans = "";

        for (int i = 0; i < sizeVertices(); i++) {
            ans = (ans + i + ":  [ ");

            for (Edge x : vertices[i]) {
                ans = ans + x.toString() + " ";
            }

            ans = (ans + "]\n");
        }

        for (int i = 0; i < sizeVertices(); i++) {
            ans = (ans + "point " + i + ": ");

            ans = (ans + points[i].toString() + "\n");
        }
        return ans;
    }

    /**
     * draw the graph in a 2D frame
     */
    public void drawGraph() {
        Fenetre f = new Fenetre();
        for (int i = 0; i < vertices.length; i++) {
            for (Edge e : getEdges(i)) {
                f.addSegment(this.getPoint(e.getU()), this.getPoint(e.getV()));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Testing class Graph");
        Graph g = graphFromFile("delaunay.txt");
        g.addEdge(0, 4);
        g.addEdge(0, 1);
        g.addEdge(-1, 0);
        g.addEdge(0, 0);
        System.out.println(g.toString());
        g.drawGraph();
    }

    // The methods below are design to deal with input/output operations
    public static Graph graphFromFile(String filename) {
        Graph result = null;
        double x, y;
        File file;
        FileReader readfic;
        BufferedReader input;
        String line;
        System.out.println("Creating an Adjacency List Representation of a graph from a file");
        try {
            System.out.println("Opening OFF file... " + filename);
            file = new File(filename);
            readfic = new FileReader(file);
            input = new BufferedReader(readfic);

            line = input.readLine();
            StringTokenizer tok = new StringTokenizer(line);
            int nVertices = Integer.parseInt(tok.nextToken());
            int nEdges = Integer.parseInt(tok.nextToken());

            Point_2[] points = new Point_2[nVertices];
            result = new Graph(points);

            int i = 0;
            Point_2 p;
            System.out.print("Reading vertices...");
            while (i < nVertices) {
                line = input.readLine();
                tok = new StringTokenizer(line);
                //System.out.println("line "+i+" :"+line);
                x = (new Double(tok.nextToken())).doubleValue();
                y = (new Double(tok.nextToken())).doubleValue();

                p = new Point_2(x, y);
                points[i] = p;
                i++;
            }
            System.out.println("done " + nVertices + " vertices");

            //System.out.println(result);
            //line = input.readLine();
            System.out.print("Reading edges...");
            i = 0;
            while (i < nEdges) {
                if ((line = input.readLine()) == null) {
                    break;
                }
                tok = new StringTokenizer(line);

                int u = Integer.parseInt(tok.nextToken());
                int v = Integer.parseInt(tok.nextToken());
                result.addEdge(u, v);
            }
            System.out.println("done " + nEdges + " edges");
            input.close();
        } catch (FileNotFoundException e) {
            //Efichier.erreur(e);
        } catch (IOException e) {
            //Efichier.erreur(e);
        }
        System.out.println("Graph representation created");
        return result;

    }

}
