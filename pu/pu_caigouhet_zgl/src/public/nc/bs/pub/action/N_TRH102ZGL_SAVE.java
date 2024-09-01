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

public class N_TRH102ZGL_SAVE extends AbstractPfScriptAction<AggCaigoudingd_zglMasterVO>{
	
	public N_TRH102ZGL_SAVE(){
		super();
	}
	
	@Override
	protected Object process(PfParameterVO paraVO) throws BusinessException {
		try {
			ICaigoudingd_zglMasterVOService service = NCLocator.getInstance().lookup(ICaigoudingd_zglMasterVOService.class);
			AggCaigoudingd_zglMasterVO[] vos = (AggCaigoudingd_zglMasterVO[])this.getVos();
			Arrays.stream(vos).forEach(v-> v.getParent().setStatus(VOStatus.UPDATED));
			
			
			vos = service.callbackSAVE(vos);
			
			return vos;
		}catch(Exception ex) {
			if (ex instanceof BusinessException) {
		        throw (BusinessException) ex;
		      }
	        throw new PFBusinessException(ex.getMessage(), ex);
		}
	}
	
	protected void before(PfParameterVO paraVO)  throws BusinessException{
		AggCaigoudingd_zglMasterVO vo = (AggCaigoudingd_zglMasterVO)this.getVo();
		if(StringUtils.isEmpty(vo.getPrimaryKey())){
			throw new BusinessException("当前单据未执行保存动作脚本，如果配置了业务流程定义，请检查动作驱动配置！");
		}
	}
}