import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * @author nuddler
 *
 */
public class MultiLayerPerceptronProject {

	static List<Double> points = new ArrayList<Double>();
	static MultiLayerPerceptron multiLayerPerceptron;

	public static void main(String[] args) throws FileNotFoundException {
		
		List<ArrayList<Double>> inputList = readInputFromFile();
		
		int hiddenLayerNeuronCount = 3;
		int outputLayerNeuronCount = 4;
		int inputLayerNeuronCount = 4;
		double lerningFactory = 0.1;
		boolean bias = true;
		
		multiLayerPerceptron = new MultiLayerPerceptron(inputList,inputLayerNeuronCount,hiddenLayerNeuronCount,outputLayerNeuronCount,lerningFactory,bias);
		
		multiLayerPerceptron.learn();
		
		String title = "Ilosc neuronow w warstwie ukrytej: "+hiddenLayerNeuronCount+
				" bias: "+bias;
		createChart(multiLayerPerceptron.getErrorList(), title);
	}
	
	public static ArrayList<ArrayList<Double>> readInputFromFile() throws FileNotFoundException{
		ArrayList<ArrayList<Double>> input = new ArrayList<ArrayList<Double>>();
		Scanner scanner = new Scanner(new File("input"));
		ArrayList<Double> row = new ArrayList<Double>();
		
		int i = 1;
		while(scanner.hasNextDouble()){			
			row.add(scanner.nextDouble());
			
			if (i%4==0){
				ArrayList<Double> temp = new ArrayList<Double>(row);
				input.add(temp);
				row.clear();
			}
			i++;
		}
		return input;	
	}
	public static void createChart(List<Double> errors, String title) {

	    final XYSeries series = new XYSeries("Random Data");
	    
	    for (int i=0; i<errors.size(); i++) {
			series.add(i+1, errors.get(i));
		}

	    XYSeriesCollection dataset = new XYSeriesCollection();
	    dataset.addSeries(series);
	    // Generate the graph
	    JFreeChart chart = ChartFactory.createXYLineChart(
		    title, // Title
		    "Numer epoki", // x-axis Label
		    "B³¹d", // y-axis Label
		    dataset, // Dataset
		    PlotOrientation.VERTICAL, // Plot Orientation
		    false, // Show Legend
		    true, // Use tooltips
		    false // Configure chart to generate URLs?
	    );
	    ChartFrame frame1=new ChartFrame("XYArea Chart",chart);
		frame1.setVisible(true);
		frame1.setSize(400,400);
//	    }


	}

}
