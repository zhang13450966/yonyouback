package nccloud.web.pu.office_cjm.office_cjmmaster.action;

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
import nc.itf.pu.office_cjm.office_cjmmaster.IOffice_CjmMasterVOService;
import nc.vo.pu.office_cjm.Office_CjmMasterVO;
/**
 * 列表查询
 */
public class ListOffice_CjmMasterVOAction extends BaseAction{

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

		IOffice_CjmMasterVOService service = ServiceLocator.find(IOffice_CjmMasterVOService.class);
		//>>是否需要判断当前是树表节点
		String treeNodePk = param.getTreeNodePk();
		String pid = param.getPid();
		String[] allpks = service.listOffice_CjmMasterVOPkBySql(searchSql,pid,treeNodePk);
		if(ArrayUtils.isEmpty(allpks)){
			return null;
		}
		//pk排序
		//Arrays.sort(allpks);
		param.setAllpks(allpks);
		//根据分页拿到当前分页的pk
		String[] curPagePks = pageInfo == null ? allpks : paramWapper.pageResult(pageInfo, allpks);
		//查询当前分页数据
		Office_CjmMasterVO[] vos =  service.listOffice_CjmMasterVOByPk(curPagePks,true);
		//构造返回结果
		return buildResult(param,false,null,vos);
	}
	
}