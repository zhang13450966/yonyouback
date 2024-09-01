package nc.impl.pu.region_cjm.region_cjmmaster;

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


import nc.vo.pu.region_cjm.Region_CjmMasterVO;
import nc.itf.pu.region_cjm.region_cjmmaster.IRegion_CjmMasterVOService;


import nc.bs.framework.common.InvocationInfoProxy;
import nc.vo.util.BDPKLockUtil;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.util.BDAuditInfoUtil;
import nc.vo.util.BDVersionValidationUtil;
import nc.bs.uif2.validation.IValidationService;
import nc.bs.uif2.validation.ValidationException;
import nc.bs.uif2.validation.ValidationFrameworkUtil;
import nc.vo.bd.pub.SingleDistributedUpdateValidator;
import nc.vo.bd.pub.IPubEnumConst;
import nccloud.framework.core.exception.ExceptionUtils;

public class  Region_CjmMasterVOServiceImpl extends ServiceSupport implements IRegion_CjmMasterVOService {


	@Override
	public Region_CjmMasterVO[] listRegion_CjmMasterVOByPk(String[] pks,  boolean blazyLoad) throws BusinessException{
		return dao.listByPk(Region_CjmMasterVO.class, pks, blazyLoad);
	}

	@Override
	public  Region_CjmMasterVO findRegion_CjmMasterVOByPk(String pk, boolean blazyLoad) throws BusinessException{
		return dao.findByPk(Region_CjmMasterVO.class, pk, blazyLoad);
	}

