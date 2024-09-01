package nc.vo.caigoudingdan.caigoudingd_zgl;

import nc.vo.pub.*;
import nc.vo.pubapp.pattern.model.meta.entity.vo.VOMetaFactory;

public class Caigoudingd_zglMasterVO extends SuperVO {

	//构造方法
	public Caigoudingd_zglMasterVO() {
		super();
	}


    private nc.vo.pub.lang.UFDate actualinvalidate  ;
    private java.lang.String pk_supplier  ;
    private java.lang.String ccurrencyid  ;
    private nc.vo.pub.lang.UFDouble ntotalastnum  ;
    private nc.vo.pub.lang.UFDouble ntotaltaxmny  ;
    private java.lang.String vmemo  ;
    private java.lang.String pk_cgdingdan_zglmaster  ;
    private java.lang.String pk_org  ;
    private java.lang.String pk_group  ;
    private java.lang.String code  ;
    private java.lang.String pk_org_v  ;
    private nc.vo.pub.lang.UFDateTime maketime  ;
    private nc.vo.pub.lang.UFDateTime lastmaketime  ;
    private java.lang.String creator  ;
    private nc.vo.pub.lang.UFDateTime creationtime  ;
    private java.lang.String modifier  ;
    private nc.vo.pub.lang.UFDateTime modifiedtime  ;
    private java.lang.String billversionpk  ;
    private java.lang.String billtype  ;
    private java.lang.String transtype  ;
    private java.lang.String transtypepk  ;
    private java.lang.String approvenote  ;
    private java.lang.String approver  ;
    private nc.vo.pub.lang.UFDateTime approvedate  ;
    private java.lang.Integer approvestatus  ;
    private java.lang.Integer emendenum  ;
    private java.lang.String billmaker  ;
    private java.lang.String srcbillid  ;
    private java.lang.String srcbilltype  ;
    private java.lang.String busitype  ;
    private java.lang.Integer saga_frozen  ;
    private java.lang.String saga_gtxid  ;
    private java.lang.String saga_btxid  ;
    private java.lang.Integer saga_status  ;
    private java.lang.String vbillcode  ;
    private nc.vo.pub.lang.UFDate vbilldate  ;
    private java.lang.String cemployeeid  ;
    private java.lang.String pk_dept  ;
    private nc.vo.pub.lang.UFDate actualvalidate  ;
    private java.lang.Integer dr  ;
    private nc.vo.pub.lang.UFDateTime ts  ;


	public static final String ACTUALINVALIDATE = "actualinvalidate";
	public static final String PK_SUPPLIER = "pk_supplier";
	public static final String CCURRENCYID = "ccurrencyid";
	public static final String NTOTALASTNUM = "ntotalastnum";
	public static final String NTOTALTAXMNY = "ntotaltaxmny";
	public static final String VMEMO = "vmemo";
	public static final String PK_CGDINGDAN_ZGLMASTER = "pk_cgdingdan_zglmaster";
	public static final String PK_ORG = "pk_org";
	public static final String PK_GROUP = "pk_group";
	public static final String CODE = "code";
	public static final String PK_ORG_V = "pk_org_v";
	public static final String MAKETIME = "maketime";
	public static final String LASTMAKETIME = "lastmaketime";
	public static final String CREATOR = "creator";
	public static final String CREATIONTIME = "creationtime";
	public static final String MODIFIER = "modifier";
	public static final String MODIFIEDTIME = "modifiedtime";
	public static final String BILLVERSIONPK = "billversionpk";
	public static final String BILLTYPE = "billtype";
	public static final String TRANSTYPE = "transtype";
	public static final String TRANSTYPEPK = "transtypepk";
	public static final String APPROVENOTE = "approvenote";
	public static final String APPROVER = "approver";
	public static final String APPROVEDATE = "approvedate";
	public static final String APPROVESTATUS = "approvestatus";
	public static final String EMENDENUM = "emendenum";
	public static final String BILLMAKER = "billmaker";
	public static final String SRCBILLID = "srcbillid";
	public static final String SRCBILLTYPE = "srcbilltype";
	public static final String BUSITYPE = "busitype";
	public static final String SAGA_FROZEN = "saga_frozen";
	public static final String SAGA_GTXID = "saga_gtxid";
	public static final String SAGA_BTXID = "saga_btxid";
	public static final String SAGA_STATUS = "saga_status";
	public static final String VBILLCODE = "vbillcode";
	public static final String VBILLDATE = "vbilldate";
	public static final String CEMPLOYEEID = "cemployeeid";
	public static final String PK_DEPT = "pk_dept";
	public static final String ACTUALVALIDATE = "actualvalidate";
	public static final String DR = "dr";
	public static final String TS = "ts";

