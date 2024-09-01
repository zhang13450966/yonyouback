package nc.vo.caigoudingdan.caigoudingd_zgl;

import nc.vo.pubapp.pattern.model.meta.entity.bill.AbstractBillMeta;

public class AggCaigoudingd_zglMasterVOMeta  extends AbstractBillMeta{
	
	public AggCaigoudingd_zglMasterVOMeta(){
		this.init();
	}

    private void init() {
        this.setParent(nc.vo.caigoudingdan.caigoudingd_zgl.Caigoudingd_zglMasterVO.class);
            this.addChildren(nc.vo.caigoudingdan.caigoudingd_zgl.Caigoudingd_zglSlave0VO.class);
    }

}
