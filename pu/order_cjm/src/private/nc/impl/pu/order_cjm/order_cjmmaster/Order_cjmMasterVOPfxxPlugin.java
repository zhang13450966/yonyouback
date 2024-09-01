
package nc.impl.pu.order_cjm.order_cjmmaster;

import nc.bs.pfxx.plugin.AbstractPfxxPlugin;
import nc.vo.pub.BusinessException;
import nc.bs.pfxx.ISwapContext;
import nc.vo.pfxx.auxiliary.AggxsysregisterVO;
import nc.vo.pfxx.util.PfxxPluginUtils;
import nc.bs.framework.common.NCLocator;
import nc.vo.pu.order_cjm.AggOrder_cjmMasterVO;
import nc.itf.pu.order_cjm.order_cjmmaster.IOrder_cjmMasterVOService;

public class Order_cjmMasterVOPfxxPlugin extends AbstractPfxxPlugin {
	
	@Override
	protected Object processBill(Object vo, ISwapContext swapContext, AggxsysregisterVO aggxsysvo)
			throws BusinessException {
		AggOrder_cjmMasterVO entityVO = (AggOrder_cjmMasterVO)vo;
		String vopk = PfxxPluginUtils.queryBillPKBeforeSaveOrUpdate(swapContext.getBilltype(), swapContext.getDocID());
		entityVO.getParentVO().setPrimaryKey(vopk);
		AggOrder_cjmMasterVO[] saveVO = getService().saveAggOrder_cjmMasterVO(entityVO);
		return saveVO;
	}
	
	private IOrder_cjmMasterVOService getService() {
		return NCLocator.getInstance().lookup(IOrder_cjmMasterVOService.class);
	}
}