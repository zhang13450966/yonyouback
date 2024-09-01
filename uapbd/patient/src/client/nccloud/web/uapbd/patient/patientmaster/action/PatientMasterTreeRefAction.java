
package nccloud.web.uapbd.patient.patientmaster.action;

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
public class PatientMasterTreeRefAction extends DefaultTreeRefAction {
	
	public PatientMasterTreeRefAction() {
		super();
		setResourceCode(IOrgResourceCodeConst.ORG);
	}

	@Override
	public TreeRefMeta getRefMeta(RefQueryInfo refQueryInfo) {
		TreeRefMeta refMeta = new TreeRefMeta();
		setResourceCode(IOrgResourceCodeConst.ORG);
		refMeta.setCodeField("code");
		refMeta.setNameField("name");
		refMeta.setPkField("pk_patientmaster");
		refMeta.setPidField("");
		refMeta.setTableName("uapbd_patientmaster");
		refMeta.setMutilLangNameRef(true);
		return refMeta;
	}

}
