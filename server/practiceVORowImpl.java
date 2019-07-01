package oracle.apps.ak.practice.server;

import oracle.apps.ak.practice.schema.practiceEOImpl;
import oracle.apps.fnd.framework.server.OAViewRowImpl;

import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class practiceVORowImpl extends OAViewRowImpl {
    public static final int USERID = 0;
    public static final int USERNAME = 1;
    public static final int STARTDATE = 2;
    public static final int ENDDATE = 3;
    public static final int EMAILADDRESS = 4;
    public static final int LASTUPDATEDATE = 5;
    public static final int LASTUPDATEDBY = 6;
    public static final int CREATIONDATE = 7;
    public static final int CREATEDBY = 8;
    public static final int LASTUPDATELOGIN = 9;

    /**This is the default constructor (do not remove)
     */
    public practiceVORowImpl() {
    }

    /**Gets the attribute value for the calculated attribute UserId
     */
    public Number getUserId() {
        return (Number) getAttributeInternal(USERID);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute UserId
     */
    public void setUserId(Number value) {
        setAttributeInternal(USERID, value);
    }

    /**Gets the attribute value for the calculated attribute UserName
     */
    public String getUserName() {
        return (String) getAttributeInternal(USERNAME);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute UserName
     */
    public void setUserName(String value) {
        setAttributeInternal(USERNAME, value);
    }

    /**Gets the attribute value for the calculated attribute StartDate
     */
    public Date getStartDate() {
        return (Date) getAttributeInternal(STARTDATE);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute StartDate
     */
    public void setStartDate(Date value) {
        setAttributeInternal(STARTDATE, value);
    }

    /**Gets the attribute value for the calculated attribute EndDate
     */
    public Date getEndDate() {
        return (Date) getAttributeInternal(ENDDATE);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute EndDate
     */
    public void setEndDate(Date value) {
        setAttributeInternal(ENDDATE, value);
    }

    /**Gets the attribute value for the calculated attribute EmailAddress
     */
    public String getEmailAddress() {
        return (String) getAttributeInternal(EMAILADDRESS);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute EmailAddress
     */
    public void setEmailAddress(String value) {
        setAttributeInternal(EMAILADDRESS, value);
    }

    /**Gets the attribute value for the calculated attribute LastUpdateDate
     */
    public Date getLastUpdateDate() {
        return (Date) getAttributeInternal(LASTUPDATEDATE);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute LastUpdateDate
     */
    public void setLastUpdateDate(Date value) {
        setAttributeInternal(LASTUPDATEDATE, value);
    }

    /**Gets the attribute value for the calculated attribute LastUpdatedBy
     */
    public Number getLastUpdatedBy() {
        return (Number) getAttributeInternal(LASTUPDATEDBY);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute LastUpdatedBy
     */
    public void setLastUpdatedBy(Number value) {
        setAttributeInternal(LASTUPDATEDBY, value);
    }

    /**Gets the attribute value for the calculated attribute CreationDate
     */
    public Date getCreationDate() {
        return (Date) getAttributeInternal(CREATIONDATE);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute CreationDate
     */
    public void setCreationDate(Date value) {
        setAttributeInternal(CREATIONDATE, value);
    }

    /**Gets the attribute value for the calculated attribute CreatedBy
     */
    public Number getCreatedBy() {
        return (Number) getAttributeInternal(CREATEDBY);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute CreatedBy
     */
    public void setCreatedBy(Number value) {
        setAttributeInternal(CREATEDBY, value);
    }

    /**Gets the attribute value for the calculated attribute LastUpdateLogin
     */
    public Number getLastUpdateLogin() {
        return (Number) getAttributeInternal(LASTUPDATELOGIN);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute LastUpdateLogin
     */
    public void setLastUpdateLogin(Number value) {
        setAttributeInternal(LASTUPDATELOGIN, value);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case USERID:
            return getUserId();
        case USERNAME:
            return getUserName();
        case STARTDATE:
            return getStartDate();
        case ENDDATE:
            return getEndDate();
        case EMAILADDRESS:
            return getEmailAddress();
        case LASTUPDATEDATE:
            return getLastUpdateDate();
        case LASTUPDATEDBY:
            return getLastUpdatedBy();
        case CREATIONDATE:
            return getCreationDate();
        case CREATEDBY:
            return getCreatedBy();
        case LASTUPDATELOGIN:
            return getLastUpdateLogin();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case USERID:
            setUserId((Number)value);
            return;
        case USERNAME:
            setUserName((String)value);
            return;
        case STARTDATE:
            setStartDate((Date)value);
            return;
        case ENDDATE:
            setEndDate((Date)value);
            return;
        case EMAILADDRESS:
            setEmailAddress((String)value);
            return;
        case LASTUPDATEDATE:
            setLastUpdateDate((Date)value);
            return;
        case LASTUPDATEDBY:
            setLastUpdatedBy((Number)value);
            return;
        case CREATIONDATE:
            setCreationDate((Date)value);
            return;
        case CREATEDBY:
            setCreatedBy((Number)value);
            return;
        case LASTUPDATELOGIN:
            setLastUpdateLogin((Number)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }

    /**Gets practiceEO entity object.
     */
    public practiceEOImpl getpracticeEO() {
        return (practiceEOImpl)getEntity(0);
    }
}