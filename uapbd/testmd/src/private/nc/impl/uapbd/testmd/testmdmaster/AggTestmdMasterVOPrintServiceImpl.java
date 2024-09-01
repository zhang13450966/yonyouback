
package nc.impl.uapbd.testmd.testmdmaster;

import nc.ui.pub.print.IDataSource;
import nccloud.pubitf.platform.print.AbstractPrintService;
import nccloud.pubitf.platform.print.IPrintInfo;
import nccloud.pubitf.platform.print.vo.PrintInfo;

public class AggTestmdMasterVOPrintServiceImpl extends AbstractPrintService {
	
	@Override
    public IDataSource[] getDataSources(IPrintInfo info) {
        PrintInfo printinfo = (PrintInfo) info;
        String[] ids = printinfo.getIds();
        AggTestmdMasterVOPrintDataSource ds = new AggTestmdMasterVOPrintDataSource(ids);
       	return new IDataSource[] { ds };
       
    }
}