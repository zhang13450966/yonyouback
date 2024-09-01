package nccloud.web.pu.pu_caigouhet_zgl.pu_caigouhet_zglmaster.action;

import java.util.Arrays;
import java.util.Collections;

import nccloud.web.codeplatform.framework.action.base.BaseAction;
import nccloud.web.codeplatform.framework.action.base.RequstParamWapper;
import nccloud.web.codeplatform.framework.action.base.VOTransform;
import nccloud.web.codeplatform.framework.action.base.RequestDTO;

import nccloud.framework.service.ServiceLocator;
import nccloud.framework.web.container.IRequest;

import nccloud.pubitf.platform.query.INCCloudQueryService;
import nccloud.dto.baseapp.querytree.dataformat.QueryTreeFormatVO;
import nc.ui.querytemplate.querytree.IQueryScheme;
import nccloud.commons.lang.StringUtils;
import nccloud.commons.lang.ArrayUtils;
import nccloud.framework.web.ui.model.PageInfo;
import nc.itf.pu.pu_caigouhet_zgl.pu_caigouhet_zglmaster.IPu_caigouhet_zglMasterVOService;
import nc.vo.pu.pu_caigouhet_zgl.Pu_caigouhet_zglMasterVO;
/**
 * 列表查询
 */
public class ListPu_caigouhet_zglMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		//json数据转换
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		
		PageInfo pageInfo = param.getPageInfo();
		
		//查询方案
		INCCloudQueryService nccloudService = ServiceLocator.find(INCCloudQueryService.class);
		QueryTreeFormatVO queryVo = param.getQueryTreeFormatVO();
		String searchSql = "";
		if(queryVo != null){
			IQueryScheme searchService = nccloudService.convertCondition(queryVo);
			searchSql = searchService.getWhereSQLOnly();
		}

		IPu_caigouhet_zglMasterVOService service = ServiceLocator.find(IPu_caigouhet_zglMasterVOService.class);
		//查询当前方案下所有的数据pk
		String[] allpks = service.listPu_caigouhet_zglMasterVOPkByCond(searchSql);
		if(ArrayUtils.isEmpty(allpks)){
			return null;
		}
		//pk排序
		//Arrays.sort(allpks);
		param.setAllpks(allpks);
		//根据分页拿到当前分页的pk
		String[] curPagePks = pageInfo == null ? allpks : paramWapper.pageResult(pageInfo, allpks);
		Pu_caigouhet_zglMasterVO[] vos =  service.listPu_caigouhet_zglMasterVOByPk(curPagePks);
		//构造返回结果
		return buildResult(param,false,null,vos);
	}
	
}