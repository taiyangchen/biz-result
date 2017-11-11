package com.sm.biz.resourcebundle.proxy;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sm.biz.resourcebundle.AbstractResourceBundle;
import com.sm.common.china.convert.CharConverter;

/***
 * 自动语言转换代理类,用于自动语言转换,如:zh_CN->zh_TW,zh_CN->zh_HK**
 * 
 * @author <a href="chenxu.xc@alibaba-inc.com">xc</a>
 * @version create on 2017年11月10日 下午11:55:50
 */
public class ConvertResourceBundleProxy extends AbstractResourceBundle {
  private AbstractResourceBundle resourceBundle;
  private CharConverter converter;

  public ConvertResourceBundleProxy(AbstractResourceBundle resourceBundle, CharConverter converter) {
    this.resourceBundle = resourceBundle;
    this.setBaseName(resourceBundle.getBaseName());
    this.setLocale(resourceBundle.getLocale());

    this.converter = converter;
  }

  public Enumeration<String> getKeys() {
    return resourceBundle.getKeys();
  }

  protected String convertString(String str) {
    char[] chars;
    chars = str.toCharArray();
    converter.convert(chars);
    return new String(chars);
  }

  protected Object convertObject(Object obj) {
    if (obj == null) {
      return null;
    }

    Object result = obj;
    if (String.class.isInstance(result)) {
      return convertString((String) result);
    }

    if (Map.class.isInstance(result)) {
      Map<?, ?> srcMap = (Map<?, ?>) result;
      Map<Object, Object> map = new HashMap<>(srcMap.size());
      for (Map.Entry<?, ?> entry : srcMap.entrySet()) {
        Object key = entry.getKey();
        Object value = entry.getValue();
        value = convertObject(value);
        map.put(key, value);
      }
      return map;
    }

    if (List.class.isInstance(result)) {
      List<?> srcList = (List<?>) result;
      List<Object> list = new ArrayList<>(srcList.size());
      for (int i = 0; i < srcList.size(); i++) {
        Object value = srcList.get(i);
        // 递归转换
        value = convertObject(value);
        list.add(value);
      }
      return list;
    }

    return result;
  }

  protected Object handleGetObject(String key) {
    Object result;
    // XXX 由于 resourceBundle.handleGetObject(String key)不可访问，故采用了近似的
    // resourceBundle.getObject(key) 替代
    result = resourceBundle.getObject(key);
    return convertObject(result);
  }

  public AbstractResourceBundle getResourceBundle() {
    return resourceBundle;
  }

  public CharConverter getConverter() {
    return converter;
  }
}
