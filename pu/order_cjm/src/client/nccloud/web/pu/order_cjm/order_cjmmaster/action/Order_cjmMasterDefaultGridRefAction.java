
package nccloud.web.pu.order_cjm.order_cjmmaster.action;

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
public class Order_cjmMasterDefaultGridRefAction extends DefaultGridRefAction {
	
	public Order_cjmMasterDefaultGridRefAction() {
		super();
		setResourceCode(IOrgResourceCodeConst.ORG);
	}

	@Override
	public RefMeta getRefMeta(RefQueryInfo refQueryInfo) {
		RefMeta refMeta = new RefMeta();		
		setResourceCode(IOrgResourceCodeConst.ORG);
		refMeta.setCodeField("code");
		refMeta.setNameField("");
		
		refMeta.setPkField("pk_order_cjmmaster");
		refMeta.setTableName("pu_order_cjmmaster");
		refMeta.setMutilLangNameRef(true);
		return refMeta;
	}

}