	public void setActualinvalidate(nc.vo.pub.lang.UFDate actualinvalidate){
		this.actualinvalidate = actualinvalidate;
	}

	public nc.vo.pub.lang.UFDate getActualinvalidate(){
		return this.actualinvalidate;
	} 
	
	public void setPk_supplier(java.lang.String pk_supplier){
		this.pk_supplier = pk_supplier;
	}

	public java.lang.String getPk_supplier(){
		return this.pk_supplier;
	} 
	
	public void setCcurrencyid(java.lang.String ccurrencyid){
		this.ccurrencyid = ccurrencyid;
	}

	public java.lang.String getCcurrencyid(){
		return this.ccurrencyid;
	} 
	
	public void setNtotalastnum(nc.vo.pub.lang.UFDouble ntotalastnum){
		this.ntotalastnum = ntotalastnum;
	}

	public nc.vo.pub.lang.UFDouble getNtotalastnum(){
		return this.ntotalastnum;
	} 
	
	public void setNtotaltaxmny(nc.vo.pub.lang.UFDouble ntotaltaxmny){
		this.ntotaltaxmny = ntotaltaxmny;
	}

	public nc.vo.pub.lang.UFDouble getNtotaltaxmny(){
		return this.ntotaltaxmny;
	} 
	
	public void setVmemo(java.lang.String vmemo){
		this.vmemo = vmemo;
	}

	public java.lang.String getVmemo(){
		return this.vmemo;
	} 
	
	public void setPk_cgdingdan_zglmaster(java.lang.String pk_cgdingdan_zglmaster){
		this.pk_cgdingdan_zglmaster = pk_cgdingdan_zglmaster;
	}

	public java.lang.String getPk_cgdingdan_zglmaster(){
		return this.pk_cgdingdan_zglmaster;
	} 
	
	public void setPk_org(java.lang.String pk_org){
		this.pk_org = pk_org;
	}

	public java.lang.String getPk_org(){
		return this.pk_org;
	} 
	
	public void setPk_group(java.lang.String pk_group){
		this.pk_group = pk_group;
	}

	public java.lang.String getPk_group(){
		return this.pk_group;
	} 
	
	public void setCode(java.lang.String code){
		this.code = code;
	}

	public java.lang.String getCode(){
		return this.code;
	} 
	
	public void setPk_org_v(java.lang.String pk_org_v){
		this.pk_org_v = pk_org_v;
	}

	public java.lang.String getPk_org_v(){
		return this.pk_org_v;
	} 
	
	public void setMaketime(nc.vo.pub.lang.UFDateTime maketime){
		this.maketime = maketime;
	}

	public nc.vo.pub.lang.UFDateTime getMaketime(){
		return this.maketime;
	} 
	
	public void setLastmaketime(nc.vo.pub.lang.UFDateTime lastmaketime){
		this.lastmaketime = lastmaketime;
	}

	public nc.vo.pub.lang.UFDateTime getLastmaketime(){
		return this.lastmaketime;
	} 
	
	public void setCreator(java.lang.String creator){
		this.creator = creator;
	}

	public java.lang.String getCreator(){
		return this.creator;
	} 
	
	public void setCreationtime(nc.vo.pub.lang.UFDateTime creationtime){
		this.creationtime = creationtime;
	}

	public nc.vo.pub.lang.UFDateTime getCreationtime(){
		return this.creationtime;
	} 
	
	public void setModifier(java.lang.String modifier){
		this.modifier = modifier;
	}

	public java.lang.String getModifier(){
		return this.modifier;
	} 
	
	public void setModifiedtime(nc.vo.pub.lang.UFDateTime modifiedtime){
		this.modifiedtime = modifiedtime;
	}

	public nc.vo.pub.lang.UFDateTime getModifiedtime(){
		return this.modifiedtime;
	} 
	
	public void setBillversionpk(java.lang.String billversionpk){
		this.billversionpk = billversionpk;
	}

	public java.lang.String getBillversionpk(){
		return this.billversionpk;
	} 
	
	public void setBilltype(java.lang.String billtype){
		this.billtype = billtype;
	}

	public java.lang.String getBilltype(){
		return this.billtype;
	} 
	
	public void setTranstype(java.lang.String transtype){
		this.transtype = transtype;
	}

	public java.lang.String getTranstype(){
		return this.transtype;
	} 
	
	public void setTranstypepk(java.lang.String transtypepk){
		this.transtypepk = transtypepk;
	}

	public java.lang.String getTranstypepk(){
		return this.transtypepk;
	} 
	
	public void setApprovenote(java.lang.String approvenote){
		this.approvenote = approvenote;
	}

	public java.lang.String getApprovenote(){
		return this.approvenote;
	} 
	
	public void setApprover(java.lang.String approver){
		this.approver = approver;
	}

