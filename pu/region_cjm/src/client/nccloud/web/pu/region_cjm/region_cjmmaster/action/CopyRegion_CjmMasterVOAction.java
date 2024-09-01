package nccloud.web.pu.region_cjm.region_cjmmaster.action;
import java.util.HashMap;
import java.util.Map;
import nccloud.web.codeplatform.framework.action.base.BaseAction;
import nccloud.web.codeplatform.framework.action.base.RequstParamWapper;
import nccloud.web.codeplatform.framework.action.base.RequestDTO;
import nccloud.web.codeplatform.framework.action.base.VOTransform;
import nccloud.framework.service.ServiceLocator;
import nccloud.framework.web.container.IRequest;
import nc.vo.pu.region_cjm.Region_CjmMasterVO;
import nc.itf.pu.region_cjm.region_cjmmaster.IRegion_CjmMasterVOService;

/**
 * �༭Action
 */
public class CopyRegion_CjmMasterVOAction extends BaseAction{
	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		//json����ת��
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		//��ȡ����
		String pk = param.getPk();
		
		IRegion_CjmMasterVOService service = ServiceLocator.find(IRegion_CjmMasterVOService.class);
		
		Region_CjmMasterVO vo = service.copyRegion_CjmMasterVO(pk);
		
		if(vo == null){
			return null;
		}
		return buildResult(param,true,null,vo);
	}
	
}