
package nc.itf.uapbd.patient.patientmaster;

import java.util.Map;

import nc.vo.pub.BusinessException;

import nc.vo.uapbd.patient.AggPatientMasterVO;
import nc.vo.uapbd.patient.PatientMasterVO;

public interface  IPatientMasterVOService{

	/**
	 * ��ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggPatientMasterVO[] listAggPatientMasterVOByPk(String... pks) throws BusinessException;
	
	/**
	 * ��ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public AggPatientMasterVO[] listAggPatientMasterVOByPk(boolean blazyLoad,String... pks) throws BusinessException;
	
	/**
	 * ��ʵ���AGGVO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  AggPatientMasterVO findAggPatientMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * ��ʵ���AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  AggPatientMasterVO[] listAggPatientMasterVOByCondition(String condition) throws BusinessException;
	
	/**
	 * ��ʵ���AGGVO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @param orderPath ���򼯺�
	 * @return �������
	 */
	public  AggPatientMasterVO[] listAggPatientMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;
	
	/**
	 * ��ʵ�������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk����
	 * @return �������
	 */
	public PatientMasterVO[] listPatientMasterVOByPk(String...pks) throws BusinessException;
	
	/**
	 * ��ʵ�������VO��ѯ����
	 * ��������������ѯAgg����
	 * @param pk ����
	 * @return �������
	 */
	public  PatientMasterVO findPatientMasterVOByPk(String pk) throws BusinessException;
	
	/**
	 * ��ʵ�������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  PatientMasterVO[] listPatientMasterVOByCondition(String condition) throws BusinessException;
	/**
	 * ��ʵ�������VO��ѯ����
	 * ���������ַ�����ѯAgg����
	 * @param condition ����
	 * @return �������
	 */
	public  PatientMasterVO[] listPatientMasterVOByCondition(String condition,String[] orderPath) throws BusinessException;

	/**
	 * ��ʵ�������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listPatientMasterVOPkByCond(String condition) throws BusinessException;
	
	/**
	 * ��ʵ�������pk��ѯ����
	 * ���������ַ�����ѯpk��������
	 * @param condition ��ѯ����+
	 * @return �������
	 */
	public String[] listPatientMasterVOPkByCond(String condition,String[] orderPath) throws BusinessException;
	/**
	 * ����ʵ��vo����Ĭ��ֵ
	 * @param vo
	 */
	public void initDefaultData(PatientMasterVO vo);
	
	
	/**
	 * Ԥ����������ʵ������
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggPatientMasterVO preAddAggPatientMasterVO(Map<String,Object> userJson) throws BusinessException;
	
	public AggPatientMasterVO preAddAggPatientMasterVO(AggPatientMasterVO vo,Map<String,Object> userJson) throws BusinessException;
	 /**
	 * Ԥ�༭������ʵ������
	 * @param userJson  ����ʱ��Ҫ����չ��������
	 */
	public AggPatientMasterVO preEditAggPatientMasterVO(String pk) throws BusinessException;
	
	 /**
	 * ���Ʋ�����ʵ������
	 * 
	 */
	public AggPatientMasterVO copyAggPatientMasterVO(String pk) throws BusinessException;
	/**
	 * ���������ʵ������
	 * @param vos �������
	 * @return @
	 */
	public AggPatientMasterVO[] saveAggPatientMasterVO(AggPatientMasterVO vo) throws BusinessException;

	public AggPatientMasterVO[] saveAggPatientMasterVO(AggPatientMasterVO[] vos) throws BusinessException;
	
	
	/**
	 * ɾ��������ʵ������
	 * @param vos ɾ������
	 * @return @
	 */
	public AggPatientMasterVO[] deleteAggPatientMasterVOs(Map<String,String> tsMap) throws BusinessException;
	
	/**
	 * ����������������ʵ��
	 * @param vos ����
	 * @return @
	 */
	public <T> T[] loadTreeData(Class<T> clazz,Map<String,Object> userJson) throws BusinessException;


}