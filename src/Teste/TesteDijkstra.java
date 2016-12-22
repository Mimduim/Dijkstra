package Teste;

import Files.*;

public class TesteDijkstra {
	

	public static void main(String args[]) throws java.io.IOException {

		
		
		SearchGraphAlgorithms ga = new SearchGraphAlgorithms();

		Graph<Double, Double> mg = new ProcessGraph("graph.txt");
		

		SearchGraphAlgorithms.SearchInfo so = ga.search(TypeSearchEnum.DIJKSTRA, 16, mg);

		System.out.println("A partir do vertice 16: ");
		System.out.println("Menor Caminho para o ");

		System.out.println("Vertice " + 6 + " " + so.getPathFrom(6));

		System.out.println("\nMenor Distancia para o ");

		System.out.println("Vertice " + 6 + " " + so.getDistFrom(6));
		
	

	}

}
