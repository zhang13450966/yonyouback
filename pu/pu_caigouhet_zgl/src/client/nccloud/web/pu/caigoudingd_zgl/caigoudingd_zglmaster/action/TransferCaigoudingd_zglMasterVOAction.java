package nccloud.web.pu.caigoudingd_zgl.caigoudingd_zglmaster.action;

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
import nc.vo.caigoudingdan.caigoudingd_zgl.AggCaigoudingd_zglMasterVO;
import nc.itf.pu.caigoudingd_zgl.caigoudingd_zglmaster.ICaigoudingd_zglMasterVOService;



/**
 * 
 * @description 拉单-单据转换处理action
 * @version ncc1.0
 */
public class TransferCaigoudingd_zglMasterVOAction extends BaseAction{

	@Override
	public Object doAction(IRequest request, RequstParamWapper paramWapper)throws BusinessException {
		TransferDTO param = VOTransform.toVO(paramWapper.requestString,TransferDTO.class);
		
		if(param==null||param.getData()==null||param.getData().length==0){
			return null;
		}
		
		ResultWapper res = null;
		VOTransform tf = new VOTransform(null, param.getPageCode());
		
		AggCaigoudingd_zglMasterVO[] vos = this.transferVos(param.getData());
		setVoStatus(vos);
		res = tf.toList(vos,param.getFormId(),param.getFormListIds(),null);

		Map<String,Object> externalData = new HashMap<>();
		ICaigoudingd_zglMasterVOService service = ServiceLocator.find(ICaigoudingd_zglMasterVOService.class);
		BillCodeContext context = service.getBillCodeContext("caigoudingd_zgl");
		externalData.put("billCodeContext",context);
		res.setExternalData(externalData);
		
		return res;
	}
	/**
	 * 调用接口单据转换，TransferBTRecord::billType为对应单据类型，TransferBTRecord::records为选择的记录。
	 * 先转成pk-ts的map类型，然后调用service接口，返回转换后的合并数组。
	 * @throws BusinessException 
	 */
	private AggCaigoudingd_zglMasterVO[] transferVos(TransferBTRecord[]  bTRecords) throws BusinessException{
		List<AggCaigoudingd_zglMasterVO> ret =new ArrayList<>();
		ICaigoudingd_zglMasterVOService service = ServiceLocator.find(ICaigoudingd_zglMasterVOService.class);
		
		for(TransferBTRecord  bTRecord:bTRecords) {
			if(bTRecord==null||bTRecord.getRecords()==null) {
				continue;
			}
			List<TransferRecord> recordList= new ArrayList<>();
			//主表、子表进行合并
			Arrays.stream(bTRecord.getRecords()).forEach(item->{
				recordList.add(item);
				if(item.getChildren()!=null) {
					recordList.addAll(Arrays.asList(item.getChildren()));
				}
			});
			Map<String,String> pkTsMap = recordList.stream().collect(Collectors.toMap(TransferRecord::getPk, TransferRecord::getTs,(k1,k2)->k1));
			AggCaigoudingd_zglMasterVO[] vos=null;
			switch(bTRecord.getBillType()){
			case "puzgl":
				vos = service.tranferpuzglToAggCaigoudingd_zglMasterVO(pkTsMap);
				break;
			}
			if(vos==null ||vos.length==0) {
				continue;
			}
			ret.addAll(Arrays.asList(vos));
		}
		
		return ret.toArray(new AggCaigoudingd_zglMasterVO[0]);
	}
	/**
	* 设置vo的status为NEW
	*/
	private void setVoStatus(AggCaigoudingd_zglMasterVO[] vos){
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
