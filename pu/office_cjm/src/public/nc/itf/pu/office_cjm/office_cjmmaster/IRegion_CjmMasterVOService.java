package nc.itf.pu.office_cjm.office_cjmmaster;

import nc.vo.pub.BusinessException;
import nc.vo.pu.region_cjm.Region_CjmMasterVO;
/**
 * ���������� �ӿ�
 */
public interface  IRegion_CjmMasterVOService {


	/**
	 * loadtree
	 */
	public Region_CjmMasterVO[] loadTreeData(String appcode) throws BusinessException;


	/**
	 * ��ȡ�¼�pks
	 */
	public String[] getLowerLevelPks(String pk) throws BusinessException;

}