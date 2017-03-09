package com.fizzer.doraemon.android_fizzer_utils.Utils;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 用于校验的工具类
 * @author xiaolei.li
 */

public class RegularToolkit {

    /**
     * 判定输入汉字
     *
     * @param c
     * @return
     */
    private static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }

    /**
     * 是否全是中文
     *
     * @param name
     * @return
     */
    public static boolean checkNameChese(String name) {
        boolean res = true;
        char[] cTemp = name.toCharArray();
        for (int i = 0; i < name.length(); i++) {
            if (!isChinese(cTemp[i])) {
                res = false;
                break;
            }
        }
        return res;
    }

    /**
     * 通过{n},格式
     *
     * @param src
     * @param objects
     * @return
     */
    public static String format(String src, Object... objects) {
        int k = 0;
        for (Object obj : objects) {
            src = src.replace("{" + k + "}", obj.toString());
            k++;
        }
        return src;
    }

    /**
     * 半角转换为全角
     *
     * @param input
     * @return
     */
    public static String ToDBC(String input) {
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 12288) {
                c[i] = (char) 32;
                continue;
            }
            if (c[i] > 65280 && c[i] < 65375)
                c[i] = (char) (c[i] - 65248);
        }
        return new String(c);
    }

    /**
     * 是否为手机号
     *
     * @param mobiles
     * @return
     */
    public static boolean isMobileNO(String mobiles) {
        if (isMobileNOCM(mobiles) ||
                isMobileNOCU(mobiles) ||
                isMobileNOCT(mobiles) ||
                isNewNOCT(mobiles)) {
            return true;
        }
        return false;
    }

    /***
     * 移动
     *
     * @param mobiles
     * @return
     */
    public static boolean isMobileNOCM(String mobiles) {
        String regExp = "^((13[4-9])|(147)|(15[0-2,7-9])|(178)|(18[2-4,7-8]))\\d{8}|(1705)\\d{7}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    /**
     * 联通
     *
     * @param mobiles
     * @return
     */
    public static boolean isMobileNOCU(String mobiles) {
        String regExp = "^((13[0-2])|(145)|(15[5-6])|(176)|(18[5-6]))\\d{8}|(1709)\\d{7}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    /**
     * 电信
     *
     * @param mobiles
     * @return
     */
    public static boolean isMobileNOCT(String mobiles) {
        String regExp = "^((133)|(153)|(177)|(18[0,1,9]))\\d{8}|(1700)\\d{7}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    /**
     * 新号段
     *
     * @param mobiles
     * @return
     */
    public static boolean isNewNOCT(String mobiles) {
        String regExp = "^((154)|(170)|(171)|(173)|(175))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    /***
     * 是否为邮箱
     *
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);

        return m.matches();
    }

    /**
     * 是否为纯数字
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    public static String replace(String content) {
        String regxpForImaTagSrcAttrib = "src=\"([^\"]+)\"";
        content.replace(regxpForImaTagSrcAttrib, "");
        return content;
    }


    /**
     * 校验身份证
     *
     * @param cardId
     * @return
     */
    public static boolean checkIdentityCards(String cardId) {
        Pattern pattern = Pattern.compile("^(\\d{14}|\\d{17})(\\d|[xX])$");
        Matcher isNum = pattern.matcher(cardId);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }


    /**
     * 校验银行卡卡号
     *
     * @param cardId
     * @return
     */
    public static boolean checkBankCards(String cardId) {
        Pattern pattern = Pattern.compile("^(\\d{15}|\\d{16}|\\d{17}|\\d{18}|\\d{19})$");
        Matcher isNum = pattern.matcher(cardId);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }


    /**
     * 校验银行卡卡号
     *
     * @param cardId
     * @return
     */
    public static boolean checkBankCard(String cardId) {
        char bit = getBankCardCheckCode(cardId.substring(0, cardId.length() - 1));
        if (bit == 'N') {
            return false;
        }
        return cardId.charAt(cardId.length() - 1) == bit;
    }

    /**
     * 从不含校验位的银行卡卡号采用 Luhm 校验算法获得校验位
     *
     * @param nonCheckCodeCardId
     * @return
     */
    public static char getBankCardCheckCode(String nonCheckCodeCardId) {
        if (nonCheckCodeCardId == null || nonCheckCodeCardId.trim().length() == 0
                || !nonCheckCodeCardId.matches("\\d+")) {
            //如果传的不是数据返回N
            return 'N';
        }
        char[] chs = nonCheckCodeCardId.trim().toCharArray();
        int luhmSum = 0;
        for (int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
            int k = chs[i] - '0';
            if (j % 2 == 0) {
                k *= 2;
                k = k / 10 + k % 10;
            }
            luhmSum += k;
        }
        return (luhmSum % 10 == 0) ? '0' : (char) ((10 - luhmSum % 10) + '0');
    }


//    public static boolean regular(String url, String regular) {
//        boolean success = false;
//        try {
//            Document doc = Jsoup.connect(url).get();
//            String content = doc.text();
//            if (!TextUtils.isEmpty(content) && content.contains(regular)) {
//                success = true;
//            } else {
//                success = false;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return success;
//    }

    /**
     * 校验密码
     *
     * @param pwd
     * @return
     */
    public static boolean checkPwd(String pwd) {
        Pattern pattern = Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$");
        Matcher isNum = pattern.matcher(pwd);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }


    /***
     * 判断是否为全中文
     * @param name
     * @return
     */
    public static boolean checkChinese(String name) {
        Pattern pattern = Pattern.compile("^[\\u4e00-\\u9fa5]*$");
        Matcher matcher = pattern.matcher(name);
        if (!matcher.matches()) {
            return false;
        }
        return true;
    }


    public static String maskPhone(String mobile){
        if(TextUtils.isEmpty(mobile) || mobile.length()<11){
            return mobile;
        }
        //mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
       return mobile.substring(0,3)+"****"+mobile.substring(7,mobile.length());
    }

}
