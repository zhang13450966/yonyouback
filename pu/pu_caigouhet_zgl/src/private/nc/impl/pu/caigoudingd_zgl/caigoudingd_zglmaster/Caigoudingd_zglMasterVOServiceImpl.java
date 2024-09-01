package nc.impl.pu.caigoudingd_zgl.caigoudingd_zglmaster;

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

import nc.vo.caigoudingdan.caigoudingd_zgl.Caigoudingd_zglMasterVO;
import nc.vo.caigoudingdan.caigoudingd_zgl.Caigoudingd_zglSlave0VO;
import nc.vo.caigoudingdan.caigoudingd_zgl.AggCaigoudingd_zglMasterVO;
import nc.itf.pu.caigoudingd_zgl.caigoudingd_zglmaster.ICaigoudingd_zglMasterVOService;


import nc.vo.pub.pf.BillStatusEnum;
import nc.bs.framework.common.InvocationInfoProxy;
import nccloud.framework.core.exception.ExceptionUtils;

public class  Caigoudingd_zglMasterVOServiceImpl extends ServiceSupport implements ICaigoudingd_zglMasterVOService {


	@Override
	public AggCaigoudingd_zglMasterVO[] listAggCaigoudingd_zglMasterVOByPk(String...pks) throws BusinessException{
		return listAggCaigoudingd_zglMasterVOByPk(false,pks);
	}

	@Override
	public AggCaigoudingd_zglMasterVO[] listAggCaigoudingd_zglMasterVOByPk(boolean blazyLoad,String... pks) throws BusinessException{
		return dao.listByPksWithOrder(AggCaigoudingd_zglMasterVO.class,pks,blazyLoad);
	}

	@Override
	public AggCaigoudingd_zglMasterVO findAggCaigoudingd_zglMasterVOByPk(String pk) throws BusinessException{
		return dao.findByPk(AggCaigoudingd_zglMasterVO.class, pk, false);
	}

	@Override
	public  AggCaigoudingd_zglMasterVO[] listAggCaigoudingd_zglMasterVOByCondition(String condition) throws BusinessException{
		return listAggCaigoudingd_zglMasterVOByCondition(condition,new String[]{"pk_cgdingdan_zglmaster"});
	}
	@Override
	public  AggCaigoudingd_zglMasterVO[] listAggCaigoudingd_zglMasterVOByCondition(String condition,String[] orderPath) throws BusinessException{
		return dao.listByCondition(AggCaigoudingd_zglMasterVO.class, condition, false,false,orderPath);
	}
	@Override
	public Caigoudingd_zglMasterVO[] listCaigoudingd_zglMasterVOByPk(String... pks) throws BusinessException{
		return dao.listByPk(Caigoudingd_zglMasterVO.class, pks, true);
	}

	@Override
	public  Caigoudingd_zglMasterVO findCaigoudingd_zglMasterVOByPk(String pk) throws BusinessException{
		return dao.findByPk(Caigoudingd_zglMasterVO.class, pk, true);
	}

	@Override
	public  Caigoudingd_zglMasterVO[] listCaigoudingd_zglMasterVOByCondition(String condition) throws BusinessException{
		return listCaigoudingd_zglMasterVOByCondition(condition,new String[]{"pk_cgdingdan_zglmaster"});
	}
	@Override
	public  Caigoudingd_zglMasterVO[] listCaigoudingd_zglMasterVOByCondition(String condition,String[] orderPath) throws BusinessException{
		return dao.listByCondition(Caigoudingd_zglMasterVO.class, condition, false,false,orderPath);
	}

