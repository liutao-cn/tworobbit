package cn.t18.est;

import cn.t18.est.mapper.UsersMapper;
import cn.t18.est.pojo.Users;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
@MapperScan(value = {"cn.t18.est.mapper"})
@SpringBootApplication
public class TworobbitApplication {

    public static void main(String[] args) {
        SpringApplication.run(TworobbitApplication.class, args);
       /* ConfigurableApplicationContext run = SpringApplication.run(TworobbitApplication.class, args);
        UsersMapper bean = run.getBean(UsersMapper.class);
        Users users = bean.selectByPrimaryKey(4l);
        System.out.println("用户信息为"+users);*/
    }

}
