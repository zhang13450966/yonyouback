package nccloud.web.pu.region_cjm.region_cjmmaster.action;

import nccloud.web.platform.print.AbstractPrintAction;

public class PrintRegion_CjmMasterVOAction extends AbstractPrintAction{

	@Override
	public String getPrintServiceModule() {
		return "pu";
	}
	
	@Override
	public String getPrintServiceName() {
		return "nc.impl.pu.region_cjm.region_cjmmaster.Region_CjmMasterVOPrintServiceImpl";
	}
}