	@Override
	public String[] listCaigoudingd_zglMasterVOPkByCond(String condition) throws BusinessException{
		return listCaigoudingd_zglMasterVOPkByCond(condition,new String[]{"pk_cgdingdan_zglmaster"});
	}
	@Override
	public String[] listCaigoudingd_zglMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException{
		if(StringUtils.isEmpty(condition)) {
			condition = " 1 = 1 ";
		}
		StringBuilder sql = new StringBuilder();
		sql.append(" select pk_cgdingdan_zglmaster from ").append(Caigoudingd_zglMasterVO.getDefaultTableName());
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
	public void initDefaultData(Caigoudingd_zglMasterVO vo){
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
			vo.setAttributeValue("billtype","TRH102ZGL");
		}
		if(vo.getAttributeValue("approvestatus") == null){
			vo.setAttributeValue("approvestatus",BillStatusEnum.FREE.toIntValue());
		}
	}
	@Override
	public AggCaigoudingd_zglMasterVO preAddAggCaigoudingd_zglMasterVO(AggCaigoudingd_zglMasterVO vo,Map<String,Object> userJson) throws BusinessException{

		getMainVO(vo).setStatus(VOStatus.NEW);
		initDefaultData((Caigoudingd_zglMasterVO)getMainVO(vo));

		//下面这段要判断是否是树表界面插件
		Map<String,String> data = userJson!=null && userJson.get("data") != null?(Map<String,String>)userJson.get("data"):null;
		if(data!=null && data.size()>0){
			String parentKey = data.get("parentKey");
			String parentPk = data.get("parentPk");
			getMainVO(vo).setAttributeValue(parentKey,parentPk);
		}

		//编码规则生成vo的编码
		BillCodeContext billCodeContext = getBillCodeContext("caigoudingd_zgl");
		if(billCodeContext == null){
			throw new BusinessException("当前编码规则不存在，请到【编码规则定义-全局】节点检查是否存在"+"caigoudingd_zgl");
		}
		if(billCodeContext.isPrecode()){
			String pk_group = InvocationInfoProxy.getInstance().getGroupId();
			String code = getBillcodeManage().getPreBillCode_RequiresNew("caigoudingd_zgl", pk_group, pk_group);
			getMainVO(vo).setAttributeValue("code",code);
		}

		return vo;
	}
	@Override
	public AggCaigoudingd_zglMasterVO preAddAggCaigoudingd_zglMasterVO(Map<String,Object> userJson) throws BusinessException{
		AggCaigoudingd_zglMasterVO result = null;

		Caigoudingd_zglMasterVO mainvo = new Caigoudingd_zglMasterVO();
		//设置默认值
		initDefaultData(mainvo);
		AggCaigoudingd_zglMasterVO aggvo = new AggCaigoudingd_zglMasterVO();
		aggvo.setParent(mainvo);
		result = aggvo;
		return preAddAggCaigoudingd_zglMasterVO(result,userJson);
	}

	@Override
	public AggCaigoudingd_zglMasterVO preEditAggCaigoudingd_zglMasterVO(String pk) throws BusinessException{
		return dao.findByPk(AggCaigoudingd_zglMasterVO.class, pk, false);
	}

