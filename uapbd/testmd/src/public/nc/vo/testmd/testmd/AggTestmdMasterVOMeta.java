package nc.vo.testmd.testmd;

import nc.vo.pubapp.pattern.model.meta.entity.bill.AbstractBillMeta;

public class AggTestmdMasterVOMeta  extends AbstractBillMeta{
	
	public AggTestmdMasterVOMeta(){
		this.init();
	}

    private void init() {
        this.setParent(nc.vo.testmd.testmd.TestmdMasterVO.class);
            this.addChildren(nc.vo.testmd.testmd.TestmdSlave0VO.class);
    }

}