	public java.lang.String getApprover(){
		return this.approver;
	} 
	
	public void setApprovedate(nc.vo.pub.lang.UFDateTime approvedate){
		this.approvedate = approvedate;
	}

	public nc.vo.pub.lang.UFDateTime getApprovedate(){
		return this.approvedate;
	} 
	
	public void setApprovestatus(java.lang.Integer approvestatus){
		this.approvestatus = approvestatus;
	}

	public java.lang.Integer getApprovestatus(){
		return this.approvestatus;
	} 
	
	public void setEmendenum(java.lang.Integer emendenum){
		this.emendenum = emendenum;
	}

	public java.lang.Integer getEmendenum(){
		return this.emendenum;
	} 
	
	public void setBillmaker(java.lang.String billmaker){
		this.billmaker = billmaker;
	}

	public java.lang.String getBillmaker(){
		return this.billmaker;
	} 
	
	public void setSrcbillid(java.lang.String srcbillid){
		this.srcbillid = srcbillid;
	}

	public java.lang.String getSrcbillid(){
		return this.srcbillid;
	} 
	
	public void setSrcbilltype(java.lang.String srcbilltype){
		this.srcbilltype = srcbilltype;
	}

	public java.lang.String getSrcbilltype(){
		return this.srcbilltype;
	} 
	
	public void setBusitype(java.lang.String busitype){
		this.busitype = busitype;
	}

	public java.lang.String getBusitype(){
		return this.busitype;
	} 
	
	public void setSaga_frozen(java.lang.Integer saga_frozen){
		this.saga_frozen = saga_frozen;
	}

	public java.lang.Integer getSaga_frozen(){
		return this.saga_frozen;
	} 
	
	public void setSaga_gtxid(java.lang.String saga_gtxid){
		this.saga_gtxid = saga_gtxid;
	}

	public java.lang.String getSaga_gtxid(){
		return this.saga_gtxid;
	} 
	
	public void setSaga_btxid(java.lang.String saga_btxid){
		this.saga_btxid = saga_btxid;
	}

	public java.lang.String getSaga_btxid(){
		return this.saga_btxid;
	} 
	
	public void setSaga_status(java.lang.Integer saga_status){
		this.saga_status = saga_status;
	}

	public java.lang.Integer getSaga_status(){
		return this.saga_status;
	} 
	
	public void setVbillcode(java.lang.String vbillcode){
		this.vbillcode = vbillcode;
	}

	public java.lang.String getVbillcode(){
		return this.vbillcode;
	} 
	
	public void setVbilldate(nc.vo.pub.lang.UFDate vbilldate){
		this.vbilldate = vbilldate;
	}

	public nc.vo.pub.lang.UFDate getVbilldate(){
		return this.vbilldate;
	} 
	
	public void setCemployeeid(java.lang.String cemployeeid){
		this.cemployeeid = cemployeeid;
	}

	public java.lang.String getCemployeeid(){
		return this.cemployeeid;
	} 
	
	public void setPk_dept(java.lang.String pk_dept){
		this.pk_dept = pk_dept;
	}

	public java.lang.String getPk_dept(){
		return this.pk_dept;
	} 
	
	public void setActualvalidate(nc.vo.pub.lang.UFDate actualvalidate){
		this.actualvalidate = actualvalidate;
	}

	public nc.vo.pub.lang.UFDate getActualvalidate(){
		return this.actualvalidate;
	} 
	
	public void setDr(java.lang.Integer dr){
		this.dr = dr;
	}

	public java.lang.Integer getDr(){
		return this.dr;
	} 
	
	public void setTs(nc.vo.pub.lang.UFDateTime ts){
		this.ts = ts;
	}

	public nc.vo.pub.lang.UFDateTime getTs(){
		return this.ts;
	} 
	
	
	
	public java.lang.String getParentPKFieldName() {
	    return null;
	}   
    
	@Override
	public java.lang.String getPKFieldName() {
	  return "pk_cgdingdan_zglmaster";
	}
    
	/**
	 * <p>返回表名称.
	 * <p>
	 * 创建日期:
	 * @return java.lang.String
	 */
	@Override
	public java.lang.String getTableName() {
		return "pu_caigoudingd_zglmaster";
	}
	
	public static java.lang.String getDefaultTableName() {
		return "pu_caigoudingd_zglmaster";
	}    
    
	@Override
	@nc.vo.annotation.MDEntityInfo(beanFullclassName =  "nc.vo.caigoudingdan.caigoudingd_zgl.Caigoudingd_zglMasterVO" )
	public IVOMeta getMetaData() {
		return VOMetaFactory.getInstance().getVOMeta("caigoudingdan.caigoudingd_zglMaster");
  	}
  	
}
