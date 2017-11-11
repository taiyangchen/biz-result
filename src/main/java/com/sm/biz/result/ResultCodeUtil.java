package com.sm.biz.result;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import com.sm.biz.resourcebundle.ResourceBundleConstant;
import com.sm.biz.resourcebundle.ResourceBundleFactory;
import com.sm.common.libs.core.LoggerSupport;
import com.sm.common.libs.util.LocaleUtil;
import com.sm.common.libs.util.MessageUtil;

/**
 * <code>ResultCode</code>辅助类。
 * 
 * @author <a href="mailto:xuchen06@baidu.com">xuc</a>
 * @version create on 2014年7月24日 下午6:05:31
 */
public class ResultCodeUtil extends LoggerSupport implements Serializable, ResourceBundleConstant {
  private static final long serialVersionUID = -1283084401300246727L;
  private final ResultCode resultCode;
  private transient Map<Locale, ResourceBundle> resourceBundles;

  /**
   * 取得指定<code>ResultCode</code>对应的util实例。
   */
  public ResultCodeUtil(ResultCode resultCode) {
    this.resultCode = resultCode;

    if (!(resultCode instanceof Enum)) {
      throw new IllegalArgumentException("ResultCode should be java.lang.Enum: " + getClass().getName());
    }
  }

  /**
   * 取得<code>ResultCode</code>名称。
   */
  public String getName() {
    return Enum.class.cast(resultCode).name();
  }

  /**
   * 取得<code>ResultCode</code>code值。
   */
  public int getCode() {
    return getMessage().getCode();
  }

  /**
   * 创建result code的描述信息。
   */
  public ResultCodeMessage getMessage() {
    final ResourceBundle resourceBundle = getResourceBundle();

    return new ResultCodeMessage() {
      public String getName() {
        return resultCode.getName();
      }

      public ResultCode getResultCode() {
        return resultCode;
      }

      public String getMessage() {
        return MessageUtil.getMessage(resourceBundle, resultCode.getName());
      }

      public int getCode() {
        String code = MessageUtil.getMessage(resourceBundle, resultCode.getName() + XPATH_RESOURCE_CODE_SUFFIX);
        return (code == null) ? 0 : Integer.valueOf(code);
      }

      public String toString() {
        return getMessage();
      }
    };
  }

  /**
   * 创建result code的描述信息。
   * 
   * @param args 传入参数
   */
  public ResultCodeMessage getMessage(final Object... args) {
    final ResourceBundle resourceBundle = getResourceBundle();

    return new ResultCodeMessage() {
      public String getName() {
        return resultCode.getName();
      }

      public ResultCode getResultCode() {
        return resultCode;
      }

      public String getMessage() {
        return MessageUtil.getMessage(resourceBundle, resultCode.getName(), args);
      }

      public int getCode() {
        String code = MessageUtil.getMessage(resourceBundle, resultCode.getName() + XPATH_RESOURCE_CODE_SUFFIX, args);
        return (code == null) ? 0 : Integer.valueOf(code);
      }

      public String toString() {
        return getMessage();
      }
    };
  }

  /**
   * 取得存放result code描述信息的resouce bundle。
   */
  protected final synchronized ResourceBundle getResourceBundle() {
    if (resourceBundles == null) {
      resourceBundles = new HashMap<Locale, ResourceBundle>();
    }

    Locale contextLocale = LocaleUtil.getContext().getLocale();
    ResourceBundle resourceBundle = resourceBundles.get(contextLocale);

    if (resourceBundle == null) {
      Class<?> resultCodeClass = resultCode.getClass();

      do {
        String resourceBundleName = resultCodeClass.getName();

        logger.debug("Trying to load resource bundle: [{}]", resourceBundleName);

        try {
          resourceBundle = ResourceBundleFactory.getBundle(resourceBundleName);
        } catch (MissingResourceException e) {
          if (e.getCause() != null) {
            logger.error(e.getCause().getMessage(), e.getCause());
          } else {
            logger.debug("Resource bundle not found: " + resourceBundleName);
          }

          resultCodeClass = resultCodeClass.getSuperclass();
        }
      } while (resourceBundle == null && resultCodeClass != null);

      resourceBundles.put(contextLocale, resourceBundle);
    }

    return resourceBundle;
  }


}
