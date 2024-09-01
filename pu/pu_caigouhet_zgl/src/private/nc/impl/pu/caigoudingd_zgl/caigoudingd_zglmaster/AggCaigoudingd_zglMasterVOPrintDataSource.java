
package nc.impl.pu.caigoudingd_zgl.caigoudingd_zglmaster;

import nc.bs.framework.common.NCLocator;
import nc.md.model.MetaDataException;
import nc.md.persist.framework.IMDPersistenceQueryService;
import nc.ui.pub.print.IMetaDataDataSource;
import nccloud.framework.core.exception.ExceptionUtils;
import nc.vo.caigoudingdan.caigoudingd_zgl.AggCaigoudingd_zglMasterVO;

public class AggCaigoudingd_zglMasterVOPrintDataSource implements IMetaDataDataSource {

	private static final long serialVersionUID = 1L;

	private String[] oids;

	public AggCaigoudingd_zglMasterVOPrintDataSource(String[] oids) {
		this.oids = oids;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object[] getMDObjects() {
		IMDPersistenceQueryService bs = NCLocator.getInstance().lookup(IMDPersistenceQueryService.class);
		AggCaigoudingd_zglMasterVO[] aggvos = new AggCaigoudingd_zglMasterVO[] {};
		try {
			aggvos = (AggCaigoudingd_zglMasterVO[]) bs.queryBillOfVOByPKs(AggCaigoudingd_zglMasterVO.class, this.oids, false).toArray(new AggCaigoudingd_zglMasterVO[0]);
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
