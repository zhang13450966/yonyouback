package nccloud.web.pu.caigoudingd_zgl.caigoudingd_zglmaster.action;

import nccloud.web.platform.print.AbstractPrintAction;

public class PrintCaigoudingd_zglMasterVOAction extends AbstractPrintAction{

	@Override
	public String getPrintServiceModule() {
		return "pu";
	}
	
	@Override
	public String getPrintServiceName() {
		return "nc.impl.pu.caigoudingd_zgl.caigoudingd_zglmaster.AggCaigoudingd_zglMasterVOPrintServiceImpl";
	}
}