package nc.impl.pu.office_cjm.office_cjmmaster;

import nc.ui.bd.ref.AbstractRefModel;
import nc.vo.pfxx.exception.PfxxException;
import nccloud.bs.excel.ITranslateContext;
import nccloud.bs.excel.bdtranslate.AbstractRefTranslator;
 
/**
 * 
 * 导入导出自定义翻译类
 */
public class Office_CjmMasterVOTranslator extends AbstractRefTranslator {

	@Override
	public String translateExToNC(String srcValue, String metaDataID, ITranslateContext translateContext)
			throws PfxxException {
		return null;
	}

	@Override
	protected void processRefModel(AbstractRefModel refmodel, ITranslateContext translateContext) {
		return;
	}

}