	@Override
	public AggCaigoudingd_zglMasterVO copyAggCaigoudingd_zglMasterVO(String pk) throws BusinessException{

		AggCaigoudingd_zglMasterVO vo = dao.findByPk(AggCaigoudingd_zglMasterVO.class, pk, false);

		getMainVO(vo).setPrimaryKey(null);
		getMainVO(vo).setStatus(VOStatus.NEW);

		getMainVO(vo).setAttributeValue("srcbilltype",null);
		getMainVO(vo).setAttributeValue("srcbillid",null);

		getMainVO(vo).setAttributeValue("code",null);
		getMainVO(vo).setAttributeValue("",null);
		//编码规则生成vo的编码
		BillCodeContext billCodeContext = getBillCodeContext("caigoudingd_zgl");
		if(billCodeContext == null){
			throw new BusinessException("当前编码规则不存在，请到【编码规则定义-全局】节点检查是否存在"+"caigoudingd_zgl");
		}
		if(billCodeContext.isPrecode()){
			String pk_group = InvocationInfoProxy.getInstance().getGroupId();
			String code = getBillcodeManage().getPreBillCode_RequiresNew("caigoudingd_zgl", pk_group, pk_group);
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

		Caigoudingd_zglSlave0VO[] caigoudingd_zglSlave0VOs = (Caigoudingd_zglSlave0VO[])vo.getChildren(Caigoudingd_zglSlave0VO.class);
		if(caigoudingd_zglSlave0VOs!=null && caigoudingd_zglSlave0VOs.length>0){
			Arrays.stream(caigoudingd_zglSlave0VOs).forEach(subvo->{
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
	public AggCaigoudingd_zglMasterVO[] saveAggCaigoudingd_zglMasterVO(AggCaigoudingd_zglMasterVO vo) throws BusinessException{
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
	private void setBillCode(AggCaigoudingd_zglMasterVO... vos) throws BusinessException {
		if(ArrayUtils.isNotEmpty(vos)) {
			for(AggCaigoudingd_zglMasterVO vo : vos) {
				String pk = getVOPrimaryKey(vo);
				if(StringUtils.isEmpty(pk)){
					BillCodeContext billCodeContext = getBillCodeContext("caigoudingd_zgl");
					String pk_group = InvocationInfoProxy.getInstance().getGroupId();
					if(billCodeContext!=null && !billCodeContext.isPrecode()){
						if(getMainVO(vo).getAttributeValue("code") == null){
							String code = getBillcodeManage().getBillCode_RequiresNew("caigoudingd_zgl", pk_group, pk_group, getMainVO(vo));
							getMainVO(vo).setAttributeValue("code",code);
						}
					} else {
						String code = (String) getMainVO(vo).getAttributeValue("code");
						getBillcodeManage().commitPreBillCode("caigoudingd_zgl", pk_group, pk_group, code);
					}
				}
			}
		}
	}
	/**
	 * 保存前设置审计信息
	 * @param vos
	 */
	private void setAuditInfo(AggCaigoudingd_zglMasterVO... vos) throws BusinessException {
		if(ArrayUtils.isNotEmpty(vos)) {
			UFDateTime now = new UFDateTime();
			for(AggCaigoudingd_zglMasterVO vo : vos) {
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
	private void setDefaultVal(AggCaigoudingd_zglMasterVO... vos) throws BusinessException {
		setBillCode(vos);
		setAuditInfo(vos);
		//其他默认值处理
	}

	// 给单表（行编辑表）单独适配
	@Override
	public AggCaigoudingd_zglMasterVO[] saveAggCaigoudingd_zglMasterVO(AggCaigoudingd_zglMasterVO[] vos) throws BusinessException {
		if (ArrayUtils.isEmpty(vos)) {
			return new AggCaigoudingd_zglMasterVO[0];
		}
		setDefaultVal(vos); // 设置默认值
		List<String> pks = Arrays.stream(vos).filter(v -> getMainVO(v).getStatus() == VOStatus.DELETED)
				.map(v -> getMainVO(v).getPrimaryKey()).collect(Collectors.toList()); // 删除单据主键
		if (pks == null || pks.size() == 0) {
			return dao.save(vos, true);
		}
		AggCaigoudingd_zglMasterVO[] deleteVOs = dao.listByPk(AggCaigoudingd_zglMasterVO.class, pks.toArray(new String[0]));
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
				getBillcodeManage().returnBillCodeOnDelete("caigoudingd_zgl", pk_group, pk_group, code, deleteVOs[i]);
			}
		}
		return dao.save(vos,true);
	}

	@Override
	public AggCaigoudingd_zglMasterVO[] deleteAggCaigoudingd_zglMasterVOs(Map<String,String> tsMap) throws BusinessException{
		AggCaigoudingd_zglMasterVO[] vos = dao.listByPk(AggCaigoudingd_zglMasterVO.class,tsMap.keySet().toArray(new String[0]));
		validate(vos,tsMap);
		String pk_group = InvocationInfoProxy.getInstance().getGroupId();
		Arrays.stream(vos).forEach(vo->{
			String code = (String)getMainVO(vo).getAttributeValue("code");
			try {
				getBillcodeManage().returnBillCodeOnDelete("caigoudingd_zgl",pk_group,pk_group,code,vo);
			} catch (BusinessException e) {
				ExceptionUtils.wrapException(e.getMessage(),e);
			}
		});
		dao.delete(vos,true);
		return vos;
	}
	
	//校验  包括ts校验  已提交校验
	private void validate(AggCaigoudingd_zglMasterVO[] vos,Map<String,String> tsMap) throws BusinessException{

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
		String cond = " pk_cgdingdan_zglmaster = '" + parentId + "' ";
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
	private void validateCommitAggCaigoudingd_zglMasterVO(AggCaigoudingd_zglMasterVO... vos) throws BusinessException {
		if(ArrayUtils.isEmpty(vos)) {
			return ;
		}
		List<AggCaigoudingd_zglMasterVO> list = Arrays.stream(vos)
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
		for(AggCaigoudingd_zglMasterVO vo  : list) {
			errors+="单据号：["+vo.getParentVO().getAttributeValue("code")+"]提交失败，失败原因：单据状态不正确，请检查。\n";
		}
		throw new BusinessException(errors);
	}
	/**
	 * 收回前校验:
	 * 检查单据状态
	 * @throws BusinessException
	 * */
	private void validateUnCommitAggCaigoudingd_zglMasterVO(AggCaigoudingd_zglMasterVO... vos) throws BusinessException {
		if(ArrayUtils.isEmpty(vos)) {
			return ;
		}
		List<AggCaigoudingd_zglMasterVO> list = Arrays.stream(vos)
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
		for(AggCaigoudingd_zglMasterVO vo  : list) {
			errors+="单据号：["+vo.getParentVO().getAttributeValue("code")+"]收回失败，失败原因：单据状态不正确，请检查。\n";
		}
		throw new BusinessException(errors);
	}
	@Override
	public Object commitAggCaigoudingd_zglMasterVO(String actionName,Map<String,String> tsMap,Object assign) throws BusinessException{
		AggCaigoudingd_zglMasterVO[] vos = dao.listByPk(AggCaigoudingd_zglMasterVO.class,getAllPks(tsMap),false);
		validateTs(tsMap,vos);
		//提交前校验及业务逻辑
		validateCommitAggCaigoudingd_zglMasterVO(vos);
		Map<String,Object> res = this.execFlows(actionName,"TRH102ZGL",assign,vos);
		//提交后业务逻辑
		return res;
	}

	@Override
	public Object batchCommitAggCaigoudingd_zglMasterVO(String actionName,Map<String,String> tsMap) throws BusinessException{
		AggCaigoudingd_zglMasterVO[] vos = dao.listByPk(AggCaigoudingd_zglMasterVO.class,getAllPks(tsMap),false);
		validateTs(tsMap,vos);
		//批量提交前校验及业务逻辑
		validateCommitAggCaigoudingd_zglMasterVO(vos);
		Map<String,Object> res = this.execFlows(actionName,"TRH102ZGL",vos);
		//批量提交后业务逻辑
		return res;
	}

	@Override
	public Object uncommitAggCaigoudingd_zglMasterVO(String actionName,Map<String,String> tsMap) throws BusinessException{
		AggCaigoudingd_zglMasterVO[] vos = dao.listByPk(AggCaigoudingd_zglMasterVO.class,getAllPks(tsMap),false);
		validateTs(tsMap,vos);
		//收回前校验及业务逻辑
		validateUnCommitAggCaigoudingd_zglMasterVO(vos);
		Map<String,Object> res = this.execFlows(actionName,"TRH102ZGL",vos);
		//收回后业务逻辑
		return res;
	}

	@Override
	public Object batchUncommitAggCaigoudingd_zglMasterVO(String actionName,Map<String,String> tsMap) throws BusinessException{
		AggCaigoudingd_zglMasterVO[] vos = dao.listByPk(AggCaigoudingd_zglMasterVO.class,getAllPks(tsMap),false);
		validateTs(tsMap,vos);
		//批量收回前校验及业务逻辑
		validateUnCommitAggCaigoudingd_zglMasterVO(vos);
		Map<String,Object> res = this.execFlows(actionName,"TRH102ZGL",vos);
		//批量收回后业务逻辑
		return res;
	}

	@Override
	public AggCaigoudingd_zglMasterVO[] callbackSAVEBASE(AggCaigoudingd_zglMasterVO...vos) throws BusinessException{
		if(ArrayUtils.isEmpty(vos)) {
			return null;
		}
		return this.saveAggCaigoudingd_zglMasterVO(vos);

	}


	@Override
	public AggCaigoudingd_zglMasterVO[] callbackSAVE(AggCaigoudingd_zglMasterVO...vos) throws BusinessException{
		if(ArrayUtils.isEmpty(vos)) {
			return null;
		}
		//同步单据状态和审批状态(只有提交时候需要手动设置审批状态。其余审批完后审批状态都已更新)
		Arrays.stream(vos).forEach(v->{
				v.getParent().setAttributeValue("approvestatus",BillStatusEnum.COMMIT.toIntValue());
		});
		return this.saveAggCaigoudingd_zglMasterVO(vos);

	}


	@Override
	public AggCaigoudingd_zglMasterVO[] callbackUNSAVE(AggCaigoudingd_zglMasterVO...vos) throws BusinessException{
		if(ArrayUtils.isEmpty(vos)) {
			return null;
		}
		return this.saveAggCaigoudingd_zglMasterVO(vos);

	}


	@Override
	public AggCaigoudingd_zglMasterVO[] callbackAPPROVE(AggCaigoudingd_zglMasterVO...vos) throws BusinessException{
		if(ArrayUtils.isEmpty(vos)) {
			return null;
		}
		return this.saveAggCaigoudingd_zglMasterVO(vos);

	}


	@Override
	public AggCaigoudingd_zglMasterVO[] callbackUNAPPROVE(AggCaigoudingd_zglMasterVO...vos) throws BusinessException{
		if(ArrayUtils.isEmpty(vos)) {
			return null;
		}
		return this.saveAggCaigoudingd_zglMasterVO(vos);

	}

	@Override
	public AggCaigoudingd_zglMasterVO[] tranferpuzglToAggCaigoudingd_zglMasterVO(Map<String,String> pkTsMap) throws BusinessException{
		AggCaigoudingd_zglMasterVO[] vos = pullBillFromLastBill("puzgl","TRH102ZGL",nc.vo.pu.pu_caigouhet_zgl.AggPu_caigouhet_zglMasterVO.class,AggCaigoudingd_zglMasterVO.class,pkTsMap);
		//编码规则生成vo的编码
		BillCodeContext billCodeContext = getBillCodeContext("caigoudingd_zgl");
		if(billCodeContext == null){
			throw new BusinessException("当前编码规则不存在，请到【编码规则定义-全局】节点检查是否存在"+"caigoudingd_zgl");
		}
		if(billCodeContext.isPrecode()){
			String pk_group = InvocationInfoProxy.getInstance().getGroupId();
			for (AggCaigoudingd_zglMasterVO vo : vos) {
				String code = getBillcodeManage().getPreBillCode_RequiresNew("caigoudingd_zgl", pk_group, pk_group);
				getMainVO(vo).setAttributeValue("code",code);
			}
		}
		return vos;
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
