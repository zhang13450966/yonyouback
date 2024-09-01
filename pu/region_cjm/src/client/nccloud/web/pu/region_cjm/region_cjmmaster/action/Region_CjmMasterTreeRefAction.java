
package nccloud.web.pu.region_cjm.region_cjmmaster.action;

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
public class Region_CjmMasterTreeRefAction extends DefaultTreeRefAction {
	
	public Region_CjmMasterTreeRefAction() {
		super();
		setResourceCode(IOrgResourceCodeConst.ORG);
	}

	@Override
	public TreeRefMeta getRefMeta(RefQueryInfo refQueryInfo) {
		TreeRefMeta refMeta = new TreeRefMeta();
		setResourceCode(IOrgResourceCodeConst.ORG);
		refMeta.setCodeField("code");
		refMeta.setNameField("name");
		refMeta.setPkField("pk_region_cjmmaster");
		refMeta.setPidField("pid");
		refMeta.setTableName("pu_region_cjmmaster");
		refMeta.setMutilLangNameRef(true);
		return refMeta;
	}

}
