package nc.vo.caigoudingdan.caigoudingd_zgl;

import nc.vo.pubapp.pattern.model.entity.bill.AbstractBill;
import nc.vo.pubapp.pattern.model.meta.entity.bill.BillMetaFactory;
import nc.vo.pubapp.pattern.model.meta.entity.bill.IBillMeta;
import nc.vo.caigoudingdan.caigoudingd_zgl.Caigoudingd_zglMasterVO;

/**
 * 
 * 单子表/单表头/单表体聚合VO
 *
 * 创建日期:
 * @author 
 * @version NCPrj ??
 */
@nc.vo.annotation.AggVoInfo(parentVO = "nc.vo.caigoudingdan.caigoudingd_zgl.Caigoudingd_zglMasterVO")
public class  AggCaigoudingd_zglMasterVO  extends AbstractBill {
	
	private static final long serialVersionUID = 1309613813878961316L;

      @Override
	  public IBillMeta getMetaData() {
	  	IBillMeta billMeta =BillMetaFactory.getInstance().getBillMeta(AggCaigoudingd_zglMasterVOMeta.class);
	  	return billMeta;
	  }
	    
	  @Override
	  public Caigoudingd_zglMasterVO getParentVO(){
	  	return (Caigoudingd_zglMasterVO)this.getParent();
	  }

      @Override
        public String getPrimaryKey() {
            return super.getPrimaryKey();
      }

}
