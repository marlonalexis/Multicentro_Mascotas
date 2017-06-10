/*    */ package org.primefaces.sentinel;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.annotation.PostConstruct;
/*    */ import javax.faces.bean.ManagedBean;
/*    */ 
/*    */ @ManagedBean
/*    */ public class OrderListView
/*    */ {
/*    */   private List<String> cities;
/*    */ 
/*    */   @PostConstruct
/*    */   public void init()
/*    */   {
/* 31 */     this.cities = new ArrayList();
/* 32 */     this.cities.add("San Francisco");
/* 33 */     this.cities.add("London");
/* 34 */     this.cities.add("Paris");
/* 35 */     this.cities.add("Istanbul");
/* 36 */     this.cities.add("Berlin");
/* 37 */     this.cities.add("Barcelona");
/* 38 */     this.cities.add("Rome");
/*    */   }
/*    */ 
/*    */   public List<String> getCities() {
/* 42 */     return this.cities;
/*    */   }
/*    */ }

/* Location:           C:\Users\jbravo\Desktop\classes\
 * Qualified Name:     org.primefaces.sentinel.OrderListView
 * JD-Core Version:    0.6.0
 */