package Pratica;

import java.util.LinkedList;
import java.util.Stack;


public class GRAPH {

	private LinkedList<Integer> []vertexList;
	private Integer[] distance;
	private static Integer[] parent;
	private Status[] visited;
	
	private String caminho = "";
	private String caminhoDFSRecursivo, caminhoDFS;
	
	
	public GRAPH(int n) {
		vertexList = new LinkedList[n+1];
		
		visited = new Status[vertexList.length];
		distance = new Integer[vertexList.length];
		parent = new Integer[vertexList.length];
		
		for(int x = 1; x <= n; x++) {
			vertexList[x] = new LinkedList<Integer>();
		}
	}
	
	
	public void addEdge(int source, int target) {
		if(source < 0 || source > vertexList.length) {
			 throw new ArrayIndexOutOfBoundsException("Posição de Origem Invalida");
			 
		}else if(target < 0 || target > vertexList.length) {
			 throw new ArrayIndexOutOfBoundsException("Posição de Destino Invalida");
			
		}else {
			 vertexList[source].add(target);
			 vertexList[target].add(source);
		}
	}
	
	
	
	public int Vertices() {
		return vertexList.length-1;
	}
	
	
	public int Arestas() {
		int cont = 0;
		
		for(int x = 1; x < Vertices(); x++) {
			for(int y = (x+1); y <= Vertices(); y++) {
				
				if(vertexList[x].contains(y)) {
					cont ++;
				}
			}}
		
		return cont;
	}
	
		
	
	private int Grau(int vertex) {
		return vertexList[vertex].size();
	}
	
	
	public float GrauMedio() {
		float soma = 0;
		
		for(int x = 1; x < vertexList.length; x++) {
			soma += Grau(x);
		}
		
		return (soma/Vertices());
	}
	
	
	public int GrauMáximo() {
		int maior = Grau(1);
		
		for(int x = 2; x < vertexList.length; x++) {
			if(Grau(x) > maior) {
				maior = Grau(x);
			}
		}
		
		return maior;
	}
	
	
	public int GrauMinimo() {
		int menor = Grau(1);
		
		for(int x = 2; x < vertexList.length; x++) {
			if(Grau(x) < menor) {
				menor = Grau(x);
			}
		}
		
		return menor;
	}	
	
	
	
	public void BFS(int raiz) {

		for(int x = 1; x <= this.Vertices(); x++) {
			visited[x] = Status.não_descoberto;
			distance[x] = -1;
			parent[x] = null;
		}
		
		
		LinkedList<Integer> fila = new LinkedList<Integer>();
		
		visited[raiz] = Status.descoberto;
		distance[raiz] = 0;
		fila.add(raiz);
		
		
		while(!fila.isEmpty()) {
			
			int aux = fila.poll();
			
			
			for(Integer x : vertexList[aux]) {

				if(visited[x] == Status.não_descoberto) {
					
					visited[x] = Status.descoberto;  
					parent[x] = aux;
					distance[x] = distance[aux] + 1;
									  
					fila.add(x);							  					 
				}
			}
			
			visited[aux] = Status.explorado;
		}	
	}
	
	
	
	public void DFS_Recursive(int raiz) {
		
		for(int x = 1; x <= this.Vertices(); x++) {
			visited[x] = Status.não_descoberto;
			parent[x] = null;
		}
		
		caminhoDFSRecursivo="";
		
		DFS_UTIL(raiz);
	}
	
	
	private void DFS_UTIL(int raiz) {
		
		caminhoDFSRecursivo += (raiz + " ");
		
		visited[raiz] = Status.descoberto;
		
		
		for(Integer x : vertexList[raiz]) {
			
			if(visited[x] == Status.não_descoberto) {
				parent[x] = raiz;
				DFS_UTIL(x);
			}
		}	
	}
	
	
	
	public void DFS(int raiz) {
		
		for(int x = 1; x <= this.Vertices(); x++) {
			visited[x] = Status.não_descoberto;
			parent[x] = null;
		}
		
		
		caminhoDFS = "";
		
		Stack<Integer> st = new Stack<Integer>();
		
		visited[raiz] = Status.descoberto;
		st.push(raiz);
		
		
		while(st.size() != 0) {
			
			int aux = st.pop();
			
			caminhoDFS += (aux  + " ");
			
			
			for(Integer x : vertexList[aux]) {
				
				if(visited[x] == Status.não_descoberto) {
					System.out.println(aux + " " + x);
					  parent[x] = aux;
					  visited[x] = Status.descoberto;
					
					  st.push(x);
				}
			}
		}	
	}
	
	
	public String getCaminhoDFSRecursivo() {
		return caminhoDFSRecursivo;
	}

	public String getCaminhoDFS() {
		return caminhoDFS;
	}
	
	public Integer[] getParent() {
		return parent;
	}
	
	
	
	public void GerarCaminho(int source, int target) {
		if(source == target) {
			 caminho += (source + " ");
			 
		}else if(parent[source] != null) {
			 caminho += (source + " ");
			 GerarCaminho(parent[source], target);
			
		}else {
			throw new RuntimeException("Caminho Não Identificado");
		}}
	
	
	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	
	public Integer[] getDistance() {
		return distance;
	}
	
}