package com.example.springbootmybatis;

import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * description : TODO:类的作用
 * author : tao.liu
 * email : tao.liu@uurobot.cn
 * date : 2020/4/28 14:38
 * version : v1.0
 */
@RestController
@RequestMapping(path = "/demo")
public class UserbeanController {
    @GetMapping("/all")
    public List<User> findAllUser() {
        return MyBatisHelper.getInstance().findAllUser();
    }

    @PostMapping("/add")
    public @ResponseBody
    ResponseBean addNewUser(@RequestParam String username
            , @RequestParam String address, @RequestParam String sex) {
        User user = new User();
        user.setUsername(username);
        user.setAddress(address);
        user.setSex(sex);
        user.setBirthday(new Date());
        MyBatisHelper.getInstance().insertUser(user);
        return new ResponseBean(0, "添加成功");
    }

    /**
     * 插入一条数据 客户端传json数据
     *
     * @param user
     * @return
     */
    @PostMapping(path = "/insert")
    ResponseBean insertUser(@RequestBody User user) {
        MyBatisHelper.getInstance().insertUser(user);
        return new ResponseBean(0, "ok");
    }

    @PostMapping("/delete")
    public @ResponseBody
    ResponseBean deleteUser(@RequestParam int id) {
        MyBatisHelper.getInstance().deleteUser(id);
        return new ResponseBean(0, "删除成功");
    }

    /**
     * 通过请求路径获取参数
     * @param id
     * @param name
     * @return
     */
    @RequestMapping(path = "/find/{id}")
    User findUserById(@PathVariable int id, @RequestParam String name) {
        System.out.println("id->"+id+" name->"+name);
        return MyBatisHelper.getInstance().findUserById(id);
    }
}
