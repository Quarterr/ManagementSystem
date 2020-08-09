package System.Data;
import java.io.*;
import java.awt.Font;  
import java.text.DecimalFormat;
import java.text.NumberFormat;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;  
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import System.Control.Chart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import java.awt.Color;

/**
 * This class provide the generate the chart that the manager can check the pie chart of each item
 * @author Siyi Yan, Xinyu Li
 * @version 1.0
 */
public class Chart_Generater {
	static JFreeChart pieChartsoup;
	static JFreeChart pieChartnoodle;
	static JFreeChart pieChartspring;
	static JFreeChart pieChartspi;
	static JFreeChart barChartadd;

	
	 /**
	 * Create the chart.
	 */
	public static void generate() {
		DefaultPieDataset dataset = Chart.getDataSet("Soup"); 
	    pieChartsoup = ChartFactory.createPieChart("Choice of Soup", dataset, true, true, true);  
	    PiePlot plot = (PiePlot) pieChartsoup.getPlot();  
	    DecimalFormat df = new DecimalFormat("0.00%");//get DecimalFormat object
 	    NumberFormat nf = NumberFormat.getNumberInstance();//get NumberFormat object
 	    StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//get StandardPieSectionLabelGenerator object
 	    plot.setLabelGenerator(sp1);//Set percentage
	    Font font = new Font("Comic Sans MS", Font.BOLD, 25);  
	    plot.setLabelFont(font);  
	    pieChartsoup.getLegend().setItemFont(font);  
	    pieChartsoup.getTitle().setFont(font);
	    plot.setBackgroundPaint(new Color(255, 204, 102));
        try {
        ChartUtilities.saveChartAsPNG(new File("src/Chart/souppic.png"), pieChartsoup, 520, 250);
        } catch (Exception ex) {
        		ex.printStackTrace();
        }
        
        DefaultPieDataset datasetnoodle = Chart.getDataSet("Noodle"); 
	    pieChartnoodle = ChartFactory.createPieChart("Choice of Noodle", datasetnoodle, true, true, true);  
	    PiePlot plotnoodle = (PiePlot) pieChartnoodle.getPlot();  
	    Font fontnoodle = new Font("Comic Sans MS", Font.BOLD, 25);  
	    plotnoodle.setLabelFont(fontnoodle);  
	    pieChartnoodle.getLegend().setItemFont(fontnoodle);  
	    pieChartnoodle.getTitle().setFont(fontnoodle);
	    DecimalFormat df1 = new DecimalFormat("0.00%");//get DecimalFormat object
 	    NumberFormat nf1 = NumberFormat.getNumberInstance();//get NumberFormat object
 	    StandardPieSectionLabelGenerator sp2 = new StandardPieSectionLabelGenerator("{0}  {2}", nf1, df1);//get StandardPieSectionLabelGenerator object
 	    plotnoodle.setLabelGenerator(sp2);//Set percentage
 	    plotnoodle.setBackgroundPaint(new Color(255, 204, 102));
 	    try {
     	ChartUtilities.saveChartAsPNG(new File("src/Chart/noodlepic.png"), pieChartnoodle, 520, 250);  //generate the picture
        } catch (Exception ex) {
        ex.printStackTrace();
     	}
 	 
 	    DefaultPieDataset datasetspring = Chart.getDataSet("Spring"); 
 	    pieChartspring = ChartFactory.createPieChart("Choice of Spring Onion", datasetspring, true, true, true);  
 	    PiePlot plotspring = (PiePlot) pieChartspring.getPlot();  
 	    Font fontspring = new Font("Comic Sans MS", Font.BOLD, 25);  
 	    plotspring.setLabelFont(fontspring);  
 	    pieChartspring.getLegend().setItemFont(fontspring);  
 	    pieChartspring.getTitle().setFont(fontspring);
 	    DecimalFormat df2 = new DecimalFormat("0.00%");//get DecimalFormat object
 	    NumberFormat nf2 = NumberFormat.getNumberInstance();//get NumberFormat object
 	    StandardPieSectionLabelGenerator sp3 = new StandardPieSectionLabelGenerator("{0}  {2}", nf2, df2);//get StandardPieSectionLabelGenerator object
 	    plotspring.setLabelGenerator(sp3);//Set percentage
 	    plotspring.setBackgroundPaint(new Color(255, 204, 102));
 	    try {
 	    ChartUtilities.saveChartAsPNG(new File("src/Chart/springpic.png"), pieChartspring, 520, 250);  //generate the picture
 	    } catch (Exception ex) {
 	    ex.printStackTrace();
 	    }
 	    
 	    DefaultPieDataset datasetspi = Chart.getDataSet("Spiciness"); 
 	    pieChartspi = ChartFactory.createPieChart("Choice of Spiciness", datasetspi, true, true, true);  
 	    PiePlot plotspi = (PiePlot) pieChartspi.getPlot();  
 	    DecimalFormat df3 = new DecimalFormat("0.00%");//get DecimalFormat object
 	    NumberFormat nf3 = NumberFormat.getNumberInstance();//get NumberFormat object
 	    StandardPieSectionLabelGenerator sp4 = new StandardPieSectionLabelGenerator("{0}  {2}", nf3, df3);//get StandardPieSectionLabelGenerator object
 	    plotspi.setLabelGenerator(sp4);//Set percentage
 	    Font fontspi = new Font("Comic Sans MS", Font.BOLD, 25);  
 	    plotspi.setLabelFont(fontspi);  
 	    pieChartspi.getLegend().setItemFont(fontspi);  
 	    pieChartspi.getTitle().setFont(fontspi);
 	    plotspi.setBackgroundPaint(new Color(255, 204, 102));
 	    try {
 	    ChartUtilities.saveChartAsPNG(new File("src/Chart/spicypic.png"), pieChartspi, 520, 250);
 	    } catch (Exception ex) {
 	    	   ex.printStackTrace();
 	    }	 
 	    
 	    CategoryDataset datasetadd = Chart.getDataSet2();
		barChartadd = ChartFactory.createBarChart3D("Choice of Add-on", "category", "quantity",  
				datasetadd,PlotOrientation.VERTICAL, true, true, true);
		CategoryPlot plotadd = (CategoryPlot) barChartadd.getPlot();
		CategoryAxis domainAxis = plotadd.getDomainAxis();
		ValueAxis rangeAxis = plotadd.getRangeAxis();
		Font font1 = new Font("Comic Sans MS", Font.BOLD, 24);
		barChartadd.getTitle().setFont(font1);
		barChartadd.getLegend().setItemFont(font1);
		plotadd.setBackgroundPaint(new Color(255, 204, 102));
		domainAxis.setLabelFont(font1);
		domainAxis.setTickLabelFont(font1);
		rangeAxis.setLabelFont(font1);
		rangeAxis.setTickLabelFont(font1);
		try {
        	ChartUtilities.saveChartAsPNG(new File("src/Chart/addpic.png"), barChartadd, 520, 250);//generate the picture
        
        } catch (Exception ex) {
        		ex.printStackTrace();
        }
	}
	
}
