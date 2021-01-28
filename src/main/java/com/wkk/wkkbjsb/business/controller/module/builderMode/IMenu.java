package com.wkk.wkkbjsb.business.controller.module.builderMode;

/**
 * @author : ligengying
 * @Package : com.wkk.wkkbjsb.business.controller.module.builderMode
 * @Description : TODO
 * @Create on : 2021/1/6 14:01
 * @email : lgy961228@gamil.com
 **/
public interface IMenu {

    IMenu appendCeiling(Matter matter); // 吊顶
    IMenu appendCoat(Matter matter); // 涂料
    IMenu appendFloor(Matter matter); // 地板
    IMenu appendTile(Matter matter); // 地砖
    String getDetail(); // 明细
}
