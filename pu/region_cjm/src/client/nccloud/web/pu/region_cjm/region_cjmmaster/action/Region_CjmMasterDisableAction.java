
package nccloud.web.pu.region_cjm.region_cjmmaster.action;
import nccloud.web.action.NCCAction;
import nccloud.commons.lang.ArrayUtils;
import nccloud.framework.web.container.IRequest;
import nccloud.framework.service.ServiceLocator;
import nccloud.web.uapbd.commons.web.ParamUtils;
import nc.itf.pu.region_cjm.region_cjmmaster.IRegion_CjmMasterVOService;
import nc.vo.pu.region_cjm.Region_CjmMasterVO;

/**
 * 
 *	档案停用Action
 * 
 * @author zhaoxwf
 * 
 */
public class Region_CjmMasterDisableAction extends NCCAction {
	
	@Override
	public <T> Object execute(IRequest request, T para) throws Exception {
	
		ParamUtils param = new ParamUtils(request);
		String[] pks = param.getStrings("pks");	
		
		Region_CjmMasterVO[] vos = getService().listRegion_CjmMasterVOByPk(pks,false);
		if(ArrayUtils.isNotEmpty(vos)) {
			getService().batchDisable(vos);
		}
		return null;
	}
	
	/**
	 * 	数据权限校验值
	 * 
	 * @param request
	 * @param vos
	 * @throws Exception
	 */
	public void checkDataPermission(IRequest request, Region_CjmMasterVO[] vos) throws Exception {
		// 数据权限校验值set
		super.setMdOperateCode("enable");
		super.setResourceCode("region_CjmMaster");
		super.checkDataPermission(request, vos);
	}
	
	private IRegion_CjmMasterVOService getService() {
		return ServiceLocator.find(IRegion_CjmMasterVOService.class);
	}

}
