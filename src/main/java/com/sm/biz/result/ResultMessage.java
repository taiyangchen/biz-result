/**
 * 
 */
package com.sm.biz.result;

/**
 * 代表一个包含结果信息的接口
 * 
 * @author <a href="mailto:xuchen06@baidu.com">xuc</a>
 * @version create on 2014年7月24日 下午6:06:03
 */
public interface ResultMessage {

    /**
     * 获取结果代码
     * 
     * @return 处理结果的代码 @see ResultCode
     */
    ResultCode getResultCode();

}
