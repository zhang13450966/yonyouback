package nccloud.web.pu.pu_caigouhet_zgl.pu_caigouhet_zglmaster.action;
import java.util.HashMap;
import java.util.Map;
import nc.pub.billcode.vo.BillCodeContext;
import nccloud.web.codeplatform.framework.action.base.BaseAction;
import nccloud.web.codeplatform.framework.action.base.RequstParamWapper;
import nccloud.web.codeplatform.framework.action.base.RequestDTO;
import nccloud.web.codeplatform.framework.action.base.VOTransform;
import nccloud.framework.service.ServiceLocator;
import nccloud.framework.web.container.IRequest;
import nc.vo.pu.pu_caigouhet_zgl.AggPu_caigouhet_zglMasterVO;
import nc.itf.pu.pu_caigouhet_zgl.pu_caigouhet_zglmaster.IPu_caigouhet_zglMasterVOService;

/**
 * 编辑Action
 */
public class CopyPu_caigouhet_zglMasterVOAction extends BaseAction{
	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		//json数据转换
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		//获取参数
		String pk = param.getPk();
		
		IPu_caigouhet_zglMasterVOService service = ServiceLocator.find(IPu_caigouhet_zglMasterVOService.class);
		
		AggPu_caigouhet_zglMasterVO vo = service.copyAggPu_caigouhet_zglMasterVO(pk);
		
		if(vo == null){
			return null;
		}
		Map<String,Object> externalData = new HashMap<>();
		BillCodeContext context = service.getBillCodeContext("pupu_caigouhet_zgl");
		externalData.put("billCodeContext",context);
		return buildResult(param,true,externalData,vo);
	}
	
}