/*    */ package org.primefaces.sentinel;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import javax.annotation.PostConstruct;
/*    */ import javax.faces.bean.ManagedBean;
/*    */ import javax.faces.bean.ManagedProperty;
/*    */ import javax.faces.bean.ViewScoped;
/*    */ import org.primefaces.model.TreeNode;
/*    */ 
/*    */ @ManagedBean(name="treeSelectionView")
/*    */ @ViewScoped
/*    */ public class SelectionView
/*    */   implements Serializable
/*    */ {
/*    */   private TreeNode root1;
/*    */   private TreeNode root2;
/*    */   private TreeNode selectedNode;
/*    */   private TreeNode[] selectedNodes1;
/*    */ 
/*    */   @ManagedProperty("#{documentService}")
/*    */   private DocumentService service;
/*    */ 
/*    */   @PostConstruct
/*    */   public void init()
/*    */   {
/* 41 */     this.root1 = this.service.createDocuments();
/* 42 */     this.root2 = this.service.createCheckboxDocuments();
/*    */   }
/*    */ 
/*    */   public TreeNode getRoot1() {
/* 46 */     return this.root1;
/*    */   }
/*    */ 
/*    */   public TreeNode getRoot2() {
/* 50 */     return this.root2;
/*    */   }
/*    */ 
/*    */   public TreeNode getSelectedNode() {
/* 54 */     return this.selectedNode;
/*    */   }
/*    */ 
/*    */   public void setSelectedNode(TreeNode selectedNode) {
/* 58 */     this.selectedNode = selectedNode;
/*    */   }
/*    */ 
/*    */   public TreeNode[] getSelectedNodes1() {
/* 62 */     return this.selectedNodes1;
/*    */   }
/*    */ 
/*    */   public void setSelectedNodes1(TreeNode[] selectedNodes1) {
/* 66 */     this.selectedNodes1 = selectedNodes1;
/*    */   }
/*    */ 
/*    */   public void setService(DocumentService service) {
/* 70 */     this.service = service;
/*    */   }
/*    */ }

/* Location:           C:\Users\jbravo\Desktop\classes\
 * Qualified Name:     org.primefaces.sentinel.SelectionView
 * JD-Core Version:    0.6.0
 */