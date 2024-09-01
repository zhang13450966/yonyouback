package nccloud.web.pu.order_cjm.order_cjmmaster.action;

import nccloud.web.platform.print.AbstractPrintAction;

public class PrintOrder_cjmMasterVOAction extends AbstractPrintAction{

	@Override
	public String getPrintServiceModule() {
		return "pu";
	}
	
	@Override
	public String getPrintServiceName() {
		return "nc.impl.pu.order_cjm.order_cjmmaster.AggOrder_cjmMasterVOPrintServiceImpl";
	}
}