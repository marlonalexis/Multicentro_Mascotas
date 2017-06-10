/*     */ package org.primefaces.sentinel;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.faces.application.FacesMessage;
/*     */ import javax.faces.bean.ManagedBean;
/*     */ import javax.faces.bean.ManagedProperty;
/*     */ import javax.faces.context.FacesContext;
/*     */ import org.primefaces.event.SelectEvent;
/*     */ 
/*     */ @ManagedBean
/*     */ public class AutoCompleteView
/*     */ {
/*     */   private String txt1;
/*     */   private String txt2;
/*     */   private String txt3;
/*     */   private String txt4;
/*     */   private String txt5;
/*     */   private String txt6;
/*     */   private String txt7;
/*     */   private String txt8;
/*     */   private Theme theme1;
/*     */   private Theme theme2;
/*     */   private Theme theme3;
/*     */   private Theme theme4;
/*     */   private List<Theme> selectedThemes;
/*     */ 
/*     */   @ManagedProperty("#{themeService}")
/*     */   private ThemeService service;
/*     */ 
/*     */   public List<String> completeText(String query)
/*     */   {
/*  48 */     List results = new ArrayList();
/*  49 */     for (int i = 0; i < 10; i++) {
/*  50 */       results.add(query + i);
/*     */     }
/*     */ 
/*  53 */     return results;
/*     */   }
/*     */ 
/*     */   public List<Theme> completeTheme(String query) {
/*  57 */     List allThemes = this.service.getThemes();
/*  58 */     List filteredThemes = new ArrayList();
/*     */ 
/*  60 */     for (int i = 0; i < allThemes.size(); i++) {
/*  61 */       Theme skin = (Theme)allThemes.get(i);
/*  62 */       if (skin.getName().toLowerCase().contains(query)) {
/*  63 */         filteredThemes.add(skin);
/*     */       }
/*     */     }
/*     */ 
/*  67 */     return filteredThemes;
/*     */   }
/*     */ 
/*     */   public List<Theme> completeThemeContains(String query) {
/*  71 */     List allThemes = this.service.getThemes();
/*  72 */     List filteredThemes = new ArrayList();
/*     */ 
/*  74 */     for (int i = 0; i < allThemes.size(); i++) {
/*  75 */       Theme skin = (Theme)allThemes.get(i);
/*  76 */       if (skin.getName().toLowerCase().contains(query)) {
/*  77 */         filteredThemes.add(skin);
/*     */       }
/*     */     }
/*     */ 
/*  81 */     return filteredThemes;
/*     */   }
/*     */ 
/*     */   public void onItemSelect(SelectEvent event) {
/*  85 */     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Selected", event.getObject().toString()));
/*     */   }
/*     */ 
/*     */   public String getTxt1() {
/*  89 */     return this.txt1;
/*     */   }
/*     */ 
/*     */   public void setTxt1(String txt1) {
/*  93 */     this.txt1 = txt1;
/*     */   }
/*     */ 
/*     */   public String getTxt2() {
/*  97 */     return this.txt2;
/*     */   }
/*     */ 
/*     */   public void setTxt2(String txt2) {
/* 101 */     this.txt2 = txt2;
/*     */   }
/*     */ 
/*     */   public String getTxt3() {
/* 105 */     return this.txt3;
/*     */   }
/*     */ 
/*     */   public void setTxt3(String txt3) {
/* 109 */     this.txt3 = txt3;
/*     */   }
/*     */ 
/*     */   public String getTxt4() {
/* 113 */     return this.txt4;
/*     */   }
/*     */ 
/*     */   public void setTxt4(String txt4) {
/* 117 */     this.txt4 = txt4;
/*     */   }
/*     */ 
/*     */   public String getTxt5() {
/* 121 */     return this.txt5;
/*     */   }
/*     */ 
/*     */   public void setTxt5(String txt5) {
/* 125 */     this.txt5 = txt5;
/*     */   }
/*     */ 
/*     */   public String getTxt6() {
/* 129 */     return this.txt6;
/*     */   }
/*     */ 
/*     */   public void setTxt6(String txt6) {
/* 133 */     this.txt6 = txt6;
/*     */   }
/*     */ 
/*     */   public String getTxt7() {
/* 137 */     return this.txt7;
/*     */   }
/*     */ 
/*     */   public void setTxt7(String txt7) {
/* 141 */     this.txt7 = txt7;
/*     */   }
/*     */ 
/*     */   public String getTxt8() {
/* 145 */     return this.txt8;
/*     */   }
/*     */ 
/*     */   public void setTxt8(String txt8) {
/* 149 */     this.txt8 = txt8;
/*     */   }
/*     */ 
/*     */   public Theme getTheme1() {
/* 153 */     return this.theme1;
/*     */   }
/*     */ 
/*     */   public void setTheme1(Theme theme1) {
/* 157 */     this.theme1 = theme1;
/*     */   }
/*     */ 
/*     */   public Theme getTheme2() {
/* 161 */     return this.theme2;
/*     */   }
/*     */ 
/*     */   public void setTheme2(Theme theme2) {
/* 165 */     this.theme2 = theme2;
/*     */   }
/*     */ 
/*     */   public Theme getTheme3() {
/* 169 */     return this.theme3;
/*     */   }
/*     */ 
/*     */   public void setTheme3(Theme theme3) {
/* 173 */     this.theme3 = theme3;
/*     */   }
/*     */ 
/*     */   public Theme getTheme4() {
/* 177 */     return this.theme4;
/*     */   }
/*     */ 
/*     */   public void setTheme4(Theme theme4) {
/* 181 */     this.theme4 = theme4;
/*     */   }
/*     */ 
/*     */   public List<Theme> getSelectedThemes() {
/* 185 */     return this.selectedThemes;
/*     */   }
/*     */ 
/*     */   public void setSelectedThemes(List<Theme> selectedThemes) {
/* 189 */     this.selectedThemes = selectedThemes;
/*     */   }
/*     */ 
/*     */   public void setService(ThemeService service) {
/* 193 */     this.service = service;
/*     */   }
/*     */ 
/*     */   public char getThemeGroup(Theme theme) {
/* 197 */     return theme.getDisplayName().charAt(0);
/*     */   }
/*     */ }

/* Location:           C:\Users\jbravo\Desktop\classes\
 * Qualified Name:     org.primefaces.sentinel.AutoCompleteView
 * JD-Core Version:    0.6.0
 */