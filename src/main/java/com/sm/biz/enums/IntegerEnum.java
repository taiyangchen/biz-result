/**
 * 
 */
package com.sm.biz.enums;

/**
 * 类型安全的枚举类型, 代表一个整数.
 * 
 * @author <a href="chenxu.xc@alibaba-inc.com">xc</a>
 * @version create on 2017年11月10日 下午11:43:48
 */
public abstract class IntegerEnum extends Enum {
  private static final long serialVersionUID = 343392921439669443L;

  /**
   * 创建一个枚举量.
   * 
   * @param value 枚举量的整数值
   */
  protected static final IntegerEnum create(int value) {
    return createEnum(Integer.valueOf(value));
  }

  /**
   * 创建一个枚举量.
   * 
   * @param value 枚举量的整数值
   */
  protected static final IntegerEnum create(Number value) {
    return createEnum(Integer.valueOf(value.intValue()));
  }

  /**
   * 创建一个枚举量.
   * 
   * @param name 枚举量的名称
   * @param value 枚举量的整数值
   */
  protected static final IntegerEnum create(String name, int value) {
    return createEnum(name, Integer.valueOf(value));
  }

  /**
   * 创建一个枚举量.
   * 
   * @param name 枚举量的名称
   * @param value 枚举量的整数值
   */
  protected static final IntegerEnum create(String name, Number value) {
    return createEnum(name, Integer.valueOf(value.intValue()));
  }

  /**
   * 创建一个枚举类型的<code>EnumType</code>.
   * 
   * @return 枚举类型的<code>EnumType</code>
   */
  protected static Object createEnumType() {
    return new EnumType() {
      protected Class<Integer> getUnderlyingClass() {
        return Integer.class;
      }

      protected Number getNextValue(Number value, boolean flagMode) {
        if (value == null) {
          return flagMode ? 1 : 0; // 默认起始值
        }

        int intValue = ((Integer) value).intValue();

        if (flagMode) {
          return Integer.valueOf(intValue << 1); // 位模式
        }

        return Integer.valueOf(intValue + 1);
      }

      protected boolean isZero(Number value) {
        return ((Integer) value).intValue() == 0;
      }
    };
  }

  /**
   * 实现<code>Number</code>类, 取得整数值.
   * 
   * @return 整数值
   */
  public int intValue() {
    return ((Integer) getValue()).intValue();
  }

  /**
   * 实现<code>Number</code>类, 取得长整数值.
   * 
   * @return 长整数值
   */
  public long longValue() {
    return ((Integer) getValue()).longValue();
  }

  /**
   * 实现<code>Number</code>类, 取得<code>double</code>值.
   * 
   * @return <code>double</code>值
   */
  public double doubleValue() {
    return ((Integer) getValue()).doubleValue();
  }

  /**
   * 实现<code>Number</code>类, 取得<code>float</code>值.
   * 
   * @return <code>float</code>值
   */
  public float floatValue() {
    return ((Integer) getValue()).floatValue();
  }

  /**
   * 实现<code>IntegralNumber</code>类, 转换成十六进制整数字符串.
   * 
   * @return 十六进制整数字符串
   */
  public String toHexString() {
    return Integer.toHexString(((Integer) getValue()).intValue());
  }

  /**
   * 实现<code>IntegralNumber</code>类, 转换成八进制整数字符串.
   * 
   * @return 八进制整数字符串
   */
  public String toOctalString() {
    return Integer.toOctalString(((Integer) getValue()).intValue());
  }

  /**
   * 实现<code>IntegralNumber</code>类, 转换成二进制整数字符串.
   * 
   * @return 二进制整数字符串
   */
  public String toBinaryString() {
    return Integer.toBinaryString(((Integer) getValue()).intValue());
  }
}