	@Override
	public  Region_CjmMasterVO[] listRegion_CjmMasterVOByPk(String condition, boolean blazyLoad) throws BusinessException{
		return dao.listByCondition(Region_CjmMasterVO.class, condition, blazyLoad);
	}
	@Override
	public String[] listRegion_CjmMasterVOPkByCond(String condition) throws BusinessException{
		return listRegion_CjmMasterVOPkByCond(condition,new String[]{"pk_region_cjmmaster"});
	}
	@Override
	public String[] listRegion_CjmMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException{
		if(StringUtils.isEmpty(condition)) {
			condition = " 1 = 1 ";
		}
		StringBuilder sql = new StringBuilder();
		sql.append(" select pk_region_cjmmaster from ").append(Region_CjmMasterVO.getDefaultTableName());
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
	public void initDefaultData(Region_CjmMasterVO vo){
		if(vo.getAttributeValue("pk_group") == null){
			vo.setAttributeValue("pk_group",InvocationInfoProxy.getInstance().getGroupId());
		}
		vo.setAttributeValue("enablestate", IPubEnumConst.ENABLESTATE_ENABLE);
	}
	@Override
	public Region_CjmMasterVO preAddRegion_CjmMasterVO(Region_CjmMasterVO vo,Map<String,Object> userJson) throws BusinessException{

		getMainVO(vo).setStatus(VOStatus.NEW);
		initDefaultData((Region_CjmMasterVO)getMainVO(vo));

		//�������Ҫ�ж��Ƿ������������
		Map<String,String> data = userJson!=null && userJson.get("data") != null?(Map<String,String>)userJson.get("data"):null;
		if(data!=null && data.size()>0){
			String parentKey = data.get("parentKey");
			String parentPk = data.get("parentPk");
			getMainVO(vo).setAttributeValue(parentKey,parentPk);
		}


		return vo;
	}
	@Override
	public Region_CjmMasterVO preAddRegion_CjmMasterVO(Map<String,Object> userJson) throws BusinessException{
		Region_CjmMasterVO result = null;

		Region_CjmMasterVO mainvo = new Region_CjmMasterVO();
		//����Ĭ��ֵ
		initDefaultData(mainvo);
		result = mainvo;
		return preAddRegion_CjmMasterVO(result,userJson);
	}

	@Override
	public Region_CjmMasterVO preEditRegion_CjmMasterVO(String pk) throws BusinessException{
		return dao.findByPk(Region_CjmMasterVO.class, pk, false);
	}

	@Override
	public Region_CjmMasterVO copyRegion_CjmMasterVO(String pk) throws BusinessException{

		Region_CjmMasterVO vo = dao.findByPk(Region_CjmMasterVO.class, pk, false);

		getMainVO(vo).setPrimaryKey(null);
		getMainVO(vo).setStatus(VOStatus.NEW);

		getMainVO(vo).setAttributeValue("srcbilltype",null);
		getMainVO(vo).setAttributeValue("srcbillid",null);

	    getMainVO(vo).setAttributeValue("enablestate", new Integer(2));
		getMainVO(vo).setAttributeValue("code",null);
		getMainVO(vo).setAttributeValue("",null);
		getMainVO(vo).setAttributeValue("name",null);
		getMainVO(vo).setAttributeValue("", new UFDateTime(InvocationInfoProxy.getInstance().getBizDateTime()));

		return vo;
	}
	@Override
	public Region_CjmMasterVO[] saveRegion_CjmMasterVO(Region_CjmMasterVO vo) throws BusinessException{
		String pk = getVOPrimaryKey(vo);
		setDefaultVal(vo);
		if(StringUtils.isEmpty(pk)){
			return dao.insert(vo); //����
		}else{
			return dao.update(vo); //����
		}
	}
	/**
	 * ����ǰ���������Ϣ
	 * @param vos
	 */
	private void setAuditInfo(Region_CjmMasterVO... vos) throws BusinessException {
		if(ArrayUtils.isNotEmpty(vos)) {
			UFDateTime now = new UFDateTime();
			for(Region_CjmMasterVO vo : vos) {
				String pk = getVOPrimaryKey(vo);
				if(StringUtils.isEmpty(pk)){
					//���ô����˴���ʱ��
					getMainVO(vo).setAttributeValue("creator",InvocationInfoProxy.getInstance().getUserId());
					getMainVO(vo).setAttributeValue("creationtime",now);
					getMainVO(vo).setAttributeValue("",now);
					getMainVO(vo).setAttributeValue("modifier",null);
					getMainVO(vo).setAttributeValue("modifiedtime",null);
				}else{
					//�����޸����޸�ʱ��
					getMainVO(vo).setAttributeValue("modifier",InvocationInfoProxy.getInstance().getUserId());
					getMainVO(vo).setAttributeValue("modifiedtime",now);
					getMainVO(vo).setAttributeValue("",now);
				}
			}
		}
	}
	/**
	 * ����ǰ����һЩĬ��ֵ
	 * @param vos
	 */
	private void setDefaultVal(Region_CjmMasterVO... vos) throws BusinessException {
		setAuditInfo(vos);
		//����Ĭ��ֵ����
	}

	// �������б༭����������
	@Override
	public Region_CjmMasterVO[] saveRegion_CjmMasterVO(Region_CjmMasterVO[] vos) throws BusinessException {
		if (ArrayUtils.isEmpty(vos)) {
			return new Region_CjmMasterVO[0];
		}
		setDefaultVal(vos); // ����Ĭ��ֵ
		return dao.save(vos,true);
	}

	@Override
	public Region_CjmMasterVO[] deleteRegion_CjmMasterVOs(Map<String,String> tsMap) throws BusinessException{
		Region_CjmMasterVO[] vos = dao.listByPk(Region_CjmMasterVO.class,tsMap.keySet().toArray(new String[0]));
		validate(vos,tsMap);
		dao.delete(vos,true);
		return vos;
	}
	
	//У��  ����tsУ��  ���ύУ��
	private void validate(Region_CjmMasterVO[] vos,Map<String,String> tsMap) throws BusinessException{

		Boolean isPass = true;
		String error = "";    //������Ϣ
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
			throw new BusinessException("�������������ѱ������޸Ļ�ɾ������ˢ�º����ԣ�");
		}
		if(!"".equals(error)){
			throw new BusinessException(error);
		}
	}
	
