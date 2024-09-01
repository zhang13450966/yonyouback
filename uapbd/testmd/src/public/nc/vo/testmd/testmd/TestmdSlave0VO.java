package nc.vo.testmd.testmd;

import nc.vo.pub.*;
import nc.vo.pubapp.pattern.model.meta.entity.vo.VOMetaFactory;

public class TestmdSlave0VO extends SuperVO {

	//构造方法
	public TestmdSlave0VO() {
		super();
	}


    private java.lang.String pk_testmdslave0  ;
    private java.lang.String rowno  ;
    private java.lang.String srcrowno  ;
    private java.lang.Integer dr  ;
    private nc.vo.pub.lang.UFDateTime ts  ;
    private java.lang.String pk_testmdmaster  ;


	public static final String PK_TESTMDSLAVE0 = "pk_testmdslave0";
	public static final String ROWNO = "rowno";
	public static final String SRCROWNO = "srcrowno";
	public static final String DR = "dr";
	public static final String TS = "ts";
	public static final String PK_TESTMDMASTER = "pk_testmdmaster";

	public void setPk_testmdslave0(java.lang.String pk_testmdslave0){
		this.pk_testmdslave0 = pk_testmdslave0;
	}

	public java.lang.String getPk_testmdslave0(){
		return this.pk_testmdslave0;
	} 
	
	public void setRowno(java.lang.String rowno){
		this.rowno = rowno;
	}

	public java.lang.String getRowno(){
		return this.rowno;
	} 
	
	public void setSrcrowno(java.lang.String srcrowno){
		this.srcrowno = srcrowno;
	}

	public java.lang.String getSrcrowno(){
		return this.srcrowno;
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
	
	
	public void setPk_testmdmaster(java.lang.String pk_testmdmaster){
		this.pk_testmdmaster = pk_testmdmaster;
	}

	public java.lang.String getPk_testmdmaster(){
		return this.pk_testmdmaster;
	} 
	
	
	public java.lang.String getParentPKFieldName() {
	    return null;
	}   
    
	@Override
	public java.lang.String getPKFieldName() {
	  return "pk_testmdslave0";
	}
    
	/**
	 * <p>返回表名称.
	 * <p>
	 * 创建日期:
	 * @return java.lang.String
	 */
	@Override
	public java.lang.String getTableName() {
		return "uapbd_testmdslave0";
	}
	
	public static java.lang.String getDefaultTableName() {
		return "uapbd_testmdslave0";
	}    
    
	@Override
	@nc.vo.annotation.MDEntityInfo(beanFullclassName =  "nc.vo.testmd.testmd.TestmdSlave0VO" )
	public IVOMeta getMetaData() {
		return VOMetaFactory.getInstance().getVOMeta("testmd.testmdSlave0");
  	}
  	
}
