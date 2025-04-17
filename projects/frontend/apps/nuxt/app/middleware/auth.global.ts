import { useUserStore } from '@/composables/states/use-user';

export default defineNuxtRouteMiddleware((to) => {
  // 在服务器端不执行此中间件逻辑
  if (process.server) return;
  
  // 只处理/member开头的路径
  if (to.path.startsWith('/member')) {
    // 获取用户信息
    const userStore = useUserStore();
    
    // 如果用户未登录且想要访问会员中心，则重定向到登录页
    if (!userStore.profile.token) {
      return navigateTo('/login?redirectUrl=' + encodeURIComponent(to.fullPath));
    }
  }
}); 