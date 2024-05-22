# Painting(画图软件)

## 快速启动

- 使用IntelliJ IDEA clone本项目到本地，启动即可

## 一、需求

- 利用面向对象的思想，设计并实现一个画图软件。实现基本的图形绘制功能、文本绘制功能、橡皮檫功能、撤销功能以及图片的存取功能，画图软件具有美观的用户界面。
  使用户可以绘制直线、曲线、矩形、圆、三角形、五边形、六边形和椭圆等基本图形，可以设置画笔颜色，以及绘制填充图形，文件读取最终实现jpg、bmp、png
  和gif格式的存取。



## 二、总体设计

- 通过分析，画图软件主界面主要分为菜单栏、工具栏、调色板、画板和状态栏五个部分，将主界面设计为一个MyFrame类，将主界面上的菜单栏、工具栏、调色板等均分装成
  一个类，完成各自的功能。将菜单栏分装成MyMenu类，主要实现图片的打开、保存和新建功能，画笔颜色粗细设置功能，以及软件的使用说明；将工具栏封装成MyToolbar
  类，主要实现图形绘制按钮，文本绘制、文本字体大小和字体风格的设置，同时添加保存文件、清空画板和撤销功能的快捷按钮；将调色板封装成ColorPanel类，主要用来
  设置画笔的颜色，可以使用设计好的16种颜色，也可以通过JColorChooser（颜色选择器）选择更多的颜色；将画板封装成DrawPanel类，主要实现图形以及文本的绘制；
  状态栏作为MyFrame类的成员变量，用于显示鼠标当前的位置。
- 对于图形绘制，设计一个抽象Shape类，包含图形绘制的基本属性值和一个抽象draw(Graphics2D g)方法；其他图形类对象均继承Shape类，并实现抽象方法。
  程序一共设计com.edu.nwafu.abstractShape、com.edu.nwafu.start和com.edu.nwafu.tool三个包，分别存放图形类对象、主界面和调色板。

定义一个Text类，继承Shape类，用于文字输入



## 三、执行流程

1. **初始化界面**：

    - 创建`MyFrame`类的实例，设置窗口标题、大小、位置等属性。
    - 初始化菜单栏`MyMenu`和工具栏`MyToolbar`。
    - 创建画图区域`DrawPanel`，添加到中心位置，并设置光标类型、背景颜色等。

2. **菜单和工具栏设置**：

    - 在`MyMenu`类中设置文件、设置、帮助菜单，以及对应的菜单项（新建、打开、保存、退出等）。
    - 在`MyToolbar`类中设置工具栏按钮，包括保存、清空、撤销、铅笔、直线、矩形、椭圆等绘图工具。

3. **画图区域**：
    - `DrawPanel`类是实际进行绘图的面板，它重写了`paintComponent`方法来绘制所有图形。
    - 通过`MouseAction`和`MouseMotion`内部类响应鼠标事件，如按下、释放、拖动等。

4. **图形对象管理**：
    - 使用`AbstractShape`抽象类及其子类（如`Pencil`、`Line`、`Rectangle`等）来表示不同的图形。
    - 图形对象存储在`itemList`数组中，每个图形对象包含绘制所需的属性，如颜色、宽度、坐标等。

5. **绘图流程**：
    - 用户通过选择工具栏上的按钮来选择绘图工具。
    - 用户在画图区域进行操作（如点击、拖动鼠标）时，`MouseAction`和`MouseMotion`类响应这些事件。
    - 根据用户的操作，创建相应的图形对象，并将其添加到`itemList`数组中。
    - `DrawPanel`的`paintComponent`方法会被调用，绘制`itemList`中的所有图形对象。

6. **撤销操作**：
    - 通过`DrawPanel`的`undo`方法实现撤销功能，它通过减少`index`来撤销最近的操作，并把被撤销的内容存放至`undoStack(撤销栈)`中。

7. **重做（恢复被撤销的内容）操作:**
    - 通过`DrawPanel`的`redo`方法实现重做功能，它通过从`undoStack(撤销栈)`中获取被撤销的内容来恢复最近的操作。

8. **保存和打开文件**：
    - 用户可以通过菜单栏的文件选项来保存或打开图形文件。
    - 保存时，会将画板内容绘制到`BufferedImage`对象中，然后使用`ImageIO.write`方法保存为图片文件。
    - 打开文件时，会读取图片文件，并将其显示在画图区域。

9. **退出程序**：
    - 用户可以选择退出程序，如果文件未保存，会弹出提示框询问用户是否确定退出。

整个程序的流程是基于事件驱动的，用户的每个操作都会触发相应的事件处理，从而实现绘图、撤销、保存等功能。



## 四、添加的功能：

- 输入RGB值来改变颜色
- 取色工具
- 重做(撤销撤销)



## 五、快捷键

- 打开文件：`ctrl+O`
- 保存文件：`ctrl+S`
- 退出程序：`ctrl+X`
- 撤销：`ctrl+Z`
- 重做：`ctrl+Y`



## 六、声明

基于[HansGerry/Painting](https://gitcode.com/HansGerry/Painting/overview)实现,去除并且添加了某些功能



