package nc.impl.pu.order_cjm.order_cjmmaster;

import java.util.Map;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.UUID;
import java.lang.String;
import java.util.stream.Stream;
import nc.vo.pub.lang.UFDateTime;
import nc.uap.utils.InSQLCreator;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.beanutils.PropertyUtils;


import nc.vo.pub.BusinessException;
import nc.vo.pub.BusinessRuntimeException;
import nc.vo.pub.SuperVO;
import nc.vo.pub.VOStatus;
import nc.codeplatform.framework.service.ServiceSupport;

import nc.pub.billcode.vo.BillCodeContext;

import nc.vo.pu.order_cjm.Order_cjmSlave0VO;
import nc.vo.pu.order_cjm.Order_cjmMasterVO;
import nc.vo.pu.order_cjm.AggOrder_cjmMasterVO;
import nc.itf.pu.order_cjm.order_cjmmaster.IOrder_cjmMasterVOService;


import nc.vo.pub.pf.BillStatusEnum;
import nc.bs.framework.common.InvocationInfoProxy;
import nccloud.framework.core.exception.ExceptionUtils;

public class  Order_cjmMasterVOServiceImpl extends ServiceSupport implements IOrder_cjmMasterVOService {


	@Override
	public AggOrder_cjmMasterVO[] listAggOrder_cjmMasterVOByPk(String...pks) throws BusinessException{
		return listAggOrder_cjmMasterVOByPk(false,pks);
	}

	@Override
	public AggOrder_cjmMasterVO[] listAggOrder_cjmMasterVOByPk(boolean blazyLoad,String... pks) throws BusinessException{
		return dao.listByPksWithOrder(AggOrder_cjmMasterVO.class,pks,blazyLoad);
	}

	@Override
	public AggOrder_cjmMasterVO findAggOrder_cjmMasterVOByPk(String pk) throws BusinessException{
		return dao.findByPk(AggOrder_cjmMasterVO.class, pk, false);
	}

	@Override
	public  AggOrder_cjmMasterVO[] listAggOrder_cjmMasterVOByCondition(String condition) throws BusinessException{
		return listAggOrder_cjmMasterVOByCondition(condition,new String[]{"pk_order_cjmmaster"});
	}
	@Override
	public  AggOrder_cjmMasterVO[] listAggOrder_cjmMasterVOByCondition(String condition,String[] orderPath) throws BusinessException{
		return dao.listByCondition(AggOrder_cjmMasterVO.class, condition, false,false,orderPath);
	}
	@Override
	public Order_cjmMasterVO[] listOrder_cjmMasterVOByPk(String... pks) throws BusinessException{
		return dao.listByPk(Order_cjmMasterVO.class, pks, true);
	}

	@Override
	public  Order_cjmMasterVO findOrder_cjmMasterVOByPk(String pk) throws BusinessException{
		return dao.findByPk(Order_cjmMasterVO.class, pk, true);
	}

	@Override
	public  Order_cjmMasterVO[] listOrder_cjmMasterVOByCondition(String condition) throws BusinessException{
		return listOrder_cjmMasterVOByCondition(condition,new String[]{"pk_order_cjmmaster"});
	}
	@Override
	public  Order_cjmMasterVO[] listOrder_cjmMasterVOByCondition(String condition,String[] orderPath) throws BusinessException{
		return dao.listByCondition(Order_cjmMasterVO.class, condition, false,false,orderPath);
	}

