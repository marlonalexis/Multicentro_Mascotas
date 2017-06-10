/*    */ package org.primefaces.sentinel;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import javax.annotation.PostConstruct;
/*    */ import javax.faces.bean.ManagedBean;
/*    */ import org.primefaces.model.chart.Axis;
/*    */ import org.primefaces.model.chart.AxisType;
/*    */ import org.primefaces.model.chart.LineChartModel;
/*    */ import org.primefaces.model.chart.LineChartSeries;
/*    */ import org.primefaces.model.chart.PieChartModel;
/*    */ 
/*    */ @ManagedBean
/*    */ public class ChartView
/*    */   implements Serializable
/*    */ {
/*    */   private LineChartModel lineModel;
/*    */   private PieChartModel pieModel;
/*    */ 
/*    */   @PostConstruct
/*    */   public void init()
/*    */   {
/* 35 */     initLinearModel();
/* 36 */     initPieModel();
/*    */   }
/*    */ 
/*    */   public LineChartModel getLineModel() {
/* 40 */     return this.lineModel;
/*    */   }
/*    */ 
/*    */   public PieChartModel getPieModel() {
/* 44 */     return this.pieModel;
/*    */   }
/*    */ 
/*    */   private void initLinearModel() {
/* 48 */     this.lineModel = new LineChartModel();
/* 49 */     this.lineModel.setTitle("Linear Chart");
/* 50 */     this.lineModel.setLegendPosition("e");
/* 51 */     this.lineModel.setExtender("skinChart");
/* 52 */     this.lineModel.setAnimate(true);
/* 53 */     Axis yAxis = this.lineModel.getAxis(AxisType.Y);
/* 54 */     yAxis.setMin(Integer.valueOf(0));
/* 55 */     yAxis.setMax(Integer.valueOf(10));
/*    */ 
/* 57 */     LineChartSeries series1 = new LineChartSeries();
/* 58 */     series1.setLabel("Series 1");
/*    */ 
/* 60 */     series1.set(Integer.valueOf(1), Integer.valueOf(2));
/* 61 */     series1.set(Integer.valueOf(2), Integer.valueOf(1));
/* 62 */     series1.set(Integer.valueOf(3), Integer.valueOf(3));
/* 63 */     series1.set(Integer.valueOf(4), Integer.valueOf(6));
/* 64 */     series1.set(Integer.valueOf(5), Integer.valueOf(8));
/*    */ 
/* 66 */     LineChartSeries series2 = new LineChartSeries();
/* 67 */     series2.setLabel("Series 2");
/*    */ 
/* 69 */     series2.set(Integer.valueOf(1), Integer.valueOf(6));
/* 70 */     series2.set(Integer.valueOf(2), Integer.valueOf(3));
/* 71 */     series2.set(Integer.valueOf(3), Integer.valueOf(2));
/* 72 */     series2.set(Integer.valueOf(4), Integer.valueOf(7));
/* 73 */     series2.set(Integer.valueOf(5), Integer.valueOf(9));
/*    */ 
/* 75 */     this.lineModel.addSeries(series1);
/* 76 */     this.lineModel.addSeries(series2);
/*    */   }
/*    */ 
/*    */   private void initPieModel() {
/* 80 */     this.pieModel = new PieChartModel();
/*    */ 
/* 82 */     this.pieModel.set("Brand 1", Integer.valueOf(540));
/* 83 */     this.pieModel.set("Brand 2", Integer.valueOf(325));
/* 84 */     this.pieModel.set("Brand 3", Integer.valueOf(702));
/* 85 */     this.pieModel.set("Brand 4", Integer.valueOf(421));
/*    */ 
/* 87 */     this.pieModel.setExtender("skinPie");
/*    */   }
/*    */ }

/* Location:           C:\Users\jbravo\Desktop\classes\
 * Qualified Name:     org.primefaces.sentinel.ChartView
 * JD-Core Version:    0.6.0
 */