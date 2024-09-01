
package nc.impl.pu.caigoudingd_zgl.caigoudingd_zglmaster;

import nc.ui.pub.print.IDataSource;
import nccloud.pubitf.platform.print.AbstractPrintService;
import nccloud.pubitf.platform.print.IPrintInfo;
import nccloud.pubitf.platform.print.vo.PrintInfo;

public class AggCaigoudingd_zglMasterVOPrintServiceImpl extends AbstractPrintService {
	
	@Override
    public IDataSource[] getDataSources(IPrintInfo info) {
        PrintInfo printinfo = (PrintInfo) info;
        String[] ids = printinfo.getIds();
        AggCaigoudingd_zglMasterVOPrintDataSource ds = new AggCaigoudingd_zglMasterVOPrintDataSource(ids);
       	return new IDataSource[] { ds };
       
    }
}