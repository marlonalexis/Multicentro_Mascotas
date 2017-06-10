/*     */ package org.primefaces.sentinel;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ 
/*     */ public class Car
/*     */   implements Serializable
/*     */ {
/*     */   public String id;
/*     */   public String brand;
/*     */   public int year;
/*     */   public String color;
/*     */   public int price;
/*     */   public boolean sold;
/*     */ 
/*     */   public Car()
/*     */   {
/*     */   }
/*     */ 
/*     */   public Car(String id, String brand, int year, String color)
/*     */   {
/*  32 */     this.id = id;
/*  33 */     this.brand = brand;
/*  34 */     this.year = year;
/*  35 */     this.color = color;
/*     */   }
/*     */ 
/*     */   public Car(String id, String brand, int year, String color, int price, boolean sold) {
/*  39 */     this.id = id;
/*  40 */     this.brand = brand;
/*  41 */     this.year = year;
/*  42 */     this.color = color;
/*  43 */     this.price = price;
/*  44 */     this.sold = sold;
/*     */   }
/*     */ 
/*     */   public String getId() {
/*  48 */     return this.id;
/*     */   }
/*     */   public void setId(String id) {
/*  51 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getBrand() {
/*  55 */     return this.brand;
/*     */   }
/*     */   public void setBrand(String brand) {
/*  58 */     this.brand = brand;
/*     */   }
/*     */ 
/*     */   public int getYear() {
/*  62 */     return this.year;
/*     */   }
/*     */   public void setYear(int year) {
/*  65 */     this.year = year;
/*     */   }
/*     */ 
/*     */   public String getColor() {
/*  69 */     return this.color;
/*     */   }
/*     */   public void setColor(String color) {
/*  72 */     this.color = color;
/*     */   }
/*     */ 
/*     */   public int getPrice() {
/*  76 */     return this.price;
/*     */   }
/*     */   public void setPrice(int price) {
/*  79 */     this.price = price;
/*     */   }
/*     */ 
/*     */   public boolean isSold() {
/*  83 */     return this.sold;
/*     */   }
/*     */   public void setSold(boolean sold) {
/*  86 */     this.sold = sold;
/*     */   }
/*     */ 
/*     */   public int hashCode()
/*     */   {
/*  91 */     int hash = 7;
/*  92 */     hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
/*  93 */     return hash;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object obj)
/*     */   {
/*  98 */     if (obj == null) {
/*  99 */       return false;
/*     */     }
/* 101 */     if (getClass() != obj.getClass()) {
/* 102 */       return false;
/*     */     }
/* 104 */     Car other = (Car)obj;
/*     */ 
/* 106 */     return this.id == null ? other.id == null : this.id.equals(other.id);
/*     */   }
/*     */ }

/* Location:           C:\Users\jbravo\Desktop\classes\
 * Qualified Name:     org.primefaces.sentinel.Car
 * JD-Core Version:    0.6.0
 */