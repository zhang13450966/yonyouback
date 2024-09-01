package nccloud.web.uapbd.testmd.testmdmaster.action;

import nccloud.web.platform.print.AbstractPrintAction;

public class PrintTestmdMasterVOAction extends AbstractPrintAction{

	@Override
	public String getPrintServiceModule() {
		return "uapbd";
	}
	
	@Override
	public String getPrintServiceName() {
		return "nc.impl.uapbd.testmd.testmdmaster.AggTestmdMasterVOPrintServiceImpl";
	}
}