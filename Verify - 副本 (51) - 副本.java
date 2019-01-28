package userMothod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.testng.Assert;

/**
 * @author wangy34 Tel:13145878905
 */
public class Verify {

  static boolean flag = true;
  static List<Error> errors = new ArrayList<Error>();

  public Verify() {
    // TODO Auto-generated constructor stub
  }

  // 比较是否相等，遍历集合中的每一个元素。
  public void iterateIsEquals(Collection<?> actualCol, String expectStr, String message) {
    Object[] obj = actualCol.toArray();
    int i = 0;
    System.out.println(message + " 遍历集合中的每一个元素，是否等于预期值：" + expectStr);
    for (Object s : obj) {
      i++;
      Boolean equals = s.toString().trim().equals(expectStr);//trim()除去开头和末尾的空格
      if (equals) {
        System.out.println("第" + i + "个元素," + s + "==" + expectStr);
      } else {
        System.err.println("第" + i + "个元素," + s + "≠≠" + expectStr);
        try {
          Assert.fail("第" + i + "个元素," + s + "≠≠" + expectStr);
        } catch (Exception e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
          flag = false;
        }
      }
    }
  }

  // 右包含，实际值在预期范围内。⊆ ⊂ ⊇ ⊃ ∈＝≠
  public void iterateIsContainsR(Collection<?> actualCol, String expectStr, String message) {
    if (message.isEmpty()) {
      message = "检查(实际结果, 预期结果)是否包含:";
    }
    Object[] obj = actualCol.toArray();
    int i = 0;
    System.out.println(message + " 遍历集合中的每一个元素，是否包含在预期值[" + expectStr + "]");// expectStr="1,2,3"
    for (Object s : obj) {
      i++;
      Boolean contains = expectStr.trim().contains(s.toString());
      if (contains) {
        System.out.println("第" + i + "个元素,（" + s + "） ⊆ 预期值:{" + expectStr + "}");
      } else {
        System.err.println("第" + i + "个元素,（" + s + "） !⊆ 预期值:{" + expectStr + "}");
        // System.out.println("第"+i+"个元素,"+s+" !⊆ 预期值:{"+expectStr+"}");
        try {
          Assert.fail("第" + i + "个元素,（" + s + "） !⊆ 预期值:{" + expectStr + "}");
        } catch (Exception e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
          flag = false;
        }
      }
    }
  }

  // 实际值可能有多个字符串组成，只要包含预期值，结果则为true。
  public void iterateIsContains(Collection<?> actualCol, String expectStr, String message) {
    if (message.isEmpty()) {
      message = "检查(实际结果,预期结果)是否包含:";
    }
    Object[] obj = actualCol.toArray();
    int i = 0;
    System.out.println(message + " 遍历集合中的每一个元素,是否包含预期值[" + expectStr + "]");
    for (Object s : obj) {
      i++;
      Boolean contains = s.toString().contains(expectStr.trim());
      if (contains) {
        System.out.println("预期值:（" + expectStr + "）⊆第" + i + "个元素{" + s + "}");
      } else {
        System.err.println("预期值:（" + expectStr + "）!⊆第" + i + "个元素{" + s + "}");
        // System.out.println("预期值:" + expectStr+",!⊆第"+i+"个元素{"+s+"}");
        try {
          Assert.fail("预期值:（" + expectStr + "）!⊆第" + i + "个元素{" + s + "}");
        } catch (Exception e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
          flag = false;
        }
      }
    }
  }

  public void isContains(String actualStr, String expectStr, String message) {
    if (message.isEmpty()) {
      message = "检查(实际结果,预期结果)是否包含:";
    }
    actualStr = actualStr.trim();
    expectStr = expectStr.trim();
    Boolean contains = actualStr.contains(expectStr);
    if (contains) {
      System.out.println(message + "  预期值:（" + expectStr + "） ⊆ 实际值:" + actualStr);
    } else {
      System.err.println(message + "  预期值:（" + expectStr + "） !⊆ 实际值:" + actualStr);
      try {
        Assert.fail(message + "  预期值:（" + expectStr + "） !⊆ 实际值:" + actualStr);
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        flag = false;
      }
    }
  }

  // 调用Assert.assertEquals()方法，比较两个两个字符串。
  public void assertIsEquals(String actual, String expected, String message) {
    if (message.isEmpty()) {
      message = "检查(实际结果,预期结果)是否相等:";
    }

    actual = actual.trim();
    expected = expected.trim();

    try {
      Assert.assertEquals(actual, expected);
      System.out.println(message + ": " + actual + "==" + expected);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      System.err.println(message + ": " + actual + "≠≠" + expected);
      // System.out.println(message+": "+actual+"≠≠"+expected);
      e.printStackTrace();
      flag = false;
    }
  }

  public void assertIsEquals(String actual, String expected) {
    assertIsEquals(actual, expected, "");
  }

  // 调用Assert.assertEquals()方法，比较两个集合是否相等。
  public void assertIsEquals(Collection<?> actual, Collection<?> expected, String message) {
    if (message.isEmpty()) {
      message = "检查(实际结果,预期结果)是否相等:";
    }

    try {
      Assert.assertEquals(actual, expected, message);
      System.out.println(message + ": " + actual + "==" + expected);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      System.err.println(message + ": " + actual + "≠≠" + expected);
      // System.out.println(message+": "+actual+"≠≠"+expected);
      e.printStackTrace();
      flag = false;
    }
  }

  public void assertIsEquals(Collection<?> actual, Collection<?> expected) {
    assertIsEquals(actual, expected, "");
  }

  // 判断真假
  public void assertTrue(Boolean checkResult) {
    Boolean actual = checkResult;
    Boolean expected = true;
    try {
      Assert.assertEquals(actual, expected, "检查(实际结果是否为True):");
      System.out.println("检查(实际结果是否为True),检查结果为：True");
    } catch (Exception e) {
      // TODO Auto-generated catch block
      System.err.println("！！检查(实际结果是否为True),检查结果为：False");
      // System.err.println("！！检查(实际结果,预期结果)是否相等。检查结果为：False");
      // log4j.PrintStackTraceElement();
      e.printStackTrace();
      flag = false;
    }

  }

}
