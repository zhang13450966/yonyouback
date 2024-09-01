package nc.vo.pu.pu_caigouhet_zgl;

import nc.vo.pubapp.pattern.model.meta.entity.bill.AbstractBillMeta;

public class AggPu_caigouhet_zglMasterVOMeta  extends AbstractBillMeta{
	
	public AggPu_caigouhet_zglMasterVOMeta(){
		this.init();
	}

    private void init() {
        this.setParent(Pu_caigouhet_zglMasterVO.class);
            this.addChildren(Pu_caigouhet_zglSlave0VO.class);
    }

}
