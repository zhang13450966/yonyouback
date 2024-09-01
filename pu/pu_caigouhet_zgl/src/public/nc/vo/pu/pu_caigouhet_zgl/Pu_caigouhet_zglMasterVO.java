package nc.vo.pu.pu_caigouhet_zgl;

import nc.vo.pub.IVOMeta;
import nc.vo.pub.SuperVO;
import nc.vo.pubapp.pattern.model.meta.entity.vo.VOMetaFactory;

public class Pu_caigouhet_zglMasterVO extends SuperVO {

    //构造方法
    public Pu_caigouhet_zglMasterVO() {
        super();
    }


    private String pk_caigouhet_zglmaster;
    private String pk_org;
    private String pk_group;
    private String code;
    private String pk_org_v;
    private nc.vo.pub.lang.UFDateTime maketime;
    private nc.vo.pub.lang.UFDateTime lastmaketime;
    private String creator;
    private nc.vo.pub.lang.UFDateTime creationtime;
    private String modifier;
    private nc.vo.pub.lang.UFDateTime modifiedtime;
    private String billversionpk;
    private String billtype;
    private String transtype;
    private String transtypepk;
    private String approvenote;
    private String approver;
    private nc.vo.pub.lang.UFDateTime approvedate;
    private Integer approvestatus;
    private Integer emendenum;
    private String billmaker;
    private String busitype;
    private Integer saga_frozen;
    private String saga_gtxid;
    private String saga_btxid;
    private Integer saga_status;
    private String vbillcode;
    private String ctname;
    private nc.vo.pub.lang.UFDate subscribedate;
    private nc.vo.pub.lang.UFDate valdate;
    private nc.vo.pub.lang.UFDate invallidate;
    private nc.vo.pub.lang.UFDate actualvalidate;
    private nc.vo.pub.lang.UFDate actualinvalidate;
    private String cvendorid;
    private String ccurrencyid;
    private nc.vo.pub.lang.UFDouble ntotalastnum;
    private nc.vo.pub.lang.UFDouble ntotaltaxmny;
    private String vmemo;
    private Integer dr;
    private nc.vo.pub.lang.UFDateTime ts;


    public static final String PK_CAIGOUHET_ZGLMASTER = "pk_caigouhet_zglmaster";
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
    public static final String SAGA_FROZEN = "saga_frozen";
    public static final String SAGA_GTXID = "saga_gtxid";
    public static final String SAGA_BTXID = "saga_btxid";
    public static final String SAGA_STATUS = "saga_status";
    public static final String VBILLCODE = "vbillcode";
    public static final String CTNAME = "ctname";
    public static final String SUBSCRIBEDATE = "subscribedate";
    public static final String VALDATE = "valdate";
    public static final String INVALLIDATE = "invallidate";
    public static final String ACTUALVALIDATE = "actualvalidate";
    public static final String ACTUALINVALIDATE = "actualinvalidate";
    public static final String CVENDORID = "cvendorid";
    public static final String CCURRENCYID = "ccurrencyid";
    public static final String NTOTALASTNUM = "ntotalastnum";
    public static final String NTOTALTAXMNY = "ntotaltaxmny";
    public static final String VMEMO = "vmemo";
    public static final String DR = "dr";
    public static final String TS = "ts";

    public void setPk_caigouhet_zglmaster(String pk_caigouhet_zglmaster) {
        this.pk_caigouhet_zglmaster = pk_caigouhet_zglmaster;
    }

    public String getPk_caigouhet_zglmaster() {
        return this.pk_caigouhet_zglmaster;
    }

    public void setPk_org(String pk_org) {
        this.pk_org = pk_org;
    }

    public String getPk_org() {
        return this.pk_org;
    }

    public void setPk_group(String pk_group) {
        this.pk_group = pk_group;
    }

