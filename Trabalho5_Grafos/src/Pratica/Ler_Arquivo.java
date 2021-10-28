package Pratica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ler_Arquivo {
	
	private static GRAPH gh;
	private static Projetar_Grafo pg;
	
	
	public static void Recolher_Informacoes(String file) {
				
		pg = new Projetar_Grafo();
	
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		
			
			String value = br.readLine();
		
			gh = new GRAPH(Integer.parseInt(value));
			
			System.out.println("Total de Vertices: " + value + "\n");
			
			
			for(int x = 1; x <= Integer.parseInt(value); x++) {
				pg.addNode(String.valueOf(x));
			}
			
			
			value = br.readLine();
			
			while (value != null) {
				String[] vertex = value.split(" ");

				System.out.println(vertex[0] + " " + vertex[1]);
								
				gh.addEdge(Integer.parseInt(vertex[0]), Integer.parseInt(vertex[1]));
								
				value = br.readLine();
			}
	
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}


	public static GRAPH getGraph() {
		return gh;
	}

	public static Projetar_Grafo getProjetar_Grafo() {
		return pg;
	}
	
}