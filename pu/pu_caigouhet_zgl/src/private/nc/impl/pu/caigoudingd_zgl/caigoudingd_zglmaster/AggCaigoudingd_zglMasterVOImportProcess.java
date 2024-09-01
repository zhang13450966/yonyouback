
package nc.impl.pu.caigoudingd_zgl.caigoudingd_zglmaster;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

import nc.bs.framework.common.NCLocator;
import nc.vo.pub.BusinessException;
import nc.vo.pub.CircularlyAccessibleValueObject;
import nc.vo.pub.SuperVO;
import nc.vo.pub.ISuperVO;
import nc.vo.pub.IVOMeta;
import nc.vo.pub.VOStatus;
import nc.vo.pubapp.pattern.model.meta.entity.bill.IBillMeta;
import nc.vo.trade.pub.HYBillVO;
import nc.vo.pubapp.pattern.model.entity.bill.AbstractBill;
import nccloud.bs.excel.IXChangeContext;
import nccloud.bs.excel.plugin.AbstractImportProceeWithContext;
import nc.vo.caigoudingdan.caigoudingd_zgl.Caigoudingd_zglMasterVO;
import nc.vo.caigoudingdan.caigoudingd_zgl.Caigoudingd_zglSlave0VO;
import nc.vo.caigoudingdan.caigoudingd_zgl.AggCaigoudingd_zglMasterVO;
import nc.itf.pu.caigoudingd_zgl.caigoudingd_zglmaster.ICaigoudingd_zglMasterVOService;

public class AggCaigoudingd_zglMasterVOImportProcess extends AbstractImportProceeWithContext {
	
	@Override
	protected void processBillWithContext(Object vo, IXChangeContext changcontext) throws BusinessException {
		AggCaigoudingd_zglMasterVO targetVO = (AggCaigoudingd_zglMasterVO)vo;
		targetVO.getParentVO().setStatus(VOStatus.NEW);

		Caigoudingd_zglSlave0VO[] caigoudingd_zglSlave0VOs = (Caigoudingd_zglSlave0VO[])targetVO.getChildren(Caigoudingd_zglSlave0VO.class);
		if(caigoudingd_zglSlave0VOs!=null && caigoudingd_zglSlave0VOs.length>0){
			Arrays.stream(caigoudingd_zglSlave0VOs).forEach(subvo->{
				subvo.setStatus(VOStatus.NEW);
			});
		}
  		getService().initDefaultData(targetVO.getParentVO());
		getService().saveAggCaigoudingd_zglMasterVO(targetVO);
	}
	
	private ICaigoudingd_zglMasterVOService getService() {
		return NCLocator.getInstance().lookup(ICaigoudingd_zglMasterVOService.class);
	}

}
