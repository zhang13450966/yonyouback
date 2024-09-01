
package nccloud.api.pu.order_cjmmanage.order_cjmmaster;

import java.lang.reflect.Field;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.lang.StringBuilder;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.HashMap;

import org.json.JSONString;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import nccloud.ws.rest.resource.AbstractNCCRestResource;
import nccloud.api.rest.utils.ResultMessageUtil;
import nccloud.commons.lang.ArrayUtils;
import nccloud.commons.lang.StringUtils;
import nc.bs.framework.common.NCLocator;
import nc.vo.pub.JavaType;
import nc.vo.pub.IAttributeMeta;
import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;
import nc.vo.pub.VOStatus;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.lang.UFDate;
import nc.vo.pub.lang.UFDateTime;
import nc.vo.pub.lang.UFDouble;
import nc.vo.pub.lang.UFLiteralDate;
import nc.vo.pub.lang.UFTime;
import nc.vo.pu.order_cjm.Order_cjmSlave0VO;
import nc.vo.pu.order_cjm.Order_cjmMasterVO;
import nc.vo.pu.order_cjm.AggOrder_cjmMasterVO;
import nc.itf.pu.order_cjm.order_cjmmaster.IOrder_cjmMasterVOService;

@Path("pu/order_cjmmanage/order_cjmMaster")
public class Order_cjmMasterManageResources extends AbstractNCCRestResource {

	private Map<String, String> fieldsNameAndType = new HashMap<>();

	private Map<String, Map<String, String>> bodyFieldsNameAndTypes = new HashMap<>();

	@Override
	public String getModule() {
		return "pu";
	}
	
	@POST
	@Path("/addAggOrder_cjmMasterVO")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public JSONString addAggOrder_cjmMasterVO(JSONString json) {
		return dealJson(json, "addAggOrder_cjmMasterVO");
	}
	
	@POST
	@Path("/deleteAggOrder_cjmMasterVO")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public JSONString deleteAggOrder_cjmMasterVO(JSONString json) {
		return dealJson(json, "deleteAggOrder_cjmMasterVO");
	}
	
	@POST
	@Path("/updateAggOrder_cjmMasterVO")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public JSONString updateAggOrder_cjmMasterVO(JSONString json) {
		return dealJson(json, "updateAggOrder_cjmMasterVO");
	}
	
	@POST
	@Path("/queryAggOrder_cjmMasterVO")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public JSONString queryAggOrder_cjmMasterVO(JSONString json) {
		return dealJson(json, "queryAggOrder_cjmMasterVO");
	}
	
	private JSONString dealJson(JSONString json, String methodName) {
		if(json == null) {
			return ResultMessageUtil.exceptionToJSON(new NullPointerException("输入参数不能为空！"));
		}
		JSONObject obj = JSON.parseObject(json.toJSONString());
		if(methodName.indexOf("add") >= 0) {
			StringBuilder builder = requiredFieldsValidate(obj);
			if(builder.length() > 0) {
				String addError = "新增时必输项存在空值，为空的必输项有：" + builder.deleteCharAt(builder.length() - 1).toString();
				return ResultMessageUtil.exceptionToJSON(new NullPointerException(addError));
			} else {
				// 调用接口新增
				AggOrder_cjmMasterVO vo = buildVO(obj, true);
				AggOrder_cjmMasterVO[] result = null;
				try{
					result = getService().saveAggOrder_cjmMasterVO(vo);
				} catch(BusinessException e) {
					return ResultMessageUtil.exceptionToJSON(e);
				}
				JSONObject returnJson = new JSONObject();
				returnJson.put("result", result);
				return ResultMessageUtil.toJSON(returnJson);
			}				
		} else if(methodName.indexOf("delete") >= 0) {
			String entityPk = obj.getString("pk_order_cjmmaster");
			if(StringUtils.isEmpty(entityPk)) {
				return ResultMessageUtil.exceptionToJSON(new NullPointerException("删除时主键为必输项，不能为空！"));
			}
			// 删除需要区分全局、集团和业务单元
			String pk_org = obj.getString("pk_org");
			// 如果没有传pk_org, 默认是全局
			if(StringUtils.isEmpty(pk_org)) {
				pk_org = "GLOBLE00000000000000";
			}
			// 调用接口删除
			JSONObject returnJson = new JSONObject();
			Map<String, String> tsMap = new HashMap<>();
			Order_cjmMasterVO[] vos = null;
			try {
			vos = getService().listOrder_cjmMasterVOByPk(entityPk);
			} catch (BusinessException e) {
				ResultMessageUtil.exceptionToJSON(e);
			}
			if(ArrayUtils.isNotEmpty(vos)) {
				tsMap.put(vos[0].getAttributeValue("pk_order_cjmmaster").toString(), vos[0].getTs().toString());
			}
			AggOrder_cjmMasterVO[] result = null;
			try {
				result = getService().deleteAggOrder_cjmMasterVOs(tsMap);
			} catch (BusinessException e) {
				ResultMessageUtil.exceptionToJSON(e);
			}
			returnJson.put("result", result);
			return ResultMessageUtil.toJSON(returnJson);
		} else if(methodName.indexOf("update") >= 0) {
			JSONObject object = (JSONObject)obj.get("order_cjmMaster");
			String entityPk = object.getString("pk_order_cjmmaster");
			if(StringUtils.isEmpty(entityPk)) {
				return ResultMessageUtil.exceptionToJSON(new NullPointerException("修改时主键为必输项，不能为空！"));
			}
			StringBuilder builder = requiredFieldsValidate(obj);
			if(builder.length() > 0) {
				String updateError = "修改时必输项存在空值，为空的必输项有：" + builder.deleteCharAt(builder.length() - 1).toString();
				return ResultMessageUtil.exceptionToJSON(new NullPointerException(updateError));
			} else {
				// 调用接口修改
				AggOrder_cjmMasterVO vo = buildVO(obj, false);
				AggOrder_cjmMasterVO[] result = null;
				JSONObject returnJson = new JSONObject();
				try{
					result = getService().saveAggOrder_cjmMasterVO(vo);
				} catch(BusinessException e) {
					return ResultMessageUtil.exceptionToJSON(e);
				}
				returnJson.put("result", result);
				return ResultMessageUtil.toJSON(returnJson);
			}		
		} else if(methodName.indexOf("query") >= 0) {
			// 查询时需要接收业务单元作为参数吗？
			StringBuilder sqlBuilder = new StringBuilder(" isnull(dr, 0) = 0");
			Set<Entry<String, Object>> entrySet = obj.entrySet();
			Iterator<Entry<String, Object>> iterator = entrySet.iterator();
			while(iterator.hasNext()) {
				Entry<String, Object> entry = iterator.next();
				if(entry.getValue() != null) {
					sqlBuilder.append(" and " + entry.getKey() + "='" + entry.getValue() + "'");
				}
			}
			AggOrder_cjmMasterVO[] results = null;
			try {
			results = getService().listAggOrder_cjmMasterVOByCondition(sqlBuilder.toString());
			} catch (BusinessException e) {
				return ResultMessageUtil.exceptionToJSON(e);
			}
			JSONObject returnJson = new JSONObject();
			returnJson.put("result", results);
			return ResultMessageUtil.toJSON(returnJson);
		}
		return null;
	}
	