	@Override
	public <T> T[] loadTreeData(Class<T> clazz,Map<String,Object> userJson) throws BusinessException{
		String condition = "dr = 0 ";
		String showOff = (String)userJson.get("showOff");
		if("Y".equals(showOff)){
			condition = condition + " and enablestate = '2' ";
		}
		return dao.listByCondition(clazz, condition, false);
	}


	/**
	 * 	������������
	 *
	 * @throws BusinessException
	 * */
	@Override
	public void batchEnable(Region_CjmMasterVO[] vos) throws BusinessException{
		
			Object pid = getMainVO(vos[0]).getAttributeValue("pid");
			if(pid!=null && !String.valueOf(pid).equals("root") && !String.valueOf(pid).equals("~")){
				String parent_id = String.valueOf(pid);
				Region_CjmMasterVO parentVO = dao.findByPk(Region_CjmMasterVO.class, parent_id, false);
				if(parentVO != null){
					Integer parentEnable = (Integer)(getMainVO(parentVO).getAttributeValue("enablestate"));
					if(IPubEnumConst.ENABLESTATE_ENABLE != parentEnable){
						throw new BusinessException("�ϼ�δ���ã���ǰ���ڵ㲻�������ã�");
					}
				}
			}
	
		for(Region_CjmMasterVO vo : vos) {
			enable(vo);
		}
	}

	/**
	 * 	��������
	 *
	 * @throws BusinessException
	 * */
	private void enable(Region_CjmMasterVO vo) throws BusinessException {
		SuperVO headVO = getMainVO(vo);
		bdlockOperate(headVO);
		versionValidate(headVO);
		enableValidate(headVO);
		// �����Ϣ
		BDAuditInfoUtil.updateData(headVO);
		vo.setAttributeValue("enablestate", IPubEnumConst.ENABLESTATE_ENABLE);
		dao.update(vo);
	}

	/**
	 * 	��������ͣ��
	 *
	 * @throws BusinessException
	 * */
	@Override
	public void batchDisable(Region_CjmMasterVO[] vos) throws BusinessException{
	
			String pk = (String)(getMainVO(vos[0]).getAttributeValue("pk_region_cjmmaster"));
			
			String condition = " pid='"+pk+"' and enablestate = '2' ";
			Region_CjmMasterVO[] disabledChilds = dao.listByCondition(Region_CjmMasterVO.class,condition);
			if(disabledChilds!=null && disabledChilds.length>0){
				throw new BusinessException("����δͣ�õ��¼�����ǰ���ڵ㲻����ͣ�ã�");
			}
		for(Region_CjmMasterVO vo : vos) {
			disable(vo);
		}
	}

	/**
	 * 	����ͣ��
	 *
	 * @throws BusinessException
	 * */
	private void disable(Region_CjmMasterVO vo) throws BusinessException {
		SuperVO headVO = getMainVO(vo);
		bdlockOperate(headVO);
		versionValidate(headVO);
		enableValidate(headVO);
		// �����Ϣ
		BDAuditInfoUtil.updateData(headVO);
		headVO.setAttributeValue("enablestate",IPubEnumConst.ENABLESTATE_DISABLE);
		headVO.setAttributeValue("enablestate",new Integer(3));
		dao.update(vo);
	}

	/**
	 * 	������
	 *
	 * @throws BusinessException
	 * */
	private void bdlockOperate(SuperVO vo) throws BusinessException {
		BDPKLockUtil.lockSuperVO(vo);
	}

	/**
	 *	�汾У��
	 *
	 * @throws BusinessException
	 * */
	private void versionValidate(SuperVO vo) throws BusinessException {
		BDVersionValidationUtil.validateSuperVO(vo);
	}

	/**
	 *	ҵ��У��
	 *
	 * @throws BusinessException
	 * */
	private void enableValidate(SuperVO vo) throws ValidationException {
		IValidationService vService = ValidationFrameworkUtil
				.createValidationService(new SingleDistributedUpdateValidator());
		vService.validate(vo);
	}
}
