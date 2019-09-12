package grafos;

import java.util.*;

/**
 * This class provides methods for computing min vertex covers
 *
 * @author Luca Castelli Aleardi (INF421 2011)
 */
public class VertexCover {
	
	public boolean[] vertices;
	public Graph g;
	
	public VertexCover(Graph g) {
		this.g=g;
		this.vertices=new boolean[g.sizeVertices()];
	}
	
	public void drawVertexCover() {
		Fenetre f=new Fenetre();
		for(int i=0;i<g.vertices.length;i++) {
			for(Edge e: g.getEdges(i)) {
				f.addSegment(g.getPoint(e.getU()), g.getPoint(e.getV()));
			}
			if(vertices[i])
				f.addPoint(g.getPoint(i));
		}		
	}
	
	public void draw(LinkedList<Edge> edgeList) {
		Fenetre f=new Fenetre();
		
		for(Edge e: edgeList) {
			f.addSegment(g.getPoint(e.getU()), g.getPoint(e.getV()));
		}
	}

	/**
	 * Add a vertex to the (vertex) cover
	 */
	public void addVertexToCover(int i) {
		this.vertices[i]=true;
	}
	
	/**
	 * Check whether the vertex cover is valid (covering all edges)
	 * The time complexity should is O(E)
	 */
	public boolean checkValidity() {
		for(int i = 0; i < vertices.length; i++){
                  if(vertices[i] == true) return true;
                }
                
                return false;
	}

	/**
	 * Compute a vertex cover with Gavril's algorithm
	 * It computes a set of edges defining a maximal matching:
	 * the incident vertices provide the vertex cover.
	 */
	public void gavrilCover() {
		for(int i = 0; i < g.sizeVertices(); i++){
                    for(int j = 0; j < g.getEdges(i).size(); j++){
                        g.getEdges(i).get(j).covered = false;
                    }
                }
                
                for(int i = 0; i < g.sizeVertices(); i++){
                    int u = g.getEdges(i).getFirst().getU(), v = g.getEdges(i).getFirst().getV();
                    
                    if(!g.getEdges(i).getFirst().covered){
                        addVertexToCover(u);
                        addVertexToCover(v);
                        for(int k = 0; k < g.getEdges(i).size(); k++){
                            g.getEdges(i).get(k).covered = true;
                        }
                        
                        for(int k = 0; k < g.getEdges(v).size(); k++){
                            g.getEdges(v).get(k).covered = true;
                        }
                    }
                }
	}
	
	/**
	 * Return a String with the labels of vertices, listed according to a DFS traversal
	 * Iterative version
	 */
	public String dfsOrderIterative() {
		throw new Error("a' completer: exo 3 (facultatif)");
	}
	
	/**
	 * Return a String with the labels of vertices, listed according to a DFS traversal
	 * Recursive version
	 */
	public String dfsOrderRecursive(int v, boolean[] visited) {
            String s = new String();
            s = s + v + " ";
            
            visited[v]=true;
            
            for(int i = 0; i < g.getEdges(v).size();i++){
		int u = g.getEdges(v).get(i).getOtherExtremity(v);
	
                if(!visited[u]){
                    s += dfsOrderRecursive(u, visited);
                }
            }
		//throw new Error("a' completer: exo 3");
		
            return s;
	}
	
	/**
	 * Return a String with the labels of vertices, listed according to a DFS traversal
	 * Recursive version
	 */
	public void dfsSpanningTree(Graph tree, int ancestor, int v, boolean[] visited) {
            visited[v] = true;
	
            if(ancestor != v) tree.addEdge(ancestor, v);
            
            for(int i=0;i<g.getEdges(v).size();i++){
                int u = g.getEdges(v).get(i).getOtherExtremity(v);
		
                if(!visited[u])
                    dfsSpanningTree(tree, v, u, visited);                
            }
        }
	
	/**
	 * Return a String with the labels of vertices, listed according to a DFS traversal
	 * Recursive version
	 */
	public Graph computeSpanningTree() {
		int n=this.g.sizeVertices();
		if(n==0) {
			System.out.println("no vertices: empty graph");
			return null;
		}
		
		Graph tree=new Graph(this.g.points);
		boolean[] visited=new boolean[n];
		
		dfsSpanningTree(tree, 0, 0, visited);
		return tree;
	}


