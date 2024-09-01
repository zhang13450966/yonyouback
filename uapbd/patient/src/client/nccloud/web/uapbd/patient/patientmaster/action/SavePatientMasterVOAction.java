package nccloud.web.uapbd.patient.patientmaster.action;

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
import nc.itf.uapbd.patient.patientmaster.IPatientMasterVOService;
import nc.vo.uapbd.patient.AggPatientMasterVO;

/**
 * 保存action（主子、单表、单form）
 */
public class SavePatientMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		
		IPatientMasterVOService service = ServiceLocator.find(IPatientMasterVOService.class);

		AggPatientMasterVO[] vos = this.getVOs(param, AggPatientMasterVO.class);
		
		vos = service.saveAggPatientMasterVO(vos);
		Object result = buildResult(param,param.getBillCard().getHead()!=null,null,vos);
		return result;
	
	}
	
}