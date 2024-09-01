
package nc.impl.pu.order_cjm.order_cjmmaster;

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
import nc.vo.pu.order_cjm.Order_cjmSlave0VO;
import nc.vo.pu.order_cjm.Order_cjmMasterVO;
import nc.vo.pu.order_cjm.AggOrder_cjmMasterVO;
import nc.itf.pu.order_cjm.order_cjmmaster.IOrder_cjmMasterVOService;

public class AggOrder_cjmMasterVOImportProcess extends AbstractImportProceeWithContext {
	
	@Override
	protected void processBillWithContext(Object vo, IXChangeContext changcontext) throws BusinessException {
		AggOrder_cjmMasterVO targetVO = (AggOrder_cjmMasterVO)vo;
		targetVO.getParentVO().setStatus(VOStatus.NEW);

		Order_cjmSlave0VO[] order_cjmSlave0VOs = (Order_cjmSlave0VO[])targetVO.getChildren(Order_cjmSlave0VO.class);
		if(order_cjmSlave0VOs!=null && order_cjmSlave0VOs.length>0){
			Arrays.stream(order_cjmSlave0VOs).forEach(subvo->{
				subvo.setStatus(VOStatus.NEW);
			});
		}
  		getService().initDefaultData(targetVO.getParentVO());
		getService().saveAggOrder_cjmMasterVO(targetVO);
	}
	
	private IOrder_cjmMasterVOService getService() {
		return NCLocator.getInstance().lookup(IOrder_cjmMasterVOService.class);
	}

}
