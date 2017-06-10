/*    */ package org.primefaces.sentinel;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.annotation.PostConstruct;
/*    */ import javax.faces.bean.ManagedBean;
/*    */ import javax.faces.model.SelectItem;
/*    */ import javax.faces.model.SelectItemGroup;
/*    */ 
/*    */ @ManagedBean
/*    */ public class MultiSelectView
/*    */ {
/*    */   private List<SelectItem> categories;
/*    */   private String selection;
/*    */ 
/*    */   @PostConstruct
/*    */   public void init()
/*    */   {
/* 33 */     this.categories = new ArrayList();
/* 34 */     SelectItemGroup group1 = new SelectItemGroup("Group 1");
/* 35 */     SelectItemGroup group2 = new SelectItemGroup("Group 2");
/* 36 */     SelectItemGroup group3 = new SelectItemGroup("Group 3");
/* 37 */     SelectItemGroup group4 = new SelectItemGroup("Group 4");
/*    */ 
/* 39 */     SelectItemGroup group11 = new SelectItemGroup("Group 1.1");
/* 40 */     SelectItemGroup group12 = new SelectItemGroup("Group 1.2");
/*    */ 
/* 42 */     SelectItemGroup group21 = new SelectItemGroup("Group 2.1");
/*    */ 
/* 44 */     SelectItem option31 = new SelectItem("Option 3.1", "Option 3.1");
/* 45 */     SelectItem option32 = new SelectItem("Option 3.2", "Option 3.2");
/* 46 */     SelectItem option33 = new SelectItem("Option 3.3", "Option 3.3");
/* 47 */     SelectItem option34 = new SelectItem("Option 3.4", "Option 3.4");
/*    */ 
/* 49 */     SelectItem option41 = new SelectItem("Option 4.1", "Option 4.1");
/*    */ 
/* 51 */     SelectItem option111 = new SelectItem("Option 1.1.1");
/* 52 */     SelectItem option112 = new SelectItem("Option 1.1.2");
/* 53 */     group11.setSelectItems(new SelectItem[] { option111, option112 });
/*    */ 
/* 55 */     SelectItem option121 = new SelectItem("Option 1.2.1", "Option 1.2.1");
/* 56 */     SelectItem option122 = new SelectItem("Option 1.2.2", "Option 1.2.2");
/* 57 */     SelectItem option123 = new SelectItem("Option 1.2.3", "Option 1.2.3");
/* 58 */     group12.setSelectItems(new SelectItem[] { option121, option122, option123 });
/*    */ 
/* 60 */     SelectItem option211 = new SelectItem("Option 2.1.1", "Option 2.1.1");
/* 61 */     group21.setSelectItems(new SelectItem[] { option211 });
/*    */ 
/* 63 */     group1.setSelectItems(new SelectItem[] { group11, group12 });
/* 64 */     group2.setSelectItems(new SelectItem[] { group21 });
/* 65 */     group3.setSelectItems(new SelectItem[] { option31, option32, option33, option34 });
/* 66 */     group4.setSelectItems(new SelectItem[] { option41 });
/*    */ 
/* 68 */     this.categories.add(group1);
/* 69 */     this.categories.add(group2);
/* 70 */     this.categories.add(group3);
/* 71 */     this.categories.add(group4);
/*    */   }
/*    */ 
/*    */   public List<SelectItem> getCategories() {
/* 75 */     return this.categories;
/*    */   }
/*    */ 
/*    */   public String getSelection() {
/* 79 */     return this.selection;
/*    */   }
/*    */   public void setSelection(String selection) {
/* 82 */     this.selection = selection;
/*    */   }
/*    */ }

/* Location:           C:\Users\jbravo\Desktop\classes\
 * Qualified Name:     org.primefaces.sentinel.MultiSelectView
 * JD-Core Version:    0.6.0
 */