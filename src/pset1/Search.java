package pset1;

import java.util.LinkedList;
import java.util.Queue;

public class Search{
	String[] cityList;
	boolean[][] edge;
	int numberOfCities;
	
	public Search()
	{
		cityList = new String[9];
		setupGraph();
	}
	public void setupGraph()
	{
		cityList[0] = "Darwin";
		cityList[1] = "Perth";
		cityList[2] = "Black Stump";
		cityList[3] = "Brisbane";
		cityList[4] = "Canbera";
		cityList[5] = "Adelaide";
		cityList[6] = "Melbourne";
		cityList[7] = "Hobert";
		cityList[8] = "Sydney";              
		numberOfCities = 9;
		edge = new boolean[numberOfCities][numberOfCities];
		edge[0][4] = edge[1][2] = true;
		edge[2][0] = edge[3][8] = true; 
		edge[4][3] = edge[4][5] = true;
		edge[4][8] = edge[5][1] = true;
		edge[5][6] = edge[6][4] = true;
		edge[6][7] = edge[7][6] = true;
		edge[8][4] = true;
	}
	public void depthTraversal()
	{
		boolean[] visited = new boolean[numberOfCities];
	
		for (int i=0; i < numberOfCities; ++i)
		{
			if (!visited[i])
			{
				System.out.println("Start: "+ cityList[i]);
		   		depthTraversal(i,visited);
		   	}
		}
	  
	  System.out.println();
	}
	public void depthTraversal(int at, boolean[] visited)
	{
		System.out.println("Current: " + cityList[at]);
		visited[at] = true;
		for (int i = 0; i < numberOfCities; ++i)
			if (edge[at][i] && !visited[i])
		    {
			    depthTraversal(i,visited);
		    }
	}
	public void breadthTraversal()
	{
		boolean[] visited = new boolean[numberOfCities];
		for (int i = 0; i < numberOfCities; ++i)
		{
			if (!visited[i])
			{
				System.out.println("Start: " + cityList[i]);
				breadthTraversal(i,visited);
			}
		}
		System.out.println();
	}
	public void breadthTraversal(int start, boolean[] visited)
	{
		Queue<Integer> list = new LinkedList<Integer>();
		list.offer(start);
		visited[start] = true;
		while (!list.isEmpty())
		{
			int at = list.poll();
			System.out.println("Current: " + cityList[at]);
			for (int i =  0; i < numberOfCities; ++i)
			{
				if (edge[at][i] && !visited[i])
				{
					list.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}
