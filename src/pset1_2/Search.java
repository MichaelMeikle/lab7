package pset1_2;

import java.util.*;
public class Search{
	public static void main(String[] args){
		Search obj = new Search();
		GraphNode root = obj.generateGraph();
		//calling methods
		obj.calculateBFS(root);
		Search obj2 = new Search();
		GraphNode root2 = obj2.generateGraph();
		obj2.calculateDFS(root2);
	}
	private class GraphNode {
	
		private String city;
		private GraphNode left, right;
		private boolean visited;
	
		private GraphNode(String city) {
		this.city = city;
		this.left = this.right = null;
		}
	}
	
	/* creating graph with city names */
	public GraphNode generateGraph() {
		
		GraphNode rootNode = new GraphNode("Sydney");
		GraphNode a = new GraphNode("Brisbane");
		GraphNode b = new GraphNode("Caniberra");
		GraphNode c = new GraphNode("Adelaide");
		GraphNode d = new GraphNode("Melbourne");
		GraphNode e = new GraphNode("Perth");
		GraphNode f = new GraphNode("Hobart");
		GraphNode g = new GraphNode("Black Stump");
		GraphNode h = new GraphNode("Darwin");
		rootNode.left = a;
		rootNode.right = b;
		b.left = a;
		b.right = c;
		c.left = d;
		c.right = e;
		d.left = b;
		d.right = f;
		e.left = g;
		g.left = h;
		return rootNode;
	}
	
	private GraphNode getUnvisitNode(GraphNode node) {
	if (node.left != null) {
	if (!node.left.visited) {
	return node.left;
	}
	}
	if (node.right != null) {
	if (!node.right.visited) {
	return node.right;
	}
	}
	return null;
	}
	
	public void calculateBFS(GraphNode rootNode) {
		System.out.println("*************** BFS ******************");
		Queue<GraphNode> bfs_queue = new LinkedList<>();
		bfs_queue.add(rootNode);
		System.out.println(rootNode.city);
		while (!bfs_queue.isEmpty()) {
			GraphNode node = bfs_queue.remove(); // removing top element
			GraphNode child = null;
			while ((child = getUnvisitNode(node)) != null) {
				child.visited = true;
				System.out.println(child.city);
				bfs_queue.add(child);
			}
		}
	}
	public void calculateDFS(GraphNode rootNode) {
	System.out.println("\n*************** DFS ******************");
	Stack<GraphNode> dfs_stack = new Stack<>();
	dfs_stack.push(rootNode);
	rootNode.visited = true;
	System.out.println(rootNode.city);
	while (!dfs_stack.isEmpty()) {
	GraphNode node = dfs_stack.peek(); // getting top element, but not removing
	GraphNode child = getUnvisitNode(node);
	if (child != null) {
	child.visited = true;
	System.out.println(child.city);
	dfs_stack.push(child);
	} else {
	dfs_stack.pop();
	}
	}
	}

}