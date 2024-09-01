package nccloud.web.uapbd.patient.patientmaster.action;
import java.util.HashMap;
import java.util.Map;
import nccloud.web.codeplatform.framework.action.base.BaseAction;
import nccloud.web.codeplatform.framework.action.base.RequstParamWapper;
import nccloud.web.codeplatform.framework.action.base.RequestDTO;
import nccloud.web.codeplatform.framework.action.base.VOTransform;
import nccloud.framework.service.ServiceLocator;
import nccloud.framework.web.container.IRequest;
import nc.vo.uapbd.patient.AggPatientMasterVO;
import nc.itf.uapbd.patient.patientmaster.IPatientMasterVOService;


/**
 * 新增Action
 */
public class AddPatientMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		//json数据转换
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		//获取参数
		Map<String,Object> userJson = param.getUserJson();

		AggPatientMasterVO[] vos = this.getVOs(param, AggPatientMasterVO.class);
		
		//获得实体VO
		IPatientMasterVOService service = ServiceLocator.find(IPatientMasterVOService.class);
		AggPatientMasterVO vo = service.preAddAggPatientMasterVO(vos[0],userJson);
		return buildResult(param,true,null,vo);
		
	}

}