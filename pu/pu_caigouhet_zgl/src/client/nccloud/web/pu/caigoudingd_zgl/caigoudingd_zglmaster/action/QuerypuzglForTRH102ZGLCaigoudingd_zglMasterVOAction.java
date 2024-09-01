package nccloud.web.pu.caigoudingd_zgl.caigoudingd_zglmaster.action;

import java.util.Arrays;

import nccloud.web.codeplatform.framework.action.base.BaseAction;
import nccloud.web.codeplatform.framework.action.base.RequestDTO;
import nccloud.web.codeplatform.framework.action.base.RequstParamWapper;
import nccloud.web.codeplatform.framework.action.base.VOTransform;

import nc.vo.pub.BusinessException;
import nc.ui.querytemplate.querytree.IQueryScheme;
import nccloud.web.codeplatform.framework.action.base.ResultWapper;
import nccloud.dto.baseapp.querytree.dataformat.QueryTreeFormatVO;
import nccloud.framework.core.exception.ExceptionUtils; 
import nccloud.framework.service.ServiceLocator;
import nccloud.framework.web.container.IRequest;
import nccloud.pubitf.platform.query.INCCloudQueryService;
import nc.itf.pu.caigoudingd_zgl.caigoudingd_zglmaster.IQuerypuzglForTRH102ZGL;
import nc.vo.pu.pu_caigouhet_zgl.AggPu_caigouhet_zglMasterVO;
import nc.vo.pu.pu_caigouhet_zgl.Pu_caigouhet_zglMasterVO;

/**
 * @description 拉单界面查询的 action类
 * @version ncc1.0
 */
public class QuerypuzglForTRH102ZGLCaigoudingd_zglMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) {
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		QueryTreeFormatVO queryInfo = param.getQueryTreeFormatVO();
		VOTransform tf = new VOTransform(null, param.getPageCode());
	
		ResultWapper res = null;
		try {
			// 查询条件转换为queryScheme
			IQueryScheme queryScheme = ServiceLocator.find(INCCloudQueryService.class)
					.convertCondition(queryInfo);
			

			IQuerypuzglForTRH102ZGL iQuerypuzglForTRH102ZGL = ServiceLocator.find(IQuerypuzglForTRH102ZGL.class);
			// 执行查询
			AggPu_caigouhet_zglMasterVO[] vos = iQuerypuzglForTRH102ZGL.queryByScheme(queryScheme);
			
			if (vos != null && vos.length > 0) {
				res = tf.toGrid(param.getPageCode(), param.getFormId(), getParentVOs(vos), getAllPks(vos), null);
			}
			
			
		} catch (Exception e) {
			ExceptionUtils.wrapException(e);
		}
		return res;
	}
	private Pu_caigouhet_zglMasterVO[] getParentVOs(AggPu_caigouhet_zglMasterVO[] vos) {
		return Arrays.stream(vos).map(item->item.getParentVO()).toArray(Pu_caigouhet_zglMasterVO[]::new);
	}
	private String[] getAllPks(AggPu_caigouhet_zglMasterVO[] vos) {
		return Arrays.stream(vos).map(item->{
			try {
				return item.getParentVO().getPrimaryKey();
			} catch (Exception ex) {
				ExceptionUtils.wrapException(ex);
			}
			return null;
		}).toArray(String[]::new);
	}

}