	/**
	 * Return a String with the labels of vertices, listed according to a DFS traversal
	 * Recursive version
	 */
	public String dfsOrderRecursive() {
		int n=this.g.sizeVertices();
		if(n==0)
			return "empty graph: no vertices";
		
		boolean[] visited=new boolean[n];
		return dfsOrderRecursive(0, visited);
	}

	/**
	 * Compute a vertex cover with Savage's algorithm
	 * The cover is defined by the inner nodes of the DFS spanning tree (leaves are omitted)
	 * The graph is assumed to be connected
	 */
	public void spanningTreeCover() {
		throw new Error("a' completer: exo 4");
	}

	//-----------------------------------------------------
	//----------- fonctions below deal with tests ---------
	//-----------------------------------------------------
	
	public static void main(String[] args) {
		System.out.println("Testing class VertexCover");
		Graph g=Graph.graphFromFile("dodecahedron.txt");
		//System.out.println("Graph representation \n"+g);
		g.drawGraph();
		
		//testValidity(g);
		//testGavril(g);
		//testDFSTraversal(g);
		//testSpanningTree(g);
		//testSpanningTreeCover(g);
	}
	
	public static void testValidity(Graph g) {
		VertexCover vc=new VertexCover(g);
		vc.addVertexToCover(0);
		//vc.addVertexToCover(1);
		vc.addVertexToCover(2);
		vc.addVertexToCover(3);
		vc.addVertexToCover(4);
		//vc.addVertexToCover(5);
		vc.addVertexToCover(6);
		vc.addVertexToCover(7);
		//vc.addVertexToCover(8);
		vc.addVertexToCover(9);
		vc.addVertexToCover(10);
		//vc.addVertexToCover(11);
		vc.addVertexToCover(12);
		vc.addVertexToCover(14);
		vc.addVertexToCover(16);
		vc.addVertexToCover(18);
		vc.addVertexToCover(19);
		
		System.out.print("Testing vertex cover validity... ");
		if(vc.checkValidity())
			System.out.println("ok");
		else
			System.out.println(" not valid");
		
		vc.drawVertexCover();
	}
	
	/**
	 * Testing Gavril algorithm
	 */
	public static void testGavril(Graph g) {
		System.out.print("Testing greedy algorithm ... ");
		VertexCover vc=new VertexCover(g);
		vc.gavrilCover();
		
		System.out.println("done");
		vc.drawVertexCover();
		System.out.print("Testing vertex cover validity... ");
		if(vc.checkValidity())
			System.out.println("ok");
		else
			System.out.println(" not valid");
	}
	
	/**
	 * Testing DFS traversal
	 */
	public static void testDFSTraversal(Graph g) {
		System.out.print("Testing dfs traversal ... ");
		VertexCover vc=new VertexCover(g);
		// String vertexLabelsIterative=vc.dfsOrderIterative();
		String vertexLabelsRecursive=vc.dfsOrderRecursive();
		
		System.out.println("done");
		// System.out.println("vertex labels (dfs order: iterative traversal): \n"+vertexLabelsIterative);
		System.out.println("vertex labels (dfs order: recursive traversal): \n"+vertexLabelsRecursive);
		vc.drawVertexCover();
	}

	/**
	 * Testing DFS spanning tree
	 */
	public static void testSpanningTree(Graph g) {
		System.out.print("Testing dfs spanning tree ... ");
		VertexCover vc=new VertexCover(g);
		Graph tree=vc.computeSpanningTree();
		
		System.out.println("done");
		System.out.println("dfs spanning tree: \n"+tree.toString());

		tree.drawGraph();
	}

	/**
	 * Testing DFS spanning tree
	 */
	public static void testSpanningTreeCover(Graph g) {
		System.out.print("Testing dfs spanning tree cover (Savage's algorithm)... ");
		VertexCover vc=new VertexCover(g);
		Graph tree=vc.computeSpanningTree();
		vc.spanningTreeCover();
		System.out.println("done");
		System.out.println("dfs spanning tree: \n"+tree.toString());
		vc.drawVertexCover();
		tree.drawGraph();
	}

}
