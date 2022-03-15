import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * This program demonstrates how to draw XY line chart with XYDataset
 * using JFreechart library.
 * @author www.codejava.net
 *
 */
public class XYLineChartExample extends JFrame {

	public XYLineChartExample() {
		super("XY Line Chart Example with JFreechart");
		
		JPanel chartPanel = createChartPanel();
		add(chartPanel, BorderLayout.CENTER);
		
		setSize(640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	private JPanel createChartPanel() {
		String chartTitle = "Power Chart";
		String xAxisLabel = "hour";
		String yAxisLabel = "Power";
		
		XYDataset dataset = createDataset();
		
		JFreeChart chart = ChartFactory.createXYLineChart(chartTitle, 
				xAxisLabel, yAxisLabel, dataset);
		
//		boolean showLegend = false;
//		boolean createURL = false;
//		boolean createTooltip = false;
//		
//		JFreeChart chart = ChartFactory.createXYLineChart(chartTitle, 
//				xAxisLabel, yAxisLabel, dataset, 
//				PlotOrientation.HORIZONTAL, showLegend, createTooltip, createURL);
		
		customizeChart(chart);
		
		// saves the chart as an image files
		File imageFile = new File("XYLineChart.png");
		int width = 640;
		int height = 480;
		
		try {
			ChartUtilities.saveChartAsPNG(imageFile, chart, width, height);
		} catch (IOException ex) {
			System.err.println(ex);
		}
		
		return new ChartPanel(chart);
	}


	private XYDataset createDataset() {
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries series1 = new XYSeries("Current Power");
		//XYSeries series2 = new XYSeries("Object 2");
		//XYSeries series3 = new XYSeries("Object 3");

		DBTest db = new DBTest();
				//a example day
		for(int i = 0; i <= db.parseJSON2(db.makeGETRequest("https://studev.groept.be/api/a21ib2d03/getPowerDay")).size() -1 ; i = i+1){
			series1.add(Integer.parseInt(db.parseJSONLastDay(db.makeGETRequest("https://studev.groept.be/api/a21ib2d03/getPowerDay")).get(i)), Integer.parseInt(db.parseJSON2(db.makeGETRequest("https://studev.groept.be/api/a21ib2d03/getPowerDay")).get(i)));
		}
		/*
				//last minute
		for(int i = 0; i <= db.parseJSON2(db.makeGETRequest("    https://studev.groept.be/api/a21ib2d03/getPowerLastMinute")).size() -1 ; i = i+1){
			series1.add(Integer.parseInt(db.parseJSONLastMinute(db.makeGETRequest("https://studev.groept.be/api/a21ib2d03/getPowerLastMinute")).get(i)), Integer.parseInt(db.parseJSON2(db.makeGETRequest("https://studev.groept.be/api/a21ib2d03/getPowerLastMinute")).get(i)));
		}
		*/


		/*
		series1.add(1.0, Integer.parseInt(db.parseJSON2(db.makeGETRequest("https://studev.groept.be/api/a21ib2d03/getPowerBetweenTime")).get(0)));
		series1.add(2.0, Integer.parseInt(db.parseJSON2(db.makeGETRequest("https://studev.groept.be/api/a21ib2d03/getPowerBetweenTime")).get(1)));
		series1.add(3.0, Integer.parseInt(db.parseJSON2(db.makeGETRequest("https://studev.groept.be/api/a21ib2d03/getPowerBetweenTime")).get(2)));
		series1.add(4, Integer.parseInt(db.parseJSON2(db.makeGETRequest("https://studev.groept.be/api/a21ib2d03/getPowerBetweenTime")).get(3)));
		series1.add(5, Integer.parseInt(db.parseJSON2(db.makeGETRequest("https://studev.groept.be/api/a21ib2d03/getPowerBetweenTime")).get(4)));
*/
		/*series2.add(2.0, 1.0);
		series2.add(2.5, 2.4);
		series2.add(3.2, 1.2);
		series2.add(3.9, 2.8);
		series2.add(9.6, 9.0);
		
		series3.add(1.2, 4.0);
		series3.add(2.5, 4.4);
		series3.add(3.8, 4.2);
		series3.add(4.3, 3.8);
		series3.add(9.5, 9.0);
		*/
		dataset.addSeries(series1);
		//dataset.addSeries(series2);
		//dataset.addSeries(series3);
		
		return dataset;
	}
	
	private void customizeChart(JFreeChart chart) {
		XYPlot plot = chart.getXYPlot();
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

		// sets paint color for each series
		renderer.setSeriesPaint(0, Color.RED);
		//renderer.setSeriesPaint(1, Color.GREEN);
		//renderer.setSeriesPaint(2, Color.YELLOW);

		// sets thickness for series (using strokes)
		renderer.setSeriesStroke(0, new BasicStroke(4.0f));
		//renderer.setSeriesStroke(1, new BasicStroke(3.0f));
		//renderer.setSeriesStroke(2, new BasicStroke(2.0f));
		
		// sets paint color for plot outlines
		plot.setOutlinePaint(Color.BLUE);
		plot.setOutlineStroke(new BasicStroke(2.0f));
		
		// sets renderer for lines
		plot.setRenderer(renderer);
		
		// sets plot background
		plot.setBackgroundPaint(Color.DARK_GRAY);
		
		// sets paint color for the grid lines
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.BLACK);
		
		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.BLACK);
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new XYLineChartExample().setVisible(true);
			}
		});
	}
}