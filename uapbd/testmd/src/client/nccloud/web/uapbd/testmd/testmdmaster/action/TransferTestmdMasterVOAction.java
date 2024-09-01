package nccloud.web.uapbd.testmd.testmdmaster.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

import nc.codeplatform.framework.commons.TransferBTRecord;
import nc.codeplatform.framework.commons.TransferRecord;
import nc.codeplatform.framework.commons.TransferDTO;
import nccloud.web.codeplatform.framework.action.base.BaseAction;
import nccloud.web.codeplatform.framework.action.base.RequstParamWapper;
import nccloud.web.codeplatform.framework.action.base.VOTransform;
import nccloud.web.codeplatform.framework.action.base.ResultWapper;
import nccloud.framework.service.ServiceLocator;
import nccloud.framework.web.container.IRequest;
import nc.pub.billcode.vo.BillCodeContext;
import nc.vo.pub.BusinessException;
import nc.vo.pub.CircularlyAccessibleValueObject;
import nc.vo.pub.VOStatus;
import nc.vo.pubapp.pattern.model.entity.bill.AbstractBill;
import nc.vo.pubapp.pattern.model.meta.entity.bill.IBillMeta;
import nc.vo.testmd.testmd.AggTestmdMasterVO;
import nc.itf.uapbd.testmd.testmdmaster.ITestmdMasterVOService;



/**
 * 
 * @description ����-����ת������action
 * @version ncc1.0
 */
public class TransferTestmdMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper)throws BusinessException {
		TransferDTO param = VOTransform.toVO(paramWapper.requestString,TransferDTO.class);
		
		if(param==null||param.getData()==null||param.getData().length==0){
			return null;
		}
		
		ResultWapper res = null;
		VOTransform tf = new VOTransform(null, param.getPageCode());
		
		AggTestmdMasterVO[] vos = this.transferVos(param.getData());
		setVoStatus(vos);
		res = tf.toList(vos,param.getFormId(),param.getFormListIds(),null);

		Map<String,Object> externalData = new HashMap<>();
		ITestmdMasterVOService service = ServiceLocator.find(ITestmdMasterVOService.class);
		BillCodeContext context = service.getBillCodeContext("testmdtestmd");
		externalData.put("billCodeContext",context);
		res.setExternalData(externalData);
		
		return res;
	}
	/**
	 * ���ýӿڵ���ת����TransferBTRecord::billTypeΪ��Ӧ�������ͣ�TransferBTRecord::recordsΪѡ��ļ�¼��
	 * ��ת��pk-ts��map���ͣ�Ȼ�����service�ӿڣ�����ת����ĺϲ����顣
	 * @throws BusinessException 
	 */
	private AggTestmdMasterVO[] transferVos(TransferBTRecord[]  bTRecords) throws BusinessException{
		List<AggTestmdMasterVO> ret =new ArrayList<>();
		ITestmdMasterVOService service = ServiceLocator.find(ITestmdMasterVOService.class);
		
		for(TransferBTRecord  bTRecord:bTRecords) {
			if(bTRecord==null||bTRecord.getRecords()==null) {
				continue;
			}
			List<TransferRecord> recordList= new ArrayList<>();
			//�������ӱ����кϲ�
			Arrays.stream(bTRecord.getRecords()).forEach(item->{
				recordList.add(item);
				if(item.getChildren()!=null) {
					recordList.addAll(Arrays.asList(item.getChildren()));
				}
			});
			Map<String,String> pkTsMap = recordList.stream().collect(Collectors.toMap(TransferRecord::getPk, TransferRecord::getTs,(k1,k2)->k1));
			AggTestmdMasterVO[] vos=null;
			switch(bTRecord.getBillType()){
			case "10KH":
				vos = service.tranfer10KHToAggTestmdMasterVO(pkTsMap);
				break;
			}
			if(vos==null ||vos.length==0) {
				continue;
			}
			ret.addAll(Arrays.asList(vos));
		}
		
		return ret.toArray(new AggTestmdMasterVO[0]);
	}
	/**
	* ����vo��statusΪNEW
	*/
	private void setVoStatus(AggTestmdMasterVO[] vos){
		if(vos==null||vos.length==0){
			return ;
		}
		Arrays.stream(vos).forEach(aggvo->{
			aggvo.getParentVO().setStatus(VOStatus.NEW);
			if(aggvo instanceof AbstractBill) {
				IBillMeta billMeta = aggvo.getMetaData();
				if(billMeta==null||billMeta.getChildren()==null) {
					return ;
				}
				Arrays.stream(billMeta.getChildren()).filter(meta->aggvo.getChildren(meta)!=null).forEach(meta->{
					Arrays.stream(aggvo.getChildren(meta)).filter(child->child!=null).forEach(child-> child.setStatus(VOStatus.NEW));
				});
			}else {
				CircularlyAccessibleValueObject[] childrenVO = aggvo.getChildrenVO();
				if(childrenVO==null) {
					return ;
				}
				Arrays.stream(childrenVO).filter(child->child!=null).forEach(child-> child.setStatus(VOStatus.NEW));
			}
		});
	}
	
}