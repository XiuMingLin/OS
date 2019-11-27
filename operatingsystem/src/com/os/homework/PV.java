/**
 * PV操作类
 * @Author vs
 * @Description //TODO
 * @Date 2019年11月24日17点42分
 * @Param
 * @return
 **/

package com.os.homework;

import java.util.Queue;

public class PV {
    boolean ifoccupy = false;


    public void P()
    {
        ifoccupy = true;
    }

    public void V()
    {
        ifoccupy = false;
    }
}
