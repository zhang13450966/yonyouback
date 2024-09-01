package nccloud.web.pu.office_cjm.office_cjmmaster.action;

import nccloud.web.platform.print.AbstractPrintAction;

public class PrintOffice_CjmMasterVOAction extends AbstractPrintAction{

	@Override
	public String getPrintServiceModule() {
		return "pu";
	}
	
	@Override
	public String getPrintServiceName() {
		return "nc.impl.pu.office_cjm.office_cjmmaster.Office_CjmMasterVOPrintServiceImpl";
	}
}