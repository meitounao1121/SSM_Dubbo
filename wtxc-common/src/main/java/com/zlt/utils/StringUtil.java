package com.zlt.utils;

import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;


/**
* 
* 文件名: StringUtil.java
* 业务日志
*

*  
* @since NJA Core Platform 1.0
*/
public class StringUtil {
	static final char[] DIGITS_CN = { '〇', '一', '二', '三', '四', '五', '六', '七',
			'八', '九', '十' };

	private StringUtil(){}
	/**
	 * 把数字变为中文串，如2001变成二〇〇一.
	 * 
	 * @param N
	 *            数字
	 * @return 中文数字串
	 */
	public static String toNumberCN(int N) {
		StringBuilder b = new StringBuilder();
		while (N > 0) {
			b.append(DIGITS_CN[N % 10]);
			N /= 10;
		}
		return b.reverse().toString();
	}

	/**
	 * 在给定的字符串后，指定的位置加一个后缀。
	 * <li> 如果是空串，直接返回后缀
	 * <li> 如果不够长，直接在源串后加后缀
	 * <li> 如果超过给的长度，在给定长度后成加一个后缀
	 * 
	 * @param src
	 *            源串
	 * @param num
	 *            源串中加后缀的位置
	 * @param postfix
	 *            后缀
	 * @return
	 */
	public String appendPostfix(String src, int num, String postfix) {
		if (src == null || src.length() == 0) {
			return postfix;
		}
		if (src.length() > num) {
			return src.substring(0, num) + postfix;
		}

		return src + postfix;
	}

	/**
	 * 取出一个字符串中的子串，子串由指定位置开始，到结束位置。如果为空，返回空串
	 * 
	 * @param src
	 *            源串
	 * @param start
	 *            指定的位置
	 * @param end
	 *            结束位置
	 * @return 子串
	 */
	public static String subString(String src, int start, int end) {
		if (src == null || src.length() == 0)
			return "";
		if (start > end || end > src.length())
			return "";
		return src.substring(start, end);
	}

