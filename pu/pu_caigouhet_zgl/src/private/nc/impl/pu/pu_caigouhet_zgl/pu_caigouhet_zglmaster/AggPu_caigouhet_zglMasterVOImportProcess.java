
package nc.impl.pu.pu_caigouhet_zgl.pu_caigouhet_zglmaster;

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
import nc.vo.pu.pu_caigouhet_zgl.Pu_caigouhet_zglMasterVO;
import nc.vo.pu.pu_caigouhet_zgl.Pu_caigouhet_zglSlave0VO;
import nc.vo.pu.pu_caigouhet_zgl.AggPu_caigouhet_zglMasterVO;
import nc.itf.pu.pu_caigouhet_zgl.pu_caigouhet_zglmaster.IPu_caigouhet_zglMasterVOService;

public class AggPu_caigouhet_zglMasterVOImportProcess extends AbstractImportProceeWithContext {
	
	@Override
	protected void processBillWithContext(Object vo, IXChangeContext changcontext) throws BusinessException {
		AggPu_caigouhet_zglMasterVO targetVO = (AggPu_caigouhet_zglMasterVO)vo;
		targetVO.getParentVO().setStatus(VOStatus.NEW);

		Pu_caigouhet_zglSlave0VO[] pu_caigouhet_zglSlave0VOs = (Pu_caigouhet_zglSlave0VO[])targetVO.getChildren(Pu_caigouhet_zglSlave0VO.class);
		if(pu_caigouhet_zglSlave0VOs!=null && pu_caigouhet_zglSlave0VOs.length>0){
			Arrays.stream(pu_caigouhet_zglSlave0VOs).forEach(subvo->{
				subvo.setStatus(VOStatus.NEW);
			});
		}
  		getService().initDefaultData(targetVO.getParentVO());
		getService().saveAggPu_caigouhet_zglMasterVO(targetVO);
	}
	
	private IPu_caigouhet_zglMasterVOService getService() {
		return NCLocator.getInstance().lookup(IPu_caigouhet_zglMasterVOService.class);
	}

}
