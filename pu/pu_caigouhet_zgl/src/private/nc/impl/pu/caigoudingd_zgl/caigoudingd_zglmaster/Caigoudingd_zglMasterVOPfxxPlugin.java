
package nc.impl.pu.caigoudingd_zgl.caigoudingd_zglmaster;

import nc.bs.pfxx.plugin.AbstractPfxxPlugin;
import nc.vo.pub.BusinessException;
import nc.bs.pfxx.ISwapContext;
import nc.vo.pfxx.auxiliary.AggxsysregisterVO;
import nc.vo.pfxx.util.PfxxPluginUtils;
import nc.bs.framework.common.NCLocator;
import nc.vo.caigoudingdan.caigoudingd_zgl.AggCaigoudingd_zglMasterVO;
import nc.itf.pu.caigoudingd_zgl.caigoudingd_zglmaster.ICaigoudingd_zglMasterVOService;

public class Caigoudingd_zglMasterVOPfxxPlugin extends AbstractPfxxPlugin {
	
	@Override
	protected Object processBill(Object vo, ISwapContext swapContext, AggxsysregisterVO aggxsysvo)
			throws BusinessException {
		AggCaigoudingd_zglMasterVO entityVO = (AggCaigoudingd_zglMasterVO)vo;
		String vopk = PfxxPluginUtils.queryBillPKBeforeSaveOrUpdate(swapContext.getBilltype(), swapContext.getDocID());
		entityVO.getParentVO().setPrimaryKey(vopk);
		AggCaigoudingd_zglMasterVO[] saveVO = getService().saveAggCaigoudingd_zglMasterVO(entityVO);
		return saveVO;
	}
	
	private ICaigoudingd_zglMasterVOService getService() {
		return NCLocator.getInstance().lookup(ICaigoudingd_zglMasterVOService.class);
	}
}