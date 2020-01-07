package cn.demo.bean;


import lombok.Data;
import lombok.ToString;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;



@Data
@ToString
public class User implements Serializable {
  private Integer id;
  private Integer age;
  public String username;
  private String password;
  private String email;
  private String sex;

}
