package com.unimedsci.ydata.jxc.commons.util;


import com.alibaba.fastjson.JSONObject;
import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;


/**
 * wanglie
 * 2016.3.3 3:55:49
 */
public final class StringUtil {

    public static boolean isEmpty(Object object) {
        if (object == null) {
            return true;
        }
        String str = object instanceof String ? (String) object : object.toString();
        return str.length() == 0 || str.trim().length() == 0;
    }

    public static String sortUsingFunction(String functionName, String sortField) {
        return functionName + "(" + sortField + ")";
    }

    public static String toCamelCase(final String init, String split) {
        if (init == null)
            return null;

        final StringBuilder ret = new StringBuilder(init.length());
        String[] words = init.split(split);
        if (words.length > 1) {
            ret.append(words[0]);
            for (int i = 1; i < words.length; i++) {
                String word = words[i];
                if (!word.isEmpty()) {
                    ret.append(word.substring(0, 1).toUpperCase());
                    ret.append(word.substring(1).toLowerCase());
                }
            }
        } else
            return init;
        return ret.toString();
    }

    public static String camelCaseToString(final String init, String split) {
        if (init == null)
            return null;


        String[] words = init.split("[A-Z]{1}");

        final StringBuilder ret = new StringBuilder(init.length());

        for (int i = 0; i < init.length(); i++) {
            char c = init.charAt(i);
            if (Character.isUpperCase(c)) {
                if (i != 0)
                    ret.append(split);
                ret.append(Character.toLowerCase(c));
            } else {
                ret.append(c);
            }
        }
        return ret.toString();
    }


    public static String printList(List<Object> list) {
        String result = "";
        if (list != null && list.size() > 0) {
            StringBuffer sb = new StringBuffer();
            for (Iterator<Object> iterator = list.iterator(); iterator.hasNext(); ) {
                Object object = (Object) iterator.next();
                sb.append(object.toString());
            }
            result = sb.toString();
        }

        return result;
    }

    /**
     * @param str
     * @return
     */
    public static boolean isNumberic(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (int i = str.length() - 1; i >= 0; i--) {
            int chr = str.charAt(i);
            if (chr < 48 || chr > 57) {
                return false;
            }
        }
        return true;
    }

    public static String getFileNameFromURL(String url) {
        String fname = null;
        int index = url.lastIndexOf('/');
        if (index >= 0) {
            fname = url.substring(index);
        }
        return fname;
    }

    public static PageBounds orderToPageBounds(Integer offset,
                                               Integer limit,
                                               String sort,
                                               SortDirection direction) {
        PageBounds pageBounds = null;
        if (sort != null) {
            List<Order> orders = new ArrayList<Order>();
            orders.add(Order.create(StringUtil.camelCaseToString(sort, "_"), direction.toString(), "convert(? using gb2312)"));
            pageBounds = new PageBounds(offset, limit, orders);
        } else {
            pageBounds = new PageBounds(offset, limit);
        }
        return pageBounds;
    }

    public static PageBounds orderToPageBounds2(Integer offset,
                                               Integer limit,
                                               String sort,
                                               SortDirection direction) {
        PageBounds pageBounds = null;
        if (sort != null) {
            List<Order> orders = new ArrayList<Order>();
            orders.add(Order.create(StringUtil.camelCaseToString(sort, "_"), direction.toString()));
            pageBounds = new PageBounds(offset, limit, orders);
        } else {
            pageBounds = new PageBounds(offset, limit);
        }
        return pageBounds;
    }

    public static PageBounds orderToPageBoundsForManHour(Integer offset,
                                               Integer limit,
                                               String sort,
                                               SortDirection direction) {
        PageBounds pageBounds = null;
        if (sort != null) {
            List<Order> orders = new ArrayList<Order>();
            orders.add(Order.create(StringUtil.camelCaseToString(sort, "_"), direction.toString(), "convert(? ,DECIMAL)"));
            pageBounds = new PageBounds(offset, limit, orders);
        } else {
            pageBounds = new PageBounds(offset, limit);
        }
        return pageBounds;
    }




    /**
     * @param str
     * @return
     */
    public static boolean isPhoneNumber(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        if (str.length() != 11 || !str.startsWith("1")) {
            return false;
        }

        return isNumberic(str);
    }

