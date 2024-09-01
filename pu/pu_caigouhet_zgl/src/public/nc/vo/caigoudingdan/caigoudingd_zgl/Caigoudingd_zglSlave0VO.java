package nc.vo.caigoudingdan.caigoudingd_zgl;

import nc.vo.pub.*;
import nc.vo.pubapp.pattern.model.meta.entity.vo.VOMetaFactory;

public class Caigoudingd_zglSlave0VO extends SuperVO {

	//构造方法
	public Caigoudingd_zglSlave0VO() {
		super();
	}


    private java.lang.String pk_material  ;
    private java.lang.String pk_marbasclass  ;
    private java.lang.String castunitid  ;
    private java.lang.String cproductorid  ;
    private nc.vo.pub.lang.UFDouble ntaxrate  ;
    private nc.vo.pub.lang.UFDouble nastnum  ;
    private nc.vo.pub.lang.UFDate dreqdate  ;
    private java.lang.String pk_suggestsupplier  ;
    private java.lang.String pk_reqstor  ;
    private nc.vo.pub.lang.UFDouble ntaxprice  ;
    private nc.vo.pub.lang.UFDouble ntaxmny  ;
    private java.lang.String cdevaddrid  ;
    private java.lang.String srctranstype  ;
    private java.lang.String srctranstypecode  ;
    private java.lang.String srcbilltype  ;
    private java.lang.String csourceid  ;
    private java.lang.String csourcebid  ;
    private java.lang.String pk_cgdingdan_zglslave0  ;
    private java.lang.String rowno  ;
    private java.lang.String srcrowno  ;
    private java.lang.Integer dr  ;
    private nc.vo.pub.lang.UFDateTime ts  ;
    private java.lang.String pk_cgdingdan_zglmaster  ;


	public static final String PK_MATERIAL = "pk_material";
	public static final String PK_MARBASCLASS = "pk_marbasclass";
	public static final String CASTUNITID = "castunitid";
	public static final String CPRODUCTORID = "cproductorid";
	public static final String NTAXRATE = "ntaxrate";
	public static final String NASTNUM = "nastnum";
	public static final String DREQDATE = "dreqdate";
	public static final String PK_SUGGESTSUPPLIER = "pk_suggestsupplier";
	public static final String PK_REQSTOR = "pk_reqstor";
	public static final String NTAXPRICE = "ntaxprice";
	public static final String NTAXMNY = "ntaxmny";
	public static final String CDEVADDRID = "cdevaddrid";
	public static final String SRCTRANSTYPE = "srctranstype";
	public static final String SRCTRANSTYPECODE = "srctranstypecode";
	public static final String SRCBILLTYPE = "srcbilltype";
	public static final String CSOURCEID = "csourceid";
	public static final String CSOURCEBID = "csourcebid";
	public static final String PK_CGDINGDAN_ZGLSLAVE0 = "pk_cgdingdan_zglslave0";
	public static final String ROWNO = "rowno";
	public static final String SRCROWNO = "srcrowno";
	public static final String DR = "dr";
	public static final String TS = "ts";
	public static final String PK_CGDINGDAN_ZGLMASTER = "pk_cgdingdan_zglmaster";

	public void setPk_material(java.lang.String pk_material){
		this.pk_material = pk_material;
	}

	public java.lang.String getPk_material(){
		return this.pk_material;
	} 
	
	public void setPk_marbasclass(java.lang.String pk_marbasclass){
		this.pk_marbasclass = pk_marbasclass;
	}

	public java.lang.String getPk_marbasclass(){
		return this.pk_marbasclass;
	} 
	
	public void setCastunitid(java.lang.String castunitid){
		this.castunitid = castunitid;
	}

	public java.lang.String getCastunitid(){
		return this.castunitid;
	} 
	
	public void setCproductorid(java.lang.String cproductorid){
		this.cproductorid = cproductorid;
	}

	public java.lang.String getCproductorid(){
		return this.cproductorid;
	} 
	
	public void setNtaxrate(nc.vo.pub.lang.UFDouble ntaxrate){
		this.ntaxrate = ntaxrate;
	}

	public nc.vo.pub.lang.UFDouble getNtaxrate(){
		return this.ntaxrate;
	} 
	
	public void setNastnum(nc.vo.pub.lang.UFDouble nastnum){
		this.nastnum = nastnum;
	}

