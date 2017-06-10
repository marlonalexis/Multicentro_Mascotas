/*    */ package org.primefaces.sentinel;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import java.util.UUID;
/*    */ import javax.faces.bean.ApplicationScoped;
/*    */ import javax.faces.bean.ManagedBean;
/*    */ 
/*    */ @ManagedBean(name="carService")
/*    */ @ApplicationScoped
/*    */ public class CarService
/*    */ {
/* 34 */   private static final String[] colors = new String[10];
/*    */   private static final String[] brands;
/*    */ 
/*    */   public List<Car> createCars(int size)
/*    */   {
/* 60 */     List list = new ArrayList();
/* 61 */     for (int i = 0; i < size; i++) {
/* 62 */       list.add(new Car(getRandomId(), getRandomBrand(), getRandomYear(), getRandomColor(), getRandomPrice(), getRandomSoldState()));
/*    */     }
/*    */ 
/* 65 */     return list;
/*    */   }
/*    */ 
/*    */   private String getRandomId() {
/* 69 */     return UUID.randomUUID().toString().substring(0, 8);
/*    */   }
/*    */ 
/*    */   private int getRandomYear() {
/* 73 */     return (int)(Math.random() * 50.0D + 1960.0D);
/*    */   }
/*    */ 
/*    */   private String getRandomColor() {
/* 77 */     return colors[(int)(Math.random() * 10.0D)];
/*    */   }
/*    */ 
/*    */   private String getRandomBrand() {
/* 81 */     return brands[(int)(Math.random() * 10.0D)];
/*    */   }
/*    */ 
/*    */   private int getRandomPrice() {
/* 85 */     return (int)(Math.random() * 100000.0D);
/*    */   }
/*    */ 
/*    */   private boolean getRandomSoldState() {
/* 89 */     return Math.random() > 0.5D;
/*    */   }
/*    */ 
/*    */   public List<String> getColors() {
/* 93 */     return Arrays.asList(colors);
/*    */   }
/*    */ 
/*    */   public List<String> getBrands() {
/* 97 */     return Arrays.asList(brands);
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 35 */     colors[0] = "Black";
/* 36 */     colors[1] = "White";
/* 37 */     colors[2] = "Green";
/* 38 */     colors[3] = "Red";
/* 39 */     colors[4] = "Blue";
/* 40 */     colors[5] = "Orange";
/* 41 */     colors[6] = "Silver";
/* 42 */     colors[7] = "Yellow";
/* 43 */     colors[8] = "Brown";
/* 44 */     colors[9] = "Maroon";
/*    */ 
/* 46 */     brands = new String[10];
/* 47 */     brands[0] = "BMW";
/* 48 */     brands[1] = "Mercedes";
/* 49 */     brands[2] = "Volvo";
/* 50 */     brands[3] = "Audi";
/* 51 */     brands[4] = "Renault";
/* 52 */     brands[5] = "Fiat";
/* 53 */     brands[6] = "Volkswagen";
/* 54 */     brands[7] = "Honda";
/* 55 */     brands[8] = "Jaguar";
/* 56 */     brands[9] = "Ford";
/*    */   }
/*    */ }

/* Location:           C:\Users\jbravo\Desktop\classes\
 * Qualified Name:     org.primefaces.sentinel.CarService
 * JD-Core Version:    0.6.0
 */