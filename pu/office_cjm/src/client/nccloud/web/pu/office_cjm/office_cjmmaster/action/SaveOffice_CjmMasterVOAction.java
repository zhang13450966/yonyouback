package nccloud.web.pu.office_cjm.office_cjmmaster.action;

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
import nc.itf.pu.office_cjm.office_cjmmaster.IOffice_CjmMasterVOService;
import nc.vo.pu.office_cjm.Office_CjmMasterVO;

/**
 * 保存action（主子、单表、单form）
 */
public class SaveOffice_CjmMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		
		IOffice_CjmMasterVOService service = ServiceLocator.find(IOffice_CjmMasterVOService.class);

		Office_CjmMasterVO[] vos = this.getVOs(param, Office_CjmMasterVO.class);
		
		vos = service.saveOffice_CjmMasterVO(vos[0]);
		Object result = buildResult(param,param.getBillCard().getHead()!=null,null,vos);
		return result;
	
	}
	
}