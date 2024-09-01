package nc.vo.uapbd.patient;

import nc.vo.pubapp.pattern.model.meta.entity.bill.AbstractBillMeta;

public class AggPatientMasterVOMeta  extends AbstractBillMeta{
	
	public AggPatientMasterVOMeta(){
		this.init();
	}

    private void init() {
        this.setParent(nc.vo.uapbd.patient.PatientMasterVO.class);
    }

}
