
package nccloud.web.uapbd.testmd.testmdmaster.action;

import nc.itf.org.IOrgResourceCodeConst;
import nccloud.framework.web.processor.refgrid.RefQueryInfo;
import nccloud.framework.web.ui.meta.RefMeta;
import nccloud.web.refer.DefaultGridRefAction;

/**
 * 
 * 默认表格参照
 * 
 * @author zx
 * 
 */
public class TestmdMasterDefaultGridRefAction extends DefaultGridRefAction {
	
	public TestmdMasterDefaultGridRefAction() {
		super();
		setResourceCode(IOrgResourceCodeConst.ORG);
	}

	@Override
	public RefMeta getRefMeta(RefQueryInfo refQueryInfo) {
		RefMeta refMeta = new RefMeta();		
		setResourceCode(IOrgResourceCodeConst.ORG);
		refMeta.setCodeField("code");
		refMeta.setNameField("name");
		
		refMeta.setPkField("pk_testmdmaster");
		refMeta.setTableName("uapbd_testmdmaster");
		refMeta.setMutilLangNameRef(true);
		return refMeta;
	}

}
