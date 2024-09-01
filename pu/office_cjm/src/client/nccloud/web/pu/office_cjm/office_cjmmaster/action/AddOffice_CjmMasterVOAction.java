package nccloud.web.pu.office_cjm.office_cjmmaster.action;
import java.util.HashMap;
import java.util.Map;
import nccloud.web.codeplatform.framework.action.base.BaseAction;
import nccloud.web.codeplatform.framework.action.base.RequstParamWapper;
import nccloud.web.codeplatform.framework.action.base.RequestDTO;
import nccloud.web.codeplatform.framework.action.base.VOTransform;
import nccloud.framework.service.ServiceLocator;
import nccloud.framework.web.container.IRequest;
import nc.vo.pu.office_cjm.Office_CjmMasterVO;
import nc.itf.pu.office_cjm.office_cjmmaster.IOffice_CjmMasterVOService;


/**
 * 新增Action
 */
public class AddOffice_CjmMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		//json数据转换
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		//获取参数
		Map<String,Object> userJson = param.getUserJson();

		Office_CjmMasterVO[] vos = this.getVOs(param, Office_CjmMasterVO.class);
		
		//获得实体VO
		IOffice_CjmMasterVOService service = ServiceLocator.find(IOffice_CjmMasterVOService.class);
		Office_CjmMasterVO vo = service.preAddOffice_CjmMasterVO(vos[0],userJson);
		return buildResult(param,true,null,vo);
		
	}

}