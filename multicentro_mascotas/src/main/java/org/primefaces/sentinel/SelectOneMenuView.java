/*     */ package org.primefaces.sentinel;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.PostConstruct;
/*     */ import javax.faces.bean.ManagedBean;
/*     */ import javax.faces.bean.ManagedProperty;
/*     */ import javax.faces.model.SelectItem;
/*     */ import javax.faces.model.SelectItemGroup;
/*     */ 
/*     */ @ManagedBean
/*     */ public class SelectOneMenuView
/*     */ {
/*     */   private String console;
/*     */   private String car;
/*     */   private List<SelectItem> cars;
/*     */   private String city;
/*  37 */   private Map<String, String> cities = new HashMap();
/*     */   private Theme theme;
/*     */   private List<Theme> themes;
/*     */ 
/*     */   @ManagedProperty("#{themeService}")
/*     */   private ThemeService service;
/*     */ 
/*     */   @PostConstruct
/*     */   public void init()
/*     */   {
/*  48 */     SelectItemGroup g1 = new SelectItemGroup("German Cars");
/*  49 */     g1.setSelectItems(new SelectItem[] { new SelectItem("BMW", "BMW"), new SelectItem("Mercedes", "Mercedes"), new SelectItem("Volkswagen", "Volkswagen") });
/*     */ 
/*  51 */     SelectItemGroup g2 = new SelectItemGroup("American Cars");
/*  52 */     g2.setSelectItems(new SelectItem[] { new SelectItem("Chrysler", "Chrysler"), new SelectItem("GM", "GM"), new SelectItem("Ford", "Ford") });
/*     */ 
/*  54 */     this.cars = new ArrayList();
/*  55 */     this.cars.add(g1);
/*  56 */     this.cars.add(g2);
/*     */ 
/*  59 */     this.cities = new HashMap();
/*  60 */     this.cities.put("New York", "New York");
/*  61 */     this.cities.put("London", "London");
/*  62 */     this.cities.put("Paris", "Paris");
/*  63 */     this.cities.put("Barcelona", "Barcelona");
/*  64 */     this.cities.put("Istanbul", "Istanbul");
/*  65 */     this.cities.put("Berlin", "Berlin");
/*     */ 
/*  68 */     this.themes = this.service.getThemes();
/*     */   }
/*     */ 
/*     */   public String getConsole() {
/*  72 */     return this.console;
/*     */   }
/*     */ 
/*     */   public void setConsole(String console) {
/*  76 */     this.console = console;
/*     */   }
/*     */ 
/*     */   public String getCar() {
/*  80 */     return this.car;
/*     */   }
/*     */ 
/*     */   public void setCar(String car) {
/*  84 */     this.car = car;
/*     */   }
/*     */ 
/*     */   public String getCity() {
/*  88 */     return this.city;
/*     */   }
/*     */ 
/*     */   public void setCity(String city) {
/*  92 */     this.city = city;
/*     */   }
/*     */ 
/*     */   public Theme getTheme() {
/*  96 */     return this.theme;
/*     */   }
/*     */ 
/*     */   public void setTheme(Theme theme) {
/* 100 */     this.theme = theme;
/*     */   }
/*     */ 
/*     */   public List<SelectItem> getCars() {
/* 104 */     return this.cars;
/*     */   }
/*     */ 
/*     */   public Map<String, String> getCities() {
/* 108 */     return this.cities;
/*     */   }
/*     */ 
/*     */   public List<Theme> getThemes() {
/* 112 */     return this.themes;
/*     */   }
/*     */ 
/*     */   public void setService(ThemeService service) {
/* 116 */     this.service = service;
/*     */   }
/*     */ }

/* Location:           C:\Users\jbravo\Desktop\classes\
 * Qualified Name:     org.primefaces.sentinel.SelectOneMenuView
 * JD-Core Version:    0.6.0
 */