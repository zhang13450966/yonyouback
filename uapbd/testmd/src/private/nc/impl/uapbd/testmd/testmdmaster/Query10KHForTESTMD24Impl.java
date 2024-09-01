package nc.impl.uapbd.testmd.testmdmaster;

import nc.vo.pub.BusinessException;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
import nc.codeplatform.framework.service.ServiceSupport;
import nc.ui.querytemplate.querytree.IQueryScheme;
import nc.vo.bd.cust.pf.AggCustomerPfVO;
import nc.itf.uapbd.testmd.testmdmaster.IQuery10KHForTESTMD24;

/**
 *
 * 
 * @version 
 * @since ncc
 * @author nccsys
 * @time 
 */
 
public class Query10KHForTESTMD24Impl  extends ServiceSupport  implements IQuery10KHForTESTMD24{

  /**
   * 查询方法
   * 
   * @throws BusinessException 
   */
  @Override
  public AggCustomerPfVO[] queryByScheme(IQueryScheme scheme)
      throws BusinessException {
    try {
      String whereSQL =  scheme == null||scheme.getWhereSQLOnly()==null  ? " isnull(bd_customer_pf.dr,0)=0 " : scheme.getWhereSQLOnly()+" and isnull(bd_customer_pf.dr,0)=0 ";
      
      whereSQL+=" and bd_customer_pf.pk_billtype='10KH' ";
      AggCustomerPfVO[] vos=queryBySQL(whereSQL);
      return vos;
    }
    catch (Exception e) {
      ExceptionUtils.marsh(e);
    }
    return null;
  }
  
  /**
   * 查询方法
   * @throws BusinessException 
   */
  @Override
  public AggCustomerPfVO[] queryBySQL(String sql)
      throws BusinessException {
    try { 
      AggCustomerPfVO[] vos=this.dao.listByCondition(AggCustomerPfVO.class, sql);
      return vos;
    }
    catch (Exception e) {
      ExceptionUtils.marsh(e);
    }
    return null;
  }
  

}

