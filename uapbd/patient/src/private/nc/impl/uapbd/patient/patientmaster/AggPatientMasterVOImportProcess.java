
package nc.impl.uapbd.patient.patientmaster;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

import nc.bs.framework.common.NCLocator;
import nc.vo.pub.BusinessException;
import nc.vo.pub.CircularlyAccessibleValueObject;
import nc.vo.pub.SuperVO;
import nc.vo.pub.ISuperVO;
import nc.vo.pub.IVOMeta;
import nc.vo.pub.VOStatus;
import nc.vo.pubapp.pattern.model.meta.entity.bill.IBillMeta;
import nc.vo.trade.pub.HYBillVO;
import nc.vo.pubapp.pattern.model.entity.bill.AbstractBill;
import nccloud.bs.excel.IXChangeContext;
import nccloud.bs.excel.plugin.AbstractImportProceeWithContext;
import nc.vo.uapbd.patient.PatientMasterVO;
import nc.vo.uapbd.patient.AggPatientMasterVO;
import nc.itf.uapbd.patient.patientmaster.IPatientMasterVOService;

public class AggPatientMasterVOImportProcess extends AbstractImportProceeWithContext {
	
	@Override
	protected void processBillWithContext(Object vo, IXChangeContext changcontext) throws BusinessException {
		SuperVO headVO = (SuperVO)((HYBillVO)vo).getParentVO();
		AggPatientMasterVO targetVO = new AggPatientMasterVO();
		targetVO.setParentVO(headVO);
		targetVO.getParentVO().setStatus(VOStatus.NEW);

  		getService().initDefaultData(targetVO.getParentVO());
		getService().saveAggPatientMasterVO(targetVO);
	}
	
	private IPatientMasterVOService getService() {
		return NCLocator.getInstance().lookup(IPatientMasterVOService.class);
	}

}
