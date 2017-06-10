/*    */ package org.primefaces.sentinel;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.annotation.PostConstruct;
/*    */ import javax.faces.bean.ManagedBean;
/*    */ import javax.faces.bean.ManagedProperty;
/*    */ import javax.faces.bean.ViewScoped;
/*    */ import org.primefaces.event.DragDropEvent;
/*    */ 
/*    */ @ManagedBean(name="carsView")
/*    */ @ViewScoped
/*    */ public class CarsView
/*    */   implements Serializable
/*    */ {
/*    */   private List<Car> cars;
/*    */   private List<Car> minCars;
/*    */   private Car selectedCar;
/*    */   private List<Car> droppedCars;
/*    */   private List<Car> selectedCars;
/*    */ 
/*    */   @ManagedProperty("#{carService}")
/*    */   private CarService service;
/*    */ 
/*    */   @PostConstruct
/*    */   public void init()
/*    */   {
/* 42 */     this.cars = this.service.createCars(50);
/* 43 */     this.minCars = this.service.createCars(10);
/* 44 */     this.droppedCars = new ArrayList();
/*    */   }
/*    */ 
/*    */   public void onCarDrop(DragDropEvent ddEvent) {
/* 48 */     Car car = (Car)ddEvent.getData();
/*    */ 
/* 50 */     this.droppedCars.add(car);
/* 51 */     this.cars.remove(car);
/*    */   }
/*    */ 
/*    */   public List<Car> getDroppedCars() {
/* 55 */     return this.droppedCars;
/*    */   }
/*    */ 
/*    */   public void setDroppedCars(List<Car> droppedCars) {
/* 59 */     this.droppedCars = droppedCars;
/*    */   }
/*    */ 
/*    */   public List<Car> getCars() {
/* 63 */     return this.cars;
/*    */   }
/*    */ 
/*    */   public void setCars(List<Car> cars) {
/* 67 */     this.cars = cars;
/*    */   }
/*    */ 
/*    */   public List<Car> getMinCars() {
/* 71 */     return this.minCars;
/*    */   }
/*    */ 
/*    */   public void setMinCars(List<Car> minCars) {
/* 75 */     this.minCars = minCars;
/*    */   }
/*    */ 
/*    */   public void setService(CarService service) {
/* 79 */     this.service = service;
/*    */   }
/*    */ 
/*    */   public Car getSelectedCar() {
/* 83 */     return this.selectedCar;
/*    */   }
/*    */ 
/*    */   public void setSelectedCar(Car selectedCar) {
/* 87 */     this.selectedCar = selectedCar;
/*    */   }
/*    */ 
/*    */   public List<Car> getSelectedCars() {
/* 91 */     return this.selectedCars;
/*    */   }
/*    */ 
/*    */   public void setSelectedCars(List<Car> selectedCars) {
/* 95 */     this.selectedCars = selectedCars;
/*    */   }
/*    */ }

/* Location:           C:\Users\jbravo\Desktop\classes\
 * Qualified Name:     org.primefaces.sentinel.CarsView
 * JD-Core Version:    0.6.0
 */