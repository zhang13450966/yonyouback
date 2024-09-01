package nc.impl.uapbd.patient.patientmaster;

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


import nc.vo.uapbd.patient.PatientMasterVO;
import nc.vo.uapbd.patient.AggPatientMasterVO;
import nc.itf.uapbd.patient.patientmaster.IPatientMasterVOService;


import nc.bs.framework.common.InvocationInfoProxy;
import nccloud.framework.core.exception.ExceptionUtils;

public class  PatientMasterVOServiceImpl extends ServiceSupport implements IPatientMasterVOService {


	@Override
	public AggPatientMasterVO[] listAggPatientMasterVOByPk(String...pks) throws BusinessException{
		return listAggPatientMasterVOByPk(false,pks);
	}

	@Override
	public AggPatientMasterVO[] listAggPatientMasterVOByPk(boolean blazyLoad,String... pks) throws BusinessException{
		return dao.listByPksWithOrder(AggPatientMasterVO.class,pks,blazyLoad);
	}

	@Override
	public AggPatientMasterVO findAggPatientMasterVOByPk(String pk) throws BusinessException{
		return dao.findByPk(AggPatientMasterVO.class, pk, false);
	}

	@Override
	public  AggPatientMasterVO[] listAggPatientMasterVOByCondition(String condition) throws BusinessException{
		return listAggPatientMasterVOByCondition(condition,new String[]{"pk_patientmaster"});
	}
	@Override
	public  AggPatientMasterVO[] listAggPatientMasterVOByCondition(String condition,String[] orderPath) throws BusinessException{
		return dao.listByCondition(AggPatientMasterVO.class, condition, false,false,orderPath);
	}
	@Override
	public PatientMasterVO[] listPatientMasterVOByPk(String... pks) throws BusinessException{
		return dao.listByPk(PatientMasterVO.class, pks, true);
	}

	@Override
	public  PatientMasterVO findPatientMasterVOByPk(String pk) throws BusinessException{
		return dao.findByPk(PatientMasterVO.class, pk, true);
	}

	@Override
	public  PatientMasterVO[] listPatientMasterVOByCondition(String condition) throws BusinessException{
		return listPatientMasterVOByCondition(condition,new String[]{"pk_patientmaster"});
	}
	@Override
	public  PatientMasterVO[] listPatientMasterVOByCondition(String condition,String[] orderPath) throws BusinessException{
		return dao.listByCondition(PatientMasterVO.class, condition, false,false,orderPath);
	}

	@Override
	public String[] listPatientMasterVOPkByCond(String condition) throws BusinessException{
		return listPatientMasterVOPkByCond(condition,new String[]{"pk_patientmaster"});
	}
	@Override
	public String[] listPatientMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException{
		if(StringUtils.isEmpty(condition)) {
			condition = " 1 = 1 ";
		}
		StringBuilder sql = new StringBuilder();
		sql.append(" select pk_patientmaster from ").append(PatientMasterVO.getDefaultTableName());
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
	public void initDefaultData(PatientMasterVO vo){
		if(vo.getAttributeValue("pk_group") == null){
			vo.setAttributeValue("pk_group",InvocationInfoProxy.getInstance().getGroupId());
		}
	}
	@Override
	public AggPatientMasterVO preAddAggPatientMasterVO(AggPatientMasterVO vo,Map<String,Object> userJson) throws BusinessException{

		getMainVO(vo).setStatus(VOStatus.NEW);
		initDefaultData((PatientMasterVO)getMainVO(vo));

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
	public AggPatientMasterVO preAddAggPatientMasterVO(Map<String,Object> userJson) throws BusinessException{
		AggPatientMasterVO result = null;

		PatientMasterVO mainvo = new PatientMasterVO();
		//����Ĭ��ֵ
		initDefaultData(mainvo);
		AggPatientMasterVO aggvo = new AggPatientMasterVO();
		aggvo.setParent(mainvo);
		result = aggvo;
		return preAddAggPatientMasterVO(result,userJson);
	}

	@Override
	public AggPatientMasterVO preEditAggPatientMasterVO(String pk) throws BusinessException{
		return dao.findByPk(AggPatientMasterVO.class, pk, false);
	}

	@Override
	public AggPatientMasterVO copyAggPatientMasterVO(String pk) throws BusinessException{

		AggPatientMasterVO vo = dao.findByPk(AggPatientMasterVO.class, pk, false);

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
	public AggPatientMasterVO[] saveAggPatientMasterVO(AggPatientMasterVO vo) throws BusinessException{
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
	private void setAuditInfo(AggPatientMasterVO... vos) throws BusinessException {
		if(ArrayUtils.isNotEmpty(vos)) {
			UFDateTime now = new UFDateTime();
			for(AggPatientMasterVO vo : vos) {
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
	private void setDefaultVal(AggPatientMasterVO... vos) throws BusinessException {
		setAuditInfo(vos);
		//����Ĭ��ֵ����
	}

	// �������б༭����������
	@Override
	public AggPatientMasterVO[] saveAggPatientMasterVO(AggPatientMasterVO[] vos) throws BusinessException {
		if (ArrayUtils.isEmpty(vos)) {
			return new AggPatientMasterVO[0];
		}
		setDefaultVal(vos); // ����Ĭ��ֵ
		return dao.save(vos,true);
	}

	@Override
	public AggPatientMasterVO[] deleteAggPatientMasterVOs(Map<String,String> tsMap) throws BusinessException{
		AggPatientMasterVO[] vos = dao.listByPk(AggPatientMasterVO.class,tsMap.keySet().toArray(new String[0]));
		validate(vos,tsMap);
		dao.delete(vos,true);
		return vos;
	}
	
	//У��  ����tsУ��  ���ύУ��
	private void validate(AggPatientMasterVO[] vos,Map<String,String> tsMap) throws BusinessException{

		Boolean isPass = true;
		String error = "";    //������Ϣ
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
		return dao.listByCondition(clazz, condition, false);
	}


}
