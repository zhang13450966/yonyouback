
package nc.impl.pu.region_cjm.region_cjmmaster;

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
import nc.vo.pu.region_cjm.Region_CjmMasterVO;
import nc.itf.pu.region_cjm.region_cjmmaster.IRegion_CjmMasterVOService;

public class Region_CjmMasterVOImportProcess extends AbstractImportProceeWithContext {
	
	@Override
	protected void processBillWithContext(Object vo, IXChangeContext changcontext) throws BusinessException {
		Region_CjmMasterVO targetVO = (Region_CjmMasterVO)vo;
		targetVO.setStatus(VOStatus.NEW);

  		getService().initDefaultData(targetVO);
		getService().saveRegion_CjmMasterVO(targetVO);
	}
	
	private IRegion_CjmMasterVOService getService() {
		return NCLocator.getInstance().lookup(IRegion_CjmMasterVOService.class);
	}

}
