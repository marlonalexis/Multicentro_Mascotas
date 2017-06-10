/*    */ package org.primefaces.sentinel;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.annotation.PostConstruct;
/*    */ import javax.faces.bean.ManagedBean;
/*    */ import org.primefaces.model.DualListModel;
/*    */ 
/*    */ @ManagedBean
/*    */ public class PickListView
/*    */ {
/*    */   private DualListModel<String> cities;
/*    */ 
/*    */   @PostConstruct
/*    */   public void init()
/*    */   {
/* 32 */     List citiesSource = new ArrayList();
/* 33 */     List citiesTarget = new ArrayList();
/*    */ 
/* 35 */     citiesSource.add("San Francisco");
/* 36 */     citiesSource.add("London");
/* 37 */     citiesSource.add("Paris");
/* 38 */     citiesSource.add("Istanbul");
/* 39 */     citiesSource.add("Berlin");
/* 40 */     citiesSource.add("Barcelona");
/* 41 */     citiesSource.add("Rome");
/*    */ 
/* 43 */     this.cities = new DualListModel(citiesSource, citiesTarget);
/*    */   }
/*    */ 
/*    */   public DualListModel<String> getCities() {
/* 47 */     return this.cities;
/*    */   }
/*    */ 
/*    */   public void setCities(DualListModel<String> cities) {
/* 51 */     this.cities = cities;
/*    */   }
/*    */ }

/* Location:           C:\Users\jbravo\Desktop\classes\
 * Qualified Name:     org.primefaces.sentinel.PickListView
 * JD-Core Version:    0.6.0
 */