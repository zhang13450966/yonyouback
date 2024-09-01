
package nc.impl.pu.order_cjm.order_cjmmaster;

import nc.ui.pub.print.IDataSource;
import nccloud.pubitf.platform.print.AbstractPrintService;
import nccloud.pubitf.platform.print.IPrintInfo;
import nccloud.pubitf.platform.print.vo.PrintInfo;

public class AggOrder_cjmMasterVOPrintServiceImpl extends AbstractPrintService {
	
	@Override
    public IDataSource[] getDataSources(IPrintInfo info) {
        PrintInfo printinfo = (PrintInfo) info;
        String[] ids = printinfo.getIds();
        AggOrder_cjmMasterVOPrintDataSource ds = new AggOrder_cjmMasterVOPrintDataSource(ids);
       	return new IDataSource[] { ds };
       
    }
}