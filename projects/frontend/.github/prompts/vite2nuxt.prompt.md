# nuxt 项目改造

你好，在该对话中，我们将共同完成 vite 项目改造。我们最终的目的是为了把一个 vite 项目改造成 nuxt 项目。

## 参考项目

你的参考项目如下： https://github.com/antfu/vitesse-nuxt

## 被更改的项目

将本项目改造成 nuxt 项目，在本工作区内，相对路径地址如下：

frontend\apps\mall-web-toC-pc

该项目接下来将会被称呼为 mall ，即商城项目。

## 已有的项目基架

其相对路径为：

frontend\apps\nuxt

该项目接下来称呼为 nuxt 项目。

## 工作方式

我会引用 mall 项目的内容，然后由你做出修改。修改后的文件按照 nuxt 架构移动到 nuxt 项目内。

## 注意事项

- 不要修改 mall 项目的源代码，mall 项目仍旧保持 vite 项目架构。

## 参考信息

为了协助你完成 vite 项目转换成 nuxt 项目，我会提供给你一些关键内容，以便帮助你了解项目架构。

### mall 项目

- package.json

- main.ts

- vite.config.ts

- 路由配置文件
  src\router\index.ts

- 布局用的组件
  src\components\layout

### nuxt 项目

- nuxt.config.ts
