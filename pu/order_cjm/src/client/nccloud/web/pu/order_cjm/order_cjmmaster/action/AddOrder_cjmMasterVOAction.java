package nccloud.web.pu.order_cjm.order_cjmmaster.action;
import java.util.HashMap;
import java.util.Map;
import nc.pub.billcode.vo.BillCodeContext;
import nccloud.web.codeplatform.framework.action.base.BaseAction;
import nccloud.web.codeplatform.framework.action.base.RequstParamWapper;
import nccloud.web.codeplatform.framework.action.base.RequestDTO;
import nccloud.web.codeplatform.framework.action.base.VOTransform;
import nccloud.framework.service.ServiceLocator;
import nccloud.framework.web.container.IRequest;
import nc.vo.pu.order_cjm.AggOrder_cjmMasterVO;
import nc.itf.pu.order_cjm.order_cjmmaster.IOrder_cjmMasterVOService;


/**
 * 新增Action
 */
public class AddOrder_cjmMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		//json数据转换
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		//获取参数
		Map<String,Object> userJson = param.getUserJson();

		AggOrder_cjmMasterVO[] vos = this.getVOs(param, AggOrder_cjmMasterVO.class);
		
		//获得实体VO
		IOrder_cjmMasterVOService service = ServiceLocator.find(IOrder_cjmMasterVOService.class);
		AggOrder_cjmMasterVO vo = service.preAddAggOrder_cjmMasterVO(vos[0],userJson);
		Map<String,Object> externalData = new HashMap<>();
		BillCodeContext context = service.getBillCodeContext("puorder_cjm");
		externalData.put("billCodeContext",context);
		return buildResult(param,true,externalData,vo);
		
	}

}