	private StringBuilder requiredFieldsValidate(JSONObject obj) {
		StringBuilder builder = new StringBuilder();
		List<String> notNullFields = getRequiredFields(obj);
		JSONObject object = (JSONObject)obj.get("order_cjmMaster");
		for(String notNullField : notNullFields) {
			Object val = object.get(notNullField);
			if(val == null){
				builder.append(notNullField + ",");
			}
		}
		return builder;
	}

	private AggOrder_cjmMasterVO buildVO(JSONObject json, boolean isAdd) {
		if(json.get("order_cjmMaster") == null) {
			throw new NullPointerException("传入参数中不存在主实体数据！");
		}
		int voStatus = isAdd ? VOStatus.NEW : VOStatus.UPDATED;
		AggOrder_cjmMasterVO aggVO = new AggOrder_cjmMasterVO();

		// 主实体
		JSONObject headJson = (JSONObject) json.get("order_cjmMaster");
		Order_cjmMasterVO headVO = new Order_cjmMasterVO();
		IAttributeMeta[] headAttrs = headVO.getMetaData().getAttributes();
		for (IAttributeMeta attribute : headAttrs) {
			Object value = getValueByAttr(headJson, attribute);
			headVO.setAttributeValue(attribute.getName(), value);
		}
		headVO.setStatus(voStatus);
		aggVO.setParent(headVO);

		// 子实体
		JSONArray order_cjmSlave0VOArr = json.getJSONArray("order_cjmslave0_order_cjmslave0");
		if (order_cjmSlave0VOArr != null && !order_cjmSlave0VOArr.isEmpty()) {
			Order_cjmSlave0VO[] order_cjmSlave0VOs = new Order_cjmSlave0VO[order_cjmSlave0VOArr.size()];
			IAttributeMeta[] bodyAttrs = new Order_cjmSlave0VO().getMetaData().getAttributes();
			for (int i = 0; i < order_cjmSlave0VOArr.size(); i++) {
				JSONObject order_cjmSlave0VOJson = (JSONObject) order_cjmSlave0VOArr.get(i);
				order_cjmSlave0VOs[i] = new Order_cjmSlave0VO();
				for (IAttributeMeta attribute : bodyAttrs) {
					Object value = getValueByAttr(order_cjmSlave0VOJson, attribute);
					order_cjmSlave0VOs[i].setAttributeValue(attribute.getName(), value);
				}
				order_cjmSlave0VOs[i].setStatus(voStatus);

			}
			aggVO.setChildren(Order_cjmSlave0VO.class, order_cjmSlave0VOs);
		}
		return aggVO;
	}

	private Object getValueByAttr(JSONObject json, IAttributeMeta attribute) {
		Object value = json.get(attribute.getName());
		if (value == null || StringUtils.isEmpty(value.toString())) {
			return null;
		}
		JavaType javaType = attribute.getJavaType();
		switch (javaType) {
			case String:
			case UFStringEnum:
				return value.toString();
			case BigDecimal:
				return new BigDecimal(value.toString());
			case Integer:
			case UFFlag:
				return Integer.valueOf(value.toString());
			case UFDouble:
				return new UFDouble(value.toString());
			case UFBoolean:
				return new UFBoolean(value.toString());
			case UFDate:
				return new UFDate(value.toString());
			case UFDateTime:
				return new UFDateTime(value.toString());
			case UFTime:
				return new UFTime(value.toString());
			case UFLiteralDate:
				return new UFLiteralDate(value.toString());
			default:
				return value;
		}
	}

	private List<String> getRequiredFields(JSONObject obj) {
		List<String> notNullFields = new ArrayList<String>();
		return notNullFields;
	}
	
	private IOrder_cjmMasterVOService getService() {
		return NCLocator.getInstance().lookup(IOrder_cjmMasterVOService.class);
	}
	
}

