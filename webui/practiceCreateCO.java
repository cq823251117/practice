/*===========================================================================+
 |   Copyright (c) 2001, 2005 Oracle Corporation, Redwood Shores, CA, USA    |
 |                         All rights reserved.                              |
 +===========================================================================+
 |  HISTORY                                                                  |
 +===========================================================================*/
package oracle.apps.ak.practice.webui;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAApplicationModule;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import com.sun.java.util.collections.HashMap;
import java.io.Serializable;
import oracle.apps.fnd.common.MessageToken;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.OAViewObject;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.webui.TransactionUnitHelper;
import oracle.jbo.domain.Number;

/**
 * Controller for ...
 */
public class practiceCreateCO extends OAControllerImpl
{
  public static final String RCS_ID="$Header$";
  public static final boolean RCS_ID_RECORDED =
        VersionInfo.recordClassVersion(RCS_ID, "%packagename%");

  /**
   * Layout and page setup logic for a region.
   * @param pageContext the current OA page context
   * @param webBean the web bean corresponding to the region
   */
  public void processRequest(OAPageContext pageContext, OAWebBean webBean)
  {
    super.processRequest(pageContext, webBean);
    //??AM???VO
     OAApplicationModule am=pageContext.getApplicationModule(webBean);
     String userId=(String)pageContext.getParameter("USER_ID");
     if(userId!=null&&!"".equals(userId)) {
         System.out.println("CreateCO update");
         HashMap parameters=new HashMap();
         Serializable[] methodParams={parameters};
         Class[] parameterType={parameters.getClass()};
         parameters.put("userid",userId);
         am.invokeMethod("search",methodParams,parameterType);
     }
     else{
         System.out.println("CreateCo create");
         am.invokeMethod("CreateUser");
     }
     
  }

  /**
   * Procedure to handle form submissions for form elements in
   * a region.
   * @param pageContext the current OA page context
   * @param webBean the web bean corresponding to the region
   */
  public void processFormRequest(OAPageContext pageContext, OAWebBean webBean)
  {
    super.processFormRequest(pageContext, webBean);
      OAApplicationModule am=pageContext.getApplicationModule(webBean);
      if(pageContext.getParameter("SaveBar")!=null) {
          am.invokeMethod("save");
          
          
     
            OAViewObject vo = (OAViewObject)am.findViewObject("practiceVO1");
            String username = (String)vo.getCurrentRow().getAttribute("UserName");
            Number userid = (Number)vo.getCurrentRow().getAttribute("UserId");
            String usernum = String.valueOf(userid.intValue());
            am.invokeMethod("apply");
            
            
            TransactionUnitHelper.endTransactionUnit(pageContext, "CreateUser");
            MessageToken[] tokens = { new MessageToken("USER_NAME", username),
            new MessageToken("USER_ID", usernum) };
            OAException confirmMessage = new OAException("CUX", "CUX_18726_MES",    tokens,
            OAException.CONFIRMATION, null);
            pageContext.putDialogMessage(confirmMessage);



            pageContext.forwardImmediately("OA.jsp?page=/oracle/apps/ak/practice/webui/practicePG",
                                         null,
                                         OAWebBeanConstants.KEEP_MENU_CONTEXT,
                                         null,
                                         null,
                                         true, // retain AM
                                         OAWebBeanConstants.ADD_BREAD_CRUMB_NO); 
        
      }
      
      else  if (pageContext.getParameter("update") != null)
      {
       OAViewObject vo = (OAViewObject)am.findViewObject("practiceVO1");
       String username = (String)vo.getCurrentRow().getAttribute("UserName");
       Number userid = (Number)vo.getCurrentRow().getAttribute("UserId");
       String usernum = String.valueOf(userid.intValue());
       am.invokeMethod("apply");
       
       
       TransactionUnitHelper.endTransactionUnit(pageContext, "CreateUser");
       MessageToken[] tokens = { new MessageToken("USER_NAME", username),
       new MessageToken("USER_ID", usernum) };
       OAException confirmMessage = new OAException("CUX", "CUX_18726_UPDATE",    tokens,
       OAException.CONFIRMATION, null);
       pageContext.putDialogMessage(confirmMessage);



       pageContext.forwardImmediately("OA.jsp?page=/oracle/apps/ak/practice/webui/practicePG",
                                    null,
                                    OAWebBeanConstants.KEEP_MENU_CONTEXT,
                                    null,
                                    null,
                                    true, // retain AM
                                    OAWebBeanConstants.ADD_BREAD_CRUMB_NO); 
      }
      else if(pageContext.getParameter("CancelBar")!=null) {
          am.invokeMethod("rollback");
          pageContext.forwardImmediately("OA.jsp?page=/oracle/apps/ak/practice/webui/practicePG",
                                        null,
                                        OAWebBeanConstants.KEEP_MENU_CONTEXT,
                                        null,
                                        null,
                                        true, // retain AM
                                        OAWebBeanConstants.ADD_BREAD_CRUMB_NO);
      }
  }

}
