
package nc.impl.pu.office_cjm.office_cjmmaster;

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
import nc.vo.pu.office_cjm.Office_CjmMasterVO;
import nc.itf.pu.office_cjm.office_cjmmaster.IOffice_CjmMasterVOService;

public class Office_CjmMasterVOImportProcess extends AbstractImportProceeWithContext {
	
	@Override
	protected void processBillWithContext(Object vo, IXChangeContext changcontext) throws BusinessException {
		Office_CjmMasterVO targetVO = (Office_CjmMasterVO)vo;
		targetVO.setStatus(VOStatus.NEW);

  		getService().initDefaultData(targetVO);
		getService().saveOffice_CjmMasterVO(targetVO);
	}
	
	private IOffice_CjmMasterVOService getService() {
		return NCLocator.getInstance().lookup(IOffice_CjmMasterVOService.class);
	}

}
