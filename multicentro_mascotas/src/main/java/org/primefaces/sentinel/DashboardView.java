/*    */ package org.primefaces.sentinel;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import javax.annotation.PostConstruct;
/*    */ import javax.faces.bean.ManagedBean;
/*    */ import javax.faces.bean.ViewScoped;
/*    */ import org.primefaces.model.DashboardColumn;
/*    */ import org.primefaces.model.DashboardModel;
/*    */ import org.primefaces.model.DefaultDashboardColumn;
/*    */ import org.primefaces.model.DefaultDashboardModel;
/*    */ 
/*    */ @ManagedBean
/*    */ @ViewScoped
/*    */ public class DashboardView
/*    */   implements Serializable
/*    */ {
/*    */   private DashboardModel model;
/*    */ 
/*    */   @PostConstruct
/*    */   public void init()
/*    */   {
/* 41 */     this.model = new DefaultDashboardModel();
/* 42 */     DashboardColumn column1 = new DefaultDashboardColumn();
/* 43 */     DashboardColumn column2 = new DefaultDashboardColumn();
/* 44 */     DashboardColumn column3 = new DefaultDashboardColumn();
/*    */ 
/* 46 */     column1.addWidget("sports");
/* 47 */     column1.addWidget("finance");
/*    */ 
/* 49 */     column2.addWidget("lifestyle");
/* 50 */     column2.addWidget("weather");
/*    */ 
/* 52 */     column3.addWidget("politics");
/*    */ 
/* 54 */     this.model.addColumn(column1);
/* 55 */     this.model.addColumn(column2);
/* 56 */     this.model.addColumn(column3);
/*    */   }
/*    */ 
/*    */   public DashboardModel getModel() {
/* 60 */     return this.model;
/*    */   }
/*    */ }

/* Location:           C:\Users\jbravo\Desktop\classes\
 * Qualified Name:     org.primefaces.sentinel.DashboardView
 * JD-Core Version:    0.6.0
 */