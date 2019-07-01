/*===========================================================================+
 |   Copyright (c) 2001, 2005 Oracle Corporation, Redwood Shores, CA, USA    |
 |                         All rights reserved.                              |
 +===========================================================================+
 |  HISTORY                                                                  |
 +===========================================================================*/
package oracle.apps.ak.practice.webui;

import com.sun.java.util.collections.HashMap;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.servlet.http.HttpServletResponse;

import javax.swing.JOptionPane;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAApplicationModule;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageTextInputBean;

/**
 * Controller for ...
 */
public class practiceCO extends OAControllerImpl
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
      OAApplicationModule am=pageContext.getApplicationModule(webBean);
      System.out.println("co init");
      am.invokeMethod("initSearch");
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
    
      System.out.println("co2go1");
      
      
      
      String event=pageContext.getParameter(EVENT_PARAM);
      OAApplicationModule am=pageContext.getApplicationModule(webBean);
      if(pageContext.getParameter("go")!=null) {
          String userid = (String)pageContext.getParameter("userid");
          String username=(String)pageContext.getParameter("username");
          HashMap parameters=new HashMap();
          parameters.put("userid",userid);
          parameters.put("username",username);
          Serializable[] methodParams={parameters};
          Class[] parameterType={parameters.getClass()};
          
          System.out.println("co2go2");
          am.invokeMethod("search",methodParams,parameterType);
      }
      if(pageContext.getParameter("CreateBtn")!=null) {
          System.out.println("createBtn click");
          pageContext.forwardImmediately("OA.jsp?page=/oracle/apps/ak/practice/webui/practiceCreatePG",
                                        null,
                                        OAWebBeanConstants.KEEP_MENU_CONTEXT,
                                        null,
                                        null,
                                        true, // retain AM
                                        OAWebBeanConstants.ADD_BREAD_CRUMB_NO);
            
      }
      if("Update".equals(event)) {
          System.out.println("updateBtn click");
          String userId=(String)pageContext.getParameter("USER_ID");
          HashMap parameter=new HashMap();
          parameter.put("USER_ID",userId);
          pageContext.forwardImmediately("OA.jsp?page=/oracle/apps/ak/practice/webui/practiceCreatePG",
                                        null,
                                        OAWebBeanConstants.KEEP_MENU_CONTEXT,
                                        null,
                                        parameter,
                                        true, // retain AM
                                        OAWebBeanConstants.ADD_BREAD_CRUMB_NO);
          
      }
      if ("Delete".equals(event)){
          String userId=(String)pageContext.getParameter("USER_ID");
          Serializable[] methodParams={userId};
          
      
              
          int res=JOptionPane.showConfirmDialog(null, "delete?", "confirm", JOptionPane.YES_NO_OPTION);
          System.out.println(res);
          if(res==JOptionPane.YES_OPTION){ 
               am.invokeMethod("deleteUser",methodParams);
           }
                      
      }
      if(pageContext.getParameter("clear")!=null) {
           //OAMessageTextInputBean na =new OAMessageTextInputBean("userid");
            OAMessageTextInputBean na=(OAMessageTextInputBean)webBean.findChildRecursive("userid");
            na.setValue(pageContext,"");
            OAMessageTextInputBean nb=(OAMessageTextInputBean)webBean.findChildRecursive("username");
            nb.setValue(pageContext,"");
      }
  }

}
