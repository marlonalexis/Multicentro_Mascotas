/*    */ package org.primefaces.sentinel;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import javax.faces.application.FacesMessage;
/*    */ import javax.faces.bean.ManagedBean;
/*    */ import javax.faces.bean.ViewScoped;
/*    */ import javax.faces.context.FacesContext;
/*    */ 
/*    */ @ManagedBean
/*    */ @ViewScoped
/*    */ public class ProgressBarView
/*    */   implements Serializable
/*    */ {
/*    */   private Integer progress;
/*    */ 
/*    */   public Integer getProgress()
/*    */   {
/* 31 */     if (this.progress == null) {
/* 32 */       this.progress = Integer.valueOf(0);
/*    */     }
/*    */     else {
/* 35 */       this.progress = Integer.valueOf(this.progress.intValue() + (int)(Math.random() * 35.0D));
/*    */ 
/* 37 */       if (this.progress.intValue() > 100) {
/* 38 */         this.progress = Integer.valueOf(100);
/*    */       }
/*    */     }
/* 41 */     return this.progress;
/*    */   }
/*    */ 
/*    */   public void setProgress(Integer progress) {
/* 45 */     this.progress = progress;
/*    */   }
/*    */ 
/*    */   public void onComplete() {
/* 49 */     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Progress Completed"));
/*    */   }
/*    */ 
/*    */   public void cancel() {
/* 53 */     this.progress = null;
/*    */   }
/*    */ }

/* Location:           C:\Users\jbravo\Desktop\classes\
 * Qualified Name:     org.primefaces.sentinel.ProgressBarView
 * JD-Core Version:    0.6.0
 */