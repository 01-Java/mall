import axios from 'axios';

export const requestForUseAxios = axios.create({
  baseURL: '/api',
  timeout: 5000,
});

// 请求拦截器
requestForUseAxios.interceptors.request.use(
  (config) => {
    return config;
  },
  (error) => {
    return Promise.reject(error);
  },
);

// 响应拦截器
requestForUseAxios.interceptors.response.use(
  (response) => {
    return response.data;
  },
  (error) => {
    return Promise.reject(error);
  },
); 