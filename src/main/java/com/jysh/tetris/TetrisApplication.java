package com.jysh.tetris;

import com.jysh.tetris.controller.TetraBoardController;

/**
 *      TODO 目前，对于整体UI的设置是在controller中完成，应当在view中创建一个JFrame完全控制所有的UI绘制，而controller只负责将model和view结合
 *      TODO 同时，目前model中大多数方法都设置为public，应当对此进行控制，只需将控制方块动作、获取板上信息等方法暴露即可
 *      TODO Tetra.java中注释不符合规范，待修正
 */
public class TetrisApplication {
    public static void main(String[] args) {
        new TetraBoardController().init();
    }
}
