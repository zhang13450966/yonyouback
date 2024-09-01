
package nccloud.web.uapbd.testmd.testmdmaster.action;

import nc.itf.org.IOrgResourceCodeConst;
import nccloud.framework.web.processor.refgrid.RefQueryInfo;
import nccloud.framework.web.ui.meta.TreeRefMeta;
import nccloud.web.refer.DefaultTreeRefAction;

/**
 * 
 * 档案特性生成默认参照
 * 
 * @author zhaoxwf
 * 
 */
public class TestmdMasterTreeRefAction extends DefaultTreeRefAction {
	
	public TestmdMasterTreeRefAction() {
		super();
		setResourceCode(IOrgResourceCodeConst.ORG);
	}

	@Override
	public TreeRefMeta getRefMeta(RefQueryInfo refQueryInfo) {
		TreeRefMeta refMeta = new TreeRefMeta();
		setResourceCode(IOrgResourceCodeConst.ORG);
		refMeta.setCodeField("code");
		refMeta.setNameField("name");
		refMeta.setPkField("pk_testmdmaster");
		refMeta.setPidField("");
		refMeta.setTableName("uapbd_testmdmaster");
		refMeta.setMutilLangNameRef(true);
		return refMeta;
	}

}