	@Override
	public String[] listOrder_cjmMasterVOPkByCond(String condition) throws BusinessException{
		return listOrder_cjmMasterVOPkByCond(condition,new String[]{"pk_order_cjmmaster"});
	}
	@Override
	public String[] listOrder_cjmMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException{
		if(StringUtils.isEmpty(condition)) {
			condition = " 1 = 1 ";
		}
		StringBuilder sql = new StringBuilder();
		sql.append(" select pk_order_cjmmaster from ").append(Order_cjmMasterVO.getDefaultTableName());
		sql.append(" where ").append(condition);
		if (ArrayUtils.isNotEmpty(orderPath)) {
			sql.append(" order by ").append(StringUtils.join(orderPath, ", "));
		}
		return (String[]) dao.getBaseDAO().executeQuery(sql.toString(), (rs) -> {
			List<String> pks = new ArrayList<>();
			while (rs.next()) {
				pks.add(rs.getString(1));
			}
			return pks.toArray(new String[0]);
		});
	}
	@Override
	public void initDefaultData(Order_cjmMasterVO vo){
		if(vo.getAttributeValue("pk_group") == null){
			vo.setAttributeValue("pk_group",InvocationInfoProxy.getInstance().getGroupId());
		}
		if(vo.getAttributeValue("billmaker") == null){
			vo.setAttributeValue("billmaker",InvocationInfoProxy.getInstance().getUserId());
		}
		if(vo.getAttributeValue("maketime") == null){
			vo.setAttributeValue("maketime",new UFDateTime(InvocationInfoProxy.getInstance().getBizDateTime()));
		}
		if(vo.getAttributeValue("billtype") == null){
			vo.setAttributeValue("billtype","PU51");
		}
		if(vo.getAttributeValue("approvestatus") == null){
			vo.setAttributeValue("approvestatus",BillStatusEnum.FREE.toIntValue());
		}
	}
	@Override
	public AggOrder_cjmMasterVO preAddAggOrder_cjmMasterVO(AggOrder_cjmMasterVO vo,Map<String,Object> userJson) throws BusinessException{

		getMainVO(vo).setStatus(VOStatus.NEW);
		initDefaultData((Order_cjmMasterVO)getMainVO(vo));

		//下面这段要判断是否是树表界面插件
		Map<String,String> data = userJson!=null && userJson.get("data") != null?(Map<String,String>)userJson.get("data"):null;
		if(data!=null && data.size()>0){
			String parentKey = data.get("parentKey");
			String parentPk = data.get("parentPk");
			getMainVO(vo).setAttributeValue(parentKey,parentPk);
		}

		//编码规则生成vo的编码
		BillCodeContext billCodeContext = getBillCodeContext("puorder_cjm");
		if(billCodeContext == null){
			throw new BusinessException("当前编码规则不存在，请到【编码规则定义-全局】节点检查是否存在"+"puorder_cjm");
		}
		if(billCodeContext.isPrecode()){
			String pk_group = InvocationInfoProxy.getInstance().getGroupId();
			String code = getBillcodeManage().getPreBillCode_RequiresNew("puorder_cjm", pk_group, pk_group);
			getMainVO(vo).setAttributeValue("code",code);
		}

		return vo;
	}
	@Override
	public AggOrder_cjmMasterVO preAddAggOrder_cjmMasterVO(Map<String,Object> userJson) throws BusinessException{
		AggOrder_cjmMasterVO result = null;

		Order_cjmMasterVO mainvo = new Order_cjmMasterVO();
		//设置默认值
		initDefaultData(mainvo);
		AggOrder_cjmMasterVO aggvo = new AggOrder_cjmMasterVO();
		aggvo.setParent(mainvo);
		result = aggvo;
		return preAddAggOrder_cjmMasterVO(result,userJson);
	}

	@Override
	public AggOrder_cjmMasterVO preEditAggOrder_cjmMasterVO(String pk) throws BusinessException{
		return dao.findByPk(AggOrder_cjmMasterVO.class, pk, false);
	}

