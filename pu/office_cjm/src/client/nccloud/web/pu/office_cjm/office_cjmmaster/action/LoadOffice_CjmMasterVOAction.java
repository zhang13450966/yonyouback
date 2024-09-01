package nccloud.web.pu.office_cjm.office_cjmmaster.action;
import nccloud.commons.lang.StringUtils;
import nccloud.web.codeplatform.framework.action.base.BaseAction;
import nccloud.web.codeplatform.framework.action.base.RequstParamWapper;
import nccloud.web.codeplatform.framework.action.base.VOTransform;
import nccloud.web.codeplatform.framework.action.base.RequestDTO;
import nccloud.framework.service.ServiceLocator;
import nccloud.framework.web.container.IRequest;
import nccloud.framework.core.exception.BusinessException;
import nc.vo.pu.office_cjm.Office_CjmMasterVO;
import nc.itf.pu.office_cjm.office_cjmmaster.IOffice_CjmMasterVOService;
/**
 * 卡片查询
 */
public class LoadOffice_CjmMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		
		String pk = param.getPk();
		if(StringUtils.isEmpty(pk)){
			throw new BusinessException("参数中缺少pk参数，请检查代码！");
		}
		IOffice_CjmMasterVOService service = ServiceLocator.find(IOffice_CjmMasterVOService.class);
		
		Office_CjmMasterVO vo = service.findOffice_CjmMasterVOByPk(pk,false);
		if(vo == null){
			return null;
		}
		
		return buildResult(param,true,null,vo);
	}
	
}