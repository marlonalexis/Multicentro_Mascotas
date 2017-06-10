/*    */ package org.primefaces.sentinel;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.annotation.PostConstruct;
/*    */ import javax.faces.application.FacesMessage;
/*    */ import javax.faces.bean.ManagedBean;
/*    */ import javax.faces.bean.ViewScoped;
/*    */ import javax.faces.context.FacesContext;
/*    */ import javax.faces.model.SelectItem;
/*    */ import javax.faces.model.SelectItemGroup;
/*    */ 
/*    */ @ManagedBean(name="formsView")
/*    */ @ViewScoped
/*    */ public class FormsView
/*    */   implements Serializable
/*    */ {
/*    */   private List<SelectItem> carsGroup;
/* 34 */   private String text = "PrimeFaces";
/*    */   private String password1;
/*    */   private String password2;
/*    */ 
/*    */   @PostConstruct
/*    */   public void init()
/*    */   {
/* 40 */     SelectItemGroup g1 = new SelectItemGroup("German Cars");
/* 41 */     g1.setSelectItems(new SelectItem[] { new SelectItem("BMW", "BMW"), new SelectItem("Mercedes", "Mercedes"), new SelectItem("Volkswagen", "Volkswagen") });
/*    */ 
/* 43 */     SelectItemGroup g2 = new SelectItemGroup("American Cars");
/* 44 */     g2.setSelectItems(new SelectItem[] { new SelectItem("Chrysler", "Chrysler"), new SelectItem("GM", "GM"), new SelectItem("Ford", "Ford") });
/*    */ 
/* 46 */     this.carsGroup = new ArrayList();
/* 47 */     this.carsGroup.add(g1);
/* 48 */     this.carsGroup.add(g2);
/*    */   }
/*    */ 
/*    */   public List<SelectItem> getCarsGroup() {
/* 52 */     return this.carsGroup;
/*    */   }
/*    */ 
/*    */   public void setCarsGroup(List<SelectItem> carsGroup) {
/* 56 */     this.carsGroup = carsGroup;
/*    */   }
/*    */ 
/*    */   public String getText() {
/* 60 */     return this.text;
/*    */   }
/*    */ 
/*    */   public void setText(String text) {
/* 64 */     this.text = text;
/*    */   }
/*    */ 
/*    */   public void onActive() {
/* 68 */     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Welcome Back", "Well, that's a long coffee break!"));
/*    */   }
/*    */ 
/*    */   public String getPassword1()
/*    */   {
/* 73 */     return this.password1;
/*    */   }
/*    */ 
/*    */   public void setPassword1(String password1) {
/* 77 */     this.password1 = password1;
/*    */   }
/*    */ 
/*    */   public String getPassword2() {
/* 81 */     return this.password2;
/*    */   }
/*    */ 
/*    */   public void setPassword2(String password2) {
/* 85 */     this.password2 = password2;
/*    */   }
/*    */ }

/* Location:           C:\Users\jbravo\Desktop\classes\
 * Qualified Name:     org.primefaces.sentinel.FormsView
 * JD-Core Version:    0.6.0
 */