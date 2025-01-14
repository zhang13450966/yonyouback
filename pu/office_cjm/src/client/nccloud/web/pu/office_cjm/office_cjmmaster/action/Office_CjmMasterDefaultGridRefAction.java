
package nccloud.web.pu.office_cjm.office_cjmmaster.action;

import nc.itf.org.IOrgResourceCodeConst;
import nccloud.framework.web.processor.refgrid.RefQueryInfo;
import nccloud.framework.web.ui.meta.RefMeta;
import nccloud.web.refer.DefaultGridRefAction;

/**
 * 
 * Ĭ�ϱ������
 * 
 * @author zx
 * 
 */
public class Office_CjmMasterDefaultGridRefAction extends DefaultGridRefAction {
	
	public Office_CjmMasterDefaultGridRefAction() {
		super();
		setResourceCode(IOrgResourceCodeConst.ORG);
	}

	@Override
	public RefMeta getRefMeta(RefQueryInfo refQueryInfo) {
		RefMeta refMeta = new RefMeta();		
		setResourceCode(IOrgResourceCodeConst.ORG);
		refMeta.setCodeField("code");
		refMeta.setNameField("name");
		
		refMeta.setPkField("pk_office_cjmmaster");
		refMeta.setTableName("pu_office_cjmmaster");
		refMeta.setMutilLangNameRef(true);
		return refMeta;
	}

}