	@Override
	public AggOrder_cjmMasterVO copyAggOrder_cjmMasterVO(String pk) throws BusinessException{

		AggOrder_cjmMasterVO vo = dao.findByPk(AggOrder_cjmMasterVO.class, pk, false);

		getMainVO(vo).setPrimaryKey(null);
		getMainVO(vo).setStatus(VOStatus.NEW);

		getMainVO(vo).setAttributeValue("srcbilltype",null);
		getMainVO(vo).setAttributeValue("srcbillid",null);

		getMainVO(vo).setAttributeValue("code",null);
		getMainVO(vo).setAttributeValue("",null);
		//编码规则生成vo的编码
		BillCodeContext billCodeContext = getBillCodeContext("puorder_cjm");
		if(billCodeContext == null){
			throw new BusinessException("当前编码规则不存在，请到【编码规则定义-全局】节点检查是否存在"+"puorder_cjm");
		}
		if(billCodeContext.isPrecode()){
			String pk_group = InvocationInfoProxy.getInstance().getGroupId();
			String code = getBillcodeManage().getPreBillCode_RequiresNew("puorder_cjm", pk_group, pk_group);
			getMainVO(vo).setAttributeValue("code",code);
		}
		getMainVO(vo).setAttributeValue("approvestatus", BillStatusEnum.FREE.toIntValue());
		getMainVO(vo).setAttributeValue("billmaker", InvocationInfoProxy.getInstance().getUserId());
		getMainVO(vo).setAttributeValue("approver", null);
		getMainVO(vo).setAttributeValue("approvenote", null);
		getMainVO(vo).setAttributeValue("approvedate", null);
		//设置审计信息为空
		getMainVO(vo).setAttributeValue("creator",null);
		getMainVO(vo).setAttributeValue("creationtime",null);
		getMainVO(vo).setAttributeValue("modifier",null);
		getMainVO(vo).setAttributeValue("modifiedtime",null);
		getMainVO(vo).setAttributeValue("maketime", new UFDateTime(InvocationInfoProxy.getInstance().getBizDateTime()));

		Order_cjmSlave0VO[] order_cjmSlave0VOs = (Order_cjmSlave0VO[])vo.getChildren(Order_cjmSlave0VO.class);
		if(order_cjmSlave0VOs!=null && order_cjmSlave0VOs.length>0){
			Arrays.stream(order_cjmSlave0VOs).forEach(subvo->{
				subvo.setPrimaryKey(null);
				subvo.setStatus(VOStatus.NEW);
				subvo.setAttributeValue("srcbilltype",null);
				subvo.setAttributeValue("srcbillid",null);
				subvo.setAttributeValue("rowno", null);
				subvo.setAttributeValue("srcrowno", null);
			});
		}
		return vo;
	}
	@Override
	public AggOrder_cjmMasterVO[] saveAggOrder_cjmMasterVO(AggOrder_cjmMasterVO vo) throws BusinessException{
		String pk = getVOPrimaryKey(vo);
		setDefaultVal(vo);
		if(StringUtils.isEmpty(pk)){
			return dao.insert(vo); //插入
		}else{
			return dao.update(vo); //更新
		}
	}
	/**
	 * 保存前处理编码规则
	 * @param vos
	 */
	private void setBillCode(AggOrder_cjmMasterVO... vos) throws BusinessException {
		if(ArrayUtils.isNotEmpty(vos)) {
			for(AggOrder_cjmMasterVO vo : vos) {
				String pk = getVOPrimaryKey(vo);
				if(StringUtils.isEmpty(pk)){
					BillCodeContext billCodeContext = getBillCodeContext("puorder_cjm");
					String pk_group = InvocationInfoProxy.getInstance().getGroupId();
					if(billCodeContext!=null && !billCodeContext.isPrecode()){
						if(getMainVO(vo).getAttributeValue("code") == null){
							String code = getBillcodeManage().getBillCode_RequiresNew("puorder_cjm", pk_group, pk_group, getMainVO(vo));
							getMainVO(vo).setAttributeValue("code",code);
						}
					} else {
						String code = (String) getMainVO(vo).getAttributeValue("code");
						getBillcodeManage().commitPreBillCode("puorder_cjm", pk_group, pk_group, code);
					}
				}
			}
		}
	}
	/**
	 * 保存前设置审计信息
	 * @param vos
	 */
	private void setAuditInfo(AggOrder_cjmMasterVO... vos) throws BusinessException {
		if(ArrayUtils.isNotEmpty(vos)) {
			UFDateTime now = new UFDateTime();
			for(AggOrder_cjmMasterVO vo : vos) {
				String pk = getVOPrimaryKey(vo);
				if(StringUtils.isEmpty(pk)){
					//设置创建人创建时间
					getMainVO(vo).setAttributeValue("creator",InvocationInfoProxy.getInstance().getUserId());
					getMainVO(vo).setAttributeValue("creationtime",now);
					getMainVO(vo).setAttributeValue("maketime",now);
					getMainVO(vo).setAttributeValue("billmaker", InvocationInfoProxy.getInstance().getUserId()); // 制单人
					getMainVO(vo).setAttributeValue("modifier",null);
					getMainVO(vo).setAttributeValue("modifiedtime",null);
				}else{
					//设置修改人修改时间
					getMainVO(vo).setAttributeValue("modifier",InvocationInfoProxy.getInstance().getUserId());
					getMainVO(vo).setAttributeValue("modifiedtime",now);
					getMainVO(vo).setAttributeValue("lastmaketime",now);
				}
			}
		}
	}
	/**
	 * 保存前处理一些默认值
	 * @param vos
	 */
	private void setDefaultVal(AggOrder_cjmMasterVO... vos) throws BusinessException {
		setBillCode(vos);
		setAuditInfo(vos);
		//其他默认值处理
	}

