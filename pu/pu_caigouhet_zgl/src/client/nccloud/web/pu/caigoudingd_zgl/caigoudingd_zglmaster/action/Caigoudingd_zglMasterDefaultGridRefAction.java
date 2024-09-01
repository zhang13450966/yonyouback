
package nccloud.web.pu.caigoudingd_zgl.caigoudingd_zglmaster.action;

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
public class Caigoudingd_zglMasterDefaultGridRefAction extends DefaultGridRefAction {
	
	public Caigoudingd_zglMasterDefaultGridRefAction() {
		super();
		setResourceCode(IOrgResourceCodeConst.ORG);
	}

	@Override
	public RefMeta getRefMeta(RefQueryInfo refQueryInfo) {
		RefMeta refMeta = new RefMeta();		
		setResourceCode(IOrgResourceCodeConst.ORG);
		refMeta.setCodeField("code");
		refMeta.setNameField("");
		
		refMeta.setPkField("pk_cgdingdan_zglmaster");
		refMeta.setTableName("pu_caigoudingd_zglmaster");
		refMeta.setMutilLangNameRef(true);
		return refMeta;
	}

}
