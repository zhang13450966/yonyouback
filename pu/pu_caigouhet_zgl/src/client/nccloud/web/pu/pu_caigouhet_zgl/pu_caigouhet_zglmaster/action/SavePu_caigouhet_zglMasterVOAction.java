package nccloud.web.pu.pu_caigouhet_zgl.pu_caigouhet_zglmaster.action;

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
import nc.itf.pu.pu_caigouhet_zgl.pu_caigouhet_zglmaster.IPu_caigouhet_zglMasterVOService;
import nc.vo.pu.pu_caigouhet_zgl.AggPu_caigouhet_zglMasterVO;

/**
 * 保存action（主子、单表、单form）
 */
public class SavePu_caigouhet_zglMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		
		IPu_caigouhet_zglMasterVOService service = ServiceLocator.find(IPu_caigouhet_zglMasterVOService.class);

		AggPu_caigouhet_zglMasterVO[] vos = this.getVOs(param, AggPu_caigouhet_zglMasterVO.class);
		
		vos = service.saveAggPu_caigouhet_zglMasterVO(vos[0]);
		Object result = buildResult(param,param.getBillCard().getHead()!=null,null,vos);
		return result;
	
	}
	
}