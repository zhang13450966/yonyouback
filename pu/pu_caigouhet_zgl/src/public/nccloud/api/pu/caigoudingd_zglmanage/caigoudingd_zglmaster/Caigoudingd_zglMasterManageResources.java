
package nccloud.api.pu.caigoudingd_zglmanage.caigoudingd_zglmaster;

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
import nc.vo.caigoudingdan.caigoudingd_zgl.Caigoudingd_zglMasterVO;
import nc.vo.caigoudingdan.caigoudingd_zgl.Caigoudingd_zglSlave0VO;
import nc.vo.caigoudingdan.caigoudingd_zgl.AggCaigoudingd_zglMasterVO;
import nc.itf.pu.caigoudingd_zgl.caigoudingd_zglmaster.ICaigoudingd_zglMasterVOService;

@Path("pu/caigoudingd_zglmanage/caigoudingd_zglMaster")
public class Caigoudingd_zglMasterManageResources extends AbstractNCCRestResource {

	private Map<String, String> fieldsNameAndType = new HashMap<>();

	private Map<String, Map<String, String>> bodyFieldsNameAndTypes = new HashMap<>();

	@Override
	public String getModule() {
		return "pu";
	}
	
	@POST
	@Path("/addAggCaigoudingd_zglMasterVO")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public JSONString addAggCaigoudingd_zglMasterVO(JSONString json) {
		return dealJson(json, "addAggCaigoudingd_zglMasterVO");
	}
	
	@POST
	@Path("/deleteAggCaigoudingd_zglMasterVO")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public JSONString deleteAggCaigoudingd_zglMasterVO(JSONString json) {
		return dealJson(json, "deleteAggCaigoudingd_zglMasterVO");
	}
	
	@POST
	@Path("/updateAggCaigoudingd_zglMasterVO")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public JSONString updateAggCaigoudingd_zglMasterVO(JSONString json) {
		return dealJson(json, "updateAggCaigoudingd_zglMasterVO");
	}
	
	@POST
	@Path("/queryAggCaigoudingd_zglMasterVO")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public JSONString queryAggCaigoudingd_zglMasterVO(JSONString json) {
		return dealJson(json, "queryAggCaigoudingd_zglMasterVO");
	}
	