	// 给单表（行编辑表）单独适配
	@Override
	public AggOrder_cjmMasterVO[] saveAggOrder_cjmMasterVO(AggOrder_cjmMasterVO[] vos) throws BusinessException {
		if (ArrayUtils.isEmpty(vos)) {
			return new AggOrder_cjmMasterVO[0];
		}
		setDefaultVal(vos); // 设置默认值
		List<String> pks = Arrays.stream(vos).filter(v -> getMainVO(v).getStatus() == VOStatus.DELETED)
				.map(v -> getMainVO(v).getPrimaryKey()).collect(Collectors.toList()); // 删除单据主键
		if (pks == null || pks.size() == 0) {
			return dao.save(vos, true);
		}
		AggOrder_cjmMasterVO[] deleteVOs = dao.listByPk(AggOrder_cjmMasterVO.class, pks.toArray(new String[0]));
		for (int i = 0; i < deleteVOs.length; i++) {
			SuperVO mainVO = getMainVO(deleteVOs[i]);
			// 删除单据时校验单据状态
			Integer approveStatus = (Integer) mainVO.getAttributeValue("approvestatus");
			if (approveStatus != null && !approveStatus.equals(-1)) {
				throw new BusinessException("第" + (i + 1) + "张单据处理失败：单据状态不正确，不能删除！");
			}
			// 删除单据时回退单据号
			String code = (String)mainVO.getAttributeValue("code");
			if (StringUtils.isNotEmpty(code)) {
				String pk_group = InvocationInfoProxy.getInstance().getGroupId();
				getBillcodeManage().returnBillCodeOnDelete("puorder_cjm", pk_group, pk_group, code, deleteVOs[i]);
			}
		}
		return dao.save(vos,true);
	}

	@Override
	public AggOrder_cjmMasterVO[] deleteAggOrder_cjmMasterVOs(Map<String,String> tsMap) throws BusinessException{
		AggOrder_cjmMasterVO[] vos = dao.listByPk(AggOrder_cjmMasterVO.class,tsMap.keySet().toArray(new String[0]));
		validate(vos,tsMap);
		String pk_group = InvocationInfoProxy.getInstance().getGroupId();
		Arrays.stream(vos).forEach(vo->{
			String code = (String)getMainVO(vo).getAttributeValue("code");
			try {
				getBillcodeManage().returnBillCodeOnDelete("puorder_cjm",pk_group,pk_group,code,vo);
			} catch (BusinessException e) {
				ExceptionUtils.wrapException(e.getMessage(),e);
			}
		});
		dao.delete(vos,true);
		return vos;
	}
	
