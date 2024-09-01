package nccloud.web.pu.office_cjm.office_cjmmaster.action;
import java.util.HashMap;
import java.util.Map;
import nccloud.commons.lang.ArrayUtils;
import nccloud.web.codeplatform.framework.action.base.BaseAction;
import nccloud.web.codeplatform.framework.action.base.RequestDTO;
import nccloud.web.codeplatform.framework.action.base.RequstParamWapper;
import nccloud.web.codeplatform.framework.action.base.VOTransform;
import nccloud.framework.service.ServiceLocator;
import nccloud.framework.web.container.IRequest;
import nc.vo.pu.office_cjm.Office_CjmMasterVO;

import nc.itf.pu.office_cjm.office_cjmmaster.IRegion_CjmMasterVOService;
import nc.vo.pu.region_cjm.Region_CjmMasterVO;

public class LoadTreeRegion_CjmMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable {
		//jsonÊý¾Ý×ª»»
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		Map<String,Object> map = param.getUserJson();
		if(map == null) {
			map = new HashMap<String,Object>();
		}
	
		Map<String, Object> userJson = param.getUserJson();
		String appcode = (String) userJson.get("appcode");
		IRegion_CjmMasterVOService service = ServiceLocator.find(IRegion_CjmMasterVOService.class);
		Region_CjmMasterVO[] vos = service.loadTreeData(appcode);
		
		if(ArrayUtils.isEmpty(vos)) {
			return null;
		}
		return buildResult(null,vos);	
	}

}
