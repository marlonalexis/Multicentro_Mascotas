/*    */ package org.primefaces.sentinel;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import javax.faces.application.FacesMessage;
/*    */ import javax.faces.component.UIComponent;
/*    */ import javax.faces.context.ExternalContext;
/*    */ import javax.faces.context.FacesContext;
/*    */ import javax.faces.convert.Converter;
/*    */ import javax.faces.convert.ConverterException;
/*    */ import javax.faces.convert.FacesConverter;
/*    */ 
/*    */ @FacesConverter("themeConverter")
/*    */ public class ThemeConverter
/*    */   implements Converter
/*    */ {
/*    */   public Object getAsObject(FacesContext fc, UIComponent uic, String value)
/*    */   {
/* 30 */     if ((value != null) && (value.trim().length() > 0)) {
/*    */       try {
/* 32 */         ThemeService service = (ThemeService)fc.getExternalContext().getApplicationMap().get("themeService");
/* 33 */         return service.getThemes().get(Integer.parseInt(value));
/*    */       } catch (NumberFormatException e) {
/* 35 */         throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
/*    */       }
/*    */     }
/*    */ 
/* 39 */     return null;
/*    */   }
/*    */ 
/*    */   public String getAsString(FacesContext fc, UIComponent uic, Object object)
/*    */   {
/* 44 */     if (object != null) {
/* 45 */       return String.valueOf(((Theme)object).getId());
/*    */     }
/*    */ 
/* 48 */     return null;
/*    */   }
/*    */ }

/* Location:           C:\Users\jbravo\Desktop\classes\
 * Qualified Name:     org.primefaces.sentinel.ThemeConverter
 * JD-Core Version:    0.6.0
 */