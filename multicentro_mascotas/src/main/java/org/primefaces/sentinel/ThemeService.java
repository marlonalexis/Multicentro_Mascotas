/*    */ package org.primefaces.sentinel;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.annotation.PostConstruct;
/*    */ import javax.faces.bean.ApplicationScoped;
/*    */ import javax.faces.bean.ManagedBean;
/*    */ 
/*    */ @ManagedBean(name="themeService", eager=true)
/*    */ @ApplicationScoped
/*    */ public class ThemeService
/*    */ {
/*    */   private List<Theme> themes;
/*    */ 
/*    */   @PostConstruct
/*    */   public void init()
/*    */   {
/* 33 */     this.themes = new ArrayList();
/* 34 */     this.themes.add(new Theme(0, "Afterdark", "afterdark"));
/* 35 */     this.themes.add(new Theme(1, "Afternoon", "afternoon"));
/* 36 */     this.themes.add(new Theme(2, "Afterwork", "afterwork"));
/* 37 */     this.themes.add(new Theme(3, "Aristo", "aristo"));
/* 38 */     this.themes.add(new Theme(4, "Black-Tie", "black-tie"));
/* 39 */     this.themes.add(new Theme(5, "Blitzer", "blitzer"));
/* 40 */     this.themes.add(new Theme(6, "Bluesky", "bluesky"));
/* 41 */     this.themes.add(new Theme(7, "Bootstrap", "bootstrap"));
/* 42 */     this.themes.add(new Theme(8, "Casablanca", "casablanca"));
/* 43 */     this.themes.add(new Theme(9, "Cupertino", "cupertino"));
/* 44 */     this.themes.add(new Theme(10, "Cruze", "cruze"));
/* 45 */     this.themes.add(new Theme(11, "Dark-Hive", "dark-hive"));
/* 46 */     this.themes.add(new Theme(12, "Delta", "delta"));
/* 47 */     this.themes.add(new Theme(13, "Dot-Luv", "dot-luv"));
/* 48 */     this.themes.add(new Theme(14, "Eggplant", "eggplant"));
/* 49 */     this.themes.add(new Theme(15, "Excite-Bike", "excite-bike"));
/* 50 */     this.themes.add(new Theme(16, "Flick", "flick"));
/* 51 */     this.themes.add(new Theme(17, "Glass-X", "glass-x"));
/* 52 */     this.themes.add(new Theme(18, "Home", "home"));
/* 53 */     this.themes.add(new Theme(19, "Hot-Sneaks", "hot-sneaks"));
/* 54 */     this.themes.add(new Theme(20, "Humanity", "humanity"));
/* 55 */     this.themes.add(new Theme(21, "Le-Frog", "le-frog"));
/* 56 */     this.themes.add(new Theme(22, "Midnight", "midnight"));
/* 57 */     this.themes.add(new Theme(23, "Mint-Choc", "mint-choc"));
/* 58 */     this.themes.add(new Theme(24, "Overcast", "overcast"));
/* 59 */     this.themes.add(new Theme(25, "Pepper-Grinder", "pepper-grinder"));
/* 60 */     this.themes.add(new Theme(26, "Redmond", "redmond"));
/* 61 */     this.themes.add(new Theme(27, "Rocket", "rocket"));
/* 62 */     this.themes.add(new Theme(28, "Sam", "sam"));
/* 63 */     this.themes.add(new Theme(29, "Smoothness", "smoothness"));
/* 64 */     this.themes.add(new Theme(30, "South-Street", "south-street"));
/* 65 */     this.themes.add(new Theme(31, "Start", "start"));
/* 66 */     this.themes.add(new Theme(32, "Sunny", "sunny"));
/* 67 */     this.themes.add(new Theme(33, "Swanky-Purse", "swanky-purse"));
/* 68 */     this.themes.add(new Theme(34, "Trontastic", "trontastic"));
/* 69 */     this.themes.add(new Theme(35, "UI-Darkness", "ui-darkness"));
/* 70 */     this.themes.add(new Theme(36, "UI-Lightness", "ui-lightness"));
/* 71 */     this.themes.add(new Theme(37, "Vader", "vader"));
/*    */   }
/*    */ 
/*    */   public List<Theme> getThemes() {
/* 75 */     return this.themes;
/*    */   }
/*    */ }

/* Location:           C:\Users\jbravo\Desktop\classes\
 * Qualified Name:     org.primefaces.sentinel.ThemeService
 * JD-Core Version:    0.6.0
 */