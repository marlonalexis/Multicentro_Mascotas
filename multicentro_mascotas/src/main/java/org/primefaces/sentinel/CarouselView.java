/*    */ package org.primefaces.sentinel;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.List;
/*    */ import javax.annotation.PostConstruct;
/*    */ import javax.faces.bean.ManagedBean;
/*    */ import javax.faces.bean.ManagedProperty;
/*    */ import javax.faces.bean.ViewScoped;
/*    */ 
/*    */ @ManagedBean
/*    */ @ViewScoped
/*    */ public class CarouselView
/*    */   implements Serializable
/*    */ {
/*    */   private List<Car> cars;
/*    */   private Car selectedCar;
/*    */ 
/*    */   @ManagedProperty("#{carService}")
/*    */   private CarService service;
/*    */ 
/*    */   @PostConstruct
/*    */   public void init()
/*    */   {
/* 38 */     this.cars = this.service.createCars(9);
/*    */   }
/*    */ 
/*    */   public List<Car> getCars() {
/* 42 */     return this.cars;
/*    */   }
/*    */ 
/*    */   public void setService(CarService service) {
/* 46 */     this.service = service;
/*    */   }
/*    */ 
/*    */   public Car getSelectedCar() {
/* 50 */     return this.selectedCar;
/*    */   }
/*    */ 
/*    */   public void setSelectedCar(Car selectedCar) {
/* 54 */     this.selectedCar = selectedCar;
/*    */   }
/*    */ }

/* Location:           C:\Users\jbravo\Desktop\classes\
 * Qualified Name:     org.primefaces.sentinel.CarouselView
 * JD-Core Version:    0.6.0
 */