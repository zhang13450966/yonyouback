
package nc.impl.uapbd.patient.patientmaster;

import nc.bs.pfxx.plugin.AbstractPfxxPlugin;
import nc.vo.pub.BusinessException;
import nc.bs.pfxx.ISwapContext;
import nc.vo.pfxx.auxiliary.AggxsysregisterVO;
import nc.vo.pfxx.util.PfxxPluginUtils;
import nc.bs.framework.common.NCLocator;
import nc.vo.uapbd.patient.AggPatientMasterVO;
import nc.itf.uapbd.patient.patientmaster.IPatientMasterVOService;

public class PatientMasterVOPfxxPlugin extends AbstractPfxxPlugin {
	
	@Override
	protected Object processBill(Object vo, ISwapContext swapContext, AggxsysregisterVO aggxsysvo)
			throws BusinessException {
		AggPatientMasterVO entityVO = (AggPatientMasterVO)vo;
		String vopk = PfxxPluginUtils.queryBillPKBeforeSaveOrUpdate(swapContext.getBilltype(), swapContext.getDocID());
		entityVO.getParentVO().setPrimaryKey(vopk);
		AggPatientMasterVO[] saveVO = getService().saveAggPatientMasterVO(entityVO);
		return saveVO;
	}
	
	private IPatientMasterVOService getService() {
		return NCLocator.getInstance().lookup(IPatientMasterVOService.class);
	}
}