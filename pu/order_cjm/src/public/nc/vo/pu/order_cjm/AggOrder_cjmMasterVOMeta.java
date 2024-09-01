package nc.vo.pu.order_cjm;

import nc.vo.pubapp.pattern.model.meta.entity.bill.AbstractBillMeta;

public class AggOrder_cjmMasterVOMeta  extends AbstractBillMeta{
	
	public AggOrder_cjmMasterVOMeta(){
		this.init();
	}

    private void init() {
        this.setParent(nc.vo.pu.order_cjm.Order_cjmMasterVO.class);
            this.addChildren(nc.vo.pu.order_cjm.Order_cjmSlave0VO.class);
    }

}
