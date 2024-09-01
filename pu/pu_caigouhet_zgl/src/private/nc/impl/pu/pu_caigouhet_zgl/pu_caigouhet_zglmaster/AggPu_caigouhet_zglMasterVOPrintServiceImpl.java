
package nc.impl.pu.pu_caigouhet_zgl.pu_caigouhet_zglmaster;

import nc.ui.pub.print.IDataSource;
import nccloud.pubitf.platform.print.AbstractPrintService;
import nccloud.pubitf.platform.print.IPrintInfo;
import nccloud.pubitf.platform.print.vo.PrintInfo;

public class AggPu_caigouhet_zglMasterVOPrintServiceImpl extends AbstractPrintService {
	
	@Override
    public IDataSource[] getDataSources(IPrintInfo info) {
        PrintInfo printinfo = (PrintInfo) info;
        String[] ids = printinfo.getIds();
        AggPu_caigouhet_zglMasterVOPrintDataSource ds = new AggPu_caigouhet_zglMasterVOPrintDataSource(ids);
       	return new IDataSource[] { ds };
       
    }
}