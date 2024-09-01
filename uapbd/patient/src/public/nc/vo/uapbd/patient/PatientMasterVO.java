package nc.vo.uapbd.patient;

import nc.vo.pub.*;
import nc.vo.pubapp.pattern.model.meta.entity.vo.VOMetaFactory;

public class PatientMasterVO extends SuperVO {

	//构造方法
	public PatientMasterVO() {
		super();
	}


    private nc.vo.pub.lang.UFDateTime creationtime  ;
    private java.lang.String modifier  ;
    private nc.vo.pub.lang.UFDateTime modifiedtime  ;
    private java.lang.String pk_patientmaster  ;
    private java.lang.String pk_org  ;
    private java.lang.String pk_group  ;
    private java.lang.String code  ;
    private java.lang.String name  ;
    private java.lang.String vcardid  ;
    private java.lang.String vdeptname  ;
    private java.lang.String vdeptcode  ;
    private java.lang.String medicalno  ;
    private java.lang.Integer admission  ;
    private java.lang.String creator  ;
    private java.lang.Integer dr  ;
    private nc.vo.pub.lang.UFDateTime ts  ;


	public static final String CREATIONTIME = "creationtime";
	public static final String MODIFIER = "modifier";
	public static final String MODIFIEDTIME = "modifiedtime";
	public static final String PK_PATIENTMASTER = "pk_patientmaster";
	public static final String PK_ORG = "pk_org";
	public static final String PK_GROUP = "pk_group";
	public static final String CODE = "code";
	public static final String NAME = "name";
	public static final String VCARDID = "vcardid";
	public static final String VDEPTNAME = "vdeptname";
	public static final String VDEPTCODE = "vdeptcode";
	public static final String MEDICALNO = "medicalno";
	public static final String ADMISSION = "admission";
	public static final String CREATOR = "creator";
	public static final String DR = "dr";
	public static final String TS = "ts";

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
	
	public void setPk_patientmaster(java.lang.String pk_patientmaster){
		this.pk_patientmaster = pk_patientmaster;
	}

	public java.lang.String getPk_patientmaster(){
		return this.pk_patientmaster;
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
	
	public void setName(java.lang.String name){
		this.name = name;
	}

	public java.lang.String getName(){
		return this.name;
	} 
	
	public void setVcardid(java.lang.String vcardid){
		this.vcardid = vcardid;
	}

	public java.lang.String getVcardid(){
		return this.vcardid;
	} 
	
	public void setVdeptname(java.lang.String vdeptname){
		this.vdeptname = vdeptname;
	}

	public java.lang.String getVdeptname(){
		return this.vdeptname;
	} 
	
	public void setVdeptcode(java.lang.String vdeptcode){
		this.vdeptcode = vdeptcode;
	}

	public java.lang.String getVdeptcode(){
		return this.vdeptcode;
	} 
	
	public void setMedicalno(java.lang.String medicalno){
		this.medicalno = medicalno;
	}

	public java.lang.String getMedicalno(){
		return this.medicalno;
	} 
	
	public void setAdmission(java.lang.Integer admission){
		this.admission = admission;
	}

	public java.lang.Integer getAdmission(){
		return this.admission;
	} 
	
	public void setCreator(java.lang.String creator){
		this.creator = creator;
	}

	public java.lang.String getCreator(){
		return this.creator;
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
	  return "pk_patientmaster";
	}
    
	/**
	 * <p>返回表名称.
	 * <p>
	 * 创建日期:
	 * @return java.lang.String
	 */
	@Override
	public java.lang.String getTableName() {
		return "uapbd_patientmaster";
	}
	
	public static java.lang.String getDefaultTableName() {
		return "uapbd_patientmaster";
	}    
    
	@Override
	@nc.vo.annotation.MDEntityInfo(beanFullclassName =  "nc.vo.uapbd.patient.PatientMasterVO" )
	public IVOMeta getMetaData() {
		return VOMetaFactory.getInstance().getVOMeta("uapbd.patientMaster");
  	}
  	
}