    public String getPk_group() {
        return this.pk_group;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public void setPk_org_v(String pk_org_v) {
        this.pk_org_v = pk_org_v;
    }

    public String getPk_org_v() {
        return this.pk_org_v;
    }

    public void setMaketime(nc.vo.pub.lang.UFDateTime maketime) {
        this.maketime = maketime;
    }

    public nc.vo.pub.lang.UFDateTime getMaketime() {
        return this.maketime;
    }

    public void setLastmaketime(nc.vo.pub.lang.UFDateTime lastmaketime) {
        this.lastmaketime = lastmaketime;
    }

    public nc.vo.pub.lang.UFDateTime getLastmaketime() {
        return this.lastmaketime;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreator() {
        return this.creator;
    }

    public void setCreationtime(nc.vo.pub.lang.UFDateTime creationtime) {
        this.creationtime = creationtime;
    }

    public nc.vo.pub.lang.UFDateTime getCreationtime() {
        return this.creationtime;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getModifier() {
        return this.modifier;
    }

    public void setModifiedtime(nc.vo.pub.lang.UFDateTime modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

    public nc.vo.pub.lang.UFDateTime getModifiedtime() {
        return this.modifiedtime;
    }

    public void setBillversionpk(String billversionpk) {
        this.billversionpk = billversionpk;
    }

    public String getBillversionpk() {
        return this.billversionpk;
    }

    public void setBilltype(String billtype) {
        this.billtype = billtype;
    }

    public String getBilltype() {
        return this.billtype;
    }

    public void setTranstype(String transtype) {
        this.transtype = transtype;
    }

    public String getTranstype() {
        return this.transtype;
    }

    public void setTranstypepk(String transtypepk) {
        this.transtypepk = transtypepk;
    }

    public String getTranstypepk() {
        return this.transtypepk;
    }

    public void setApprovenote(String approvenote) {
        this.approvenote = approvenote;
    }

    public String getApprovenote() {
        return this.approvenote;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public String getApprover() {
        return this.approver;
    }

    public void setApprovedate(nc.vo.pub.lang.UFDateTime approvedate) {
        this.approvedate = approvedate;
    }

    public nc.vo.pub.lang.UFDateTime getApprovedate() {
        return this.approvedate;
    }

    public void setApprovestatus(Integer approvestatus) {
        this.approvestatus = approvestatus;
    }

    public Integer getApprovestatus() {
        return this.approvestatus;
    }

    public void setEmendenum(Integer emendenum) {
        this.emendenum = emendenum;
    }

    public Integer getEmendenum() {
        return this.emendenum;
    }

    public void setBillmaker(String billmaker) {
        this.billmaker = billmaker;
    }

    public String getBillmaker() {
        return this.billmaker;
    }

    public void setBusitype(String busitype) {
        this.busitype = busitype;
    }

    public String getBusitype() {
        return this.busitype;
    }

    public void setSaga_frozen(Integer saga_frozen) {
        this.saga_frozen = saga_frozen;
    }

    public Integer getSaga_frozen() {
        return this.saga_frozen;
    }

    public void setSaga_gtxid(String saga_gtxid) {
        this.saga_gtxid = saga_gtxid;
    }

    public String getSaga_gtxid() {
        return this.saga_gtxid;
    }

    public void setSaga_btxid(String saga_btxid) {
        this.saga_btxid = saga_btxid;
    }

    public String getSaga_btxid() {
        return this.saga_btxid;
    }

    public void setSaga_status(Integer saga_status) {
        this.saga_status = saga_status;
    }

    public Integer getSaga_status() {
        return this.saga_status;
    }

    public void setVbillcode(String vbillcode) {
        this.vbillcode = vbillcode;
    }

    public String getVbillcode() {
        return this.vbillcode;
    }

    public void setCtname(String ctname) {
        this.ctname = ctname;
    }

    public String getCtname() {
        return this.ctname;
    }

    public void setSubscribedate(nc.vo.pub.lang.UFDate subscribedate) {
        this.subscribedate = subscribedate;
    }

    public nc.vo.pub.lang.UFDate getSubscribedate() {
        return this.subscribedate;
    }

    public void setValdate(nc.vo.pub.lang.UFDate valdate) {
        this.valdate = valdate;
    }

    public nc.vo.pub.lang.UFDate getValdate() {
        return this.valdate;
    }

    public void setInvallidate(nc.vo.pub.lang.UFDate invallidate) {
        this.invallidate = invallidate;
    }

    public nc.vo.pub.lang.UFDate getInvallidate() {
        return this.invallidate;
    }

    public void setActualvalidate(nc.vo.pub.lang.UFDate actualvalidate) {
        this.actualvalidate = actualvalidate;
    }

    public nc.vo.pub.lang.UFDate getActualvalidate() {
        return this.actualvalidate;
    }

    public void setActualinvalidate(nc.vo.pub.lang.UFDate actualinvalidate) {
        this.actualinvalidate = actualinvalidate;
    }

    public nc.vo.pub.lang.UFDate getActualinvalidate() {
        return this.actualinvalidate;
    }

    public void setCvendorid(String cvendorid) {
        this.cvendorid = cvendorid;
    }

    public String getCvendorid() {
        return this.cvendorid;
    }

    public void setCcurrencyid(String ccurrencyid) {
        this.ccurrencyid = ccurrencyid;
    }

    public String getCcurrencyid() {
        return this.ccurrencyid;
    }

    public void setNtotalastnum(nc.vo.pub.lang.UFDouble ntotalastnum) {
        this.ntotalastnum = ntotalastnum;
    }

    public nc.vo.pub.lang.UFDouble getNtotalastnum() {
        return this.ntotalastnum;
    }

    public void setNtotaltaxmny(nc.vo.pub.lang.UFDouble ntotaltaxmny) {
        this.ntotaltaxmny = ntotaltaxmny;
    }

    public nc.vo.pub.lang.UFDouble getNtotaltaxmny() {
        return this.ntotaltaxmny;
    }

    public void setVmemo(String vmemo) {
        this.vmemo = vmemo;
    }

    public String getVmemo() {
        return this.vmemo;
    }

    public void setDr(Integer dr) {
        this.dr = dr;
    }

    public Integer getDr() {
        return this.dr;
    }

    public void setTs(nc.vo.pub.lang.UFDateTime ts) {
        this.ts = ts;
    }

    public nc.vo.pub.lang.UFDateTime getTs() {
        return this.ts;
    }


    public String getParentPKFieldName() {
        return null;
    }

    @Override
    public String getPKFieldName() {
        return "pk_caigouhet_zglmaster";
    }

    /**
     * <p>返回表名称.
     * <p>
     * 创建日期:
     *
     * @return java.lang.String
     */
    @Override
    public String getTableName() {
        return "pu_pu_caigouhet_zglmaster";
    }

    public static String getDefaultTableName() {
        return "pu_pu_caigouhet_zglmaster";
    }

    @Override
    @nc.vo.annotation.MDEntityInfo(beanFullclassName = "nc.vo.pu.pu_caigouhet_zgl.Pu_caigouhet_zglMasterVO")
    public IVOMeta getMetaData() {
        return VOMetaFactory.getInstance().getVOMeta("pu.pu_caigouhet_zglMaster");
    }

}
