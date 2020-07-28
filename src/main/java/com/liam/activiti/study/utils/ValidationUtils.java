package com.liam.activiti.study.utils;

import java.util.Collection;
import java.util.Map;

/**
 * @ProjectName activiti-study
 * @PackageName com.liam.activiti.study.utils
 * @ClassName ValidationUtils
 * @Description 判空工具类
 * @Author LiangJinTang
 * @Date 2020/07/24 22:39
 **/
public class ValidationUtils {
    public static boolean isEmpty(Object pObj) {
        if (pObj == null) {
            return true;
        } else if ("".equals(pObj)) {
            return true;
        } else {
            if (pObj instanceof String) {
                if (((String)pObj).length() == 0) {
                    return true;
                }
            } else if (pObj instanceof Collection) {
                if (((Collection)pObj).size() == 0) {
                    return true;
                }
            } else if (pObj instanceof Map && ((Map)pObj).size() == 0) {
                return true;
            }

            return false;
        }
    }

    public static boolean isNotEmpty(Object pObj) {
        if (pObj == null) {
            return false;
        } else if ( "".equals(pObj)) {
            return false;
        } else {
            if (pObj instanceof String) {
                if (((String)pObj).length() == 0) {
                    return false;
                }
            } else if (pObj instanceof Collection) {
                if (((Collection)pObj).size() == 0) {
                    return false;
                }
            } else if (pObj instanceof Map && ((Map)pObj).size() == 0) {
                return false;
            }

            return true;
        }
    }
}
