package nccloud.web.pu.order_cjm.order_cjmmaster.action;

import java.util.Map;
import nccloud.web.codeplatform.framework.action.base.BaseAction;
import nccloud.web.codeplatform.framework.action.base.RequstParamWapper;
import nccloud.web.codeplatform.framework.action.base.VOTransform;
import nccloud.web.codeplatform.framework.action.base.RequestDTO;
import nc.vo.pub.BusinessException;
import nccloud.framework.service.ServiceLocator;
import nccloud.framework.web.container.IRequest;
import nccloud.framework.core.exception.ExceptionUtils;
import nc.vo.pu.order_cjm.AggOrder_cjmMasterVO;
import nc.itf.pu.order_cjm.order_cjmmaster.IOrder_cjmMasterVOService;

public class PFlowOrder_cjmMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper) throws Throwable{
		RequestDTO param = VOTransform.toVO(paramWapper.requestString,RequestDTO.class);
		Map<String,String> tsMap = param.getTsMap();
		String actionName = param.getActionName();
		if(tsMap==null || tsMap.size()==0){
			ExceptionUtils.wrapBusinessException("��ѡ����Ҫ���������ݣ�");
		}
		Map<String,Object> userJson = param.getUserJson();
		Object assign=null;//ָ����Ϣ
		if(userJson!=null&&userJson.get("assign")!=null) {//��ȡָ����Ϣ
			assign = userJson.get("assign");
		}
		 
		return this.exeFlow(actionName,tsMap,assign);
	}
	private Object exeFlow(String actionName,Map<String,String> tsMap,Object assign) throws BusinessException{
		final String ACTION_SAVE="SAVE",ACTION_UNSAVE="UNSAVE";//�ύ���ջ�
		IOrder_cjmMasterVOService service = ServiceLocator.find(IOrder_cjmMasterVOService.class);
		Object res = null;
		
		if(tsMap.size()==1){//��������
			if(ACTION_SAVE.equals(actionName)){//�����ύ
				res = service.commitAggOrder_cjmMasterVO(actionName,tsMap,assign);
			}else if(ACTION_UNSAVE.equals(actionName)){//�����ջ�
				res = service.uncommitAggOrder_cjmMasterVO(actionName,tsMap);
			}
		}else{//��������
			if(ACTION_SAVE.equals(actionName)){//�����ύ
				res = service.batchCommitAggOrder_cjmMasterVO(actionName, tsMap);
			}else if(ACTION_UNSAVE.equals(actionName)){//�����ջ�
				res = service.batchUncommitAggOrder_cjmMasterVO(actionName, tsMap);
			}
		}
		
		return res;
	}
}