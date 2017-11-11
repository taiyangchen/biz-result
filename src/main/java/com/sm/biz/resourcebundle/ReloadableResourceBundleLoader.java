package com.sm.biz.resourcebundle;

/**
 * 装入resource bundle的数据.
 * 
 * @author <a href="chenxu.xc@alibaba-inc.com">xc</a>
 * @version create on 2017年11月10日 下午11:47:47
 */
public interface ReloadableResourceBundleLoader extends ResourceBundleLoader {
  /**
   * 取得资源束配置最近修改时间。
   * 
   * @param bundleName 要查找的bundle文件名
   * @return bundle配置的最近修改时间，如果不支持，则返回<code>0</code>
   */
  long lastModified(String bundleFileName);
}
