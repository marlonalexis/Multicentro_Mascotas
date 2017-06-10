/*    */ package org.primefaces.sentinel;
/*    */ 
/*    */ import javax.faces.application.FacesMessage;
/*    */ import javax.faces.bean.ManagedBean;
/*    */ import javax.faces.context.FacesContext;
/*    */ 
/*    */ @ManagedBean
/*    */ public class MessagesView
/*    */ {
/*    */   public void info()
/*    */   {
/* 26 */     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "PrimeFaces Rocks."));
/*    */   }
/*    */ 
/*    */   public void warn() {
/* 30 */     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Watch out for PrimeFaces."));
/*    */   }
/*    */ 
/*    */   public void error() {
/* 34 */     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contact admin."));
/*    */   }
/*    */ 
/*    */   public void fatal() {
/* 38 */     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", "System Error"));
/*    */   }
/*    */ 
/*    */   public void growlMessage() {
/* 42 */     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "PrimeFaces", "SentinelLayout"));
/*    */   }
/*    */ }

/* Location:           C:\Users\jbravo\Desktop\classes\
 * Qualified Name:     org.primefaces.sentinel.MessagesView
 * JD-Core Version:    0.6.0
 */