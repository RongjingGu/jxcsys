package com.unimedsci.ydata.jxz.commons.util;

import com.sweetw.idata.commons.data.ListQueryCondition;
import com.sweetw.idata.commons.data.QueryCondition;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Params {

    private Map<String, Object> params;
    private Map<String, String> baseInfo;
    private Map<String, Object> projectQuota;
    private Map<String, String> patientStatus;
    private List<Object> arrays;
    private List<Integer> ids;
    private List<Integer> remindTime;

    private List<Integer> regionIds;

    private List<String> keywords;

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

   /*private List<SortVisitType> sortVisitTypes;

	private List<NumberCategory> numberCategorys;//统计是数值分类 范围划分*/

    private Map<String, ListQueryCondition> conditions;//指标查询条件高级搜索使用




    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public Map<String, String> getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(Map<String, String> baseInfo) {
        this.baseInfo = baseInfo;
    }

    public Map<String, Object> getProjectQuota() {
        return projectQuota;
    }

    public void setProjectQuota(Map<String, Object> projectQuota) {
        this.projectQuota = projectQuota;
    }

    public List<Object> getArrays() {
        return arrays;
    }

    public void setArrays(List<Object> arrays) {
        this.arrays = arrays;
    }


	/*public List<SortVisitType> getSortVisitTypes() {
        return sortVisitTypes;
	}

	public void setSortVisitTypes(List<SortVisitType> sortVisitTypes) {
		this.sortVisitTypes = sortVisitTypes;
	}*/

    public Map<String, ListQueryCondition> getConditions() {
        return conditions;
    }

    public void setConditions(Map<String, ListQueryCondition> conditions) {
        this.conditions = conditions;
    }

	/*public List<NumberCategory> getNumberCategorys() {
		return numberCategorys;
	}

	public void setNumberCategorys(List<NumberCategory> numberCategorys) {
		this.numberCategorys = numberCategorys;
	}*/

    public Map<String, String> getPatientStatus() {
        return patientStatus;
    }

    public void setPatientStatus(Map<String, String> patientStatus) {
        this.patientStatus = patientStatus;
    }

    private List<Map<String, Integer>> yearAndMonth;

    public List<Map<String, Integer>> getYearAndMonth() {
        return yearAndMonth;
    }

    public void setYearAndMonth(List<Map<String, Integer>> yearAndMonth) {
        this.yearAndMonth = yearAndMonth;
    }

    public String arraysToForm() {
        StringBuffer sb = new StringBuffer();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {// --for() begin
            Class fc = field.getType();
            if (fc.isAssignableFrom(List.class)) {
                // System.out.println(field.getName());
                String fieldName = field.getName();
                List list = (List) invokeMethod(this, field.getName());
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        sb.append(fieldName + "[" + i + "]=" + list.get(i) + "&");
                    }
                }
            }
        }
        return sb.toString();
    }

    public Object invokeMethod(Object owner, String fieldName) {
        String methodName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

        Class clz = owner.getClass();

        Method method = null;
        try {
            method = clz.getMethod("get" + methodName);
        } catch (SecurityException e) {
            //e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // e.printStackTrace();
            return "";
        }

        //invoke getMethod
        try {
            return method.invoke(owner);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 将当前的条件查询转换为表达式
     *
     * @return 拼凑后的表达式
     */
    public String conditionsToExpression() {
        String result = "";
        for (String key : conditions.keySet()) {
            ListQueryCondition listConditions = conditions.get(key);
            ListQueryCondition.OPER oper = listConditions.getOper();
            if (oper == null) oper = ListQueryCondition.OPER.AND;
            List<QueryCondition> listQuery = listConditions.getListConditions();
            result += "(";
            for (QueryCondition queryCondition : listQuery) {
                List<QueryCondition.Condition> conditions = queryCondition.getConditions();
                QueryCondition.LOGICOPER logicOper = queryCondition.getOper();
                if (logicOper == null) logicOper = QueryCondition.LOGICOPER.AND;
                result += "(";
                for (QueryCondition.Condition cond : conditions) {
                    result += key + cond.toString();

                    switch (logicOper) {
                        case OR:
                            result += "||";
                            break;
                        case AND:
                            result += "&&";
                            break;
                        default:
                            result += "&&";
                    }
                }
                result += "1==1)";

                switch (oper) {
                    case OR:
                        result += "||";
                        break;
                    case AND:
                        result += "&&";
                        break;
                    default:
                        result += "&&";
                }
            }
            result += "1==1)";
            result += "&&";
        }
        result += " 1==1";
        return result;
    }

    public String conditionToFrom() {
        StringBuffer buffer = new StringBuffer();
        for (String key : conditions.keySet()) {
            ListQueryCondition listCondition = conditions.get(key);
            List<QueryCondition> listConditions = listCondition.getListConditions();
            for (int i = 0; i < listConditions.size(); i++) {
                QueryCondition queryCondition = listConditions.get(i);
                List<QueryCondition.Condition> queryConditionConditions = queryCondition.getConditions();
                for (int j = 0; j < queryConditionConditions.size(); j++) {
                    QueryCondition.Condition condition = queryConditionConditions.get(j);
                    buffer = buffer.append("&conditions[").append(key).append("]");
                    buffer = buffer.append(".listConditions[").append(i).append("]");
                    buffer = buffer.append(".conditions[").append(j).append("]");
                    buffer = buffer.append(".oper=").append(condition.getOper());
                    buffer = buffer.append("&");
                    buffer = buffer.append("conditions[").append(key).append("]");
                    buffer = buffer.append(".listConditions[").append(i).append("]");
                    buffer = buffer.append(".conditions[").append(j).append("]");
                    buffer = buffer.append(".value=").append(condition.getValue());
                }
                if (queryConditionConditions.size() > 1) {
                    buffer = buffer.append("&");
                    buffer = buffer.append("conditions[").append(key).append("]");
                    buffer = buffer.append(".listConditions[").append(i).append("]");
                    buffer = buffer.append(".oper=").append(queryCondition.getOper());
                }
            }
            if (listConditions.size() > 1) {
                buffer = buffer.append("&");
                buffer = buffer.append("conditions[").append(key).append("]");
                buffer = buffer.append(".oper=").append(listCondition.getOper());
            }
        }
        return buffer.toString();
    }

    public String parseListQueryCondition(String key, ListQueryCondition listConditions) {
        String result = "";
        ListQueryCondition.OPER oper = listConditions.getOper();
        List<QueryCondition> listQuery = listConditions.getListConditions();
        for (int j = 0; j < listQuery.size(); j++) {
            QueryCondition queryCondition = listQuery.get(j);
            List<QueryCondition.Condition> conditions = queryCondition.getConditions();
            QueryCondition.LOGICOPER logicOper = queryCondition.getOper();
            for (int i = 0; i < conditions.size(); i++) {
                QueryCondition.Condition cond = conditions.get(i);
                result += key + cond.toString();
                if (logicOper != null && i < conditions.size() - 1) {
                    switch (logicOper) {
                        case OR:
                            result += "||";
                            break;
                        case AND:
                            result += "&&";
                            break;
                        default:
                            result += "&&";
                    }
                }
            }
            if (oper != null && j < listQuery.size() - 1) {
                switch (oper) {
                    case OR:
                        result += "||";
                        break;
                    case AND:
                        result += "&&";
                        break;
                    default:
                        result += "&&";
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Params params = new Params();
        List<Object> list = new ArrayList<Object>();
        list.add("abc");
        list.add("efg");
        list.add("hij");
        list.add("lmn");

        params.setArrays(list);
        System.out.println(params.arraysToForm());


    }

//    public String getParamsString() throws UnsupportedEncodingException {
//        Map<String, Object> paramsParams = getParams();
//        StringBuffer buffer = new StringBuffer();
//        if (paramsParams != null && paramsParams.size() > 0) {
//            for (String key : paramsParams.keySet()) {
//                Object value = paramsParams.get(key);
//                buffer = buffer.append("&params[").append(key).append("]=").append(URLEncoder.encode(value.toString(), Global.ENCODING_UTF_8));
//            }
//        }
//        return buffer.toString();
//    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public List<Integer> getRemindTime() {
        return remindTime;
    }

    public void setRemindTime(List<Integer> remindTime) {
        this.remindTime = remindTime;
    }



}
