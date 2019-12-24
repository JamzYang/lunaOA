

package com.sjz.common.validator;

import com.sjz.common.exception.LunaException;
import org.apache.commons.lang.StringUtils;

/**
 * 数据校验
 *
 * @author
 */
public abstract class Assert {

    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new LunaException(message);
        }
    }

    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new LunaException(message);
        }
    }
}
