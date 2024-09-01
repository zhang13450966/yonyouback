package nccloud.web.pu.region_cjm.region_cjmmaster.action;

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
import nc.itf.pu.region_cjm.region_cjmmaster.IRegion_CjmMasterVOService;
import nc.vo.pu.region_cjm.Region_CjmMasterVO;
import nc.vo.pub.AggregatedValueObject;
import nc.vo.pub.SuperVO;

/**
 * 保存action（主子、单表、单form）
 */
public class SaveRegion_CjmMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		
		IRegion_CjmMasterVOService service = ServiceLocator.find(IRegion_CjmMasterVOService.class);

		Region_CjmMasterVO[] vos = this.getVOs(param, Region_CjmMasterVO.class);
		
		vos = service.saveRegion_CjmMasterVO(vos[0]);
		Object result = buildResult(param,param.getBillCard().getHead()!=null,null,vos);
		if(ArrayUtils.isEmpty(vos)) {
			return null;
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("data",result);
		map.put("treeNode",buildResult(null,getMainVO(vos[0])));
		return map;
	
	}
	public SuperVO getMainVO(Object vo) {
		SuperVO parentVO = null;
		if (vo instanceof SuperVO) {
			parentVO = (SuperVO) vo;
		} else if (vo instanceof AggregatedValueObject) {
			parentVO = (SuperVO) ((AggregatedValueObject) vo).getParentVO();
		} else {
			throw new IllegalArgumentException("vo type illegal ,must be supervo or aggvo!");
		}
		return parentVO;
	}
	
}