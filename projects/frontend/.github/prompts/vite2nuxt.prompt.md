# nuxt 项目改造

你好，在该对话中，我们将共同完成 vite 项目改造。我们最终的目的是为了把一个 vite 项目改造成 nuxt 项目。

## 参考项目

你的参考项目如下： https://github.com/antfu/vitesse-nuxt

## 被更改的项目

将本项目改造成 nuxt 项目，在本工作区内，相对路径地址如下：

<!-- frontend\apps\mall-web-toC-pc -->

mall

该项目接下来将会被称呼为 mall ，即商城项目。

## 已有的项目基架

其相对路径为：

<!-- frontend\apps\nuxt -->

nuxt

该项目接下来称呼为 nuxt 项目。

## 工作方式

我会引用 mall 项目的内容，然后由你做出修改。修改后的文件按照 nuxt 架构移动到 nuxt 项目内。

## 注意事项

### 注意修改目标

不要修改 mall 项目的源代码，mall 项目仍旧保持 vite 项目架构。

只修改 nuxt 项目的源代码。

### nuxt 项目本身就是来自模板的

nuxt 项目现在是时来自以下仓库的。本身就是已经可以使用的模板。

- https://github.com/antfu/vitesse-nuxt

### 每次修改确保可用

每次修改都要确保项目是可以用的。你的每次修改都要保证当前的 nuxt 项目是可以运行的，可以打包的。不要生成不可用的代码，以至于项目无法本地运行。

### 每次只在一个范围内做出迁移和修改

在 vite 项目迁移至 nuxt 项目时，会有很多迁移项，例如：

自动导入
修正类型错误
生成 layout 布局
……

请确保你每次只做一件事，不要多个内容一起做。

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

## 边缘性质的改造

以下改造项收益率较低，改造可有可无。在大多数的改造项完成后，再考虑完成以下项目的改造。

### NuxtImg

使用 Nuxt 的图片组件 NuxtImg。将项目内 img 标签，换成 NuxtImg 组件。
