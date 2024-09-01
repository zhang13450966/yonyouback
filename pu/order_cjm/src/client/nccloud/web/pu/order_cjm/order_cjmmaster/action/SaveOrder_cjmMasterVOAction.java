package nccloud.web.pu.order_cjm.order_cjmmaster.action;

import java.util.HashMap;
//import java.util.List;
import java.util.Map;
//import nccloud.framework.web.ui.pattern.grid.Grid;
import nccloud.web.codeplatform.framework.action.base.BaseAction;
import nccloud.web.codeplatform.framework.action.base.RequstParamWapper;
import nccloud.web.codeplatform.framework.action.base.RequestDTO;
import nccloud.web.codeplatform.framework.action.base.VOTransform;
import nccloud.framework.service.ServiceLocator;
import nccloud.framework.core.util.ArrayUtils;
import nccloud.framework.web.container.IRequest;
import nc.itf.pu.order_cjm.order_cjmmaster.IOrder_cjmMasterVOService;
import nc.vo.pu.order_cjm.AggOrder_cjmMasterVO;

/**
 * 保存action（主子、单表、单form）
 */
public class SaveOrder_cjmMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		
		IOrder_cjmMasterVOService service = ServiceLocator.find(IOrder_cjmMasterVOService.class);

		AggOrder_cjmMasterVO[] vos = this.getVOs(param, AggOrder_cjmMasterVO.class);
		
		vos = service.saveAggOrder_cjmMasterVO(vos[0]);
		Object result = buildResult(param,param.getBillCard().getHead()!=null,null,vos);
		return result;
	
	}
	
}