	//校验  包括ts校验  已提交校验
	private void validate(AggOrder_cjmMasterVO[] vos,Map<String,String> tsMap) throws BusinessException{

		Boolean isPass = true;
		String error = "";    //错误信息
		if(ArrayUtils.isEmpty(vos)){
			isPass = false;
		}
		
		for(int i = 0 ; i < vos.length ; i++){
			SuperVO mainvo = vos[i].getParentVO();
			UFDateTime ts = (UFDateTime)mainvo.getAttributeValue("ts");
			if(!StringUtils.equals(tsMap.get(mainvo.getPrimaryKey()),ts.toString())){
				isPass = false;
				break;
			}
			Integer approvestatus = (Integer) mainvo.getAttributeValue("approvestatus");
			if(approvestatus == null || approvestatus != BillStatusEnum.FREE.toIntValue()){
				error += "第"+(i+1)+"张单据处理失败：审批状态不正确，不能删除！\n";
			}
		}
		if(!isPass) {
			throw new BusinessException("您操作的数据已被他人修改或删除，请刷新后重试！");
		}
		if(!"".equals(error)){
			throw new BusinessException(error);
		}
	}
	
	@Override
	public <T> T[] loadTreeData(Class<T> clazz,Map<String,Object> userJson) throws BusinessException{
		String condition = "dr = 0 ";
		return dao.listByCondition(clazz, condition, false);
	}

	@Override
	public String[] queryChildPksByParentId(Class childClazz, String parentId) throws BusinessException{
		String cond = " pk_order_cjmmaster = '" + parentId + "' ";
		SuperVO[] vos  = (SuperVO[]) dao.listByCondition(childClazz, cond, false);
		if (vos == null || vos.length == 0) {
			return new String[0];
		}
		return Stream.of(vos).map(vo -> vo.getPrimaryKey()).toArray(String[]::new);
	}


	public SuperVO[] queryChildVOByPks(Class childClazz, String[] pks) throws BusinessException{
		return (SuperVO[]) dao.listByPk(childClazz, pks, false);
	}

	/**
	 * 提交前校验:
	 * 检查单据状态
	 * @throws BusinessException
	 * */
	private void validateCommitAggOrder_cjmMasterVO(AggOrder_cjmMasterVO... vos) throws BusinessException {
		if(ArrayUtils.isEmpty(vos)) {
			return ;
		}
		List<AggOrder_cjmMasterVO> list = Arrays.stream(vos)
			.filter(item ->item.getParentVO()!=null)
			.filter(item->{
				Integer status =  (Integer) item.getParentVO().getAttributeValue("approvestatus");
				return status==null||status!=BillStatusEnum.FREE.toIntValue()&&status!=BillStatusEnum.NOPASS.toIntValue();
			}).map(item->item)
			.collect(Collectors.toList());
		if(list == null||list.size() == 0) {
			return;
		}
		String errors = "";
		for(AggOrder_cjmMasterVO vo  : list) {
			errors+="单据号：["+vo.getParentVO().getAttributeValue("code")+"]提交失败，失败原因：单据状态不正确，请检查。\n";
		}
		throw new BusinessException(errors);
	}
	/**
	 * 收回前校验:
	 * 检查单据状态
	 * @throws BusinessException
	 * */
	private void validateUnCommitAggOrder_cjmMasterVO(AggOrder_cjmMasterVO... vos) throws BusinessException {
		if(ArrayUtils.isEmpty(vos)) {
			return ;
		}
		List<AggOrder_cjmMasterVO> list = Arrays.stream(vos)
			.filter(item ->item.getParentVO()!=null)
			.filter(item->{
				Integer status =  (Integer)item.getParentVO().getAttributeValue("approvestatus");
				return status==null||status==BillStatusEnum.FREE.toIntValue();
			}).map(item->item)
			.collect(Collectors.toList());
		if(list == null||list.size() == 0) {
			return;
		}
		String errors = "";
		for(AggOrder_cjmMasterVO vo  : list) {
			errors+="单据号：["+vo.getParentVO().getAttributeValue("code")+"]收回失败，失败原因：单据状态不正确，请检查。\n";
		}
		throw new BusinessException(errors);
	}
	@Override
	public Object commitAggOrder_cjmMasterVO(String actionName,Map<String,String> tsMap,Object assign) throws BusinessException{
		AggOrder_cjmMasterVO[] vos = dao.listByPk(AggOrder_cjmMasterVO.class,getAllPks(tsMap),false);
		validateTs(tsMap,vos);
		//提交前校验及业务逻辑
		validateCommitAggOrder_cjmMasterVO(vos);
		Map<String,Object> res = this.execFlows(actionName,"PU51",assign,vos);
		//提交后业务逻辑
		return res;
	}

