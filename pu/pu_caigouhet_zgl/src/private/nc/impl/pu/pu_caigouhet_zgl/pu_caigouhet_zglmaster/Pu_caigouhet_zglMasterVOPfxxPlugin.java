
package nc.impl.pu.pu_caigouhet_zgl.pu_caigouhet_zglmaster;

import nc.bs.pfxx.plugin.AbstractPfxxPlugin;
import nc.vo.pub.BusinessException;
import nc.bs.pfxx.ISwapContext;
import nc.vo.pfxx.auxiliary.AggxsysregisterVO;
import nc.vo.pfxx.util.PfxxPluginUtils;
import nc.bs.framework.common.NCLocator;
import nc.vo.pu.pu_caigouhet_zgl.AggPu_caigouhet_zglMasterVO;
import nc.itf.pu.pu_caigouhet_zgl.pu_caigouhet_zglmaster.IPu_caigouhet_zglMasterVOService;

public class Pu_caigouhet_zglMasterVOPfxxPlugin extends AbstractPfxxPlugin {
	
	@Override
	protected Object processBill(Object vo, ISwapContext swapContext, AggxsysregisterVO aggxsysvo)
			throws BusinessException {
		AggPu_caigouhet_zglMasterVO entityVO = (AggPu_caigouhet_zglMasterVO)vo;
		String vopk = PfxxPluginUtils.queryBillPKBeforeSaveOrUpdate(swapContext.getBilltype(), swapContext.getDocID());
		entityVO.getParentVO().setPrimaryKey(vopk);
		AggPu_caigouhet_zglMasterVO[] saveVO = getService().saveAggPu_caigouhet_zglMasterVO(entityVO);
		return saveVO;
	}
	
	private IPu_caigouhet_zglMasterVOService getService() {
		return NCLocator.getInstance().lookup(IPu_caigouhet_zglMasterVOService.class);
	}
}