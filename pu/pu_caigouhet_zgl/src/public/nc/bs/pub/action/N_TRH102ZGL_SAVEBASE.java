package nc.bs.pub.action;

import java.util.Arrays;

import nc.bs.framework.common.NCLocator;
import nc.bs.pub.compiler.IWorkFlowRet;
import nc.vo.pub.BusinessException;
import nc.vo.pub.compiler.PfParameterVO;
import nc.vo.pub.VOStatus;
import nc.vo.uap.pf.PFBusinessException;
import nc.vo.pubapp.pattern.model.entity.bill.AbstractBill;
import nc.vo.pubapp.pattern.model.meta.entity.bill.IBillMeta;
import nc.vo.pub.CircularlyAccessibleValueObject;
import nccloud.commons.lang.StringUtils;
import nc.codeplatform.framework.service.AbstractPfScriptAction;
import nc.vo.caigoudingdan.caigoudingd_zgl.AggCaigoudingd_zglMasterVO;
import nc.itf.pu.caigoudingd_zgl.caigoudingd_zglmaster.ICaigoudingd_zglMasterVOService;

public class N_TRH102ZGL_SAVEBASE extends AbstractPfScriptAction<AggCaigoudingd_zglMasterVO>{
	
	public N_TRH102ZGL_SAVEBASE(){
		super();
	}
	
	@Override
	protected Object process(PfParameterVO paraVO) throws BusinessException {
		try {
			ICaigoudingd_zglMasterVOService service = NCLocator.getInstance().lookup(ICaigoudingd_zglMasterVOService.class);
			AggCaigoudingd_zglMasterVO[] vos = (AggCaigoudingd_zglMasterVO[])this.getVos();
			setVoStatus(vos);
			
			
			vos = service.callbackSAVEBASE(vos);
			
			return vos;
		}catch(Exception ex) {
			if (ex instanceof BusinessException) {
		        throw (BusinessException) ex;
		      }
	        throw new PFBusinessException(ex.getMessage(), ex);
		}
	}
	
	/**
	* ����vo��statusΪNEW������δ����vostatusʱ���±��治�ϡ�
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