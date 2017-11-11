/**
 * 
 */
package com.sm.biz.result;

import com.sm.common.libs.exception.MessageException;
import com.sm.common.libs.util.MessageUtil;

/**
 * 定义一个报告结果信息的异常
 * 
 * @author <a href="mailto:xuchen06@baidu.com">xuc</a>
 * @version create on 2014年7月24日 下午6:06:39
 */
public class ResultMessageException extends MessageException implements ResultMessage {

  /**
  * 
  */
  private static final long serialVersionUID = 638791379022533792L;

  private ResultCode resultCode;

  /**
   * 构造一个空的异常.
   */
  public ResultMessageException() {
    super();
  }

  /**
   * 构造一个异常, 指明异常的详细信息.
   * 
   * @param message 详细信息
   */
  public ResultMessageException(String message) {
    super(message);
  }

  /**
   * 构造一个异常, 指明引起这个异常的起因.
   * 
   * @param cause 异常的起因
   */
  public ResultMessageException(Throwable cause) {
    super(cause);
  }

  /**
   * 构造一个异常, 指明引起这个异常的<code>ResultCode</code>.
   * 
   * @param resultCode 结果码
   */
  public ResultMessageException(ResultCode resultCode) {
    super();
    this.resultCode = resultCode;
  }

  /**
   * 构造一个异常, 指明引起这个异常的起因.
   * 
   * @param message 详细信息
   * @param cause 异常的起因
   */
  public ResultMessageException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * 构造一个异常, 指明异常的详细信息.
   * 
   * @param message 详细信息
   * 
   * @param resultCode 结果码
   */
  public ResultMessageException(String message, ResultCode resultCode) {
    super(message);
    this.resultCode = resultCode;
  }

  /**
   * 构造一个异常, 指明引起这个异常的起因.
   * 
   * @param cause 异常的起因
   * 
   * @param resultCode 结果码
   */
  public ResultMessageException(Throwable cause, ResultCode resultCode) {
    super(cause);
    this.resultCode = resultCode;
  }

  /**
   * 构造一个异常, 指明引起这个异常的起因.
   * 
   * @param message 详细信息
   * @param cause 异常的起因
   * @param resultCode 结果码
   */
  public ResultMessageException(String message, Throwable cause, ResultCode resultCode) {
    super(message, cause);
    this.resultCode = resultCode;
  }

  /**
   * 构造一个异常, 参数化详细信息
   * 
   * @param message 详细信息
   * @param params 参数表
   */
  public ResultMessageException(String message, Object... params) {
    super(MessageUtil.formatLogMessage(message, params));
  }

  /**
   * 构造一个异常, 参数化详细信息,指明引起这个异常的起因
   * 
   * @param message 详细信息
   * @param cause 异常的起因
   * @param params 参数表
   */
  public ResultMessageException(String message, Throwable cause, Object... params) {
    super(MessageUtil.formatLogMessage(message, params), cause);
  }

  @Override
  public ResultCode getResultCode() {
    return resultCode;
  }

}
