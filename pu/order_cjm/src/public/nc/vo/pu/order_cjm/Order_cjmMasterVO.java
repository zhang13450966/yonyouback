package nc.vo.pu.order_cjm;

import nc.vo.pub.*;
import nc.vo.pubapp.pattern.model.meta.entity.vo.VOMetaFactory;

public class Order_cjmMasterVO extends SuperVO {

	//构造方法
	public Order_cjmMasterVO() {
		super();
	}


    private java.lang.String pk_order_cjmmaster  ;
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
    private java.lang.String busitype  ;
    private java.lang.String srcbillid  ;
    private java.lang.String srcbilltype  ;
    private java.lang.String pk_supplier  ;
    private java.lang.String pk_region  ;
    private java.lang.String pk_office  ;
    private java.lang.String pk_psndoc  ;
    private nc.vo.pub.lang.UFDouble ntotalnum  ;
    private nc.vo.pub.lang.UFDouble ntotalmny  ;
    private java.lang.String def1  ;
    private java.lang.String def2  ;
    private java.lang.String def3  ;
    private java.lang.String def4  ;
    private java.lang.String def5  ;
    private java.lang.String def6  ;
    private java.lang.String def7  ;
    private java.lang.String def8  ;
    private java.lang.String def9  ;
    private java.lang.String def10  ;
    private java.lang.String def11  ;
    private java.lang.String def12  ;
    private java.lang.String def13  ;
    private java.lang.String def14  ;
    private java.lang.String def15  ;
    private java.lang.String def16  ;
    private java.lang.String def17  ;
    private java.lang.String def18  ;
    private java.lang.String def19  ;
    private java.lang.String def20  ;
    private java.lang.Integer dr  ;
    private nc.vo.pub.lang.UFDateTime ts  ;


	public static final String PK_ORDER_CJMMASTER = "pk_order_cjmmaster";
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
	public static final String BUSITYPE = "busitype";
	public static final String SRCBILLID = "srcbillid";
	public static final String SRCBILLTYPE = "srcbilltype";
	public static final String PK_SUPPLIER = "pk_supplier";
	public static final String PK_REGION = "pk_region";
	public static final String PK_OFFICE = "pk_office";
	public static final String PK_PSNDOC = "pk_psndoc";
	public static final String NTOTALNUM = "ntotalnum";
	public static final String NTOTALMNY = "ntotalmny";
	public static final String DEF1 = "def1";
	public static final String DEF2 = "def2";
	public static final String DEF3 = "def3";
	public static final String DEF4 = "def4";
	public static final String DEF5 = "def5";
	public static final String DEF6 = "def6";
	public static final String DEF7 = "def7";
	public static final String DEF8 = "def8";
	public static final String DEF9 = "def9";
	public static final String DEF10 = "def10";
	public static final String DEF11 = "def11";
	public static final String DEF12 = "def12";
	public static final String DEF13 = "def13";
	public static final String DEF14 = "def14";
	public static final String DEF15 = "def15";
	public static final String DEF16 = "def16";
	public static final String DEF17 = "def17";
	public static final String DEF18 = "def18";
	public static final String DEF19 = "def19";
	public static final String DEF20 = "def20";
	public static final String DR = "dr";
	public static final String TS = "ts";

	public void setPk_order_cjmmaster(java.lang.String pk_order_cjmmaster){
		this.pk_order_cjmmaster = pk_order_cjmmaster;
	}

