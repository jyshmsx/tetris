# Java俄罗斯方块
##整体结构
* model
    > Cube：存储单个方块的地址  
    > Tetra:四个方块的组合，控制方块移动  
    > Board：一个具有两个二维数组的类，存储背景板的信息。这里实现的是当一个方块不可移动之后，会将其的颜色值及地址值保存在Board中
    > TetraBoard，具有两个Tetra一个Board的类，在controller中调用这里的方法来进行移动等操作
* controller
    > TetraBoardController：将TetraBoard和TetrisJPanel相结合，并且设置键盘监听，ui更新，自动下落等

* view
    > TetrisJPanel：根据TetraBoard值绘制图形