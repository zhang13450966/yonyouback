
package nccloud.api.uapbd.testmdmanage.testmdmaster;

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
import nc.vo.testmd.testmd.TestmdSlave0VO;
import nc.vo.testmd.testmd.TestmdMasterVO;
import nc.vo.testmd.testmd.AggTestmdMasterVO;
import nc.itf.uapbd.testmd.testmdmaster.ITestmdMasterVOService;

@Path("uapbd/testmdmanage/testmdMaster")
public class TestmdMasterManageResources extends AbstractNCCRestResource {

	private Map<String, String> fieldsNameAndType = new HashMap<>();

	private Map<String, Map<String, String>> bodyFieldsNameAndTypes = new HashMap<>();

	@Override
	public String getModule() {
		return "uapbd";
	}
	
	@POST
	@Path("/addAggTestmdMasterVO")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public JSONString addAggTestmdMasterVO(JSONString json) {
		return dealJson(json, "addAggTestmdMasterVO");
	}
	
	@POST
	@Path("/deleteAggTestmdMasterVO")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public JSONString deleteAggTestmdMasterVO(JSONString json) {
		return dealJson(json, "deleteAggTestmdMasterVO");
	}
	
	@POST
	@Path("/updateAggTestmdMasterVO")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public JSONString updateAggTestmdMasterVO(JSONString json) {
		return dealJson(json, "updateAggTestmdMasterVO");
	}
	
	@POST
	@Path("/queryAggTestmdMasterVO")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public JSONString queryAggTestmdMasterVO(JSONString json) {
		return dealJson(json, "queryAggTestmdMasterVO");
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
				AggTestmdMasterVO vo = buildVO(obj, true);
				AggTestmdMasterVO[] result = null;
				try{
					result = getService().saveAggTestmdMasterVO(vo);
				} catch(BusinessException e) {
					return ResultMessageUtil.exceptionToJSON(e);
				}
				JSONObject returnJson = new JSONObject();
				returnJson.put("result", result);
				return ResultMessageUtil.toJSON(returnJson);
			}				
		} else if(methodName.indexOf("delete") >= 0) {
			String entityPk = obj.getString("pk_testmdmaster");
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
			TestmdMasterVO[] vos = null;
			try {
			vos = getService().listTestmdMasterVOByPk(entityPk);
			} catch (BusinessException e) {
				ResultMessageUtil.exceptionToJSON(e);
			}
			if(ArrayUtils.isNotEmpty(vos)) {
				tsMap.put(vos[0].getAttributeValue("pk_testmdmaster").toString(), vos[0].getTs().toString());
			}
			AggTestmdMasterVO[] result = null;
			try {
				result = getService().deleteAggTestmdMasterVOs(tsMap);
			} catch (BusinessException e) {
				ResultMessageUtil.exceptionToJSON(e);
			}
			returnJson.put("result", result);
			return ResultMessageUtil.toJSON(returnJson);
		} else if(methodName.indexOf("update") >= 0) {
			JSONObject object = (JSONObject)obj.get("testmdMaster");
			String entityPk = object.getString("pk_testmdmaster");
			if(StringUtils.isEmpty(entityPk)) {
				return ResultMessageUtil.exceptionToJSON(new NullPointerException("修改时主键为必输项，不能为空！"));
			}
			StringBuilder builder = requiredFieldsValidate(obj);
			if(builder.length() > 0) {
				String updateError = "修改时必输项存在空值，为空的必输项有：" + builder.deleteCharAt(builder.length() - 1).toString();
				return ResultMessageUtil.exceptionToJSON(new NullPointerException(updateError));
			} else {
				// 调用接口修改
				AggTestmdMasterVO vo = buildVO(obj, false);
				AggTestmdMasterVO[] result = null;
				JSONObject returnJson = new JSONObject();
				try{
					result = getService().saveAggTestmdMasterVO(vo);
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
			AggTestmdMasterVO[] results = null;
			try {
			results = getService().listAggTestmdMasterVOByCondition(sqlBuilder.toString());
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
		JSONObject object = (JSONObject)obj.get("testmdMaster");
		for(String notNullField : notNullFields) {
			Object val = object.get(notNullField);
			if(val == null){
				builder.append(notNullField + ",");
			}
		}
		return builder;
	}

	private AggTestmdMasterVO buildVO(JSONObject json, boolean isAdd) {
		if(json.get("testmdMaster") == null) {
			throw new NullPointerException("传入参数中不存在主实体数据！");
		}
		int voStatus = isAdd ? VOStatus.NEW : VOStatus.UPDATED;
		AggTestmdMasterVO aggVO = new AggTestmdMasterVO();

		// 主实体
		JSONObject headJson = (JSONObject) json.get("testmdMaster");
		TestmdMasterVO headVO = new TestmdMasterVO();
		IAttributeMeta[] headAttrs = headVO.getMetaData().getAttributes();
		for (IAttributeMeta attribute : headAttrs) {
			Object value = getValueByAttr(headJson, attribute);
			headVO.setAttributeValue(attribute.getName(), value);
		}
		headVO.setStatus(voStatus);
		aggVO.setParent(headVO);

		// 子实体
		JSONArray testmdSlave0VOArr = json.getJSONArray("testmdslave0_testmdslave0");
		if (testmdSlave0VOArr != null && !testmdSlave0VOArr.isEmpty()) {
			TestmdSlave0VO[] testmdSlave0VOs = new TestmdSlave0VO[testmdSlave0VOArr.size()];
			IAttributeMeta[] bodyAttrs = new TestmdSlave0VO().getMetaData().getAttributes();
			for (int i = 0; i < testmdSlave0VOArr.size(); i++) {
				JSONObject testmdSlave0VOJson = (JSONObject) testmdSlave0VOArr.get(i);
				testmdSlave0VOs[i] = new TestmdSlave0VO();
				for (IAttributeMeta attribute : bodyAttrs) {
					Object value = getValueByAttr(testmdSlave0VOJson, attribute);
					testmdSlave0VOs[i].setAttributeValue(attribute.getName(), value);
				}
				testmdSlave0VOs[i].setStatus(voStatus);

			}
			aggVO.setChildren(TestmdSlave0VO.class, testmdSlave0VOs);
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
	
	private ITestmdMasterVOService getService() {
		return NCLocator.getInstance().lookup(ITestmdMasterVOService.class);
	}
	
}

