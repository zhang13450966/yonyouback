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
 * ����Action
 */
public class AddPatientMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		//json����ת��
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		//��ȡ����
		Map<String,Object> userJson = param.getUserJson();

		AggPatientMasterVO[] vos = this.getVOs(param, AggPatientMasterVO.class);
		
		//���ʵ��VO
		IPatientMasterVOService service = ServiceLocator.find(IPatientMasterVOService.class);
		AggPatientMasterVO vo = service.preAddAggPatientMasterVO(vos[0],userJson);
		return buildResult(param,true,null,vo);
		
	}

}