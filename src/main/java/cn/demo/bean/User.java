package cn.demo.bean;


import cn.demo.config.DateUtils;
import lombok.Data;
import lombok.ToString;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


@Data
@ToString
public class User implements Serializable {
  private Integer id;
  private Integer age;
  public String username;
  private String password;
  private String email;
  private String sex;
  // @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") 无效
  private Date brithday;

  // 数据库中1|0
  private Integer statu;
  // 数据库中不存在的数据, 根据statu的数字判断
  private String statuStr;

  /**
   * 时间格式化
   * @return
   */
  public String getBrithday() {
    if (brithday!=null){
      String brithdayStr = DateUtils.data2String(brithday, "yyyy-MM-dd HH:mm");
      return brithdayStr;
    }
   return null;
  }
  public void setBrithday(Date brithday) {
    this.brithday = brithday;
  }

  public String getStatuStr() {
    if (statu==1){
      statuStr = "活跃";
    }
    if (statu==0){
      statuStr="沉寂";
    }
    return statuStr;
  }

  public void setStatuStr(String statuStr) {
    this.statuStr = statuStr;
  }
}