	/**
	 * 检查一个对象是否为空串。<br><br>
	 * 1.在进行空检查中，大多数为串，先检查是否为串，可以检查字符串类的对象
	 * <li> String
	 * <li> StringBuffer
	 * <li> StringBuilder
	 * 2.检查集合对象Collection子类，如Set，List等类<br>
	 * 3.检查Map类如HashMap，Hashtable
	 * 4.检查数组<br>
	 * 数组检查规则是，检查长度为，返回空，如果数组中所有对象为空，返回为空。
	 * 
	 * @param object 输入检查的对象
	 * @return 如果为空是真，非常空为假
	 */
	public static boolean isEmpty(Object o) {
		if (o == null) {
			return true;
		}
		if (o instanceof CharSequence) {
			return ((CharSequence)o).length() == 0;
		}
		
		if (o instanceof Collection) {
			return ((Collection<?>)o).size() == 0;
		}
		
		if (o instanceof Map) {
			return ((Map<?,?>)o).size() == 0;
		}
		
		if (o.getClass().isArray()) {
			int len = Array.getLength(o);
			for (int i=0; i<len; i++) {
				if (Array.get(o, i) != null) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	public static boolean isNotEmpty(Object o) {
		if (o == null) {
			return false;
		}
		if (o instanceof CharSequence) {
			return ((CharSequence)o).length() > 0;
		}
		
		if (o instanceof Collection) {
			return ((Collection<?>)o).size() > 0;
		}
		
		if (o instanceof Map) {
			return ((Map<?,?>)o).size() > 0;
		}
		
		if (o.getClass().isArray()) {
			return Array.getLength(o)>0;
		}
		return true;
	}
	/***************************************************************************
	 * 判断是否是中文字符
	 * 
	 * @Name: PinyinUtil.java
	 * @author: jianghaining
	 * @version: July 13, 2012 11:05:58 AM
	 * @param c
	 * @return
	 */
	public static final boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		return (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS //
				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS //
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A //
				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION //
				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION //
		|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS);
	}

	/***************************************************************************
	 * 判断是否是中文
	 * 
	 * @Name: PinyinUtil.java
	 * @author: jianghaining
	 * @version: July 13, 2012 11:05:58 AM
	 * @param strName
	 * @return
	 */
	public static final boolean isChinese(String strName) {
		for (int i = 0; i < strName.length(); i++) {
			if (!isChinese(strName.charAt(i)))
				return false;
		}
		return true;
	}
	
	public static String[] getSplitArr(String s, String splitstr) {
		return (s == null) ? null : s.split(splitstr);
	}

	/**
	 * 串 ：aaa,bb,cc 1：bb
	 * 
	 * @param s
	 * @param splitchar
	 * @param num
	 * @return
	 */
	public static String getSplitArr(String s, String splitstr, int idx) {
		if (isEmpty(s)) {
			s = "";
		}
		String[] arr = s.split(splitstr);
		if (idx < arr.length) {
			return arr[idx];
		}
		return "";
	}

	public static boolean isNumeric(CharSequence charseq) {
		if (charseq == null || charseq.length() == 0) {
			return false;
		}

		for (int i = 0; i < charseq.length(); i++) {
			char c = charseq.charAt(i);
			if (c < '0' || c > '9') {
				return false;
			}
		}
		return true;
	}

	/**
	 * 计算一个字符串对应的字节数。
	 * 
	 * @param s
	 * @return
	 */
	public static int lengthOfByte(String s) {
		if (s == null || s.length() == 0)
			return 0;
		return s.getBytes().length;
	}

	/**
	 * 移出在尾部指定的串，如果串不存在，返回源串
	 * 
	 * @param src
	 *            给定的源串
	 * @param postfix
	 *            后缀
	 * @return
	 */
	public static String removePostfix(String src, String postfix) {
		if (src != null && src.endsWith(postfix)) {
			return src.substring(0, src.length() - postfix.length());
		}
		return src;
	}

	/**
	 * 移出指定的前缀。
	 * 
	 * @param src
	 *            源串
	 * @param prefix
	 *            前缀
	 * @return
	 */
	public static String removePrefix(String src, String prefix) {
		if (src != null && src.startsWith(prefix)) {
			return src.substring(prefix.length());
		}
		return src;
	}

	/**
	 * 定位一个串在一个串数据中的位置.
	 * @param src 源串
	 * @param dest 串数组
	 * @return 串在串数组中的位置，如果在第一个返回为0。如果没有找到，返回为<b> -1 </b>
	 */
	public static int indexAt(String src, String[] dest) {
		if (dest == null || dest.length == 0) {
			return -1;
		}
		for (int i = 0; i < dest.length; i++) {
			if (src.equals(dest[i])) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 将字符串转为Integer类型，如果失败，返回为默认值。
	 * @param str 给定的字符中
	 * @param defaultValue 默认值
	 * @return
	 */
	public static int toInt(String str, int defaultValue) {
		if (str == null || str.length() == 0)
			return defaultValue;
		try {
			return Integer.parseInt(str.trim());
		} catch (NumberFormatException e) {
			// NOP
		}
		return defaultValue;
	}

	/**
	 * Convert an unknown Object into an integer.
	 * @param obj
	 * @return integer value.
	 */
	public static int toInt(Object obj) {
		if (obj == null) {
			return 0;
		}
		if (obj instanceof Long) {
			return ((Long) obj).intValue();
		}
		if (obj instanceof Integer) {
			return ((Integer) obj).intValue();
		}
		if (obj instanceof Byte) {
			return ((Byte) obj).intValue();
		}
		if (obj instanceof Boolean) {
			return ((Boolean) obj) ? 1 : 0;
		}
		if (obj instanceof Short) {
			return ((Short) obj).intValue();
		}
		if (obj instanceof Double) {
			return ((Double) obj).intValue();
		}
		if (obj instanceof Float) {
			return ((Float) obj).intValue();
		}
		if (obj instanceof BigDecimal) {
			return ((BigDecimal) obj).intValue();
		}
		if (obj instanceof BigInteger) {
			return ((BigInteger) obj).intValue();
		}
		return 0;
	}

	/**
	 * 将一个串，转化为长整型数，如果转化失败，返回为默认值。
	 * @param str 源串
	 * @param defaultValue 默认值
	 * @return
	 */
	public static long toLong(String str, long defaultValue) {
		if (str == null || str.length() == 0)
			return defaultValue;
		try {
			return Long.parseLong(str.trim());
		} catch (NumberFormatException e) {
			// NOP
		}
		return defaultValue;
	}

	public static boolean toBoolean(Object b) {
		return toBoolean(b,false);
	}

	public static boolean toBoolean(Object b, boolean defVal) {
		if (b == null || b.toString().length() == 0) {
			return defVal;
		}
		if (b instanceof Boolean) {
			return ((Boolean) b).booleanValue();
		}
		String x = b.toString().trim();
		return "1".equals(x) //
				|| "TRUE".equalsIgnoreCase(x)//
				|| "YES".equalsIgnoreCase(x);
	}
	
	/**
	 * 将字符串转为Double类型，如果失败，返回为默认值。
	 * @param str 给定的字符中
	 * @param defaultValue 默认值
	 * @return
	 */
	public static double toDouble(String str, double defaultValue) {
		if (str == null || str.length() == 0)
			return defaultValue;
		try {
			return Double.parseDouble(str.trim());
		} catch (NumberFormatException e) {
			// NOP
		}
		return defaultValue;
	}

	public static String getGUID() {
		String retString = UUID.randomUUID().toString();
		StringBuilder b = new StringBuilder(64);
		b.append(retString.substring(0, 8));
		b.append(retString.substring(9, 13));
		b.append(retString.substring(14, 18));
		b.append(retString.substring(19, 24));
		b.append(retString.substring(24));
		return b.toString();
	}

	/** 
	 * 生成全文检索的正则表达式
	 * FIXME: 需要修正！
	 * @param text
	 * @return 编译后的正则表达式
	 */
	public static Pattern fullTextPattern(String text) {
		if (isEmpty(text)) {
			return null;
		}
		// 预处理 TEXT， ( ) [ ] * % ?
		StringBuilder t = new StringBuilder(text.length());
		for (int i=0; i<text.length(); i++) {
			char c = text.charAt(i);
			switch (c) {
			case '(':
			case ')':
			case '[':
			case ']':
				t.append('\\').append(c);
				break;
			case '*':
			case '%':
			case '?':
			case '|':
			case '　': // 全角空格
			case '，': // 全角逗号
			case '；': // 全角分号
				t.append(' ');
				break;
			default:
				t.append(c);
			}
		}
		
		String arr[] = t.toString().toUpperCase().split("\\s+|\\,|\\;|\\+|\\:");
		StringBuilder expr = new StringBuilder(128);
		for (String x : arr) {
			if (x.length() != 0){
				expr.append('|').append(x);
			}
		}
		return Pattern.compile(expr.substring(1));
	}
	
	public static Object[] wrapObj(Object... obj) {
		return obj;
	}
	
//	/**
//	 * Encode a byte array to BASE64 String, if bb is NULL, return NULL string
//	 * @param bb a byte array
//	 * @return
//	 */
//	public static String toBASE64(byte bb[]) {
//		if (bb == null) {
//			return null;
//		}
//		sun.misc.BASE64Encoder ec = new sun.misc.BASE64Encoder();
//		return ec.encode(bb);
//	}
//
//	public static byte[] decodBASE64(String b64) throws IOException {
//		if (b64 == null) {
//			return null;
//		}
//		sun.misc.BASE64Decoder dc = new sun.misc.BASE64Decoder();
//		return dc.decodeBuffer(b64);
//	}
}
