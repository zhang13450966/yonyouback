package nc.vo.pu.pu_caigouhet_zgl;

import nc.vo.pub.*;
import nc.vo.pubapp.pattern.model.meta.entity.vo.VOMetaFactory;

public class Pu_caigouhet_zglSlave0VO extends SuperVO {

	//构造方法
	public Pu_caigouhet_zglSlave0VO() {
		super();
	}


    private String pk_caigouhet_zglslave0  ;
    private String rowno  ;
    private String srcrowno  ;
    private String pk_material  ;
    private String pk_maebasclass  ;
    private String castunitid  ;
    private String cproductorid  ;
    private nc.vo.pub.lang.UFDouble ntaxrate  ;
    private nc.vo.pub.lang.UFDouble nastnum  ;
    private nc.vo.pub.lang.UFDate dreqdate  ;
    private String pk_suggestsupplier  ;
    private nc.vo.pub.lang.UFDouble ntaxprice  ;
    private nc.vo.pub.lang.UFDouble ntaxmny  ;
    private nc.vo.pub.lang.UFDouble nordernum  ;
    private Integer dr  ;
    private nc.vo.pub.lang.UFDateTime ts  ;
    private String pk_caigouhet_zglmaster  ;


	public static final String PK_CAIGOUHET_ZGLSLAVE0 = "pk_caigouhet_zglslave0";
	public static final String ROWNO = "rowno";
	public static final String SRCROWNO = "srcrowno";
	public static final String PK_MATERIAL = "pk_material";
	public static final String PK_MAEBASCLASS = "pk_maebasclass";
	public static final String CASTUNITID = "castunitid";
	public static final String CPRODUCTORID = "cproductorid";
	public static final String NTAXRATE = "ntaxrate";
	public static final String NASTNUM = "nastnum";
	public static final String DREQDATE = "dreqdate";
	public static final String PK_SUGGESTSUPPLIER = "pk_suggestsupplier";
	public static final String NTAXPRICE = "ntaxprice";
	public static final String NTAXMNY = "ntaxmny";
	public static final String NORDERNUM = "nordernum";
	public static final String DR = "dr";
	public static final String TS = "ts";
	public static final String PK_CAIGOUHET_ZGLMASTER = "pk_caigouhet_zglmaster";

	public void setPk_caigouhet_zglslave0(String pk_caigouhet_zglslave0){
		this.pk_caigouhet_zglslave0 = pk_caigouhet_zglslave0;
	}

	public String getPk_caigouhet_zglslave0(){
		return this.pk_caigouhet_zglslave0;
	} 
	
	public void setRowno(String rowno){
		this.rowno = rowno;
	}

	public String getRowno(){
		return this.rowno;
	} 
	
	public void setSrcrowno(String srcrowno){
		this.srcrowno = srcrowno;
	}

	public String getSrcrowno(){
		return this.srcrowno;
	} 
	
	public void setPk_material(String pk_material){
		this.pk_material = pk_material;
	}

	public String getPk_material(){
		return this.pk_material;
	} 
	
	public void setPk_maebasclass(String pk_maebasclass){
		this.pk_maebasclass = pk_maebasclass;
	}

	public String getPk_maebasclass(){
		return this.pk_maebasclass;
	} 
	
	public void setCastunitid(String castunitid){
		this.castunitid = castunitid;
	}

	public String getCastunitid(){
		return this.castunitid;
	} 
	
	public void setCproductorid(String cproductorid){
		this.cproductorid = cproductorid;
	}

	public String getCproductorid(){
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
	
	public void setPk_suggestsupplier(String pk_suggestsupplier){
		this.pk_suggestsupplier = pk_suggestsupplier;
	}

	public String getPk_suggestsupplier(){
		return this.pk_suggestsupplier;
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
	
	public void setNordernum(nc.vo.pub.lang.UFDouble nordernum){
		this.nordernum = nordernum;
	}

	public nc.vo.pub.lang.UFDouble getNordernum(){
		return this.nordernum;
	} 
	
	public void setDr(Integer dr){
		this.dr = dr;
	}

	public Integer getDr(){
		return this.dr;
	} 
	
	public void setTs(nc.vo.pub.lang.UFDateTime ts){
		this.ts = ts;
	}

	public nc.vo.pub.lang.UFDateTime getTs(){
		return this.ts;
	} 
	
	
	public void setPk_caigouhet_zglmaster(String pk_caigouhet_zglmaster){
		this.pk_caigouhet_zglmaster = pk_caigouhet_zglmaster;
	}

	public String getPk_caigouhet_zglmaster(){
		return this.pk_caigouhet_zglmaster;
	} 
	
	
	public String getParentPKFieldName() {
	    return null;
	}   
    
	@Override
	public String getPKFieldName() {
	  return "pk_caigouhet_zglslave0";
	}
    
	/**
	 * <p>返回表名称.
	 * <p>
	 * 创建日期:
	 * @return java.lang.String
	 */
	@Override
	public String getTableName() {
		return "pu_pu_caigouhet_zglslave0";
	}
	
	public static String getDefaultTableName() {
		return "pu_pu_caigouhet_zglslave0";
	}    
    
	@Override
	@nc.vo.annotation.MDEntityInfo(beanFullclassName =  "nc.vo.pu.pu_caigouhet_zgl.Pu_caigouhet_zglSlave0VO" )
	public IVOMeta getMetaData() {
		return VOMetaFactory.getInstance().getVOMeta("pu.pu_caigouhet_zglSlave0");
  	}
  	
}
