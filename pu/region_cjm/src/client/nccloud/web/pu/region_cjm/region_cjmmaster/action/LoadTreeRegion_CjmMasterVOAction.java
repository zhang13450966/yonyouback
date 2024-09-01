package nccloud.web.pu.region_cjm.region_cjmmaster.action;
import java.util.HashMap;
import java.util.Map;
import nccloud.commons.lang.ArrayUtils;
import nccloud.web.codeplatform.framework.action.base.BaseAction;
import nccloud.web.codeplatform.framework.action.base.RequestDTO;
import nccloud.web.codeplatform.framework.action.base.RequstParamWapper;
import nccloud.web.codeplatform.framework.action.base.VOTransform;
import nccloud.framework.service.ServiceLocator;
import nccloud.framework.web.container.IRequest;
import nc.vo.pu.region_cjm.Region_CjmMasterVO;

import nc.itf.pu.region_cjm.region_cjmmaster.IRegion_CjmMasterVOService;

public class LoadTreeRegion_CjmMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable {
		//jsonÊý¾Ý×ª»»
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		Map<String,Object> map = param.getUserJson();
		if(map == null) {
			map = new HashMap<String,Object>();
		}
		map.put("showOff",!param.getShowOff()?"Y":"N");
		
		IRegion_CjmMasterVOService service = ServiceLocator.find(IRegion_CjmMasterVOService.class);
		Region_CjmMasterVO[] vos = service.loadTreeData(Region_CjmMasterVO.class,map);
		
		if(ArrayUtils.isEmpty(vos)) {
			return null;
		}
		return buildResult(null,vos);	
	}

}
