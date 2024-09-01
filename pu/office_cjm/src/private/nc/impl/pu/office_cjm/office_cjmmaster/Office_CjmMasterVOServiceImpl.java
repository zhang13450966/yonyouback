package nc.impl.pu.office_cjm.office_cjmmaster;

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


import nc.vo.pu.office_cjm.Office_CjmMasterVO;
import nc.itf.pu.office_cjm.office_cjmmaster.IOffice_CjmMasterVOService;


import nc.bs.framework.common.InvocationInfoProxy;
import nccloud.framework.core.exception.ExceptionUtils;

public class  Office_CjmMasterVOServiceImpl extends ServiceSupport implements IOffice_CjmMasterVOService {


	@Override
	public Office_CjmMasterVO[] listOffice_CjmMasterVOByPk(String[] pks,  boolean blazyLoad) throws BusinessException{
		return dao.listByPk(Office_CjmMasterVO.class, pks, blazyLoad);
	}

	@Override
	public  Office_CjmMasterVO findOffice_CjmMasterVOByPk(String pk, boolean blazyLoad) throws BusinessException{
		return dao.findByPk(Office_CjmMasterVO.class, pk, blazyLoad);
	}

	@Override
	public  Office_CjmMasterVO[] listOffice_CjmMasterVOByPk(String condition, boolean blazyLoad) throws BusinessException{
		return dao.listByCondition(Office_CjmMasterVO.class, condition, blazyLoad);
	}
	@Override
	public String[] listOffice_CjmMasterVOPkByCond(String condition) throws BusinessException{
		return listOffice_CjmMasterVOPkByCond(condition,new String[]{"pk_office_cjmmaster"});
	}
	@Override
	public String[] listOffice_CjmMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException{
		if(StringUtils.isEmpty(condition)) {
			condition = " 1 = 1 ";
		}
		StringBuilder sql = new StringBuilder();
		sql.append(" select pk_office_cjmmaster from ").append(Office_CjmMasterVO.getDefaultTableName());
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
	public String[] listOffice_CjmMasterVOPkBySql(String searchSql,String pid,String treeNodePk) throws BusinessException{
		if(StringUtils.isEmpty(searchSql)) {
			searchSql = " 1 = 1 ";
		}
		if(treeNodePk != null && !StringUtils.isEmpty(pid)){
			searchSql += " and " + pid + " in ("+ new InSQLCreator().getInSQL(new Region_CjmMasterVOServiceImpl().getLowerLevelPks(treeNodePk))+")";
		}
		return listOffice_CjmMasterVOPkByCond(searchSql);
	}
	@Override
	public void initDefaultData(Office_CjmMasterVO vo){
		if(vo.getAttributeValue("pk_group") == null){
			vo.setAttributeValue("pk_group",InvocationInfoProxy.getInstance().getGroupId());
		}
	}
	@Override
	public Office_CjmMasterVO preAddOffice_CjmMasterVO(Office_CjmMasterVO vo,Map<String,Object> userJson) throws BusinessException{

		getMainVO(vo).setStatus(VOStatus.NEW);
		initDefaultData((Office_CjmMasterVO)getMainVO(vo));

		//下面这段要判断是否是树表界面插件
		Map<String,String> data = userJson!=null && userJson.get("data") != null?(Map<String,String>)userJson.get("data"):null;
		if(data!=null && data.size()>0){
			String parentKey = data.get("parentKey");
			String parentPk = data.get("parentPk");
			getMainVO(vo).setAttributeValue(parentKey,parentPk);
		}


		return vo;
	}
	@Override
	public Office_CjmMasterVO preAddOffice_CjmMasterVO(Map<String,Object> userJson) throws BusinessException{
		Office_CjmMasterVO result = null;

		Office_CjmMasterVO mainvo = new Office_CjmMasterVO();
		//设置默认值
		initDefaultData(mainvo);
		result = mainvo;
		return preAddOffice_CjmMasterVO(result,userJson);
	}

	@Override
	public Office_CjmMasterVO preEditOffice_CjmMasterVO(String pk) throws BusinessException{
		return dao.findByPk(Office_CjmMasterVO.class, pk, false);
	}

	@Override
	public Office_CjmMasterVO copyOffice_CjmMasterVO(String pk) throws BusinessException{

		Office_CjmMasterVO vo = dao.findByPk(Office_CjmMasterVO.class, pk, false);

		getMainVO(vo).setPrimaryKey(null);
		getMainVO(vo).setStatus(VOStatus.NEW);

		getMainVO(vo).setAttributeValue("srcbilltype",null);
		getMainVO(vo).setAttributeValue("srcbillid",null);

		getMainVO(vo).setAttributeValue("code",null);
		getMainVO(vo).setAttributeValue("",null);
		getMainVO(vo).setAttributeValue("name",null);
		getMainVO(vo).setAttributeValue("", new UFDateTime(InvocationInfoProxy.getInstance().getBizDateTime()));

		return vo;
	}
	@Override
	public Office_CjmMasterVO[] saveOffice_CjmMasterVO(Office_CjmMasterVO vo) throws BusinessException{
		String pk = getVOPrimaryKey(vo);
		setDefaultVal(vo);
		if(StringUtils.isEmpty(pk)){
			return dao.insert(vo); //插入
		}else{
			return dao.update(vo); //更新
		}
	}
	/**
	 * 保存前设置审计信息
	 * @param vos
	 */
	private void setAuditInfo(Office_CjmMasterVO... vos) throws BusinessException {
		if(ArrayUtils.isNotEmpty(vos)) {
			UFDateTime now = new UFDateTime();
			for(Office_CjmMasterVO vo : vos) {
				String pk = getVOPrimaryKey(vo);
				if(StringUtils.isEmpty(pk)){
					//设置创建人创建时间
					getMainVO(vo).setAttributeValue("creator",InvocationInfoProxy.getInstance().getUserId());
					getMainVO(vo).setAttributeValue("creationtime",now);
					getMainVO(vo).setAttributeValue("",now);
					getMainVO(vo).setAttributeValue("modifier",null);
					getMainVO(vo).setAttributeValue("modifiedtime",null);
				}else{
					//设置修改人修改时间
					getMainVO(vo).setAttributeValue("modifier",InvocationInfoProxy.getInstance().getUserId());
					getMainVO(vo).setAttributeValue("modifiedtime",now);
					getMainVO(vo).setAttributeValue("",now);
				}
			}
		}
	}
	/**
	 * 保存前处理一些默认值
	 * @param vos
	 */
	private void setDefaultVal(Office_CjmMasterVO... vos) throws BusinessException {
		setAuditInfo(vos);
		//其他默认值处理
	}

	// 给单表（行编辑表）单独适配
	@Override
	public Office_CjmMasterVO[] saveOffice_CjmMasterVO(Office_CjmMasterVO[] vos) throws BusinessException {
		if (ArrayUtils.isEmpty(vos)) {
			return new Office_CjmMasterVO[0];
		}
		setDefaultVal(vos); // 设置默认值
		return dao.save(vos,true);
	}

	@Override
	public Office_CjmMasterVO[] deleteOffice_CjmMasterVOs(Map<String,String> tsMap) throws BusinessException{
		Office_CjmMasterVO[] vos = dao.listByPk(Office_CjmMasterVO.class,tsMap.keySet().toArray(new String[0]));
		validate(vos,tsMap);
		dao.delete(vos,true);
		return vos;
	}
	
	//校验  包括ts校验  已提交校验
	private void validate(Office_CjmMasterVO[] vos,Map<String,String> tsMap) throws BusinessException{

		Boolean isPass = true;
		String error = "";    //错误信息
		if(ArrayUtils.isEmpty(vos)){
			isPass = false;
		}
		
		for(int i = 0 ; i < vos.length ; i++){
			SuperVO mainvo = vos[i];
			UFDateTime ts = (UFDateTime)mainvo.getAttributeValue("ts");
			if(!StringUtils.equals(tsMap.get(mainvo.getPrimaryKey()),ts.toString())){
				isPass = false;
				break;
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


}