	private JSONString dealJson(JSONString json, String methodName) {
		if(json == null) {
			return ResultMessageUtil.exceptionToJSON(new NullPointerException("�����������Ϊ�գ�"));
		}
		JSONObject obj = JSON.parseObject(json.toJSONString());
		if(methodName.indexOf("add") >= 0) {
			StringBuilder builder = requiredFieldsValidate(obj);
			if(builder.length() > 0) {
				String addError = "����ʱ��������ڿ�ֵ��Ϊ�յı������У�" + builder.deleteCharAt(builder.length() - 1).toString();
				return ResultMessageUtil.exceptionToJSON(new NullPointerException(addError));
			} else {
				// ���ýӿ�����
				AggCaigoudingd_zglMasterVO vo = buildVO(obj, true);
				AggCaigoudingd_zglMasterVO[] result = null;
				try{
					result = getService().saveAggCaigoudingd_zglMasterVO(vo);
				} catch(BusinessException e) {
					return ResultMessageUtil.exceptionToJSON(e);
				}
				JSONObject returnJson = new JSONObject();
				returnJson.put("result", result);
				return ResultMessageUtil.toJSON(returnJson);
			}				
		} else if(methodName.indexOf("delete") >= 0) {
			String entityPk = obj.getString("pk_cgdingdan_zglmaster");
			if(StringUtils.isEmpty(entityPk)) {
				return ResultMessageUtil.exceptionToJSON(new NullPointerException("ɾ��ʱ����Ϊ���������Ϊ�գ�"));
			}
			// ɾ����Ҫ����ȫ�֡����ź�ҵ��Ԫ
			String pk_org = obj.getString("pk_org");
			// ���û�д�pk_org, Ĭ����ȫ��
			if(StringUtils.isEmpty(pk_org)) {
				pk_org = "GLOBLE00000000000000";
			}
			// ���ýӿ�ɾ��
			JSONObject returnJson = new JSONObject();
			Map<String, String> tsMap = new HashMap<>();
			Caigoudingd_zglMasterVO[] vos = null;
			try {
			vos = getService().listCaigoudingd_zglMasterVOByPk(entityPk);
			} catch (BusinessException e) {
				ResultMessageUtil.exceptionToJSON(e);
			}
			if(ArrayUtils.isNotEmpty(vos)) {
				tsMap.put(vos[0].getAttributeValue("pk_cgdingdan_zglmaster").toString(), vos[0].getTs().toString());
			}
			AggCaigoudingd_zglMasterVO[] result = null;
			try {
				result = getService().deleteAggCaigoudingd_zglMasterVOs(tsMap);
			} catch (BusinessException e) {
				ResultMessageUtil.exceptionToJSON(e);
			}
			returnJson.put("result", result);
			return ResultMessageUtil.toJSON(returnJson);
		} else if(methodName.indexOf("update") >= 0) {
			JSONObject object = (JSONObject)obj.get("caigoudingd_zglMaster");
			String entityPk = object.getString("pk_cgdingdan_zglmaster");
			if(StringUtils.isEmpty(entityPk)) {
				return ResultMessageUtil.exceptionToJSON(new NullPointerException("�޸�ʱ����Ϊ���������Ϊ�գ�"));
			}
			StringBuilder builder = requiredFieldsValidate(obj);
			if(builder.length() > 0) {
				String updateError = "�޸�ʱ��������ڿ�ֵ��Ϊ�յı������У�" + builder.deleteCharAt(builder.length() - 1).toString();
				return ResultMessageUtil.exceptionToJSON(new NullPointerException(updateError));
			} else {
				// ���ýӿ��޸�
				AggCaigoudingd_zglMasterVO vo = buildVO(obj, false);
				AggCaigoudingd_zglMasterVO[] result = null;
				JSONObject returnJson = new JSONObject();
				try{
					result = getService().saveAggCaigoudingd_zglMasterVO(vo);
				} catch(BusinessException e) {
					return ResultMessageUtil.exceptionToJSON(e);
				}
				returnJson.put("result", result);
				return ResultMessageUtil.toJSON(returnJson);
			}		
		} else if(methodName.indexOf("query") >= 0) {
			// ��ѯʱ��Ҫ����ҵ��Ԫ��Ϊ������
			StringBuilder sqlBuilder = new StringBuilder(" isnull(dr, 0) = 0");
			Set<Entry<String, Object>> entrySet = obj.entrySet();
			Iterator<Entry<String, Object>> iterator = entrySet.iterator();
			while(iterator.hasNext()) {
				Entry<String, Object> entry = iterator.next();
				if(entry.getValue() != null) {
					sqlBuilder.append(" and " + entry.getKey() + "='" + entry.getValue() + "'");
				}
			}
			AggCaigoudingd_zglMasterVO[] results = null;
			try {
			results = getService().listAggCaigoudingd_zglMasterVOByCondition(sqlBuilder.toString());
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
		JSONObject object = (JSONObject)obj.get("caigoudingd_zglMaster");
		for(String notNullField : notNullFields) {
			Object val = object.get(notNullField);
			if(val == null){
				builder.append(notNullField + ",");
			}
		}
		return builder;
	}

	private AggCaigoudingd_zglMasterVO buildVO(JSONObject json, boolean isAdd) {
		if(json.get("caigoudingd_zglMaster") == null) {
			throw new NullPointerException("��������в�������ʵ�����ݣ�");
		}
		int voStatus = isAdd ? VOStatus.NEW : VOStatus.UPDATED;
		AggCaigoudingd_zglMasterVO aggVO = new AggCaigoudingd_zglMasterVO();

		// ��ʵ��
		JSONObject headJson = (JSONObject) json.get("caigoudingd_zglMaster");
		Caigoudingd_zglMasterVO headVO = new Caigoudingd_zglMasterVO();
		IAttributeMeta[] headAttrs = headVO.getMetaData().getAttributes();
		for (IAttributeMeta attribute : headAttrs) {
			Object value = getValueByAttr(headJson, attribute);
			headVO.setAttributeValue(attribute.getName(), value);
		}
		headVO.setStatus(voStatus);
		aggVO.setParent(headVO);

		// ��ʵ��
		JSONArray caigoudingd_zglSlave0VOArr = json.getJSONArray("cgdingdan_zglslave0_caigoudingd_zglslave0");
		if (caigoudingd_zglSlave0VOArr != null && !caigoudingd_zglSlave0VOArr.isEmpty()) {
			Caigoudingd_zglSlave0VO[] caigoudingd_zglSlave0VOs = new Caigoudingd_zglSlave0VO[caigoudingd_zglSlave0VOArr.size()];
			IAttributeMeta[] bodyAttrs = new Caigoudingd_zglSlave0VO().getMetaData().getAttributes();
			for (int i = 0; i < caigoudingd_zglSlave0VOArr.size(); i++) {
				JSONObject caigoudingd_zglSlave0VOJson = (JSONObject) caigoudingd_zglSlave0VOArr.get(i);
				caigoudingd_zglSlave0VOs[i] = new Caigoudingd_zglSlave0VO();
				for (IAttributeMeta attribute : bodyAttrs) {
					Object value = getValueByAttr(caigoudingd_zglSlave0VOJson, attribute);
					caigoudingd_zglSlave0VOs[i].setAttributeValue(attribute.getName(), value);
				}
				caigoudingd_zglSlave0VOs[i].setStatus(voStatus);

			}
			aggVO.setChildren(Caigoudingd_zglSlave0VO.class, caigoudingd_zglSlave0VOs);
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
	
	private ICaigoudingd_zglMasterVOService getService() {
		return NCLocator.getInstance().lookup(ICaigoudingd_zglMasterVOService.class);
	}
	
}

