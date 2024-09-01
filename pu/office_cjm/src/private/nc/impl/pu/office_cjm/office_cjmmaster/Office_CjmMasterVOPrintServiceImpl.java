
package nc.impl.pu.office_cjm.office_cjmmaster;

import nc.ui.pub.print.IDataSource;
import nccloud.pubitf.platform.print.AbstractPrintService;
import nccloud.pubitf.platform.print.IPrintInfo;
import nccloud.pubitf.platform.print.vo.PrintInfo;

public class Office_CjmMasterVOPrintServiceImpl extends AbstractPrintService {
	
	@Override
    public IDataSource[] getDataSources(IPrintInfo info) {
        PrintInfo printinfo = (PrintInfo) info;
        String[] ids = printinfo.getIds();
        Office_CjmMasterVOPrintDataSource ds = new Office_CjmMasterVOPrintDataSource(ids);
       	return new IDataSource[] { ds };
       
    }
}