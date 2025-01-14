
package nc.impl.uapbd.testmd.testmdmaster;

import java.io.File;
import java.util.List;
import java.util.Map;

import nc.bs.framework.common.NCLocator;
import nc.md.MDBaseQueryFacade;
import nc.md.model.IBusinessEntity;
import nc.md.model.MetaDataException;
import nc.ui.bd.ref.AbstractRefModel;
import nc.vo.platform.appsystemplate.AreaVO;
import nc.vo.platform.appsystemplate.FormPropertyVO;
import nc.vo.pub.BusinessException;
import nc.vo.pub.ExtendedAggregatedValueObject;
import nccloud.bs.excel.process.AbstractExcelOutputProcessor;
import nccloud.itf.trade.excelexport.convertor.IRefPropertyProcess;
import nccloud.itf.trade.excelimport.ExportDataInfo;
import nccloud.ui.trade.excelimport.InputItem;
import nccloud.vo.excel.scheme.BillDefination;
import nc.vo.testmd.testmd.AggTestmdMasterVO;
import nc.itf.uapbd.testmd.testmdmaster.ITestmdMasterVOService;
/*
 *	导出
 */
public class AggTestmdMasterVOExcelOutputProcessor extends AbstractExcelOutputProcessor {

	@Override
	public File writeExportData(String filename, Object[] values, List<InputItem> inputitems,
			BillDefination billDefination) throws Exception {
		return super.writeExportData(filename, values, inputitems, billDefination);
	}

	@Override
	public File writeExportData(String filename, Object[] values, List<InputItem> inputitems,
			BillDefination billDefination, boolean isExportByTemp, Map<String, AreaVO> areamap) throws Exception {
		return super.writeExportData(filename, values, inputitems, billDefination, isExportByTemp, areamap);
	}

	@Override
	public Object[] getObjectValueByPks(String[] pks) throws BusinessException {
		// 要改成调用接口根据前端传过来的pks参数查询对应VO返回
		AggTestmdMasterVO[] queryResult = getService().listAggTestmdMasterVOByPk(pks);
		if (queryResult == null || queryResult.length <= 0) {
			return null;
		}
		return queryResult;
	}

	@Override
	protected ExportDataInfo getValue(Object[] vos, List<InputItem> exportItems, BillDefination billdefination)
			throws BusinessException {
			ExtendedAggregatedValueObject[] aggvos = getConvertorForTemp(new DefRefPropertyProcess())
				.convertDataFromEditorData(billdefination, vos, exportItems);
			return new ExportDataInfo(aggvos);
	}

	@Override
	public void setAreamap(Map<String, AreaVO> areamap) {
		super.setAreamap(areamap);
	}

	private ITestmdMasterVOService getService() {
		return NCLocator.getInstance().lookup(ITestmdMasterVOService.class);
	}
	
	class DefRefPropertyProcess implements IRefPropertyProcess{

		@Override
		public void ProcessRefProperty(AbstractRefModel refmodel) {
			refmodel.setSealedDataShow(true);
		}

		@Override
		public AbstractRefModel getRefModelByProperty(FormPropertyVO property) {
			String classid = property.getClassid();
			String pid = null;
			try {
				IBusinessEntity entity = (IBusinessEntity)MDBaseQueryFacade.getInstance().getBeanByID(classid);
				pid = entity.getBizInterfaceMapInfo("nc.vo.bd.meta.IBDObject") == null ? null : entity.getBizInterfaceMapInfo("nc.vo.bd.meta.IBDObject").get("pid");
			} catch (MetaDataException e) {
				throw new RuntimeException(e);
			}
			// 1、判断是否有树形上级参照自身字段
			if("c20d2227-2ecd-44d8-bc4f-f5fcafe82248".equals(classid) && pid != null && pid.equals(property.getCode())) {
				DefAbstractRefModel refModel = new DefAbstractRefModel(property);
				return refModel;
			}
			return null;
		}}


	class DefAbstractRefModel extends AbstractRefModel{
		FormPropertyVO property;

		String tablename;
		String pkcolname;
		String pkattrname;
		String codename;
		String namename;

		public DefAbstractRefModel(FormPropertyVO property) {
			super();
			this.property = property;
			String classid = property.getClassid();
			IBusinessEntity entity;
			Map<String, String> bizInterfaceMapInfo;
			try {
				entity = (IBusinessEntity)MDBaseQueryFacade.getInstance().getBeanByID(classid);
				bizInterfaceMapInfo = entity.getBizInterfaceMapInfo("nc.vo.bd.meta.IBDObject");
			} catch (MetaDataException e) {
				throw new RuntimeException(e);
			}
			tablename = entity.getTable().getName();
			pkcolname = entity.getKeyAttribute().getColumn().getName();
			pkattrname = entity.getKeyAttribute().getName();
			codename = bizInterfaceMapInfo.get("code");
			namename = bizInterfaceMapInfo.get("name");
			this.reset();
		}


		@Override
		public void reset() {
			this.setFieldCode(new String[] {codename});
			this.setFieldName(new String[] {namename});
			this.setTableName(this.tablename);
			this.setPkFieldCode(this.pkattrname);
			this.setRefCodeField(codename);
			this.setRefNameField(namename);
			this.resetFieldName();
		}

		@Override
		public String[] getFieldCode() {
			return new String[] {pkcolname, codename, namename};
		}

		@Override
		public String[] getFieldName() {
			return new String[] {pkcolname, codename, namename};
		}

		@Override
		public String getWherePart() {
			return " 1 = 1 ";
		}
	}


}
