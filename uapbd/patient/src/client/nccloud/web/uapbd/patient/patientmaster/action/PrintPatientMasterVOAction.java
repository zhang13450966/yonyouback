package nccloud.web.uapbd.patient.patientmaster.action;

import nccloud.web.platform.print.AbstractPrintAction;

public class PrintPatientMasterVOAction extends AbstractPrintAction{

	@Override
	public String getPrintServiceModule() {
		return "uapbd";
	}
	
	@Override
	public String getPrintServiceName() {
		return "nc.impl.uapbd.patient.patientmaster.AggPatientMasterVOPrintServiceImpl";
	}
}