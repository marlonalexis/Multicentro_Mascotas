/*     */ package org.primefaces.sentinel;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ 
/*     */ public class Document
/*     */   implements Serializable, Comparable<Document>
/*     */ {
/*     */   private String name;
/*     */   private String size;
/*     */   private String type;
/*     */ 
/*     */   public Document(String name, String size, String type)
/*     */   {
/*  29 */     this.name = name;
/*  30 */     this.size = size;
/*  31 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public String getName() {
/*  35 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name) {
/*  39 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public String getSize() {
/*  43 */     return this.size;
/*     */   }
/*     */ 
/*     */   public void setSize(String size) {
/*  47 */     this.size = size;
/*     */   }
/*     */ 
/*     */   public String getType() {
/*  51 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setType(String type) {
/*  55 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public int hashCode()
/*     */   {
/*  61 */     int prime = 31;
/*  62 */     int result = 1;
/*  63 */     result = 31 * result + (this.name == null ? 0 : this.name.hashCode());
/*  64 */     result = 31 * result + (this.size == null ? 0 : this.size.hashCode());
/*  65 */     result = 31 * result + (this.type == null ? 0 : this.type.hashCode());
/*  66 */     return result;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object obj)
/*     */   {
/*  71 */     if (this == obj)
/*  72 */       return true;
/*  73 */     if (obj == null)
/*  74 */       return false;
/*  75 */     if (getClass() != obj.getClass())
/*  76 */       return false;
/*  77 */     Document other = (Document)obj;
/*  78 */     if (this.name == null) {
/*  79 */       if (other.name != null)
/*  80 */         return false;
/*  81 */     } else if (!this.name.equals(other.name))
/*  82 */       return false;
/*  83 */     if (this.size == null) {
/*  84 */       if (other.size != null)
/*  85 */         return false;
/*  86 */     } else if (!this.size.equals(other.size))
/*  87 */       return false;
/*  88 */     if (this.type == null) {
/*  89 */       if (other.type != null)
/*  90 */         return false;
/*  91 */     } else if (!this.type.equals(other.type))
/*  92 */       return false;
/*  93 */     return true;
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/*  98 */     return this.name;
/*     */   }
/*     */ 
/*     */   public int compareTo(Document document) {
/* 102 */     return getName().compareTo(document.getName());
/*     */   }
/*     */ }

/* Location:           C:\Users\jbravo\Desktop\classes\
 * Qualified Name:     org.primefaces.sentinel.Document
 * JD-Core Version:    0.6.0
 */