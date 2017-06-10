/*    */ package org.primefaces.sentinel;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.annotation.PostConstruct;
/*    */ import javax.faces.bean.ManagedBean;
/*    */ 
/*    */ @ManagedBean
/*    */ public class ImagesView
/*    */ {
/*    */   private List<String> images;
/*    */ 
/*    */   @PostConstruct
/*    */   public void init()
/*    */   {
/* 30 */     this.images = new ArrayList();
/* 31 */     for (int i = 1; i <= 12; i++)
/* 32 */       this.images.add("nature" + i + ".jpg");
/*    */   }
/*    */ 
/*    */   public List<String> getImages()
/*    */   {
/* 37 */     return this.images;
/*    */   }
/*    */ }

/* Location:           C:\Users\jbravo\Desktop\classes\
 * Qualified Name:     org.primefaces.sentinel.ImagesView
 * JD-Core Version:    0.6.0
 */