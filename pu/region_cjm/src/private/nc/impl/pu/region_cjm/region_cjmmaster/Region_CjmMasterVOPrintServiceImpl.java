
package nc.impl.pu.region_cjm.region_cjmmaster;

import nc.ui.pub.print.IDataSource;
import nccloud.pubitf.platform.print.AbstractPrintService;
import nccloud.pubitf.platform.print.IPrintInfo;
import nccloud.pubitf.platform.print.vo.PrintInfo;

public class Region_CjmMasterVOPrintServiceImpl extends AbstractPrintService {
	
	@Override
    public IDataSource[] getDataSources(IPrintInfo info) {
        PrintInfo printinfo = (PrintInfo) info;
        String[] ids = printinfo.getIds();
        Region_CjmMasterVOPrintDataSource ds = new Region_CjmMasterVOPrintDataSource(ids);
       	return new IDataSource[] { ds };
       
    }
}