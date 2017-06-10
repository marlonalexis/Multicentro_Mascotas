/*    */ package org.primefaces.sentinel;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.annotation.PostConstruct;
/*    */ import javax.faces.application.FacesMessage;
/*    */ import javax.faces.bean.ManagedBean;
/*    */ import javax.faces.bean.ManagedProperty;
/*    */ import javax.faces.bean.ViewScoped;
/*    */ import javax.faces.context.FacesContext;
/*    */ 
/*    */ @ManagedBean(name="overlayView")
/*    */ @ViewScoped
/*    */ public class OverlayView
/*    */   implements Serializable
/*    */ {
/*    */   private List<Car> cars;
/*    */   private Car selectedCar;
/*    */   private List<String> images;
/*    */ 
/*    */   @ManagedProperty("#{carService}")
/*    */   private CarService service;
/*    */ 
/*    */   @PostConstruct
/*    */   public void init()
/*    */   {
/* 26 */     this.cars = this.service.createCars(10);
/* 27 */     this.images = new ArrayList();
/*    */ 
/* 29 */     this.images.add("nature1.jpg");
/* 30 */     this.images.add("nature2.jpg");
/* 31 */     this.images.add("nature3.jpg");
/* 32 */     this.images.add("nature4.jpg");
/*    */   }
/*    */ 
/*    */   public void destroyWorld() {
/* 36 */     FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "System Error", "Please try again later.");
/* 37 */     FacesContext.getCurrentInstance().addMessage(null, message);
/*    */   }
/*    */ 
/*    */   public List<Car> getCars() {
/* 41 */     return this.cars;
/*    */   }
/*    */ 
/*    */   public void setCars(List<Car> cars) {
/* 45 */     this.cars = cars;
/*    */   }
/*    */ 
/*    */   public Car getSelectedCar() {
/* 49 */     return this.selectedCar;
/*    */   }
/*    */ 
/*    */   public void setSelectedCar(Car selectedCar) {
/* 53 */     this.selectedCar = selectedCar;
/*    */   }
/*    */ 
/*    */   public CarService getService() {
/* 57 */     return this.service;
/*    */   }
/*    */ 
/*    */   public void setService(CarService service) {
/* 61 */     this.service = service;
/*    */   }
/*    */ 
/*    */   public List<String> getImages() {
/* 65 */     return this.images;
/*    */   }
/*    */ 
/*    */   public void setImages(List<String> images) {
/* 69 */     this.images = images;
/*    */   }
/*    */ }

/* Location:           C:\Users\jbravo\Desktop\classes\
 * Qualified Name:     org.primefaces.sentinel.OverlayView
 * JD-Core Version:    0.6.0
 */