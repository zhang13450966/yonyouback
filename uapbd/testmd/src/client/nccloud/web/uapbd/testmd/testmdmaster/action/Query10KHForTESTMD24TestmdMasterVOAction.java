package  nccloud.web.uapbd.testmd.testmdmaster.action;

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
import nc.itf.uapbd.testmd.testmdmaster.IQuery10KHForTESTMD24;
import nc.vo.bd.cust.pf.AggCustomerPfVO;
import nc.vo.bd.cust.pf.CustomerPfVO;

/**
 * @description 拉单界面查询的 action类
 * @version ncc1.0
 */
public class Query10KHForTESTMD24TestmdMasterVOAction extends BaseAction{

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
			

			IQuery10KHForTESTMD24 iQuery10KHForTESTMD24 = ServiceLocator.find(IQuery10KHForTESTMD24.class);
			// 执行查询
			AggCustomerPfVO[] vos = iQuery10KHForTESTMD24.queryByScheme(queryScheme);
			
			if (vos != null && vos.length > 0) {
				res = tf.toGrid(param.getPageCode(), param.getFormId(), getParentVOs(vos), getAllPks(vos), null);
			}
			
			
		} catch (Exception e) {
			ExceptionUtils.wrapException(e);
		}
		return res;
	}
	private CustomerPfVO[] getParentVOs(AggCustomerPfVO[] vos) {
		return Arrays.stream(vos).map(item->item.getParentVO()).toArray(CustomerPfVO[]::new);
	}
	private String[] getAllPks(AggCustomerPfVO[] vos) {
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
