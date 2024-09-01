package nccloud.web.pu.region_cjm.region_cjmmaster.action;
import java.util.HashMap;
import java.util.Map;
import nccloud.web.codeplatform.framework.action.base.BaseAction;
import nccloud.web.codeplatform.framework.action.base.RequstParamWapper;
import nccloud.web.codeplatform.framework.action.base.RequestDTO;
import nccloud.web.codeplatform.framework.action.base.VOTransform;
import nccloud.framework.service.ServiceLocator;
import nccloud.framework.web.container.IRequest;
import nc.vo.pu.region_cjm.Region_CjmMasterVO;
import nc.itf.pu.region_cjm.region_cjmmaster.IRegion_CjmMasterVOService;


/**
 * 新增Action
 */
public class AddRegion_CjmMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		//json数据转换
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		//获取参数
		Map<String,Object> userJson = param.getUserJson();

		Region_CjmMasterVO[] vos = this.getVOs(param, Region_CjmMasterVO.class);
		
		//获得实体VO
		IRegion_CjmMasterVOService service = ServiceLocator.find(IRegion_CjmMasterVOService.class);
		Region_CjmMasterVO vo = service.preAddRegion_CjmMasterVO(vos[0],userJson);
		return buildResult(param,true,null,vo);
		
	}

}