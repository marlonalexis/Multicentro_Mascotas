/*    */ package org.primefaces.sentinel.component.menu;
/*    */ 
/*    */ import java.util.Map;
/*    */ import javax.faces.application.ResourceDependencies;
/*    */ import javax.faces.component.StateHelper;
/*    */ import javax.faces.component.UINamingContainer;
/*    */ import javax.faces.context.FacesContext;
/*    */ import org.primefaces.component.api.Widget;
/*    */ import org.primefaces.component.menu.AbstractMenu;
/*    */ import org.primefaces.model.menu.MenuModel;
/*    */ 
/*    */ @ResourceDependencies({@javax.faces.application.ResourceDependency(library="primefaces", name="primefaces.css"), @javax.faces.application.ResourceDependency(library="primefaces", name="jquery/jquery.js"), @javax.faces.application.ResourceDependency(library="primefaces", name="jquery/jquery-plugins.js"), @javax.faces.application.ResourceDependency(library="primefaces", name="primefaces.js")})
/*    */ public class SentinelMenu extends AbstractMenu
/*    */   implements Widget
/*    */ {
/*    */   public static final String COMPONENT_TYPE = "org.primefaces.component.SentinelMenu";
/*    */   public static final String COMPONENT_FAMILY = "org.primefaces.component";
/*    */   private static final String DEFAULT_RENDERER = "org.primefaces.component.SentinelMenuRenderer";
/*    */ 
/*    */   public SentinelMenu()
/*    */   {
/* 56 */     setRendererType("org.primefaces.component.SentinelMenuRenderer");
/*    */   }
/*    */ 
/*    */   public String getFamily() {
/* 60 */     return "org.primefaces.component";
/*    */   }
/*    */ 
/*    */   public String getWidgetVar() {
/* 64 */     return (String)getStateHelper().eval(PropertyKeys.widgetVar, null);
/*    */   }
/*    */   public void setWidgetVar(String _widgetVar) {
/* 67 */     getStateHelper().put(PropertyKeys.widgetVar, _widgetVar);
/*    */   }
/*    */ 
/*    */   public MenuModel getModel() {
/* 71 */     return (MenuModel)getStateHelper().eval(PropertyKeys.model, null);
/*    */   }
/*    */   public void setModel(MenuModel _model) {
/* 74 */     getStateHelper().put(PropertyKeys.model, _model);
/*    */   }
/*    */ 
/*    */   public String getStyle() {
/* 78 */     return (String)getStateHelper().eval(PropertyKeys.style, null);
/*    */   }
/*    */   public void setStyle(String _style) {
/* 81 */     getStateHelper().put(PropertyKeys.style, _style);
/*    */   }
/*    */ 
/*    */   public String getStyleClass() {
/* 85 */     return (String)getStateHelper().eval(PropertyKeys.styleClass, null);
/*    */   }
/*    */   public void setStyleClass(String _styleClass) {
/* 88 */     getStateHelper().put(PropertyKeys.styleClass, _styleClass);
/*    */   }
/*    */ 
/*    */   public String resolveWidgetVar() {
/* 92 */     FacesContext context = getFacesContext();
/* 93 */     String userWidgetVar = (String)getAttributes().get("widgetVar");
/*    */ 
/* 95 */     if (userWidgetVar != null) {
/* 96 */       return userWidgetVar;
/*    */     }
/* 98 */     return "widget_" + getClientId(context).replaceAll(new StringBuilder().append("-|").append(UINamingContainer.getSeparatorChar(context)).toString(), "_");
/*    */   }
/*    */ 
/*    */   protected static enum PropertyKeys
/*    */   {
/* 37 */     widgetVar, 
/* 38 */     model, 
/* 39 */     style, 
/* 40 */     styleClass;
/*    */ 
/*    */     String toString;
/*    */ 
/* 45 */     private PropertyKeys(String toString) { this.toString = toString; }
/*    */ 
/*    */     private PropertyKeys() {
/*    */     }
/*    */ 
/*    */     public String toString() {
/* 51 */       return this.toString != null ? this.toString : super.toString();
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\jbravo\Desktop\classes\
 * Qualified Name:     org.primefaces.sentinel.component.menu.SentinelMenu
 * JD-Core Version:    0.6.0
 */