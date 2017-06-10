/*     */ package org.primefaces.sentinel;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.PostConstruct;
/*     */ import javax.faces.bean.ManagedBean;
/*     */ import javax.faces.bean.ManagedProperty;
/*     */ import javax.faces.bean.ViewScoped;
/*     */ import javax.faces.context.ExternalContext;
/*     */ import javax.faces.context.FacesContext;
/*     */ import org.primefaces.model.DefaultTreeNode;
/*     */ import org.primefaces.model.TreeNode;
/*     */ 
/*     */ @ManagedBean
/*     */ @ViewScoped
/*     */ public class ColumnManagerView
/*     */   implements Serializable
/*     */ {
/*     */   private final List<String> VALID_COLUMN_KEYS;
/*     */   private List<ColumnModel> columns;
/*     */   private List<Car> cars;
/*     */   private TreeNode availableColumns;
/*     */ 
/*     */   @ManagedProperty("#{carService}")
/*     */   private CarService service;
/*     */ 
/*     */   public ColumnManagerView()
/*     */   {
/*  35 */     this.VALID_COLUMN_KEYS = Arrays.asList(new String[] { "id", "brand", "year", "color" });
/*     */ 
/*  37 */     this.columns = new ArrayList();
/*     */   }
/*     */ 
/*     */   @PostConstruct
/*     */   public void init()
/*     */   {
/*  48 */     this.cars = this.service.createCars(9);
/*  49 */     createAvailableColumns();
/*  50 */     createDynamicColumns();
/*     */   }
/*     */ 
/*     */   private void createAvailableColumns() {
/*  54 */     this.availableColumns = new DefaultTreeNode("Root", null);
/*  55 */     TreeNode root = new DefaultTreeNode("Columns", this.availableColumns);
/*  56 */     root.setExpanded(true);
/*  57 */     TreeNode model = new DefaultTreeNode("column", new ColumnModel("Id", "id"), root);
/*  58 */     TreeNode year = new DefaultTreeNode("column", new ColumnModel("Year", "year"), root);
/*  59 */     TreeNode manufacturer = new DefaultTreeNode("column", new ColumnModel("Brand", "brand"), root);
/*  60 */     TreeNode color = new DefaultTreeNode("column", new ColumnModel("Color", "color"), root);
/*     */   }
/*     */ 
/*     */   public void createDynamicColumns() {
/*  64 */     String[] columnKeys = { "id", "year", "brand" };
/*  65 */     this.columns.clear();
/*     */ 
/*  67 */     for (String columnKey : columnKeys) {
/*  68 */       String key = columnKey.trim();
/*     */ 
/*  70 */       if (this.VALID_COLUMN_KEYS.contains(key))
/*  71 */         this.columns.add(new ColumnModel(columnKey.toUpperCase(), columnKey));
/*     */     }
/*     */   }
/*     */ 
/*     */   public void treeToTable()
/*     */   {
/*  77 */     Map params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
/*  78 */     String property = (String)params.get("property");
/*  79 */     String droppedColumnId = (String)params.get("droppedColumnId");
/*  80 */     String dropPos = (String)params.get("dropPos");
/*     */ 
/*  82 */     String[] droppedColumnTokens = droppedColumnId.split(":");
/*  83 */     int draggedColumnIndex = Integer.parseInt(droppedColumnTokens[(droppedColumnTokens.length - 1)]);
/*  84 */     int dropColumnIndex = draggedColumnIndex + Integer.parseInt(dropPos);
/*     */ 
/*  87 */     this.columns.add(dropColumnIndex, new ColumnModel(property.toUpperCase(), property));
/*     */ 
/*  90 */     TreeNode root = (TreeNode)this.availableColumns.getChildren().get(0);
/*  91 */     for (TreeNode node : root.getChildren()) {
/*  92 */       ColumnModel model = (ColumnModel)node.getData();
/*  93 */       if (model.getProperty().equals(property)) {
/*  94 */         root.getChildren().remove(node);
/*  95 */         break;
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void tableToTree() {
/* 101 */     Map params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
/* 102 */     int colIndex = Integer.parseInt((String)params.get("colIndex"));
/*     */ 
/* 105 */     ColumnModel model = (ColumnModel)this.columns.remove(colIndex);
/*     */ 
/* 108 */     TreeNode property = new DefaultTreeNode("column", model, (TreeNode)this.availableColumns.getChildren().get(0));
/*     */   }
/*     */ 
/*     */   public List<Car> getCars() {
/* 112 */     return this.cars;
/*     */   }
/*     */ 
/*     */   public List<ColumnModel> getColumns() {
/* 116 */     return this.columns;
/*     */   }
/*     */ 
/*     */   public TreeNode getAvailableColumns() {
/* 120 */     return this.availableColumns;
/*     */   }
/*     */ 
/*     */   public void setService(CarService service) {
/* 124 */     this.service = service;
/*     */   }
/*     */   public static class ColumnModel implements Serializable {
/*     */     private String header;
/*     */     private String property;
/*     */ 
/*     */     public ColumnModel(String header, String property) {
/* 133 */       this.header = header;
/* 134 */       this.property = property;
/*     */     }
/*     */ 
/*     */     public String getHeader() {
/* 138 */       return this.header;
/*     */     }
/*     */ 
/*     */     public String getProperty() {
/* 142 */       return this.property;
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\jbravo\Desktop\classes\
 * Qualified Name:     org.primefaces.sentinel.ColumnManagerView
 * JD-Core Version:    0.6.0
 */