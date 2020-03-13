package com.sjz.modules.sys.controller;

import com.sjz.common.utils.R;
import com.sjz.modules.sys.entity.SysUserEntity;
import com.sjz.modules.sys.entity.SysUserTokenEntity;
import com.sjz.modules.sys.oauth2.TokenGenerator;
import com.sjz.modules.sys.service.SysUserService;
import com.sjz.modules.sys.service.SysUserTokenService;
import io.swagger.annotations.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yang
 * Date 2019/12/4 20:11
 */

@RestController
public class SysLoginController {
    @Autowired
    private SysUserService userService;
    @Autowired
    private SysUserTokenService tokenService;

    @ApiOperation("登录")
//    @ApiImplicitParam(name = "params" , paramType = "body",examples = @Example({
//            @ExampleProperty(value = "{'user':'id'}", mediaType = "application/json")
//    }))
    @ApiImplicitParams({
            @ApiImplicitParam(name="username",required=true,paramType="query", defaultValue = "admin"),
            @ApiImplicitParam(name="password",required=true,paramType="query", defaultValue = "12345")
    })
    @PostMapping(value = "/login")
    public String login(@RequestParam String username,@RequestParam String password){
        if(username == null || password == null){
//            return R.error("用户名或密码不能为空");
        }
        SysUserEntity userEntity = userService.queryByUserName(username);
        if(userEntity == null || !verifyPassword(password,userEntity)){
//            return R.error("用户名或密码错误");
        }

        R r = tokenService.createToken(userEntity.getUserId());
        String token = (String)r.get("token");
        return "{\n" +
                "  \"code\": 0,\n" +
                "  \"Admin-Token\": \""+token+"\",\n" +
                "  \"user\": {\n" +
                "    \"deptName\": \"办公室\",\n" +
                "    \"img\": \"\",\n" +
                "    \"dingtalkId\": null,\n" +
                "    \"createTime\": \"2019-02-13 15:43:26\",\n" +
                "    \"lastLoginTime\": \"2019-12-05 22:03:23\",\n" +
                "    \"num\": \"390823685766627\",\n" +
                "    \"sex\": null,\n" +
                "    \"mobile\": \"12312341234\",\n" +
                "    \"realname\": \"admin\",\n" +
                "    \"parentName\": null,\n" +
                "    \"post\": \"1\",\n" +
                "    \"userId\": 3,\n" +
                "    \"parentId\": 0,\n" +
                "    \"lastLoginIp\": \"127.0.0.1\",\n" +
                "    \"deptId\": 1,\n" +
                "    \"email\": null,\n" +
                "    \"username\": \"admin\",\n" +
                "    \"status\": 1\n" +
                "  },\n" +
                "  \"auth\": {\n" +
                "    \"oa\": {\n" +
                "      \"book\": {\n" +
                "        \"read\": true\n" +
                "      },\n" +
                "      \"announcement\": {\n" +
                "        \"save\": true,\n" +
                "        \"update\": true,\n" +
                "        \"delete\": true\n" +
                "      }\n" +
                "    },\n" +
                "    \"work\": {\n" +
                "      \"task\": {\n" +
                "        \"save\": true\n" +
                "      },\n" +
                "      \"work\": {\n" +
                "        \"update\": true\n" +
                "      },\n" +
                "      \"taskClass\": {\n" +
                "        \"save\": true,\n" +
                "        \"update\": true,\n" +
                "        \"delete\": true\n" +
                "      }\n" +
                "    },\n" +
                "    \"bi\": {\n" +
                "      \"product\": {\n" +
                "        \"read\": true\n" +
                "      },\n" +
                "      \"oa\": {\n" +
                "        \"read\": true\n" +
                "      },\n" +
                "      \"business\": {\n" +
                "        \"read\": true\n" +
                "      },\n" +
                "      \"achievement\": {\n" +
                "        \"read\": true\n" +
                "      },\n" +
                "      \"contract\": {\n" +
                "        \"read\": true\n" +
                "      },\n" +
                "      \"ranking\": {\n" +
                "        \"read\": true\n" +
                "      },\n" +
                "      \"portrait\": {\n" +
                "        \"read\": true\n" +
                "      },\n" +
                "      \"customer\": {\n" +
                "        \"read\": true\n" +
                "      }\n" +
                "    },\n" +
                "    \"project\": {\n" +
                "      \"projectManage\": {\n" +
                "        \"save\": true\n" +
                "      }\n" +
                "    },\n" +
                "    \"crm\": {\n" +
                "      \"product\": {\n" +
                "        \"read\": true,\n" +
                "        \"excelexport\": true,\n" +
                "        \"save\": true,\n" +
                "        \"update\": true,\n" +
                "        \"index\": true,\n" +
                "        \"excelimport\": true,\n" +
                "        \"status\": true\n" +
                "      },\n" +
                "      \"business\": {\n" +
                "        \"read\": true,\n" +
                "        \"transfer\": true,\n" +
                "        \"teamsave\": true,\n" +
                "        \"save\": true,\n" +
                "        \"update\": true,\n" +
                "        \"index\": true,\n" +
                "        \"delete\": true\n" +
                "      },\n" +
                "      \"leads\": {\n" +
                "        \"transform\": true,\n" +
                "        \"read\": true,\n" +
                "        \"transfer\": true,\n" +
                "        \"excelexport\": true,\n" +
                "        \"save\": true,\n" +
                "        \"update\": true,\n" +
                "        \"index\": true,\n" +
                "        \"excelimport\": true,\n" +
                "        \"delete\": true\n" +
                "      },\n" +
                "      \"contract\": {\n" +
                "        \"read\": true,\n" +
                "        \"transfer\": true,\n" +
                "        \"teamsave\": true,\n" +
                "        \"save\": true,\n" +
                "        \"update\": true,\n" +
                "        \"index\": true,\n" +
                "        \"delete\": true\n" +
                "      },\n" +
                "      \"pool\": {\n" +
                "        \"receive\": true,\n" +
                "        \"excelexport\": true,\n" +
                "        \"index\": true,\n" +
                "        \"distribute\": true\n" +
                "      },\n" +
                "      \"receivables\": {\n" +
                "        \"read\": true,\n" +
                "        \"save\": true,\n" +
                "        \"update\": true,\n" +
                "        \"index\": true,\n" +
                "        \"delete\": true\n" +
                "      },\n" +
                "      \"contacts\": {\n" +
                "        \"read\": true,\n" +
                "        \"transfer\": true,\n" +
                "        \"excelexport\": true,\n" +
                "        \"save\": true,\n" +
                "        \"update\": true,\n" +
                "        \"index\": true,\n" +
                "        \"excelimport\": true,\n" +
                "        \"delete\": true\n" +
                "      },\n" +
                "      \"customer\": {\n" +
                "        \"read\": true,\n" +
                "        \"transfer\": true,\n" +
                "        \"teamsave\": true,\n" +
                "        \"excelexport\": true,\n" +
                "        \"save\": true,\n" +
                "        \"update\": true,\n" +
                "        \"index\": true,\n" +
                "        \"lock\": true,\n" +
                "        \"excelimport\": true,\n" +
                "        \"dealStatus\": true,\n" +
                "        \"putinpool\": true,\n" +
                "        \"delete\": true\n" +
                "      }\n" +
                "    },\n" +
                "    \"manage\": {\n" +
                "      \"oa\": {\n" +
                "        \"examine\": true\n" +
                "      },\n" +
                "      \"system\": {\n" +
                "        \"read\": true,\n" +
                "        \"update\": true\n" +
                "      },\n" +
                "      \"examineFlow\": {\n" +
                "        \"update\": true\n" +
                "      },\n" +
                "      \"work\": {\n" +
                "        \"update\": true\n" +
                "      },\n" +
                "      \"permission\": {\n" +
                "        \"update\": true\n" +
                "      },\n" +
                "      \"configSet\": {\n" +
                "        \"read\": true,\n" +
                "        \"update\": true\n" +
                "      },\n" +
                "      \"users\": {\n" +
                "        \"deptSave\": true,\n" +
                "        \"deptDelete\": true,\n" +
                "        \"read\": true,\n" +
                "        \"userEnables\": true,\n" +
                "        \"userUpdate\": true,\n" +
                "        \"userSave\": true,\n" +
                "        \"deptUpdate\": true\n" +
                "      },\n" +
                "      \"crm\": {\n" +
                "        \"field\": true,\n" +
                "        \"achievement\": true,\n" +
                "        \"pool\": true,\n" +
                "        \"setting\": true\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}\n";
    }

    @PostMapping(value = "/logout")
    public R logout(HttpServletRequest request){
        String token = request.getHeader("Admin-Token");
        //tokenService.logout(token);

        return R.ok();
    }
    private boolean verifyPassword(String inputtedPassword, SysUserEntity userEntity) {
        return userEntity.getPassword().equals(new Sha256Hash(inputtedPassword,userEntity.getSalt()).toHex());
    }

}
