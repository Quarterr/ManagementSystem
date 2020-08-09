package System.Data;

import org.jfree.chart.JFreeChart;
/**
 * This class provide the methods to get different chart.
 * @author Siyi Yan, Xinyu Li
 * @version 1.0
 */
public class Chart_Getter {

	/**
	 * Get the chart.
	 * @param s the type that manager want to check
	 * @return a chart instance
	 */
	public JFreeChart getpie(String s) {
		if(s=="Soup") {  //choice of soup
			return Chart_Generater.pieChartsoup;
			  }
		else if(s=="Noodle"){
			return Chart_Generater.pieChartnoodle;
		}
		else if(s=="Spring"){
			return Chart_Generater.pieChartspring;
		}
		else {
			return Chart_Generater.pieChartspi;
		}
	}
	
	/**
	 * Get the chart.
	 * @return a bar chart instance
	 */
	public JFreeChart getbar() {
		return Chart_Generater.barChartadd;
	}
}
