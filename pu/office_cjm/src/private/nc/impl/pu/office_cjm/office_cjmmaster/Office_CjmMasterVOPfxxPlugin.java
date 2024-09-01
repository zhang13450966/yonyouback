
package nc.impl.pu.office_cjm.office_cjmmaster;

import nc.bs.pfxx.plugin.AbstractPfxxPlugin;
import nc.vo.pub.BusinessException;
import nc.bs.pfxx.ISwapContext;
import nc.vo.pfxx.auxiliary.AggxsysregisterVO;
import nc.vo.pfxx.util.PfxxPluginUtils;
import nc.bs.framework.common.NCLocator;
import nc.vo.pu.office_cjm.Office_CjmMasterVO;
import nc.itf.pu.office_cjm.office_cjmmaster.IOffice_CjmMasterVOService;

public class Office_CjmMasterVOPfxxPlugin extends AbstractPfxxPlugin {
	
	@Override
	protected Object processBill(Object vo, ISwapContext swapContext, AggxsysregisterVO aggxsysvo)
			throws BusinessException {
		Office_CjmMasterVO entityVO = (Office_CjmMasterVO)vo;
		String vopk = PfxxPluginUtils.queryBillPKBeforeSaveOrUpdate(swapContext.getBilltype(), swapContext.getDocID());
		entityVO.setPrimaryKey(vopk);
		Office_CjmMasterVO[] saveVO = getService().saveOffice_CjmMasterVO(entityVO);
		return saveVO;
	}
	
	private IOffice_CjmMasterVOService getService() {
		return NCLocator.getInstance().lookup(IOffice_CjmMasterVOService.class);
	}
}