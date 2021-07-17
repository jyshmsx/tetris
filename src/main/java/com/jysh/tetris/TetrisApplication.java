package com.jysh.tetris;

import com.jysh.tetris.controller.TetraBoardController;

/**
 * 整体思想
 *      在model中，将俄罗斯方块分为版、方块两个部分，使用一个TetraBoard结合这两者，并且在TetraBoard进行所有的控制
 *      在controller中，将tetraBoard和视图相结合，并且设置键盘监听，ui更新，自动下落等
 *      在view中，TetrisJPanel根据controller中设置的TetraBoard值绘制图形
 *
 *      TODO 目前，对于整体UI的设置是在controller中完成，应当在view中创建一个JFrame完全控制所有的UI绘制，而controller只负责将model和view结合
 *      TODO 同时，目前model中大多数方法都设置为public，应当对此进行控制，只需将控制方块动作、获取板上信息等方法暴露即可
 */
public class TetrisApplication {
    public static void main(String[] args) {
        new TetraBoardController().init();
    }
}
