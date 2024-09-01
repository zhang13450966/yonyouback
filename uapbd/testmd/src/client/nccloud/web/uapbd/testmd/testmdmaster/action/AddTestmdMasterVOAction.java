package nccloud.web.uapbd.testmd.testmdmaster.action;
import java.util.HashMap;
import java.util.Map;
import nc.pub.billcode.vo.BillCodeContext;
import nccloud.web.codeplatform.framework.action.base.BaseAction;
import nccloud.web.codeplatform.framework.action.base.RequstParamWapper;
import nccloud.web.codeplatform.framework.action.base.RequestDTO;
import nccloud.web.codeplatform.framework.action.base.VOTransform;
import nccloud.framework.service.ServiceLocator;
import nccloud.framework.web.container.IRequest;
import nc.vo.testmd.testmd.AggTestmdMasterVO;
import nc.itf.uapbd.testmd.testmdmaster.ITestmdMasterVOService;


/**
 * 新增Action
 */
public class AddTestmdMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		//json数据转换
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		//获取参数
		Map<String,Object> userJson = param.getUserJson();

		AggTestmdMasterVO[] vos = this.getVOs(param, AggTestmdMasterVO.class);
		
		//获得实体VO
		ITestmdMasterVOService service = ServiceLocator.find(ITestmdMasterVOService.class);
		AggTestmdMasterVO vo = service.preAddAggTestmdMasterVO(vos[0],userJson);
		Map<String,Object> externalData = new HashMap<>();
		BillCodeContext context = service.getBillCodeContext("testmdtestmd");
		externalData.put("billCodeContext",context);
		return buildResult(param,true,externalData,vo);
		
	}

}