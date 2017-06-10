/*    */ package org.primefaces.sentinel;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import javax.annotation.PostConstruct;
/*    */ import javax.faces.application.FacesMessage;
/*    */ import javax.faces.bean.ManagedBean;
/*    */ import javax.faces.bean.ViewScoped;
/*    */ import javax.faces.context.FacesContext;
/*    */ import org.primefaces.event.TreeDragDropEvent;
/*    */ import org.primefaces.model.DefaultTreeNode;
/*    */ import org.primefaces.model.TreeNode;
/*    */ 
/*    */ @ManagedBean(name="treeDNDView")
/*    */ @ViewScoped
/*    */ public class DragDropView
/*    */   implements Serializable
/*    */ {
/*    */   private TreeNode root1;
/*    */   private TreeNode root2;
/*    */   private TreeNode selectedNode1;
/*    */   private TreeNode selectedNode2;
/*    */ 
/*    */   @PostConstruct
/*    */   public void init()
/*    */   {
/* 27 */     this.root1 = new DefaultTreeNode("Root", null);
/* 28 */     TreeNode node0 = new DefaultTreeNode("Node 0", this.root1);
/* 29 */     TreeNode node1 = new DefaultTreeNode("Node 1", this.root1);
/* 30 */     TreeNode node2 = new DefaultTreeNode("Node 2", this.root1);
/*    */ 
/* 32 */     TreeNode node00 = new DefaultTreeNode("Node 0.0", node0);
/* 33 */     TreeNode node01 = new DefaultTreeNode("Node 0.1", node0);
/*    */ 
/* 35 */     TreeNode node10 = new DefaultTreeNode("Node 1.0", node1);
/* 36 */     TreeNode node11 = new DefaultTreeNode("Node 1.1", node1);
/*    */ 
/* 38 */     TreeNode node000 = new DefaultTreeNode("Node 0.0.0", node00);
/* 39 */     TreeNode node001 = new DefaultTreeNode("Node 0.0.1", node00);
/* 40 */     TreeNode node010 = new DefaultTreeNode("Node 0.1.0", node01);
/*    */ 
/* 42 */     TreeNode node100 = new DefaultTreeNode("Node 1.0.0", node10);
/*    */ 
/* 44 */     this.root2 = new DefaultTreeNode("Root2", null);
/* 45 */     TreeNode item0 = new DefaultTreeNode("Item 0", this.root2);
/* 46 */     TreeNode item1 = new DefaultTreeNode("Item 1", this.root2);
/* 47 */     TreeNode item2 = new DefaultTreeNode("Item 2", this.root2);
/*    */ 
/* 49 */     TreeNode item00 = new DefaultTreeNode("Item 0.0", item0);
/*    */   }
/*    */ 
/*    */   public TreeNode getRoot1() {
/* 53 */     return this.root1;
/*    */   }
/*    */ 
/*    */   public TreeNode getRoot2() {
/* 57 */     return this.root2;
/*    */   }
/*    */ 
/*    */   public TreeNode getSelectedNode1() {
/* 61 */     return this.selectedNode1;
/*    */   }
/*    */ 
/*    */   public void setSelectedNode1(TreeNode selectedNode1) {
/* 65 */     this.selectedNode1 = selectedNode1;
/*    */   }
/*    */ 
/*    */   public TreeNode getSelectedNode2() {
/* 69 */     return this.selectedNode2;
/*    */   }
/*    */ 
/*    */   public void setSelectedNode2(TreeNode selectedNode2) {
/* 73 */     this.selectedNode2 = selectedNode2;
/*    */   }
/*    */ 
/*    */   public void onDragDrop(TreeDragDropEvent event) {
/* 77 */     TreeNode dragNode = event.getDragNode();
/* 78 */     TreeNode dropNode = event.getDropNode();
/* 79 */     int dropIndex = event.getDropIndex();
/*    */ 
/* 81 */     FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dragged " + dragNode.getData(), "Dropped on " + dropNode.getData() + " at " + dropIndex);
/* 82 */     FacesContext.getCurrentInstance().addMessage(null, message);
/*    */   }
/*    */ }

/* Location:           C:\Users\jbravo\Desktop\classes\
 * Qualified Name:     org.primefaces.sentinel.DragDropView
 * JD-Core Version:    0.6.0
 */