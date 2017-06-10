/*    */ package org.primefaces.sentinel;
/*    */ 
/*    */ public class Theme
/*    */ {
/*    */   private int id;
/*    */   private String displayName;
/*    */   private String name;
/*    */ 
/*    */   public Theme()
/*    */   {
/*    */   }
/*    */ 
/*    */   public Theme(int id, String displayName, String name)
/*    */   {
/* 27 */     this.id = id;
/* 28 */     this.displayName = displayName;
/* 29 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public int getId() {
/* 33 */     return this.id;
/*    */   }
/*    */ 
/*    */   public void setId(int id) {
/* 37 */     this.id = id;
/*    */   }
/*    */ 
/*    */   public String getDisplayName() {
/* 41 */     return this.displayName;
/*    */   }
/*    */ 
/*    */   public void setDisplayName(String displayName) {
/* 45 */     this.displayName = displayName;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 49 */     return this.name;
/*    */   }
/*    */ 
/*    */   public void setName(String name) {
/* 53 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 58 */     return this.name;
/*    */   }
/*    */ }

/* Location:           C:\Users\jbravo\Desktop\classes\
 * Qualified Name:     org.primefaces.sentinel.Theme
 * JD-Core Version:    0.6.0
 */