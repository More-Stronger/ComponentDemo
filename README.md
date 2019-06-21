# ComponentDemo
一个组件化项目Demo.

## 依赖关系 UML 图.
 ![depend_uml.bmp](https://github.com/More-Stronger/ComponentDemo/blob/master/depend_uml.bmp)

## 实现组件化基本步骤.

#### 步骤1.在项目 gradle.properties 文件中添加变量.
   
   *. 项目版本变量.
   *. 各组件是否可以独立运行的变量.
   *. 第三方库版本变量等.

#### 步骤2.通过 gradle.properties 文件中的变量配置各组件 Application 和Library 自动切换.

   *. apply plugin: 'com.android.application' 和 apply plugin: 'com.android.library' 切换.
   *. applicationId 切换.
   *. AndroidManifest.xml 切换.
   *. 壳 APP 组件依赖切换.

#### 步骤3.全局 Context(ApplicationContext).

   *. 在中间件模块中,创建通用的 Application ,各组件的 Application 继承.

#### 步骤4.在中间件中定义接口,各组件去具体实现.

#### 步骤5.在中间件中提供单例对象,用于设置和获取组件接口对象.

## 注意

   *. 资源命名,建议命名前添加组件名为前缀,区分资源.
   *. 壳 APP 中禁止直接实例化组件内的对象,减少耦合,避免组件内对象删除后,影响到壳 APP 的运行.