	@Override
	public Object batchCommitAggOrder_cjmMasterVO(String actionName,Map<String,String> tsMap) throws BusinessException{
		AggOrder_cjmMasterVO[] vos = dao.listByPk(AggOrder_cjmMasterVO.class,getAllPks(tsMap),false);
		validateTs(tsMap,vos);
		//批量提交前校验及业务逻辑
		validateCommitAggOrder_cjmMasterVO(vos);
		Map<String,Object> res = this.execFlows(actionName,"PU51",vos);
		//批量提交后业务逻辑
		return res;
	}

	@Override
	public Object uncommitAggOrder_cjmMasterVO(String actionName,Map<String,String> tsMap) throws BusinessException{
		AggOrder_cjmMasterVO[] vos = dao.listByPk(AggOrder_cjmMasterVO.class,getAllPks(tsMap),false);
		validateTs(tsMap,vos);
		//收回前校验及业务逻辑
		validateUnCommitAggOrder_cjmMasterVO(vos);
		Map<String,Object> res = this.execFlows(actionName,"PU51",vos);
		//收回后业务逻辑
		return res;
	}

	@Override
	public Object batchUncommitAggOrder_cjmMasterVO(String actionName,Map<String,String> tsMap) throws BusinessException{
		AggOrder_cjmMasterVO[] vos = dao.listByPk(AggOrder_cjmMasterVO.class,getAllPks(tsMap),false);
		validateTs(tsMap,vos);
		//批量收回前校验及业务逻辑
		validateUnCommitAggOrder_cjmMasterVO(vos);
		Map<String,Object> res = this.execFlows(actionName,"PU51",vos);
		//批量收回后业务逻辑
		return res;
	}

	@Override
	public AggOrder_cjmMasterVO[] callbackSAVEBASE(AggOrder_cjmMasterVO...vos) throws BusinessException{
		if(ArrayUtils.isEmpty(vos)) {
			return null;
		}
		return this.saveAggOrder_cjmMasterVO(vos);

	}


	@Override
	public AggOrder_cjmMasterVO[] callbackSAVE(AggOrder_cjmMasterVO...vos) throws BusinessException{
		if(ArrayUtils.isEmpty(vos)) {
			return null;
		}
		//同步单据状态和审批状态(只有提交时候需要手动设置审批状态。其余审批完后审批状态都已更新)
		Arrays.stream(vos).forEach(v->{
				v.getParent().setAttributeValue("approvestatus",BillStatusEnum.COMMIT.toIntValue());
		});
		return this.saveAggOrder_cjmMasterVO(vos);

	}


	@Override
	public AggOrder_cjmMasterVO[] callbackUNSAVE(AggOrder_cjmMasterVO...vos) throws BusinessException{
		if(ArrayUtils.isEmpty(vos)) {
			return null;
		}
		return this.saveAggOrder_cjmMasterVO(vos);

	}


	@Override
	public AggOrder_cjmMasterVO[] callbackAPPROVE(AggOrder_cjmMasterVO...vos) throws BusinessException{
		if(ArrayUtils.isEmpty(vos)) {
			return null;
		}
		return this.saveAggOrder_cjmMasterVO(vos);

	}


	@Override
	public AggOrder_cjmMasterVO[] callbackUNAPPROVE(AggOrder_cjmMasterVO...vos) throws BusinessException{
		if(ArrayUtils.isEmpty(vos)) {
			return null;
		}
		return this.saveAggOrder_cjmMasterVO(vos);

	}


	@Override
	public BillCodeContext getBillCodeContext(String coderuleid) throws BusinessException{
		return super.getBillCodeContext(coderuleid);
	}

	@Override
	public BillCodeContext getBillCodeContext(String coderuleid, String pkgroup, String pkorg) throws BusinessException{
		return super.getBillCodeContext(coderuleid,pkgroup,pkorg);
	}
}
