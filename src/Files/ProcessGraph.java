package Files;



public class ProcessGraph implements Graph<Double, Double> {

	private double[][] cost;
	

	public ProcessGraph(String fileName) throws java.io.IOException {
		java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(new java.io.File(fileName)));

		int length = Integer.parseInt(br.readLine());

		cost = new double[length][length];

		String[] line;

		for (int i = 0; i < cost.length; i++) {
			line = br.readLine().split(" ");

			for (int j = 0; j < cost.length; j++) {
				if (line[j].compareTo("*") == 0) {
					cost[i][j] = Float.MAX_VALUE;

				} else {
					cost[i][j] = Float.parseFloat(line[j]);
				}
			}
		}

		br.close();
	}

	

	public Double get(int i, int j) {
		return Double.valueOf(cost[i][j]);
	}

	public int size() {
		return cost.length;
	}

}
