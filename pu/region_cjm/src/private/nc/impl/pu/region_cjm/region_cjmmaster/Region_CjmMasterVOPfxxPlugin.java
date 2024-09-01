
package nc.impl.pu.region_cjm.region_cjmmaster;

import nc.bs.pfxx.plugin.AbstractPfxxPlugin;
import nc.vo.pub.BusinessException;
import nc.bs.pfxx.ISwapContext;
import nc.vo.pfxx.auxiliary.AggxsysregisterVO;
import nc.vo.pfxx.util.PfxxPluginUtils;
import nc.bs.framework.common.NCLocator;
import nc.vo.pu.region_cjm.Region_CjmMasterVO;
import nc.itf.pu.region_cjm.region_cjmmaster.IRegion_CjmMasterVOService;

public class Region_CjmMasterVOPfxxPlugin extends AbstractPfxxPlugin {
	
	@Override
	protected Object processBill(Object vo, ISwapContext swapContext, AggxsysregisterVO aggxsysvo)
			throws BusinessException {
		Region_CjmMasterVO entityVO = (Region_CjmMasterVO)vo;
		String vopk = PfxxPluginUtils.queryBillPKBeforeSaveOrUpdate(swapContext.getBilltype(), swapContext.getDocID());
		entityVO.setPrimaryKey(vopk);
		Region_CjmMasterVO[] saveVO = getService().saveRegion_CjmMasterVO(entityVO);
		return saveVO;
	}
	
	private IRegion_CjmMasterVOService getService() {
		return NCLocator.getInstance().lookup(IRegion_CjmMasterVOService.class);
	}
}