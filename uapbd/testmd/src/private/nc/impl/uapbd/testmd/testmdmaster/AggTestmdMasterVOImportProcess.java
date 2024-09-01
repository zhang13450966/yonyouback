
package nc.impl.uapbd.testmd.testmdmaster;

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
import nc.vo.testmd.testmd.TestmdSlave0VO;
import nc.vo.testmd.testmd.TestmdMasterVO;
import nc.vo.testmd.testmd.AggTestmdMasterVO;
import nc.itf.uapbd.testmd.testmdmaster.ITestmdMasterVOService;

public class AggTestmdMasterVOImportProcess extends AbstractImportProceeWithContext {
	
	@Override
	protected void processBillWithContext(Object vo, IXChangeContext changcontext) throws BusinessException {
		AggTestmdMasterVO targetVO = (AggTestmdMasterVO)vo;
		targetVO.getParentVO().setStatus(VOStatus.NEW);

		TestmdSlave0VO[] testmdSlave0VOs = (TestmdSlave0VO[])targetVO.getChildren(TestmdSlave0VO.class);
		if(testmdSlave0VOs!=null && testmdSlave0VOs.length>0){
			Arrays.stream(testmdSlave0VOs).forEach(subvo->{
				subvo.setStatus(VOStatus.NEW);
			});
		}
  		getService().initDefaultData(targetVO.getParentVO());
		getService().saveAggTestmdMasterVO(targetVO);
	}
	
	private ITestmdMasterVOService getService() {
		return NCLocator.getInstance().lookup(ITestmdMasterVOService.class);
	}

}