    /**
     * @param bts
     * @return
     */
    public static String bytes2Hex(byte[] bts) {
        String des = "";
        String tmp = null;
        for (int i = 0; i < bts.length; i++) {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1) {
                des += "0";
            }
            des += tmp;
        }
        return des;
    }

    /**
     * sha1
     *
     * @param strSrc
     * @return
     */
    public static String Encrypt(String strSrc) {
        MessageDigest md = null;
        String strDes = null;
        byte[] bt = strSrc.getBytes();
        try {
            md = MessageDigest.getInstance("SHA-1");
            md.update(bt);
            strDes = bytes2Hex(md.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        return strDes;
    }

    final static int BUFFER_SIZE = 1024;

    /**
     * @param in
     * @return String
     * @throws Exception
     */
    public static String InputStreamTOString(InputStream in) {
        return InputStreamTOString(in, "UTF-8");
    }

    /**
     * @param in
     * @param encoding
     * @return
     * @throws Exception
     */
    public static String InputStreamTOString(InputStream in, String encoding) {
        String result = null;
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] data = new byte[BUFFER_SIZE];
        try {
            int count = -1;
            while ((count = in.read(data, 0, BUFFER_SIZE)) != -1)
                outStream.write(data, 0, count);

            result = new String(outStream.toByteArray(), encoding);
            outStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            data = null;
        }
        return result;
    }

    /**
     * @param in
     * @return
     * @throws Exception
     */
    public static InputStream StringTOInputStream(String in) throws Exception {

        ByteArrayInputStream is = new ByteArrayInputStream(in.getBytes("UTF-8"));
        return is;
    }

    /**
     * @param in InputStream
     * @return byte[]
     * @throws IOException
     */
    public static byte[] InputStreamTOByte(InputStream in) {
        byte[] data = new byte[BUFFER_SIZE];
        ByteArrayOutputStream outStream = null;
        try {
            outStream = new ByteArrayOutputStream();

            int count = -1;
            while ((count = in.read(data, 0, BUFFER_SIZE)) != -1)
                outStream.write(data, 0, count);

            data = null;
            return outStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {

                if (null != outStream)
                    outStream.close();
            } catch (IOException e) {

                e.printStackTrace();
            }

        }
        return null;

    }

    /**
     * @param in
     * @return
     * @throws Exception
     */
    public static InputStream byteTOInputStream(byte[] in) throws Exception {

        ByteArrayInputStream is = new ByteArrayInputStream(in);
        return is;
    }

    /**
     * @param in
     * @return
     * @throws Exception
     */
    public static String byteTOString(byte[] in) throws Exception {

        InputStream is = byteTOInputStream(in);
        return InputStreamTOString(is);
    }


    /**
     * 仅仅提供网页使用
     *
     * @param color          显示颜色
     * @param content        全体内容
     * @param key            高亮显示字符
     * @param previsouOffset 截取关键字前长度
     * @return
     */
    public static String higherLigt(String color, String content, String key, int previsouOffset) {
        String highligthKey = "<font color='" + color + "' style='background-color:white;'>" + key + "</font>";
        int currentPos = content.indexOf(key);

        if (currentPos > previsouOffset) content = content.substring(currentPos - previsouOffset);


        String newContent = content.replaceAll(key, highligthKey);


        return newContent;
    }


    public static String higherLigt(String color, String content, String key) {
        return higherLigt(color, content, key, 10);
    }


    /**
     * 说明：过滤特殊字符
     */
    public static String filterNotEAndChinese(String src) {
        String reg = "[^a-z^A-Z^0-9^_^\u4e00-\u9fa5]*";

        return src.replaceAll(reg, "");

    }


    /**
     * 说明：list转成string，方便查询sql in 操作
     */
    public static String convertListToStringForSql(List<String> list) {
        String str = "(";
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                str += list.get(i);
            } else {
                str += list.get(i) + ",";
            }
        }
        str += ")";
        return str;
    }

    /**
     * 说明：list转成string，方便查询sql in 操作
     */
    public static String convertListToStringForSql_StringType(List<String> list) {
        String str = "(";
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                str += "'" + list.get(i) + "'";
            } else {
                str += "'" + list.get(i) + "',";
            }
        }
        str += ")";
        return str;
    }

    public static String mapToJson(Map map) {
        JSONObject jsonObject = new JSONObject();
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            jsonObject.put(key, map.get(key));
        }
        return jsonObject.toJSONString();
    }

    public static int compareTo(Object str1, Object str2) {
        if (isEmpty(str1)) {
            return -1;
        }
        if (isEmpty(str2)) {
            return 1;
        }
        return str1.toString().compareTo(str2.toString());
    }

    public static String padLeft(String src, int len, char ch) {
        int diff = len - src.length();
        if (diff <= 0) {
            return src;
        }

        char[] charr = new char[len];
        System.arraycopy(src.toCharArray(), 0, charr, diff, src.length());
        for (int i = 0; i < diff; i++) {
            charr[i] = ch;
        }
        return new String(charr);
    }

    public static String padRight(String src, int len, char ch) {
        int diff = len - src.length();
        if (diff <= 0) {
            return src;
        }

        char[] charr = new char[len];
        System.arraycopy(src.toCharArray(), 0, charr, 0, src.length());
        for (int i = src.length(); i < len; i++) {
            charr[i] = ch;
        }
        return new String(charr);
    }

    /**
     * 数据格式化
     *
     * @param num          被除数
     * @param divisor      除数
     * @param decimalPlace 保留位数
     * @return double string
     */
    public static String formatDouble(String num, Integer divisor, Integer decimalPlace) {
        if(num == null){
            return null;
        }
        if (decimalPlace == null) {
            DecimalFormat df2 = new DecimalFormat("##0.00");
            Double numD = Double.valueOf(num);
            return df2.format(Double.valueOf(numD / divisor));
        } else {
            StringBuilder buffer = new StringBuilder("##0.");
            for (int i = 0; i < decimalPlace; i++) {
                buffer = buffer.append("0");
            }
            DecimalFormat df2 = new DecimalFormat(buffer.toString());
            Double numD = Double.valueOf(num);
            return df2.format(Double.valueOf(numD / divisor));
        }
    }

    public static String digistPassword(String password) throws Exception{
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        digest.update(password.getBytes("UTF-8"));
        byte[] result = digest.digest();
        return new String(result);
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception{
        System.out.println(digistPassword("123456"));


    }

    public static Pattern  getLike(String username){
        return Pattern.compile(".*" + username + ".*", Pattern.CASE_INSENSITIVE);

    }

}

