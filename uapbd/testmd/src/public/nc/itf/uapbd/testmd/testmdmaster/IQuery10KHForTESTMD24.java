package nc.itf.uapbd.testmd.testmdmaster;

import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.vo.pub.BusinessException;
import nc.vo.bd.cust.pf.AggCustomerPfVO;

/**
 * ת����ѯ����
 * 
 * @since 
 * @version  
 */
public interface IQuery10KHForTESTMD24 {

  /**
   * ת����ѯ����ͨ����ѯ�������в�ѯ��
   * 
   * @param queryScheme
   * @return AggCustomerPfVO[]
   * @throws BusinessException
   */
  public AggCustomerPfVO[] queryByScheme(IQueryScheme queryScheme)  throws BusinessException;
  
  /**
   *  ת����ѯ����ͨ��sql�����в�ѯ��
   * 
   * @param queryScheme
   * @return AggCustomerPfVO[]
   * @throws BusinessException
   */
  public AggCustomerPfVO[] queryBySQL(String sql)  throws BusinessException;
}
