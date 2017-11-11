/**
 * 
 */
package com.sm.biz.enums;

/**
 * 代表创建和初始化<code>Enum</code>的异常。
 * 
 * @author <a href="chenxu.xc@alibaba-inc.com">xc</a>
 * @version create on 2017年11月10日 下午11:34:58
 */
public class CreateEnumException extends IllegalArgumentException {

  private static final long serialVersionUID = 3258688789055287860L;

  /**
   * 构造一个空的异常.
   */
  public CreateEnumException() {
    super();
  }

  /**
   * 构造一个异常, 指明异常的详细信息.
   * 
   * @param message 详细信息
   */
  public CreateEnumException(String message) {
    super(message);
  }

  /**
   * 构造一个异常, 指明引起这个异常的起因.
   * 
   * @param cause 异常的起因
   */
  public CreateEnumException(Throwable cause) {
    super(cause);
  }

  /**
   * 构造一个异常, 指明引起这个异常的起因.
   * 
   * @param message 详细信息
   * @param cause 异常的起因
   */
  public CreateEnumException(String message, Throwable cause) {
    super(message, cause);
  }

}