	public nc.vo.pub.lang.UFDouble getNastnum(){
		return this.nastnum;
	} 
	
	public void setDreqdate(nc.vo.pub.lang.UFDate dreqdate){
		this.dreqdate = dreqdate;
	}

	public nc.vo.pub.lang.UFDate getDreqdate(){
		return this.dreqdate;
	} 
	
	public void setPk_suggestsupplier(java.lang.String pk_suggestsupplier){
		this.pk_suggestsupplier = pk_suggestsupplier;
	}

	public java.lang.String getPk_suggestsupplier(){
		return this.pk_suggestsupplier;
	} 
	
	public void setPk_reqstor(java.lang.String pk_reqstor){
		this.pk_reqstor = pk_reqstor;
	}

	public java.lang.String getPk_reqstor(){
		return this.pk_reqstor;
	} 
	
	public void setNtaxprice(nc.vo.pub.lang.UFDouble ntaxprice){
		this.ntaxprice = ntaxprice;
	}

	public nc.vo.pub.lang.UFDouble getNtaxprice(){
		return this.ntaxprice;
	} 
	
	public void setNtaxmny(nc.vo.pub.lang.UFDouble ntaxmny){
		this.ntaxmny = ntaxmny;
	}

	public nc.vo.pub.lang.UFDouble getNtaxmny(){
		return this.ntaxmny;
	} 
	
	public void setCdevaddrid(java.lang.String cdevaddrid){
		this.cdevaddrid = cdevaddrid;
	}

	public java.lang.String getCdevaddrid(){
		return this.cdevaddrid;
	} 
	
	public void setSrctranstype(java.lang.String srctranstype){
		this.srctranstype = srctranstype;
	}

	public java.lang.String getSrctranstype(){
		return this.srctranstype;
	} 
	
	public void setSrctranstypecode(java.lang.String srctranstypecode){
		this.srctranstypecode = srctranstypecode;
	}

	public java.lang.String getSrctranstypecode(){
		return this.srctranstypecode;
	} 
	
	public void setSrcbilltype(java.lang.String srcbilltype){
		this.srcbilltype = srcbilltype;
	}

	public java.lang.String getSrcbilltype(){
		return this.srcbilltype;
	} 
	
	public void setCsourceid(java.lang.String csourceid){
		this.csourceid = csourceid;
	}

	public java.lang.String getCsourceid(){
		return this.csourceid;
	} 
	
	public void setCsourcebid(java.lang.String csourcebid){
		this.csourcebid = csourcebid;
	}

	public java.lang.String getCsourcebid(){
		return this.csourcebid;
	} 
	
	public void setPk_cgdingdan_zglslave0(java.lang.String pk_cgdingdan_zglslave0){
		this.pk_cgdingdan_zglslave0 = pk_cgdingdan_zglslave0;
	}

	public java.lang.String getPk_cgdingdan_zglslave0(){
		return this.pk_cgdingdan_zglslave0;
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
	
	
	public void setPk_cgdingdan_zglmaster(java.lang.String pk_cgdingdan_zglmaster){
		this.pk_cgdingdan_zglmaster = pk_cgdingdan_zglmaster;
	}

	public java.lang.String getPk_cgdingdan_zglmaster(){
		return this.pk_cgdingdan_zglmaster;
	} 
	
	
	public java.lang.String getParentPKFieldName() {
	    return null;
	}   
    
	@Override
	public java.lang.String getPKFieldName() {
	  return "pk_cgdingdan_zglslave0";
	}
    
	/**
	 * <p>返回表名称.
	 * <p>
	 * 创建日期:
	 * @return java.lang.String
	 */
	@Override
	public java.lang.String getTableName() {
		return "pu_caigoudingd_zglslave0";
	}
	
	public static java.lang.String getDefaultTableName() {
		return "pu_caigoudingd_zglslave0";
	}    
    
	@Override
	@nc.vo.annotation.MDEntityInfo(beanFullclassName =  "nc.vo.caigoudingdan.caigoudingd_zgl.Caigoudingd_zglSlave0VO" )
	public IVOMeta getMetaData() {
		return VOMetaFactory.getInstance().getVOMeta("caigoudingdan.caigoudingd_zglSlave0");
  	}
  	
}
