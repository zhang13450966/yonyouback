package nccloud.web.pu.pu_caigouhet_zgl.pu_caigouhet_zglmaster.action;

import nccloud.web.platform.print.AbstractPrintAction;

public class PrintPu_caigouhet_zglMasterVOAction extends AbstractPrintAction{

	@Override
	public String getPrintServiceModule() {
		return "pu";
	}
	
	@Override
	public String getPrintServiceName() {
		return "nc.impl.pu.pu_caigouhet_zgl.pu_caigouhet_zglmaster.AggPu_caigouhet_zglMasterVOPrintServiceImpl";
	}
}