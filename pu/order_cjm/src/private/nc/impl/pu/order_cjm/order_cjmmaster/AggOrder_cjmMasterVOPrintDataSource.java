
package nc.impl.pu.order_cjm.order_cjmmaster;

import nc.bs.framework.common.NCLocator;
import nc.md.model.MetaDataException;
import nc.md.persist.framework.IMDPersistenceQueryService;
import nc.ui.pub.print.IMetaDataDataSource;
import nccloud.framework.core.exception.ExceptionUtils;
import nc.vo.pu.order_cjm.AggOrder_cjmMasterVO;

public class AggOrder_cjmMasterVOPrintDataSource implements IMetaDataDataSource {

	private static final long serialVersionUID = 1L;

	private String[] oids;

	public AggOrder_cjmMasterVOPrintDataSource(String[] oids) {
		this.oids = oids;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object[] getMDObjects() {
		IMDPersistenceQueryService bs = NCLocator.getInstance().lookup(IMDPersistenceQueryService.class);
		AggOrder_cjmMasterVO[] aggvos = new AggOrder_cjmMasterVO[] {};
		try {
			aggvos = (AggOrder_cjmMasterVO[]) bs.queryBillOfVOByPKs(AggOrder_cjmMasterVO.class, this.oids, false).toArray(new AggOrder_cjmMasterVO[0]);
		} catch (MetaDataException e) {
			ExceptionUtils.wrapException(e);
		}
		return aggvos;
	}

	@Override
	public String[] getItemValuesByExpress(String itemExpress) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isNumber(String itemExpress) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String[] getDependentItemExpressByExpress(String itemExpress) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getAllDataItemExpress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getAllDataItemNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return null;
	}

}
