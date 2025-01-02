# Nuxt Minimal Starter

Look at the [Nuxt documentation](https://nuxt.com/docs/getting-started/introduction) to learn more.

## Setup

Make sure to install dependencies:

```bash
# npm
npm install

# pnpm
pnpm install

# yarn
yarn install

# bun
bun install
```

## Development Server

Start the development server on `http://localhost:3000`:

```bash
# npm
npm run dev

# pnpm
pnpm dev

# yarn
yarn dev

# bun
bun run dev
```

## Production

Build the application for production:

```bash
# npm
npm run build

# pnpm
pnpm build

# yarn
yarn build

# bun
bun run build
```

Locally preview production build:

```bash
# npm
npm run preview

# pnpm
pnpm preview

# yarn
yarn preview

# bun
bun run preview
```

Check out the [deployment documentation](https://nuxt.com/docs/getting-started/deployment) for more information.

## 全局样式 scss 在 nuxt 项目内如何导入？

- https://juejin.cn/post/7443087944720384050#heading-4

## 接近烂尾

这个将商城项目改造成期望的 nuxt 项目，太坐牢了。

### bug1

在根目录运行 vitest 时，无法启动。

```bash
Did you mean to import "@babel/plugin-transform-typescript/lib/index.js"?
```

### bug2

每次运行开发环境时，运行速度非常的慢，要加载非常多的文件。开发环境非常缓慢。
