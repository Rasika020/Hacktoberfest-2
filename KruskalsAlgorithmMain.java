package client;

import java.util.*;
/*
 we'd want to store all the edges in array so to sort the 
 array of type edge which is user defined we'd need that array
 sort function to know on what basis to compare two edges have to decide the 
 smaller and larger the comparison on which this should happen we need to specify
 that so we use Comparable interface here.
 */
class Edge implements Comparable<Edge>{
	// we are using edges as
	int v1;
	int v2;
	int weight;
	public Edge(int v1, int v2, int weight) {
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}
	
	public int compareTo(Edge o) {
		return this.weight-o.weight;
	}
}

public class KruskalsAlgorithmMain {
	public static int findParent(int v, int parent[]){
		if(v==parent[v]) {
			return v;
		}
	  return findParent(parent[v], parent);
	}

	public static Edge[] kruskalsAlgo(Edge[] edgs, int n) {
		Arrays.sort(edgs);
		Edge mst[] = new Edge[n-1];
		int parent[] = new int[n];
		for(int j=0;j<n;j++) {
			parent[j] = j;
		}
		int count = 0, i=0;
		while(count!=n-1) {
			Edge currentEdge = edgs[i];
			int v1Par = findParent(currentEdge.v1, parent);
			int v2Par = findParent(currentEdge.v2, parent);
			if(v1Par!=v2Par) {
				// including current edge
				mst[count] = currentEdge;
				count++;
				parent[v1Par] = v2Par;
			}
			i++;
		}
		return mst;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int e = sc.nextInt();
		Edge edg[] = new Edge[e];
		for(int i=0;i<e;i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int weight = sc.nextInt();
			Edge edge = new Edge(v1, v2, weight);
			edg[i] = edge;
		}
	
	Edge mst[] = kruskalsAlgo(edg, n);
	for(int i=0;i<mst.length;i++) {
		if(mst[i].v1<mst[i].v2) {
			System.out.println(mst[i].v1+" "+mst[i].v2+" "+mst[i].weight);
		}
		else {
			System.out.println(mst[i].v2+" "+mst[i].v1+" "+mst[i].weight);

		}
	}
	}
}
// comments are remaining and print statement of edges and vertices
