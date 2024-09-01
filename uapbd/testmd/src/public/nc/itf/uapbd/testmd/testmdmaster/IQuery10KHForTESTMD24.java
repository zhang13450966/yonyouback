package nc.itf.uapbd.testmd.testmdmaster;

import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.vo.pub.BusinessException;
import nc.vo.bd.cust.pf.AggCustomerPfVO;

/**
 * 转单查询服务。
 * 
 * @since 
 * @version  
 */
public interface IQuery10KHForTESTMD24 {

  /**
   * 转单查询服务，通过查询方案进行查询。
   * 
   * @param queryScheme
   * @return AggCustomerPfVO[]
   * @throws BusinessException
   */
  public AggCustomerPfVO[] queryByScheme(IQueryScheme queryScheme)  throws BusinessException;
  
  /**
   *  转单查询服务，通过sql语句进行查询。
   * 
   * @param queryScheme
   * @return AggCustomerPfVO[]
   * @throws BusinessException
   */
  public AggCustomerPfVO[] queryBySQL(String sql)  throws BusinessException;
}
