package Files;

import java.util.*;

public class SearchGraphAlgorithms {

	public SearchInfo search(TypeSearchEnum type, int v, Graph<Double, Double> cost) {
		if (type == TypeSearchEnum.DIJKSTRA) {
			return this.dijkstra(v, cost);
		}
		return null;
	}

	private SearchInfo dijkstra(int v, Graph<Double, Double> cost) {
		boolean[] visited = new boolean[cost.size()];
		int[] previous = new int[cost.size()]; //
		double[] DIST = new double[cost.size()];
		double min = Float.MAX_VALUE;
		int i;

		for (i = 0; i < visited.length; i++) {
			DIST[i] = cost.get(v, i);
		}

		previous[v] = -1;
		visited[v] = true;
		DIST[v] = 0;

		int u = 0;
		for (i = 0; i < DIST.length; i++) {
			if (min > DIST[i] && !visited[i]) {
				min = DIST[i];
				u = i;
			}
		}

		previous[u] = v;
		int num = 2;

		while (num < visited.length) {
			min = Double.POSITIVE_INFINITY;

			for (i = 0; i < DIST.length; i++) {
				if (min > DIST[i] && !visited[i]) {
					min = DIST[i];
					u = i;
				}
			}

			visited[u] = true;

			num++;

			for (i = 0; i < visited.length; i++) {
				if (!visited[i]) {
					if (DIST[i] > DIST[u] + cost.get(u, i)) {
						DIST[i] = DIST[u] + cost.get(u, i);
						previous[i] = u;
					}
				}
			}
		}

		SearchInfo si = new SearchInfo(DIST);
		si.buildPaths(previous);

		return si;
	}

	public class SearchInfo {

		private ArrayList<LinkedList<Integer>> paths;

		private double[] dist;

		private SearchInfo(double[] dist) {
			paths = new ArrayList<LinkedList<Integer>>(dist.length);

			for (int i = 0; i < dist.length; i++) {
				paths.add(new LinkedList<Integer>());
			}

			this.dist = dist;
		}

		private void buildPaths(int[] before) {
			int i = 0;
			int j;
			while (i < before.length) {
				j = before[i];
				if (j == -1) {
					this.paths.get(i).addFirst(i);
					i++;
					continue;
				}

				this.paths.get(i).addFirst(i);
				this.paths.get(i).addFirst(j);

				while (j != -1) {
					if (before[j] == -1) {
						break;
					}

					this.paths.get(i).addFirst(before[j]);

					j = before[j];
				}

				i++;
			}
		}

		public LinkedList<Integer> getPathFrom(int vertex) {
			return this.paths.get(vertex);
		}

		public double getDistFrom(int vertex) {
			return this.dist[vertex];
		}
	}
}