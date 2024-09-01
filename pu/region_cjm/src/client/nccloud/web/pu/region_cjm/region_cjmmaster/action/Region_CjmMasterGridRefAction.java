
package nccloud.web.pu.region_cjm.region_cjmmaster.action;

import nc.itf.org.IOrgResourceCodeConst;
import nccloud.framework.web.processor.refgrid.RefQueryInfo;
import nccloud.framework.web.ui.meta.RefMeta;
import nccloud.web.refer.DefaultGridRefAction;

/**
 * 
 * 档案特性生成默认参照
 * 
 * @author zhaoxwf
 * 
 */
public class Region_CjmMasterGridRefAction extends DefaultGridRefAction {
	
	public Region_CjmMasterGridRefAction() {
		super();
		setResourceCode(IOrgResourceCodeConst.ORG);
	}

	@Override
	public RefMeta getRefMeta(RefQueryInfo refQueryInfo) {
		RefMeta refMeta = new RefMeta();		
		setResourceCode(IOrgResourceCodeConst.ORG);
		refMeta.setCodeField("code");
		refMeta.setNameField("name");
		refMeta.setPkField("pk_region_cjmmaster");
		refMeta.setTableName("pu_region_cjmmaster");
		refMeta.setMutilLangNameRef(true);
		return refMeta;
	}

}
