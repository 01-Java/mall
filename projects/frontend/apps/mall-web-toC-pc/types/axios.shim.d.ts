import type { AxiosResponse } from "axios";

declare module "axios" {
	// export interface AxiosResponse<T = any, K extends keyof T> {
	// 	[key: K]: T[K];
	// 	// data: T;
	// 	// status: number;
	// 	// statusText: string;
	// 	// headers: AxiosResponseHeaders;
	// 	// config: AxiosRequestConfig<D>;
	// 	// request?: any;
	// }
	export type AxiosResponse<T> = T;
}
