/*     */ package org.primefaces.sentinel.component.menu;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.faces.FacesException;
/*     */ import javax.faces.component.UIComponent;
/*     */ import javax.faces.context.FacesContext;
/*     */ import javax.faces.context.ResponseWriter;
/*     */ import org.primefaces.component.api.AjaxSource;
/*     */ import org.primefaces.component.api.UIOutcomeTarget;
/*     */ import org.primefaces.component.menu.AbstractMenu;
/*     */ import org.primefaces.component.menu.BaseMenuRenderer;
/*     */ import org.primefaces.model.menu.MenuElement;
/*     */ import org.primefaces.model.menu.MenuItem;
/*     */ import org.primefaces.model.menu.Separator;
/*     */ import org.primefaces.model.menu.Submenu;
/*     */ import org.primefaces.util.ComponentUtils;
/*     */ 
/*     */ public class SentinelMenuRenderer extends BaseMenuRenderer
/*     */ {
/*     */   protected void encodeMarkup(FacesContext context, AbstractMenu abstractMenu)
/*     */     throws IOException
/*     */   {
/*  41 */     SentinelMenu menu = (SentinelMenu)abstractMenu;
/*  42 */     ResponseWriter writer = context.getResponseWriter();
/*  43 */     String clientId = menu.getClientId(context);
/*  44 */     String style = menu.getStyle();
/*  45 */     String styleClass = menu.getStyleClass();
/*  46 */     styleClass = "layout-menubar-container " + styleClass;
/*     */ 
/*  48 */     writer.startElement("ul", menu);
/*  49 */     if (shouldRenderId(null)) {
/*  50 */       writer.writeAttribute("id", clientId, "id");
/*     */     }
/*  52 */     writer.writeAttribute("class", styleClass, "styleClass");
/*  53 */     if (style != null) {
/*  54 */       writer.writeAttribute("style", style, "style");
/*     */     }
/*     */ 
/*  57 */     if (menu.getElementsCount() > 0) {
/*  58 */       encodeElements(context, menu, menu.getElements(), 0);
/*     */     }
/*     */ 
/*  61 */     writer.endElement("ul");
/*     */   }
/*     */ 
/*     */   protected void encodeElements(FacesContext context, AbstractMenu menu, List<MenuElement> elements, int marginLevel) throws IOException {
/*  65 */     ResponseWriter writer = context.getResponseWriter();
/*  66 */     String menuClientId = menu.getClientId(context);
/*     */ 
/*  68 */     for (MenuElement element : elements)
/*  69 */       if (element.isRendered())
/*  70 */         if ((element instanceof MenuItem)) {
/*  71 */           MenuItem menuItem = (MenuItem)element;
/*  72 */           String menuItemClientId = menuClientId + "_" + menuItem.getClientId();
/*  73 */           String containerStyle = menuItem.getContainerStyle();
/*  74 */           String containerStyleClass = menuItem.getContainerStyleClass();
/*     */ 
/*  76 */           writer.startElement("li", null);
/*  77 */           writer.writeAttribute("id", menuItemClientId, null);
/*  78 */           writer.writeAttribute("role", "menuitem", null);
/*     */ 
/*  80 */           if (containerStyle != null) writer.writeAttribute("style", containerStyle, null);
/*  81 */           if (containerStyleClass != null) writer.writeAttribute("class", containerStyleClass, null);
/*     */ 
/*  83 */           encodeMenuItem(context, menu, menuItem, marginLevel);
/*     */ 
/*  85 */           writer.endElement("li");
/*     */         }
/*  87 */         else if ((element instanceof Submenu)) {
/*  88 */           Submenu submenu = (Submenu)element;
/*  89 */           String submenuClientId = menuClientId + "_" + submenu.getClientId();
/*  90 */           String style = submenu.getStyle();
/*  91 */           String styleClass = submenu.getStyleClass();
/*     */ 
/*  93 */           writer.startElement("li", null);
/*  94 */           writer.writeAttribute("id", submenuClientId, null);
/*  95 */           writer.writeAttribute("role", "menuitem", null);
/*     */ 
/*  97 */           if (style != null) writer.writeAttribute("style", style, null);
/*  98 */           if (styleClass != null) writer.writeAttribute("class", styleClass, null);
/*     */ 
/* 100 */           encodeSubmenu(context, menu, submenu, marginLevel);
/*     */ 
/* 102 */           writer.endElement("li");
/*     */         }
/* 104 */         else if ((element instanceof Separator)) {
/* 105 */           encodeSeparator(context, (Separator)element);
/*     */         }
/*     */   }
/*     */ 
/*     */   protected void encodeMenuItem(FacesContext context, AbstractMenu menu, MenuItem menuitem, int marginLevel)
/*     */     throws IOException
/*     */   {
/* 112 */     ResponseWriter writer = context.getResponseWriter();
/* 113 */     String title = menuitem.getTitle();
/* 114 */     boolean disabled = menuitem.isDisabled();
/* 115 */     String style = menuitem.getStyle();
/*     */ 
/* 117 */     writer.startElement("a", null);
/* 118 */     if (title != null) writer.writeAttribute("title", title, null);
/* 119 */     if (style != null) writer.writeAttribute("style", style, null);
/* 120 */     if (marginLevel > 0) writer.writeAttribute("class", "marginLevel-" + marginLevel, null);
/*     */ 
/* 122 */     if (disabled) {
/* 123 */       writer.writeAttribute("href", "#", null);
/* 124 */       writer.writeAttribute("onclick", "return false;", null);
/*     */     }
/*     */     else {
/* 127 */       String onclick = menuitem.getOnclick();
/* 128 */       if (marginLevel == 0) {
/* 129 */         onclick = "Sentinel.toggleSubMenu(this);" + onclick;
/*     */       }
/*     */ 
/* 133 */       if ((menuitem.getUrl() != null) || (menuitem.getOutcome() != null)) {
/* 134 */         String targetURL = getTargetURL(context, (UIOutcomeTarget)menuitem);
/* 135 */         writer.writeAttribute("href", targetURL, null);
/*     */ 
/* 137 */         if (menuitem.getTarget() != null) {
/* 138 */           writer.writeAttribute("target", menuitem.getTarget(), null);
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 143 */         writer.writeAttribute("href", "#", null);
/*     */ 
/* 145 */         UIComponent form = ComponentUtils.findParentForm(context, menu);
/* 146 */         if (form == null)
/* 147 */           throw new FacesException("MenuItem must be inside a form element");
/*     */         String command;
/* 151 */         if (menuitem.isDynamic()) {
/* 152 */           String menuClientId = menu.getClientId(context);
/* 153 */           Map params = menuitem.getParams();
/* 154 */           if (params == null) {
/* 155 */             params = new LinkedHashMap();
/*     */           }
/* 157 */           List idParams = new ArrayList();
/* 158 */           idParams.add(menuitem.getId());
/* 159 */           params.put(menuClientId + "_menuid", idParams);
/*     */ 
/* 161 */           command = menuitem.isAjax() ? buildAjaxRequest(context, menu, (AjaxSource)menuitem, form, params) : buildNonAjaxRequest(context, menu, form, menuClientId, params, true);
/*     */         }
/*     */         else {
/* 164 */           command = menuitem.isAjax() ? buildAjaxRequest(context, (AjaxSource)menuitem, form) : buildNonAjaxRequest(context, (UIComponent)menuitem, form, ((UIComponent)menuitem).getClientId(context), true);
/*     */         }
/*     */ 
/* 167 */         onclick = onclick + ";" + command;
/*     */       }
/*     */ 
/* 170 */       if (onclick != null) {
/* 171 */         writer.writeAttribute("onclick", onclick, null);
/*     */       }
/*     */     }
/*     */ 
/* 175 */     encodeMenuItemContent(context, menu, menuitem);
/*     */ 
/* 177 */     writer.endElement("a");
/*     */   }
/*     */ 
/*     */   protected void encodeMenuItemContent(FacesContext context, AbstractMenu menu, MenuItem menuitem) throws IOException
/*     */   {
/* 182 */     ResponseWriter writer = context.getResponseWriter();
/* 183 */     String icon = menuitem.getIcon();
/* 184 */     Object value = menuitem.getValue();
/*     */ 
/* 186 */     if (icon != null) {
/* 187 */       writer.startElement("i", null);
/* 188 */       writer.writeAttribute("class", icon + " yellow i", null);
/* 189 */       writer.endElement("i");
/*     */     }
/*     */ 
/* 192 */     if (value != null)
/* 193 */       writer.writeText(" " + value, "value");
/*     */   }
/*     */ 
/*     */   protected void encodeSubmenu(FacesContext context, AbstractMenu menu, Submenu submenu, int marginLevel) throws IOException
/*     */   {
/* 198 */     ResponseWriter writer = context.getResponseWriter();
/* 199 */     String icon = submenu.getIcon();
/* 200 */     String label = submenu.getLabel();
/*     */ 
/* 203 */     writer.startElement("a", null);
/* 204 */     writer.writeAttribute("href", "#", null);
/* 205 */     writer.writeAttribute("onclick", "Sentinel.toggleSubMenu(this);return false;", null);
/* 206 */     if (marginLevel > 0) {
/* 207 */       writer.writeAttribute("class", "marginLevel-" + marginLevel, null);
/*     */     }
/*     */ 
/* 210 */     if (icon != null) {
/* 211 */       writer.startElement("i", null);
/* 212 */       writer.writeAttribute("class", icon + " yellow i", null);
/* 213 */       writer.endElement("i");
/*     */     }
/*     */ 
/* 216 */     if (label != null) {
/* 217 */       writer.writeText(label, null);
/*     */     }
/*     */ 
/* 220 */     writer.startElement("i", null);
/* 221 */     writer.writeAttribute("class", "icon-angle-down Fright", null);
/* 222 */     writer.endElement("i");
/*     */ 
/* 224 */     writer.endElement("a");
/*     */ 
/* 227 */     if (submenu.getElementsCount() > 0) {
/* 228 */       writer.startElement("ul", null);
/* 229 */       writer.writeAttribute("class", "layout-menubar-submenu-container", null);
/* 230 */       writer.writeAttribute("role", "menu", null);
/* 231 */       marginLevel++; encodeElements(context, menu, submenu.getElements(), marginLevel);
/* 232 */       writer.endElement("ul");
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void encodeScript(FacesContext context, AbstractMenu abstractMenu) throws IOException
/*     */   {
/* 238 */     ResponseWriter writer = context.getResponseWriter();
/* 239 */     writer.startElement("script", null);
/* 240 */     writer.writeAttribute("type", "text/javascript", null);
/* 241 */     writer.write("Sentinel.restoreMenuState();");
/* 242 */     writer.endElement("script");
/*     */   }
/*     */ }

/* Location:           C:\Users\jbravo\Desktop\classes\
 * Qualified Name:     org.primefaces.sentinel.component.menu.SentinelMenuRenderer
 * JD-Core Version:    0.6.0
 */