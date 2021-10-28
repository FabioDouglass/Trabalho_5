package Pratica;

import java.awt.Color;
import java.io.File;


import org.gephi.graph.api.DirectedGraph;
import org.gephi.graph.api.Edge;
import org.gephi.graph.api.GraphController;
import org.gephi.graph.api.GraphModel;
import org.gephi.graph.api.Node;
import org.gephi.io.exporter.api.ExportController;

import org.gephi.preview.api.PreviewController;
import org.gephi.preview.api.PreviewModel;
import org.gephi.preview.api.PreviewProperty;
import org.gephi.preview.types.DependantOriginalColor;
import org.gephi.preview.types.EdgeColor;
import org.gephi.project.api.ProjectController;

import org.openide.util.Lookup;

import java.awt.Font;


public class Projetar_Grafo {
	
	
	private static ProjectController pc;
	private static GraphModel model;
	private static DirectedGraph directed;
	private static PreviewModel preview;
	
	public Projetar_Grafo() {
		pc = Lookup.getDefault().lookup(ProjectController.class);	
		Iniciar();
	}
	
		
	private void Iniciar() {
		pc.newProject();
		
		model =  Lookup.getDefault().lookup(GraphController.class).getGraphModel();
		
		directed = model.getDirectedGraph();	
		
		preview = Lookup.getDefault().lookup(PreviewController.class).getModel();
		
		preview.getProperties().putValue(PreviewProperty.SHOW_EDGES, true);
		preview.getProperties().putValue(PreviewProperty.EDGE_COLOR, new EdgeColor(Color.BLACK));
		preview.getProperties().putValue(PreviewProperty.SHOW_NODE_LABELS, true);
		preview.getProperties().putValue(PreviewProperty.SHOW_EDGE_LABELS, true);
		preview.getProperties().putValue(PreviewProperty.EDGE_LABEL_COLOR, new DependantOriginalColor(Color.RED));
		preview.getProperties().putValue(PreviewProperty.EDGE_LABEL_FONT, new Font("Arial", Font.ITALIC, 7));
		preview.getProperties().putValue(PreviewProperty.EDGE_CURVED, false);
	}
	
	
	public void addNode(String value) {
		Node n = model.factory().newNode(value);
		  
		n.setLabel(value);
		n.setColor(Color.WHITE);
		n.setSize(5);
		
		directed.addNode(n);
	} 	
	
	
	public Edge newEdge(String pos1, String pos2) {
		 Edge e = model.factory().newEdge(directed.getNode(pos1) , directed.getNode(pos2)); 

		 directed.addEdge(e);
		 
		 return e;
	}
	
	
	public void Criando_Arvore(String caminho, Integer []parents, String fileName) {
						
		String []nodes = caminho.split(" ");
		
		int mult = 0;
		
		String aux = nodes[0];
		
		
		for(int x = 1; x < nodes.length; x++) {
			
			  String parent = String.valueOf(parents[Integer.parseInt(nodes[x])]);
			
			  Edge e = directed.getEdge( directed.getNode(parent), directed.getNode(nodes[x]) );

			  
			  if(e == null) {		
				  Edge oldEdge = directed.getEdge( directed.getNode(nodes[x]), directed.getNode(parent) );
				  
				  directed.removeEdge(oldEdge);
								
				  e = newEdge(parent, nodes[x]);
			  }
			  
			  
			  e.getTarget().setX(e.getSource().x() - (20 * mult));
			  e.getTarget().setY(e.getSource().y() - 50);	
			  
			  e.setLabel("   " + x);	
			  
			  
			  if(aux != parent) {
				  mult --;
			  }else {
				  mult++;
			  }	 
		}
		
		directed.getNodes().forEach(node -> System.out.println(node.getLabel() + " - ( x: " + node.x() + "  y: " + node.y() + " )")); 	
		directed.getEdges().forEach(edge -> System.out.println("\n" + edge.getLabel() + " -> " + edge.getSource().getLabel() + " , " + edge.getTarget().getLabel())); 
	
		COLOCAR_ARQUIVO(fileName);
	}

	
	private void COLOCAR_ARQUIVO(String name) {
	
		ExportController ec = Lookup.getDefault().lookup(ExportController.class);
		
		try {
			
			ec.exportFile( new File(name) );

		}catch(Exception e) {
			 e.printStackTrace();
		}
		
		directed.getNodes().forEach(x -> x.setPosition(0,0));
		directed.getEdges().forEach(x -> x.setLabel(null));
	}

  
}