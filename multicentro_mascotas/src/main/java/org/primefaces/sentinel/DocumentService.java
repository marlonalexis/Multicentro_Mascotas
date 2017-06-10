/*    */ package org.primefaces.sentinel;
/*    */ 
/*    */ import javax.faces.bean.ApplicationScoped;
/*    */ import javax.faces.bean.ManagedBean;
/*    */ import org.primefaces.model.CheckboxTreeNode;
/*    */ import org.primefaces.model.DefaultTreeNode;
/*    */ import org.primefaces.model.TreeNode;
/*    */ 
/*    */ @ManagedBean(name="documentService")
/*    */ @ApplicationScoped
/*    */ public class DocumentService
/*    */ {
/*    */   public TreeNode createDocuments()
/*    */   {
/* 29 */     TreeNode root = new DefaultTreeNode(new Document("Files", "-", "Folder"), null);
/*    */ 
/* 31 */     TreeNode documents = new DefaultTreeNode(new Document("Documents", "-", "Folder"), root);
/* 32 */     TreeNode pictures = new DefaultTreeNode(new Document("Pictures", "-", "Folder"), root);
/* 33 */     TreeNode movies = new DefaultTreeNode(new Document("Movies", "-", "Folder"), root);
/*    */ 
/* 35 */     TreeNode work = new DefaultTreeNode(new Document("Work", "-", "Folder"), documents);
/* 36 */     TreeNode primefaces = new DefaultTreeNode(new Document("PrimeFaces", "-", "Folder"), documents);
/*    */ 
/* 39 */     TreeNode expenses = new DefaultTreeNode("document", new Document("Expenses.doc", "30 KB", "Word Document"), work);
/* 40 */     TreeNode resume = new DefaultTreeNode("document", new Document("Resume.doc", "10 KB", "Word Document"), work);
/* 41 */     TreeNode refdoc = new DefaultTreeNode("document", new Document("RefDoc.pages", "40 KB", "Pages Document"), primefaces);
/*    */ 
/* 44 */     TreeNode barca = new DefaultTreeNode("picture", new Document("barcelona.jpg", "30 KB", "JPEG Image"), pictures);
/* 45 */     TreeNode primelogo = new DefaultTreeNode("picture", new Document("logo.jpg", "45 KB", "JPEG Image"), pictures);
/* 46 */     TreeNode optimus = new DefaultTreeNode("picture", new Document("optimusprime.png", "96 KB", "PNG Image"), pictures);
/*    */ 
/* 49 */     TreeNode pacino = new DefaultTreeNode(new Document("Al Pacino", "-", "Folder"), movies);
/* 50 */     TreeNode deniro = new DefaultTreeNode(new Document("Robert De Niro", "-", "Folder"), movies);
/*    */ 
/* 52 */     TreeNode scarface = new DefaultTreeNode("mp3", new Document("Scarface", "15 GB", "Movie File"), pacino);
/* 53 */     TreeNode carlitosWay = new DefaultTreeNode("mp3", new Document("Carlitos' Way", "24 GB", "Movie File"), pacino);
/*    */ 
/* 55 */     TreeNode goodfellas = new DefaultTreeNode("mp3", new Document("Goodfellas", "23 GB", "Movie File"), deniro);
/* 56 */     TreeNode untouchables = new DefaultTreeNode("mp3", new Document("Untouchables", "17 GB", "Movie File"), deniro);
/*    */ 
/* 58 */     return root;
/*    */   }
/*    */ 
/*    */   public TreeNode createCheckboxDocuments() {
/* 62 */     TreeNode root = new CheckboxTreeNode(new Document("Files", "-", "Folder"), null);
/*    */ 
/* 64 */     TreeNode documents = new CheckboxTreeNode(new Document("Documents", "-", "Folder"), root);
/* 65 */     TreeNode pictures = new CheckboxTreeNode(new Document("Pictures", "-", "Folder"), root);
/* 66 */     TreeNode movies = new CheckboxTreeNode(new Document("Movies", "-", "Folder"), root);
/*    */ 
/* 68 */     TreeNode work = new CheckboxTreeNode(new Document("Work", "-", "Folder"), documents);
/* 69 */     TreeNode primefaces = new CheckboxTreeNode(new Document("PrimeFaces", "-", "Folder"), documents);
/*    */ 
/* 72 */     TreeNode expenses = new CheckboxTreeNode("document", new Document("Expenses.doc", "30 KB", "Word Document"), work);
/* 73 */     TreeNode resume = new CheckboxTreeNode("document", new Document("Resume.doc", "10 KB", "Word Document"), work);
/* 74 */     TreeNode refdoc = new CheckboxTreeNode("document", new Document("RefDoc.pages", "40 KB", "Pages Document"), primefaces);
/*    */ 
/* 77 */     TreeNode barca = new CheckboxTreeNode("picture", new Document("barcelona.jpg", "30 KB", "JPEG Image"), pictures);
/* 78 */     TreeNode primelogo = new CheckboxTreeNode("picture", new Document("logo.jpg", "45 KB", "JPEG Image"), pictures);
/* 79 */     TreeNode optimus = new CheckboxTreeNode("picture", new Document("optimusprime.png", "96 KB", "PNG Image"), pictures);
/*    */ 
/* 82 */     TreeNode pacino = new CheckboxTreeNode(new Document("Al Pacino", "-", "Folder"), movies);
/* 83 */     TreeNode deniro = new CheckboxTreeNode(new Document("Robert De Niro", "-", "Folder"), movies);
/*    */ 
/* 85 */     TreeNode scarface = new CheckboxTreeNode("mp3", new Document("Scarface", "15 GB", "Movie File"), pacino);
/* 86 */     TreeNode carlitosWay = new CheckboxTreeNode("mp3", new Document("Carlitos' Way", "24 GB", "Movie File"), pacino);
/*    */ 
/* 88 */     TreeNode goodfellas = new CheckboxTreeNode("mp3", new Document("Goodfellas", "23 GB", "Movie File"), deniro);
/* 89 */     TreeNode untouchables = new CheckboxTreeNode("mp3", new Document("Untouchables", "17 GB", "Movie File"), deniro);
/*    */ 
/* 91 */     return root;
/*    */   }
/*    */ }

/* Location:           C:\Users\jbravo\Desktop\classes\
 * Qualified Name:     org.primefaces.sentinel.DocumentService
 * JD-Core Version:    0.6.0
 */