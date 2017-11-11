package com.sm.biz.result;

import com.sm.biz.resourcebundle.AbstractResourceBundle;
import com.sm.biz.resourcebundle.ResourceBundleConstant;
import com.sm.common.libs.util.MessageUtil;

/**
 * 支持自定义枚举类的ResultCodeMessage
 * 
 * @author <a href="mailto:xuchen06@baidu.com">xuc</a>
 * @version create on 2014年7月24日 下午5:57:24
 */
public class ResultMessageProvider implements ResultCodeMessage, ResourceBundleConstant {

  private ResultCode resultCode;
  private AbstractResourceBundle resourceBundle;
  private Object[] params;

  public ResultMessageProvider(ResultCode resultCode, AbstractResourceBundle resourceBundle) {
    this(resultCode, resourceBundle, null);
  }

  public ResultMessageProvider(ResultCode resultCode, AbstractResourceBundle resourceBundle, Object[] params) {
    this.resultCode = resultCode;
    this.resourceBundle = resourceBundle;
    this.params = params;

    if (resultCode == null) {
      throw new IllegalArgumentException("ResultCode is null");
    }

  }

  public String getName() {
    return this.resultCode.getName();
  }

  public ResultCode getResultCode() {
    return this.resultCode;
  }

  public String getMessage() {
    return MessageUtil.getMessage(this.resourceBundle, this.resultCode.getName(), this.params);
  }

  public int getCode() {
    String code = MessageUtil.getMessage(resourceBundle, resultCode.getName() + XPATH_RESOURCE_CODE_SUFFIX, params);
    return (code == null) ? 0 : Integer.valueOf(code);
  }

  public String toString() {
    return getMessage();
  }

}
