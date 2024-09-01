
package nccloud.web.pu.region_cjm.region_cjmmaster.action;

import java.util.Map;
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
public class Region_CjmMasterDefaultGridRefAction extends DefaultGridRefAction {
	
	public Region_CjmMasterDefaultGridRefAction() {
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
	@Override
	public String getExtraSql(RefQueryInfo refQueryInfo, RefMeta refMeta) {
		Map<String,String> conmap = refQueryInfo.getQueryCondition();
		String pid = conmap.get("pid");
		return " and pid='" + pid + "'";
	}
}
