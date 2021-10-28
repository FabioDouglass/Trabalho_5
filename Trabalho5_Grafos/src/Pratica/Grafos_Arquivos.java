package Pratica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Grafos_Arquivos {

	
	public static void main(String[] args) {
		
		
		Ler_Arquivo.Recolher_Informacoes("Grafo_1.txt");
		
		
		GRAPH gh = Ler_Arquivo.getGraph();
			
		Projetar_Grafo pg = Ler_Arquivo.getProjetar_Grafo();
		
	    		
     	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {		
			  System.out.println("\n\nDigite a raiz do grafo");   	
		      int raiz = Integer.parseInt(br.readLine());
		    
		      
		      gh.DFS_Recursive(raiz);
		      System.out.println("\n\nDFS Recursivo: " + gh.getCaminhoDFSRecursivo() + "\n");
		      
		    //  pg.Criando_Arvore(gh.getCaminhoDFSRecursivo(), gh.getParent(), "DFS_Recursivo.pdf");		    
		            
		            
		      gh.DFS(raiz);
		      System.out.println("\n\nDFS: " + gh.getCaminhoDFS() + "\n");
		      
		  //   pg.Criando_Arvore(gh.getCaminhoDFS(), gh.getParent(), "DFS.pdf");
		  
		      
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}