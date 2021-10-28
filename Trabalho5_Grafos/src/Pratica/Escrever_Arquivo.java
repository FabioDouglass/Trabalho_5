package Pratica;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Escrever_Arquivo {
	
	
/*	public static void Guarda_Informacoes_Grafo(String file) {
		
		Document doc = new Document();
		
		try {
			 PdfWriter.getInstance(doc, new FileOutputStream(file));
			
			 doc.open();
		
			 
			 doc.add(new Paragraph("Arvore DFS"));
			 
			 Image dfs = Image.getInstance("DFS.png");
			 doc.add(dfs);
			 
			 
			 doc.add(new Paragraph("Arvore DFS Recursivo"));

			 Image dfsR = Image.getInstance("DFS_Recursivo.png");
			 doc.add(dfsR);
			 
			doc.close();
			  
		  } catch (DocumentException e) {
			  e.printStackTrace();
			  
		  } catch (FileNotFoundException e) {
			  e.printStackTrace();
			  
		  }	catch (MalformedURLException e) {
			  e.printStackTrace();
		
		  } catch (IOException e) {
			  e.printStackTrace();
		  }
	}
*/	
	
	
	
	/*public static void TESTAGEM(GRAPH gh) {
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("Dados_Grafo.txt"))){
			
			bw.write("Vertices: " + gh.Vertices() + "\n");
			bw.write("Arestas: " + gh.Arestas() + "\n");
			
			bw.write("Grau Máximo: " + gh.GrauMáximo() + "\n");
			bw.write("Grau Mínimo: " + gh.GrauMinimo() + "\n");
			bw.write("Grau Médio: " + gh.GrauMedio());
			
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} */
	
}