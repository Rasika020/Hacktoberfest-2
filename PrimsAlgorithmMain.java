package client;
import java.util.*;
public class PrimsAlgorithmMain {
	public static int findMinVertex(boolean visited[], int weight[]) {
		int minVertex = -1;
		for(int i=0;i<visited.length;i++) {
			if(!visited[i]&&(minVertex==-1 || weight[i]<weight[minVertex])) {
				minVertex = i;
				
			}
		}
		return minVertex;
	}
	public static void primsAlgo(int adjMat[][]) {
		int n = adjMat.length;
		boolean visited[] = new boolean[n];
		int parent[] = new int[n];
		int weight[] = new int[n];
		//taking source as vertex 0
		parent[0] = -1;
		weight[0] = 0;
		for(int i=0;i<n;i++) {
			weight[i] = Integer.MAX_VALUE;
			
		}
	    for(int i=0;i<n;i++) {
	    	int minVertex = findMinVertex(visited, weight);
	    	visited[minVertex] = true;
	    	//explre neighbors of min vertex
	    	for(int j=0;j<n;j++) {
	    		if(adjMat[minVertex][j]!=0&&!visited[j]) {
	    			if(weight[j]>adjMat[minVertex][j]) {
	    				// update values
	    				weight[j] = adjMat[minVertex][j];
	    				parent[j] = minVertex;
	    			}
	    		}
	    	}
	    }
	    //print the mst
	    for(int i=1;i<n;i++) {
	    	if(i<parent[i]) {
	    	System.out.println(i+" "+parent[i]+" "+weight[i]);
	    }
	    	else {
		    	System.out.println(parent[i]+" "+i+" "+weight[i]);

	    	}
	    	}
 	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int e = sc.nextInt();
		int adjMat[][] = new int [n][n];
		for(int i=0;i<e;i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int weight = sc.nextInt();
			adjMat[v1][v2] = weight;
			adjMat[v2][v1] = weight;
		}
		primsAlgo(adjMat);
	}

}
//comments are remaining and print statement of edges and vertices

