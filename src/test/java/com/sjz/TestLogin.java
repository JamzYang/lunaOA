package com.sjz;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author yang
 * Date 2019/12/4 22:24
 */


public class TestLogin {
    @Test
    public void testVerifyPassword(){
        String inputtedPassword = "123456";
        String storedPassword = "cdac762d0ba79875489f6a8b430fa8b5dfe0cdd81da38b80f02f33328af7fd4a";
        String salt = "YzcmCZNvbXocrsz9dm8e";
        String hashed = new Sha256Hash(inputtedPassword, salt).toHex();
        Assert.assertEquals(storedPassword,hashed);
    }
}
