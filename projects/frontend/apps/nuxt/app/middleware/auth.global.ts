import { useUserStore } from '~/composables/states/use-user';

export default defineNuxtRouteMiddleware((to) => {
  // 获取用户信息
  const userStore = useUserStore();
  const token = userStore.profile.token;
  
  // 需要登录才能访问的页面路径列表
  const authPages = [
    '/member',
    '/member/order',
    '/checkout',
    '/pay'
  ];
  
  // 当前访问的是需要登录的页面，但没有登录
  if (authPages.some(page => to.path.startsWith(page)) && !token) {
    // 跳转到登录页
    return navigateTo('/login', { 
      replace: true,
      query: { 
        redirectUrl: to.fullPath 
      } 
    });
  }
}); 