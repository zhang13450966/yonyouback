
package nc.impl.pu.pu_caigouhet_zgl.pu_caigouhet_zglmaster;

import nc.bs.framework.common.NCLocator;
import nc.md.model.MetaDataException;
import nc.md.persist.framework.IMDPersistenceQueryService;
import nc.ui.pub.print.IMetaDataDataSource;
import nccloud.framework.core.exception.ExceptionUtils;
import nc.vo.pu.pu_caigouhet_zgl.AggPu_caigouhet_zglMasterVO;

public class AggPu_caigouhet_zglMasterVOPrintDataSource implements IMetaDataDataSource {

	private static final long serialVersionUID = 1L;

	private String[] oids;

	public AggPu_caigouhet_zglMasterVOPrintDataSource(String[] oids) {
		this.oids = oids;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object[] getMDObjects() {
		IMDPersistenceQueryService bs = NCLocator.getInstance().lookup(IMDPersistenceQueryService.class);
		AggPu_caigouhet_zglMasterVO[] aggvos = new AggPu_caigouhet_zglMasterVO[] {};
		try {
			aggvos = (AggPu_caigouhet_zglMasterVO[]) bs.queryBillOfVOByPKs(AggPu_caigouhet_zglMasterVO.class, this.oids, false).toArray(new AggPu_caigouhet_zglMasterVO[0]);
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