	public java.lang.String getPk_order_cjmmaster(){
		return this.pk_order_cjmmaster;
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
	
	public void setBusitype(java.lang.String busitype){
		this.busitype = busitype;
	}

	public java.lang.String getBusitype(){
		return this.busitype;
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
	
	public void setPk_supplier(java.lang.String pk_supplier){
		this.pk_supplier = pk_supplier;
	}

	public java.lang.String getPk_supplier(){
		return this.pk_supplier;
	} 
	
	public void setPk_region(java.lang.String pk_region){
		this.pk_region = pk_region;
	}

	public java.lang.String getPk_region(){
		return this.pk_region;
	} 
	
	public void setPk_office(java.lang.String pk_office){
		this.pk_office = pk_office;
	}

	public java.lang.String getPk_office(){
		return this.pk_office;
	} 
	
	public void setPk_psndoc(java.lang.String pk_psndoc){
		this.pk_psndoc = pk_psndoc;
	}

	public java.lang.String getPk_psndoc(){
		return this.pk_psndoc;
	} 
	
	public void setNtotalnum(nc.vo.pub.lang.UFDouble ntotalnum){
		this.ntotalnum = ntotalnum;
	}

	public nc.vo.pub.lang.UFDouble getNtotalnum(){
		return this.ntotalnum;
	} 
	
	public void setNtotalmny(nc.vo.pub.lang.UFDouble ntotalmny){
		this.ntotalmny = ntotalmny;
	}

	public nc.vo.pub.lang.UFDouble getNtotalmny(){
		return this.ntotalmny;
	} 
	
	public void setDef1(java.lang.String def1){
		this.def1 = def1;
	}

	public java.lang.String getDef1(){
		return this.def1;
	} 
	
	public void setDef2(java.lang.String def2){
		this.def2 = def2;
	}

	public java.lang.String getDef2(){
		return this.def2;
	} 
	
	public void setDef3(java.lang.String def3){
		this.def3 = def3;
	}

	public java.lang.String getDef3(){
		return this.def3;
	} 
	
	public void setDef4(java.lang.String def4){
		this.def4 = def4;
	}

	public java.lang.String getDef4(){
		return this.def4;
	} 
	
	public void setDef5(java.lang.String def5){
		this.def5 = def5;
	}

	public java.lang.String getDef5(){
		return this.def5;
	} 
	
	public void setDef6(java.lang.String def6){
		this.def6 = def6;
	}

	public java.lang.String getDef6(){
		return this.def6;
	} 
	
	public void setDef7(java.lang.String def7){
		this.def7 = def7;
	}

	public java.lang.String getDef7(){
		return this.def7;
	} 
	
	public void setDef8(java.lang.String def8){
		this.def8 = def8;
	}

	public java.lang.String getDef8(){
		return this.def8;
	} 
	
	public void setDef9(java.lang.String def9){
		this.def9 = def9;
	}

	public java.lang.String getDef9(){
		return this.def9;
	} 
	
	public void setDef10(java.lang.String def10){
		this.def10 = def10;
	}

	public java.lang.String getDef10(){
		return this.def10;
	} 
	
	public void setDef11(java.lang.String def11){
		this.def11 = def11;
	}

	public java.lang.String getDef11(){
		return this.def11;
	} 
	
	public void setDef12(java.lang.String def12){
		this.def12 = def12;
	}

	public java.lang.String getDef12(){
		return this.def12;
	} 
	
	public void setDef13(java.lang.String def13){
		this.def13 = def13;
	}

	public java.lang.String getDef13(){
		return this.def13;
	} 
	
	public void setDef14(java.lang.String def14){
		this.def14 = def14;
	}

	public java.lang.String getDef14(){
		return this.def14;
	} 
	
	public void setDef15(java.lang.String def15){
		this.def15 = def15;
	}

	public java.lang.String getDef15(){
		return this.def15;
	} 
	
	public void setDef16(java.lang.String def16){
		this.def16 = def16;
	}

	public java.lang.String getDef16(){
		return this.def16;
	} 
	
	public void setDef17(java.lang.String def17){
		this.def17 = def17;
	}

	public java.lang.String getDef17(){
		return this.def17;
	} 
	
	public void setDef18(java.lang.String def18){
		this.def18 = def18;
	}

	public java.lang.String getDef18(){
		return this.def18;
	} 
	
	public void setDef19(java.lang.String def19){
		this.def19 = def19;
	}

	public java.lang.String getDef19(){
		return this.def19;
	} 
	
	public void setDef20(java.lang.String def20){
		this.def20 = def20;
	}

	public java.lang.String getDef20(){
		return this.def20;
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
	  return "pk_order_cjmmaster";
	}
    
	/**
	 * <p>返回表名称.
	 * <p>
	 * 创建日期:
	 * @return java.lang.String
	 */
	@Override
	public java.lang.String getTableName() {
		return "pu_order_cjmmaster";
	}
	
	public static java.lang.String getDefaultTableName() {
		return "pu_order_cjmmaster";
	}    
    
	@Override
	@nc.vo.annotation.MDEntityInfo(beanFullclassName =  "nc.vo.pu.order_cjm.Order_cjmMasterVO" )
	public IVOMeta getMetaData() {
		return VOMetaFactory.getInstance().getVOMeta("pu.order_cjmMaster");
  	}
  	
}
